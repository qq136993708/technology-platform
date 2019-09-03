package com.pcitc.web.controller.hanaLeader;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class SmallLeaderController extends BaseController {

	private static final String getInvestment = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/money-hana-type";

	private static final String getInvestment02 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/month/money-hana-type";

	private static final String getInvestmentAll = "http://pcitc-zuul/stp-proxy/stp-provider/budget/out-organ-items";

	private static final String getBudgetInfo = "http://pcitc-zuul/system-proxy/out-project-provider/budget/all-level";

	/**
	 * 专业处--研究院预算（原科研投入功能）
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/investment")
	public String investment(HttpServletRequest request) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		String userLevel = CommonUtil.getParameter(request, "userLevel", "");
		request.setAttribute("userLevel", userLevel);
		return "stp/hana/home/small_leader/investment";
	}

	/**
	 * 获取预算总额（按照专业处进行权限获取）
	 */
	@RequestMapping(value = "/small_leader/getInvestmentAll")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String getInvestmentAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		System.out.println("getInvestmentAll=================" + zycbm);

		JSONObject resultObj = new JSONObject();
		if (zycbm.equals("")) {
			// 无权限;
			return resultObj.toString();
		}

		// 数据控制属性
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel()); // 领导标识
		paramsMap.put("username", sysUserInfo.getUserName());
		paramsMap.put("nd", nd);

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getInvestment02, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>getInvestmentAll jSONArray-> " + jSONArray.toString());
			List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
			double investMoney = 0d;
			for (int i = 0; i < list.size(); i++) {
				BudgetMysql bm = list.get(i);
				investMoney = bm.getFyxXqBudget() == null?0d:Double.valueOf(bm.getFyxXqBudget().toString());
				break;
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("investMoney", String.valueOf(investMoney));
			result.setSuccess(true);
			result.setData(map);
		}
		resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		System.out.println(">>>>>>>>>>>>>>>getInvestmentAll " + resultObj.toString());
		return resault;
	}

	/**
	 * 专业处--研究院预算-直属研究院合同签订情况
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/investment_data")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String zycInvestment(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		PageResult pageResult = new PageResult();
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
				System.out.println(">>>>>>>>>>>>>>investment_data jSONArray-> " + jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);

				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "define2");
					barLine.setxAxisDataList(xAxisDataList);

					List<String> legendDataList = new ArrayList<String>();
					legendDataList.add("新签费用性预算");
					legendDataList.add("资本性预算");
					legendDataList.add("新签费用性金额");
					legendDataList.add("新签资本性金额");
					legendDataList.add("已拨款金额");
					barLine.setLegendDataList(legendDataList);
					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
					ChartBarLineSeries s1 = HanaUtil.getInvestmentBarLineSeries(list, "fyxXqBudget");
					seriesList.add(s1);
					ChartBarLineSeries s2 = HanaUtil.getInvestmentBarLineSeries(list, "zbxBudget");
					seriesList.add(s2);
					ChartBarLineSeries s3 = HanaUtil.getInvestmentBarLineSeries(list, "ysfyxje");
					seriesList.add(s3);
					ChartBarLineSeries s4 = HanaUtil.getInvestmentBarLineSeries(list, "yszbxje");
					seriesList.add(s4);
					ChartBarLineSeries s5 = HanaUtil.getInvestmentBarLineSeries(list, "hanaMoney");
					seriesList.add(s5);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("2")) {

					BudgetMysql newBM = new BudgetMysql();
					for (int i = 0; i < list.size(); i++) {
						BudgetMysql bm = list.get(i);

						newBM.setDefine2("合计");
						Double fyxXqBudget = newBM.getFyxXqBudget() == null ? 0d : Double.valueOf(newBM.getFyxXqBudget().toString());
						Double temYS = bm.getFyxXqBudget() == null ? 0d : Double.valueOf(bm.getFyxXqBudget().toString());
						newBM.setFyxXqBudget(fyxXqBudget + temYS);
						
						Double zbxBudget = newBM.getZbxBudget() == null ? 0d : Double.valueOf(newBM.getZbxBudget().toString());
						Double temJE = bm.getZbxBudget() == null ? 0d : Double.valueOf(bm.getZbxBudget().toString());
						newBM.setZbxBudget(zbxBudget + temJE);
						
						Double ysfyxje = newBM.getYsfyxje() == null ? 0d : Double.valueOf(newBM.getYsfyxje().toString());
						Double temWXD = bm.getYsfyxje() == null ? 0d : Double.valueOf(bm.getYsfyxje().toString());
						newBM.setYsfyxje(ysfyxje + temWXD);
						
						Double hanaMoney = newBM.getHanaMoney() == null ? 0d : Double.valueOf(newBM.getHanaMoney().toString());
						Double temHana = bm.getHanaMoney() == null ? 0d : Double.valueOf(bm.getHanaMoney().toString());
						newBM.setHanaMoney(hanaMoney + temHana);
						
						Double yszbxje = newBM.getYszbxje() == null ? 0d : Double.valueOf(newBM.getYszbxje().toString());
						Double temZBX = bm.getYszbxje() == null ? 0d : Double.valueOf(bm.getYszbxje().toString());
						newBM.setYszbxje(yszbxje + temZBX);
					}
					list.add(0, newBM);
					
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
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
				
				
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		if (type.equals("1")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault = resultObj.toString();
			System.out.println(">>>>>>>>>>>11>>>>investment_data " + resultObj.toString());
		} else {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			resault = resultObj.toString();
			System.out.println(">>>>>>>>>>>>22>>>investment_data " + resultObj.toString());
		}

		return resault;
	}

	/**
	 * 直属研究院月度合同签订情况
	 */
	@RequestMapping(value = "/small_leader/investment_data_02")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String investment_data_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		PageResult pageResult = new PageResult();
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
				System.out.println(">>>>>>>>>>>>>>getInvestment02 jSONArray-> " + jSONArray.toString());
				List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);

				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "yearMonth");
					barLine.setxAxisDataList(xAxisDataList);

					List<String> legendDataList = new ArrayList<String>();
					legendDataList.add("当月费用性签订金额");
					legendDataList.add("当月资本性签订金额");
					legendDataList.add("当月拨款金额");
					barLine.setLegendDataList(legendDataList);

					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();

					ChartBarLineSeries s1 = HanaUtil.getInvestmentBarLineSeries02(list, "ysfyxje");
					seriesList.add(s1);
					
					ChartBarLineSeries s2 = HanaUtil.getInvestmentBarLineSeries02(list, "yszbxje");
					seriesList.add(s2);

					ChartBarLineSeries s3 = HanaUtil.getInvestmentBarLineSeries02(list, "hanaMoney");
					seriesList.add(s3);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("2")) {
					BudgetMysql newBM = new BudgetMysql();
					for (int i = 0; i < list.size(); i++) {
						BudgetMysql bm = list.get(i);

						newBM.setYearMonth("合计");
						newBM.setFyxXqBudget(bm.getFyxXqBudget());
						newBM.setZbxBudget(bm.getZbxBudget());
						Double ysfyxje = newBM.getYsfyxje() == null ? 0d : Double.valueOf(newBM.getYsfyxje().toString());
						Double temJE = bm.getYsfyxje() == null ? 0d : Double.valueOf(bm.getYsfyxje().toString());
						newBM.setYsfyxje((double) Math.round((ysfyxje + temJE) * 100) / 100);
						
						Double yszbxje = newBM.getYszbxje() == null ? 0d : Double.valueOf(newBM.getYszbxje().toString());
						Double temJEz = bm.getYszbxje() == null ? 0d : Double.valueOf(bm.getYszbxje().toString());
						newBM.setYszbxje((double) Math.round((yszbxje + temJEz) * 100) / 100);

						Double hanaMoney = newBM.getHanaMoney() == null ? 0d : Double.valueOf(newBM.getHanaMoney().toString());
						Double temHana = bm.getHanaMoney() == null ? 0d : Double.valueOf(bm.getHanaMoney().toString());
						newBM.setHanaMoney((double) Math.round((hanaMoney + temHana) * 100) / 100);

						bm.setFyxXqBudget("-");
						bm.setZbxBudget("-");
					}
					
					list.add(0, newBM);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		if (type.equals("1")) {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault = resultObj.toString();
			System.out.println(">>>>>>>>>>>11>>>>investment_data_02 " + resultObj.toString());
		} else {
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			resault = resultObj.toString();
			System.out.println(">>>>>>>>>>>>22>>>investment_data_02 " + resultObj.toString());
		}

		return resault;
	}
	
	/**
	 * 获取预算总额（按照专业处进行权限获取）
	 */
	@RequestMapping(value = "/small_leader/budget/info")
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
			System.out.println(">>>>>>>>>>>>>>getBudgetInfo jSONArray-> " + jSONArray.toString());
			result.setSuccess(true);
			result.setData(jSONArray);
		}
		
		return result;
	}

}
