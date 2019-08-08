package com.pcitc.web.controller.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobileController extends BaseController {
	
	
	
	
	@RequestMapping(value = "/mobile/budget")
	public String budget(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/budget";
	}
	
	
	/**
	 * ================================================科研合同 begin
	 * =====================================
	 */

	@RequestMapping(value = "/mobile/contract")
	public String contract(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/contract";
	}
	
	/**
	 * ================================================科研投入 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/project")
	public String project(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String nd = CommonUtil.getParameter(request, "nd",HanaUtil.getCurrentYear());// 项目名
		String ysnd = CommonUtil.getParameter(request, "ysnd", "");// 项目名
		String xmmc = CommonUtil.getParameter(request, "xmmc", "");// 项目名
		String hth = CommonUtil.getParameter(request, "hth", "");// 合同号
		String define1 = CommonUtil.getParameter(request, "define1", "");// 资本性、费用性
		String define2 = CommonUtil.getParameter(request, "define2", "");// 8大院等细分结构
		String define3 = CommonUtil.getParameter(request, "define3", "");// 直属研究院、分子公司、集团等9种类型
		String project_property = CommonUtil.getParameter(request, "project_property", "");// 国家项目、重大专项、重点项目、其他项目
		String project_scope = CommonUtil.getParameter(request, "project_scope", "");// 新开项目、续建项目、完工项目
		String zylb = CommonUtil.getParameter(request, "zylb", "");// 装备的各种技术类型
		String define10 = CommonUtil.getParameter(request, "define10", "");// 各个处室
		String qdbz = CommonUtil.getParameter(request, "qdbz", "");// 签订标识
		String define11 = CommonUtil.getParameter(request, "define11", "");// 费用来源
		String define12 = CommonUtil.getParameter(request, "define12", "");// 单位类别
		String fzdwflag = CommonUtil.getParameter(request, "fzdwflag", "承担单位");
		String groupFlag = CommonUtil.getParameter(request, "groupFlag", "");// 查询分组条件
		request.setAttribute("fzdwflag", fzdwflag);
		request.setAttribute("define12", define12);
		request.setAttribute("define11", define11);
		request.setAttribute("qdbz", qdbz);
		request.setAttribute("nd", nd);
		request.setAttribute("ysnd", ysnd);
		request.setAttribute("define10", define10);
		request.setAttribute("xmmc", xmmc);
		request.setAttribute("hth", hth);
		request.setAttribute("define1", define1);
		request.setAttribute("define2", define2);
		request.setAttribute("define3", define3);
		request.setAttribute("project_property", project_property);
		request.setAttribute("project_scope", project_scope);
		request.setAttribute("zylb", zylb);
		request.setAttribute("groupFlag", groupFlag);
		String projectId = CommonUtil.getParameter(request, "projectId", "");
		request.setAttribute("projectId", projectId);
		
		
		
		
		return "/mobile/project";
	}
	
	
	
	
	/**
	 * ================================================现金流
	 */
	@RequestMapping(value = "/mobile/cash")
	public String cash(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String month = HanaUtil.getCurrentYearMoth();
		request.setAttribute("month", month);
		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		
		return "/mobile/cash";
	}
	

	/**
	 * ================================================科研投入 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/kytr")
	public String kytr(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/kytr";
	}

	/**
	 * ================================================科研投入 end
	 * =====================================
	 */

	

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

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		String month = HanaUtil.getCurrentYear_Moth();
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
		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		String month = HanaUtil.getCurrentYear_Moth();
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

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		String month = HanaUtil.getCurrentYear_Moth();
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

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		return "/mobile/cgzl";
	}
	
	@RequestMapping(value = "/mobile/zhfxChart")
	public String zhfxChart(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		return "/mobile/zhfxChart";
	}
	
	@RequestMapping(value = "/mobile/zhfxTable")
	public String zhfxTable(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);

		return "/mobile/zhfxTable";
	}
	
	@RequestMapping(value = "/mobile/index2")
	public String index2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);

		return "/mobile/index2";
	}

	
	
	@RequestMapping(value = "/mobile/zhfxTable3")
	public String zhfxTable3(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);

		return "/mobile/zhfxTable3";
	}
	

}
