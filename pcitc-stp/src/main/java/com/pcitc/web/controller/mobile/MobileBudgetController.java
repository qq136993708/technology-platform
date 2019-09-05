package com.pcitc.web.controller.mobile;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobileBudgetController extends BaseController {

	// 科研投入
	private static final String investment_01 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/money/complete-rate/company-type";
	private static final String investment_02 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/money/complete-rate/institute";
	private static final String investment_03 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/plan-money/department";
	private static final String getBudgetInfo = "http://pcitc-zuul/system-proxy/out-project-provider/budget/all-level";

	// 首页预算数据
	@RequestMapping(method = RequestMethod.GET, value = "/mobile/index_budget")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String index_budget(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("companyCode", companyCode);
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		// 领导标识
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());
		paramsMap.put("username", sysUserInfo.getUserName());
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				//System.out.println(">>>>>>>>>>>>>>index_budget jSONArray-> " + jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				result.setData(list);
				result.setSuccess(true);
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		//System.out.println(">>>>>>>>>>>>>>index_budget " + resultObj.toString());
		return resultObj.toString();
	}

	// 原one_level_main/investment_02
	/*
	 * @RequestMapping(method = RequestMethod.GET, value =
	 * "/mobile/investment_02")
	 * 
	 * @ResponseBody
	 * 
	 * @OperationFilter(dataFlag = "true") public String
	 * investment_mobile(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { Result result = new Result(); String nd =
	 * CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new
	 * Date(), DateUtil.FMT_YYYY)); String type =
	 * CommonUtil.getParameter(request, "type", ""); Map<String, Object>
	 * paramsMap = new HashMap<String, Object>(); paramsMap.put("nd", nd); //
	 * 数据控制属性 String zycbm = request.getAttribute("zycbm") == null ? "" :
	 * request.getAttribute("zycbm").toString(); String zylbbm =
	 * request.getAttribute("zylbbm") == null ? "" :
	 * request.getAttribute("zylbbm").toString(); String zsyjy =
	 * request.getAttribute("zsyjy") == null ? "" :
	 * request.getAttribute("zsyjy").toString(); paramsMap.put("zycbm", zycbm);
	 * paramsMap.put("zylbbm", zylbbm); paramsMap.put("zsyjy", zsyjy);
	 * 
	 * // 领导标识 paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());
	 * paramsMap.put("username", sysUserInfo.getUserName()); JSONObject
	 * jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
	 * HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(),
	 * httpHeaders); if (!nd.equals("")) { ResponseEntity<JSONArray>
	 * responseEntity = restTemplate.exchange(investment_02, HttpMethod.POST,
	 * entity, JSONArray.class); int statusCode =
	 * responseEntity.getStatusCodeValue(); if (statusCode == 200) { JSONArray
	 * jSONArray = responseEntity.getBody();
	 * //System.out.println(">>>>>>>>>>>>>>imobilenvestment_02 jSONArray-> " +
	 * jSONArray.toString()); List<BudgetMysql> list =
	 * JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
	 * result.setSuccess(true); result.setData(list); } }else {
	 * result.setSuccess(false); result.setMessage("参数为空"); } JSONObject
	 * resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
	 * //System.out.println(">>>>>>>>>type=" + type + ">>>>>imobilenvestment_02 "
	 * + resultObj.toString()); return resultObj.toString(); }
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/mobile/investment_02")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String investment_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("companyCode", companyCode);
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		String zsyjy = request.getAttribute("zsyjy") == null ? "" : request.getAttribute("zsyjy").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		paramsMap.put("zsyjy", zsyjy);

		// 领导标识
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());
		paramsMap.put("username", sysUserInfo.getUserName());
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_02, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				//System.out.println(">>>>>>>>>>>>>>investment_02 jSONArray-> " + jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				result.setSuccess(true);
				result.setData(list);

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		//System.out.println(">>>>>>>>>type=" + type + ">>>>>investment_02 " + resultObj.toString());
		return resultObj.toString();
	}

	/**
	 * 获取预算总额（按照专业处进行权限获取）
	 */
	@RequestMapping(value = "/mobile/small_leader/budget/info")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public Object getBudgetInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));

		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel()); // 领导标识
		paramsMap.put("username", sysUserInfo.getUserName());
		paramsMap.put("nd", nd);

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getBudgetInfo, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			////System.out.println(">>>>>>>>>>>>>>getBudgetInfo jSONArray-> " + jSONArray.toString());
			result.setSuccess(true);
			result.setData(jSONArray);
		}

		return result;
	}

	// 原:/one_level_main/investment_03
	@RequestMapping(value = "/mobile/investment_03")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String investment_03(HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject resultObj = null;
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String xkFlag = CommonUtil.getParameter(request, "xkFlag", "");
		String xmlbbm = CommonUtil.getParameter(request, "xmlbbm", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("companyCode", companyCode);
		paramsMap.put("xkFlag", xkFlag);
		paramsMap.put("xmlbbm", xmlbbm);
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);

		// 领导标识
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());
		paramsMap.put("username", sysUserInfo.getUserName());
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_03, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				//System.out.println(">>>>>>>>>>>>>>investment_03 jSONArray-> " + jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
				result.setSuccess(true);
				result.setData(list);
				resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		//System.out.println(">>>>>>>type=" + type + ">>>>>>>investment_03 " + resultObj.toString());
		return resultObj.toString();
	}

}
