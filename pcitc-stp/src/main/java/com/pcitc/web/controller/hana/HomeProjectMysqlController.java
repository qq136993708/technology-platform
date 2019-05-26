package com.pcitc.web.controller.hana;

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
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.hana.report.ProjectForMysql;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class HomeProjectMysqlController extends BaseController{

	private static final String	getProjectByCountBar		= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/project-type";
	private static final String	getProjectByCountPie		= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/project-type";
	private static final String	getProjectByCountCricle		= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/type/tree";
	private static final String	getProjectByUnitCricle		= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/unit/tree";
	private static final String	getProjectByDistributeBar	= "http://pcitc-zuul/system-proxy/out-project-provider/project-info/unit";
	private static final String	getProjectByUnitBar			= "http://pcitc-zuul/system-proxy/out-project-provider/type/unit/list";

	@Autowired
	private HttpHeaders			httpHeaders;

	@Autowired
	private RestTemplate		restTemplate;

	/**
	 * =====================================科研项目二级页面============================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/home_project_02/home_project")
	public String kyzb_level2(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);
		String nd = HanaUtil.getBeforeYear();
		request.setAttribute("nd", nd);
		return "stp/hana/home/level/home_project_mysql";
	}

	/** =====================================按数量============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_project_02/getProjectByCountBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getProjectByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByCountBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getProjectByCountBar jSONArray-> "+jSONArray.toString());

				List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "zycmc");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("新开课题");
				legendDataList.add("结转课题");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getProjectCountForMysqlChartBarLineSeries(list, "xksl");
				ChartBarLineSeries s2 = HanaUtil.getProjectCountForMysqlChartBarLineSeries(list, "xjsl");

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
		System.out.println(">>>>>>>>>>>>>>getProjectByCountBar "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_project_02/getProjectByCountPie")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getProjectByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByCountPie, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getProjectByCountPie jSONArray-> "+jSONArray.toString());
				List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i<list.size(); i++) {
					ProjectForMysql f2 = list.get(i);
					String name = f2.getProject_property();
					Integer value = (Integer) f2.getZsl();

					legendDataList.add(name);

					if (value!=null) {
						dataList.add(new ChartPieDataValue(value, name));
					} else {
						dataList.add(new ChartPieDataValue(0, name));
					}

					/*
					 * legendDataList.add(name); dataList.add(new
					 * ChartPieDataValue(value, name));
					 */
					/*
					 * DecimalFormat decimalFormat=new DecimalFormat(".00");
					 * value=decimalFormat.format(Float.valueOf(value));
					 */
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
		System.out.println(">>>>>>>>>>>>>>>getProjectByCountPie "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_project_02/getProjectByCountCricle")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getProjectByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByCountCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode==200) {
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>>getProjectByCountCricle jSONArray"+jSONArray.toString());

			List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "project_scope");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleuNITForproject01type(lista, list);

			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);

		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getProjectByCountCricle "+resultObj.toString());
		return resultObj.toString();
	}

	/** =====================================按单位============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_project_02/getProjectByUnitBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getProjectByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByUnitBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getProjectByUnitBar jSONArray-> "+jSONArray.toString());

				List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "type_flag");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("新开课题");
				legendDataList.add("结转课题");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getProjectForMysqlChartBarLineSeries(list, "xksl");
				ChartBarLineSeries s2 = HanaUtil.getProjectForMysqlChartBarLineSeries(list, "xjsl");

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
		System.out.println(">>>>>>>>>>>>>>getProjectByUnitBar "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_project_02/getProjectByUnitCricle")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getProjectByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode==200) {
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>>getProjectByUnitCricle jSONArray"+jSONArray.toString());

			List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "project_scope");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleuNITForproject02(lista, list);

			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);

		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getProjectByUnitCricle "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_project_02/getProjectByDistributeBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getProjectByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getProjectByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getProjectByDistributeBar jSONArray-> "+jSONArray.toString());

				List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);

				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "define2");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("新开课题");
				legendDataList.add("结转课题");

				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据

				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getProjectForMysqlChartBarLineSeries(list, "xksl");
				ChartBarLineSeries s2 = HanaUtil.getProjectForMysqlChartBarLineSeries(list, "xjsl");
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
		System.out.println(">>>>>>>>>>>>>>getProjectByDistributeBar "+resultObj.toString());
		return resultObj.toString();
	}

}
