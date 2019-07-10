package com.pcitc.web.controller.budget;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

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
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.web.common.BaseController;

@Controller
public class BudgetOrganController extends BaseController 
{
	private static final String BUDGET_ORGAN_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organ-get/";
	private static final String BUDGET_ORGAN_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organ-list";
	private static final String BUDGET_ORGAN_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organ-table";
	private static final String BUDGET_ORGAN_SAVE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organ-save";
	private static final String BUDGET_ORGAN_UPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organ-upd";
	private static final String BUDGET_ORGAN_SAVEORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organ-saveorupd";
	private static final String BUDGET_ORGAN_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organ-del/";

	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_organ_main")
	public Object toBudgetOrganMainPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_organ_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_organ_edit")
	public Object toBudgetOrganEditPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_organ_edit";
	}
	
	@RequestMapping(value = "/budget/budget-organ-get", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOrgan(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_GET+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organ-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOrganTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organ-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOrganList(@ModelAttribute("bean") BudgetOrgan bean,HttpServletRequest request) throws IOException 
	{
		
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_LIST, HttpMethod.POST, new HttpEntity<BudgetOrgan>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organ-del", method = RequestMethod.POST)
	@ResponseBody
	public Object delBudgetOrgan(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_DEL+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organ-upd", method = RequestMethod.POST)
	@ResponseBody
	public Object updBudgetOrgan(@ModelAttribute("bean") BudgetOrgan bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_UPD, HttpMethod.POST, new HttpEntity<BudgetOrgan>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organ-save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetOrgan(@ModelAttribute("bean") BudgetOrgan bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_SAVE, HttpMethod.POST, new HttpEntity<BudgetOrgan>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organ-saveorupd", method = RequestMethod.POST)
	@ResponseBody
	public Object saveOrupdBudgetOrgan(@ModelAttribute("bean") BudgetOrgan bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGAN_SAVEORUPD, HttpMethod.POST, new HttpEntity<BudgetOrgan>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
}
