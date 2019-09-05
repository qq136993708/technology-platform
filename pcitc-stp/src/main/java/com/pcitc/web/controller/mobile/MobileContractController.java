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
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.AchievementsAnalysis;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.Contract;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.controller.hanaLeader.OneLevelMainController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobileContractController extends BaseController {

	// 合同
	private static final String contract_01 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/total";
	private static final String contract_03 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/institute";
	private static final String contract_zyc = "http://pcitc-zuul/system-proxy/out-project-plan-provider/zyc/plan/count";
	private static final String getInvestment02 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/month/money-hana-type";
	private static final String getInvestment = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/money-hana-type";

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
		paramsMap.put("username", sysUserInfo.getUserName());

		ChartPieResultData pie = new ChartPieResultData();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				//System.out.println(">>>>>>>>>>>>>>contract_01 jSONArray-> " + jSONArray.toString());
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
		paramsMap.put("username", sysUserInfo.getUserName());

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_03, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				//System.out.println(">>>>>>>>>>>>>>contract_03 jSONArray-> " + jSONArray.toString());
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
			//System.out.println(">>>>>>>>>>>>>1>>contract_03 " + resultObj.toString());
		} else if (type.equals("2")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			resault = resultObj.toString();
			//System.out.println(">>>>>>>>>>>>2>>>contract_03 " + resultObj.toString());
		} else if (type.equals("mobile")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault = resultObj.toString();
			//System.out.println(">>>>>>>>>>>>mobile>>>contract_03 " + resultObj.toString());
		}
		return resault;
	}

	// 按专业处分
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
		paramsMap.put("username", sysUserInfo.getUserName());

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_zyc, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				//System.out.println(">>>>>>>>>>>>>>contract_03 jSONArray-> " + jSONArray.toString());
				List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
				result.setSuccess(true);
				result.setData(list);
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		//System.out.println(">>>>>>>>>>>>mobile>>>contract_03 " + resultObj.toString());
		return resault;
	}

	// 三级表格
	@RequestMapping(method = RequestMethod.POST, value = "/mobile/common_table_data_mobile")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String common_table_data_mobile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LayuiTableParam param = new LayuiTableParam();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String limit = CommonUtil.getParameter(request, "limit", "15");
		String page = CommonUtil.getParameter(request, "page", "1");
		String qdbz = CommonUtil.getParameter(request, "qdbz", "");
		String xmmc = CommonUtil.getParameter(request, "xmmc", "");
		String hth = CommonUtil.getParameter(request, "hth", "");
		String key = CommonUtil.getParameter(request, "key", "");

		String define2 = CommonUtil.getParameter(request, "define2", "");// 研究院
		String gsbmbmFlag = CommonUtil.getParameter(request, "gsbmbmFlag", "");// 部门
		String zycbmFlag = CommonUtil.getParameter(request, "zycbmFlag", "");// 处室
		String groupFlag = CommonUtil.getParameter(request, "groupFlag", "");
		String fzdwflag = CommonUtil.getParameter(request, "fzdwflag", "");

		// 部门
		List<SysDictionary> gsbmbmList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_ZBJG", restTemplate, httpHeaders);
		if (gsbmbmList != null && gsbmbmList.size() > 0) {
			for (int i = 0; i < gsbmbmList.size(); i++) {
				SysDictionary sysDictionary = gsbmbmList.get(i);
				String name = sysDictionary.getName();
				String code = sysDictionary.getCode();
				if (gsbmbmFlag.equals(name)) {
					gsbmbmFlag = code;
				}

			}
		}
		// 科技部二级级联： 专业处->专业类别
		List<SysDictionary> zycList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_ZBJG_KJB", restTemplate, httpHeaders);
		if (zycList != null && zycList.size() > 0) {
			for (int i = 0; i < zycList.size(); i++) {
				SysDictionary sysDictionary = zycList.get(i);
				String name = sysDictionary.getName();
				String code = sysDictionary.getCode();
				if (zycbmFlag.equals(name)) {
					zycbmFlag = code;
				}

			}
		}

		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		param.getParam().put("zycbm", zycbm);
		param.getParam().put("zylbbm", zylbbm);

		param.getParam().put("define2", define2);
		param.getParam().put("gsbmbmFlag", gsbmbmFlag);
		param.getParam().put("zycbmFlag", zycbmFlag);
		param.getParam().put("groupFlag", groupFlag);
		param.getParam().put("fzdwflag", fzdwflag);

		// 领导标识
		param.getParam().put("leaderFlag", sysUserInfo.getUserLevel());
		param.getParam().put("username", sysUserInfo.getUserName());

		param.setLimit(Integer.valueOf(limit));
		param.setPage(Integer.valueOf(page));
		param.getParam().put("nd", nd);
		param.getParam().put("qdbz", qdbz);
		param.getParam().put("hth", hth);
		param.getParam().put("xmmc", xmmc);
		param.getParam().put("key", key);
		//System.out.println(">>>>>>>>>>>>nd:" + nd + "page=" + page);
		String result = OneLevelMainController.setCommonTable(restTemplate, httpHeaders, sysUserInfo, param, request, response);
		return result;
	}

	/**
	 * 直属研究院月度合同签订情况
	 */
	@RequestMapping(value = "/mobile/small_leader/investment_data_02")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String investment_data_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
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
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getInvestment02, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				//System.out.println(">>>>>>>>>>>>>>getInvestment02 jSONArray-> " + jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);

				if (type.equals("1")) {
					ChartSingleLineResultData barLine = new ChartSingleLineResultData();
					List<String> xAxisList = HanaUtil.getduplicatexAxisByList(list, "yearMonth");
					List<String> xAxisDataList = new ArrayList<String>();
					for (int i = 0; i < xAxisList.size(); i++) {
						String month = xAxisList.get(i);
						month = month.replace(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY), "");
						month = month.replaceAll("^(0+)", "");
						month = month + "月";
						xAxisDataList.add(month);
					}
					barLine.setxAxisDataList(xAxisDataList);
					// X轴数据
					List<Object> seriesDataList = new ArrayList<Object>();
					for (BudgetMysql dt : list) {

						Object hanaMoney = dt.getHanaMoney();
						String str = "0";
						if (hanaMoney != null) {
							str = HanaUtil.DecimalFormatObject(hanaMoney);
							str = HanaUtil.chufa(Float.valueOf(str), 10000);
						}
						seriesDataList.add(str);
					}

					barLine.setSeriesDataList(seriesDataList);
					barLine.setxAxisDataList(xAxisDataList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("2")) {
					ChartSingleLineResultData barLine = new ChartSingleLineResultData();
					List<String> xAxisList = HanaUtil.getduplicatexAxisByList(list, "yearMonth");
					List<String> xAxisDataList = new ArrayList<String>();
					for (int i = 0; i < xAxisList.size(); i++) {
						String month = xAxisList.get(i);
						month = month.replace(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY), "");
						month = month.replaceAll("^(0+)", "");
						month = month + "月";
						xAxisDataList.add(month);
					}

					barLine.setxAxisDataList(xAxisDataList);
					// X轴数据
					List<Object> seriesDataList = new ArrayList<Object>();
					for (BudgetMysql dt : list) {

						Integer qdsl = dt.getQdsl();
						if (qdsl == null) {
							qdsl = 0;
						}
						seriesDataList.add(qdsl);
					}

					barLine.setSeriesDataList(seriesDataList);
					barLine.setxAxisDataList(xAxisDataList);
					result.setSuccess(true);
					result.setData(barLine);
				}

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		if (type.equals("1")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault = resultObj.toString();
			//System.out.println(">>>>>>>>>>>11>>>>investment_data_02 " + resultObj.toString());
		} else {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault = resultObj.toString();
			//System.out.println(">>>>>>>>>>>>22>>>investment_data_02 " + resultObj.toString());
		}

		return resault;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mobile/small_leader/investment_data")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String zycInvestment(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		PageResult pageResult = new PageResult();
		List<BudgetMysql> list = new ArrayList();
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		String typeFlag = CommonUtil.getParameter(request, "typeFlag", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel()); // 领导标识
		paramsMap.put("username", sysUserInfo.getUserName());

		paramsMap.put("nd", nd);
		paramsMap.put("typeFlag", typeFlag);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getInvestment, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				////System.out.println(">>>>>>>>>>>>>>investment_data jSONArray-> " + jSONArray.toString());
				list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);

				/*
				 * BudgetMysql newBM = new BudgetMysql(); for (int i = 0; i <
				 * list.size(); i++) { BudgetMysql bm = list.get(i);
				 * 
				 * newBM.setDefine2("合计"); Double fyxXqBudget =
				 * newBM.getFyxXqBudget() == null ? 0d :
				 * Double.valueOf(newBM.getFyxXqBudget().toString()); Double
				 * temYS = bm.getFyxXqBudget() == null ? 0d :
				 * Double.valueOf(bm.getFyxXqBudget().toString());
				 * newBM.setFyxXqBudget(fyxXqBudget + temYS);
				 * 
				 * Double zbxBudget = newBM.getZbxBudget() == null ? 0d :
				 * Double.valueOf(newBM.getZbxBudget().toString()); Double temJE
				 * = bm.getZbxBudget() == null ? 0d :
				 * Double.valueOf(bm.getZbxBudget().toString());
				 * newBM.setZbxBudget(zbxBudget + temJE);
				 * 
				 * Double ysfyxje = newBM.getYsfyxje() == null ? 0d :
				 * Double.valueOf(newBM.getYsfyxje().toString()); Double temWXD
				 * = bm.getYsfyxje() == null ? 0d :
				 * Double.valueOf(bm.getYsfyxje().toString());
				 * newBM.setYsfyxje(ysfyxje + temWXD);
				 * 
				 * Double hanaMoney = newBM.getHanaMoney() == null ? 0d :
				 * Double.valueOf(newBM.getHanaMoney().toString()); Double
				 * temHana = bm.getHanaMoney() == null ? 0d :
				 * Double.valueOf(bm.getHanaMoney().toString());
				 * newBM.setHanaMoney(hanaMoney + temHana);
				 * 
				 * Double yszbxje = newBM.getYszbxje() == null ? 0d :
				 * Double.valueOf(newBM.getYszbxje().toString()); Double temZBX
				 * = bm.getYszbxje() == null ? 0d :
				 * Double.valueOf(bm.getYszbxje().toString());
				 * newBM.setYszbxje(yszbxje + temZBX); } list.add(0, newBM);
				 */

				for (int i = 0; i < list.size(); i++) {
					BudgetMysql bm = list.get(i);
					if (bm.getFyxXqBudget() == null || bm.getFyxXqBudget().toString().equals("null") || bm.getFyxXqBudget().toString().equals("")) {
						bm.setFyxXqBudget(String.format("%.2f", 0d));
					} else {
						bm.setFyxXqBudget(String.format("%.2f", Double.valueOf(String.valueOf(bm.getFyxXqBudget()))));
					}

					if (bm.getZbxBudget() == null || bm.getZbxBudget().toString().equals("null") || bm.getZbxBudget().toString().equals("")) {
						bm.setZbxBudget(String.format("%.2f", 0d));
					} else {
						bm.setZbxBudget(String.format("%.2f", Double.valueOf(String.valueOf(bm.getZbxBudget()))));
					}

					if (bm.getYsfyxje() == null || bm.getYsfyxje().toString().equals("null") || bm.getYsfyxje().toString().equals("")) {
						bm.setYsfyxje(String.format("%.2f", 0d));
					} else {
						bm.setYsfyxje(String.format("%.2f", Double.valueOf(String.valueOf(bm.getYsfyxje()))));
					}

					if (bm.getHanaMoney() == null || bm.getHanaMoney().toString().equals("null") || bm.getHanaMoney().toString().equals("")) {
						bm.setHanaMoney(String.format("%.2f", 0d));
					} else {
						bm.setHanaMoney(String.format("%.2f", Double.valueOf(String.valueOf(bm.getHanaMoney()))));
					}

					if (bm.getYszbxje() == null || bm.getYszbxje().toString().equals("null") || bm.getYszbxje().toString().equals("")) {
						bm.setYszbxje(String.format("%.2f", 0d));
					} else {
						bm.setYszbxje(String.format("%.2f", Double.valueOf(String.valueOf(bm.getYszbxje()))));
					}

				}

			}
			result.setSuccess(true);
			result.setData(list);

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		//System.out.println(">>>>>>>>>>>>>investment_data " + resultObj.toString());

		return resault;
	}

}
