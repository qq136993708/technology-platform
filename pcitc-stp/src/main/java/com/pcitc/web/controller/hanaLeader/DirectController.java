package com.pcitc.web.controller.hanaLeader;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.Contract;
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.hana.report.Topic;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/direct")
public class DirectController {
	

    //知识产权--专利
	private static final String getKnowledgeBar_01 = "http://pcitc-zuul/system-proxy/out-patent-provider/lx/apply-agree";
	private static final String getKnowledgeBar_02 = "http://pcitc-zuul/system-proxy/out-patent-provider/institute/type-list";
	private static final String getKnowledgePie = "http://pcitc-zuul/system-proxy/out-patent-provider/institute/lx/apply-agree";
	
	//科研课题
	private static final String topic_01 = "http://pcitc-zuul/system-proxy/out-project-provider/ld/project-info/unit";
	private static final String topic_02 = "http://pcitc-zuul/system-proxy/out-project-provider/project-info/new-old/lx";
	private static final String topic_03 = "http://pcitc-zuul/system-proxy/out-project-provider/tech/type/project-info";
	//合同
	private static final String contract_01 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/complete-rate/total";
	private static final String contract_02 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/complete-rate/old-new";
	private static final String contract_03 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/complete-rate/institute";
	private static final String contract_04 = "http://pcitc-zuul/system-proxy/out-project-provider/project-money/institute";
	
	
	
	@Autowired
	private HttpHeaders httpHeaders;
	@Autowired
	private RestTemplate restTemplate;

	
	/**===================================首页=================================*/
	
	
	/**===================================首页  end=================================*/
	
	
      /**===================================知识产权--专利=================================*/
	  @RequestMapping(method = RequestMethod.GET, value = "/knowledgePatent")
	  public String knowledgePatent(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
		    String unitCode=userInfo.getUnitCode();
		    request.setAttribute("unitCode", unitCode);
		    
		    String year= HanaUtil.getCurrrentYear();
		    request.setAttribute("year", year);
	        return "stp/hana/home/oneLevelMain/direct/knowledgePatent";
	  }
		
		
		
		
		  
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/getKnowledgeBar_01")
		@ResponseBody
		public String getKnowledgeBar_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKnowledgeBar_01, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>getKnowledgeBar_01 jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				
					
