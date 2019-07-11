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
import com.pcitc.base.stp.budget.BudgetOrganItems;
import com.pcitc.web.common.BaseController;

@Controller
public class BudgetOrganItemsController extends BaseController 
{
	private static final String BUDGET_ORGANITEMS_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organitems-get/";
	private static final String BUDGET_ORGANITEMS_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organitems-list";
	private static final String BUDGET_ORGANITEMS_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organitems-table";
	private static final String BUDGET_ORGANITEMS_SAVE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organitems-save";
	private static final String BUDGET_ORGANITEMS_UPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organitems-upd";
	private static final String BUDGET_ORGANITEMS_SAVEORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organitems-saveorupd";
	private static final String BUDGET_ORGANITEMS_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-organitems-del/";

	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_organitems_main")
	public Object toBudgetOrganItemsMainPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_organitems_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_organitems_edit")
	public Object toBudgetOrganItemsEditPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_organitems_edit";
	}
	
	@RequestMapping(value = "/budget/budget-organitems-get", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOrganItems(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGANITEMS_GET+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organitems-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOrganItemsTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGANITEMS_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organitems-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOrganItemsList(@ModelAttribute("bean") BudgetOrganItems bean,HttpServletRequest request) throws IOException 
	{
		
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGANITEMS_LIST, HttpMethod.POST, new HttpEntity<BudgetOrganItems>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organitems-del", method = RequestMethod.POST)
	@ResponseBody
	public Object delBudgetOrganItems(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGANITEMS_DEL+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organitems-upd", method = RequestMethod.POST)
	@ResponseBody
	public Object updBudgetOrganItems(@ModelAttribute("bean") BudgetOrganItems bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGANITEMS_UPD, HttpMethod.POST, new HttpEntity<BudgetOrganItems>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organitems-save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetOrganItems(@ModelAttribute("bean") BudgetOrganItems bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGANITEMS_SAVE, HttpMethod.POST, new HttpEntity<BudgetOrganItems>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-organitems-saveorupd", method = RequestMethod.POST)
	@ResponseBody
	public Object saveOrupdBudgetOrganItems(@ModelAttribute("bean") BudgetOrganItems bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_ORGANITEMS_SAVEORUPD, HttpMethod.POST, new HttpEntity<BudgetOrganItems>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
}
