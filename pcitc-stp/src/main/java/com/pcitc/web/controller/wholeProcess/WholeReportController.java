package com.pcitc.web.controller.wholeProcess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.common.BaseController;

/**
 * 全流程可视化报告
 * @author uuy
 *
 */
@Controller
public class WholeReportController extends BaseController 
{
	
	private static final String PROJECT_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/report-project-list";
	
	
	//国家项目
	@RequestMapping(value = "/whole-process/report/national_project")
	public String toNationalProjectReportPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/nationalProjectReport";
	}
	
	@RequestMapping(value = "/whole-process/report/national-project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outNationalProjectList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/whole-process/report/national-project-list");
		param.getParam().put("project_property", "国家项目");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		return JSON.toJSON(retJson).toString();
	}
	
	
	
	//十条龙项目
	@RequestMapping(value = "/whole-process/report/tendragon_project")
	public String toTenDragonProjectReportPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("====/whole-process/report/tendragon_project  page.......");
		return "/stp/wholeProcess/tenLongProjectReport";
	}
	
	
	@RequestMapping(value = "/whole-process/report/tendragon-project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outTendragonProjectList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/whole-process/report/tendragon-project-list");
		param.getParam().put("project_property", "十条龙项目");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		System.out.println("tendragon return ....... ");
		System.out.println(JSON.toJSONString(retJson));
		return JSON.toJSON(retJson).toString();
	}
	
	
	//重大项目
	@RequestMapping(value = "/whole-process/report/major_project")
	public String toMajorProjectReportPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/stp/wholeProcess/majorProjectReport";
	}
	
	@RequestMapping(value = "/whole-process/report/major-project-list", method = RequestMethod.POST)
	@ResponseBody
	public Object outMajorProjectList(@ModelAttribute("param") LayuiTableParam param) {

		System.out.println("====/whole-process/report/major-project-list");
		param.getParam().put("project_property", "重大专项");
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();
		return JSON.toJSON(retJson).toString();
	}
	
	
	
	@RequestMapping(value = "/whole-process/project_detail/{dataId}", method = RequestMethod.GET)
	public String iniOutProjectShow(@PathVariable("dataId") String dataId, HttpServletRequest request) {
		return "/stp/wholeProcess/projectDetail";
	}
}
