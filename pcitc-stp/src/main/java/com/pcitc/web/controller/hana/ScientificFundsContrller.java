package com.pcitc.web.controller.hana;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.ScientificFunds;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

//科技经费
@Controller
public class ScientificFundsContrller {
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	private static final String ktzjjfytjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/ktzjjfytjb";
	private static final String rgcbzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/rgcbzctjb";
	private static final String yclzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/yclzctjb";
	private static final String nhzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/nhzctjb";
	private static final String xmzjlxfx_data = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/xmzjlxfx";
	private static final String investment_02 = "http://pcitc-zuul/system-proxy/out-project-plna-provider/money/complete-rate/institute";
	
	//人工成本支出统计表-详情
	private static final String getRgcbzctjbData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/rgcbzctjb_detail";
	//课题直间接费用统计表-详情
    private static final String getKtzjjfytjbData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getKtzjjfytjbData_detail";
    //原材料支出统计表-详情
    private static final String getYclzctjbData_Detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getYclzctjbData_Detail";
    //能耗支出统计表-详情
    private static final String getNhzctjbData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getNhzctjbData_detail";
    //项目资金流向分析-详情
    private static final String getXmzjlxfxData_detail = "http://pcitc-zuul/hana-proxy/hana/scientific_funds/getXmzjlxfxData_detail";
	
	  //年度经费预算合同签订进度分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ndjfyshtqdjdfx")
	  public String ndjfyshtqdjdfx(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser2(userInfo,restTemplate,httpHeaders,request);
		    
		    String year = HanaUtil.getCurrrentYear();
			request.setAttribute("year", year);
	        return "stp/hana/scientificFunds/ndjfyshtqdjdfx";
	  }
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/ndjfyshtqdjdfx_data_01")
		@ResponseBody
		public String ndjfyshtqdjdfx_data_01(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Result result = new Result();
			String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("nd", nd);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!nd.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(investment_02, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					
					JSONArray jSONArray = responseEntity.getBody();
					System.out.println(">>>>>>>>>>>>>>ndjfyshtqdjdfx_data_01 jSONArray-> " + jSONArray.toString());
					List<BudgetMysql> list = JSONObject.parseArray(jSONArray.toJSONString(), BudgetMysql.class);
					ChartPieResultData pie = new ChartPieResultData();
					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					for (int i = 0; i < list.size(); i++) {
						BudgetMysql f2 = list.get(i);
						String projectName = f2.getDefine2();
						String value =((BigDecimal)f2.getZsjje()).toString();
						value=String.format("%.2f", Double.valueOf(value)/10000);
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
			System.out.println(">>>>>>>>>>>>>>ndjfyshtqdjdfx_data_01 " + resultObj.toString());
			return resultObj.toString();
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  //年度预算合同签订差异多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ndyshtqdcydwfx")
	  public String ndyshtqdcydwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/ndyshtqdcydwfx";
	  }
	  //科研经费综合多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/kyjfzhdwfx")
	  public String kyjfzhdwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/kyjfzhdwfx";
	  }
	  
	  //课题科研资金使用多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ktkyzjsydwfx")
	  public String ktkyzjsydwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/ktkyzjsydwfx";
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  //课题直间接费用统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ktzjjfytjb")
	  public String ktzjjfytjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser2(userInfo,restTemplate,httpHeaders,request);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/ktzjjfytjb";
	  }
	  
	  
	        ////数据控制配置（直属院）
		   @RequestMapping(method = RequestMethod.GET, value = "/getDirDeparetMentList")
		   @ResponseBody
		   public Result getDirDeparetMentList(HttpServletRequest request, HttpServletResponse response) throws Exception 
	       {
			    Result resultsDate = new Result();
			    String functionId = CommonUtil.getParameter(request, "functionId", "");
			    List<SysDictionary>  sysDictionaryList=EquipmentUtils.getDirDeparetMentList( functionId , restTemplate, httpHeaders);
			    resultsDate.setData(sysDictionaryList);
			    resultsDate.setSuccess(true);
				return resultsDate;
				
	       }
		   
		   
		   

