package com.pcitc.web.controller.hana;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.ChartDot;
import com.pcitc.base.common.ChartDotResultData;
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.BrandConstructionPay;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis01;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis02;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis03;
import com.pcitc.base.hana.report.InvisibleCapitalDevelop;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.hana.report.ScientificBaseBuildFee01;
import com.pcitc.base.hana.report.ScientificBaseBuildFee02;
import com.pcitc.base.hana.report.ScientificBaseBuildFee03;
import com.pcitc.base.hana.report.ScientificBaseBuildFee04;
import com.pcitc.base.hana.report.ScientificCashFlow01;
import com.pcitc.base.hana.report.ScientificCashFlow02;
import com.pcitc.base.hana.report.ScientificCashFlow03;
import com.pcitc.base.hana.report.ScientificInstrumentPay;
import com.pcitc.base.hana.report.ScientificInstrumentPayDetail;
import com.pcitc.base.hana.report.TopicDevelop;
import com.pcitc.base.hana.report.TotalCostProjectPay01;
import com.pcitc.base.hana.report.TotalCostProjectPay02;
import com.pcitc.base.hana.report.TotalCostProjectPay03;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.ExcelUtils;
import com.pcitc.web.utils.HanaUtil;

/**
 * 经费决策
 * 
 * @author admin
 */
@Controller
@RequestMapping(value = "/financial-decision")
public class FinancialDecisionController extends BaseController {

	// 报表名称: 科技资金现金流分析 报表编码:
	// H1AM_KY_ZH_1003_01,H1AM_KY_ZH_1003_02,H1AM_KY_ZH_1003_03
	private static final String GET_DECISION_FUNDS_CHSH_FLOW_01 = "http://pcitc-zuul/hana-proxy/hana/decision/funds/cash-flow/01";
	private static final String GET_DECISION_FUNDS_CHSH_FLOW_02 = "http://pcitc-zuul/hana-proxy/hana/decision/funds/cash-flow/02";
	private static final String GET_DECISION_FUNDS_CHSH_FLOW_03 = "http://pcitc-zuul/hana-proxy/hana/decision/funds/cash-flow/03";

	// 报表名称: 科研经费综合分析 报表编码:
	// H1AM_KY_ZH_1001_01,H1AM_KY_ZH_1001_02,H1AM_KY_ZH_1001_03
	private static final String GET_FUNDS_ALL_ANANLYSIS_01 = "http://pcitc-zuul/hana-proxy/hana/decision/funds/all-analysis/01";
	private static final String GET_FUNDS_ALL_ANANLYSIS_02 = "http://pcitc-zuul/hana-proxy/hana/decision/funds/all-analysis/02";
	private static final String GET_FUNDS_ALL_ANANLYSIS_03 = "http://pcitc-zuul/hana-proxy/hana/decision/funds/all-analysis/03";
	// 全成本项目支出综合分析
	private static final String GET_TOTAL_COST_PROJECT_PAY_01 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/total_cost_project_pay/01";
	private static final String GET_TOTAL_COST_PROJECT_PAY_TYPE_01 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/total_cost_project_pay/type_01";
	private static final String GET_TOTAL_COST_PROJECT_PAY_02 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/total_cost_project_pay/02";
	private static final String GET_TOTAL_COST_PROJECT_PAY_03 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/total_cost_project_pay/03";

	// 科研基建投资支出分析
	private static final String GET_BASE_BUILD_01 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/base_build_01";
	private static final String GET_BASE_BUILD_02 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/base_build_02";
	private static final String GET_BASE_BUILD_03 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/base_build_03";
	private static final String GET_BASE_BUILD_04 = "http://pcitc-zuul/hana-proxy/hana/decision/financial/base_build_04";
	private static final String GET_BASE_BUILD_04_EXCEL = "http://pcitc-zuul/hana-proxy/hana/decision/financial/base_build_04_excel";

	// 科研仪器设备支出分析
	private static final String GET_SCIENTIFIC_DEVICE_PAY_DETAIL = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_device_pay_detail";
	private static final String GET_SCIENTIFIC_DEVICE_PAY_DETAIL_EXCEL = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_device_pay_detail_excel";

	private static final String GET_SCIENTIFIC_DEVICE_PAY_TRAND = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_device_pay_trand";
	private static final String GET_SCIENTIFIC_DEVICE_PAY_TYPE = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_device_pay_by_type";
	private static final String GET_SCIENTIFIC_DEVICE_PAY_DEPARTMENT = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_device_pay_by_department";

	// 品牌建设支出分析
	private static final String GET_SCIENTIFIC_RBAND_PAY_DETAIL = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_brand_pay_detail";
	private static final String GET_SCIENTIFIC_RBAND_PAY_DETAIL_EXCEL = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_brand_pay_detail_excel";

	private static final String GET_SCIENTIFIC_RBAND_PAY_TRAND = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_brand_pay_trand";
	private static final String GET_SCIENTIFIC_RBAND_PAY_TYPE = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_brand_pay_by_type";
	private static final String GET_SCIENTIFIC_RBAND_PAY_DEPARTMENT = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_brand_pay_by_department";

	// 无形资产支出分析
	private static final String GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_DETAIL = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_invisible_capital_detail";
	private static final String GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_DETAIL_EXCEL = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_invisible_capital_detail_excel";
	private static final String GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_TRAND = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_invisible_capital_trand";
	private static final String GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_TYPE = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_invisible_capital_type";
	private static final String GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_DEPARTMENT = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_invisible_capital_department";

	// 课题研发支出分析
	private static final String GET_SCIENTIFIC_TOPIC_POT = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_topic_develop_pot";
	private static final String GET_SCIENTIFIC_TOPIC_PIE = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_topic_develop_detail_pie";
	private static final String GET_SCIENTIFIC_TOPIC_DETAIL_BY_CODE = "http://pcitc-zuul/hana-proxy/hana/decision/financial/scientific_topic_develop_detail_by_code";

	
	
	
	
	
	
	/**
	 * ===========================================全成本项目支出综合分析
	 * ===========================================
	 */

	@RequestMapping(value = "/to-total-cost-project_pay")
	public String total_cost_project_pay(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		String month = HanaUtil.getCurrrentYearMoth();
		request.setAttribute("month", month);
		return "stp/hana/decision/financial/total-cost-project_pay";
	}

