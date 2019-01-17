package com.pcitc.web.controller.hanaLeader;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.Contract;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.hana.report.ProjectForMysql;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.FileUtil;
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
		private static final String contract_dic = "http://pcitc-zuul/system-proxy/out-project-provider/select-condition/list";
		
		
		
		
		
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
		private static final String dragon_count = "http://pcitc-zuul/system-proxy/out-provider/dragon/project-count";
		private static final String getStlTable = "http://pcitc-zuul/system-proxy/out-project-provider/dragon/details";
		private static final String dragon_search_con = "http://pcitc-zuul/system-proxy/out-project-provider/dragon/select-condition/list";
		

		//科研投入
		private static final String investment_01 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/money/complete-rate/company-type";
		private static final String investment_02 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/money/complete-rate/institute";
		
		private static final String investment_first_page_count = "http://pcitc-zuul/system-proxy/out-provider/project-money";
		private static final String contract_count = "http://pcitc-zuul/system-proxy/out-provider/project-count";
		
		
		
		
		
		
		//新闻
		private static final String get_news = "http://pcitc-zuul/system-proxy/news-provider/select_news_main";
		
		private static final String common_table = "http://pcitc-zuul/system-proxy/out-project-plna-provider/project-plan/page/list";
		private static final String ten_dragon_table_data = "http://pcitc-zuul/system-proxy/out-project-plna-provider/project-plan/page/list";
		
		private static final String count_table_data = "http://pcitc-zuul/system-proxy/out-project-provider/common-project/list";
		
		

		//数量--成果
	    private static final String achievement_table_dic = "http://pcitc-zuul/system-proxy/out-provider/appraisal/select-condition/list";
				
	   //数量--知识
	    private static final String knowledge_table_data = "http://pcitc-zuul/system-proxy/out-project-provider/common-project/list";
	    private static final String achievement_table_data = "http://pcitc-zuul/system-proxy/out-provider/project/appraisal-list";
			
	    
		
		@Autowired
		private HttpHeaders httpHeaders;
		@Autowired
		private RestTemplate restTemplate;
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/investment_first_page_count")
		@ResponseBody
		public String investment_first_page_count(HttpServletRequest request, HttpServletResponse response) throws Exception {

	    	String resault="";
			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(investment_first_page_count, HttpMethod.POST, entity, JSONObject.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					   JSONObject jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>investment_first_page_count jSONArray-> " + jSONArray.toString());
						
						String projectMoney =String.valueOf(jSONArray.getString("projectMoney"));
		         		
						projectMoney=String.format("%.2f", Double.valueOf(projectMoney));
		         		
						Map map=new HashMap();
						map.put("projectMoney", projectMoney);
		         		result.setSuccess(true);
						result.setData(map);
					
				}
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault=resultObj.toString();
			System.out.println(">>>>>>>>>>>>>investment_first_page_count " + resultObj.toString());
			
			return resault;
		}
		
		
		
		@RequestMapping(method = RequestMethod.GET, value = "/contract_count")
		@ResponseBody
		public String contract_count(HttpServletRequest request, HttpServletResponse response) throws Exception {

	    	String resault="";
			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(contract_count, HttpMethod.POST, entity, JSONObject.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					    JSONObject jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>contract_count jSONArray-> " + jSONArray.toString());
						Integer projectCount =	jSONArray.getInteger("projectCount");
						Map map=new HashMap();
						map.put("projectCount", projectCount);
		         		result.setSuccess(true);
						result.setData(map);
					
				}
				
			} else
			{
				result.setSuccess(false);
				result.setMessage("参数为空");
			}
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
			resault=resultObj.toString();
			System.out.println(">>>>>>>>>>>>>contract_count " + resultObj.toString());
			
			return resault;
		}
		
		
		
		
		
		
		 
	    /**========================================================知识--详情==========================================================*/

		
		
		@RequestMapping(method = RequestMethod.GET, value = "/knowledge_table")
		  public String knowledge_table(HttpServletRequest request) throws Exception
		  {
			 
				String nd=CommonUtil.getParameter(request, "nd", "");//项目名
				String cglx=CommonUtil.getParameter(request, "cglx", "");//成果类型
				String zy=CommonUtil.getParameter(request, "zy", "");//成果专业
				String define3=CommonUtil.getParameter(request, "define3", "");//一级单位
				String define1=CommonUtil.getParameter(request, "define1", "");//二级单位
				
				request.setAttribute("nd", nd);
				request.setAttribute("cglx", cglx);
				request.setAttribute("zy", zy);
				request.setAttribute("define3", define3);
				request.setAttribute("define1", define1);
				
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(achievement_table_dic, HttpMethod.POST, entity, JSONArray.class);
				
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					 JSONArray jSONArray = responseEntity.getBody();
					 System.out.println(">>>>>>>>>>>>>knowledge_table:" + jSONArray.toString());
					 
					 List<String> define1List = new ArrayList<String>();
					 List<String> define31List = new ArrayList<String>();//8大研究院 
					 List<String> cglxList = new ArrayList<String>();
					 List<String> zyList = new ArrayList<String>();
					 
					 
					 for (int i = 0; i < jSONArray.size(); i++)
			         {
						    Map  object = (Map) jSONArray.get(i);
			                String showCode= (String)object.get("showCode");
			                String showName= (String)object.get("showName");
			                if(showCode.equals("define1"))
			                {
			                	if(showName!=null && !showName.equals(""))
			                	{
			                		define1List.add(showName);
			                	}
			                }
			                if(showCode.equals("define3"))
			                {
			                	define31List.add(showName);
			                }
			                if(showCode.equals("cglx"))
			                {
			                	cglxList.add(showName);
			                }
			                if(showCode.equals("zy"))
			                {
			                	zyList.add(showName);
			                }
			                
			          }
					 request.setAttribute("define1List", define1List);
					 request.setAttribute("zyList", zyList);
					 request.setAttribute("cglxList", cglxList);
					 request.setAttribute("define31List", define31List);
				}
		        return "stp/hana/home/oneLevelMain/knowledge_table";
		  }
		
		
		 //三级表格
	    @RequestMapping(method = RequestMethod.POST, value = "/knowledge_table_data")
		@ResponseBody
		public String knowledge_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

	    	System.out.println(">>>>>>>>>>>>knowledge_table_data>param:" + JSONObject.toJSONString(param));
	    	
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(achievement_table_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>knowledge_table_data:" + result.toString());
			return result.toString();
		}
	    
	    /**========================================================知识--详情  end==========================================================*/
    
		

		 
	    /**========================================================成果--详情==========================================================*/

		
		
		@RequestMapping(method = RequestMethod.GET, value = "/achievement_table")
		  public String achievement_table(HttpServletRequest request) throws Exception
		  {
			 
				String nd=CommonUtil.getParameter(request, "nd", "");//项目名
				String cglx=CommonUtil.getParameter(request, "cglx", "");//成果类型
				String zy=CommonUtil.getParameter(request, "zy", "");//成果专业
				String define3=CommonUtil.getParameter(request, "define3", "");//一级单位
				String define1=CommonUtil.getParameter(request, "define1", "");//二级单位
				
				request.setAttribute("nd", nd);
				request.setAttribute("cglx", cglx);
				request.setAttribute("zy", zy);
				request.setAttribute("define3", define3);
				request.setAttribute("define1", define1);
				
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(achievement_table_dic, HttpMethod.POST, entity, JSONArray.class);
				
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					 JSONArray jSONArray = responseEntity.getBody();
					 System.out.println(">>>>>>>>>>>>>achievement_table:" + jSONArray.toString());
					 
					 List<String> define1List = new ArrayList<String>();
					 List<String> define31List = new ArrayList<String>();//8大研究院 
					 List<String> cglxList = new ArrayList<String>();
					 List<String> zyList = new ArrayList<String>();
					 
					 
					 for (int i = 0; i < jSONArray.size(); i++)
			         {
						    Map  object = (Map) jSONArray.get(i);
			                String showCode= (String)object.get("showCode");
			                String showName= (String)object.get("showName");
			                if(showCode.equals("define1"))
			                {
			                	if(showName!=null && !showName.equals(""))
			                	{
			                		define1List.add(showName);
			                	}
			                }
			                if(showCode.equals("define3"))
			                {
			                	define31List.add(showName);
			                }
			                if(showCode.equals("cglx"))
			                {
			                	cglxList.add(showName);
			                }
			                if(showCode.equals("zy"))
			                {
			                	zyList.add(showName);
			                }
			                
			          }
					 request.setAttribute("define1List", define1List);
					 request.setAttribute("zyList", zyList);
					 request.setAttribute("cglxList", cglxList);
					 request.setAttribute("define31List", define31List);
				}
		        return "stp/hana/home/oneLevelMain/achievement_table";
		  }
		
		
	    @RequestMapping(method = RequestMethod.POST, value = "/achievement_table_data")
		@ResponseBody
		public String achievement_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

	    	System.out.println(">>>>>>>>>>>>achievement_table_data>param:" + JSONObject.toJSONString(param));
	    	
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(achievement_table_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>achievement_table_data:" + result.toString());
			return result.toString();
		}
	    
	    /**=========================================================成果-详情  end==========================================================*/
    
	    
		 
	    /**========================================================数量--详情==========================================================*/

		
		
		@RequestMapping(method = RequestMethod.GET, value = "/count_table")
		  public String count_table(HttpServletRequest request) throws Exception
		  {
			 
				
				String nd=CommonUtil.getParameter(request, "nd", "");//项目名
				String ysnd=CommonUtil.getParameter(request, "ysnd", "");//项目名
				String xmmc=CommonUtil.getParameter(request, "xmmc", "");//项目名
				String hth=CommonUtil.getParameter(request, "hth", "");//合同号
				String define1=CommonUtil.getParameter(request, "define1", "");//资本性、费用性
				String define2=CommonUtil.getParameter(request, "define2", "");//8大院等细分结构
				String type_flag=CommonUtil.getParameter(request, "type_flag", "");//直属研究院、分子公司、集团等9种类型
				String project_property=CommonUtil.getParameter(request, "project_property", "");//国家项目、重大专项、重点项目、其他项目
				String project_scope=CommonUtil.getParameter(request, "project_scope", "");//新开项目、续建项目、完工项目
				String zylb=CommonUtil.getParameter(request, "zylb", "");//装备的各种技术类型
				String zycmc=CommonUtil.getParameter(request, "zycmc", "");//各个处室
				String define5=CommonUtil.getParameter(request, "define5", "");//技术分布
				String ktlx=CommonUtil.getParameter(request, "ktlx", "");
				
				
				
				request.setAttribute("ktlx", ktlx);
				request.setAttribute("define5", define5);
				request.setAttribute("nd", nd);
				request.setAttribute("ysnd", ysnd);
				request.setAttribute("zycmc", zycmc);
				request.setAttribute("xmmc", xmmc);
				request.setAttribute("hth", hth);
				request.setAttribute("define1", define1);
				request.setAttribute("define2", define2);
				request.setAttribute("type_flag", type_flag);
				request.setAttribute("project_property", project_property);
				request.setAttribute("project_scope", project_scope);
				request.setAttribute("zylb", zylb);
				
				String projectId=CommonUtil.getParameter(request, "projectId", "");
				request.setAttribute("projectId", projectId);
				
				
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_dic, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					 JSONArray jSONArray = responseEntity.getBody();
					 List<String> define1List = new ArrayList<String>();
					 List<String> define21List = new ArrayList<String>();//8大研究院 
					 List<String> type_flagList = new ArrayList<String>();
					 List<String> zylbList = new ArrayList<String>();
					 List<String> zycmcList = new ArrayList<String>();
					 for (int i = 0; i < jSONArray.size(); i++)
			         {
						    Map  object = (Map) jSONArray.get(i);
			                String showCode= (String)object.get("showCode");
			                String showName= (String)object.get("showName");
			                if(showCode.equals("define1"))
			                {
			                	if(showName!=null && !showName.equals(""))
			                	{
			                		define1List.add(showName);
			                	}
			                
			                }
			                if(showCode.equals("define2"))
			                {
			                	define21List.add(showName);
			                }
			                if(showCode.equals("type_flag"))
			                {
			                	type_flagList.add(showName);
			                }
			                if(showCode.equals("zylb"))
			                {
			                	zylbList.add(showName);
			                }
			                if(showCode.equals("zycmc"))
			                {
			                	zycmcList.add(showName);
			                }
			                
			          }
					 
					 request.setAttribute("define1List", define1List);
					 request.setAttribute("define21List", define21List);
					 request.setAttribute("type_flagList", type_flagList);
					 request.setAttribute("zylbList", zylbList);
					 request.setAttribute("zycmcList", zycmcList);
					 
					 
					 List<String> ktlxList = new ArrayList<String>();
					 ktlxList.add("新开课题");
					 ktlxList.add("结转课题");
					 request.setAttribute("ktlxList", ktlxList);
				}
		        return "stp/hana/home/oneLevelMain/count_table";
		  }
		
		
		 //三级表格
	    @RequestMapping(method = RequestMethod.POST, value = "/count_table_data")
		@ResponseBody
		public String count_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

	    	System.out.println(">>>>>>>>>>>>count_table_data>param:" + JSONObject.toJSONString(param));
	    	
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(count_table_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>count_table_data:" + result.toString());
			return result.toString();
		}
	    
	    /**========================================================签订率--详情  end==========================================================*/
    
		
		
		/**========================================================十条龙三级详情==========================================================*/
		@RequestMapping(method = RequestMethod.GET, value = "/ten_dragon_table")
		public String ten_dragon_table(HttpServletRequest request) throws Exception
		{
				String nd=CommonUtil.getParameter(request, "nd", DateUtil.dateToStr(DateUtil.getLastYearDay(new Date()), DateUtil.FMT_YYYY));
				
				request.setAttribute("nd", nd);
				request.setAttribute("xmfl", CommonUtil.getParameter(request, "xmfl", ""));//项目分類：(公共领域，油气勘探.....)
				request.setAttribute("xmzt", CommonUtil.getParameter(request, "xmzt", ""));//项目状态：（入龙、出龙、退龙...）
				request.setAttribute("yjy", CommonUtil.getParameter(request, "yjy", ""));//研究院：8大院等细分结构
				request.setAttribute("yjdw", CommonUtil.getParameter(request, "yjdw", ""));//一級單位：直属研究院、分子公司、集团等9种类型
				
				
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				HttpEntity<String> entity = new HttpEntity<String>(JSONObject.toJSONString(paramsMap), httpHeaders);
				
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(dragon_search_con, HttpMethod.POST, entity, JSONArray.class);
				//System.out.println(JSON.toJSONString(responseEntity.getBody()));
				
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					 JSONArray jSONArray = responseEntity.getBody();
					 List<String> xmflList = new ArrayList<String>();
					 List<String> xmztList = new ArrayList<String>();
					 List<String> yjyList = new ArrayList<String>();
					 List<String> yjdwList = new ArrayList<String>();
					
					 for (int i = 0; i < jSONArray.size(); i++)
			         {
						    Map<?,?>  object = (Map<?,?>) jSONArray.get(i);
			                String showCode= (String)object.get("showCode");
			                String showName= (String)object.get("showName");
			                if(showCode.equals("define2"))
			                {
			                	yjyList.add(showName);
			                }else if(showCode.equals("type_flag"))
			                {
			                	yjdwList.add(showName);
			                }else if(showCode.equals("xmlbmc"))
			                {
			                	xmflList.add(showName);
			                }else if(showCode.equals("status"))
			                {
			                	xmztList.add(showName);
			                }else {
			                	System.out.println("other param:"+showCode+":"+showName);
			                }
			          }
					 request.setAttribute("yjyList", yjyList);
					 request.setAttribute("yjdwList", yjdwList);
					 request.setAttribute("xmflList", xmflList);
					 request.setAttribute("xmztList", xmztList);
				}
		        return "stp/hana/home/oneLevelMain/ten_dragon_table";
		  }
		 //十条龙三级表格
	    @RequestMapping(method = RequestMethod.POST, value = "/ten_dragon_table_data")
		@ResponseBody
		public String ten_dragon_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

	    	System.out.println(">>>>>>>>>>>>ten_dragon_table_data>param:" + JSONObject.toJSONString(param));
	    	PageResult pageResult = new PageResult();

			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", param.getParam().get("nd"));
			paramsMap.put("xmmc", param.getParam().get("xmmc"));
			
			paramsMap.put("define2",  param.getParam().get("yjyItem")==""?null:param.getParam().get("yjyItem"));//研究院
			paramsMap.put("xmlbmc",  param.getParam().get("xmflItem")==""?null:param.getParam().get("xmflItem"));//项目分类
			paramsMap.put("type_flag",  param.getParam().get("yjdwItem")==""?null:param.getParam().get("yjdwItem"));//一级单位（9个机构）
			paramsMap.put("status",  param.getParam().get("xmztItem")==""?null:param.getParam().get("xmztItem"));//项目状态
			
			

			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getStlTable, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>ten_dragon_table_data jSONArray>>> " + jSONArray.toString());
				pageResult.setData(jSONArray);
				pageResult.setCode(0);
				pageResult.setCount(Long.valueOf(jSONArray.size()));
				pageResult.setLimit(1000);
				pageResult.setPage(1l);
			}
			System.out.println(">>>>>>>>>>>>>>>ten_dragon_table_data " + JSON.toJSON(pageResult).toString());
			return JSON.toJSON(pageResult).toString();
		}
	    
	    
	    
	    
	    /**========================================================签订率--详情==========================================================*/

		
		
		@RequestMapping(method = RequestMethod.GET, value = "/common_table")
		  public String common_table(HttpServletRequest request) throws Exception
		  {
			 
				
				String nd=CommonUtil.getParameter(request, "nd", "");//项目名
				String ysnd=CommonUtil.getParameter(request, "ysnd", "");//项目名
				String xmmc=CommonUtil.getParameter(request, "xmmc", "");//项目名
				String hth=CommonUtil.getParameter(request, "hth", "");//合同号
				String define1=CommonUtil.getParameter(request, "define1", "");//资本性、费用性
				String define2=CommonUtil.getParameter(request, "define2", "");//8大院等细分结构
				String define3=CommonUtil.getParameter(request, "define3", "");//直属研究院、分子公司、集团等9种类型
				String project_property=CommonUtil.getParameter(request, "project_property", "");//国家项目、重大专项、重点项目、其他项目
				String project_scope=CommonUtil.getParameter(request, "project_scope", "");//新开项目、续建项目、完工项目
				String zylb=CommonUtil.getParameter(request, "zylb", "");//装备的各种技术类型
				String zycmc=CommonUtil.getParameter(request, "zycmc", "");//各个处室
				
				String qdbz=CommonUtil.getParameter(request, "qdbz", "");//签订标识
				
				request.setAttribute("qdbz", qdbz);
				
				
				request.setAttribute("nd", nd);
				request.setAttribute("ysnd", ysnd);
				
				
				request.setAttribute("zycmc", zycmc);
				request.setAttribute("xmmc", xmmc);
				request.setAttribute("hth", hth);
				request.setAttribute("define1", define1);
				request.setAttribute("define2", define2);
				request.setAttribute("define3", define3);
				request.setAttribute("project_property", project_property);
				request.setAttribute("project_scope", project_scope);
				request.setAttribute("zylb", zylb);
				
				String projectId=CommonUtil.getParameter(request, "projectId", "");
				request.setAttribute("projectId", projectId);
				
				
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_dic, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					 JSONArray jSONArray = responseEntity.getBody();
					 List<String> define1List = new ArrayList<String>();
					 List<String> define21List = new ArrayList<String>();//8大研究院 
					 List<String> type_flagList = new ArrayList<String>();
					 List<String> zylbList = new ArrayList<String>();
					 List<String> zycmcList = new ArrayList<String>();
					 for (int i = 0; i < jSONArray.size(); i++)
			         {
						    Map  object = (Map) jSONArray.get(i);
			                String showCode= (String)object.get("showCode");
			                String showName= (String)object.get("showName");
			                if(showCode.equals("define1"))
			                {
			                	if(showName!=null && !showName.equals(""))
			                	{
			                		define1List.add(showName);
			                	}
			                
			                }
			                if(showCode.equals("define2"))
			                {
			                	define21List.add(showName);
			                }
			                if(showCode.equals("type_flag"))
			                {
			                	type_flagList.add(showName);
			                }
			                if(showCode.equals("zylb"))
			                {
			                	zylbList.add(showName);
			                }
			                if(showCode.equals("zycmc"))
			                {
			                	zycmcList.add(showName);
			                }
			                
			          }
					 
					 request.setAttribute("define1List", define1List);
					 request.setAttribute("define21List", define21List);
					 request.setAttribute("type_flagList", type_flagList);
					 request.setAttribute("zylbList", zylbList);
					 request.setAttribute("zycmcList", zycmcList);
					 
					 
					 List<String> qdbzList = new ArrayList<String>();
					 qdbzList.add("已签订");
					 qdbzList.add("未签订");
					 request.setAttribute("qdbzList", qdbzList);
				}
		        return "stp/hana/home/oneLevelMain/common_table";
		  }
		
		
		 //三级表格
	    @RequestMapping(method = RequestMethod.POST, value = "/common_table_data")
		@ResponseBody
		public String common_table_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

	    	System.out.println(">>>>>>>>>>>>common_table_data>param:" + JSONObject.toJSONString(param));
	    	
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(common_table, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>common_table:" + result.toString());
			return result.toString();
		}
	    
	    /**========================================================签订率--详情  end==========================================================*/
    

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
		
		

		@RequestMapping(method = RequestMethod.GET, value = "/knowledge_pie_01")
		@ResponseBody
		public String knowledge_pie_01(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				    System.out.println(">>>>>>>>>>>>>>knowledge_pie_01 jSONArray-> " + jSONArray.toString());
					List<Knowledge> list = JSONObject.parseArray(jSONArray.toJSONString(), Knowledge.class);
				
					
						ChartPieResultData pie = new ChartPieResultData();
						List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
						List<String> legendDataList = new ArrayList<String>();
						for (int i = 0; i < list.size(); i++) {
							Knowledge f2 = list.get(i);
							String projectName = f2.getLx();
							String value = "0";
							if(type.equals("1"))
							{
								value =f2.getApplyCount();
							}
							
							if(type.equals("2"))
							{
								value =f2.getAgreeCount();
							}
							
							
							legendDataList.add(projectName);
							dataList.add(new ChartPieDataValue(Integer.valueOf(value), projectName));
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
			System.out.println(">>>>>>>>>>>>>>knowledge_pie_01 type= "+type+" : " + resultObj.toString());
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
							Object o=contract.getQdl();
							String qdl="0";
							if(o!=null)
							{
								qdl =((BigDecimal)contract.getQdl()).toString();
							}
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
								legendDataList.add("计划签订数");
								legendDataList.add("实际签订数");
								legendDataList.add("签订率");
								barLine.setLegendDataList(legendDataList);
								//X轴数据
								List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
								ChartBarLineSeries s1 = HanaUtil.getContractChartBarLineSeries9(list, "jhqds");
								seriesList.add(s1);
								ChartBarLineSeries s2 = HanaUtil.getContractChartBarLineSeries9(list, "sjqds");
								seriesList.add(s2);
								
								ChartBarLineSeries s3 = HanaUtil.getContractChartBarLineSeries9(list, "htqdl");
								seriesList.add(s3);
								
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
					System.out.println(">>>>>>>>>>1>>>>>contract_01_01 " + resultObj.toString());
				}
				else
				{
					JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
					resault=resultObj.toString();
					System.out.println(">>>>>>>>>>>>2>>>contract_01_01 " + resultObj.toString());
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
				String str="0";
				if(jhqds_count!=0)
				{
					str=df.format(((float)sjqds_count/jhqds_count)*100);
				}
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
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
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
							if(qdbl!=null && !qdbl.toString().equals("0"))
							{
								String str=String.format("%.2f", Double.valueOf(String.valueOf(qdbl)));
								seriesDataList.add(str);
								xAxisDataList.add(define3);
							}
							
							
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
								legendDataList.add("已签");
								legendDataList.add("未签");
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
				String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
				String companyCode = CommonUtil.getParameter(request, "companyCode", "");
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("nd", nd);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_05, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						JSONArray jSONArray = responseEntity.getBody();
						System.out.println(">>>>>>>>>>>>>>>contract_05 jSONArray" + jSONArray.toString());
						
						//List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
						//List<String>  lista=HanaUtil.getduplicatexAxisByList(list,"define3");
						//List<TreeNode2>  chartCircleList=	HanaUtil.getChildChartCircleuContract02(lista,list);
						
						pageResult.setData(jSONArray);
						pageResult.setCode(0);
						pageResult.setCount(Long.valueOf(jSONArray.size()));
						//pageResult.setLimit(1000);
						//pageResult.setPage(1l);
						
						
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
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);
		request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
		request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
		String year = HanaUtil.getCurrrentYear();
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
				for (int i = 0; i < list.size(); i++)
				{
					ProjectForMysql f2 = list.get(i);
					String projectName = (String) f2.getXmlbmc();
					Integer value = (Integer) f2.getSl();
					legendDataList.add(projectName);
					dataList.add(new ChartPieDataValue(value, projectName));
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
		System.out.println(">>>>>>>>>>>>>>dragon_01 type= " + type + " : " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dragon_02")
	@ResponseBody
	public String dragon_02(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String l_nd = DateUtil.format(DateUtil.dateAdd(DateUtil.strToDate(nd, DateUtil.FMT_YYYY), -365), DateUtil.FMT_YYYY);

		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("l_nd", l_nd);
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
			// List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(),
			// ProjectForMysql.class);
			List<String> xAxisDataList = new ArrayList<String>();
			List<Object> seriesDataList = new ArrayList<Object>();
			if (jSONArray != null && jSONArray.size() > 0)
			{
				// ProjectForMysql contract = (ProjectForMysql) list.get(0);
				JSONObject obj = jSONArray.getJSONObject(0);

				Integer sqtl = obj.getInteger("sqtl");
				Integer sqcl = obj.getInteger("sqcl");
				Integer sqxm = obj.getInteger("sqxm");
				Integer tjrl = obj.getInteger("tjrl");
				Integer sqyq = obj.getInteger("sqyq");
				Integer zyxm = obj.getInteger("zyxm");

				
				xAxisDataList.add("申请休眠");
				xAxisDataList.add("申请退龙");
				xAxisDataList.add("申请出龙");
				xAxisDataList.add("入龙");
				xAxisDataList.add("申请延期");
				xAxisDataList.add("在研项目");

				
				seriesDataList.add(sqxm);
				seriesDataList.add(sqtl);
				seriesDataList.add(sqcl);
				seriesDataList.add(tjrl);
				seriesDataList.add(sqyq);
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
	public String getProjectByCountBar(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		Result result = new Result();
		ChartBarLineResultData barLine = new ChartBarLineResultData();
		String nd = CommonUtil.getParameter(request, "nd", DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
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
				List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "define2");
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

		}
		else
		{
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>dragon_03 " + resultObj.toString());
		return resultObj.toString();
	}

	// 重在集团
	@RequestMapping(method = RequestMethod.GET, value = "/getZdstlTable")
	@ResponseBody
	public String getZdstlTable(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		PageResult pageResult = new PageResult();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");
		// String type = CommonUtil.getParameter(request, "type", "重点专项");
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
			// List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(),
			// ProjectForMysql.class);
			pageResult.setData(jSONArray);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(jSONArray.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);
		}

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getZdstlTable " + resultObj.toString());
		return resultObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dragon_count")
	@ResponseBody
	public String dragon_count(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals(""))
		{
			ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(dragon_count, HttpMethod.POST, entity, JSONObject.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{

				JSONObject jSONObject = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>jSONObject -> " + jSONObject.toString());
				result.setSuccess(true);
				result.setData(jSONObject);

			}

		}
		else
		{
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		System.out.println(">>>>>>>>>>>>>dragon_count " + resultObj.toString());

		return resault;
	}

	// 十条龙
	@RequestMapping(method = RequestMethod.GET, value = "/getStlTable")
	@ResponseBody
	public String getStlTable(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		PageResult pageResult = new PageResult();
		String nd = CommonUtil.getParameter(request, "nd", DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", "");

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("companyCode", companyCode);

		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getStlTable, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			JSONArray jSONArray = responseEntity.getBody();
			System.out.println(">>>>>>>>>>>>getStlTable jSONArray>>> " + jSONArray.toString());
			// List<ProjectForMysql> list = JSONObject.parseArray(jSONArray.toJSONString(),
			// ProjectForMysql.class);
			pageResult.setData(jSONArray);
			pageResult.setCode(0);
			pageResult.setCount(Long.valueOf(jSONArray.size()));
			pageResult.setLimit(1000);
			pageResult.setPage(1l);
		}
		// JSONObject resultObj =
		// JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>getStlTable " + JSON.toJSON(pageResult).toString());
		return JSON.toJSON(pageResult).toString();
	}
	//下载报告
	@RequestMapping("/report_download/{year}")
	public void downLoadPlantRunningListInfo(HttpServletResponse res,@PathVariable("year") String year) throws IOException {
		
		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/ten_dragon/ten_dragon_report_20121120.doc");
		
		FileUtil.fileDownload(f, res);
	}
/**======================十条龙 end==================================*/

						/**======================科研投入============================*/
									
										
									
									

									  @RequestMapping(method = RequestMethod.GET, value = "/investment")
									  public String kyzb_level2(HttpServletRequest request) throws Exception
									  {
										    
										    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
										    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
										    String unitCode=userInfo.getUnitCode();
										    request.setAttribute("unitCode", unitCode);
										    request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
										    request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
										    
										    String year= HanaUtil.getCurrrentYear();
										    request.setAttribute("year", year);
									        return "stp/hana/home/oneLevelMain/investment";
									        
									  }
									
									
									@RequestMapping(method = RequestMethod.GET, value = "/investment_01")
									@ResponseBody
									public String investment_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

										Result result = new Result();
										ChartBarLineResultData barLine=new ChartBarLineResultData();
										String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
										String companyCode = CommonUtil.getParameter(request, "companyCode", "");
										Map<String, Object> paramsMap = new HashMap<String, Object>();
										paramsMap.put("nd", nd);
										paramsMap.put("companyCode", companyCode);
										JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
										HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
										if (!companyCode.equals(""))
										{
											ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_01, HttpMethod.POST, entity, JSONArray.class);
											int statusCode = responseEntity.getStatusCodeValue();
											if (statusCode == 200) 
											{
												JSONArray jSONArray = responseEntity.getBody();
												System.out.println(">>>>>>>>>>>>>>investment_01 jSONArray-> " + jSONArray.toString());
												List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
												
												
												List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define3");
								         		barLine.setxAxisDataList(xAxisDataList);
												List<String> legendDataList = new ArrayList<String>();
												legendDataList.add("费用性科研投入");
												legendDataList.add("资本性科研投入");
												barLine.setxAxisDataList(xAxisDataList);
												barLine.setLegendDataList(legendDataList);
												
												// X轴数据
												List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
												ChartBarLineSeries s1 = HanaUtil.getinvestmentChartBarLineSeries(list, "fyxsjje");
												ChartBarLineSeries s2 = HanaUtil.getinvestmentChartBarLineSeries(list, "zbxsjje");
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
										System.out.println(">>>>>>>>>>>>>>investment_01 " + resultObj.toString());
										return resultObj.toString();
									}
									
									
									@RequestMapping(method = RequestMethod.GET, value = "/investment_0101")
									@ResponseBody
									public String investment_0101(HttpServletRequest request, HttpServletResponse response) throws Exception {

										Result result = new Result();
										String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
										String companyCode = CommonUtil.getParameter(request, "companyCode", "");
										Map<String, Object> paramsMap = new HashMap<String, Object>();
										paramsMap.put("nd", nd);
										paramsMap.put("companyCode", companyCode);
										JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
										HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
										if (!companyCode.equals(""))
										{
											ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_01, HttpMethod.POST, entity, JSONArray.class);
											int statusCode = responseEntity.getStatusCodeValue();
											if (statusCode == 200) 
											{
												JSONArray jSONArray = responseEntity.getBody();
												System.out.println(">>>>>>>>>>>>>>investment_0101 jSONArray-> " + jSONArray.toString());
												List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
								         		result.setSuccess(true);
												result.setData(list);
											}
											
										} else
										{
											result.setSuccess(false);
											result.setMessage("参数为空");
										}
										JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
										System.out.println(">>>>>>>>>>>>>>investment_0101 " + resultObj.toString());
										return resultObj.toString();
									}
									
									

									//重在集团
									@RequestMapping(method = RequestMethod.GET, value = "/investment_01_01")
									@ResponseBody
									public String investment_01_01(HttpServletRequest request, HttpServletResponse response) throws Exception {
										PageResult pageResult = new PageResult();
										String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
										String companyCode = CommonUtil.getParameter(request, "companyCode", "");
										String type = CommonUtil.getParameter(request, "type", "重点专项");
										Map<String, Object> paramsMap = new HashMap<String, Object>();
										paramsMap.put("nd", nd);
										paramsMap.put("type", type);
										paramsMap.put("companyCode", companyCode);
										JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
										HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
										
											ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_01, HttpMethod.POST, entity, JSONArray.class);
											int statusCode = responseEntity.getStatusCodeValue();
											if (statusCode == 200) 
											{
												JSONArray jSONArray = responseEntity.getBody();
												System.out.println(">>>>>>>>>>>>investment_01_01 jSONArray>>> " + jSONArray.toString());
												List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
												
												for(int i=0;i<list.size();i++)
												{
													BudgetMysql budgetMysql=list.get(i);
													Object fyxRate= budgetMysql.getFyxRate();
													Object jeRate= budgetMysql.getJeRate();
													Object zbxRate= budgetMysql.getZbxRate();
													Object zRate= budgetMysql.getzRate();
													
													System.out.println(">>>>>>>>>>>> fyxRate>>> " + fyxRate);
													
													Object fyxRate_str="0";
													if(fyxRate==null)
													{
														fyxRate_str="0";
													}else if(fyxRate.toString().equals("0"))
													{
														fyxRate_str="0";
													}else
													{
														fyxRate_str=String.format("%.2f", fyxRate);
													}
													
													Object jeRate_str="0";
													
													if(jeRate==null)
													{
														jeRate_str=0;
													}else if(jeRate.toString().equals("0"))
													{
														jeRate_str="0";
													}else
													{
														jeRate_str=String.format("%.2f", jeRate);
													}
													
													Object zbxRate_str="0";
													
													if(zbxRate==null)
													{
														zbxRate_str=0;
													}else if(zbxRate.toString().equals("0"))
													{
														zbxRate_str="0";
													}else
													{
														zbxRate_str=String.format("%.2f", zbxRate);
													}
													
													Object zRate_str="0";
													if(zRate==null)
													{
														zRate_str=0;
													}else if(zRate.toString().equals("0"))
													{
														zRate_str="0";
													}else
													{
														zRate_str=String.format("%.2f", zRate);
													}
													
													budgetMysql.setFyxRate(fyxRate_str);;
													budgetMysql.setJeRate(jeRate_str);
													budgetMysql.setZbxRate(zbxRate_str);
													budgetMysql.setzRate(zRate_str);
												}
												
												pageResult.setData(list);
												pageResult.setCode(0);
												pageResult.setCount(Long.valueOf(list.size()));
												pageResult.setLimit(1000);
												pageResult.setPage(1l);
											}
											
										
										JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
										System.out.println(">>>>>>>>>>>>>>>investment_01_01 " + resultObj.toString());
										return resultObj.toString();
									}
									
									
									
									@RequestMapping(method = RequestMethod.GET, value = "/investment_02")
									@ResponseBody
									public String investment_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

										Result result = new Result();
										ChartBarLineResultData barLine=new ChartBarLineResultData();
										String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
										String companyCode = CommonUtil.getParameter(request, "companyCode", "");
										Map<String, Object> paramsMap = new HashMap<String, Object>();
										paramsMap.put("nd", nd);
										paramsMap.put("companyCode", companyCode);
										JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
										HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
										if (!companyCode.equals(""))
										{
											ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_02, HttpMethod.POST, entity, JSONArray.class);
											int statusCode = responseEntity.getStatusCodeValue();
											if (statusCode == 200) 
											{
												
												JSONArray jSONArray = responseEntity.getBody();
												System.out.println(">>>>>>>>>>>>>>investment_02 jSONArray-> " + jSONArray.toString());
												List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
												List<String>  xAxisDataList=HanaUtil.getduplicatexAxisByList(list,"define2");
								         		barLine.setxAxisDataList(xAxisDataList);
												List<String> legendDataList = new ArrayList<String>();
												legendDataList.add("实际科研投入");
												legendDataList.add("未执行");
												legendDataList.add("预算执行率");
												barLine.setxAxisDataList(xAxisDataList);
												barLine.setLegendDataList(legendDataList);
												// X轴数据
												List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
												ChartBarLineSeries s1 = HanaUtil.getinvestmentBarLineSeries2(list, "zsjje");
												ChartBarLineSeries s2 = HanaUtil.getinvestmentBarLineSeries2(list, "wxdje");
												ChartBarLineSeries ztzwcl = HanaUtil.getinvestmentBarLineSeries2(list, "jeRate");
												seriesList.add(s1);
												seriesList.add(s2);
												seriesList.add(ztzwcl);
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
										System.out.println(">>>>>>>>>>>>>>investment_02 " + resultObj.toString());
										return resultObj.toString();
									}
									
									
									
									@RequestMapping(method = RequestMethod.GET, value = "/investment_02_count")
									@ResponseBody
									public String investment_02_count(HttpServletRequest request, HttpServletResponse response) throws Exception {

										Result result = new Result();
										String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
										String companyCode = CommonUtil.getParameter(request, "companyCode", "");
										Map<String, Object> paramsMap = new HashMap<String, Object>();
										paramsMap.put("nd", nd);
										paramsMap.put("companyCode", companyCode);
										JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
										HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
										if (!companyCode.equals(""))
										{
											ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_02, HttpMethod.POST, entity, JSONArray.class);
											int statusCode = responseEntity.getStatusCodeValue();
											if (statusCode == 200) 
											{
												
												JSONArray jSONArray = responseEntity.getBody();
												System.out.println(">>>>>>>>>>>>>>investment_02_count jSONArray-> " + jSONArray.toString());
												List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
												
												
												List<Object> dataList = new ArrayList<Object>();
												if (list != null && list.size() > 0) 
												{
													for (int i = 0; i < list.size(); i++) 
													{
														BudgetMysql f03 = list.get(i);
														String zsjje =((BigDecimal)f03.getZsjje()).toString();//实际下达
														String wxdje ="0";
														Object tt=f03.getWxdje();
														if(tt!=null)
														{
															wxdje =((BigDecimal)f03.getWxdje()).toString(); //未下达
														}
														
														String zysje ="0";
														Object ttt=f03.getZysje();
														if(ttt!=null)
														{
															zysje =((BigDecimal)f03.getZysje()).toString(); //总金额
														}
														
														String jeRate ="0";
														Object o=f03.getJeRate();
														if(o!=null)
														{
															jeRate =((BigDecimal)f03.getJeRate()).toString(); 
														}
														//
														zsjje=String.format("%.4f", Double.valueOf(zsjje)/10000);
														wxdje=String.format("%.4f", Double.valueOf(wxdje)/10000);
														zysje=String.format("%.4f", Double.valueOf(zysje)/10000);
														//
														f03.setZsjje(zsjje);
														f03.setWxdje(wxdje);
														f03.setJeRate(jeRate);
														f03.setZysje(zysje);
														dataList.add(f03);
													}
												}
								         		result.setSuccess(true);
												result.setData(dataList);
												
											}
											
										} else
										{
											result.setSuccess(false);
											result.setMessage("参数为空");
										}
										JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
										System.out.println(">>>>>>>>>>>>>>investment_02_count " + resultObj.toString());
										return resultObj.toString();
									}
									
									/**=============================================新闻=========================*/
									//新闻
									@RequestMapping(method = RequestMethod.GET, value = "/get_news")
									@ResponseBody
									public String get_news(HttpServletRequest request, HttpServletResponse response) throws Exception {
										Result result = new Result();
										String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
										Map<String, Object> paramsMap = new HashMap<String, Object>();
										paramsMap.put("month", month);
										JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
										HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
										
											ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(get_news, HttpMethod.POST, entity, JSONArray.class);
											int statusCode = responseEntity.getStatusCodeValue();
											if (statusCode == 200) 
											{
												JSONArray jSONArray = responseEntity.getBody();
												System.out.println(">>>>>>>>>>>>get_news jSONArray>>> " + jSONArray.toString());
												List<SysNews> list = JSONObject.parseArray(jSONArray.toJSONString(), SysNews.class);
												for(int i=0;i<list.size();i++)
												{
													SysNews sysNews=list.get(i);
													String str="";
													String createtime=sysNews.getCreatetime();
													if(createtime!=null)
													{
														str=DateUtil.dateToStr(DateUtil.strToDate(sysNews.getCreatetime(), DateUtil.FMT_DD) , DateUtil.FMT_DD);
													}
													sysNews.setCreatetimestr(str);
												}
												result.setSuccess(true);
												result.setData(list);
											}
											
										
										JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
										return resultObj.toString();
									}
									
}
