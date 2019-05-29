package com.pcitc.web.controller.hana;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.ProjectCost;
import com.pcitc.base.hana.report.ScientificInvestment;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;
import com.pcitc.web.utils.PoiExcelExportUitl;

//项目成本
@Controller
public class ProjectCostController extends BaseController {
	 
	 private static final String kytztjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/kytztjb";
	 private static final String kytztjb_data_out_excel = "http://pcitc-zuul/hana-proxy/hana/projectCost/kytztjb_out_excel";
	 
	 
	 
	 private static final String kjjftjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/kjjftjb";
	 private static final String kjjftjb_data_out_excel = "http://pcitc-zuul/hana-proxy/hana/projectCost/kjjftjb_out_excel";
	 private static final String hxktqcbtjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/hxktqcbtjb";
	 
	 
	 private static final String kytztjb_detail = "http://pcitc-zuul/hana-proxy/hana/projectCost/kytztjb_detail";
	 private static final String kjjftjb_detail = "http://pcitc-zuul/hana-proxy/hana/projectCost/kjjftjb_detail";
	 private static final String hxktqcbtjb_detail = "http://pcitc-zuul/hana-proxy/hana/projectCost/hxktqcbtjb_detail";
	 
	 
	 
	 
	 private static final String hxktqcbtjb_data_out_excel = "http://pcitc-zuul/hana-proxy/hana/projectCost/hxktqcbtjb_out_excel";
	 
	 
	 
	 
	 