	/**
	 * 研究院科研经费预算批复和实际支出全成本分析
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/total-cost-project-01")
	@ResponseBody
	public String total_cost_project_pay_Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			// 科研经费预算投入年度趋势分析
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_TOTAL_COST_PROJECT_PAY_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				List<TotalCostProjectPay01> list = JSONObject.parseArray(jSONArray.toJSONString(), TotalCostProjectPay01.class);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>研究院科研经费预算批复和实际支出全成本分析       statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
				ChartBarLineResultData barLine = new ChartBarLineResultData();
				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("实际支出");
				legendDataList.add("预算批复");
				legendDataList.add("预算结余");
				barLine.setLegendDataList(legendDataList);
				List<String> yAxisDataList = HanaUtil.getYAxisTotalCostProjectPay01(list, "G0XMLXMS");// YAxis
				barLine.setyAxisDataList(yAxisDataList);

				List<ChartBarLineSeries> seriesList = HanaUtil.getSeriesListTotalCostProjectPay01(list);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}
		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>>>>>研究院科研经费预算批复和实际支出全成本分析 " + resultObj.toString());
		return resultObj.toString();

	}

	/**
	 * 研究院科研经费预算批复和实际支出全成本分析 G0XMGLLX G0XMGLLY G0XMGLJB
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/total-cost-project_pay-01")
	@ResponseBody
	public String toalCostPay(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "G0XMGLLX");
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode+" type="+type);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("type", type);
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			// 科研经费预算投入年度趋势分析
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_TOTAL_COST_PROJECT_PAY_TYPE_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				List<TotalCostProjectPay01> list = JSONObject.parseArray(jSONArray.toJSONString(), TotalCostProjectPay01.class);
				// System.out.println(">>>>>>>>>>>>>>>>>>>>>GET_TOTAL_COST_PROJECT_PAY_TYPE_01 返回      statusCode = "+statusCode+" jSONArray="+jSONArray.toString());
				ChartBarLineResultData barLine = new ChartBarLineResultData();
				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("实际支出");
				legendDataList.add("预算批复");
				legendDataList.add("使用率");
				barLine.setLegendDataList(legendDataList);
				List<String> xAxisDataList = HanaUtil.getYAxisTotalCostProjectPay01(list, type);// YAxis
				barLine.setxAxisDataList(xAxisDataList);

				List<ChartBarLineSeries> seriesList = HanaUtil.getSeriesListTotalCostProjectPayType01(list);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}
		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		if (type.equals("G0XMGLLX")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>项目类型使用率分析: " + resultObj.toString());
		} else if (type.equals("G0XMGLLY")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>项目来源使用率分析: " + resultObj.toString());
		} else if (type.equals("G0XMGLJB")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>项目管理级别使用率分析: " + resultObj.toString());
		}

		return resultObj.toString();

	}

	/**
	 * H1AS_KY_CB_1001_02 全成本项目支出综合分析_实际支出费用类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/total-cost-project-02")
	@ResponseBody
	public String H1AS_KY_CB_1001_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode+" type="+type);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("type", type);
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("") && !month.equals("") && !type.equals("")) {
			// 科研经费预算投入年度趋势分析
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_TOTAL_COST_PROJECT_PAY_02, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				List<TotalCostProjectPay02> list = JSONObject.parseArray(jSONArray.toJSONString(), TotalCostProjectPay02.class);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>GET_TOTAL_COST_PROJECT_PAY_02 返回      statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
				if (type.equals("1"))// 费用细分类型使用率分析
				{
					// 封装返回对像
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					// xAxis data
					List<String> xAxisDataList = HanaUtil.getXAxisDataList_TotalCostProjectPay02(list);
					// legend data
					List<String> legendDataList = new ArrayList<String>();
					legendDataList.add("实际支出");// K0BNGLFPHJECB
					legendDataList.add("同期支出");// K0SNGLFPHJECB
					legendDataList.add("同比");// K0TBBL
					barLine.setxAxisDataList(xAxisDataList);
					barLine.setLegendDataList(legendDataList);
					// X轴数据
					List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
					ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_TotalCostProjectPay02(list, "K0BNGLFPHJECB");// 实际支出
					ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_TotalCostProjectPay02(list, "K0SNGLFPHJECB");// 同期支出
					ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_TotalCostProjectPay02(list, "K0TBBL");// 同比
					seriesList.add(s1);
					seriesList.add(s2);
					seriesList.add(s3);
					barLine.setSeriesList(seriesList);
					result.setData(barLine);
					result.setSuccess(true);
				} else if (type.equals("2"))// 费用细分类型占比分析
				{
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						TotalCostProjectPay02 f2 = list.get(i);
						String name = f2.getG0FYFL();
						String value = f2.getK0BNGLFPHJECB();
						value=String.format("%.2f", Double.valueOf(value));
						legendDataList.add(name);
						dataList.add(new ChartPieDataValue(value, name));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					result.setData(pie);
					result.setSuccess(true);
				} else if (type.equals("3"))// 研究院实际支出占比分析
				{
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						TotalCostProjectPay02 f2 = list.get(i);
						String name = f2.getG0GSJC();
						String value = f2.getK0BNGLFPHJECB();
						value=String.format("%.2f", Double.valueOf(value));
						legendDataList.add(name);
						dataList.add(new ChartPieDataValue(value, name));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					result.setData(pie);
					result.setSuccess(true);
				}

			}
		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		if (type.equals("1")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>费用细分类型使用率分析: " + resultObj.toString());
		} else if (type.equals("2")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>费用细分类型占比分析: " + resultObj.toString());
		} else if (type.equals("3")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>研究院实际支出占比分析: " + resultObj.toString());
		}

		return resultObj.toString();

	}

	/**
	 * 研究院人均实际支出分析
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/total-cost-project-03")
	@ResponseBody
	public String toalCostPay03(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!month.equals("")) {
			// 科研经费预算投入年度趋势分析
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_TOTAL_COST_PROJECT_PAY_03, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				List<TotalCostProjectPay03> list = JSONObject.parseArray(jSONArray.toJSONString(), TotalCostProjectPay03.class);
				// System.out.println(">>>>>>>>>>>>>>>>>>>>>研究院人均实际支出分析 返回      statusCode = "+statusCode+" jSONArray="+jSONArray.toString());
				ChartBarLineResultData barLine = new ChartBarLineResultData();
				// xAxis
				List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0GSJC");
				barLine.setxAxisDataList(xAxisDataList);
				// legendData
				List<String> legendDataList = new ArrayList();
				legendDataList.add("人均成本");
				legendDataList.add("人均专利");
				legendDataList.add("人均项目");
				barLine.setLegendDataList(legendDataList);

				List<ChartBarLineSeries> seriesList = HanaUtil.getSeriesListByTotalCostProjectPay03(list);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}
		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>研究院人均实际支出分析 " + resultObj.toString());
		return resultObj.toString();

	}

	/**
	 * ===========================================全成本项目支出综合分析
	 * end===========================================
	 */

