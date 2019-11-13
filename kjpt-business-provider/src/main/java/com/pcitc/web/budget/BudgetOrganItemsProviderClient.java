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
import com.pcitc.base.stp.budget.BudgetOrganItems;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetOrganItemsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算项明细管理",tags= {"预算-预算项明细管理"})
@RestController
public class BudgetOrganItemsProviderClient 
{

	@Autowired
	private BudgetOrganItemsService budgetOrganItemsService;
	
	
	@ApiOperation(value="预算项明细管理-检索预算项明细",notes="根据预算项明细ID检索预算项明细!")
	@RequestMapping(value = "/stp-provider/budget/budget-organitems-get/{dataId}", method = RequestMethod.POST)
	public Object selectBudgetOrganItemsById(@PathVariable("dataId") String dataId) 
	{
		BudgetOrganItems organ = null;
		try 
		{
			organ = budgetOrganItemsService.selectBudgetOrganItems(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	@ApiOperation(value="预算项明细管理-预算项明细列表",notes="获取预算项明细列表。")
	@RequestMapping(value = "/stp-provider/budget/budget-organitems-list", method = RequestMethod.POST)
	public Object selectBudgetOrganItemsList(@RequestBody BudgetOrganItems bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetOrganItems> datalist = budgetOrganItemsService.selectListBudgetOrganItemsByBean(bean);
			for(BudgetOrganItems dt:datalist) {
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
	@ApiOperation(value="预算项明细管理-预算分页列表",notes="获取预算项明细列表（带分页）。")
	@RequestMapping(value = "/stp-provider/budget/budget-organitems-table", method = RequestMethod.POST)
	public Object selectBudgetOrganItemsTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = budgetOrganItemsService.selectTableBudgetOrganItems(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算项明细管理-预算项明细保存",notes="保存预算项明细")
	@RequestMapping(value = "/stp-provider/budget/budget-organitems-save", method = RequestMethod.POST)
	public Object saveBudgetOrganItems(@RequestBody BudgetOrganItems bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganItemsService.saveBudgetOrganItems(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算项明细管理-预算项明细更新",notes="更新预算项明细")
	@RequestMapping(value = "/stp-provider/budget/budget-organitems-upd", method = RequestMethod.POST)
	public Object updBudgetOrganItems(@RequestBody BudgetOrganItems bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganItemsService.updateBudgetOrganItems(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="预算项明细管理-预算项明细保存或更新",notes="预算项明细保存或更新")
	@RequestMapping(value = "/stp-provider/budget/budget-organitems-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpdBudgetOrganItems(@RequestBody BudgetOrganItems bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganItemsService.saveOrUpdBudgetOrganItems(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="预算项明细管理-预算项明细删除",notes="预算项明细删除")
	@RequestMapping(value = "/stp-provider/budget/budget-organitems-del/{dataId}", method = RequestMethod.POST)
	public Object delBudgetOrganItems(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganItemsService.deleteBudgetOrganItems(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
