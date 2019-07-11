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
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetOrganService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算项管理",tags= {"预算-预算项管理"})
@RestController
public class BudgetOrganProviderClient 
{

	@Autowired
	private BudgetOrganService budgetOrganService;
	
	
	@ApiOperation(value="预算项管理-检索预算项",notes="根据预算项ID检索预算项!")
	@RequestMapping(value = "/stp-provider/budget/budget-organ-get/{dataId}", method = RequestMethod.POST)
	public Object selectBudgetOrganById(@PathVariable("dataId") String dataId) 
	{
		BudgetOrgan organ = null;
		try 
		{
			organ = budgetOrganService.selectBudgetOrgan(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	@ApiOperation(value="预算项管理-预算项列表",notes="获取预算项列表。")
	@RequestMapping(value = "/stp-provider/budget/budget-organ-list", method = RequestMethod.POST)
	public Object selectBudgetOrganList(@RequestBody BudgetOrgan bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetOrgan> datalist = budgetOrganService.selectListBudgetOrganByBean(bean);
			for(BudgetOrgan dt:datalist) {
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
	@ApiOperation(value="预算项管理-预算分页列表",notes="获取预算项列表（带分页）。")
	@RequestMapping(value = "/stp-provider/budget/budget-organ-table", method = RequestMethod.POST)
	public Object selectBudgetOrganTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = budgetOrganService.selectTableBudgetOrgan(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算项管理-预算项保存",notes="保存预算项")
	@RequestMapping(value = "/stp-provider/budget/budget-organ-save", method = RequestMethod.POST)
	public Object saveBudgetOrgan(@RequestBody BudgetOrgan bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganService.saveBudgetOrgan(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算项管理-预算项更新",notes="更新预算项")
	@RequestMapping(value = "/stp-provider/budget/budget-organ-upd", method = RequestMethod.POST)
	public Object updBudgetOrgan(@RequestBody BudgetOrgan bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganService.updateBudgetOrgan(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="预算项管理-预算项保存或更新",notes="预算项保存或更新")
	@RequestMapping(value = "/stp-provider/budget/budget-organ-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpdBudgetOrgan(@RequestBody BudgetOrgan bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganService.saveOrUpdBudgetOrgan(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="预算项管理-预算项删除",notes="预算项删除")
	@RequestMapping(value = "/stp-provider/budget/budget-organ-del/{dataId}", method = RequestMethod.POST)
	public Object delBudgetOrgan(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOrganService.deleteBudgetOrgan(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