	/**
	 * ===========================================科研经费综合分析
	 * ===========================================
	 */
	/**
	 * 科研经费综合分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/to-funds-all-analysis")
	public String funds_all_analysis(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);

		return "stp/hana/decision/financial/funds-all-analysis";
	}

	/**
	 * 科研经费综合分析 --科研经费预算投入年度趋势分析
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/funds-all-analysis-01")
	@ResponseBody
	public String funds_all_analysis_01_Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals("")) {
			// 科研经费预算投入年度趋势分析
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_FUNDS_ALL_ANANLYSIS_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				List<FundsComprehensiveAnalysis01> list = JSONObject.parseArray(jSONArray.toJSONString(), FundsComprehensiveAnalysis01.class);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>GET_FUNDS_ALL_ANANLYSIS_01 返回      statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
				ChartBarLineResultData barLine = new ChartBarLineResultData();
				List<String> xAxisDataList = HanaUtil.duplicateList(list);
				barLine.setxAxisDataList(xAxisDataList);
				List<String> legendDataList = HanaUtil.getBeforeYear4List(month);
				barLine.setLegendDataList(legendDataList);
				List seriesList = HanaUtil.getChartBarLineSeriesByYear(list, legendDataList);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}
		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>resultObj " + resultObj.toString());
		return resultObj.toString();

	}

	/**
	 * 科研经费综合分析 --02
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/funds-all-analysis-02")
	@ResponseBody
	public String funds_all_analysis_02Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String analysisType = CommonUtil.getParameter(request, "analysisType", "1");// 1预算,2投入
		if (!month.equals("") && !companyCode.equals("") && !type.equals("")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode + " type=" + type);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			paramsMap.put("type", type);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_FUNDS_ALL_ANANLYSIS_02, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				ChartPieResultData pie = new ChartPieResultData();
				JSONArray jSONArray = responseEntity.getBody();
				List<FundsComprehensiveAnalysis02> list = JSONObject.parseArray(jSONArray.toJSONString(), FundsComprehensiveAnalysis02.class);
				if (type.equals("project")) {
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						FundsComprehensiveAnalysis02 f2 = list.get(i);
						String projectName = f2.getG0XMGLLX();
						String k0BNYSJE = f2.getK0BNYSJE();// 预算
						String k0BNSJJE = f2.getK0BNSJJE();// 投入
						k0BNYSJE=String.format("%.2f", Double.valueOf(k0BNYSJE));
					    k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
						legendDataList.add(projectName);
						if (analysisType.equals("1")) {
							dataList.add(new ChartPieDataValue(k0BNYSJE, projectName));
						} else {
							dataList.add(new ChartPieDataValue(k0BNSJJE, projectName));
						}

					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
				}
				if (type.equals("source")) {
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						FundsComprehensiveAnalysis02 f2 = list.get(i);
						String projectName = f2.getG0XMGLLY();
						String k0BNYSJE = f2.getK0BNYSJE();// 预算
						String k0BNSJJE = f2.getK0BNSJJE();// 投入
						k0BNYSJE=String.format("%.2f", Double.valueOf(k0BNYSJE));
					    k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
						legendDataList.add(projectName);
						if (analysisType.equals("1")) {
							dataList.add(new ChartPieDataValue(k0BNYSJE, projectName));
						} else {
							dataList.add(new ChartPieDataValue(k0BNSJJE, projectName));
						}

					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
				}
				if (type.equals("manage")) {
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						FundsComprehensiveAnalysis02 f2 = list.get(i);
						String projectName = f2.getG0XMGLJB();
						String k0BNYSJE = f2.getK0BNYSJE();// 预算
						String k0BNSJJE = f2.getK0BNSJJE();// 投入
						k0BNYSJE=String.format("%.2f", Double.valueOf(k0BNYSJE));
					    k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
						legendDataList.add(projectName);

						if (analysisType.equals("1")) {
							dataList.add(new ChartPieDataValue(k0BNYSJE, projectName));
						} else {
							dataList.add(new ChartPieDataValue(k0BNSJJE, projectName));
						}

					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
				}
				result.setData(pie);
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
				result.setMessage("远程调用出错");
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));

		if (type.equals("manage") && analysisType.equals("2")) {
			System.out.println(">>>>>>>>>>>>>>>>>研究院实际经费投入管理级别占比分析 " + resultObj.toString());
		} else {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>funds-all-analysis-02 " + resultObj.toString());
		}

		return resultObj.toString();

	}

	/**
	 * 科研经费综合分析 --研究院科研经费资金使用率分析
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/funds-all-analysis-03")
	@ResponseBody
	public String funds_all_analysis_03Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));

		List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
		String companyCode = HanaUtil.getCompanyCodeAll(companyCodeList);

		// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		// 研究院科研经费资金使用率分析
		ResponseEntity<JSONArray> responseEntity_03 = restTemplate.exchange(GET_FUNDS_ALL_ANANLYSIS_03, HttpMethod.POST, entity, JSONArray.class);
		int statusCode_03 = responseEntity_03.getStatusCodeValue();
		if (statusCode_03 == 200) {
			JSONArray jSONArray = responseEntity_03.getBody();
			if (jSONArray != null) {
				List<FundsComprehensiveAnalysis03> list = JSONObject.parseArray(jSONArray.toJSONString(), FundsComprehensiveAnalysis03.class);
				// System.out.println(">>>>>>>>>>>>>>>>>>>>>GET_FUNDS_ALL_ANANLYSIS_03 返回      statusCode = "+statusCode_03+" jSONArray="+jSONArray.toString());
				// 封装返回对像
				ChartBarLineResultData barLine = new ChartBarLineResultData();
				// xAxis data
				List<String> xAxisDataList = HanaUtil.getXAxisDataList(list);
				// legend data
				List<String> legendDataList = new ArrayList<String>();
				legendDataList.add("计划");
				legendDataList.add("实际");
				legendDataList.add("本期使用率");
				legendDataList.add("同期使用率");
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries(list, "K0BNYSJE");// 计划
				ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries(list, "K0BNSJJE");// 实际
				ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries(list, "K0BNZCBL");// 本期
				ChartBarLineSeries s4 = HanaUtil.getChartBarLineSeries(list, "K0TQZCBL");// 同期
				seriesList.add(s1);
				seriesList.add(s2);
				seriesList.add(s3);
				seriesList.add(s4);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>研究院科研经费资金使用率分析: " + resultObj.toString());
		return resultObj.toString();

	}

	/**
	 * ===========================================科研经费综合分析 end
	 * ===========================================
	 */

	/**
	 * ===========================================科技资金现金流分析 begin
	 * ===========================================
	 */

	/**
	 * 科技资金现金流分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/to-cash-flow")
	public String cash_flow(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		String month = HanaUtil.getCurrrent_Year_Moth();
		request.setAttribute("month", month);
		return "stp/hana/decision/financial/cash-flow";
	}

	/**
	 * @param request
	 * @param 报表名称
	 *            : 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_01
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/cash-flow-01")
	@ResponseBody
	public synchronized String cashFlowAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartSingleLineResultData chartSingleLineResultData = new ChartSingleLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_DECISION_FUNDS_CHSH_FLOW_01, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			List<ScientificCashFlow01> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificCashFlow01.class);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>loadData 返回      statusCode = " + statusCode + " list=" + list.size());
			if (list.size() > 0) {
				List<String> xAxisDataList = new ArrayList<String>();
				List<Object> seriesDataList = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {
					ScientificCashFlow01 flo01 = (ScientificCashFlow01) list.get(i);
					String yearMonth = flo01.getG0CWNY();
					String value = flo01.getK0XJYE();
					value=String.format("%.2f", Double.valueOf(value));
					xAxisDataList.add(yearMonth);
					seriesDataList.add(value);
				}
				chartSingleLineResultData.setSeriesDataList(seriesDataList);
				chartSingleLineResultData.setxAxisDataList(xAxisDataList);
			}
			resultsDate.setSuccess(true);
			resultsDate.setData(chartSingleLineResultData);
		} else {
			resultsDate.setSuccess(false);
		}

		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();

	}

	/**
	 * @param request
	 * @param 报表名称
	 *            : 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_02
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/cash-flow-02")
	@ResponseBody
	public String cashFlow2Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageResult pageResult = new PageResult();

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "1020");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<List> responseEntity = restTemplate.exchange(GET_DECISION_FUNDS_CHSH_FLOW_02, HttpMethod.POST, entity, List.class);
		List list = responseEntity.getBody();
		if (list != null) {
			
			
			
			pageResult.setData(list);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(list.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);
			
		}

		
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>cash-flow-02 result = " + result.toString());
		
		return result.toString();

	}

	/**
	 * @param request
	 * @param 报表名称
	 *            : 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_03
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/cash-flow-03")
	@ResponseBody
	public String cashFlow3Ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		// 饼图
		ChartPieResultData pieResult = new ChartPieResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String type = CommonUtil.getParameter(request, "type", "13");// 13,27,46
		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		
		
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("type", type);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_DECISION_FUNDS_CHSH_FLOW_03, HttpMethod.POST, entity, JSONArray.class);
		JSONArray array = responseEntity.getBody();
		if (array != null) {
			List<ScientificCashFlow03> list = JSONObject.parseArray(array.toJSONString(), ScientificCashFlow03.class);
			if (list != null) {
				List<ChartPieDataValue> piedataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i < list.size(); i++) {
					ScientificCashFlow03 fl3 = list.get(i);
					String value = fl3.getK0BQLJJE();
					String name = fl3.getG0GSJC();
					
					value=String.format("%.2f", Double.valueOf(value));
				    
					piedataList.add(new ChartPieDataValue(value, name));
					legendDataList.add(name);
				}
				pieResult.setDataList(piedataList);
				pieResult.setLegendDataList(legendDataList);

			}
			resultsDate.setSuccess(true);
			resultsDate.setData(pieResult);
		} else {
			resultsDate.setSuccess(false);
			resultsDate.setData(null);
		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>loadData 返回      status = " + responseEntity.getStatusCodeValue() + " json=" + array.toString());
		response.setContentType("text/html;charset=UTF-8");
		String resut = JSON.toJSONString(resultsDate);
		System.out.println(" ajax 结果-->:" + resut);
		return resut;

	}

	/**
	 * ===========================================科技资金现金流分析 end
	 * ===========================================
	 */

