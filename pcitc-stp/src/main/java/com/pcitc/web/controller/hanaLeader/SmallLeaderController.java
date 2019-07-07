package com.pcitc.web.controller.hanaLeader;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class SmallLeaderController extends BaseController{

	
	
	/**
	 * ===================================知识产权--专利==============================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/knowledgePatent")
	public String knowledgePatent(HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		String nd = HanaUtil.getBeforeYear();
		request.setAttribute("nd", nd);
		return "stp/hana/home/small_leader/knowledgePatent";
	}
	
	/**
	 * ==========================================成果数量分析========================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/achievement")
	public String achievement(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		String nd = HanaUtil.getBeforeYear();
		request.setAttribute("nd", nd);
		return "stp/hana/home/small_leader/achievement";
	}
	
	
	/**
	 * ==========================================合同签订==========================
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/contract")
	public String contract(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		String year = HanaUtil.getBeforeYear();
		request.setAttribute("year", year);
		return "stp/hana/home/small_leader/contract";
	}
	
	
	
	
	
	/**
	 * =========================================科研课题============================
	 * =====
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/topic")
	public String topic(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		String year = HanaUtil.getBeforeYear();
		request.setAttribute("year", year);
		return "stp/hana/home/small_leader/topic";
	}
	
	
	
	
	
	/**
	 * =========================================科研装备课题==========================
	 * =======
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/equipment")
	public String equipment(HttpServletRequest request) throws Exception {

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		String unitCode = userInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		String year = HanaUtil.getBeforeYear();
		request.setAttribute("year", year);
		String month = HanaUtil.getCurrrentYear_Moth();
		request.setAttribute("month", year + "-" + month.substring(5));
		return "stp/hana/home/small_leader/equipment";
	}
	
	
	
	/**
	 * =========================================经费==========================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/actualPay")
	public String actualPay(HttpServletRequest request) throws Exception {

		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		String year = HanaUtil.getCurrrentYear();
		request.setAttribute("year", year);
		String month = HanaUtil.getCurrrentYear_Moth();
		request.setAttribute("month", month);
		String isdisplay = CommonUtil.getParameter(request, "isdisplay", "");
		request.setAttribute("isdisplay", isdisplay);
		return "stp/hana/home/small_leader/actualPay";
	}
	
	/**
	 * =========================================国际合作==========================
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/small_leader/intl_cooperation")
	public String intl_cooperation(HttpServletRequest request) throws Exception {

		return "stp/hana/home/small_leader/intl_cooperation";
	}
	
}
