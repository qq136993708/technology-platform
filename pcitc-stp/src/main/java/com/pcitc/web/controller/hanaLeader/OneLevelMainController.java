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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
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
import com.pcitc.base.hana.report.AchievementsAnalysis;
import com.pcitc.base.hana.report.Contract;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.hana.report.ProjectForMysql;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;


//高层首页
@Controller
@RequestMapping(value = "/one_level_main")
public class OneLevelMainController {
	
	
	
	    //知识产权
		private static final String knowledge_01 = "http://pcitc-zuul/system-proxy/out-patent-provider/lx/apply-agree";
		private static final String knowledge_02 = "http://pcitc-zuul/system-proxy/out-patent-provider/institute/lx/apply-agree";
		private static final String knowledge_pie = "http://pcitc-zuul/system-proxy/out-patent-provider/company-type/apply-agree";
		
		//合同
		private static final String contract_01 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/complete-rate/total";
		private static final String contract_01_01 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/complete-rate/money-type";
		private static final String contract_02 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/complete-rate/company-type";
		private static final String contract_03 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/complete-rate/institute";
		private static final String contract_04 = "http://pcitc-zuul/system-proxy/out-project-provider/project-money/institute";
		private static final String contract_05 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/contract-rate/details";
		
		
		
		
		
		//科技成果
		private static final String achievement_01 = "http://pcitc-zuul/system-proxy/out-appraisal-provider/institution/cg/info";
		private static final String achievement_02 = "http://pcitc-zuul/system-proxy/out-appraisal-provider/cg/count/company-type";
		private static final String achievement_03 = "http://pcitc-zuul/system-proxy/out-appraisal-provider/zy/cg/info";
		private static final String achievement_04 = "http://pcitc-zuul/system-proxy/out-provider/reward-list";
		private static final String achievement_05 = "http://pcitc-zuul/system-proxy/out-provider/reward-year-list";

		//科研装备
		private static final String equipment_01 = "http://pcitc-zuul/hana-proxy/hana/home/get_home_KYZB";
		private static final String equipment_02 = "http://pcitc-zuul/hana-proxy/hana/home/get_home_KYZB_02";
		
		
		
		//十条龙
		private static final String dragon_01 = "http://pcitc-zuul/system-proxy/out-project-provider/dragon/type/project-info";
		private static final String dragon_02 = "http://pcitc-zuul/system-proxy/out-project-provider/dragon/out-in/project-info";
		private static final String getZdstlTable = "http://pcitc-zuul/system-proxy/out-project-provider/ld/project-info/zdstl";
		private static final String dragon_03 = "http://pcitc-zuul/system-proxy/out-project-provider/dragon/institute/project-info";

		
		
		@Autowired
		private HttpHeaders httpHeaders;
		@Autowired
		private RestTemplate restTemplate;

		/**======================高层首页-知识产权==================================*/
			
