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
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYSY100117;
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
	
	private static final String equipment_02 = "http://pcitc-zuul/hana-proxy/hana/home/get_direct_KYZB_02";
	private static final String equipment_03 = "http://pcitc-zuul/hana-proxy/hana/home/get_direct_KYZB";
	//支出
	private static final String pay_01 =      "http://pcitc-zuul/hana-proxy/hana/home/pay_01";
	private static final String pay_02 =   "http://pcitc-zuul/hana-proxy/hana/home/pay_02";
	private static final String pay_03 = "http://pcitc-zuul/hana-proxy/hana/home/pay_03";
	
	
	private static final String GET_XFZC =      "http://pcitc-zuul/hana-proxy/hana/home/getndys_xfzc";
	
	
	
	private static final String contry_01 = "http://pcitc-zuul/system-proxy/out-project-provider/project-money/institute";
	private static final String contry_02 = "http://pcitc-zuul/system-proxy/out-project-provider/tech/type/project-info";
	
	
	@Autowired
	private HttpHeaders httpHeaders;
	@Autowired
	private RestTemplate restTemplate;

	
	/**===================================首页=================================*/
	//年度预算 经费支出
			@RequestMapping(method = RequestMethod.GET, value = "/getndys_xfzc")
			@ResponseBody
			public String getndys_xfzc(HttpServletRequest request, HttpServletResponse response) throws Exception {

				Result result = new Result();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!companyCode.equals("")) {
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_XFZC, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						JSONArray jSONArray = responseEntity.getBody();
						List<H1AMKYSY100104> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100104.class);
						
						if(list!=null && list.size()>0)
						{
							result.setSuccess(true);
							result.setData(list.get(0));
						}
					}
				} else {
					result.setSuccess(false);
					result.setMessage("参数为空");
				}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println(">>>>>>>>>>>>>>>>>年度预算 经费支出" + resultObj.toString());
				return resultObj.toString();

			}
	
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
		
		
		
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/contry_01")
		@ResponseBody
		public String contry_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contry_01, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>contry_01 jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
					if(type.equals("1"))
					{
						ChartBarLineResultData barLine=new ChartBarLineResultData();
						List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
		         		barLine.setxAxisDataList(xAxisDataList);
		         		
		         		List<String> legendDataList = new ArrayList<String>();
		         		legendDataList.add("新开课题");
						legendDataList.add("结转课题");
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries07(list, "gjxksl");
						seriesList.add(s1);
						ChartBarLineSeries s2 = HanaUtil.getKNOWLDGELevel2ChartBarLineSeries07(list, "gjjzsl");
						seriesList.add(s2);
						barLine.setSeriesList(seriesList);
		         		result.setSuccess(true);
						result.setData(barLine);
					}
					if(type.equals("2") )
					{
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) 
						{
							Knowledge f2 = list.get(i);
							Integer applyCount = f2.getGjjzsl();
							
							int value =Integer.valueOf(applyCount).intValue();
							legendDataList.add(f2.getLx());
							dataList.add(new ChartPieDataValue(value, f2.getDefine2()));
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
			System.out.println(">>>>>>>>>>>>>>>contry_01 " + resultObj.toString());
			return resultObj.toString();
		}
		
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/contry_02")
		@ResponseBody
		public String contry_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contry_02, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>contry_02 jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
					
					
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) 
						{
							Knowledge f2 = list.get(i);
							int applyCount = f2.getZsl();
							legendDataList.add(f2.getLx());
							dataList.add(new ChartPieDataValue(applyCount, f2.getDefine5()));
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
			System.out.println(">>>>>>>>>>>>>>>contry_02 " + resultObj.toString());
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
		    
		    
		    
		    
		    @RequestMapping(method = RequestMethod.GET, value = "/contract_01_count")
			@ResponseBody
			public String contract_01_count(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    	String resault="";
				Result result = new Result();
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				paramsMap.put("xmlbbm", "fkyzb");
				
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!nd.equals(""))
				{
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_01, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						
							JSONArray jSONArray = responseEntity.getBody();
							System.out.println(">>>>>>>>>>>>>>contract_01_count jSONArray-> " + jSONArray.toString());
							List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
							Contract contract=list.get(0);
							result.setSuccess(true);
							result.setData(contract);
						
					}
					
				} else
				{
					result.setSuccess(false);
					result.setMessage("参数为空");
				}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				resault=resultObj.toString();
				System.out.println(">>>>>>>>>>>>>contract_01_count " + resultObj.toString());
				
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
						Map  map= get_contract_02_map(list);
						List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"define1");
						List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleuContract(lista,list);
						
						TreeNode2 treeNode2=new TreeNode2();
						treeNode2.setId("00001");
						treeNode2.setName("总计");
						treeNode2.setExtend01(String.valueOf(map.get("jhqds_count")));
						treeNode2.setExtend02(String.valueOf(map.get("sjqds_count")));
						String jhqds_count=String.valueOf(map.get("jhqds_count"));
						String sjqds_count=String.valueOf(map.get("sjqds_count"));
						treeNode2.setExtend03(String.valueOf(HanaUtil.chufa2(Integer.valueOf(sjqds_count), Integer.valueOf(jhqds_count))));
						
						
						
						List<TreeNode2>  result=new ArrayList();
						result.add(treeNode2);
						for(int i=0;i<chartCircleList.size();i++)
						{
							TreeNode2 treeNode_02=chartCircleList.get(i);
							
							result.add(treeNode_02);
						}
						pageResult.setData(result);
						pageResult.setCode(0);
						pageResult.setCount(Long.valueOf(result.size()));
						pageResult.setLimit(1000);
						pageResult.setPage(1l);
					}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
				System.out.println(">>>>>>>>>>>>>>>contract_02 " + resultObj.toString());
				return resultObj.toString();
			}
		    
		    
		    public Map   get_contract_02_map(List<Contract> list)
			{
				List<Contract> resutList =new ArrayList<Contract>();
				int jhqds_count=0;
				int sjqds_count=0;
				for(int i=0;i<list.size();i++)
				{
					Contract contract=list.get(i);
					
					Integer jhqds=(Integer)contract.getJhqds();
					Integer sjqds=(Integer)contract.getSjqds();
					jhqds_count=jhqds_count+jhqds;
					sjqds_count=sjqds_count+sjqds;
				}
				Map map=new HashMap();
				map.put("jhqds_count", jhqds_count);
				map.put("sjqds_count", sjqds_count);
				return map;
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
								legendDataList.add("结转课题");
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
								
								
								pageResult.setData(add_topic_01(list));
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
		
		    
		    
		    
		    public List<Topic>  add_topic_01(List<Topic> list)
			{
				List<Topic> resutList =new ArrayList<Topic>();
				Topic temp=new Topic();
				temp.setDefine2("总计");
				int zsl_count=0;
				int xksl_count=0;
				int xjsl_count=0;
				for(int i=0;i<list.size();i++)
				{
					Topic contract=list.get(i);
					Integer zsl =Double.valueOf(contract.getZsl()).intValue();
					Integer xksl =Double.valueOf(contract.getXksl()).intValue();
					Integer xjsl =Double.valueOf(contract.getXjsl()).intValue();
					zsl_count=zsl_count+zsl;
					xksl_count=xksl_count+xksl;
					xjsl_count=xjsl_count+xjsl;
					
				}
				temp.setZsl(zsl_count);
				temp.setXksl(xksl_count);
				temp.setXjsl(xjsl_count);
				temp.setXkRate(HanaUtil.chufa2(xksl_count, zsl_count));
				temp.setXjRate(HanaUtil.chufa2(xjsl_count, zsl_count));
				temp.setZslRate(100);
				resutList.add(temp);
				for(int i=0;i<list.size();i++)
				{
					Topic contract=list.get(i);
					resutList.add(contract);
				}
				return resutList;
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
			 							legendDataList.add("结转课题");
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
		 								pageResult.setData(add_topic_02(list));
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
		            
		            
		            
		            
		            public List<Topic>  add_topic_02(List<Topic> list)
					{
						List<Topic> resutList =new ArrayList<Topic>();
						Topic temp=new Topic();
						temp.setProject_property("总计");
						int zsl_count=0;
						int xksl_count=0;
						int xjsl_count=0;
						for(int i=0;i<list.size();i++)
						{
							Topic contract=list.get(i);
							Integer zsl =Double.valueOf(contract.getZsl()).intValue();
							Integer xksl =Double.valueOf(contract.getXksl()).intValue();
							Integer xjsl =Double.valueOf(contract.getXjsl()).intValue();
							zsl_count=zsl_count+zsl;
							xksl_count=xksl_count+xksl;
							xjsl_count=xjsl_count+xjsl;
							
						}
						temp.setZsl(zsl_count);
						temp.setXksl(xksl_count);
						temp.setXjsl(xjsl_count);
						temp.setXkRate(HanaUtil.chufa2(xksl_count, zsl_count));
						temp.setXjRate(HanaUtil.chufa2(xjsl_count, zsl_count));
						temp.setZslRate(100);
						resutList.add(temp);
						for(int i=0;i<list.size();i++)
						{
							Topic contract=list.get(i);
							resutList.add(contract);
						}
						return resutList;
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
		 							legendDataList.add("结转课题");
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
								legendDataList.add("结转课题");
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
								pageResult.setData(add_equipment_01(list));
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
		    
		    
		    
		    public List<Topic>  add_equipment_01(List<Topic> list)
			{
				List<Topic> resutList =new ArrayList<Topic>();
				Topic temp=new Topic();
				temp.setDefine2("总计");
				int zsl_count=0;
				int xksl_count=0;
				int xjsl_count=0;
				for(int i=0;i<list.size();i++)
				{
					Topic contract=list.get(i);
					Integer zsl =Double.valueOf(contract.getZsl()).intValue();
					Integer xksl =Double.valueOf(contract.getXksl()).intValue();
					Integer xjsl =Double.valueOf(contract.getXjsl()).intValue();
					zsl_count=zsl_count+zsl;
					xksl_count=xksl_count+xksl;
					xjsl_count=xjsl_count+xjsl;
					
				}
				temp.setZsl(zsl_count);
				temp.setXksl(xksl_count);
				temp.setXjsl(xjsl_count);
				temp.setXkRate(HanaUtil.chufa2(xksl_count, zsl_count));
				temp.setXjRate(HanaUtil.chufa2(xjsl_count, zsl_count));
				temp.setZslRate(100);
				resutList.add(temp);
				for(int i=0;i<list.size();i++)
				{
					Topic contract=list.get(i);
					resutList.add(contract);
				}
				return resutList;
			}
 		
		    
		    @RequestMapping(method = RequestMethod.GET, value = "/equipment_02")
			@ResponseBody
			public String equipment_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	PageResult pageResult = new PageResult();
				Result result = new Result();
				String resault="";
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				String type = CommonUtil.getParameter(request, "type", "");
				// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!companyCode.equals("")) {
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(equipment_02, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						JSONArray jSONArray = responseEntity.getBody();
						List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);
						System.out.println("type="+type+">>>>>>equipment_02>>>>>>>>>>>>>>       statusCode = " + statusCode + " jSONArray=" + jSONArray.toString());
						if(type.equals("1"))
						{
								ChartBarLineResultData barLine = new ChartBarLineResultData();
								List<String> legendDataList = new ArrayList<String>();
								legendDataList.add("大型分析仪器");
								legendDataList.add("中型实验装置");
								legendDataList.add("单台值大于500万");
								legendDataList.add("专业软件（外购）");
								barLine.setLegendDataList(legendDataList);
								List<String>  yAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
								barLine.setyAxisDataList(yAxisDataList);
								
								List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
								ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL1");
								ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL2");
								ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL3");
								ChartBarLineSeries K0BNXMYQSL = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL4");
								seriesList.add(s1);
								seriesList.add(s2);
								seriesList.add(s3);
								seriesList.add(K0BNXMYQSL);
								barLine.setSeriesList(seriesList);
								result.setSuccess(true);
								result.setData(barLine);
						}
						if(type.equals("2"))
						{
							pageResult.setData(addListLine5(list));
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
				
				if(type.equals("1"))
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
					resault=resultObj.toString();
					System.out.println("type="+type+">>>>>>>>>>>>>>>equipment_02 result" + resultObj.toString());
				}
				else
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					resault=resultObj.toString();
					System.out.println("type="+type+">>>>>>>>>>>>>>>equipment_02 result " + resultObj.toString());
				}
				return resault;

			}

		    
			
			public List<H1AMKYSY100117>  addListLine5(List<H1AMKYSY100117> list)
			{
				List<H1AMKYSY100117> resutList =new ArrayList<H1AMKYSY100117>();
				//加--总数行
				H1AMKYSY100117 temp=new H1AMKYSY100117();
				temp.setG0GSJC("总计");
				int g0SBSL_count=0;
				int g0SBSL1_count=0;
				int g0SBSL2_count=0;
				int g0SBSL3_count=0;
				int g0SBSL4_count=0;
				for(int i=0;i<list.size();i++)
				{
					H1AMKYSY100117 contract=list.get(i);
					//Integer g0SBSL = Double.valueOf(contract.getG0SBSL()).intValue();
					Integer g0SBSL1 =Double.valueOf(contract.getG0SBSL1()).intValue();
					Integer g0SBSL2 =Double.valueOf(contract.getG0SBSL2()).intValue();
					Integer g0SBSL3 =Double.valueOf(contract.getG0SBSL3()).intValue();
					Integer g0SBSL4 =Double.valueOf(contract.getG0SBSL4()).intValue();
					//g0SBSL_count=g0SBSL_count+g0SBSL;
					g0SBSL1_count=g0SBSL1_count+g0SBSL1;
					g0SBSL2_count=g0SBSL2_count+g0SBSL2;
					g0SBSL3_count=g0SBSL3_count+g0SBSL3;
					g0SBSL4_count=g0SBSL4_count+g0SBSL4;
					
				}
				//temp.setG0SBSL(String.valueOf(g0SBSL_count));
				temp.setG0SBSL1(String.valueOf(g0SBSL1_count));
				temp.setG0SBSL2(String.valueOf(g0SBSL2_count));
				temp.setG0SBSL3(String.valueOf(g0SBSL3_count));
				temp.setG0SBSL4(String.valueOf(g0SBSL4_count));
				
				resutList.add(temp);
				for(int i=0;i<list.size();i++)
				{
					H1AMKYSY100117 contract=list.get(i);
					resutList.add(contract);
				}
				return resutList;
			}
		  
			
		  
			@RequestMapping(method = RequestMethod.GET, value = "/equipment_03")
			@ResponseBody
			public String equipment_03(HttpServletRequest request, HttpServletResponse response) throws Exception {

				Result result = new Result();
				 ChartBarLineResultData barLine=new ChartBarLineResultData();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!companyCode.equals("")) {
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(equipment_03, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						JSONArray jSONArray = responseEntity.getBody();
						List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);
						List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0ZCXLMS");
		         		barLine.setxAxisDataList(xAxisDataList);
		         	
						List<String> legendDataList = new ArrayList<String>();
						legendDataList.add("大型分析仪器");
						legendDataList.add("中型实验装置");
						legendDataList.add("单台值大于500万");
						legendDataList.add("专业软件（外购）");
						barLine.setxAxisDataList(xAxisDataList);
						barLine.setLegendDataList(legendDataList);
						// X轴数据
						List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
						ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL1");
						ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL2");
						ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL3");
						ChartBarLineSeries K0BNXMYQSL = HanaUtil.getChartBarLineSeries_GET_getDzzk_bar(list, "g0SBSL4");
						seriesList.add(s1);
						seriesList.add(s2);
						seriesList.add(s3);
						seriesList.add(K0BNXMYQSL);
						barLine.setSeriesList(seriesList);
		         		result.setSuccess(true);
						result.setData(barLine);
					}
					
				} else {
					result.setSuccess(false);
					result.setMessage("参数为空");
				}
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
				System.out.println(">>>>>>>>>>>>>>equipment_03 " + resultObj.toString());
				return resultObj.toString();
			}
		    
		    
		    
		  /**=========================================科研实际支出=================================*/
			
		  @RequestMapping(method = RequestMethod.GET, value = "/actualPay")
		  public String actualPay(HttpServletRequest request) throws Exception
		  {
			    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    String unitCode=userInfo.getUnitCode();
			    request.setAttribute("unitCode", unitCode);
			    request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
			    request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
		        return "stp/hana/home/oneLevelMain/direct/actualPay";
		  }
		  
		    
						@RequestMapping(method = RequestMethod.GET, value = "/pay_01")
						@ResponseBody
						public String pay_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

							Result result = new Result();
							ChartBarLineResultData barLine=new ChartBarLineResultData();
							String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
							String companyCode = CommonUtil.getParameter(request, "companyCode", "");
							Map<String, Object> paramsMap = new HashMap<String, Object>();
							paramsMap.put("month", month);
							paramsMap.put("companyCode", companyCode);
							JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
							HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
							if (!companyCode.equals(""))
							{
								ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(pay_01, HttpMethod.POST, entity, JSONArray.class);
								int statusCode = responseEntity.getStatusCodeValue();
								if (statusCode == 200) 
								{
									JSONArray jSONArray = responseEntity.getBody();
									System.out.println(">>>>>>>>>>>>>>pay_01 jSONArray-> " + jSONArray.toString());
									
					         	
					         		List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
									List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0XMDL");
					         		barLine.setxAxisDataList(xAxisDataList);
					         	
									List<String> legendDataList = new ArrayList<String>();
									legendDataList.add("新开课题");
									legendDataList.add("结转课题");
									barLine.setxAxisDataList(xAxisDataList);
									barLine.setLegendDataList(legendDataList);
									// X轴数据
									List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
									ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_budget_count_bar(list, "K0BNXKJE");
									ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_budget_count_bar(list, "K0BNXJJE");
									
									seriesList.add(s2);
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
							System.out.println(">>>>>>>>>>>>>>pay_01 " + resultObj.toString());
							return resultObj.toString();
						}
		  
		  
						@RequestMapping(method = RequestMethod.GET, value = "/pay_02")
						@ResponseBody
						public String pay_02(HttpServletRequest request, HttpServletResponse response) throws Exception {
							PageResult pageResult = new PageResult();
							String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
							String companyCode = CommonUtil.getParameter(request, "companyCode", "");
							Map<String, Object> paramsMap = new HashMap<String, Object>();
							paramsMap.put("month", month);
							paramsMap.put("companyCode", companyCode);
							JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
							HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
							
								ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(pay_02, HttpMethod.POST, entity, JSONArray.class);
								int statusCode = responseEntity.getStatusCodeValue();
								if (statusCode == 200) 
								{
									JSONArray jSONArray = responseEntity.getBody();
									
									System.out.println(">>>>>>>>>>>>pay_02 jSONArray>>> " + jSONArray.toString());
									List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
									
									Map  map= get_pay_02_map(list);
									List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"g0XMXZ");
									List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleForBudgetCount(lista,list);
									
									
									TreeNode2 treeNode2=new TreeNode2();
									treeNode2.setId("00001");
									treeNode2.setName("总计");
									treeNode2.setExtend01(String.valueOf(map.get("K0BNYSJHJE_count")));
									
									List<TreeNode2>  result=new ArrayList();
									result.add(treeNode2);
									for(int i=0;i<chartCircleList.size();i++)
									{
										TreeNode2 treeNode_02=chartCircleList.get(i);
										result.add(treeNode_02);
									}
									
									
									
									pageResult.setData(result);
									pageResult.setCode(0);
									pageResult.setCount(Long.valueOf(result.size()));
									pageResult.setLimit(1000);
									pageResult.setPage(1l);
								}
								
							
							JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
							System.out.println(">>>>>>>>>>>>>>>pay_02 " + resultObj.toString());
							return resultObj.toString();
						}
						
						public Map   get_pay_02_map(List<H1AMKYSY100109> list)
						{
							Double K0BNYSJHJE_count=0.00;
							for(int i=0;i<list.size();i++)
							{
								H1AMKYSY100109 contract=list.get(i);
								String K0BNYSJHJE=contract.getK0BNYSJHJE();
								K0BNYSJHJE_count=HanaUtil.add(K0BNYSJHJE_count,Double.valueOf(K0BNYSJHJE));
							}
							Map map=new HashMap();
							map.put("K0BNYSJHJE_count", K0BNYSJHJE_count);
							return map;
						}
						
						
						@RequestMapping(method = RequestMethod.GET, value = "/pay_03")
						@ResponseBody
						public String pay_03(HttpServletRequest request, HttpServletResponse response) throws Exception {
                             String resault="";
                             PageResult pageResult = new PageResult();
							Result result = new Result();
							ChartBarLineResultData barLine=new ChartBarLineResultData();
							String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
							String companyCode = CommonUtil.getParameter(request, "companyCode", "");
							String type = CommonUtil.getParameter(request, "type", "");
							
							Map<String, Object> paramsMap = new HashMap<String, Object>();
							paramsMap.put("month", month);
							paramsMap.put("companyCode", companyCode);
							JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
							HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
							if (!companyCode.equals(""))
							{
								ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(pay_03, HttpMethod.POST, entity, JSONArray.class);
								int statusCode = responseEntity.getStatusCodeValue();
								if (statusCode == 200) 
								{
									JSONArray jSONArray = responseEntity.getBody();
									System.out.println(">>>>>>>>>>>>>>pay_03 jSONArray-> " + jSONArray.toString());
									
									List<H1AMKYSY100109> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100109.class);
									if(type.equals("1"))
									{
										List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"g0GSJC");
						         		barLine.setxAxisDataList(xAxisDataList);
						         	
										List<String> legendDataList = new ArrayList<String>();
										//legendDataList.add("总计");
										legendDataList.add("费用性");
										legendDataList.add("资本性");
										
										barLine.setxAxisDataList(xAxisDataList);
										barLine.setLegendDataList(legendDataList);
										// X轴数据
										List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
										//ChartBarLineSeries s1 = HanaUtil.getChartBarLineSeries_PAY02_bar(list, "K0BNYSJHJE");
										ChartBarLineSeries s2 = HanaUtil.getChartBarLineSeries_PAY02_bar(list, "K0BNFYJE");
										ChartBarLineSeries s3 = HanaUtil.getChartBarLineSeries_PAY02_bar(list, "K0BNZBJE");
										
										//seriesList.add(s1);
										seriesList.add(s2);
										seriesList.add(s3);
										barLine.setSeriesList(seriesList);
						         		result.setSuccess(true);
										result.setData(barLine);
									}else
									{
										pageResult.setData(addListLineH1AMKYSY100109(list));
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
								System.out.println(">>>>>>>>>>>>>>>pay_03 " + resultObj.toString());
							}
							else
							{
								JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
								resault=resultObj.toString();
								System.out.println(">>>>>>>>>>>>>>>pay_03 " + resultObj.toString());
							}
							
							return resault;
						}
						
						
						public List<H1AMKYSY100109>  addListLineH1AMKYSY100109(List<H1AMKYSY100109> list)
						{
							List<H1AMKYSY100109> resutList =new ArrayList<H1AMKYSY100109>();
							//加--总数行
							H1AMKYSY100109 temp=new H1AMKYSY100109();
							temp.setG0GSJC("总计");
							Double k0BNYSJHJE_count=0.0;
							Double k0BNZBJE_count=0.0;
							Double k0BNFYJE_count=0.0;
							DecimalFormat df=new DecimalFormat("0.00");
							for(int i=0;i<list.size();i++)
							{
								H1AMKYSY100109 contract=list.get(i);
								String k0BNYSJHJE =contract.getK0BNYSJHJE();
								String k0BNZBJE =contract.getK0BNZBJE();
								String k0BNFYJE =contract.getK0BNFYJE();
								k0BNYSJHJE_count=k0BNYSJHJE_count+Double.valueOf(k0BNYSJHJE);
								k0BNZBJE_count=k0BNZBJE_count+Double.valueOf(k0BNZBJE);
								k0BNFYJE_count=k0BNFYJE_count+Double.valueOf(k0BNFYJE);
								
							}
							temp.setK0BNYSJHJE(df.format(k0BNFYJE_count));
							temp.setK0BNZBJE(df.format(k0BNZBJE_count));
							temp.setK0BNFYJE(df.format(k0BNFYJE_count));
							
    						//double fyxsl_rate = new BigDecimal((float)fyxsl_count/zsl_count).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							resutList.add(temp);
							for(int i=0;i<list.size();i++)
							{
								H1AMKYSY100109 contract=list.get(i);
								contract.setK0BNYSJHJE(df.format(Double.valueOf(contract.getK0BNYSJHJE())));
								contract.setK0BNZBJE(df.format(Double.valueOf(contract.getK0BNZBJE())));
								contract.setK0BNFYJE(df.format(Double.valueOf(contract.getK0BNFYJE())));
								resutList.add(contract);
							}
							return resutList;
						}
					  
			
		  
		  
		 

}
