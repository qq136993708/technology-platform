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
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.web.common.BaseController;

@Controller
public class BudgetInfoController extends BaseController
{

	private static final String BUDGET_INFO_FINAL_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget_info_final_list";
	
	
	
	@RequestMapping(value = "/budget/budget_info_final_list", method = RequestMethod.POST)
	@ResponseBody
	public Object getBudgetGroupList(@ModelAttribute("info") BudgetInfo info,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(BUDGET_INFO_FINAL_LIST, HttpMethod.POST, new HttpEntity<BudgetInfo>(info, this.httpHeaders), Object.class);
		//System.out.println(JSON.toJSON(responseEntity.getBody()).toString());
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
}
