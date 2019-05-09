package com.pcitc.web.controller.mobile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

@RestController
@RequestMapping(value = "/mobile")
public class MobileController extends BaseController {
	
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		return "/mobile/index";
	}
	
	/**================================================科研投入 begin =====================================*/
	@RequestMapping(value = "/kytr")
	public String kytr(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		return "/mobile/kytr";
	}
	
	/**================================================科研投入 end =====================================*/
	
	
    /**================================================科研合同 begin =====================================*/
	
	@RequestMapping(value = "/kyht")
	public String kyht(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		return "/mobile/kyht";
	}
	
	
	/**===============================================科研合同 end =====================================*/
	
	
	
	
	
    /**================================================科研装备  begin =====================================*/
	@RequestMapping(value = "/kyzb")
	public String kyzb(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		return "/mobile/kyzb";
	}
	/**================================================科研装备 end =====================================*/
	
	
	
    /**================================================科研支出  begin =====================================*/
	@RequestMapping(value = "/kyzc")
	public String kyzc(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		return "/mobile/kyzc";
	}
	/**================================================科研支出 end =====================================*/
	
	
	
	
	
	
	
	

}
