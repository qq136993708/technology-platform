package com.pcitc.web.controller.budget;

import java.io.IOException;
import java.util.Date;

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
import com.pcitc.base.stp.budget.BudgetOtherPayMoney;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

@Controller
public class BudgetOtherPayMoneyController extends BaseController 
{
	private static final String BUDGET_OTHERPAYMONEY_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-otherpaymoney-get/";
	private static final String BUDGET_OTHERPAYMONEY_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-otherpaymoney-list";
	private static final String BUDGET_OTHERPAYMONEY_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-otherpaymoney-table";
	private static final String BUDGET_OTHERPAYMONEY_SAVE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-otherpaymoney-save";
	private static final String BUDGET_OTHERPAYMONEY_UPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-otherpaymoney-upd";
	private static final String BUDGET_OTHERPAYMONEY_SAVEORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-otherpaymoney-saveorupd";
	private static final String BUDGET_OTHERPAYMONEY_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-otherpaymoney-del/";

	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_otherpaymoney_main")
	public Object toBudgetOtherPayMoneyMainPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("nd", DateUtil.format(DateUtil.getNextYearDay(new Date()), DateUtil.FMT_YYYY));
		return "stp/budget/budget_otherpaymoney_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_otherpaymoney_edit")
	public Object toBudgetOtherPayMoneyEditPage(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("dataId", request.getParameter("dataId"));
		request.setAttribute("nd", request.getParameter("nd"));
		return "stp/budget/budget_otherpaymoney_edit";
	}
	
	@RequestMapping(value = "/budget/budget-otherpaymoney-get", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOtherPayMoney(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_OTHERPAYMONEY_GET+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-otherpaymoney-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOtherPayMoneyTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_OTHERPAYMONEY_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-otherpaymoney-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetOtherPayMoneyList(@ModelAttribute("bean") BudgetOtherPayMoney bean,HttpServletRequest request) throws IOException 
	{
		
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_OTHERPAYMONEY_LIST, HttpMethod.POST, new HttpEntity<BudgetOtherPayMoney>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-otherpaymoney-del", method = RequestMethod.POST)
	@ResponseBody
	public Object delBudgetOtherPayMoney(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_OTHERPAYMONEY_DEL+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-otherpaymoney-upd", method = RequestMethod.POST)
	@ResponseBody
	public Object updBudgetOtherPayMoney(@ModelAttribute("bean") BudgetOtherPayMoney bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_OTHERPAYMONEY_UPD, HttpMethod.POST, new HttpEntity<BudgetOtherPayMoney>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-otherpaymoney-save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveBudgetOtherPayMoney(@ModelAttribute("bean") BudgetOtherPayMoney bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_OTHERPAYMONEY_SAVE, HttpMethod.POST, new HttpEntity<BudgetOtherPayMoney>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/budget-otherpaymoney-saveorupd", method = RequestMethod.POST)
	@ResponseBody
	public Object saveOrupdBudgetOtherPayMoney(@ModelAttribute("bean") BudgetOtherPayMoney bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_OTHERPAYMONEY_SAVEORUPD, HttpMethod.POST, new HttpEntity<BudgetOtherPayMoney>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
}
