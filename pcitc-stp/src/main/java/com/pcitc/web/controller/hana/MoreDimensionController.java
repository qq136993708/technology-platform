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

/**
 * 多维 分析
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/more-dimension")
public class MoreDimensionController extends BaseController {
	
	
	
	 //课题研发支出多维分析表
	  @RequestMapping(method = RequestMethod.GET, value = "/ktyfzcdwfxb")
	  public String ktyfzcdwfxb(HttpServletRequest request) throws Exception
	  {
		   String month=HanaUtil.getCurrrent_YearMoth();
		   request.setAttribute("month", month);
	        return "stp/hana/moreDimension/ktyfzcdwfxb";
	  }
	
	 //专利申报情况明细分析表
	  @RequestMapping(method = RequestMethod.GET, value = "/zlsbqkmxfxb")
	  public String zlsbqkmxfxb(HttpServletRequest request) throws Exception
	  {
		  String month=HanaUtil.getCurrrent_YearMoth();
		   request.setAttribute("month", month);
	        return "stp/hana/moreDimension/zlsbqkmxfxb";
	  }
	  
	  // 专利申请授权情况明细分析表
	  @RequestMapping(method = RequestMethod.GET, value = "/zlsqsqqkmxfxb")
	  public String zlsqsqqkmxfxb(HttpServletRequest request) throws Exception
	  {
		  String month=HanaUtil.getCurrrent_YearMoth();
		   request.setAttribute("month", month);
	        return "stp/hana/moreDimension/zlsqsqqkmxfxb";
	  }
	  
	  //成果鉴定明细分析表
	  @RequestMapping(method = RequestMethod.GET, value = "/cgjdmxfxb")
	  public String cgjdmxfxb(HttpServletRequest request) throws Exception
	  {
		  String month=HanaUtil.getCurrrent_YearMoth();
		   request.setAttribute("month", month);
	        return "stp/hana/moreDimension/cgjdmxfxb";
	  }
	  
	  //科技奖励情况明细分析表
	  @RequestMapping(method = RequestMethod.GET, value = "/kjjlqkmxfxb")
	  public String kjjlqkmxfxb(HttpServletRequest request) throws Exception
	  {
		  String month=HanaUtil.getCurrrent_YearMoth();
		   request.setAttribute("month", month);
	        return "stp/hana/moreDimension/kjjlqkmxfxb";
	  }
	  
	  
	  
	  
	
	
	/**
	  *专利年度趋势分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/knowledge/patent-trend-analysis")
	 public String loopContractExecutionAwards(HttpServletRequest request) throws Exception
	 {
		    
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/moreDimension/knowledge/patent-trend-analysis";
	 }
	 
	 
	 
	 
	 
	 
	 /**
	  *项目成果年度趋势分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/achievements/trend-analysis")
	 public String loopContractExecutionAchievements(HttpServletRequest request) throws Exception
	 {
		    
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/moreDimension/achievement/achievements-trend-analysis";
	 }
	 
	 
	 
	 
	 
	 /**
	  *多维分析-成果鉴定涉及项目分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/achievements/project-analysis")
	 public String achievementsproject(HttpServletRequest request) throws Exception
	 {
		    
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/moreDimension/achievement/achievements-project-analysis";
	 }
	 /**
	  *成果鉴定涉及专利专家分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/achievements/patent-analysis")
	 public String achievementpatent(HttpServletRequest request) throws Exception
	 {
		    
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/moreDimension/achievement/achievements-patent-analysis";
	 }
	 
	 
	 /**
	  *科技奖励年度趋势分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/science/trend-analysis")
	 public String science(HttpServletRequest request) throws Exception
	 {
		    
		 
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/moreDimension/science/science-trend-analysis";
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /**
	  *科技奖励涉及项目分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/science/project-analysis")
	 public String scienceproject(HttpServletRequest request) throws Exception
	 {
		    
		 
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			 List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
				request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/moreDimension/science/science-project-analysis";
	 }
	 
	 
	 
	 
	 
	 /**
	  *科技奖励涉及专利专家分析
	 * @param request
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.GET, value = "/science/patent-analysis")
	 public String sciencepatent(HttpServletRequest request) throws Exception
	 {
		    
		 SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	     HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
			List<ProjectCode> projectCodeList=HanaUtil.getProjectCode(restTemplate,httpHeaders);
		    request.setAttribute("projectCodeList",projectCodeList);
	        return "stp/hana/moreDimension/science/science-patent-analysis";
	 }
	  
}