		@RequestMapping(method = RequestMethod.GET, value = "/knowledge")
		  public String knowledge(HttpServletRequest request) throws Exception
		  {
			    
				
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    
			    String year= HanaUtil.getCurrrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/oneLevelMain/knowledge";
		  }
			
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/knowledge_01")
		@ResponseBody
		public String knowledge_01(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(knowledge_01, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					JSONArray jSONArray = responseEntity.getBody();
				    System.out.println(">>>>>>>>>>>>>>knowledge_01 jSONArray-> " + jSONArray.toString());
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
			System.out.println(">>>>>>>>>>>>>>knowledge_01 type= "+type+" : " + resultObj.toString());
			return resultObj.toString();
		}
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/knowledge_pie")
		@ResponseBody
		public String knowledge_pie(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(knowledge_pie, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					JSONArray jSONArray = responseEntity.getBody();
				    System.out.println(">>>>>>>>>>>>>>knowledge_pie jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				
					
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) {
							Knowledge f2 = list.get(i);
							String projectName = f2.getDefine3();
							Integer value = 0;
							if(type.equals("1"))
							{
								value =f2.getFmzlAgreeCount();
							}
							if(type.equals("2"))
							{
								value =f2.getFmzlApplyCount();
							}
							if(type.equals("3"))
							{
								value =f2.getSyxxAgreeCount();
							}
							if(type.equals("4"))
							{
								value =f2.getSyxxApplyCount();
							}
							
							legendDataList.add(projectName);
							dataList.add(new ChartPieDataValue(value, projectName));
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
			System.out.println(">>>>>>>>>>>>>>knowledge_pie type= "+type+" : " + resultObj.toString());
			return resultObj.toString();
		}
		
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/knowledge_bar_02")
		@ResponseBody
		public String knowledge_bar_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(knowledge_pie, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					JSONArray jSONArray = responseEntity.getBody();
				    System.out.println(">>>>>>>>>>>>>>knowledge_bar_02 jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				
					
					ChartBarLineResultData barLine=new ChartBarLineResultData();
					List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define3");
	         		barLine.setxAxisDataList(xAxisDataList);
	         	
	         		
	         		List<String> legendDataList = new ArrayList<String>();
					legendDataList.add("专利申请");
					legendDataList.add("专利授权");
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
			System.out.println(">>>>>>>>>>>>>>knowledge_bar_02 type= "+type+" : " + resultObj.toString());
			return resultObj.toString();
		}
		

		
		@RequestMapping(method = RequestMethod.GET, value = "/knowledge_02")
		@ResponseBody
		public String knowledge_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(knowledge_02, HttpMethod.POST, entity, JSONArray.class);
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
					ChartBarLineSeries s1 = HanaUtil.getKnowledgeChartBarLineSeries07(list, "fmzlAgreeCount");
					seriesList.add(s1);
					ChartBarLineSeries s2 = HanaUtil.getKnowledgeChartBarLineSeries07(list, "wgsjAgreeCount");
					seriesList.add(s2);
					ChartBarLineSeries s3 = HanaUtil.getKnowledgeChartBarLineSeries07(list, "syxxAgreeCount");
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
			System.out.println(">>>>>>>>>>>>>>>knowledge_03 " + resultObj.toString());
			return resultObj.toString();
		}
	
		/**================================知识产权   end========================================*/
		

		
		
		/**=========================================科研合同===============================*/
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/contract")
		  public String contract(HttpServletRequest request) throws Exception
		  {
			    
				
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    
			    String year= HanaUtil.getCurrrentYear();
			    request.setAttribute("year", year);
		        return "stp/hana/home/oneLevelMain/contract";
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
							Contract contract=list.get(0);
			         		Integer yqht =(Integer)contract.getYqht();
							Integer wqht = (Integer)contract.getWqht();
							Integer zsl = (Integer)contract.getZsl();
							String qdl =((BigDecimal)contract.getQdl()).toString();
							
							if(type.equals("1"))
							{
								
								
								Map map=new HashMap();
								map.put("yqht", yqht);
								map.put("zsl",zsl);
								map.put("qdl", Double.valueOf(qdl));
				         		result.setSuccess(true);
								result.setData(map);
							}
							if(type.equals("2"))
							{
								
								
								Map map2=new HashMap();
								map2.put("name", "签订率");
								map2.put("value",Double.valueOf(qdl));
				         		result.setSuccess(true);
								result.setData(map2);
								
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
		
		    @RequestMapping(method = RequestMethod.GET, value = "/contract_01_01")
			@ResponseBody
			public String contract_01_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_01_01, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>contract_01_01 jSONArray-> " + jSONArray.toString());
							List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
							if(type.equals("1"))
							{
								ChartBarLineResultData barLine=new ChartBarLineResultData();
								List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define1");
				         		barLine.setxAxisDataList(xAxisDataList);
				         		List<String> legendDataList = new ArrayList<String>();
								legendDataList.add("计划合同");
								legendDataList.add("已签合同");
								barLine.setLegendDataList(legendDataList);
								//X轴数据
								List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
								ChartBarLineSeries s1 = HanaUtil.getContractChartBarLineSeries9(list, "jhqds");
								seriesList.add(s1);
								ChartBarLineSeries s2 = HanaUtil.getContractChartBarLineSeries9(list, "sjqds");
								seriesList.add(s2);
								barLine.setSeriesList(seriesList);
				         		result.setSuccess(true);
								result.setData(barLine);
							}
							if(type.equals("2"))
							{
								List<Contract> resutList =addListLine02(list);
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
					System.out.println(">>>>>>>>>>>>>>>contract_01_01 " + resultObj.toString());
				}
				else
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>>>>contract_01_01 " + resultObj.toString());
				}
				
				return resault;
			}
		    
		    public List<Contract>  addListLine02(List<Contract> list)
			{
				List<Contract> resutList =new ArrayList<Contract>();
				//加--总数行
				Contract temp=new Contract();
				temp.setDefine1("总计");
				int jhqds_count=0;
				int sjqds_count=0;
				for(int i=0;i<list.size();i++)
				{
					Contract contract=list.get(i);
					Integer jhqds =(Integer)contract.getJhqds();
					Integer sjqds =(Integer)contract.getSjqds();
					jhqds_count=jhqds_count+jhqds;
					sjqds_count=sjqds_count+sjqds;
				}
				temp.setJhqds(jhqds_count);
				temp.setSjqds(sjqds_count);
				DecimalFormat df=new DecimalFormat("0.00");
				String str=df.format(((float)sjqds_count/jhqds_count)*100);
				temp.setHtqdl(str);
				resutList.add(temp);
				for(int i=0;i<list.size();i++)
				{
					Contract contract=list.get(i);
					resutList.add(contract);
				}
				return resutList;
			}
          
		    @RequestMapping(method = RequestMethod.GET, value = "/contract_02")
			@ResponseBody
			public String contract_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	Result result = new Result();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ChartSingleLineResultData chartSingleLineResultData = new ChartSingleLineResultData();
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_02, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>>contract_02 jSONArray" + jSONArray.toString());
						
						List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
						
						List<String> xAxisDataList = new ArrayList<String>();
						List<Object> seriesDataList = new ArrayList<Object>();
						
						for (int i = 0; i < list.size(); i++) {
							Contract contract = (Contract) list.get(i);
							String define3 = contract.getDefine3();
							Object qdbl =contract.getQdbl();
							String str=String.format("%.2f", Double.valueOf(String.valueOf(qdbl)));
							seriesDataList.add(str);
							xAxisDataList.add(define3);
							
						}
						chartSingleLineResultData.setxAxisDataList(xAxisDataList);
						chartSingleLineResultData.setSeriesDataList(seriesDataList);
						result.setSuccess(true);
						result.setData(chartSingleLineResultData);
					}
					
				
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
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
								legendDataList.add("已签合同");
								legendDataList.add("未签合同");
								barLine.setLegendDataList(legendDataList);
								//X轴数据
								List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
								ChartBarLineSeries s1 = HanaUtil.getContractChartBarLineSeries8(list, "yqhtzj");
								seriesList.add(s1);
								ChartBarLineSeries s2 = HanaUtil.getContractChartBarLineSeries8(list, "wqhtzj");
								seriesList.add(s2);
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
  							Integer fyxsl =Double.valueOf(String.valueOf(contract.getFyxsl())).intValue();
  							Integer zbxsl =Double.valueOf(String.valueOf(contract.getZbxsl())).intValue() ;
  							Integer zsl =Double.valueOf(String.valueOf(contract.getZsl())).intValue();
  							
  							zsl_count=zsl_count+zsl;
  							fyxsl_count=fyxsl_count+fyxsl;
  							zbxsl_count=zbxsl_count+zbxsl;
  						}
  						
  						DecimalFormat df=new DecimalFormat("0.00");
  						double fyxsl_rate = new BigDecimal((float)fyxsl_count/zsl_count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
  						double zbxsl_rate = new BigDecimal((float)zbxsl_count/zsl_count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
  						
  						map.put("fyxsl_rate", fyxsl_rate*100+"%");
  						map.put("zbxsl_rate", zbxsl_rate*100+"%");
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
  	
  	
          
          @RequestMapping(method = RequestMethod.GET, value = "/contract_05")
			@ResponseBody
			public String contract_05(HttpServletRequest request, HttpServletResponse response) throws Exception {

				PageResult pageResult = new PageResult();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_05, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>>contract_05 jSONArray" + jSONArray.toString());
						
						List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
						List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"define3");
						List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleuContract02(lista,list);
						
						pageResult.setData(chartCircleList);
						pageResult.setCode(0);
						pageResult.setCount(Long.valueOf(chartCircleList.size()));
						pageResult.setLimit(1000);
						pageResult.setPage(1l);
						
						
					}
					
				
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
				System.out.println(">>>>>>>>>>>>>>>contract_05 " + resultObj.toString());
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
		  
			
		/**=========================================科研合同 end===============================*/
		
         /**=========================================科技成果===============================*/
		
			@RequestMapping(method = RequestMethod.GET, value = "/achievement")
			  public String achievement(HttpServletRequest request) throws Exception
			  {
				    
					
				    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
				    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
				    String unitCode=userInfo.getUnitCode();
				    request.setAttribute("unitCode", unitCode);
				    
				    String year= HanaUtil.getCurrrentYear();
				    request.setAttribute("year", year);
			        return "stp/hana/home/oneLevelMain/achievement";
			  }
			
			
			
			@RequestMapping(method = RequestMethod.GET, value = "/achievement_01")
			@ResponseBody
			public String achievement_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd",DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				String type = CommonUtil.getParameter(request, "type", "" );
				HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(paramsMap, httpHeaders);
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(achievement_01, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<AchievementsAnalysis> list = JSONObject.parseArray(jSONArray.toJSONString(), AchievementsAnalysis.class);
					System.out.println(">>>>>>>>>>>>>>achievement_01 jSONArray-> " + jSONArray.toString());
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						AchievementsAnalysis f2 = list.get(i);
						String projectName = f2.getDefine1();
						Integer value = f2.getSl();
						legendDataList.add(projectName);
						dataList.add(new ChartPieDataValue(value, projectName));
					}
					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					result.setSuccess(true);
					result.setData(pie);
					
				}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println(">>>>>>>>>>>>>>>achievement_01 " + resultObj.toString());
				return resultObj.toString();
			}
			