						ChartBarLineResultData barLine=new ChartBarLineResultData();
					    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"lxmc");
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
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>>getKnowledgeBar_01 " + resultObj.toString());
			return resultObj.toString();
		}
	
	
	
	
	
	
		
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/getKnowledgeBar_02")
		@ResponseBody
		public String getKnowledgeUnitList_stack(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			String type = CommonUtil.getParameter(request, "type", "");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			paramsMap.put("type", type);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKnowledgeBar_02, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>getKnowledgeBar_02 jSONArray-> " + jSONArray.toString());
						List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
						
						ChartBarLineResultData barLine=new ChartBarLineResultData();
						List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"lx");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
		         		
		         		List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("发明授权");
						legendDataList.add("外观设计");
						legendDataList.add("实用新型");
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries05(list, "fmsqsl");
						seriesList.add(s1);
						ChartBarLineSeries s2 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries05(list, "wgsjsl");
						seriesList.add(s2);
						ChartBarLineSeries s3 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries05(list, "syxxsl");
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
			System.out.println(">>>>>>>>>>>>>>>getKnowledgeBar_02 " + resultObj.toString());
			return resultObj.toString();
		}
	
	
	
	
		@RequestMapping(method = RequestMethod.GET, value = "/getKnowledgePie")
		@ResponseBody
		public String getKnowledgePie(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_ALL);
			String type = CommonUtil.getParameter(request, "type", "1");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKnowledgePie, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>getKnowledgePie jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						Knowledge f2 = list.get(i);
						String name = f2.getLx();
						Integer value =0;
						if(type.equals("1"))
						{
							value =f2.getFmzlApplyCount();
						}
						if(type.equals("2"))
						{                
							value =f2.getSyxxApplyCount();
						}
						if(type.equals("3"))
						{                
							value =f2.getFmzlAgreeCount();
						}
						if(type.equals("4"))
						{                
							value =f2.getSyxxAgreeCount();
						}
						legendDataList.add(name);
						dataList.add(new ChartPieDataValue(value, name));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
	         		result.setSuccess(true);
					result.setData(pie);
				}
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			System.out.println(">>>>>>>>>>>>>>>getKnowledgePie " + resultObj.toString());
			return resultObj.toString();
		}
		
		
		
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/knowledge_04")
		@ResponseBody
		public String knowledge_04(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_ALL);
			String type = CommonUtil.getParameter(request, "type", "1");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKnowledgePie, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>knowledge_04 jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
					if(type.equals("1"))
					{
						ChartBarLineResultData barLine=new ChartBarLineResultData();
						List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"lx");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
		         		
		         		List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("申请总数");
						legendDataList.add("授权总数");
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries06(list, "applyCount");
						seriesList.add(s1);
						ChartBarLineSeries s2 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries06(list, "agreeCount");
						seriesList.add(s2);
						barLine.setSeriesList(seriesList);
		         		result.setSuccess(true);
						result.setData(barLine);
					}
					if(type.equals("2") || type.equals("3"))
					{
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) 
						{
							Knowledge f2 = list.get(i);
							String applyCount = f2.getApplyCount();
							String agreeCount = f2.getAgreeCount();
							
							int value =0;
							if(type.equals("2"))
							{
								value =Integer.valueOf(applyCount).intValue();
							}
							if(type.equals("3"))
							{                
								value =Integer.valueOf(agreeCount).intValue();
							}
							
							legendDataList.add(f2.getLx());
							dataList.add(new ChartPieDataValue(value, f2.getLx()));
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
			System.out.println(">>>>>>>>>>>>>>>knowledge_04 " + resultObj.toString());
			return resultObj.toString();
		}
		
		
		/**==========================================成果数量分析====================================*/
		
		  @RequestMapping(method = RequestMethod.GET, value = "/achievement")
		  public String achievement(HttpServletRequest request) throws Exception
		  {
			    
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    
			    String year= HanaUtil.getCurrrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/oneLevelMain/direct/achievement";
		  }
		  
		  
		  /**==========================================合同签订===================================*/
			
		  @RequestMapping(method = RequestMethod.GET, value = "/contract")
		  public String contract(HttpServletRequest request) throws Exception
		  {
			    
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    
			    String year= HanaUtil.getCurrrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/oneLevelMain/direct/contract";
		  }
		
		  
		    @RequestMapping(method = RequestMethod.GET, value = "/contract_01")
			@ResponseBody
			public String contract_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    	String resault="";
				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				String type = CommonUtil.getParameter(request, "type", "" );
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				paramsMap.put("xmlbbm", "fkyzb");
				
				ChartPieResultData pie = new ChartPieResultData();
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!nd.equals(""))
				{
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_01, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>contract_01 jSONArray-> " + jSONArray.toString());
							List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
							if(type.equals("1"))
							{
								Contract contract=list.get(0);
				         		Integer yqht =(Integer)contract.getYqht();
								Integer wqht = (Integer)contract.getWqht();
								
								ChartSingleLineResultData chartSingleLineResultData = new ChartSingleLineResultData();
								List<String> xAxisDataList = new ArrayList<String>();
								xAxisDataList.add("已签合同");
								xAxisDataList.add("未签合同");
								List<Object> seriesDataList = new ArrayList<Object>();
								seriesDataList.add(yqht);
								seriesDataList.add(wqht);
								
								chartSingleLineResultData.setSeriesDataList(seriesDataList);
								chartSingleLineResultData.setxAxisDataList(xAxisDataList);
								
								
								
				         		result.setSuccess(true);
								result.setData(chartSingleLineResultData);
							}
							if(type.equals("2"))
							{
								
								List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
								List<String> legendDataList = new ArrayList<String>();
								Contract contract=list.get(0);
				         		Integer yqht =(Integer)contract.getYqht();
								Integer wqht = (Integer)contract.getWqht();
								legendDataList.add("已签合同");
								legendDataList.add("未签合同");
								
								dataList.add(new ChartPieDataValue(yqht, "已签合同"));
								dataList.add(new ChartPieDataValue(wqht, "未签合同"));
								
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
				resault=resultObj.toString();
				System.out.println(">>>>>>>>>>>>>>type="+type+"    contract_01 " + resultObj.toString());
				
				return resault;
			}
		
		    
		    @RequestMapping(method = RequestMethod.GET, value = "/contract_02")
			@ResponseBody
			public String contract_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

				PageResult pageResult = new PageResult();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_02, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>>contract_02 jSONArray" + jSONArray.toString());
						
						List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
						List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"define1");
						List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleuContract(lista,list);
						
						pageResult.setData(chartCircleList);
						pageResult.setCode(0);
						pageResult.setCount(Long.valueOf(chartCircleList.size()));
						pageResult.setLimit(1000);
						pageResult.setPage(1l);
						
						
					}
					
				
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
				System.out.println(">>>>>>>>>>>>>>>contract_02 " + resultObj.toString());
				return resultObj.toString();
			}
			
		    
		  
            @RequestMapping(method = RequestMethod.GET, value = "/contract_03")
			@ResponseBody
			public String contract_03(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    	String resault="";
		    	PageResult pageResult = new PageResult();
				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				String type = CommonUtil.getParameter(request, "type", "" );
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!nd.equals(""))
				{
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_03, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>contract_03 jSONArray-> " + jSONArray.toString());
							List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
							if(type.equals("1"))
							{
								ChartBarLineResultData barLine=new ChartBarLineResultData();
								List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
				         		barLine.setxAxisDataList(xAxisDataList);
				         	
				         		List<String> legendDataList = new ArrayList<String>();
								legendDataList.add("计划签订");
								legendDataList.add("实际签订");
								legendDataList.add("签订率");
								barLine.setLegendDataList(legendDataList);
								//X轴数据
								List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
								ChartBarLineSeries s1 = HanaUtil.getContractChartBarLineSeries6(list, "zsl");
								seriesList.add(s1);
								ChartBarLineSeries s2 = HanaUtil.getContractChartBarLineSeries6(list, "yqhtzj");
								seriesList.add(s2);
								ChartBarLineSeries qdlzj = HanaUtil.getContractChartBarLineSeries6(list, "qdlzj");
								seriesList.add(qdlzj);
								barLine.setSeriesList(seriesList);
				         		result.setSuccess(true);
								result.setData(barLine);
							}
							if(type.equals("2"))
							{
								
								
								List<Contract> resutList =addListLine(list);
								pageResult.setData(resutList);
								pageResult.setCode(0);
								pageResult.setCount(Long.valueOf(resutList.size()));
								pageResult.setLimit(1000);
								pageResult.setPage(1l);
							}
							
						
						
					}
					
				} else
				{
					result.setSuccess(false);
					result.setMessage("参数为空");
				}
				if(type.equals("1"))
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>>>>contract_03 " + resultObj.toString());
				}
				else
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>>>>contract_03 " + resultObj.toString());
				}
				
				return resault;
			}
            
            
            
            @RequestMapping(method = RequestMethod.GET, value = "/contract_04")
    		@ResponseBody
    		public String contract_04(HttpServletRequest request, HttpServletResponse response) throws Exception {

    			Result result = new Result();
    			String type = CommonUtil.getParameter(request, "type", "" );
    			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
    			Map<String, Object> paramsMap = new HashMap<String, Object>();
    			paramsMap.put("nd", nd);
    			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
    			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
    			if (!nd.equals(""))
    			{
    				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_04, HttpMethod.POST, entity, JSONArray.class);
    				int statusCode = responseEntity.getStatusCodeValue();
    				if (statusCode == 200) 
    				{
    					JSONArray jSONArray = responseEntity.getBody();
    					System.out.println(">>>>>>>>>>>>>>contract_04 jSONArray-> " + jSONArray.toString());
    					List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
    					if(type.equals("1"))
    					{
    						ChartBarLineResultData barLine=new ChartBarLineResultData();
    					    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
    		         		barLine.setxAxisDataList(xAxisDataList);
    		         	
    						List<String> legendDataList = new ArrayList<String>();
    						legendDataList.add("费用性");
    						legendDataList.add("资本性");
    						barLine.setxAxisDataList(xAxisDataList);
    						barLine.setLegendDataList(legendDataList);
    						// X轴数据
    						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
    						ChartBarLineSeries s1 = HanaUtil.getContractChartBarLineSeries22(list, "fyxRate");
    						seriesList.add(s1);
    						ChartBarLineSeries s2 = HanaUtil.getContractChartBarLineSeries22(list, "zbxRate");
    						seriesList.add(s2);
    						barLine.setSeriesList(seriesList);
    		         		result.setSuccess(true);
    						result.setData(barLine);
    					
    					}else
    					{
    						Map map =new HashMap();
    						int zsl_count=0;
    						int fyxsl_count=0;
    						int zbxsl_count=0;
    						for(int i=0;i<list.size();i++)
    						{
    							Contract contract=list.get(i);
    							Integer fyxsl =(Integer)contract.getFyxsl();
    							Integer zbxsl =(Integer)contract.getZbxsl();
    							Integer zsl =(Integer)contract.getZsl();
    							
    							zsl_count=zsl_count+zsl;
    							fyxsl_count=fyxsl_count+fyxsl;
    							zbxsl_count=zbxsl_count+zbxsl;
    						}
    						
    						DecimalFormat df=new DecimalFormat("0.00");
    						double fyxsl_rate = new BigDecimal((float)fyxsl_count/zsl_count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    						double zbxsl_rate = new BigDecimal((float)zbxsl_count/zsl_count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    						
    						map.put("fyxsl_rate", fyxsl_rate);
    						map.put("zbxsl_rate", zbxsl_rate);
    						result.setSuccess(true);
    						result.setData(map);
    					}
    					
    					
    				}
    				
    			} else
    			{
    				result.setSuccess(false);
    				result.setMessage("参数为空");
    			}
    			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
    			System.out.println(">>>>>>>>>>>>>>>contract_04 " + resultObj.toString());
    			return resultObj.toString();
    		}
    	
    	
            
            
				
			public List<Contract>  addListLine(List<Contract> list)
			{
				List<Contract> resutList =new ArrayList<Contract>();
				//加--总数行
				Contract temp=new Contract();
				temp.setDefine2("总计");
				int zsl_count=0;
				int yqhtzj_count=0;
				for(int i=0;i<list.size();i++)
				{
					Contract contract=list.get(i);
					Integer zsl =(Integer)contract.getZsl();
					Integer yqhtzj =(Integer)contract.getYqhtzj();
					zsl_count=zsl_count+zsl;
					yqhtzj_count=yqhtzj_count+yqhtzj;
					
				}
				temp.setZsl(zsl_count);
				temp.setYqhtzj(yqhtzj_count);
				DecimalFormat df=new DecimalFormat("0.00");
				System.out.println("yqhtzj_count="+yqhtzj_count+"zsl_count="+zsl_count);
				
				
				String str=df.format(((float)yqhtzj_count/zsl_count)*100);
				
				temp.setQdlzj(str);
				resutList.add(temp);
				for(int i=0;i<list.size();i++)
				{
					Contract contract=list.get(i);
					resutList.add(contract);
				}
				return resutList;
			}
		  
		  
		  /**==========================================合同签订 end ================================*/
		  
		  
		  /**=========================================科研课题=================================*/
			
		  @RequestMapping(method = RequestMethod.GET, value = "/topic")
		  public String topic(HttpServletRequest request) throws Exception
		  {
			    
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    
			    String year= HanaUtil.getCurrrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/oneLevelMain/direct/topic";
		  }
		  
		  
		    @RequestMapping(method = RequestMethod.GET, value = "/topic_01")
			@ResponseBody
			public String topic_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    	String resault="";
		    	PageResult pageResult = new PageResult();
				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				String type = CommonUtil.getParameter(request, "type", "" );
				String xmlbbm = CommonUtil.getParameter(request, "xmlbbm", "fkyzb");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				paramsMap.put("xmlbbm", xmlbbm);
				
				
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!nd.equals(""))
				{
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(topic_01, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>topic_01 jSONArray-> " + jSONArray.toString());
							List<Topic> list = JSONObject.parseArray(jSONArray.toJSONString(), Topic.class);
							if(type.equals("1"))
 							{
								ChartBarLineResultData barLine=new ChartBarLineResultData();
								List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
				         		barLine.setxAxisDataList(xAxisDataList);
				         	
				         		List<String> legendDataList = new ArrayList<String>();
								legendDataList.add("新开课题");
								legendDataList.add("转结课题");
								barLine.setLegendDataList(legendDataList);
								// X轴数据
								List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
								ChartBarLineSeries s1 = HanaUtil.getTopicChartBarLineSeries05(list, "xksl");
								seriesList.add(s1);
								ChartBarLineSeries s2 = HanaUtil.getTopicChartBarLineSeries05(list, "xjsl");
								seriesList.add(s2);
								barLine.setSeriesList(seriesList);
				         		result.setSuccess(true);
								result.setData(barLine);
 							}
							if(type.equals("2"))
 							{
								pageResult.setData(list);
								pageResult.setCode(0);
								pageResult.setCount(Long.valueOf(list.size()));
								pageResult.setLimit(1000);
								pageResult.setPage(1l);
 							}
							
						
						
					}
					
				} else
				{
					result.setSuccess(false);
					result.setMessage("参数为空");
				}
				if(type.equals("1"))
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>>>>topic_01 " + resultObj.toString());
				}
				else
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>>>>topic_01 " + resultObj.toString());
				}
				
				return resault;
			}
		
		  
		  
		  
		            @RequestMapping(method = RequestMethod.GET, value = "/topic_02")
		 			@ResponseBody
		 			public String topic_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		            	String resault="";
		 				Result result = new Result();
		 				PageResult pageResult = new PageResult();
		 				String type = CommonUtil.getParameter(request, "type", "" );
		 				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		 				Map<String, Object> paramsMap = new HashMap<String, Object>();
		 				paramsMap.put("nd", nd);
		 				paramsMap.put("xmlbbm", "fkyzb");
		 				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		 				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		 				if (!nd.equals(""))
		 				{
		 					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(topic_02, HttpMethod.POST, entity, JSONArray.class);
		 					int statusCode = responseEntity.getStatusCodeValue();
		 					if (statusCode == 200) 
		 					{
		 						
		 							JSONArray jSONArray = responseEntity.getBody();
		 							System.out.println(">>>>>>>>>>>>>>topic_02 jSONArray-> " + jSONArray.toString());
		 							List<Topic> list = JSONObject.parseArray(jSONArray.toJSONString(), Topic.class);
		 							if(type.equals("1"))
		 							{
		 								ChartBarLineResultData barLine=new ChartBarLineResultData();
			 							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"project_property");
			 			         		barLine.setxAxisDataList(xAxisDataList);
			 			         	
			 			         		List<String> legendDataList = new ArrayList<String>();
			 							legendDataList.add("新开课题");
			 							legendDataList.add("转结课题");
			 							barLine.setLegendDataList(legendDataList);
			 							// X轴数据
			 							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
			 							ChartBarLineSeries s1 = HanaUtil.getTopicChartBarLineSeries05(list, "xksl");
			 							seriesList.add(s1);
			 							ChartBarLineSeries s2 = HanaUtil.getTopicChartBarLineSeries05(list, "xjsl");
			 							seriesList.add(s2);
			 							barLine.setSeriesList(seriesList);
			 			         		result.setSuccess(true);
			 							result.setData(barLine);
		 							}
		 							else
		 							{
		 								pageResult.setData(list);
										pageResult.setCode(0);
										pageResult.setCount(Long.valueOf(list.size()));
										pageResult.setLimit(1000);
										pageResult.setPage(1l);
		 							}
		 						
		 						
		 					}
		 					
		 				} else
		 				{
		 					result.setSuccess(false);
		 					result.setMessage("参数为空");
		 				}
		 				if(type.equals("1"))
						{
							JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
							resault=resultObj.toString();
							System.out.println(">>>>>>>>>>>>>>>topic_02 resault" + resultObj.toString());
						}
						else
						{
							JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
							resault=resultObj.toString();
							System.out.println(">>>>>>>>>>>>>>>topic_02 resault " + resultObj.toString());
						}
		 				return resault;
		 			}
		 		
		  

		            @RequestMapping(method = RequestMethod.GET, value = "/topic_03")
		 			@ResponseBody
		 			public String topic_03(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 				Result result = new Result();
		 				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		 				Map<String, Object> paramsMap = new HashMap<String, Object>();
		 				paramsMap.put("nd", nd);
		 				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		 				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		 				if (!nd.equals(""))
		 				{
		 					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(topic_03, HttpMethod.POST, entity, JSONArray.class);
		 					int statusCode = responseEntity.getStatusCodeValue();
		 					if (statusCode == 200) 
		 					{
		 						
		 							JSONArray jSONArray = responseEntity.getBody();
		 							System.out.println(">>>>>>>>>>>>>>topic_03 jSONArray-> " + jSONArray.toString());
		 							List<Topic> list = JSONObject.parseArray(jSONArray.toJSONString(), Topic.class);
		 							
		 							ChartBarLineResultData barLine=new ChartBarLineResultData();
		 							List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define5");
		 			         		barLine.setxAxisDataList(xAxisDataList);
		 			         	
		 			         		List<String> legendDataList = new ArrayList<String>();
		 							legendDataList.add("新开课题");
		 							legendDataList.add("转结课题");
		 							barLine.setLegendDataList(legendDataList);
		 							// X轴数据
		 							List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
		 							ChartBarLineSeries s1 = HanaUtil.getTopicChartBarLineSeries05(list, "xksl");
		 							seriesList.add(s1);
		 							ChartBarLineSeries s2 = HanaUtil.getTopicChartBarLineSeries05(list, "xjsl");
		 							seriesList.add(s2);
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
		 				System.out.println(">>>>>>>>>>>>>>>topic_03 " + resultObj.toString());
		 				return resultObj.toString();
		 			}
		 		
		  
		  /**=========================================科研装备课题=================================*/
			
		  
		  
		  
		  @RequestMapping(method = RequestMethod.GET, value = "/equipment")
		  public String equipment(HttpServletRequest request) throws Exception
		  {
			    
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    
			    String year= HanaUtil.getCurrrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/oneLevelMain/direct/equipment";
		  }
		  
		  
		  @RequestMapping(method = RequestMethod.GET, value = "/equipment_01")
			@ResponseBody
			public String equipment_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    	String resault="";
		    	PageResult pageResult = new PageResult();
				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				String type = CommonUtil.getParameter(request, "type", "" );
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				paramsMap.put("xmlbbm", "kyzb");
				
				
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!nd.equals(""))
				{
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(topic_01, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>equipment_01 jSONArray-> " + jSONArray.toString());
							List<Topic> list = JSONObject.parseArray(jSONArray.toJSONString(), Topic.class);
							if(type.equals("1"))
							{
								ChartBarLineResultData barLine=new ChartBarLineResultData();
								List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
				         		barLine.setxAxisDataList(xAxisDataList);
				         	
				         		List<String> legendDataList = new ArrayList<String>();
								legendDataList.add("新开课题");
								legendDataList.add("转结课题");
								barLine.setLegendDataList(legendDataList);
								// X轴数据
								List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
								ChartBarLineSeries s1 = HanaUtil.getTopicChartBarLineSeries05(list, "xksl");
								seriesList.add(s1);
								ChartBarLineSeries s2 = HanaUtil.getTopicChartBarLineSeries05(list, "xjsl");
								seriesList.add(s2);
								barLine.setSeriesList(seriesList);
				         		result.setSuccess(true);
								result.setData(barLine);
							}
							if(type.equals("2"))
							{
								pageResult.setData(list);
								pageResult.setCode(0);
								pageResult.setCount(Long.valueOf(list.size()));
								pageResult.setLimit(1000);
								pageResult.setPage(1l);
							}
							
						
						
					}
					
				} else
				{
					result.setSuccess(false);
					result.setMessage("参数为空");
				}
				if(type.equals("1"))
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>>>>equipment_01 " + resultObj.toString());
				}
				else
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>>>>equipment_01 " + resultObj.toString());
				}
				
				return resault;
			}
		  
		  /**=========================================科研实际支出=================================*/
			
		  @RequestMapping(method = RequestMethod.GET, value = "/actualPay")
		  public String actualPay(HttpServletRequest request) throws Exception
		  {
			    
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    
			    String year= HanaUtil.getCurrrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/oneLevelMain/direct/actualPay";
		  }
		  
		  
		  
		 

}