	 private static final String kytztjb_detail_out_excel = "http://pcitc-zuul/hana-proxy/hana/projectCost/kytztjb_detail_out_excel";
	 private static final String kjjftjb_detail_out_excel = "http://pcitc-zuul/hana-proxy/hana/projectCost/kjjftjb_detail_out_excel";
	 private static final String hxktqcbtjb_detail_out_excel = "http://pcitc-zuul/hana-proxy/hana/projectCost/hxktqcbtjb_detail_out_excel";
	 
	 
		
	 
	  //项目支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/xmzctjb")
	  public String xmzctjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	        return "stp/hana/projectCost/xmzctjb";
	  }
	  
	  
	  //科研投资统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/kytztjb")
	  public String kytztjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/projectCost/kytztjb";
	  }
	  
     @RequestMapping(value = "/kytztjb_data")
	 @ResponseBody
	 public String kytztjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    PageResult pageResult = new PageResult();
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		System.out.println(">>>>>>>>>>>>>>>>>>kytztjb_data>>参数      month = "+month+" companyCode="+companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!companyCode.equals(""))
		{
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kytztjb_data, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{
				JSONArray jSONArray = responseEntity.getBody();
				List<ProjectCost> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
				pageResult.setData(list);
				pageResult.setCode(0);
				pageResult.setCount(Long.valueOf(list.size()));
				pageResult.setLimit(1000);
				pageResult.setPage(1l);
			}
		} 
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
		System.out.println(">>>>>>>>>>>>>>>>>kytztjb_data " + resultObj.toString());
		return resultObj.toString();
	}
     
     

		@RequestMapping(method = RequestMethod.GET, value = "/kytztjb_data_exput_excel")
		@ResponseBody
		public String kytztjb_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			 
			this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			Map<String ,Object> paramMap = new HashMap<String ,Object>();
			paramMap.put("month", month);
			paramMap.put("companyCode", companyCode);
			System.out.println(">kytztjb_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			
			HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kytztjb_data_out_excel, HttpMethod.POST, httpEntity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			List<ScientificInvestment> list =new ArrayList();
			JSONArray jSONArray=null;
			if (statusCode == 200)
			{
				jSONArray = responseEntity.getBody();
				list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificInvestment.class);
			}
			
			
			
			    String[] headers = { "院所", "累计-计划总投资",    "累计-支出额",      "累计-承诺",    "累计-预付余额",     "累计-投资完成额", "累计-项目资金计划结余","累计-资金使用%",          "本年-投资计划",         "本年-累计支出"   , "本年-承诺",     "本年-预付款",   "本年-投资完成额",   "本年-资金计划结余",   "本年-资金使用%"};
			    String[] cols =    {"g0GSJC","k0ZTYSJE", "k0LJGLFPHJECB","k0LJSJCNJE","k0LJSJDJJE",   "k0LJSJJE",   "k0LJYSJY",     "k0LJZJSYBL",         "k0BNYSJHJE",       "k0BNGLFPHJECB","k0BNSJCNJE","k0BNSJDJJE","k0BNSJJE",     "k0BNYSJY",     "k0BNZJSYBL"};
			   
		        // 文件名默认设置为当前时间：年月日时分秒
		        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
		        // 设置response头信息
		        response.reset();
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
		        try {
			        OutputStream os = response.getOutputStream();
			        PoiExcelExportUitl<ScientificInvestment>  pee = new PoiExcelExportUitl<ScientificInvestment>(fileName, headers, cols, list,os);
			        pee.exportExcel();
		            
		        } catch (Exception e)
		        {
		            e.printStackTrace();
		            // 如果是ExcelException,则直接抛出
		            if (e instanceof ExcelException) 
		            {
		                throw (ExcelException) e;
		            } else 
		            {
		                // 否则将其他异常包装成ExcelException再抛出
		                throw new ExcelException("导出excel失败");
		            }
		        }
			   return null;
		}
		
	  
     
     
     
	  @RequestMapping(method = RequestMethod.GET, value = "/to_kytztjb_detail")
	  public String to_kytztjb_detail(HttpServletRequest request) throws Exception
	  {
		    String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			
			String companyName = CommonUtil.getParameter(request, "companyName", "");
			List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
			companyCode = HanaUtil.getCompanyCodeByName(companyCodeList, companyName);
			
			request.setAttribute("companyName", companyName);
			request.setAttribute("companyCode", companyCode);
			request.setAttribute("month", month);
			
			String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
			request.setAttribute("monthstr", monthstr);
			
	        return "stp/hana/projectCost/kytztjb_detail";
	  }
	  
	@RequestMapping(method = RequestMethod.POST, value = "/kytztjb_detail")
	@ResponseBody
	public String kytztjb_detail(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
	{

		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("companyCode", companyCode);
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(kytztjb_detail, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>kytztjb_detail:" + result.toString());
		return result.toString();
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/kytztjb_detail_out_excel")
	@ResponseBody
	public String tzxmzcqkb_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("month", month);
		paramMap.put("companyCode", companyCode);
		
		String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "" );
		String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "" );
		paramMap.put("g0PROJCODE", g0PROJCODE);
		paramMap.put("g0PROJTXT", g0PROJTXT);
		
		System.out.println(">kytztjb_detail_out_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
		
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kytztjb_detail_out_excel, HttpMethod.POST, httpEntity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		List<ProjectCost> list =new ArrayList();
		JSONArray jSONArray=null;
		if (statusCode == 200)
		{
			jSONArray = responseEntity.getBody();
			list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
			
		}
		
		
		    String[] headers = { "院所",   "项目板块",  "课题类型",   "项目编号",     "项目名称",    "计划总投资",   "累计下达投资额"  ,    "承诺",          "预付余额",      "累计投资完成额",   "项目资金计划结余" ,   "资金使用%",      "本年投资计划",     "本年累计支出"     ,     "承诺",             "本年预付款",        "本年投资完成额",     "本年资金计划结余"};
		    String[] cols =    {"g0GSJC","g0XMBK",  "g0XMLXMS","g0PROJCODE", "g0PROJTXT", "k0ZTYSJE", "k0LJGLFPHJECB",   "k0LJSJCNJE",   "k0LJSJDJJE", "k0LJSJJE",     "k0LJYSJY",      "k0LJZJSYBL",   "k0BNYSJHJE",   "k0BNGLFPHJECB" ,     "k0BNSJCNJE",     "k0BNSJDJJE",     "k0BNSJJE",     "k0BNYSJY"};
		   
	        // 文件名默认设置为当前时间：年月日时分秒
	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	        // 设置response头信息
	        response.reset();
	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	        try {
		        OutputStream os = response.getOutputStream();
		        PoiExcelExportUitl<ProjectCost>  pee = new PoiExcelExportUitl<ProjectCost>(fileName, headers, cols, list,os);
		        pee.exportExcel();
	            
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	            // 如果是ExcelException,则直接抛出
	            if (e instanceof ExcelException) 
	            {
	                throw (ExcelException) e;
	            } else 
	            {
	                // 否则将其他异常包装成ExcelException再抛出
	                throw new ExcelException("导出excel失败");
	            }
	        }
		   return null;
	}
	
	
  			
	  
	  
	  //科技经费统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/kjjftjb")
	  public String kjjftjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/projectCost/kjjftjb";
	  }
	  
	  
	  
	  
	     @RequestMapping(method = RequestMethod.GET, value = "/kjjftjb_data")
		 @ResponseBody
		 public String kjjftjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception {

		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			System.out.println(">>>>>>>>>>>>>>>>>>kjjftjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kjjftjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ProjectCost> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>kjjftjb_data " + resultObj.toString());
			return resultObj.toString();
		}
	     
	     
	     
	     
	     @RequestMapping(method = RequestMethod.GET, value = "/kjjftjb_data_out_excel")
	 	@ResponseBody
	 	public String kjjftjb_data_out_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	 	{
	 		
	 		
	 		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	 		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	 		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	 		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	 		paramMap.put("month", month);
	 		paramMap.put("companyCode", companyCode);
	 		
	 		String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "" );
	 		String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "" );
	 		paramMap.put("g0PROJCODE", g0PROJCODE);
	 		paramMap.put("g0PROJTXT", g0PROJTXT);
	 		
	 		System.out.println(">kjjftjb_data_out_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	 		
	 		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	 		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kjjftjb_data_out_excel, HttpMethod.POST, httpEntity, JSONArray.class);
	 		int statusCode = responseEntity.getStatusCodeValue();
	 		List<ProjectCost> list =new ArrayList();
	 		JSONArray jSONArray=null;
	 		if (statusCode == 200)
	 		{
	 			jSONArray = responseEntity.getBody();
	 			list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
	 			
	 		}
	 		
	 		
	 		  String[] headers = { "院所", "累计-计划总投资",    "累计-支出额",      "累计-承诺",    "累计-预付余额",     "累计-投资完成额", "累计-项目资金计划结余","累计-资金使用%",          "本年-投资计划",         "本年-累计支出"   , "本年-承诺",     "本年-预付款",   "本年-投资完成额",   "本年-资金计划结余",   "本年-资金使用%"};
			    String[] cols =    {"g0GSJC","k0ZTYSJE", "k0LJGLFPHJECB","k0LJSJCNJE","k0LJSJDJJE",   "k0LJSJJE",   "k0LJYSJY",     "k0LJZJSYBL",         "k0BNYSJHJE",       "k0BNGLFPHJECB","k0BNSJCNJE","k0BNSJDJJE","k0BNSJJE",     "k0BNYSJY",     "k0BNZJSYBL"};
			   
	 	        // 文件名默认设置为当前时间：年月日时分秒
	 	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	 	        // 设置response头信息
	 	        response.reset();
	 	        response.setContentType("application/vnd.ms-excel");
	 	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	 	        try {
	 		        OutputStream os = response.getOutputStream();
	 		        PoiExcelExportUitl<ProjectCost>  pee = new PoiExcelExportUitl<ProjectCost>(fileName, headers, cols, list,os);
	 		        pee.exportExcel();
	 	            
	 	        } catch (Exception e)
	 	        {
	 	            e.printStackTrace();
	 	            // 如果是ExcelException,则直接抛出
	 	            if (e instanceof ExcelException) 
	 	            {
	 	                throw (ExcelException) e;
	 	            } else 
	 	            {
	 	                // 否则将其他异常包装成ExcelException再抛出
	 	                throw new ExcelException("导出excel失败");
	 	            }
	 	        }
	 		   return null;
	 	}
	     
	     
	     
	     
	      @RequestMapping(method = RequestMethod.GET, value = "/to_kjjftjb_detail")
		  public String to_kjjftjb_detail(HttpServletRequest request) throws Exception
		  {
			     String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				
				//List<SysDictionary> list= HanaUtil.getDirectDepartList(request, restTemplate, httpHeaders);
				
				String companyName = CommonUtil.getParameter(request, "companyName", "");
				List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
				companyCode = HanaUtil.getCompanyCodeByName(companyCodeList, companyName);
				
				request.setAttribute("companyName", companyName);
				request.setAttribute("companyCode", companyCode);
				request.setAttribute("month", month);
				
				String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
				request.setAttribute("monthstr", monthstr);
		        return "stp/hana/projectCost/kjjftjb_detail";
		  }
	     
	     
			@RequestMapping(method = RequestMethod.POST, value = "/kjjftjb_detail")
			@ResponseBody
			public String kjjftjb_detail(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
			{

				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				System.out.println(">>>>>>>>>>kjjftjb_detail>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				
				LayuiTableData layuiTableData = new LayuiTableData();
				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(kjjftjb_detail, HttpMethod.POST, entity, LayuiTableData.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200)
				{
					layuiTableData = responseEntity.getBody();
				}
				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
				System.out.println(">>>>>>>>>>>>>kjjftjb_detail:" + result.toString());
				return result.toString();
			}

			@RequestMapping(method = RequestMethod.GET, value = "/kjjftjb_detail_out_excel")
			@ResponseBody
			public String kjjftjb_detail_out_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
			{
				
				
				this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				Map<String ,Object> paramMap = new HashMap<String ,Object>();
				paramMap.put("month", month);
				paramMap.put("companyCode", companyCode);
				System.out.println(">kytztjb_detail_out_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
				
				
				String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "" );
				String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "" );
				paramMap.put("g0PROJCODE", g0PROJCODE);
				paramMap.put("g0PROJTXT", g0PROJTXT);
				
				HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(kjjftjb_detail_out_excel, HttpMethod.POST, httpEntity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				List<ProjectCost> list =new ArrayList();
				JSONArray jSONArray=null;
				if (statusCode == 200)
				{
					jSONArray = responseEntity.getBody();
					list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
					
				}
				
				
				    String[] headers = { "院所",   "项目板块",  "课题类型",   "项目编号",     "项目名称",    "计划总投资",   "累计下达投资额"  ,    "承诺",          "预付余额",      "累计投资完成额",   "项目资金计划结余" ,   "资金使用%",      "本年投资计划",     "本年累计支出"     ,     "承诺",             "本年预付款",        "本年投资完成额",     "本年资金计划结余"};
				    String[] cols =    {"g0GSJC","g0XMBK",  "g0XMLXMS","g0PROJCODE", "g0PROJTXT", "k0ZTYSJE", "k0LJGLFPHJECB",   "k0LJSJCNJE",   "k0LJSJDJJE", "k0LJSJJE",     "k0LJYSJY",      "k0LJZJSYBL",   "k0BNYSJHJE",   "k0BNGLFPHJECB" ,     "k0BNSJCNJE",     "k0BNSJDJJE",     "k0BNSJJE",     "k0BNYSJY"};
				   
			        // 文件名默认设置为当前时间：年月日时分秒
			        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
			        // 设置response头信息
			        response.reset();
			        response.setContentType("application/vnd.ms-excel");
			        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
			        try {
				        OutputStream os = response.getOutputStream();
				        PoiExcelExportUitl<ProjectCost>  pee = new PoiExcelExportUitl<ProjectCost>(fileName, headers, cols, list,os);
				        pee.exportExcel();
			            
			        } catch (Exception e)
			        {
			            e.printStackTrace();
			            // 如果是ExcelException,则直接抛出
			            if (e instanceof ExcelException) 
			            {
			                throw (ExcelException) e;
			            } else 
			            {
			                // 否则将其他异常包装成ExcelException再抛出
			                throw new ExcelException("导出excel失败");
			            }
			        }
				   return null;
			}
			
			
	  
	  
	  
	  
	  //横向课题全成本统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/hxktqcbtjb")
	  public String hxktqcbtjb(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			String month = HanaUtil.getCurrrent_Year_Moth();
			request.setAttribute("month", month);
	        return "stp/hana/projectCost/hxktqcbtjb";
	  }
	  
	  
	   
	     @RequestMapping(method = RequestMethod.GET, value = "/hxktqcbtjb_data")
		 @ResponseBody
		 public String hxktqcbtjb_data(HttpServletRequest request, HttpServletResponse response) throws Exception 
	     {
		    PageResult pageResult = new PageResult();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
			System.out.println(">>>>>>>>>>>>>>>>>>hxktqcbtjb_data>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			if (!companyCode.equals(""))
			{
				ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(hxktqcbtjb_data, HttpMethod.POST, entity, JSONArray.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					JSONArray jSONArray = responseEntity.getBody();
					List<ProjectCost> list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
					pageResult.setData(list);
					pageResult.setCode(0);
					pageResult.setCount(Long.valueOf(list.size()));
					pageResult.setLimit(1000);
					pageResult.setPage(1l);
				}
			} 
			JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>>>>>hxktqcbtjb_data " + resultObj.toString());
			return resultObj.toString();
		}
	     
	     
	     
	     

	     @RequestMapping(method = RequestMethod.GET, value = "/hxktqcbtjb_data_out_excel")
	 	@ResponseBody
	 	public String hxktqcbtjb_data_out_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	 	{
	 		
	 		
	 		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	 		String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	 		String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	 		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	 		paramMap.put("month", month);
	 		paramMap.put("companyCode", companyCode);
	 		
	 		String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "" );
	 		String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "" );
	 		paramMap.put("g0PROJCODE", g0PROJCODE);
	 		paramMap.put("g0PROJTXT", g0PROJTXT);
	 		
	 		System.out.println(">hxktqcbtjb_data_out_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	 		
	 		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	 		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(hxktqcbtjb_data_out_excel, HttpMethod.POST, httpEntity, JSONArray.class);
	 		int statusCode = responseEntity.getStatusCodeValue();
	 		List<ProjectCost> list =new ArrayList();
	 		JSONArray jSONArray=null;
	 		if (statusCode == 200)
	 		{
	 			jSONArray = responseEntity.getBody();
	 			list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
	 			
	 		}
	 		
	 		   String[] headers = { "院所", "累计-收入",         "累计-计划总投资","累计-下达投资额",      "累计-承诺",    "累计-预付余额",     "累计-投资完成额", "累计-项目资金计划结余","累计-资金使用%",          "本年-收入",         "本年-投资计划" , "本年-累计支出",   "本年-承诺",     "本年-预付款",   "本年-投资完成额",   "本年-资金计划结余",   "本年-资金使用%"};
			    String[] cols =   {"g0GSJC","k0LJGLFPHJESR", "k0ZTYSJE",   "k0LJGLFPHJECB","k0LJSJCNJE","k0LJSJDJJE",    "k0LJSJJE",    "k0LJYSJY",       "k0LJZJSYBL",          "k0BNGLFPHJESR",  "k0BNYSJHJE", "k0BNGLFPHJECB","k0BNSJCNJE","k0BNSJDJJE",  "k0BNSJJE",     "k0BNYSJY",     "k0BNZJSYBL"};
			   
			   
	 	        // 文件名默认设置为当前时间：年月日时分秒
	 	        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
	 	        // 设置response头信息
	 	        response.reset();
	 	        response.setContentType("application/vnd.ms-excel");
	 	        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
	 	        try {
	 		        OutputStream os = response.getOutputStream();
	 		        PoiExcelExportUitl<ProjectCost>  pee = new PoiExcelExportUitl<ProjectCost>(fileName, headers, cols, list,os);
	 		        pee.exportExcel();
	 	            
	 	        } catch (Exception e)
	 	        {
	 	            e.printStackTrace();
	 	            // 如果是ExcelException,则直接抛出
	 	            if (e instanceof ExcelException) 
	 	            {
	 	                throw (ExcelException) e;
	 	            } else 
	 	            {
	 	                // 否则将其他异常包装成ExcelException再抛出
	 	                throw new ExcelException("导出excel失败");
	 	            }
	 	        }
	 		   return null;
	 	}
	     
	     
	     
	     
	     @RequestMapping(method = RequestMethod.GET, value = "/to_hxktqcbtjb_detail")
		  public String to_hxktqcbtjb_detail(HttpServletRequest request) throws Exception
		  {
	    	 String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				
				String companyName = CommonUtil.getParameter(request, "companyName", "");
				List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
				companyCode = HanaUtil.getCompanyCodeByName(companyCodeList, companyName);
				
				request.setAttribute("companyName", companyName);
				request.setAttribute("companyCode", companyCode);
				request.setAttribute("month", month);
				
				String monthstr =DateUtil.dateToStr(DateUtil.strToDate(month, DateUtil.FMT_MM), DateUtil.FMT_YYYY_ZH);
				request.setAttribute("monthstr", monthstr);
		        return "stp/hana/projectCost/hxktqcbtjb_detail";
		  }
	     
	     
	  			@RequestMapping(method = RequestMethod.POST, value = "/hxktqcbtjb_detail")
	  			@ResponseBody
	  			public String hxktqcbtjb_detail(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
	  			{

	  				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
	  				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
	  				System.out.println(">>>>>>>>>>kjjftjb_detail>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
	  				Map<String, Object> paramsMap = new HashMap<String, Object>();
	  				paramsMap.put("month", month);
	  				paramsMap.put("companyCode", companyCode);
	  				
	  				LayuiTableData layuiTableData = new LayuiTableData();
	  				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
	  				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(hxktqcbtjb_detail, HttpMethod.POST, entity, LayuiTableData.class);
	  				int statusCode = responseEntity.getStatusCodeValue();
	  				if (statusCode == 200)
	  				{
	  					layuiTableData = responseEntity.getBody();
	  				}
	  				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
	  				System.out.println(">>>>>>>>>>>>>hxktqcbtjb_detail:" + result.toString());
	  				return result.toString();
	  			}
	     
	  			@RequestMapping(method = RequestMethod.GET, value = "/hxktqcbtjb_detail_out_excel")
				@ResponseBody
				public String hxktqcbtjb_detail_out_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
				{
					
					
					this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
					String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
					String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
					Map<String ,Object> paramMap = new HashMap<String ,Object>();
					paramMap.put("month", month);
					paramMap.put("companyCode", companyCode);
					
					
					String g0PROJCODE = CommonUtil.getParameter(request, "g0PROJCODE", "" );
					String g0PROJTXT = CommonUtil.getParameter(request, "g0PROJTXT", "" );
					paramMap.put("g0PROJCODE", g0PROJCODE);
					paramMap.put("g0PROJTXT", g0PROJTXT);
			    	
					System.out.println(">hxktqcbtjb_detail_out_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
					
					HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
					ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(hxktqcbtjb_detail_out_excel, HttpMethod.POST, httpEntity, JSONArray.class);
					int statusCode = responseEntity.getStatusCodeValue();
					List<ProjectCost> list =new ArrayList();
					JSONArray jSONArray=null;
					if (statusCode == 200)
					{
						jSONArray = responseEntity.getBody();
						list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCost.class);
						
					}
					
					
					    String[] headers = { "院所",   "项目板块",  "课题类型",   "项目编号",     "项目名称",    "累计收入",         "计划总投资 "  ,    "累计下达投资额",          "承诺",                  "预付余额",         "累计投资完成额",   "项目资金计划结余" ,   "资金使用%", };
					    String[] cols =    {"g0GSJC","g0XMBK",  "g0XMLXMS","g0PROJCODE", "g0PROJTXT", "k0LJGLFPHJESR", "k0ZTYSJE",     "k0LJGLFPHJECB",       "k0LJSJCNJE",          "k0LJSJDJJE"       ,  "k0LJSJJE",     "k0LJYSJY",       "k0LJZJSYBL"};
					   
				        // 文件名默认设置为当前时间：年月日时分秒
				        String fileName = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
				        // 设置response头信息
				        response.reset();
				        response.setContentType("application/vnd.ms-excel");
				        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
				        try {
					        OutputStream os = response.getOutputStream();
					        PoiExcelExportUitl<ProjectCost>  pee = new PoiExcelExportUitl<ProjectCost>(fileName, headers, cols, list,os);
					        pee.exportExcel();
				            
				        } catch (Exception e)
				        {
				            e.printStackTrace();
				            // 如果是ExcelException,则直接抛出
				            if (e instanceof ExcelException) 
				            {
				                throw (ExcelException) e;
				            } else 
				            {
				                // 否则将其他异常包装成ExcelException再抛出
				                throw new ExcelException("导出excel失败");
				            }
				        }
					   return null;
				}
				
	  
	  
	  
}
