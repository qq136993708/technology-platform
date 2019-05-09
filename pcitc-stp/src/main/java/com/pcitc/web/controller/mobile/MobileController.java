package com.pcitc.web.controller.mobile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.HanaUtil;

@Controller
@RequestMapping(value = "/mobile")
public class MobileController extends BaseController {
	
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
		return "/mobile/index";
	}
	
	/**================================================科研投入 begin =====================================*/
	@RequestMapping(value = "/kytr")
	public String kytr(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
		return "/mobile/kytr";
	}
	
	/**================================================科研投入 end =====================================*/
	
	
    /**================================================科研合同 begin =====================================*/
	
	@RequestMapping(value = "/kyht")
	public String kyht(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
		return "/mobile/kyht";
	}
	
	
	/**===============================================科研合同 end =====================================*/
	
	
	
	
	
    /**================================================科研装备  begin =====================================*/
	@RequestMapping(value = "/kyzb")
	public String kyzb(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
	    
	    String month = HanaUtil.getCurrrentYearMoth();
		request.setAttribute("month", month);
	    
	    String  companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
	    request.setAttribute("companyCode", companyCode);
		return "/mobile/kyzb";
	}
	/**================================================科研装备 end =====================================*/
	
	
	
    /**================================================科研支出  begin =====================================*/
	@RequestMapping(value = "/kyzc")
	public String kyzc(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String  companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
	    request.setAttribute("companyCode", companyCode);
		String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);
	    
	    String month = HanaUtil.getCurrrentYearMoth();
		request.setAttribute("month", month);
		
		
		  request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
		    request.setAttribute("YJY_CODE_ALL", HanaUtil.YJY_CODE_ALL);
		    
		return "/mobile/kyzc";
	}
	/**================================================科研支出 end =====================================*/
	
	
	
	  /**================================================现金流量  begin =====================================*/
		@RequestMapping(value = "/xjll")
		public String xjll(HttpServletRequest request, HttpServletResponse response) throws Exception 
		{
			
			String year= HanaUtil.getCurrrentYear();
		    request.setAttribute("year", year);
		    String month = HanaUtil.getCurrrentYearMoth();
			request.setAttribute("month", month);
		    
			String  allCode=HanaUtil.YJY_CODE_NOT_YINGKE;
		    request.setAttribute("allCode", allCode);
		    String  companyCode=HanaUtil.YJY_CODE_NOT_YINGKE;
		    request.setAttribute("companyCode", companyCode);
		    
			return "/mobile/xjll";
		}
		/**================================================现金流量 end =====================================*/
		
	
	
	
		  /**================================================成果专利  begin =====================================*/
				@RequestMapping(value = "/cgzl")
				public String cgzl(HttpServletRequest request, HttpServletResponse response) throws Exception 
				{
					
					String year= HanaUtil.getCurrrentYear();
				    request.setAttribute("year", year);
				    
					return "/mobile/cgzl";
				}
				/**================================================成果专利 end =====================================*/
				
			
	
	
	
	
	
	

}
