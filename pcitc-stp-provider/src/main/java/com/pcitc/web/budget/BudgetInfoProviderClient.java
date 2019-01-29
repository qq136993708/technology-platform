package com.pcitc.web.budget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.service.budget.BudgetInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算表管理",tags= {"预算-预算表管理"})
@RestController
public class BudgetInfoProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetInfoProviderClient.class);

	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	
	@ApiOperation(value="集团预算表",notes="按年检索年度集团预算表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-list", method = RequestMethod.POST)
	public Object selectProjectPassAcceptList(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-grouptotal-info-list...");
		LayuiTableData data = null;
		try
		{
			System.out.println(JSON.toJSONString(param));
			data = budgetInfoService.selectBudgetInfoPage(param);
			System.out.println(JSON.toJSONString(data));
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="集团预算表",notes="保存集团年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-save", method = RequestMethod.POST)
	public Object insertBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-grouptotal-info...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(info));
			rs = budgetInfoService.insertBudgetInfo(info);
			System.out.println(JSON.toJSONString(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="集团预算表",notes="更新集团年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-update", method = RequestMethod.POST)
	public Object updBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-grouptotal-info...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(info));
			rs = budgetInfoService.updateBudgetInfo(info);
			System.out.println(JSON.toJSONString(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
