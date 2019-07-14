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
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.Award;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class HomeAchievementLDController extends BaseController {

	// 知识产权
	private static final String getAwardTypeList = "http://pcitc-zuul/system-proxy/out-appraisal-provider/result-count";
	private static final String getAwardUnitList = "http://pcitc-zuul/system-proxy/out-appraisal-provider/type/result-count";
	private static final String getAwardUnitTypeList = "http://pcitc-zuul/system-proxy/out-appraisal-provider/zy/result-count";
	private static final String getAwardTable = "http://pcitc-zuul/system-proxy/out-provider/appraisal-list";

	private static final String get_unit_result_count = "http://pcitc-zuul/system-proxy/out-appraisal-provider/unit/result-count";
	private static final String get_institution_result_count = "http://pcitc-zuul/system-proxy/out-appraisal-provider/institution/result-count";

	/**
	 * =====================================成果奖励二级页面============================
	 * ===
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/home_achievement_ld/award_level2")
	public String award_level2(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);

		return "stp/hana/home/oneLevelMain/award_level2";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_achievement_ld/award_table")
	public String award_table(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);

		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);

		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);
		return "stp/hana/home/direct_depart/award_table";
	}

	// 三级表格
	@RequestMapping(method = RequestMethod.POST, value = "/home_achievement_ld/getAwardTable")
	@ResponseBody
	public String getAwardLevel3TAble(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

		JSONObject tt = JSONObject.parseObject(JSONObject.toJSONString(param));

		System.out.println(">>>>>>>>>>>>>getAwardTable参数 :" + tt.toString());
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getAwardTable, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>getAwardTable:" + result.toString());
		return result.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_achievement_ld/getAwardTypeList")
	@ResponseBody
	public String getAwardTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();

		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");

		System.out.println(">>>>>>>>>>>>>getAwardTypeList参数 nd :" + nd + " type=" + type);

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("type", type);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getAwardTypeList, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getAwardTypeList type=" + type + "jSONArray-> " + jSONArray.toString());
				List<Award> list = JSONObject.parseArray(jSONArray.toJSONString(), Award.class);
				if (type.equals("1")) {
					ChartSingleLineResultData csr = new ChartSingleLineResultData();
					List<String> xAxisDataList = new ArrayList();
					List<Object> seriesDataList = new ArrayList<Object>();
					for (int i = 0; i < list.size(); i++) {
						Award award = list.get(i);
						xAxisDataList.add(award.getMs());
						seriesDataList.add(award.getMscount());

					}
					csr.setSeriesDataList(seriesDataList);
					csr.setxAxisDataList(xAxisDataList);
					result.setSuccess(true);
					result.setData(csr);
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>getAwardTypeList 1结果 " + resultObj.toString());
				}
				if (type.equals("2")) {

					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						Award f2 = list.get(i);
						String projectName = f2.getMs();
						String apply = f2.getMscount();
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(apply, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					result.setSuccess(true);
					result.setData(pie);
				}

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));

		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_achievement_ld/getAwardCircle")
	@ResponseBody
	public String getAwardCircle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PageResult pageResult = new PageResult();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("type", type);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getAwardUnitList, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>getAwardCircle jSONArray  " + jSONArray.toString());

			List<Award> list = JSONObject.parseArray(jSONArray.toJSONString(), Award.class);
			List<String> lista = HanaUtil.getduplicatexAxisByList(list, "cglx");

			List<TreeNode2> chartCircleList = HanaUtil.getChildChartCircleAward02type(lista, list);

			pageResult.setData(chartCircleList);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(chartCircleList.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getAwardCircle " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_achievement_ld/get_unit_result_count")
	@ResponseBody
	public String get_unit_result_count(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();

		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");

		System.out.println(">>>>>>>>>>>>>get_unit_result_count参数 nd :" + nd + " type=" + type);

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("type", type);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(get_unit_result_count, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>get_unit_result_count type=" + type + "jSONArray-> " + jSONArray.toString());
				List<Award> list = JSONObject.parseArray(jSONArray.toJSONString(), Award.class);
				if (type.equals("1")) {
					ChartSingleLineResultData csr = new ChartSingleLineResultData();
					List<String> xAxisDataList = new ArrayList();
					List<Object> seriesDataList = new ArrayList<Object>();
					for (int i = 0; i < list.size(); i++) {
						Award award = list.get(i);
						xAxisDataList.add(award.getUnitType());
						seriesDataList.add(Integer.valueOf(award.getMscount()));

					}
					csr.setSeriesDataList(seriesDataList);
					csr.setxAxisDataList(xAxisDataList);
					result.setSuccess(true);
					result.setData(csr);
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>get_unit_result_count 结果 " + resultObj.toString());

				}
				if (type.equals("2")) {
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						Award f2 = list.get(i);
						String projectName = f2.getUnitType();
						String apply = f2.getMscount();
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(apply, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					result.setSuccess(true);
					result.setData(pie);
				}

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));

		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_achievement_ld/get_institution_result_count")
	@ResponseBody
	public String get_institution_result_count(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();

		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));

		System.out.println(">>>>>>>>>>>>>get_institution_result_count参数 nd :" + nd);

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(get_institution_result_count, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>get_institution_result_count jSONArray-> " + jSONArray.toString());
				List<Award> list = JSONObject.parseArray(jSONArray.toJSONString(), Award.class);

				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i < list.size(); i++) {
					Award f2 = list.get(i);
					String projectName = f2.getUnitType();
					String apply = f2.getMscount();
					legendDataList.add(projectName);
					dataList.add(new ChartPieDataValue(apply, projectName));
				}
				pie.setDataList(dataList);
				pie.setLegendDataList(legendDataList);
				result.setSuccess(true);
				result.setData(pie);

				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println(">>>>>>>>>>>>>>get_institution_result_count 结果 " + resultObj.toString());

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));

		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/home_achievement_ld/getAwardUnitTypeList")
	@ResponseBody
	public String getAwardUnitTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String type = CommonUtil.getParameter(request, "type", "");
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));

		System.out.println(">>>>>>>>>>>>>getAwardUnitTypeList参数 nd :" + nd + " type=" + type);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getAwardUnitTypeList, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>getAwardUnitTypeList jSONArray-> " + jSONArray.toString());
				List<Award> list = JSONObject.parseArray(jSONArray.toJSONString(), Award.class);

				ChartBarLineResultData barLine = new ChartBarLineResultData();
				List<String> legendDataList = HanaUtil.getduplicatexAxisByList(list, "jdjg");
				barLine.setLegendDataList(legendDataList);
				List<String> xAxisDataList = new ArrayList();
				xAxisDataList.add("A.石油勘探");
				xAxisDataList.add("B.石油开发");
				xAxisDataList.add("C.石油工程");
				xAxisDataList.add("D.石油炼制");
				xAxisDataList.add("E.化工");
				xAxisDataList.add("F.化纤");
				xAxisDataList.add("G.装备与储运");
				xAxisDataList.add("H.安全与环保");
				xAxisDataList.add("I.信息技术");
				xAxisDataList.add("J.大型装备国产化");
				xAxisDataList.add("K.其它");
				barLine.setxAxisDataList(xAxisDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				ChartBarLineSeries s1 = HanaUtil.getAwardELevel2ChartBarLineSeries(list, "国内先进");
				seriesList.add(s1);
				ChartBarLineSeries s2 = HanaUtil.getAwardELevel2ChartBarLineSeries(list, "国内领先");
				seriesList.add(s2);

				ChartBarLineSeries s3 = HanaUtil.getAwardELevel2ChartBarLineSeries(list, "国际先进");
				seriesList.add(s3);
				ChartBarLineSeries s4 = HanaUtil.getAwardELevel2ChartBarLineSeries(list, "国际领先");
				seriesList.add(s4);

				ChartBarLineSeries s5 = HanaUtil.getAwardELevel2ChartBarLineSeries(list, "行业先进");
				seriesList.add(s5);
				ChartBarLineSeries s6 = HanaUtil.getAwardELevel2ChartBarLineSeries(list, "行业领先");
				seriesList.add(s6);
				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);

			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>getAwardUnitTypeList 结果 " + resultObj.toString());
		return resultObj.toString();
	}

}
