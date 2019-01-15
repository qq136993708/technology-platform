package com.pcitc.web.controller.hana;

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
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

//项目成本
@Controller
public class ProjectCostController {
	 @Autowired
	 private HttpHeaders httpHeaders;
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 private static final String kytztjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/kytztjb";
	 private static final String kjjftjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/kjjftjb";
	 private static final String hxktqcbtjb_data = "http://pcitc-zuul/hana-proxy/hana/projectCost/hxktqcbtjb";
	 
		
	 
	  //项目支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/xmzctjb")
	  public String xmzctjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/projectCost/xmzctjb";
	  }
	  
	  
	  //科研投资统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/kytztjb")
	  public String kytztjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/projectCost/kytztjb";
	  }
	  
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/kytztjb_data")
		@ResponseBody
		public String kytztjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(kytztjb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>kytztjb_data:" + result.toString());
			return result.toString();
		}
	  
	  //科技经费统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/kjjftjb")
	  public String kjjftjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/projectCost/kjjftjb";
	  }
	  
	  
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/kjjftjb_data")
		@ResponseBody
		public String kjjftjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(kjjftjb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>kjjftjb_data:" + result.toString());
			return result.toString();
		}
	  
	  
	  
	  //横向课题全成本统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/hxktqcbtjb")
	  public String hxktqcbtjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/projectCost/hxktqcbtjb";
	  }
	  
	  
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/hxktqcbtjb_data")
		@ResponseBody
		public String hxktqcbtjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(hxktqcbtjb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>hxktqcbtjb_data:" + result.toString());
			return result.toString();
		}
	  
	  
}