	/**
	 * =========================d= =================科研基建投资支出分析
	 * ===========================================
	 */
	/**
	 * 科研基建投资支出分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/scientific-base-pay-analysis")
	public String scientificResearchPayAnalysis(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/scientific-base-pay-analysis";
	}

	// 科研基建支出年度趋势分析
	@RequestMapping(method = RequestMethod.GET, value = "/base_build_01")
	@ResponseBody
	public synchronized String GET_BASE_BUILD_01(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BASE_BUILD_01, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			List<ScientificBaseBuildFee01> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificBaseBuildFee01.class);

			if (list.size() > 0) {

				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "g0ZCMS");
				barLine.setxAxisDataList(xAxisDataList);
				List<String> legendDataList = HanaUtil.getduplicatexAxisByList(list, "g0CALY");
				barLine.setLegendDataList(legendDataList);
				List seriesList = HanaUtil.getCBSByScientificBaseBuildFee01Year(list, legendDataList);
				barLine.setSeriesList(seriesList);
			}
			resultsDate.setSuccess(true);
			resultsDate.setData(barLine);
		} else {
			resultsDate.setSuccess(false);
		}

		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		System.out.println("科研基建支出年度趋势分析 " + result.toString());
		return result.toString();

	}

	// 科研基建投资支出分析->同比--占比分析
	@RequestMapping(method = RequestMethod.GET, value = "/base_build_02")
	@ResponseBody
	public synchronized String GET_BASE_BUILD_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String foreachIn = CommonUtil.getParameter(request, "foreachIn", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode + " foreachIn=" + foreachIn);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		paramsMap.put("type", type);
		paramsMap.put("foreachIn", foreachIn);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BASE_BUILD_02, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			List<ScientificBaseBuildFee02> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificBaseBuildFee02.class);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>loadData 返回      statusCode = " + statusCode + " list=" + list.size());
			if (list.size() > 0) {
				if (type.equals("1")) {
					// xAxis
					List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0GSJC");
					barLine.setxAxisDataList(xAxisDataList);
					// legendData
					List<String> legendDataList = new ArrayList();
					legendDataList.add("本期基建支出");
					legendDataList.add("同期基建支出");
					legendDataList.add("基建支出同比");
					barLine.setLegendDataList(legendDataList);
					List<ChartBarLineSeries> seriesList = HanaUtil.getSeriesListByScientificBaseBuildFee02(list);
					barLine.setSeriesList(seriesList);
					resultsDate.setSuccess(true);
					resultsDate.setData(barLine);
				}
				if (type.equals("2")) {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						ScientificBaseBuildFee02 f2 = list.get(i);
						String name = f2.getG0GSJC();
						String value = f2.getK0BNZCJE();
						value=String.format("%.2f", Double.valueOf(value));
						legendDataList.add(name);
						dataList.add(new ChartPieDataValue(value, name));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					resultsDate.setData(pie);
					resultsDate.setSuccess(true);
				}
			}

		} else {
			resultsDate.setSuccess(false);
		}

		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		if (type.equals("1")) {
			System.out.println("研究院基建支出同比分析 " + result.toString());
		}
		if (type.equals("2")) {
			System.out.println("研究院基建支出占比分析 " + result.toString());
		}
		return result.toString();

	}

	// 研究院基建人均面积|基建面积 分析
	@RequestMapping(method = RequestMethod.GET, value = "/base_build_03")
	@ResponseBody
	public synchronized String GET_BASE_BUILD_03(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String foreachIn = CommonUtil.getParameter(request, "foreachIn", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode + " type=" + type);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		paramsMap.put("foreachIn", foreachIn);
		paramsMap.put("type", type);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BASE_BUILD_03, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			List<ScientificBaseBuildFee03> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificBaseBuildFee03.class);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>loadData 返回      statusCode = " + statusCode + " list=" + list.size());
			if (list.size() > 0) {
				if (type.equals("1")) {

					// xAxis
					List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0GSJC");
					barLine.setxAxisDataList(xAxisDataList);
					// legendData
					List<String> legendDataList = new ArrayList();
					legendDataList.add("人均房屋面积");
					legendDataList.add("人均办公室面积");
					legendDataList.add("人均实验室面积");
					barLine.setLegendDataList(legendDataList);
					List<ChartBarLineSeries> seriesList = HanaUtil.getSeriesListByScientificBaseBuildFee03(list);
					barLine.setSeriesList(seriesList);
					resultsDate.setSuccess(true);
					resultsDate.setData(barLine);
				}
				if (type.equals("2")) {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						ScientificBaseBuildFee03 f2 = list.get(i);
						String name = f2.getG0GSJC();
						String value = f2.getK0BNFWMJ();
						value=String.format("%.2f", Double.valueOf(value));
						
						legendDataList.add(name);
						dataList.add(new ChartPieDataValue(value, name));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					resultsDate.setData(pie);
					resultsDate.setSuccess(true);
				}
			}
		} else {
			resultsDate.setSuccess(false);
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));

		if (type.equals("1")) {
			System.out.println("研究院基建人均面积分析 " + result.toString());
		}
		if (type.equals("2")) {
			System.out.println("研究院基建面积占比分析 " + result.toString());
		}

		return result.toString();

	}

	/**
	 * 科研基建投资支出分析 明细
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/scientific-base-pay-analysis-detail")
	public String scientificResearchPayAnalysisdetail(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/scientific-base-pay-analysis-detail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/scientific_base_pay_analysis_detail_list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("scientific_base_pay_analysis_detail_list param=   " + JSONObject.toJSONString(param));

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_BASE_BUILD_04, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		return result.toString();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/scientific-base-pay-analysis-detail-excel-out")
	public void scientificResearchPayAnalysisdetailexcelout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScientificBaseBuildFee04 sysLog = new ScientificBaseBuildFee04();
		String month = request.getParameter("month");
		String companyCode = request.getParameter("companyCode");
		String g0TXT50 = request.getParameter("g0TXT50");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0TXT50", g0TXT50);

		System.out.println(">>>>>>>>>excel-out  month" + month + " companyCode=" + companyCode);
		HttpEntity<Map> entity = new HttpEntity<Map>(map, this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(GET_BASE_BUILD_04_EXCEL, HttpMethod.POST, entity, JSONArray.class);
		JSONArray result = responseEntity.getBody();

		if (result != null) {
			List<ScientificBaseBuildFee04> list = JSON.parseArray(result.toJSONString(), ScientificBaseBuildFee04.class);
			// 处理list数据
			List<String> listKey = new ArrayList<String>();

			listKey.add(0, "g0TXT50");
			listKey.add(1, "g0GSJC");
			listKey.add(2, "g0PRCTR");
			listKey.add(3, "g0NCGZYZJE");
			listKey.add(4, "g0LJZCZJJE");
			listKey.add(5, "g0LJGZYZJE");

			List<String> listName = new ArrayList<String>();
			listName.add(0, "资产描述");
			listName.add(1, "公司");
			listName.add(2, "成本中心");
			listName.add(3, "资产期初原值");
			listName.add(4, "本年摊销");
			listName.add(5, "期末余额");

			HSSFWorkbook wb = new HSSFWorkbook();
			String filename = "科研基建支出情况明细表" + DateUtil.dateToStr(new Date(), DateUtil.FMT_DD);
			String beanName = "com.pcitc.base.hana.report.ScientificBaseBuildFee04";
			HSSFSheet sheet = wb.createSheet("Sheet1");
			sheet.setDefaultColumnWidth((short) 12);
			ExcelUtils excel = new ExcelUtils(wb, sheet);
			excel.insertExcelData(beanName, listKey, listName, list, 0);

			try {
				ExcelUtils.responseDownload(response, wb, filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ===========================================科研基建投资支出分析
	 * ===========================================
	 */
	/**
	 * 科研经费综合分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/scientific-funds-all-analysis")
	public String researchanalysis(HttpServletRequest request) {

		return "stp/hana/decision/financial/scientific-funds-all-analysis";
	}

	/**
	 * 全成本综合分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/comprehensive-cost-analysis")
	public String comprehensivedecision(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/decision/financial/comprehensive-cost-analysis";
	}

	/** =====================================科研仪器设备支出分析======================= */

