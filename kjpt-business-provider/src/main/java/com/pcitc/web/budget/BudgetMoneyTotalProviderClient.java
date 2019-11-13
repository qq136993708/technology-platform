package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetMoneyTotal;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetMoneyTotalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算汇总管理",tags= {"预算-预算汇总管理"})
@RestController
public class BudgetMoneyTotalProviderClient 
{

	@Autowired
	private BudgetMoneyTotalService budgetMoneyTotalService;
	
	
	@ApiOperation(value="预算汇总管理-检索预算汇总",notes="根据预算汇总ID检索预算汇总!")
	@RequestMapping(value = "/stp-provider/budget/budget-moneytotal-get/{dataId}", method = RequestMethod.POST)
	public Object selectBudgetMoneyTotalById(@PathVariable("dataId") String dataId) 
	{
		BudgetMoneyTotal organ = null;
		try 
		{
			organ = budgetMoneyTotalService.selectBudgetMoneyTotal(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	@ApiOperation(value="预算汇总管理-预算汇总列表",notes="获取预算汇总列表。")
	@RequestMapping(value = "/stp-provider/budget/budget-moneytotal-list", method = RequestMethod.POST)
	public Object selectBudgetMoneyTotalList(@RequestBody BudgetMoneyTotal bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetMoneyTotal> datalist = budgetMoneyTotalService.selectListBudgetMoneyTotalByBean(bean);
			for(BudgetMoneyTotal dt:datalist) {
				Map<String,Object> map = MyBeanUtils.transBean2Map(dt);
				//map.put("auditStatusDesc", BudgetAuditStatusEnum.getStatusByCode(dt.getAuditStatus()).getDesc());
				rsdata.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="预算汇总管理-预算分页列表",notes="获取预算汇总列表（带分页）。")
	@RequestMapping(value = "/stp-provider/budget/budget-moneytotal-table", method = RequestMethod.POST)
	public Object selectBudgetMoneyTotalTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = budgetMoneyTotalService.selectTableBudgetMoneyTotal(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算汇总管理-预算汇总保存",notes="保存预算汇总")
	@RequestMapping(value = "/stp-provider/budget/budget-moneytotal-save", method = RequestMethod.POST)
	public Object saveBudgetMoneyTotal(@RequestBody BudgetMoneyTotal bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetMoneyTotalService.saveBudgetMoneyTotal(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算汇总管理-预算汇总更新",notes="更新预算汇总")
	@RequestMapping(value = "/stp-provider/budget/budget-moneytotal-upd", method = RequestMethod.POST)
	public Object updBudgetMoneyTotal(@RequestBody BudgetMoneyTotal bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetMoneyTotalService.updateBudgetMoneyTotal(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="预算汇总管理-预算汇总保存或更新",notes="预算汇总保存或更新")
	@RequestMapping(value = "/stp-provider/budget/budget-moneytotal-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpdBudgetMoneyTotal(@RequestBody BudgetMoneyTotal bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetMoneyTotalService.saveOrUpdBudgetMoneyTotal(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="预算汇总管理-预算汇总删除",notes="预算汇总删除")
	@RequestMapping(value = "/stp-provider/budget/budget-moneytotal-del/{dataId}", method = RequestMethod.POST)
	public Object delBudgetMoneyTotal(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetMoneyTotalService.deleteBudgetMoneyTotal(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