			/*@RequestMapping(params="action=getAreaJson")
			public String getAreaJson(HttpServletRequest request,HttpServletResponse response) throws Exception 
			{
				 
				 Long parentId=CommonUtil.getParameterLong(request, "parentId", null);
		         Area criteria=new Area();
		         if(parentId==null)
		         {
		        	 criteria.setSqlStr(" t.`parent` IS NULL ");
		         }else
		         {
		        	 criteria.setParent(parentId);
		         }
		         criteria.setOrderBySql("");
				 List<Area> list=commonService.getAreaList(criteria); 
				 response.setContentType("text/json;charset=utf-8");
				 response.setHeader("Cache-Control", "no-cache");
				 JSONArray ja=JSONArray.fromObject(list);
			     PrintWriter out = response.getWriter();
			     out.write(ja.toString());
			     out.close();
			     return null;
			}
			*/
			
			
	  
	       @RequestMapping(method = RequestMethod.GET, value = "/ktzjjfytjb_data")
		   @ResponseBody
		   public String ktzjjfytjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception 
	       {
	    	   
	    	   String functionId = CommonUtil.getParameter(request, "functionId", "");
			    List<SysDictionary>  sysDictionaryList=EquipmentUtils.getDirDeparetMentList( functionId , restTemplate, httpHeaders);
		    
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				// 课题直间接费用统计表
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(ktzjjfytjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>ktzjjfytjb_data " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getKtzjjfytjbData_detail")
	  public String to_ktzjjfytjbData_detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
	      return "stp/hana/scientificFunds/getKtzjjfytjbData_detail";
	  }
	  
	  
	  
	  
		//课题直间接费用统计表-详情
	    @RequestMapping(method = RequestMethod.GET, value = "/getKtzjjfytjbData_detail")
		@ResponseBody
		public String getKtzjjfytjbData_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getKtzjjfytjbData_detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getKtzjjfytjbData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>getKtzjjfytjbData_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  

				
				
