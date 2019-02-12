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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.web.common.BaseController;
/**
 * 集团预算总表
 * @author fb
 *
 */
@Controller
public class BudgetGroupTotalController extends BaseController {

	private static final String BUDGET_GROUPTOTAL_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-info-table";
	private static final String BUDGET_GROUPTOTAL_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-info-list";
	private static final String BUDGET_GROUPTOTAL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-items";
	private static final String BUDGET_GROUPTOTAL_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-blank-grouptotal";
	private static final String BUDGET_GROUPTOTAL_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-create-template-grouptotal";
	private static final String BUDGET_GROUPTOTAL_DELETE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-del";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_group_page")
	public Object toBudgetGroupPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_group";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_group_edit")
	public Object toBudgetGroupEditPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_group_edit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_group_add")
	public Object toBudgetGroupAddPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget_group_add";
	}
	@RequestMapping(value = "/budget/budget_group_info_list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget_group_info_table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-grouptotal-items", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-grouptotal-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-grouptotal-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/budget/budget-grouptotal-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_DELETE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
}
