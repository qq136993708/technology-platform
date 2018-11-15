package com.pcitc.web.controller.hana;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

//科研投资
@Controller
public class ScientificInvestmentController {
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	  //投资项目完成情况统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/si/tzxmwcqktjb")
	  public String jtgszbkjjfys(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificInvestment/tzxmwcqktjb";
	  }
	  
	  //投资项目采购进度统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/si/tzxmcgjdtjb")
	  public String tzxmcgjdtjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificInvestment/tzxmcgjdtjb";
	  }
	  
	  
	  //投资项目转出情况表
	  @RequestMapping(method = RequestMethod.GET, value = "/si/tzxmzcqkb")
	  public String tzxmzcqkb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificInvestment/tzxmzcqkb";
	  }
	  
	  
	  
	  
}
