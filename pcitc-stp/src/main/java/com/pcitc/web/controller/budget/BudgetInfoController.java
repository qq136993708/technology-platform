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
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.InputCheckUtil;

@Controller
public class BudgetInfoController extends BaseController
{

	private static final String BUDGET_INFO_FINAL_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-final-list";
	private static final String BUDGET_GET_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-get/";
	private static final String BUDGET_INFO_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-list";
	private static final String BUDGET_INFO_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-table";
	private static final String BUDGET_INFO_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-del";
	private static final String BUDGET_INFO_CREATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-create";
	private static final String BUDGET_INFO_CREATE_BYTEMPLATE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-create-bytemplate";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_total")
	public Object toBudgetInfoTotalAddPage(HttpServletRequest request) throws IOException 
	{
		
		String nd = request.getParameter("nd");
		String budgetType = request.getParameter("budgetType");
		//验证输入有效性年度 和 预算类型
		if(!InputCheckUtil.check(InputCheckUtil.pub_nd, nd) || !InputCheckUtil.check(InputCheckUtil.budget_budgettype, budgetType)) {
			return "error";
		}
		request.setAttribute("nd", nd);
		request.setAttribute("budgetType", budgetType);
		return "stp/budget/budget_create_all_total";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_create_split")
	public Object toBudgetInfoSplitAddPage(HttpServletRequest request) throws IOException 
	{
		String nd = request.getParameter("nd");
		String budgetType = request.getParameter("budgetType");
		//验证输入有效性年度 和 预算类型
		if(!InputCheckUtil.check(InputCheckUtil.pub_nd, nd) || !InputCheckUtil.check(InputCheckUtil.budget_budgettype, budgetType)) {
			return "error";
		}
		request.setAttribute("nd", nd);
		request.setAttribute("budgetType", budgetType);
		return "stp/budget/budget_create_all_split";
	}
	
	@RequestMapping(value = "/budget/budget-info-get", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetInfo(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GET_INFO+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/budget-info-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetInfoTable(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/budget-info-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetInfoList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/budget-info-del", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_DEL, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-info-create", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfo(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_CREATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return responseEntity.getBody();
	}
	@RequestMapping(value = "/budget/budget-info-create-bytemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object createBudgetGroupInfoByTemplate(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setCreaterId(this.getUserProfile().getUserId());
		info.setCreaterName(this.getUserProfile().getUserDisp());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_CREATE_BYTEMPLATE, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return responseEntity.getBody();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/unit_select_tree")
	public Object toBudgetAssetSelectUnit(HttpServletRequest request) throws IOException 
	{
		request.setAttribute("company", request.getParameter("company"));
		return "stp/budget/unit_select_tree";
	}
	@RequestMapping(value = "/budget/budget-info-final-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_FINAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
}