	  //人工成本支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/rgcbzctjb")
	  public String rgcbzctjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser2(userInfo,restTemplate,httpHeaders,request);
			
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/rgcbzctjb";
	  }
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/rgcbzctjb_data")
		@ResponseBody
		public String rgcbzctjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		  PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(rgcbzctjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>rgcbzctjb_data " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getRgcbzctjbData_detail")
	  public String rgcbzctjb_data_detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>to_getRgcbzctjbData_detail>参数      month = "+month+" companyName="+companyName);
		  
		  
	      return "stp/hana/scientificFunds/getRgcbzctjbData_detail";
	  }
	  
	  
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/rgcbzctjb_data_detail")
		@ResponseBody
		public String rgcbzctjb_data_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>rgcbzctjb_data_detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				// 科研经费预算投入年度趋势分析
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getRgcbzctjbData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>人工成本支出统计表>>rgcbzctjb_data_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  
	  
	  
	  
	  
		
	  
	  //原材料支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/yclzctjb")
	  public String yclzctjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser2(userInfo,restTemplate,httpHeaders,request);
			
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/yclzctjb";
	  }
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/yclzctjb_data")
			@ResponseBody
			public String yclzctjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

			  PageResult pageResult = new PageResult();
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				// System.out.println(">>>>>>>>>>>>>>>>>>yclzctjb_data>>参数      month = "+month+" companyCode="+companyCode);
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				if (!companyCode.equals("")) {
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(yclzctjb_data, HttpMethod.POST, entity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) {
						JSONArray jSONArray = responseEntity.getBody();
						List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
						pageResult.setData(list);
						pageResult.setCode(0);
						pageResult.setCount(Long.valueOf(list.size()));
						pageResult.setLimit(1000);
						pageResult.setPage(1l);
					}
				} 
				JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
				System.out.println(">>>>>>>>>>>>>>>>>yclzctjb_data " + resultObj.toString());
				return resultObj.toString();

			}
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getYclzctjbData_Detail")
	  public String to_getYclzctjbData_Detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
	      return "stp/hana/scientificFunds/getYclzctjbData_Detail";
	  }
	  
	    @RequestMapping(method = RequestMethod.GET, value = "/getYclzctjbData_Detail")
		@ResponseBody
		public String getYclzctjbData_Detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getYclzctjbData_Detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				// 科研经费预算投入年度趋势分析
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getYclzctjbData_Detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>rgcbzctjb_data_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  
	  
	  
	  //能耗支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/nhzctjb")
	  public String nhzctjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			//HanaUtil.setSearchParaForUser2(userInfo,restTemplate,httpHeaders,request);
			
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/nhzctjb";
	  }
	  
	  
	  
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/nhzctjb_data")
		@ResponseBody
		public String nhzctjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		  PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			// System.out.println(">>>>>>nhzctjb_data>>>>>>>>>>>>yclzctjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) {
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(nhzctjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>nhzctjb_data " + resultObj.toString());
			return resultObj.toString();

		}

	  
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getNhzctjbData_detail")
	  public String getNhzctjbData_detail(HttpServletRequest request) throws Exception
	  {

		  String month = CommonUtil.getParameter(request, "month", "");
		  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
		  request.setAttribute("month", month);
		  request.setAttribute("companyName", companyName);
	      return "stp/hana/scientificFunds/getNhzctjbData_detail";
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/getNhzctjbData_detail")
		@ResponseBody
		public String getNhzctjbData_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getNhzctjbData_detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getNhzctjbData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>能耗支出统计表>>>>>getNhzctjbData_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  
	  
	  
	  
	  
	  //项目资金流向分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/xmzjlxfx")
	  public String xmzjlxfx(HttpServletRequest request) throws Exception
	  {
		    
		  
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser2(userInfo,restTemplate,httpHeaders,request);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/scientificFunds/xmzjlxfx";
	  }
	  
	  
	  
	  
	     @RequestMapping(method = RequestMethod.POST, value = "/xmzjlxfx_data")
		 @ResponseBody
		 public String xmzjlxfx_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			System.out.println(">>>>>>xmzjlxfx_data>>>>>>>>>>>>yclzctjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(xmzjlxfx_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) {
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>xmzjlxfx_data " + resultObj.toString());
			return resultObj.toString();
		}

	     
	     
	     
	     @RequestMapping(method = RequestMethod.GET, value = "/sf/to_getXmzjlxfxData_detail")
		  public String getXmzjlxfxData_detail(HttpServletRequest request) throws Exception
		  {

			  String month = CommonUtil.getParameter(request, "month", "");
			  String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			  request.setAttribute("month", month);
			  request.setAttribute("companyName", companyName);
		      return "stp/hana/scientificFunds/getXmzjlxfxData_detail";
		  }
	     
	     
	     
	    @RequestMapping(method = RequestMethod.GET, value = "/getXmzjlxfxData_detail")
		@ResponseBody
		public String getXmzjlxfxData_detail(HttpServletRequest request, HttpServletResponse response) throws Exception 
	    {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyName = CommonUtil.getParameter(request, "companyName", HanaUtil.YJY_CODE_NOT_YINGKE);
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			String companyCode =	HanaUtil.getCompanyCodeByName( companyCodeList,companyName);
			if(companyCode.equals(""))
			{
				companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
			}
			 System.out.println(">>>>>>>>>>>>>>>>>>>>getXmzjlxfxData_detail>参数      month = "+month+" companyCode="+companyCode+" companyName="+companyName);
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals("")) 
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getXmzjlxfxData_detail, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ScientificFunds> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificFunds.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>项目资金流向分析>>>>>getXmzjlxfxData_detail " + resultObj.toString());
			return resultObj.toString();

		}
	  
	  
	  //加计扣除模拟分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/jjkcmnfx")
	  public String jjkcmnfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/jjkcmnfx";
	  }
	  
	  
}
