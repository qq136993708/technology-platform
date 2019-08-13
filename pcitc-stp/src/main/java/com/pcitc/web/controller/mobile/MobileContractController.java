package com.pcitc.web.controller.mobile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.Contract;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.controller.hanaLeader.OneLevelMainController;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobileContractController extends BaseController {

	
	
	// 合同
	private static final String contract_01 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/total";
	private static final String contract_03 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/institute";
	private static final String contract_zyc = "http://pcitc-zuul/system-proxy/out-project-plan-provider/zyc/plan/count";

	

	/**
	 * 全口径新开课题合同（任务书）签订率
	 */
	@RequestMapping(value = "/mobile/contract_01")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String mobilecontract_01(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		// 领导标识
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());

		ChartPieResultData pie = new ChartPieResultData();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>contract_01 jSONArray-> " + jSONArray.toString());
				List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
				Contract contract = list.get(0);
				Integer yqht = (Integer) contract.getYqht();
				Integer wqht = (Integer) contract.getWqht();
				Integer zsl = (Integer) contract.getZsl();
				Object o = contract.getQdl();
				String qdl = "0";
				if (o != null) {
					qdl = ((BigDecimal) contract.getQdl()).toString();
				}
				if (type.equals("1")) {

					Map map = new HashMap();
					map.put("yqht", yqht);
					map.put("zsl", zsl);
					map.put("qdl", Double.valueOf(qdl));
					result.setSuccess(true);
					result.setData(map);
				}
				if (type.equals("2")) {

					Map map2 = new HashMap();
					map2.put("name", "签订率");
					map2.put("value", Double.valueOf(qdl));
					result.setSuccess(true);
					result.setData(map2);
				}
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return resault;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/mobile/contract_03")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String mobilecontract_03(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		PageResult pageResult = new PageResult();
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		// 领导标识
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_03, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>contract_03 jSONArray-> " + jSONArray.toString());
				List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "define2");
					barLine.setxAxisDataList(xAxisDataList);
					List<String> legendDataList = new ArrayList<String>();
					legendDataList.add("已签");
					legendDataList.add("未签");
					barLine.setLegendDataList(legendDataList);
					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
					ChartBarLineSeries s1 = HanaUtil.getContractChartBarLineSeries8(list, "yqhtzj");
					seriesList.add(s1);
					ChartBarLineSeries s2 = HanaUtil.getContractChartBarLineSeries8(list, "wqhtzj");
					seriesList.add(s2);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("mobile")) {

					result.setSuccess(true);
					result.setData(list);
				}
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		if (type.equals("1")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault = resultObj.toString();
			System.out.println(">>>>>>>>>>>>>1>>contract_03 " + resultObj.toString());
		} else if (type.equals("2")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			resault = resultObj.toString();
			System.out.println(">>>>>>>>>>>>2>>>contract_03 " + resultObj.toString());
		} else if (type.equals("mobile")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault = resultObj.toString();
			System.out.println(">>>>>>>>>>>>mobile>>>contract_03 " + resultObj.toString());
		}
		return resault;
	}
	
	
	//按专业处分
	@RequestMapping(method = RequestMethod.GET, value = "/mobile/contract_zyc")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String contract_zyc(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		// 领导标识
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals(""))
		{
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_zyc, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>contract_03 jSONArray-> " + jSONArray.toString());
				List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
				result.setSuccess(true);
				result.setData(list);
			}

		} else 
		{
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		System.out.println(">>>>>>>>>>>>mobile>>>contract_03 " + resultObj.toString());
		return resault;
	}
	
	
	
	
	
	// 三级表格
		@RequestMapping(method = RequestMethod.POST, value = "/mobile/common_table_data_mobile")
		@ResponseBody
		@OperationFilter(dataFlag = "true")
		public String common_table_data_mobile( HttpServletRequest request, HttpServletResponse response) {

			LayuiTableParam param = new LayuiTableParam();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			String limit = CommonUtil.getParameter(request, "limit", "15");
			String page = CommonUtil.getParameter(request, "page", "1");
			String qdbz = CommonUtil.getParameter(request, "qdbz", "");
			String xmmc = CommonUtil.getParameter(request, "xmmc", "");
			String hth = CommonUtil.getParameter(request, "hth", "");

			// 数据控制属性
			String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
			String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
			param.getParam().put("zycbm", zycbm);
			param.getParam().put("zylbbm", zylbbm);
			// 领导标识
			param.getParam().put("leaderFlag", sysUserInfo.getUserLevel());

			param.setLimit(Integer.valueOf(limit));
			param.setPage(Integer.valueOf(page));
			param.getParam().put("nd", nd);
			param.getParam().put("qdbz", qdbz);
			param.getParam().put("hth", hth);
			param.getParam().put("xmmc", xmmc);
			System.out.println(">>>>>>>>>>>>nd:" + nd + "page=" + page);
			String result = OneLevelMainController.setCommonTable(restTemplate, httpHeaders, sysUserInfo, param, request, response);
			return result;
		}
		
	
	
}
