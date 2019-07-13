package com.pcitc.web.controller.hanaLeader;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

	private static final String getInvestmentAll = "http://pcitc-zuul/system-proxy/out-project-plan-provider/hana-invest/money";

	/**
	 * 专业处--研究院预算（原科研投入功能）
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/investment")
	public String investment(HttpServletRequest request) throws Exception {

		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);
		String userLevel = CommonUtil.getParameter(request, "userLevel", "");
		request.setAttribute("userLevel", userLevel);
		return "stp/hana/home/small_leader/investment";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/getInvestmentAll")
	@ResponseBody
	public String getInvestmentAll(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getInvestmentAll, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				Map<String, String> map = new HashMap<String, String>();
				JSONArray jSONArray = responseEntity.getBody();
				for (Iterator iterator = jSONArray.iterator(); iterator.hasNext();) {
					Map job = (Map) iterator.next();
					String investMoney = job.get("investMoney").toString();
					map.put("investMoney", investMoney);

				}
				result.setSuccess(true);
				result.setData(map);
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		System.out.println(">>>>>>>>>>>>>>>getInvestmentAll " + resultObj.toString());
		return resault;
	}

	/**
	 * 专业处--研究院预算
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
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
		paramsMap.put("nd", nd);

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
					legendDataList.add("预算金额");
					legendDataList.add("合同金额");
					// legendDataList.add("未签合同金额");
					legendDataList.add("拨款金额");
					// legendDataList.add("未拨款金额");
					barLine.setLegendDataList(legendDataList);
					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
					ChartBarLineSeries s1 = HanaUtil.getInvestmentBarLineSeries(list, "zysje");
					seriesList.add(s1);
					ChartBarLineSeries s2 = HanaUtil.getInvestmentBarLineSeries(list, "zsjje");
					seriesList.add(s2);
					// ChartBarLineSeries s21 =
					// HanaUtil.getInvestmentBarLineSeries(list, "wqhtzje");
					// seriesList.add(s21);

					ChartBarLineSeries s3 = HanaUtil.getInvestmentBarLineSeries(list, "hanaMoney");
					seriesList.add(s3);
					// ChartBarLineSeries s4 =
					// HanaUtil.getInvestmentBarLineSeries(list, "wbkzje");
					// seriesList.add(s4);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("2")) {

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

	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/investment_data_02")
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
		if (sysUserInfo.getUserLevel() != null && sysUserInfo.getUserLevel() == 1) {
			// 领导标识，不控制数据
			paramsMap.put("leaderFlag", "1");
		}
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
					legendDataList.add("预算金额");
					legendDataList.add("合同金额");
					legendDataList.add("拨款金额");
					barLine.setLegendDataList(legendDataList);
					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
					ChartBarLineSeries s1 = HanaUtil.getInvestmentBarLineSeries02(list, "zysje");
					seriesList.add(s1);

					ChartBarLineSeries s12 = HanaUtil.getInvestmentBarLineSeries02(list, "zsjje");
					seriesList.add(s12);

					ChartBarLineSeries s2 = HanaUtil.getInvestmentBarLineSeries02(list, "hanaMoney");
					seriesList.add(s2);
					barLine.setSeriesList(seriesList);
					result.setSuccess(true);
					result.setData(barLine);
				}
				if (type.equals("2")) {

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
