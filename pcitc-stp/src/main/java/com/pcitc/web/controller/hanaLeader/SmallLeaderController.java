package com.pcitc.web.controller.hanaLeader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;
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

	private static final String getZBX = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/money-hana-type";

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
		paramsMap.put("nd", nd);

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getInvestment02, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>getInvestment02 jSONArray-> " + jSONArray.toString());
			List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
			double investMoney = 0d;
			for (int i = 0; i < list.size(); i++) {
				BudgetMysql bm = list.get(i);
				investMoney = bm.getZysje() == null?0d:Double.valueOf(bm.getZysje().toString());
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
					legendDataList.add("可新签预算");
					legendDataList.add("已签订金额");
					legendDataList.add("已拨款金额");
					barLine.setLegendDataList(legendDataList);
					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
					ChartBarLineSeries s1 = HanaUtil.getInvestmentBarLineSeries(list, "zysje");
					seriesList.add(s1);
					ChartBarLineSeries s2 = HanaUtil.getInvestmentBarLineSeries(list, "zsjje");
					seriesList.add(s2);
					ChartBarLineSeries s3 = HanaUtil.getInvestmentBarLineSeries(list, "hanaMoney");
					seriesList.add(s3);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("2")) {

					BudgetMysql newBM = new BudgetMysql();
					for (int i = 0; i < list.size(); i++) {
						BudgetMysql bm = list.get(i);

						newBM.setDefine2("合计");
						Double zysje = newBM.getZysje() == null ? 0d : Double.valueOf(newBM.getZysje().toString());
						Double temYS = bm.getZysje() == null ? 0d : Double.valueOf(bm.getZysje().toString());
						newBM.setZysje(zysje + temYS);
						
						Double zsjje = newBM.getZsjje() == null ? 0d : Double.valueOf(newBM.getZsjje().toString());
						Double temJE = bm.getZsjje() == null ? 0d : Double.valueOf(bm.getZsjje().toString());
						newBM.setZsjje(zsjje + temJE);
						
						Double wqhtzje = newBM.getWqhtzje() == null ? 0d : Double.valueOf(newBM.getWqhtzje().toString());
						Double temWXD = bm.getWqhtzje() == null ? 0d : Double.valueOf(bm.getWqhtzje().toString());
						newBM.setWqhtzje(wqhtzje + temWXD);
						
						Double hanaMoney = newBM.getHanaMoney() == null ? 0d : Double.valueOf(newBM.getHanaMoney().toString());
						Double temHana = bm.getHanaMoney() == null ? 0d : Double.valueOf(bm.getHanaMoney().toString());
						newBM.setHanaMoney(hanaMoney + temHana);

						Double wbkzje = newBM.getWbkzje() == null ? 0d : Double.valueOf(newBM.getWbkzje().toString());
						Double temWBK = bm.getWbkzje() == null ? 0d : Double.valueOf(bm.getWbkzje().toString());
						newBM.setWbkzje(wbkzje + temWBK);
					}
					list.add(0, newBM);
					
					for (int i = 0; i < list.size(); i++) {
						BudgetMysql bm = list.get(i);
						bm.setZysje(String.format("%.2f", Double.valueOf(String.valueOf(bm.getZysje()))));
						bm.setZsjje(String.format("%.2f", Double.valueOf(String.valueOf(bm.getZsjje()))));
						bm.setWqhtzje(String.format("%.2f", Double.valueOf(String.valueOf(bm.getWqhtzje()))));
						bm.setHanaMoney(String.format("%.2f", Double.valueOf(String.valueOf(bm.getHanaMoney()))));
						bm.setWbkzje(String.format("%.2f", Double.valueOf(String.valueOf(bm.getWbkzje()))));
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
					legendDataList.add("当月签订金额");
					legendDataList.add("当月拨款金额");
					barLine.setLegendDataList(legendDataList);

					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();

					ChartBarLineSeries s12 = HanaUtil.getInvestmentBarLineSeries02(list, "zsjje");
					seriesList.add(s12);

					ChartBarLineSeries s2 = HanaUtil.getInvestmentBarLineSeries02(list, "hanaMoney");
					seriesList.add(s2);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("2")) {
					BudgetMysql newBM = new BudgetMysql();
					for (int i = 0; i < list.size(); i++) {
						BudgetMysql bm = list.get(i);

						newBM.setYearMonth("合计");
						newBM.setZysje(bm.getZysje());
						Double zsjje = newBM.getZsjje() == null ? 0d : Double.valueOf(newBM.getZsjje().toString());
						Double temJE = bm.getZsjje() == null ? 0d : Double.valueOf(bm.getZsjje().toString());
						newBM.setZsjje(zsjje + temJE);

						Double hanaMoney = newBM.getHanaMoney() == null ? 0d : Double.valueOf(newBM.getHanaMoney().toString());
						Double temHana = bm.getHanaMoney() == null ? 0d : Double.valueOf(bm.getHanaMoney().toString());
						newBM.setHanaMoney(hanaMoney + temHana);

						bm.setZysje("-");
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

}
