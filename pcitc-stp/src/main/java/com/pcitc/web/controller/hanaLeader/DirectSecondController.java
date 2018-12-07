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
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.AchievementsAnalysis;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/direct_second")
public class DirectSecondController  extends BaseController
{
	
	private static final String direct_second_data_01 = "http://pcitc-zuul/system-proxy/out-appraisal-provider/institution/cg/info";
	private static final String direct_second_data_02 = "http://pcitc-zuul/system-proxy/out-appraisal-provider/cglx/cg/info";
	
	

	/**
	 *    领导二级页面，直属研究院成果数量
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/direct_second_data_01")
	@ResponseBody
	public String getDirectSecendData01(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd",DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(paramsMap, httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(direct_second_data_01, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) 
		{
			JSONArray jSONArray = responseEntity.getBody();
			List<AchievementsAnalysis> list = JSONObject.parseArray(jSONArray.toJSONString(), AchievementsAnalysis.class);
		
			
			ChartSingleLineResultData csr = new ChartSingleLineResultData();
			//X轴数据
			List<Object> seriesDataList=new ArrayList<Object>();
			for(AchievementsAnalysis dt:list) {
				seriesDataList.add(dt.getSl());
			}
			csr.setSeriesDataList(seriesDataList);
			//标题
		    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define1");
     		csr.setxAxisDataList(xAxisDataList);
			
     		result.setSuccess(true);
			result.setData(csr);
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		return resultObj.toString();
	}
	/**
	 * 年成果鉴定数量按单位分析
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/direct_second_data_02")
	@ResponseBody
	public String getDirectSecendData02(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd",DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(paramsMap, httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(direct_second_data_02, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) 
		{
			JSONArray jSONArray = responseEntity.getBody();
			List<AchievementsAnalysis> list = JSONObject.parseArray(jSONArray.toJSONString(), AchievementsAnalysis.class);
		
			
			ChartSingleLineResultData csr = new ChartSingleLineResultData();
			//X轴数据
			List<Object> seriesDataList=new ArrayList<Object>();
			for(AchievementsAnalysis dt:list) {
				seriesDataList.add(dt.getSl());
			}
			csr.setSeriesDataList(seriesDataList);
			//成果类型
		    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"cglx");
     		csr.setxAxisDataList(xAxisDataList);
			
     		result.setSuccess(true);
			result.setData(csr);
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		return resultObj.toString();
	}

}
