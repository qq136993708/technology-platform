package com.pcitc.web.controller.wholeProcess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.web.common.BaseController;

/**
 * 全流程可视化报告
 * @author uuy
 *
 */
@Controller
public class WholeReportController extends BaseController 
{
	//国家项目
	@RequestMapping(value = "/whole-process/report/national_project")
	public String toNationalProjectReportPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/nationalProjectReport";
	}
	//十条龙项目
	@RequestMapping(value = "/whole-process/report/tendragon_project")
	public String toTenDragonProjectReportPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/tenDragonProjectReport";
	}
	//重大项目
	@RequestMapping(value = "/whole-process/report/major_project")
	public String toMajorProjectReportPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/majorProjectReport";
	}
	
	
	@RequestMapping(value = "/whole-process/project_detail/{dataId}", method = RequestMethod.GET)
	public String iniOutProjectShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		return "/stp/wholeProcess/projectDetail";
	}
}
