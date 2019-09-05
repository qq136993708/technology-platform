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
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class HomeKnowledgeController extends BaseController{
	
			
	//知识产权
		private static final String getKnowledgeTypeList = "http://pcitc-zuul/system-proxy/out-patent-provider/type/apply-agree-list";
		private static final String getKnowledgeUnitList = "http://pcitc-zuul/system-proxy/out-patent-provider/institute/type-list";
		private static final String getUnitTypeList = "http://pcitc-zuul/system-proxy/out-patent-provider/unit-type/apply-agree-list";
		private static final String getKnowledgeTable = "http://pcitc-zuul/system-proxy/out-patent-provider/type/unit/details";
		
	
	
	
    /**=====================================成果奖励二级页面===============================*/
		
		@RequestMapping(method = RequestMethod.GET, value = "/home_knowledge/knowledge_level2")
		  public String knowledge_level2(HttpServletRequest request) throws Exception
		  {
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    String nd= HanaUtil.getCurrentYear();
			    request.setAttribute("nd", nd);
		        return "stp/hana/home/level/knowledge_level2";
		  }
		
		 @RequestMapping(method = RequestMethod.GET, value = "/home_knowledge/knowledge_table")
		  public String knowledge_table(HttpServletRequest request) throws Exception
		  {
			    
				
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    /*//项目类型:G0XMGLLX ,项目来源:G0XMGLLY,管理级别:G0XMGLJB,项目类别:G0XMLX,项目状态:G0XMZT
			    List<ProjectCode> G0XMGLLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLX");
			    List<ProjectCode> G0XMGLLY_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLLY");
			    List<ProjectCode> G0XMGLJB_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMGLJB");
			    List<ProjectCode> G0XMLX_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMLXMS");
			    List<ProjectCode> G0XMZT_LIST=HanaUtil.getBaseCode(restTemplate, httpHeaders, month, "G0XMZTMS");
			    
			    request.setAttribute("G0XMGLLX_LIST", G0XMGLLX_LIST);
			    request.setAttribute("G0XMGLLY_LIST", G0XMGLLY_LIST);
			    request.setAttribute("G0XMGLJB_LIST", G0XMGLJB_LIST);
			    request.setAttribute("G0XMLX_LIST", G0XMLX_LIST);
			    request.setAttribute("G0XMZT_LIST", G0XMZT_LIST);*/
			    
			    
			    String year= HanaUtil.getCurrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/level/knowledge_table";
		  }
		
		    //三级表格
		    @RequestMapping(method = RequestMethod.POST, value = "/home_knowledge/getKnowledgeTable")
			@ResponseBody
			@OperationFilter(dataFlag = "true")
			public String getKnowledgeLevel3TAble(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

				JSONObject tt = JSONObject.parseObject(JSONObject.toJSONString(param));
				//System.out.println(">>>>>>>>>>>>>getKnowledgeTable参数 :" + tt.toString());
				LayuiTableData layuiTableData = new LayuiTableData();
				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getKnowledgeTable, HttpMethod.POST, entity, LayuiTableData.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					layuiTableData = responseEntity.getBody();
				}
				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
				//System.out.println(">>>>>>>>>>>>>getKnowledgeTable:" + result.toString());
				return result.toString();
			}
		
		   
			
			
		@RequestMapping(method = RequestMethod.GET, value = "/home_knowledge/getKnowledgeTypeList")
		@ResponseBody
		@OperationFilter(dataFlag = "true")
		public String getKnowledgeTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
			Result result = new Result();
			
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			String type = CommonUtil.getParameter(request, "type", "");
			String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			paramsMap.put("type", type);
			paramsMap.put("zycmc", zycmc);
			paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());	// 领导标识
			
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKnowledgeTypeList, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					JSONArray jSONArray = responseEntity.getBody();
				    //System.out.println(">>>>>>>>>>>>>>getKnowledgeTypeList jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				
					if(type.equals("1"))
					{
						ChartBarLineResultData barLine=new ChartBarLineResultData();
							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"WXLX");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("专利申请");
						legendDataList.add("专利授权");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries(list, "applyCount");
						seriesList.add(s1);
						ChartBarLineSeries s2 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries(list, "agreeCount");
						seriesList.add(s2);
						barLine.setSeriesList(seriesList);
		         		result.setSuccess(true);
						result.setData(barLine);
					}
					if(type.equals("2"))
					{
						
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) {
							Knowledge f2 = list.get(i);
							String projectName = f2.getWXLX();
							String apply = f2.getApplyCount();
							legendDataList.add(projectName);
							dataList.add(new ChartPieDataValue(apply, projectName));
						}
						pie.setDataList(dataList);
						pie.setLegendDataList(legendDataList);
						result.setSuccess(true);
						result.setData(pie);
					}
					if(type.equals("3"))
					{
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) {
							Knowledge f2 = list.get(i);
							String projectName = f2.getWXLX();
							String apply = f2.getAgreeCount();
							legendDataList.add(projectName);
							dataList.add(new ChartPieDataValue(apply, projectName));
						}
						pie.setDataList(dataList);
						pie.setLegendDataList(legendDataList);
						result.setSuccess(true);
						result.setData(pie);
					}
					
				}
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			//System.out.println(">>>>>>>>>>>>>>getKnowledgeTypeList " + resultObj.toString());
			return resultObj.toString();
		}
		
		
		
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/home_knowledge/getUnitTypeList")
		@ResponseBody
		@OperationFilter(dataFlag = "true")
		public String getUnitTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			String type = CommonUtil.getParameter(request, "type", "");
			String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			paramsMap.put("type", type);
			paramsMap.put("zycmc", zycmc);
			paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());	// 领导标识
			
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getUnitTypeList, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					////System.out.println(">>>>>>>>>>>>>>getUnitTypeList jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				
					if(type.equals("1"))
					{
						ChartBarLineResultData barLine=new ChartBarLineResultData();
					    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"unitType");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("专利申请");
						legendDataList.add("专利授权");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries(list, "applyCount");
						seriesList.add(s1);
						ChartBarLineSeries s2 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries(list, "agreeCount");
						seriesList.add(s2);
						barLine.setSeriesList(seriesList);
		         		result.setSuccess(true);
						result.setData(barLine);
					}
					if(type.equals("2"))
					{
						
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) {
							Knowledge f2 = list.get(i);
							String projectName = f2.getUnitType();
							String apply = f2.getApplyCount();
							legendDataList.add(projectName);
							dataList.add(new ChartPieDataValue(apply, projectName));
						}
						pie.setDataList(dataList);
						pie.setLegendDataList(legendDataList);
						result.setSuccess(true);
						result.setData(pie);
					}
					if(type.equals("3"))
					{
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) {
							Knowledge f2 = list.get(i);
							String projectName = f2.getUnitType();
							String apply = f2.getAgreeCount();
							legendDataList.add(projectName);
							dataList.add(new ChartPieDataValue(apply, projectName));
						}
						pie.setDataList(dataList);
						pie.setLegendDataList(legendDataList);
						result.setSuccess(true);
						result.setData(pie);
					}
					


				}
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			////System.out.println(">>>>>>>>>>>>>>>getUnitTypeList " + resultObj.toString());
			return resultObj.toString();
		}
	
	
	
	
		//经费下达
		@RequestMapping(method = RequestMethod.GET, value = "/home_knowledge/getKnowledgeUnitList")
		@ResponseBody
		@OperationFilter(dataFlag = "true")
		public String getKnowledgeUnitList(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			String type = CommonUtil.getParameter(request, "type", "");
			String zycmc = request.getAttribute("zycmc")==null ? "" : request.getAttribute("zycmc").toString();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			paramsMap.put("type", type);
			paramsMap.put("zycmc", zycmc);
			paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());	// 领导标识
			
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKnowledgeUnitList, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
						JSONArray jSONArray = responseEntity.getBody();
						//System.out.println(">>>>>>>>>>>>>>getKnowledgeUnitList jSONArray-> " + jSONArray.toString());
						List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
						
						ChartBarLineResultData barLine=new ChartBarLineResultData();
						List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"lx");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("发明专利");
						legendDataList.add("外观设计");
						legendDataList.add("实用新型");
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries02(list, "fmsqsl");
						seriesList.add(s1);
						ChartBarLineSeries s2 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries02(list, "wgsjsl");
						seriesList.add(s2);
						ChartBarLineSeries s3 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries02(list, "syxxsl");
						seriesList.add(s3);
						
						barLine.setSeriesList(seriesList);
		         		result.setSuccess(true);
						result.setData(barLine);
					
					
				}
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			//System.out.println(">>>>>>>>>>>>>>>getKnowledgeUnitList " + resultObj.toString());
			return resultObj.toString();
		}
	
	
	
	
	
	
	
				
	  
	  
	  
}
