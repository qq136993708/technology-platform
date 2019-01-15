package com.pcitc.web.controller.hana;

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

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

//科研投资
@Controller
public class ScientificInvestmentController {
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String tzxmwcqktjb_data = "http://pcitc-zuul/hana-proxy/hana/scientificInvestment/tzxmwcqktjb";
	private static final String tzxmcgjdtjb_data = "http://pcitc-zuul/hana-proxy/hana/scientificInvestment/tzxmcgjdtjb";
	private static final String tzxmzcqkb_data =   "http://pcitc-zuul/hana-proxy/hana/scientificInvestment/tzxmzcqkb";
	
	
	
	
	  //投资项目完成情况统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/si/tzxmwcqktjb")
	  public String jtgszbkjjfys(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			
			 
	        return "stp/hana/scientificInvestment/tzxmwcqktjb";
	  }
	  
		// 三级表格
			@RequestMapping(method = RequestMethod.POST, value = "/tzxmwcqktjb_data")
			@ResponseBody
			public String tzxmwcqktjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
			{

				
				String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
				String companyCode = CommonUtil.getParameter(request, "companyCode", HanaUtil.YJY_CODE_NOT_YINGKE);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("month", month);
				paramsMap.put("companyCode", companyCode);
				
				LayuiTableData layuiTableData = new LayuiTableData();
				HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
				ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(tzxmwcqktjb_data, HttpMethod.POST, entity, LayuiTableData.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200)
				{
					layuiTableData = responseEntity.getBody();
				}
				JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
				System.out.println(">>>>>>>>>>>>>zlsbqkmxfxb_data:" + result.toString());
				return result.toString();
			}

			
	  
	  //投资项目采购进度统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/si/tzxmcgjdtjb")
	  public String tzxmcgjdtjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/scientificInvestment/tzxmcgjdtjb";
	  }
	  
	  
	  
	    @RequestMapping(method = RequestMethod.POST, value = "/tzxmcgjdtjb_data")
		@ResponseBody
		public String tzxmcgjdtjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

	    	
	    	String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(tzxmcgjdtjb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>tzxmcgjdtjb_data:" + result.toString());
			return result.toString();
		}
	  
	  
	  //投资项目转出情况表
	  @RequestMapping(method = RequestMethod.GET, value = "/si/tzxmzcqkb")
	  public String tzxmzcqkb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
			HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/scientificInvestment/tzxmzcqkb";
	  }
	  
	  
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/tzxmzcqkb_data")
		@ResponseBody
		public String tzxmzcqkb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

		  
		  String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = "+month+" companyCode="+companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(tzxmzcqkb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>tzxmzcqkb_data:" + result.toString());
			return result.toString();
		}
	  
	  
	  
	  
}
