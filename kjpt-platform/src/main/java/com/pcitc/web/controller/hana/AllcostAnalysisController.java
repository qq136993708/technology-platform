package com.pcitc.web.controller.hana;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "/allcost-analysis")
public class AllcostAnalysisController {
	
	
	
	
	 /**
	  * 资产费用分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/assets")
	 public String assets(HttpServletRequest request) 
	 {
		    
	        return "stp/hana/cost/assets";
	 }
	 
	 
	 
	 /**
	  * 经营状况分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/operating-conditions")
	 public String operatingConditions(HttpServletRequest request) 
	 {
		    
	        return "stp/hana/cost/operating-conditions";
	 }
	 
	 
	 
	 /**
	  * 现金流量分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/cash-flow")
	 public String cashFlow(HttpServletRequest request) 
	 {
		    
	        return "stp/hana/cost/cash-flow";
	 }
	 
	 
	 /**
	  *利润分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/profit")
	 public String profit(HttpServletRequest request) 
	 {
		    
	        return "stp/hana/cost/profit";
	 }

	 
	 

}
