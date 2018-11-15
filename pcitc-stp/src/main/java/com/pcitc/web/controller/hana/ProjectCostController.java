package com.pcitc.web.controller.hana;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

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
	
	private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/decision/get";
	
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
	  
	  //科技经费统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/kjjftjb")
	  public String kjjftjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/projectCost/kjjftjb";
	  }
	  
	  
	  //横向课题全成本统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/pc/hxktqcbtjb")
	  public String hxktqcbtjb(HttpServletRequest request) throws Exception
	  {
		  SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		  HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/projectCost/hxktqcbtjb";
	  }
	  
	  
	  
	  
	  
	  
}
