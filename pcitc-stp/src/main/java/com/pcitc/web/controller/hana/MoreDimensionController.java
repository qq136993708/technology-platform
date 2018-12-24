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
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

/**
 * 多维 分析
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/more-dimension")
public class MoreDimensionController extends BaseController
{

	private static final String patent_trend_analysis_01 = "http://pcitc-zuul/system-proxy/out-decision-provider/zscq/patent-count/country-type";
	private static final String patent_trend_analysis_02 = "http://pcitc-zuul/system-proxy/out-decision-provider/zscq/patent-count/patent-type";
	private static final String patent_trend_analysis_institute = "http://pcitc-zuul/system-proxy/out-decision-provider/zscq/patent-count/institute";
	private static final String zlsbqkmxfxb_data = "http://pcitc-zuul/system-proxy/out-decision-provider/zscq/patent-detail/page";
	
	//辅助决策中心》多维分析》知识产权》知识产权分析
	//专利授权数量年趋势分析
	private static final String zlsqslnqsfx_data = "http://pcitc-zuul/system-proxy/out-decision-provider/patent/home-baroad/three-year";
	
	
	
	@Autowired
	private HttpHeaders httpHeaders;

	@Autowired
	private RestTemplate restTemplate;

	// 课题研发支出多维分析表
	@RequestMapping(method = RequestMethod.GET, value = "/ktyfzcdwfxb")
	public String ktyfzcdwfxb(HttpServletRequest request) throws Exception
	{
		String month = HanaUtil.getCurrrent_YearMoth();
		request.setAttribute("month", month);
		return "stp/hana/moreDimension/ktyfzcdwfxb";
	}

	// 专利申报情况明细分析表
	@RequestMapping(method = RequestMethod.GET, value = "/zlsbqkmxfxb")
	public String zlsbqkmxfxb(HttpServletRequest request) throws Exception
	{
		String month = HanaUtil.getCurrrent_YearMoth();
		request.setAttribute("month", month);
		return "stp/hana/moreDimension/zlsbqkmxfxb";
	}

	// 三级表格
	@RequestMapping(method = RequestMethod.POST, value = "/zlsbqkmxfxb_data")
	@ResponseBody
	public String zlsbqkmxfxb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
	{

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(zlsbqkmxfxb_data, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>zlsbqkmxfxb_data:" + result.toString());
		return result.toString();
	}

	// 专利申请授权情况明细分析表
	@RequestMapping(method = RequestMethod.GET, value = "/zlsqsqqkmxfxb")
	public String zlsqsqqkmxfxb(HttpServletRequest request) throws Exception
	{
		String month = HanaUtil.getCurrrent_YearMoth();
		request.setAttribute("month", month);
		return "stp/hana/moreDimension/zlsqsqqkmxfxb";
	}

	// 成果鉴定明细分析表
	@RequestMapping(method = RequestMethod.GET, value = "/cgjdmxfxb")
	public String cgjdmxfxb(HttpServletRequest request) throws Exception
	{
		String month = HanaUtil.getCurrrent_YearMoth();
		request.setAttribute("month", month);
		return "stp/hana/moreDimension/cgjdmxfxb";
	}

	// 科技奖励情况明细分析表
	@RequestMapping(method = RequestMethod.GET, value = "/kjjlqkmxfxb")
	public String kjjlqkmxfxb(HttpServletRequest request) throws Exception
	{
		String month = HanaUtil.getCurrrent_YearMoth();
		request.setAttribute("month", month);
		return "stp/hana/moreDimension/kjjlqkmxfxb";
	}

	/**
	 * 知识产权分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/knowledge/patent-trend-analysis")
	public String loopContractExecutionAwards(HttpServletRequest request) throws Exception
	{

		List<String> yearList = HanaUtil.getBeforeYearList(HanaUtil.getCurrrentYear(), 3);
		request.setAttribute("yearList", yearList);
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		return "stp/hana/moreDimension/knowledge/patent-trend-analysis";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patent_trend_analysis_01")
	@ResponseBody
	public String patent_trend_analysis_01(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals(""))
		{
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(zlsqslnqsfx_data, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>patent_trend_analysis jSONArray-> " + jSONArray.toString());
				List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				//List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "showName");
				//barLine.setxAxisDataList(xAxisDataList);
				List<String> xAxisDataList = new ArrayList<String>();
				xAxisDataList.add("专利总数");
				xAxisDataList.add("国内专利");
				xAxisDataList.add("国外专利");
				
				List<String> yearList = HanaUtil.getBeforeYearList(HanaUtil.getCurrrentYear(), 3);
				List<String> legendDataList = yearList;
				barLine.setxAxisDataList(xAxisDataList);
				barLine.setLegendDataList(legendDataList);
				// X轴数据
				List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
				for (int i = 0; i < yearList.size(); i++)
				{
					String str = yearList.get(i);
					List<Object> dt = new ArrayList<Object>();
					dt.add(123);
					dt.add(123);
					dt.add(123);
					ChartBarLineSeries s1 = new ChartBarLineSeries();//HanaUtil.getChartBarLineSeries_knowledet_bar_year(list, str, yearList);
					
					s1.setName(str);
					s1.setData(dt);
					seriesList.add(s1);
				}

				barLine.setSeriesList(seriesList);
				result.setSuccess(true);
				result.setData(barLine);
			}

		}
		else
		{
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>patent_trend_analysis 结果" + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patent_trend_analysis_02")
	@ResponseBody
	public String patent_trend_analysis_02(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals(""))
		{
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(patent_trend_analysis_02, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>patent_trend_analysis_02_pie jSONArray-> " + jSONArray.toString());
				List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i < list.size(); i++)
				{
					Knowledge f2 = list.get(i);
					String name = f2.getTypeName();
					Integer value = f2.getSl();
					legendDataList.add(name);
					dataList.add(new ChartPieDataValue(value, name));

				}
				pie.setDataList(dataList);
				pie.setLegendDataList(legendDataList);
				result.setSuccess(true);
				result.setData(pie);
			}

		}
		else
		{
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>patent_trend_analysis_02_pie " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/patent_trend_analysis_institute")
	@ResponseBody
	public String patent_trend_analysis_institute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		Result result = new Result();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals(""))
		{
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(patent_trend_analysis_institute, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>patent_trend_analysis_institute jSONArray-> " + jSONArray.toString());
				List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				ChartPieResultData pie = new ChartPieResultData();
				List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
				List<String> legendDataList = new ArrayList<String>();
				for (int i = 0; i < list.size(); i++)
				{
					Knowledge f2 = list.get(i);
					String name = f2.getUnitName();
					Integer value = f2.getSl();
					legendDataList.add(name);
					dataList.add(new ChartPieDataValue(value, name));
				}
				pie.setDataList(dataList);
				pie.setLegendDataList(legendDataList);
				result.setSuccess(true);
				result.setData(pie);
			}

		}
		else
		{
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>patent_trend_analysis_institute " + resultObj.toString());
		return resultObj.toString();
	}

	/**
	 * 项目成果年度趋势分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/achievements/trend-analysis")
	public String loopContractExecutionAchievements(HttpServletRequest request) throws Exception
	{
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/moreDimension/achievement/achievements-trend-analysis";
	}

	/**
	 * 多维分析-成果鉴定涉及项目分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/achievements/project-analysis")
	public String achievementsproject(HttpServletRequest request) throws Exception
	{

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/moreDimension/achievement/achievements-project-analysis";
	}

	/**
	 * 成果鉴定涉及专利专家分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/achievements/patent-analysis")
	public String achievementpatent(HttpServletRequest request) throws Exception
	{

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/moreDimension/achievement/achievements-patent-analysis";
	}

	/**
	 * 科技奖励年度趋势分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/science/trend-analysis")
	public String science(HttpServletRequest request) throws Exception
	{

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/moreDimension/science/science-trend-analysis";
	}

	/**
	 * 科技奖励涉及项目分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/science/project-analysis")
	public String scienceproject(HttpServletRequest request) throws Exception
	{

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/moreDimension/science/science-project-analysis";
	}

	/**
	 * 科技奖励涉及专利专家分析
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/science/patent-analysis")
	public String sciencepatent(HttpServletRequest request) throws Exception
	{

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		List<ProjectCode> projectCodeList = HanaUtil.getProjectCode(restTemplate, httpHeaders);
		request.setAttribute("projectCodeList", projectCodeList);
		return "stp/hana/moreDimension/science/science-patent-analysis";
	}

}
