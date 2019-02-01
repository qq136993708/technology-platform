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
import com.pcitc.web.common.BudgetInfoEnum;
/**
 * 集团预算总表
 * @author fb
 *
 */
@Controller
public class BudgetGroupTotalController extends BaseController {

	private static final String PROJECT_ACCEPT_PROCESS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-info-list";
	private static final String BUDGET_GROUPTOTAL_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-grouptotal-items";
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/budget_group_page")
	public Object toBudgetGroupPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/budget";
	}
	@RequestMapping(value = "/budget/budget_group_info_list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		info.setBudgetType(BudgetInfoEnum.GROUP_TOTAL.getCode());
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(PROJECT_ACCEPT_PROCESS, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	@RequestMapping(value = "/budget/budget-grouptotal-items", method = RequestMethod.GET)
	@ResponseBody
	public Object getBudgetGroupItems(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_GROUPTOTAL_ITEMS, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}

}
