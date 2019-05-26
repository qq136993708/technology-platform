package com.pcitc.web.controller.hana;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class HomeBudgetMysqlController extends BaseController{

	private static final String	getBudgetByCountBar			= "http://pcitc-zuul/system-proxy/out-project-provider/project-money/project-type";
	private static final String	getBudgetByCountPie			= "http://pcitc-zuul/system-proxy/out-project-provider/project-money/project-type";
	private static final String	getBudgetByCountCricle		= "http://pcitc-zuul/system-proxy/out-project-provider/project-money/scope/type";
	private static final String	getBudgetByUnitBar			= "http://pcitc-zuul/system-proxy/out-project-provider/project-money/unit-type";
	private static final String	getBudgetByUnitCricle		= "http://pcitc-zuul/system-proxy/out-project-provider/project-money/scope/institute";
	private static final String	getBudgetByDistributeBar	= "http://pcitc-zuul/system-proxy/out-project-provider/project-money/institute";
	private static final String	getBudgetTable				= "http://pcitc-zuul/hana-proxy/hana/home/getBudgetTable";

	@Autowired
	private HttpHeaders			httpHeaders;

	@Autowired
	private RestTemplate		restTemplate;

	/**
	 * =====================================科研项目二级页面============================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/home_budget_02/home_budget")
	public String kyzb_level2(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		String nd = HanaUtil.getBeforeYear();
		request.setAttribute("nd", nd);
		return "stp/hana/home/level/home_budget_02";
	}


	/** =====================================按数量============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_budget_02/getBudgetByCountBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getBudgetByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("zycmc", zycmc);
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!month.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByCountBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getBudgetByCountBar jSONArray-> "+jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "define1");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("新开课题");
				legendDataList.add("结转课题");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_budget_count_bar_mysql(list, "xkje");
				ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_count_bar_mysql(list, "xjje");

				seriesList.add(s1);
				seriesList.add(s2);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>getBudgetByCountBar 结果"+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_budget_02/getBudgetByCountPie")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getBudgetByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("zycmc", zycmc);
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByCountPie, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getBudgetByCountPie jSONArray-> "+jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i<list.size(); i++) {
					BudgetMysql f2 = list.get(i);
					String name = f2.getDefine1();
					String value = ((BigDecimal) f2.getZje()).toString();
					legendDataList.add(name);
					DecimalFormat decimalFormat = new DecimalFormat(".00");
					value = decimalFormat.format(Float.valueOf(value));
					dataList.add(new ChartPieDataValue(value, name));

				}
				pie.setDataList(dataList);
				pie.setLegendDataList(legendDataList);
				result.setSuccess(true);
				result.setData(pie);
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>getBudgetByCountPie "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_budget_02/getBudgetByCountCricle")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getBudgetByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageResult pageResult = new PageResult();
		String nd = CommonUtil.getParameter(request, "nd", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("zycmc", zycmc);
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByCountCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode==200) {
			JSONArray jSONArray = responseEntity.getBody();

			System.out.println(">>>>>>>>>>>>getBudgetByCountCricle jSONArray>>> "+jSONArray.toString());
			List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "project_scope");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleForBudgetCountMysql(lista, list);
			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);
		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getBudgetByCountCricle "+resultObj.toString());
		return resultObj.toString();
	}

	/** =====================================按单位============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_budget_02/getBudgetByUnitBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getBudgetByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String nd = CommonUtil.getParameter(request, "nd", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("zycmc", zycmc);
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByUnitBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getBudgetByUnitBar jSONArray-> "+jSONArray.toString());

				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "type_flag");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("费用性");
				legendDataList.add("资本性");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_budget_unit_mysql_bar_02(list, "fyxje");
				ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_unit_mysql_bar_02(list, "zbxje");

				seriesList.add(s1);
				seriesList.add(s2);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>getBudgetByUnitBar "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_budget_02/getBudgetByUnitCricle")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getBudgetByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PageResult pageResult = new PageResult();
		String nd = CommonUtil.getParameter(request, "nd", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("zycmc", zycmc);
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode==200) {
			JSONArray jSONArray = responseEntity.getBody();

			System.out.println(">>>>>>>>>>>>>>>getBudgetByUnitCricle jSONArray "+jSONArray.toString());

			List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "define1");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleUnitBudgerMysql(lista, list);

			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);

		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getBudgetByUnitCricle "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_budget_02/getBudgetByDistributeBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getBudgetByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		
		String nd = CommonUtil.getParameter(request, "nd", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("zycmc", zycmc);
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
		
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getBudgetByDistributeBar jSONArray-> "+jSONArray.toString());

				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "define2");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				// legendDataList.add("总计");
				legendDataList.add("费用性");
				legendDataList.add("资本性");

				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				// ChartBarLineSeries s1 =
				// HanaUtil.getChartBarLineSeries_budget_unit_mysql_bar_03(list,
				// "zje");
				ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_unit_mysql_bar_03(list, "fyxje");
				ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_budget_unit_mysql_bar_03(list, "zbxje");

				// seriesList.add(s1);
				seriesList.add(s2);
				seriesList.add(s3);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>getBudgetByDistributeBar "+resultObj.toString());
		return resultObj.toString();
	}

}
