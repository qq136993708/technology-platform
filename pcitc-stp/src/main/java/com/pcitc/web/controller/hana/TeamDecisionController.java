package com.pcitc.web.controller.hana;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.pcitc.web.common.BaseController;

//团队决策
@Controller
public class TeamDecisionController extends BaseController {
	
	private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/decision/get";
	
	  //项目领军人物辅助甄选
	  @RequestMapping(method = RequestMethod.GET, value = "/tc/zhxmljrwfzzxzb")
	  public String xmljrwfzzx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/teamDecision/xmljrwfzzx";
	  }
	  
	  
	 //项目团队构成辅助建议
	  @RequestMapping(method = RequestMethod.GET, value = "/tc/xmtdgcfzjy")
	  public String xmtdgcfzjy(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/teamDecision/xmtdgcfzjy";
	  }
}