			//
			@RequestMapping(method = RequestMethod.GET, value = "/achievement_02")
			@ResponseBody
			public String achievement_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd",DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				String type = CommonUtil.getParameter(request, "type", "" );
				HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(paramsMap, httpHeaders);
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(achievement_02, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<AchievementsAnalysis> list = JSONObject.parseArray(jSONArray.toJSONString(), AchievementsAnalysis.class);
					System.out.println(">>>>>>>>>>>>>>achievement_02 jSONArray-> " + jSONArray.toString());
					
					if(type.equals("1"))
					{
						ChartSingleLineResultData csr = new ChartSingleLineResultData();
						//X轴数据
						List<Object> seriesDataList=new ArrayList<Object>();
						for(AchievementsAnalysis dt:list) {
							seriesDataList.add(dt.getSl());
						}
						csr.setSeriesDataList(seriesDataList);
						//标题
					    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define3");
			     		csr.setxAxisDataList(xAxisDataList);
						
			     		result.setSuccess(true);
						result.setData(csr);
					}
					if(type.equals("2"))
					{
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) {
							AchievementsAnalysis f2 = list.get(i);
							String projectName = f2.getDefine3();
							Integer value = f2.getSl();
							legendDataList.add(projectName);
							dataList.add(new ChartPieDataValue(value, projectName));
						}
						pie.setDataList(dataList);
						pie.setLegendDataList(legendDataList);
						result.setSuccess(true);
						result.setData(pie);
					}
					
				}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println("type>>>>>>>>>>>"+type+">>>>>>>>>>>>>>>achievement_02 " + resultObj.toString());
				return resultObj.toString();
			}
			
			
			
			@RequestMapping(method = RequestMethod.GET, value = "/achievement_03")
			@ResponseBody
			public String achievement_03(HttpServletRequest request, HttpServletResponse response) throws Exception {

				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd",DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				paramsMap.put("define1", "");
				HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(paramsMap, httpHeaders);
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(achievement_03, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<AchievementsAnalysis> list = JSONObject.parseArray(jSONArray.toJSONString(), AchievementsAnalysis.class);
					System.out.println(">>>>>>>>>>>>>>achievement_03 jSONArray-> " + jSONArray.toString());
					
						ChartSingleLineResultData csr = new ChartSingleLineResultData();
						//X轴数据
						List<Object> seriesDataList=new ArrayList<Object>();
						for(AchievementsAnalysis dt:list) {
							seriesDataList.add(dt.getSl());
						}
						csr.setSeriesDataList(seriesDataList);
						//标题
					    List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"zy");
			     		csr.setxAxisDataList(xAxisDataList);
						
			     		result.setSuccess(true);
						result.setData(csr);
					
				}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println(">>>>>>>>>>>>>>>achievement_03 " + resultObj.toString());
				return resultObj.toString();
			}
			
			
			@RequestMapping(method = RequestMethod.GET, value = "/achievement_04")
			@ResponseBody
			public String achievement_04(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

				System.out.println("achievement_04 param=   " + JSONObject.toJSONString(param));
				String nd = CommonUtil.getParameter(request, "nd", DateUtil.format(new Date(), DateUtil.FMT_YYYY));
				param.setLimit(2000);
				param.getParam().put("nd", nd);
				LayuiTableData layuiTableData = new LayuiTableData();
				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(achievement_04, HttpMethod.POST, entity, LayuiTableData.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					layuiTableData = responseEntity.getBody();
				}
				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
				System.out.println("achievement_04 result=   " + result.toJSONString());
				return result.toString();
			}
			//获得科技成果的所有年限
			@RequestMapping(method = RequestMethod.POST, value = "/achievement_05")
			@ResponseBody
			public String achievement_05(HttpServletRequest request,
					HttpServletResponse response) {

				System.out.println("achievement_05 param=   ");

				Object rs = null;
				HttpEntity<Object> entity = new HttpEntity<Object>(httpHeaders);
				ResponseEntity<Object> responseEntity = restTemplate.exchange(achievement_05, HttpMethod.POST, entity,
						Object.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					rs = responseEntity.getBody();
				}
				System.out.println("achievement_05 result=   " +JSON.toJSONString(rs));
				return JSON.toJSONString(rs);
			}
		/**=========================================科技成果 end===============================*/
		
			
			
			/**=========================================科研装备===============================*/
			
			@RequestMapping(method = RequestMethod.GET, value = "/equipment")
			  public String equipment(HttpServletRequest request) throws Exception
			  {
				    
					
				    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
				    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
				    String unitCode=userInfo.getUnitCode();
				    request.setAttribute("unitCode", unitCode);
				    
				    String year= HanaUtil.getCurrrentYear();
				    request.setAttribute("year", year);
				    
				    request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
				    
			        return "stp/hana/home/oneLevelMain/equipment";
			  }
				
			
		    @RequestMapping(method = RequestMethod.GET, value = "/equipment_01")
			@ResponseBody
			public String equipment_01(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	Result result = new Result();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ChartSingleLineResultData chartSingleLineResultData = new ChartSingleLineResultData();
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(equipment_01, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>>equipment_01 jSONArray" + jSONArray.toString());
						List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);
						List<String> xAxisDataList = new ArrayList<String>();
						List<Object> seriesDataList = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) 
						{
							H1AMKYSY100117 contract = (H1AMKYSY100117) list.get(i);
							String G0GSJC = contract.getG0GSJC();
							Object G0SBSL =contract.getG0SBSL();
							seriesDataList.add(Double.valueOf(String.valueOf(G0SBSL)).intValue());
							xAxisDataList.add(G0GSJC);
							
						}
						chartSingleLineResultData.setxAxisDataList(xAxisDataList);
						chartSingleLineResultData.setSeriesDataList(seriesDataList);
						result.setSuccess(true);
						result.setData(chartSingleLineResultData);
					}
					
				
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println(">>>>>>>>>>>>>>>equipment_01 " + resultObj.toString());
				return resultObj.toString();
			}
		    
		    
		    @RequestMapping(method = RequestMethod.GET, value = "/equipment_02")
			@ResponseBody
			public String equipment_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

				PageResult pageResult = new PageResult();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(equipment_02, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>>equipment_02 " + jSONArray.toString());
						
						List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);
						//List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0ZCXLMS");
						//List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartH1AMKYSY100117(lista,list);
						
						List<TreeNode2>  chartCircleList = new ArrayList<TreeNode2>();
						for(int i = 0;i<list.size();i++) 
						{
							H1AMKYSY100117 bean = list.get(i);
							TreeNode2 node = new TreeNode2();
							node.setExtend01(bean.getG0ZCXLMS());//设备类型
							node.setExtend02(bean.getG0GSJC());//直属研究院
							node.setExtend03(bean.getG0TXT50());//设备名称
							node.setExtend04(bean.getG0ZBHND());//购置年度
							node.setExtend05(bean.getG0NDJAR());//使用年限
							node.setExtend06(bean.getG0NDSYN());//剩余年限
							
							DecimalFormat decimalFormat=new DecimalFormat(".00");
							node.setExtend07(bean.getG0NCGZYZJE());//购置金额(万元)
							if(bean.getG0NCGZYZJE()!=null )
							{
								node.setExtend07(decimalFormat.format(Double.valueOf(bean.getG0NCGZYZJE())/10000l));
							}
							node.setExtend08(bean.getG0LJZJJE());//折旧金额（万元）
							if(bean.getG0LJZJJE()!=null )
							{
								node.setExtend08(decimalFormat.format(Double.valueOf(bean.getG0LJZJJE())/10000l));
							}
							node.setExtend09("0");
							if(bean.getG0NCGZYZJE()!=null && bean.getG0LJZJJE()!=null) 
							{
								Double rs = Double.valueOf(node.getExtend07())-Double.valueOf(node.getExtend08());
								node.setExtend09(decimalFormat.format(rs));
							}
							node.setExtend10(bean.getBl()+"%");//折旧率
							
							chartCircleList.add(node);
						}
						//把合计放到第一位置（查询结果在队列末尾）
						chartCircleList.set(0, chartCircleList.get(chartCircleList.size()-1));
						//移除最后位置的合计值
						chartCircleList.remove(chartCircleList.size()-1);
						
						pageResult.setData(chartCircleList);
						pageResult.setCode(0);
						pageResult.setCount(Long.valueOf(chartCircleList.size()));
						pageResult.setLimit(1000);
						pageResult.setPage(1l);
						
					}
					
				
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
				//System.out.println(">>>>>>>>>>>>>>>equipment_02 " + resultObj.toString());
				return resultObj.toString();
			}
				
			/**=========================================科研装备 end===============================*/
			
		    
		    
		    
		    
		    /**======================十条龙==================================*/
			
			
			@RequestMapping(method = RequestMethod.GET, value = "/dragon")
			  public String dragon(HttpServletRequest request) throws Exception
			  {
				    
				    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
				    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
				    String unitCode=userInfo.getUnitCode();
				    request.setAttribute("unitCode", unitCode);
				    request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
				    request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
				    String year= HanaUtil.getCurrrentYear();
				    request.setAttribute("year", year);
			        return "stp/hana/home/oneLevelMain/ten_dragon";
			        
			  }
			
			
			
			@RequestMapping(method = RequestMethod.GET, value = "/dragon_01")
			@ResponseBody
			public String dragon_01(HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
				
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
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(dragon_01, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						
						JSONArray jSONArray = responseEntity.getBody();
					    System.out.println(">>>>>>>>>>>>>>dragon_01 jSONArray-> " + jSONArray.toString());
						List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
					
						
							ChartPieResultData pie = new ChartPieResultData();
							List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
							List<String> legendDataList = new ArrayList<String>();
							for (int i = 0; i < list.size(); i++) {
								ProjectForMysql f2 = list.get(i);
								String projectName = (String)f2.getXmlbmc();
								Integer value =(Integer)f2.getSl();
								legendDataList.add(projectName);
								dataList.add(new ChartPieDataValue(value, projectName));
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
				System.out.println(">>>>>>>>>>>>>>dragon_01 type= "+type+" : " + resultObj.toString());
				return resultObj.toString();
			}
			
			
			    @RequestMapping(method = RequestMethod.GET, value = "/dragon_02")
				@ResponseBody
				public String dragon_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
			    	Result result = new Result();
					String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", "");
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("nd", nd);
					paramsMap.put("companyCode", companyCode);
					JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
					HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
					ChartSingleLineResultData chartSingleLineResultData = new ChartSingleLineResultData();
						ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(dragon_02, HttpMethod.POST, entity, JSONArray.class);
						int statusCode = responseEntity.getStatusCodeValue();
						if (statusCode == 200) 
						{
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>>dragon_02 jSONArray" + jSONArray.toString());
							List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
							List<String> xAxisDataList = new ArrayList<String>();
							List<Object> seriesDataList = new ArrayList<Object>();
							if(list!=null && list.size()>0)
							{
								ProjectForMysql contract = (ProjectForMysql) list.get(0);
								Integer sqcl =(Integer)contract.getSqcl();
								Integer tjrl =(Integer)contract.getTjrl();
								Integer zyxm =(Integer)contract.getZyxm();
								
								xAxisDataList.add(HanaUtil.getCurrrentYear()+"申请出龙");
								xAxisDataList.add(HanaUtil.getCurrrentYear()+"推荐入龙");
								xAxisDataList.add(HanaUtil.getCurrrentYear()+"在研项目");
								
								seriesDataList.add(sqcl);
								seriesDataList.add(tjrl);
								seriesDataList.add(zyxm);
								chartSingleLineResultData.setSeriesDataList(seriesDataList);
								chartSingleLineResultData.setxAxisDataList(xAxisDataList);
							}
							result.setSuccess(true);
							result.setData(chartSingleLineResultData);
						}
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					System.out.println(">>>>>>>>>>>>>>>dragon_02 " + resultObj.toString());
					return resultObj.toString();
			}
			
			@RequestMapping(method = RequestMethod.GET, value = "/dragon_03")
			@ResponseBody
			public String getProjectByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception {

				Result result = new Result();
				ChartBarLineResultData barLine=new ChartBarLineResultData();
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!companyCode.equals(""))
				{
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(dragon_03, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>dragon_03 jSONArray-> " + jSONArray.toString());
						List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
						List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("十条龙项目");
						legendDataList.add("重大项目");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getTenDragonChartBarLineSeries(list, "stlxm");
						ChartBarLineSeries s2 = HanaUtil.getTenDragonChartBarLineSeries(list, "zdzx");
						seriesList.add(s1);
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
				System.out.println(">>>>>>>>>>>>>>dragon_03 " + resultObj.toString());
				return resultObj.toString();
			}
						
						
						//重在集团
						@RequestMapping(method = RequestMethod.GET, value = "/getZdstlTable")
						@ResponseBody
						public String getZdstlTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
							PageResult pageResult = new PageResult();
							String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
							String companyCode = CommonUtil.getParameter(request, "companyCode", "");
							String type = CommonUtil.getParameter(request, "type", "重点专项");
							Map<String, Object> paramsMap = new HashMap<String, Object>();
							paramsMap.put("nd", nd);
							paramsMap.put("companyCode", companyCode);
							JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
							HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
							
								ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getZdstlTable, HttpMethod.POST, entity, JSONArray.class);
								int statusCode = responseEntity.getStatusCodeValue();
								if (statusCode == 200) 
								{
									JSONArray jSONArray = responseEntity.getBody();
									System.out.println(">>>>>>>>>>>>getZdstlTable jSONArray>>> " + jSONArray.toString());
									List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectForMysql.class);
									pageResult.setData(list);
									pageResult.setCode(0);
									pageResult.setCount(Long.valueOf(list.size()));
									pageResult.setLimit(1000);
									pageResult.setPage(1l);
								}
								
							
							JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
							System.out.println(">>>>>>>>>>>>>>>getZdstlTable " + resultObj.toString());
							return resultObj.toString();
						}
						
						
			 /**======================十条龙 end==================================*/
				
			
			
}
