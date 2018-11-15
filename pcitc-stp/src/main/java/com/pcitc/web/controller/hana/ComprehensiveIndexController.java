package com.pcitc.web.controller.hana;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

//综合指标
@Controller
public class ComprehensiveIndexController {
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/decision/get";
	
	  //综合指标
	  @RequestMapping(method = RequestMethod.GET, value = "/ci/zhzb")
	  public String zhzb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/comprehensiveIndex/zhzb";
	  }
}
