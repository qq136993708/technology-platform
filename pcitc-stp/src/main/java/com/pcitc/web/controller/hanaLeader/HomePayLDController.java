package com.pcitc.web.controller.hanaLeader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class HomePayLDController extends BaseController {

	private static final String getPayByCountBar = "http://pcitc-zuul/hana-proxy/hana/home/getPayByCountBar";
	private static final String getPayByCountPie = "http://pcitc-zuul/hana-proxy/hana/home/getPayByCountPie";
	private static final String getPayByCountCricle = "http://pcitc-zuul/hana-proxy/hana/home/getPayByCountCricle";
	private static final String getPayByUnitBar = "http://pcitc-zuul/hana-proxy/hana/home/getPayByUnitBar";
	private static final String getPayByUnitPie = "http://pcitc-zuul/hana-proxy/hana/home/getPayByUnitPie";
	private static final String getPayByUnitCricle = "http://pcitc-zuul/hana-proxy/hana/home/getPayByUnitCricle";
	private static final String getPayByDistributeBar = "http://pcitc-zuul/hana-proxy/hana/home/getPayByDistributeBar";
	private static final String getPayTable = "http://pcitc-zuul/hana-proxy/hana/home/getJFZCLevel3TAble";

	/**
	 * =====================================科研项目二级页面============================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/home_pay")
	public String kyzb_level2(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);

		request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
		return "stp/hana/home/level/direct_depart/home_pay";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/home_pay_table")
	public String kyzb_table(HttpServletRequest request) throws Exception {

		String month = HanaUtil.getCurrrentYearMoth();
		request.setAttribute("month", month);
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);

		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);

		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);
		// 项目类型:G0XMGLLX ,项目来源:G0XMGLLY,管理级别:G0XMGLJB,项目类别:G0XMLX,项目状态:G0XMZT
		List<ProjectCode> G0XMGLLX_LIST = HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLX");
		List<ProjectCode> G0XMGLLY_LIST = HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLY");
		List<ProjectCode> G0XMGLJB_LIST = HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLJB");
		List<ProjectCode> G0XMLX_LIST = HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMLXMS");
		List<ProjectCode> G0XMZT_LIST = HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMZTMS");

		request.setAttribute("G0XMGLLX_LIST", G0XMGLLX_LIST);
		request.setAttribute("G0XMGLLY_LIST", G0XMGLLY_LIST);
		request.setAttribute("G0XMGLJB_LIST", G0XMGLJB_LIST);
		request.setAttribute("G0XMLX_LIST", G0XMLX_LIST);
		request.setAttribute("G0XMZT_LIST", G0XMZT_LIST);

		return "stp/hana/home/level/direct_depart/home_pay_table";
	}

	// 三级表格
	@RequestMapping(method = RequestMethod.POST, value = "/home_pay_ld/home_pay_table_data")
	@ResponseBody
	public String home_pay_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getPayTable, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>home_pay_table_data:" + result.toString());
		return result.toString();
	}

	/** =====================================按数量============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/getPayByCountBar")
	@ResponseBody
	public String getPayByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPayByCountBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getPayByCountBar jSONArray-> " + jSONArray.toString());

				List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "g0XMDL");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("新开课题");
				legendDataList.add("结转课题");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_count_bar(list, "K0BNXKJE");
				ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_budget_count_bar(list, "K0BNXJJE");

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
		System.out.println(">>>>>>>>>>>>>>getPayByCountBar " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/getPayByCountPie")
	@ResponseBody
	public String getPayByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPayByCountPie, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getPayByCountPie jSONArray-> " + jSONArray.toString());
				List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i < list.size(); i++) {
					H1AMKYSY100109 f2 = list.get(i);
					String name = f2.getG0XMDL();
					String value = f2.getK0BNYSJHJE();
					legendDataList.add(name);
					DecimalFormat decimalFormat = new DecimalFormat(".00");
					value = decimalFormat.format(Float.valueOf(value));

					dataList.add(new ChartPieDataValue(value, name));

					/*
					 * if(value!=null && !value.equals("")) { dataList.add(new
					 * ChartPieDataValue(Double.valueOf(value).intValue(),
					 * name)); }else { dataList.add(new ChartPieDataValue(0,
					 * name)); }
					 */

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
		System.out.println(">>>>>>>>>>>>>>>getPayByCountPie " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/getPayByCountCricle")
	@ResponseBody
	public String getPayByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageResult pageResult = new PageResult();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPayByCountCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();

			System.out.println(">>>>>>>>>>>>getPayByCountCricle jSONArray>>> " + jSONArray.toString());
			List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "g0XMXZ");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleForBudgetCount(lista, list);
			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);
		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getPayByCountCricle " + resultObj.toString());
		return resultObj.toString();
	}

	/** =====================================按单位============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/getPayByUnitBar")
	@ResponseBody
	public String getPayByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPayByUnitBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getPayByUnitBar jSONArray-> " + jSONArray.toString());

				List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "g0GSSP");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("费用性");
				legendDataList.add("资本性");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_budget_unit_bar(list, "K0BNFYJE");
				ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_unit_bar(list, "K0BNZBJE");

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
		System.out.println(">>>>>>>>>>>>>>getPayByUnitBar " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/getPayByUnitPie")
	@ResponseBody
	public String getPayByUnitPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPayByUnitPie, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getPayByUnitPie jSONArray-> " + jSONArray.toString());
				List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i < list.size(); i++) {
					H1AMKYSY100109 f2 = list.get(i);
					String name = f2.getG0GSSP();
					String value = f2.getK0BNXMZXSL();
					legendDataList.add(name);

					if (value != null && !value.equals("")) {
						dataList.add(new ChartPieDataValue(Double.valueOf(value).intValue(), name));
					} else {
						dataList.add(new ChartPieDataValue(0, name));
					}

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
		System.out.println(">>>>>>>>>>>>>>>getPayByUnitPie " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/getPayByUnitCricle")
	@ResponseBody
	public String getPayByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PageResult pageResult = new PageResult();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPayByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>>getPayByUnitCricle " + jSONArray.toString());

			List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "g0XMDL");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleUnitPay(lista, list);

			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);

		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getPayByUnitCricle " + resultObj.toString());
		return resultObj.toString();
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value =
	 * "/home_pay_ld/getPayByUnitCricle")
	 * 
	 * @ResponseBody public String getPayByUnitCricle(HttpServletRequest
	 * request, HttpServletResponse response) throws Exception {
	 * 
	 * Result result = new Result(); String month =
	 * CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new
	 * Date(), DateUtil.FMT_MM)); String companyCode =
	 * CommonUtil.getParameter(request, "companyCode", ""); Map<String, Object>
	 * paramsMap = new HashMap<String, Object>(); paramsMap.put("month", month);
	 * paramsMap.put("companyCode", companyCode); JSONObject jsonObject =
	 * JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
	 * HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(),
	 * httpHeaders); if (!companyCode.equals("")) { ResponseEntity<JSONArray>
	 * responseEntity = restTemplate.exchange(getPayByUnitCricle,
	 * HttpMethod.POST, entity, JSONArray.class); int statusCode =
	 * responseEntity.getStatusCodeValue(); if (statusCode == 200) { JSONArray
	 * jSONArray = responseEntity.getBody(); List<H1AMKYSY100109> list =
	 * JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
	 * List<String> lista=HanaUtil.getduplicatexAxisByList(list,"g0XMDL");
	 * List<ChartCircle2> chartCircleList=
	 * HanaUtil.getChildChartCircleForproject02(lista,list);
	 * result.setSuccess(true); result.setData(chartCircleList); }
	 * 
	 * } else { result.setSuccess(false); result.setMessage("参数为空"); }
	 * JSONObject resultObj =
	 * JSONObject.parseObject(JSONObject.toJSONString(result));
	 * System.out.println(">>>>>>>>>>>>>>>getPayByUnitCricle " +
	 * resultObj.toString()); return resultObj.toString(); }
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/home_pay_ld/getPayByDistributeBar")
	@ResponseBody
	public String getPayByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPayByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getPayByDistributeBar jSONArray-> " + jSONArray.toString());

				List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "g0GSJC");
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
				// HanaUtil.getChartBarLineSeries_PAY02_bar(list, "K0BNYSJHJE");
				ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_PAY02_bar(list, "K0BNFYJE");
				ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_PAY02_bar(list, "K0BNZBJE");

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
		System.out.println(">>>>>>>>>>>>>>getPayByDistributeBar " + resultObj.toString());
		return resultObj.toString();
	}

}
