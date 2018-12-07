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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.AchievementsAnalysis;
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/direct_second")
public class DirectSecondController  extends BaseController
{
	
	private static final String ACHIEVEMENT_ANALYSIS = "http://pcitc-zuul/system-proxy/out-appraisal-provider/institution/cg/info";

	/**
	 *    领导二级页面，各个研究院的成果情况 汇总
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/direct_second_total_byunit")
	@ResponseBody
	public String getKnowledgeBar_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		
		System.out.println(JSON.toJSONString(paramsMap));
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(paramsMap, httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(ACHIEVEMENT_ANALYSIS, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) 
		{
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>>>getKnowledgeBar_01 jSONArray-> " + jSONArray.toString());
			List<AchievementsAnalysis> list = JSONObject.parseArray(jSONArray.toJSONString(), AchievementsAnalysis.class);
		
			List<Knowledge> viewList = new ArrayList<Knowledge>();
			for(AchievementsAnalysis analysis:list) {
				Knowledge k = new Knowledge();
				k.setSl(analysis.getSl());
			}
			
			
			
			ChartBarLineResultData barLine=new ChartBarLineResultData();
		    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"sl");
     		barLine.setxAxisDataList(xAxisDataList);
     	
			List<String> legendDataList = new ArrayList<String>();
			legendDataList.add("专利申请");
			legendDataList.add("专利授权");
			barLine.setxAxisDataList(xAxisDataList);
			barLine.setLegendDataList(legendDataList);
			// X轴数据
			List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
			ChartBarLineSeries s1 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries(viewList, "sl");
			seriesList.add(s1);
			
			barLine.setSeriesList(seriesList);
     		result.setSuccess(true);
			result.setData(barLine);
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>getKnowledgeBar_01 " + resultObj.toString());
		return resultObj.toString();
	}

}
