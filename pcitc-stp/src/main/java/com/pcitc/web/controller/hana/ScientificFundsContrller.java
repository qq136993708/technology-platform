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

//科技经费
@Controller
public class ScientificFundsContrller {
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/decision/get";
	
	  //年度经费预算合同签订进度分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ndjfyshtqdjdfx")
	  public String ndjfyshtqdjdfx(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/scientificFunds/ndjfyshtqdjdfx";
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
		    
	        return "stp/hana/scientificFunds/ktzjjfytjb";
	  }
	  
	  //人工成本支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/rgcbzctjb")
	  public String rgcbzctjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/rgcbzctjb";
	  }
	  
	  //原材料支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/yclzctjb")
	  public String yclzctjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/yclzctjb";
	  }
	  //能耗支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/nhzctjb")
	  public String nhzctjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/nhzctjb";
	  }
	  
	  //项目资金流向分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/xmzjlxfx")
	  public String xmzjlxfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/xmzjlxfx";
	  }
	  
	  //加计扣除模拟分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/jjkcmnfx")
	  public String jjkcmnfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/jjkcmnfx";
	  }
	  
	  
}
