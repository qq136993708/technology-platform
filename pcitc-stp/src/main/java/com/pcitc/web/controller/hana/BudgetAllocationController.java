package com.pcitc.web.controller.hana;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

//预算分配
@Controller
public class BudgetAllocationController {
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	  //集团公司总部科技经费预算（建议稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/jtgszbkjjfys")
	  public String jtgszbkjjfys(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/jtgszbkjjfys";
	  }
	  
	  
	//资产公司总部科技项目经费预算（建议稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/zcgszbkjxmjfys")
	  public String zcgszbkjxmjfys(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/zcgszbkjxmjfys";
	  }
	//股份公司总部科技经费预算（调整稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfgszbkjjfystzg")
	  public String gfgszbkjjfystzg(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfgszbkjjfystzg";
	  }
	//股份公司总部科技经费预算（建议稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfgszbkjjfysjyg")
	  public String gfgszbkjjfysjyg(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfgszbkjjfysjyg";
	  }
	//处部门科技经费预算总表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/cbmkjjfyszb")
	  public String cbmkjjfyszb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/cbmkjjfyszb";
	  }
	//集团经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/jtjfysmxb")
	  public String jtjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/jtjfysmxb";
	  }
	//资产经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/zcjfysmxb")
	  public String zcjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/zcjfysmxb";
	  }
	
	//股份（直属院）经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfzsyjfysmxb")
	  public String gfzsyjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfzsyjfysmxb";
	  }
	//股份（系统外及集团）经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfxtwjjtjfysmxb")
	  public String gfxtwjjtjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfxtwjjtjfysmxb";
	  }
	//股份（分子公司）预算
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gffzgsys")
	  public String gffzgsys(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gffzgsys";
	  }
	//股份炼油事业部、化工事业部B2、C类科技经费预算表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gflysybhgsybB2Clkjjfysb")
	  public String gflysybhgsybB2Clkjjfysb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gflysybhgsybB2Clkjjfysb";
	  }
	//股份公司科技专项经费预算表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfgskjzxjfysb")
	  public String gfgskjzxjfysb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfgskjzxjfysb";
	  }
	
}
