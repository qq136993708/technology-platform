package com.pcitc.web.controller.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobileController extends BaseController {

	/**
	 * ================================================科研投入 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/kytr")
	public String kytr(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/kytr";
	}

	/**
	 * ================================================科研投入 end
	 * =====================================
	 */

	/**
	 * ================================================科研合同 begin
	 * =====================================
	 */

	@RequestMapping(value = "/mobile/kyht")
	public String kyht(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/kyht";
	}

	/**
	 * ===============================================科研合同 end
	 * =====================================
	 */

	/**
	 * ================================================科研装备 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/kyzb")
	public String kyzb(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);

		String month = HanaUtil.getCurrrentYear_Moth();
		request.setAttribute("month", month);

		String companyCode = HanaUtil.YJY_CODE_NOT_YINGKE;
		request.setAttribute("companyCode", companyCode);
		return "/mobile/kyzb";
	}

	/**
	 * ================================================科研装备 end
	 * =====================================
	 */

	/**
	 * ================================================科研支出 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/kyzc")
	public String kyzc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);

		String month = HanaUtil.getCurrrentYear_Moth();
		request.setAttribute("month", month);

		return "/mobile/kyzc";
	}
	
	
	
	
	

	/**
	 * ================================================科研支出 end
	 * =====================================
	 */

	/**
	 * ================================================现金流量 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/xjll")
	public String xjll(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);
		String month = HanaUtil.getCurrrentYear_Moth();
		request.setAttribute("month", month);

		return "/mobile/xjll";
	}

	/**
	 * ================================================现金流量 end
	 * =====================================
	 */

	/**
	 * ================================================成果专利 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/cgzl")
	public String cgzl(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);

		return "/mobile/cgzl";
	}
	@RequestMapping(value = "/mobile/zhfxChart")
	public String zhfxChart(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrrentYear();
		request.setAttribute("nd", nd);

		return "/mobile/zhfxChart";
	}
	
	@RequestMapping(value = "/mobile/zhfxTable")
	public String zhfxTable(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrrentYear();
		request.setAttribute("year", year);

		return "/mobile/zhfxTable";
	}
	
	@RequestMapping(value = "/mobile/index2")
	public String index2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrrentYear();
		request.setAttribute("year", year);

		return "/mobile/index2";
	}

	
	
	@RequestMapping(value = "/mobile/zhfxTable3")
	public String zhfxTable3(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrrentYear();
		request.setAttribute("year", year);

		return "/mobile/zhfxTable3";
	}
	

}
