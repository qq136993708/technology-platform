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
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYZH100006;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.hana.report.ProjectForMysql;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class HomeDeviceMsqlController extends BaseController{

	private static final String	getDeviceByCountBar			= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/project-type";
	private static final String	getDeviceByCountPie			= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/project-type";
	private static final String	getDeviceByCountCricle		= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/type/tree";
	private static final String	getDeviceByUnitBar			= "http://pcitc-zuul/system-proxy/out-project-provider/type/zb/unit/list";
	private static final String	getDeviceByUnitPie			= "http://pcitc-zuul/hana-proxy/hana/home/getDeviceByUnitPie";
	private static final String	getDeviceByUnitCricle		= "http://pcitc-zuul/system-proxy/out-project-provider/project-count/zb/unit/tree";
	private static final String	getDeviceByDistributeBar	= "http://pcitc-zuul/system-proxy/out-project-provider/project-info/zb/unit";


	/**
	 * ======================专业处-科研装备============================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/zyc/equipment")
	public String kyzb_level2(HttpServletRequest request) throws Exception {

		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);
		String month = HanaUtil.getCurrentYear_Moth();
		request.setAttribute("month", year + "-" + month.substring(5));

		return "stp/hana/home/level/zyc_equipment";
	}

	/** =====================================按数量============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/getDeviceByCountBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getDeviceByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByCountBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getProjectByCountBar jSONArray-> "+jSONArray.toString());

				List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "zylb");
				barLine.setxAxisDataList(xAxisDataList);

				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("新开课题");
				legendDataList.add("结转课题");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getDeviceForMysqlChartBarLineSeries(list, "xksl");
				ChartBarLineSeries s2 = HanaUtil.getDeviceForMysqlChartBarLineSeries(list, "xjsl");

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
		System.out.println(">>>>>>>>>>>>>>getDeviceByCountBar "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/getDeviceByCountPie")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getDeviceByCountPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByCountPie, HttpMethod.POST, entity, JSONArray.class);
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
					String name = f2.getZylb();
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
		System.out.println(">>>>>>>>>>>>>>>getDeviceByCountPie "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/getDeviceByCountCricle")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getDeviceByCountCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByCountCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode==200) {
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>>getDeviceByCountCricle jSONArray"+jSONArray.toString());
			List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "project_scope");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleuNITForproject02type(lista, list);
			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);

		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getDeviceByCountCricle "+resultObj.toString());
		return resultObj.toString();
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value =
	 * "/getDeviceByCountCricle")
	 * 
	 * @ResponseBody public String getDeviceByCountCricle(HttpServletRequest
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
	 * responseEntity = restTemplate.exchange(getDeviceByCountCricle,
	 * HttpMethod.POST, entity, JSONArray.class); int statusCode =
	 * responseEntity.getStatusCodeValue(); if (statusCode == 200) { JSONArray
	 * jSONArray = responseEntity.getBody(); List<H1AMKYSY100109> list =
	 * JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
	 * List<String> lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
	 * List<TreeNode2> chartCircleList=
	 * HanaUtil.getChildChartCircleForproject(lista,list);
	 * result.setSuccess(true); result.setData(chartCircleList); }
	 * 
	 * } else { result.setSuccess(false); result.setMessage("参数为空"); }
	 * JSONObject resultObj =
	 * JSONObject.parseObject(JSONObject.toJSONString(result));
	 * System.out.println(">>>>>>>>>>>>>>>getDeviceByCountCricle " +
	 * resultObj.toString()); return resultObj.toString(); }
	 */

	/** =====================================按单位============================== */
	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/getDeviceByUnitBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getDeviceByUnitBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByUnitBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getDeviceByUnitBar jSONArray-> "+jSONArray.toString());

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
				ChartBarLineSeries s1 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xksl");
				ChartBarLineSeries s2 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xjsl");

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
		System.out.println(">>>>>>>>>>>>>>getDeviceByUnitBar "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/getDeviceByUnitPie")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getDeviceByUnitPie(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByUnitPie, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getDeviceByUnitPie jSONArray-> "+jSONArray.toString());
				List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i<list.size(); i++) {
					H1AMKYSY100109 f2 = list.get(i);
					String name = f2.getG0GSSP();
					String value = f2.getK0XMZXSL();
					legendDataList.add(name);

					if (value!=null&&!value.equals("")) {
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
		System.out.println(">>>>>>>>>>>>>>>getDeviceByUnitPie "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/getDeviceByUnitCricle")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getDeviceByUnitCricle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByUnitCricle, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode==200) {
			JSONArray jSONArray = responseEntity.getBody();

			System.out.println(">>>>>>>>>>>>>>>getDeviceByUnitCricle jSONArray "+jSONArray.toString());

			List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "project_scope");
			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleuNITForDevice(lista, list);

			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);

		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getDeviceByUnitCricle "+resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_device_02/getDeviceByDistributeBar")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getDeviceByDistributeBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getDeviceByDistributeBar, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode==200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getDeviceByDistributeBar jSONArray-> "+jSONArray.toString());

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
				ChartBarLineSeries s1 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xksl");
				ChartBarLineSeries s2 = HanaUtil.getdevceForMysqlChartBarLineSeries(list, "xjsl");
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
		System.out.println(">>>>>>>>>>>>>>getDeviceByDistributeBar "+resultObj.toString());
		return resultObj.toString();
	}

}
