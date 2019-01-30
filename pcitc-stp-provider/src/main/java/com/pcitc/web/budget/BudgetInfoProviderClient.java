package com.pcitc.web.budget;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@ApiOperation(value="预算管理-集团预算Table",notes="按年检索年度集团预算表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-info-grouptotal-table", method = RequestMethod.POST)
	public Object selectBudgetInfoTable(@RequestBody LayuiTableParam param) 
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
	@ApiOperation(value="预算管理-集团预算List",notes="按年检索年度集团预算表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-info-grouptotal-list", method = RequestMethod.POST)
	public Object selectBudgetInfoList(@RequestParam(value = "nd", required = true) String nd) 
	{
		logger.info("budget-grouptotal-info-list...");
		List<BudgetInfo> data = null;
		try
		{
			System.out.println(JSON.toJSONString(nd));
			data = budgetInfoService.selectBudgetInfoList(nd);
			System.out.println(JSON.toJSONString(data));
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@ApiOperation(value="预算管理-集团预算表",notes="保存、更新集团年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-grouptotal-saveorupdate", method = RequestMethod.POST)
	public Object saveOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("saveorupdate-budget-grouptotal-info...");
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
	@ApiOperation(value="预算管理-集团预算表",notes="创建集团年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-create-grouptotal", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("saveorupdate-budget-grouptotal-info...");
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
	
	@ApiOperation(value="预算管理-集团预算表",notes="更新集团年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-grouptotal-delete/{dataId}", method = RequestMethod.POST)
	public Object deleteBudgetInfo(@PathVariable("dataId") String dataId) 
	{
		logger.info("delete-budget-grouptotal-info...");
		Integer rs = 0;
		try
		{
			rs = budgetInfoService.deleteBudgetInfo(dataId);
			System.out.println(JSON.toJSONString(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
