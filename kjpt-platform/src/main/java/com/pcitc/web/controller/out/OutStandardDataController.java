package com.pcitc.web.controller.out;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutStandardData;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class OutStandardDataController extends BaseController 
{
	private static final String BUDGET_ORGAN_GET = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-get/";
	private static final String BUDGET_ORGAN_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-list";
	private static final String BUDGET_ORGAN_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-table";
	private static final String BUDGET_ORGAN_SAVE = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-save";
	private static final String BUDGET_ORGAN_UPD = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-upd";
	private static final String BUDGET_ORGAN_SAVEORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-saveorupd";
	private static final String BUDGET_ORGAN_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-del/";
	private static final String BUDGET_ORGAN_COUNT = "http://pcitc-zuul/stp-proxy/stp-provider/out/out-standarddata-count";
	
	

	
	@RequestMapping(method = RequestMethod.GET, value = "/out/out_standarddata_main")
	public Object toOutStandardDataMainPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", DateUtil.format(DateUtil.getNextYearDay(new Date()), DateUtil.FMT_YYYY));
		return "stp/out/out_standarddata_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/out/out_standarddata_edit")
	public Object toOutStandardDataEditPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("nd", request.getParameter("nd"));
		return "stp/out/out_standarddata_edit";
	}
	
	@RequestMapping(value = "/out/out-standarddata-get", method = RequestMethod.POST)
	@ResponseBody
	public Object getOutStandardData(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_GET+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/out/out-standarddata-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getOutStandardDataTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/out/out-standarddata-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getOutStandardDataList(@ModelAttribute("bean") OutStandardData bean,HttpServletRequest request) throws IOException 
	{
		
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_LIST, HttpMethod.POST, new HttpEntity<OutStandardData>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/out/out-standarddata-del", method = RequestMethod.POST)
	@ResponseBody
	public Object delOutStandardData(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_DEL+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/out/out-standarddata-upd", method = RequestMethod.POST)
	@ResponseBody
	public Object updOutStandardData(@ModelAttribute("bean") OutStandardData bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_UPD, HttpMethod.POST, new HttpEntity<OutStandardData>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/out/out-standarddata-save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveOutStandardData(@ModelAttribute("bean") OutStandardData bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_SAVE, HttpMethod.POST, new HttpEntity<OutStandardData>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/out/out-standarddata-saveorupd", method = RequestMethod.POST)
	@ResponseBody
	public Object saveOrupdOutStandardData(@ModelAttribute("bean") OutStandardData bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_SAVEORUPD, HttpMethod.POST, new HttpEntity<OutStandardData>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/out/out-standarddata-count", method = RequestMethod.POST)
	@ResponseBody
	public Object getProjectInfoCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer prject = this.restTemplate.exchange(BUDGET_ORGAN_COUNT, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
		return JSON.toJSON(prject);
	}
}