	@RequestMapping(method = RequestMethod.GET, value = "/scientific-instrument-pay-analysis")
	public String scientificInstrumentPayAnalysis(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/scientific-instrument-pay-analysis";
	}

	// 科研仪器设备支出分析-5年支出趋势
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_device_pay_trand")
	@ResponseBody
	public String scientific_device_pay_trand(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_DEVICE_PAY_TRAND, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			List<ScientificInstrumentPay> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificInstrumentPay.class);
			if (list.size() > 0) {

				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "g0ZCMS");
				barLine.setxAxisDataList(xAxisDataList);
				List<String> legendDataList = HanaUtil.getduplicatexAxisByList(list, "g0CALY");
				barLine.setLegendDataList(legendDataList);
				List seriesList = HanaUtil.getScientificInstrumentPayYear(list, legendDataList);
				barLine.setSeriesList(seriesList);
			}
			resultsDate.setSuccess(true);
			resultsDate.setData(barLine);
		} else {
			resultsDate.setSuccess(false);
		}

		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		System.out.println("科研基建支出年度趋势分析 " + result.toString());
		return result.toString();

	}

	// 科研仪器设备支出分析-同比占比分析--按资产类别
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_device_pay_by_type")
	@ResponseBody
	public String scientific_device_pay_by_type(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		if (!month.equals("") && !companyCode.equals("") && !type.equals("")) {

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_DEVICE_PAY_TYPE, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				List<ScientificInstrumentPay> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificInstrumentPay.class);
				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					if (list.size() > 0) {

						// 封装返回对像
						// xAxis data
						List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0ZCMS");
						// legend data
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("本期");
						legendDataList.add("同期");
						legendDataList.add("同比");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_ScientificInstrumentPay(list, "K0BNZCJE");// 本期
						ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_ScientificInstrumentPay(list, "K0SNZCJE");// 同期
						ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_ScientificInstrumentPay(list, "K0TQBL");// 同比
						seriesList.add(s1);
						seriesList.add(s2);
						seriesList.add(s3);
						barLine.setSeriesList(seriesList);
					}
					resultsDate.setSuccess(true);
					resultsDate.setData(barLine);
				} else {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						ScientificInstrumentPay f2 = list.get(i);
						String projectName = f2.getG0ZCMS();
						String k0BNZCJE = f2.getK0BNZCJE();// 本期
						k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
						
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(k0BNZCJE, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					resultsDate.setSuccess(true);
					resultsDate.setData(pie);
				}
			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		if (type.equals("1")) {
			System.out.println(">>>>>>>>>>>>>>>科研仪器支出-按资产类别-同比-分析: " + resultObj.toString());
		} else {
			System.out.println(">>>>>>>>>>>>>>科研仪器支出-按资产类型-占比-分析:" + resultObj.toString());
		}
		return resultObj.toString();

	}

	// 科研仪器设备支出分析-同比占比分析--按研究院
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_device_pay_by_department")
	@ResponseBody
	public String scientific_device_pay_by_department(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String foreachIn = CommonUtil.getParameter(request, "foreachIn", "");
		if (!month.equals("") && !companyCode.equals("") && !type.equals("")) {

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			paramsMap.put("foreachIn", foreachIn);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_DEVICE_PAY_DEPARTMENT, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				List<ScientificInstrumentPay> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificInstrumentPay.class);
				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					if (list.size() > 0) {

						// 封装返回对像
						// xAxis data
						List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0GSJC");
						// legend data
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("本期");
						legendDataList.add("同期");
						legendDataList.add("同比");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_ScientificInstrumentPay(list, "K0BNZCJE");// 本期
						ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_ScientificInstrumentPay(list, "K0SNZCJE");// 同期
						ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_ScientificInstrumentPay(list, "K0TQBL");// 同比
						seriesList.add(s1);
						seriesList.add(s2);
						seriesList.add(s3);
						barLine.setSeriesList(seriesList);
					}
					resultsDate.setSuccess(true);
					resultsDate.setData(barLine);
				} else {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						ScientificInstrumentPay f2 = list.get(i);
						String projectName = f2.getG0GSJC();
						String k0BNZCJE = f2.getK0BNZCJE();// 本期
						k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
						
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(k0BNZCJE, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					resultsDate.setSuccess(true);
					resultsDate.setData(pie);
				}
			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		if (type.equals("1")) {
			System.out.println(">>>>>>>>>>>>>>>科研仪器支出-按研究院-同比-分析: " + resultObj.toString());
		} else {
			System.out.println(">>>>>>>>>>>>>>科研仪器支出-按研究院-占比-分析:" + resultObj.toString());
		}
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/scientific-instrument-pay-analysis-detail")
	public String instrumentAnalysisdetail(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/scientific-instrument-pay-analysis-detail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/scientific-instrument-pay-analysis_detail_list")
	@ResponseBody
	public String ScientificInstrumentPayDetailajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("scientific_base_pay_analysis_detail_list param=   " + JSONObject.toJSONString(param));

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_DEVICE_PAY_DETAIL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		return result.toString();
	}

	@RequestMapping(value = "/scientific-instrument-pay-analysis_detail_excel_out")
	public void scientificInstrumentPayDetailexcelout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScientificInstrumentPayDetail sysLog = new ScientificInstrumentPayDetail();
		String month = request.getParameter("month");
		String companyCode = request.getParameter("companyCode");
		String g0TXT50 = request.getParameter("g0TXT50");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0TXT50", g0TXT50);

		HttpEntity<Map> entity = new HttpEntity<Map>(map, this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(GET_SCIENTIFIC_DEVICE_PAY_DETAIL_EXCEL, HttpMethod.POST, entity, JSONArray.class);
		JSONArray result = responseEntity.getBody();

		if (result != null) {
			List<ScientificInstrumentPayDetail> list = JSON.parseArray(result.toJSONString(), ScientificInstrumentPayDetail.class);
			System.out.println(">>>>>>ScientificInstrumentPayDetail>>>excel-out  list" + list.size());

			// 处理list数据
			List<String> listKey = new ArrayList<String>();

			listKey.add(0, "g0TXT50");
			listKey.add(1, "g0GSJC");
			listKey.add(2, "g0PRCTR");
			listKey.add(3, "g0NCGZYZJE");
			listKey.add(4, "g0LJZCZJJE");
			listKey.add(5, "g0LJGZYZJE");

			List<String> listName = new ArrayList<String>();
			listName.add(0, "资产描述");
			listName.add(1, "公司");
			listName.add(2, "成本中心");
			listName.add(3, "资产期初原值");
			listName.add(4, "本年摊销");
			listName.add(5, "期末余额");

			HSSFWorkbook wb = new HSSFWorkbook();
			String filename = "科研仪器支出情况明细表" + DateUtil.dateToStr(new Date(), DateUtil.FMT_DD);
			String beanName = "com.pcitc.base.hana.report.ScientificInstrumentPayDetail";
			HSSFSheet sheet = wb.createSheet("Sheet1");
			sheet.setDefaultColumnWidth((short) 12);
			ExcelUtils excel = new ExcelUtils(wb, sheet);
			excel.insertExcelData(beanName, listKey, listName, list, 0);

			try {
				ExcelUtils.responseDownload(response, wb, filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * =====================================科研仪器设备支出分析 end
	 * ======================================
	 */

	/** =====================================品牌建设支出分析======================= */

	/**
	 * 品牌建设支出分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/brand-construction-pay-analysis")
	public String brandConstructionPayAnalysis(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/brand-construction-pay-analysis";
	}

	// 品牌建设支出分析-5年支出趋势
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_brand_construction_trand")
	@ResponseBody
	public String scientific_brand_construction_trand(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_RBAND_PAY_TRAND, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			List<BrandConstructionPay> list = JSONObject.parseArray(jSONArray.toJSONString(), BrandConstructionPay.class);
			if (list.size() > 0) {

				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "g0ZCMS");
				barLine.setxAxisDataList(xAxisDataList);
				List<String> legendDataList = HanaUtil.getduplicatexAxisByList(list, "g0CALY");
				barLine.setLegendDataList(legendDataList);
				List seriesList = HanaUtil.getBrandConstructionPayYear(list, legendDataList);
				barLine.setSeriesList(seriesList);
			}
			resultsDate.setSuccess(true);
			resultsDate.setData(barLine);
		} else {
			resultsDate.setSuccess(false);
		}

		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		System.out.println("品牌建设支出年度趋势分析 " + result.toString());
		return result.toString();

	}

	// 品牌建设-同比占比分析--按资产类别
	/*
	 * @RequestMapping(method = RequestMethod.GET, value =
	 * "/scientific_brand_construction_type")
	 * 
	 * @ResponseBody public String
	 * scientific_brand_construction_type(HttpServletRequest
	 * request,HttpServletResponse response) throws Exception { Result
	 * resultsDate = new Result(); String month=CommonUtil.getParameter(request,
	 * "month", ""+DateUtil.dateToStr(new Date(), DateUtil.FMT_MM)); String
	 * companyCode=CommonUtil.getParameter(request, "companyCode", ""); String
	 * type=CommonUtil.getParameter(request, "type", ""); if(!month.equals("")
	 * && !companyCode.equals("")&& !type.equals("")) {
	 * 
	 * Map<String, Object> paramsMap = new HashMap<String, Object>();
	 * paramsMap.put("month", month); paramsMap.put("companyCode", companyCode);
	 * JSONObject jsonObject =
	 * JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
	 * HttpEntity<String> entity = new
	 * HttpEntity<String>(jsonObject.toString(),httpHeaders);
	 * ResponseEntity<JSONArray> responseEntity =
	 * restTemplate.exchange(GET_SCIENTIFIC_RBAND_PAY_TYPE, HttpMethod.POST,
	 * entity, JSONArray.class); int
	 * statusCode=responseEntity.getStatusCodeValue(); if(statusCode==200) {
	 * 
	 * JSONArray jSONArray=responseEntity.getBody(); List<BrandConstructionPay>
	 * list = JSONObject.parseArray(jSONArray.toJSONString(),
	 * BrandConstructionPay.class); if(type.equals("1")) {
	 * ChartBarLineResultData barLine=new ChartBarLineResultData();
	 * if(list.size()>0) {
	 * 
	 * //封装返回对像 //xAxis data List<String>
	 * xAxisDataList=HanaUtil.getxAxisByList(list,"g0ZCMS"); //legend data
	 * List<String> legendDataList=new ArrayList<String>();
	 * legendDataList.add("本期"); legendDataList.add("同期");
	 * legendDataList.add("同比"); barLine.setxAxisDataList(xAxisDataList);
	 * barLine.setLegendDataList(legendDataList); //X轴数据
	 * List<ChartBarLineSeries> seriesList=new ArrayList<ChartBarLineSeries>();
	 * ChartBarLineSeries
	 * s1=HanaUtil.getChartBarLineSeries_BrandConstructionPay(list,
	 * "K0BNJE");//本期 ChartBarLineSeries
	 * s2=HanaUtil.getChartBarLineSeries_BrandConstructionPay(list,
	 * "K0SNJE");//同期 ChartBarLineSeries
	 * s3=HanaUtil.getChartBarLineSeries_BrandConstructionPay(list,
	 * "K0TQBL");//同比 seriesList.add(s1); seriesList.add(s2);
	 * seriesList.add(s3); barLine.setSeriesList(seriesList); }
	 * resultsDate.setSuccess(true); resultsDate.setData(barLine); }else {
	 * ChartPieResultData pie=new ChartPieResultData(); List<ChartPieDataValue>
	 * dataList=new ArrayList<ChartPieDataValue>(); List<String>
	 * legendDataList=new ArrayList<String>(); for(int i=0;i<list.size();i++) {
	 * BrandConstructionPay f2=list.get(i); String projectName=f2.getG0ZCMS();
	 * String k0BNZCJE=f2.getK0BNJE();//本期 legendDataList.add(projectName);
	 * dataList.add(new ChartPieDataValue(k0BNZCJE,projectName)); }
	 * pie.setDataList(dataList); pie.setLegendDataList(legendDataList);
	 * resultsDate.setSuccess(true); resultsDate.setData(pie); } } } JSONObject
	 * resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	 * if(type.equals("1")) {
	 * System.out.println(">>>>>>>>>>>>>>>品牌建设支出-按资产类别-同比-分析: "
	 * +resultObj.toString()); }else {
	 * System.out.println(">>>>>>>>>>>>>>品牌建设支出-按资产类型-占比-分析:"
	 * +resultObj.toString()); } return resultObj.toString();
	 * 
	 * }
	 */

	// 品牌建设支出分析-同比占比分析--按研究院
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_brand_construction_department")
	@ResponseBody
	public String scientific_brand_construction_department(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String foreachIn = CommonUtil.getParameter(request, "foreachIn", "");
		if (!month.equals("") && !companyCode.equals("") && !type.equals("")) {

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			paramsMap.put("foreachIn", foreachIn);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_RBAND_PAY_DEPARTMENT, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				List<BrandConstructionPay> list = JSONObject.parseArray(jSONArray.toJSONString(), BrandConstructionPay.class);
				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					if (list.size() > 0) {

						// 封装返回对像
						// xAxis data
						List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0GSJC");
						// legend data
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("本期");
						legendDataList.add("同期");
						legendDataList.add("同比");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_BrandConstructionPay(list, "K0BNJE");// 本期
						ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_BrandConstructionPay(list, "K0SNJE");// 同期
						ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_BrandConstructionPay(list, "K0TQBL");// 同比
						seriesList.add(s1);
						seriesList.add(s2);
						seriesList.add(s3);
						barLine.setSeriesList(seriesList);
					}
					resultsDate.setSuccess(true);
					resultsDate.setData(barLine);
				} else {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						BrandConstructionPay f2 = list.get(i);
						String projectName = f2.getG0GSJC();
						String k0BNZCJE = f2.getK0BNJE();// 本期
						k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
						
						
						legendDataList.add(projectName);

						dataList.add(new ChartPieDataValue(k0BNZCJE, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					resultsDate.setSuccess(true);
					resultsDate.setData(pie);
				}
			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		if (type.equals("1")) {
			System.out.println(">>>>>>>>>>>>>>>品牌建设支出-按研究院-同比-分析: " + resultObj.toString());
		} else {
			System.out.println(">>>>>>>>>>>>>>品牌建设支出-按研究院-占比-分析:" + resultObj.toString());
		}
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/scientific_brand_construction_detail")
	public String scientific_brand_construction_detail(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/brand_construction_detail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/scientific_brand_construction_detail_list")
	@ResponseBody
	public String scientific_brand_construction_detail_list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		LayuiTableData layuiTableData = new LayuiTableData();

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_RBAND_PAY_DETAIL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>>品牌建设明细:" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/scientific_brand_construction_detail_excel_out")
	public void scientific_brand_construction_detail_excel_out(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScientificInstrumentPayDetail sysLog = new ScientificInstrumentPayDetail();
		String month = request.getParameter("month");
		String companyCode = request.getParameter("companyCode");
		String g0TXT50 = request.getParameter("g0TXT50");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0TXT50", g0TXT50);

		HttpEntity<Map> entity = new HttpEntity<Map>(map, this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(GET_SCIENTIFIC_RBAND_PAY_DETAIL_EXCEL, HttpMethod.POST, entity, JSONArray.class);
		JSONArray result = responseEntity.getBody();

		if (result != null) {
			List<BrandConstructionPay> list = JSON.parseArray(result.toJSONString(), BrandConstructionPay.class);
			System.out.println(">>>>>>ScientificInstrumentPayDetail>>>excel-out  list" + list.size());

			// 处理list数据
			List<String> listKey = new ArrayList<String>();

			listKey.add(0, "g0TXT50");
			listKey.add(1, "g0GSJC");
			listKey.add(2, "g0PRCTR");
			listKey.add(3, "g0NCGZYZJE");
			listKey.add(4, "g0LJZCZJJE");
			listKey.add(5, "g0LJGZYZJE");

			List<String> listName = new ArrayList<String>();
			listName.add(0, "资产描述");
			listName.add(1, "公司");
			listName.add(2, "成本中心");
			listName.add(3, "资产期初原值");
			listName.add(4, "本年摊销");
			listName.add(5, "期末余额");

			HSSFWorkbook wb = new HSSFWorkbook();
			String filename = "品牌建设支出情况明细表" + DateUtil.dateToStr(new Date(), DateUtil.FMT_DD);
			String beanName = "com.pcitc.base.hana.report.ScientificInstrumentPayDetail";
			HSSFSheet sheet = wb.createSheet("Sheet1");
			sheet.setDefaultColumnWidth((short) 12);
			ExcelUtils excel = new ExcelUtils(wb, sheet);
			excel.insertExcelData(beanName, listKey, listName, list, 0);

			try {
				ExcelUtils.responseDownload(response, wb, filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ===================================== 品牌建设 支出分析 end
	 * ======================================
	 */

	/**
	 * ================================================无形资产支出分析================
	 * ======================
	 */

	/**
	 * 无形资产的开发支出分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/invisible-capital-develop-analysis")
	public String invisibleCapitalDevelopAnalysis(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/invisible-capital-develop-analysis";
	}

	// 无形资产支出分析-5年支出趋势
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_invisible_capital_trand")
	@ResponseBody
	public String scientific_invisible_capital_trand(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_TRAND, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			List<InvisibleCapitalDevelop> list = JSONObject.parseArray(jSONArray.toJSONString(), InvisibleCapitalDevelop.class);
			if (list.size() > 0) {

				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "g0ZCMS");
				barLine.setxAxisDataList(xAxisDataList);
				List<String> legendDataList = HanaUtil.getduplicatexAxisByList(list, "g0CALY");
				barLine.setLegendDataList(legendDataList);
				List seriesList = HanaUtil.getInvisibleCapitalDevelopYear(list, legendDataList);
				barLine.setSeriesList(seriesList);
			}
			resultsDate.setSuccess(true);
			resultsDate.setData(barLine);
		} else {
			resultsDate.setSuccess(false);
		}

		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		System.out.println("无形资产支出年度趋势分析 " + result.toString());
		return result.toString();

	}

	// 无形资产-同比占比分析--按资产类别
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_invisible_capital_type")
	@ResponseBody
	public String scientific_invisible_capital_type(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		if (!month.equals("") && !companyCode.equals("") && !type.equals("")) {

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_TYPE, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				List<InvisibleCapitalDevelop> list = JSONObject.parseArray(jSONArray.toJSONString(), InvisibleCapitalDevelop.class);
				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					if (list.size() > 0) {

						// 封装返回对像
						// xAxis data
						List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0ZCMS");
						// legend data
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("本期");
						legendDataList.add("同期");
						legendDataList.add("同比");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_InvisibleCapitalDevelop(list, "K0BNZCJE");// 本期
						ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_InvisibleCapitalDevelop(list, "K0SNZCJE");// 同期
						ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_InvisibleCapitalDevelop(list, "K0TQBL");// 同比
						seriesList.add(s1);
						seriesList.add(s2);
						seriesList.add(s3);
						barLine.setSeriesList(seriesList);
					}
					resultsDate.setSuccess(true);
					resultsDate.setData(barLine);
				} else {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						InvisibleCapitalDevelop f2 = list.get(i);
						String projectName = f2.getG0ZCMS();
						String k0BNZCJE = f2.getK0BNZCJE();// 本期
						
						k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
						
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(k0BNZCJE, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					resultsDate.setSuccess(true);
					resultsDate.setData(pie);
				}
			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		if (type.equals("1")) {
			System.out.println(">>>>>>>>>>>>>>>无形资产支出-按资产类别-同比-分析: " + resultObj.toString());
		} else {
			System.out.println(">>>>>>>>>>>>>>无形资产支出-按资产类型-占比-分析:" + resultObj.toString());
		}
		return resultObj.toString();

	}

	// 无形资产支出分析-同比占比分析--按研究院
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_invisible_capital_department")
	@ResponseBody
	public String scientific_invisible_capital_department(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String type = CommonUtil.getParameter(request, "type", "");
		String foreachIn = CommonUtil.getParameter(request, "foreachIn", "");
		if (!month.equals("") && !companyCode.equals("") && !type.equals("")) {

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			paramsMap.put("foreachIn", foreachIn);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_DEPARTMENT, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				List<InvisibleCapitalDevelop> list = JSONObject.parseArray(jSONArray.toJSONString(), InvisibleCapitalDevelop.class);
				if (type.equals("1")) {
					ChartBarLineResultData barLine = new ChartBarLineResultData();
					if (list.size() > 0) {

						// 封装返回对像
						// xAxis data
						List<String> xAxisDataList = HanaUtil.getxAxisByList(list, "g0GSJC");
						// legend data
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("本期");
						legendDataList.add("同期");
						legendDataList.add("同比");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_InvisibleCapitalDevelop(list, "K0BNZCJE");// 本期
						ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_InvisibleCapitalDevelop(list, "K0SNZCJE");// 同期
						ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_InvisibleCapitalDevelop(list, "K0TQBL");// 同比
						seriesList.add(s1);
						seriesList.add(s2);
						seriesList.add(s3);
						barLine.setSeriesList(seriesList);
					}
					resultsDate.setSuccess(true);
					resultsDate.setData(barLine);
				} else {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						InvisibleCapitalDevelop f2 = list.get(i);
						String projectName = f2.getG0GSJC();
						String k0BNZCJE = f2.getK0BNZCJE();// 本期
						k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(k0BNZCJE, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					resultsDate.setSuccess(true);
					resultsDate.setData(pie);
				}
			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		if (type.equals("1")) {
			System.out.println(">>>>>>>>>>>>>>>无形资产设支出-按研究院-同比-分析: " + resultObj.toString());
		} else {
			System.out.println(">>>>>>>>>>>>>>无形资产支出-按研究院-占比-分析:" + resultObj.toString());
		}
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/scientific_invisible_capital_detail")
	public String scientific_invisible_capital_detail(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/invisible_capital_detail";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/scientific_invisible_capital_detail_list")
	@ResponseBody
	public String scientific_invisible_capital_detail_list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("scientific_invisible_capital_detail_list param=   " + JSONObject.toJSONString(param));

		LayuiTableData layuiTableData = new LayuiTableData();

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_DETAIL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));

		System.out.println(">>>>>>>>>>>>>>无形资产明细:" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/scientific_invisible_capital_detail_excel_out")
	public void scientific_invisible_capital_detail_excel_out(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScientificInstrumentPayDetail sysLog = new ScientificInstrumentPayDetail();
		String month = request.getParameter("month");
		String companyCode = request.getParameter("companyCode");
		String g0TXT50 = request.getParameter("g0TXT50");
		Map map = new HashMap();
		map.put("month", month);
		map.put("companyCode", companyCode);
		map.put("g0TXT50", g0TXT50);

		HttpEntity<Map> entity = new HttpEntity<Map>(map, this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(GET_SCIENTIFIC_INVISIBLE_CAPITAL_PAY_DETAIL_EXCEL, HttpMethod.POST, entity, JSONArray.class);
		JSONArray result = responseEntity.getBody();

		if (result != null) {
			List<InvisibleCapitalDevelop> list = JSON.parseArray(result.toJSONString(), InvisibleCapitalDevelop.class);
			System.out.println(">>>>>>ScientificInstrumentPayDetail>>>excel-out  list" + list.size());

			// 处理list数据
			List<String> listKey = new ArrayList<String>();

			listKey.add(0, "g0TXT50");
			listKey.add(1, "g0GSJC");
			listKey.add(2, "g0PRCTR");
			listKey.add(3, "g0NCGZYZJE");
			listKey.add(4, "g0LJZCZJJE");
			listKey.add(5, "g0LJGZYZJE");

			List<String> listName = new ArrayList<String>();
			listName.add(0, "资产描述");
			listName.add(1, "公司");
			listName.add(2, "成本中心");
			listName.add(3, "资产期初原值");
			listName.add(4, "本年摊销");
			listName.add(5, "期末余额");

			HSSFWorkbook wb = new HSSFWorkbook();
			String filename = "无形资产支出情况明细表" + DateUtil.dateToStr(new Date(), DateUtil.FMT_DD);
			String beanName = "com.pcitc.base.hana.report.ScientificInstrumentPayDetail";
			HSSFSheet sheet = wb.createSheet("Sheet1");
			sheet.setDefaultColumnWidth((short) 12);
			ExcelUtils excel = new ExcelUtils(wb, sheet);
			excel.insertExcelData(beanName, listKey, listName, list, 0);

			try {
				ExcelUtils.responseDownload(response, wb, filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * =====================================无形资产 支出分析 end
	 * ======================================
	 */

	/**
	 * 加计扣除研发费用分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/add-deduction-develop-cost-analysis")
	public String addDeductionDevelopdecision(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/add-deduction-develop-cost-analysis";
	}

	/** ======================================课题研发支出分析======================== */

	/**
	 * 课题研发支出分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/topic-develop-pay-analysis")
	public String topicDevelopPayAnalysis(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/decision/financial/topic-develop-pay-analysis";
	}

	// 课题研发支出分析
	@RequestMapping(method = RequestMethod.GET, value = "/scientific_topic_develop_pot")
	@ResponseBody
	public String scientific_topic_develop_pot(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ChartDotResultData cd = new ChartDotResultData();

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		String foreachIn = CommonUtil.getParameter(request, "foreachIn", "");
		if (!month.equals("") && !companyCode.equals("")) {

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			paramsMap.put("foreachIn", foreachIn);

			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_TOPIC_POT, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				List<ChartDot> dataList = new ArrayList<ChartDot>();
				List<String> legendDataList = new ArrayList<String>();
				List<List> resutlList = new ArrayList<List>();
				JSONArray jSONArray = responseEntity.getBody();
				List<TopicDevelop> list = JSONObject.parseArray(jSONArray.toJSONString(), TopicDevelop.class);
				if (list.size() > 0) {

					legendDataList = HanaUtil.duplicateListVlue(list, "g0XMJD");
					for (int i = 0; i < list.size(); i++) {
						TopicDevelop td = list.get(i);
						ChartDot chartDot = new ChartDot();
						String a = td.getK0LJYSJY();
						String b = td.getK0LJZJSYBL();
						if (a == null || a.equals("")) {
							a = "0";
						}
						if (b == null || b.equals("")) {
							b = "0";
						}
						chartDot.setDotSize(Float.valueOf(a) * Float.valueOf(b) + "");
						chartDot.setxValue(td.getK0ZTYSJE());
						chartDot.setyValue(td.getK0LJZJSYBL());
						chartDot.setName(td.getG0PROJTXT());
						chartDot.setIndexValue(td.getG0XMJD());
						chartDot.setId(td.getG0PROJCODE());
						dataList.add(chartDot);
					}

					if (legendDataList != null && legendDataList.size() > 0) {
						for (int j = 0; j < legendDataList.size(); j++) {
							List<List> three = new ArrayList<List>();
							String legendName = legendDataList.get(j);
							if (dataList != null && dataList.size() > 0) {
								for (int k = 0; k < dataList.size(); k++) {
									ChartDot chartDot = dataList.get(k);
									String str = chartDot.getIndexValue();
									if (legendName.equals(str)) {
										List<String> node = new ArrayList<String>();

										node.add(chartDot.getxValue());
										node.add(chartDot.getyValue());
										node.add(chartDot.getDotSize());
										node.add(chartDot.getName());
										node.add(chartDot.getIndexValue());
										node.add(chartDot.getId());
										three.add(node);
									}

								}

							}
							resutlList.add(three);

						}
					}
				}
				cd.setArrDateList(resutlList);
				cd.setDataList(dataList);
				cd.setLegendDataList(legendDataList);
				resultsDate.setSuccess(true);
				resultsDate.setData(cd);

			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		System.out.println(">>>>>>>>>>>>>>气泡: " + resultObj.toString());
		return resultObj.toString();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/scientific_topic_develop_pot_detail_list")
	@ResponseBody
	public String scientific_topic_develop_pot_detail_list(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("项目明细 param=   " + JSONObject.toJSONString(param));

		LayuiTableData layuiTableData = new LayuiTableData();

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_TOPIC_DETAIL_BY_CODE, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));

		System.out.println(">>>>>>>>>>>>>>课题研发支出分析项目明细:" + result.toString());
		return result.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/scientific_topic_develop_pot_detail_pie")
	@ResponseBody
	public String scientific_topic_develop_pot_detail_pie(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "");
		String type = CommonUtil.getParameter(request, "type", "");
		if (!month.equals("") && !g0PROJCODE.equals("")) {

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("g0PROJCODE", g0PROJCODE);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_SCIENTIFIC_TOPIC_PIE, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				List<TopicDevelop> list = JSONObject.parseArray(jSONArray.toJSONString(), TopicDevelop.class);

				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i < list.size(); i++) {
					TopicDevelop f2 = list.get(i);
					String projectName = f2.getG0WBSTXT();
					String k0BNZCJE = f2.getK0BNSJCBJE();
					k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
					legendDataList.add(projectName);
					dataList.add(new ChartPieDataValue(k0BNZCJE, projectName));
				}
				pie.setDataList(dataList);
				pie.setLegendDataList(legendDataList);
				resultsDate.setSuccess(true);
				resultsDate.setData(pie);
			}
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		System.out.println(">>>>>>>>>>>>>>>课题研发支出: " + resultObj.toString());
		return resultObj.toString();
	}

	/**
	 * ==============================================课题研发支出分析
	 * end===========================================
	 */

	/**
	 * 科技资金现金流分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/scientific-cash-flow-analysis")
	public String scientificCashFlowAnalysis(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		return "stp/hana/decision/financial/scientific-cash-flow-analysis";
	}

}
