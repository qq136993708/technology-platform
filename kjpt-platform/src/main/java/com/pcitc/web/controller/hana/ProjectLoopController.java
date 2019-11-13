package com.pcitc.web.controller.hana;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;
@Controller
@RequestMapping(value = "/project-loop")
public class ProjectLoopController extends BaseController {
	
	
	private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/decision/get";
	 
	 /**========================================================闭环========================================================*/
	 
	 
	 /**
	  * 科研项目闭环分析-统一页面
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-plan-common")
	 public String loopplan(HttpServletRequest request) throws Exception
	 {
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
				
	        return "stp/hana/decision/project/loop/loop-plan";
	 }
	 
	 /**
	  * 科研项目闭环分析-计划立项
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-plan-setup")
	 public String scientificProjectsLoopAnalysisPlan(HttpServletRequest request) throws Exception
	 {
		    
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
			
	        return "stp/hana/decision/project/loop/loop-plan-setup";
	 }
	 
	 
	 /**
	  * 科研项目闭环分析--预算批复
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-gudget-reply")
	 public String scientificProjectsLoopAnalysisGudget(HttpServletRequest request) throws Exception
	 {
		    
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/decision/project/loop/loop-gudget-reply";
	 }
	 
	 
	 /**
	  * 科研项目闭环分析--合同执行-数量
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-contract-execution-count")
	 public String loopContractExecutionCount(HttpServletRequest request) throws Exception
	 {
		    
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/decision/project/loop/loop-contract-execution-count";
	 }
	 
	 /**
	  * 科研项目闭环分析--合同执行-金额
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-contract-execution-money")
	 public String loopContractExecutionmoney(HttpServletRequest request) throws Exception
	 {
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
		    request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/decision/project/loop/loop-contract-execution-money";
	 }
	 
	 
	 /**
	  *科研项目闭环分析-成果鉴定
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-achievement-checkup")
	 public String loopContractExecutionCheckup(HttpServletRequest request) throws Exception
	 {
		 
		          SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		          HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			      List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				  request.setAttribute("projectCodeList",projectCodeList);
	              return "stp/hana/decision/project/loop/loop-achievement-checkup";
	 }
	 
	 
	 /**
	  *科研项目闭环分析-科技奖励
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-scientific-awards")
	 public String loopContractExecutionAwards(HttpServletRequest request) throws Exception
	 {

		        SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		        HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/decision/project/loop/loop-scientific-awards";
	 }
	 /**
	  *科研项目闭环分析-关闭
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/loop-scientific-close")
	 public String loopContractExecutionClose(HttpServletRequest request) throws Exception
	 {
		        SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	            HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			    List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	            return "stp/hana/decision/project/loop/loop-scientific-close";
	 }
	 

}
