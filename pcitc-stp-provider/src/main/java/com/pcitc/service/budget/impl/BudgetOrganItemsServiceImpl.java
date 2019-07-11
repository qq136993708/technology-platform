package com.pcitc.service.budget.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrganItems;
import com.pcitc.base.stp.budget.BudgetOrganItemsExample;
import com.pcitc.service.budget.BudgetOrganItemsService;
/**
 * 
 * @author fb
 *
 */
@Service("budgetOrganItemsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOrganItemsServiceImpl  extends BaseServiceImpl<BudgetOrganItems,Serializable,BudgetOrganItemsExample>  implements BudgetOrganItemsService
{

	@Override
	public BudgetOrganItems selectBudgetOrganItems(String dataId) 
	{
		return this.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveBudgetOrganItems(BudgetOrganItems bean) throws Exception 
	{
		Boolean status = this.saveBean(bean);
		
		return new Result(status);
	}
	@Override
	public Result updateBudgetOrganItems(BudgetOrganItems budgetOrganItems) throws Exception 
	{
		Boolean status =  this.updateBean(budgetOrganItems);
		
		return new Result(status);
	}
	@Override
	public Result deleteBudgetOrganItems(String id) throws Exception 
	{
		Boolean status =  this.deleteBean(id);
		
		return new Result(status);
	}
	@Override
	public Result saveOrUpdBudgetOrganItems(BudgetOrganItems bean) throws Exception 
	{
		Boolean status =  this.saveOrUpdBean(bean.getDataId(),bean);
		
		return new Result(status);
	}
	@Override
	public List<BudgetOrganItems> selectListBudgetOrganItems() 
	{
		BudgetOrganItemsExample example = new BudgetOrganItemsExample();
		return this.selectListData(example);
	}
	@Override
	public LayuiTableData selectTableBudgetOrganItems(LayuiTableParam param) 
	{
		BudgetOrganItemsExample example = new BudgetOrganItemsExample();
		return this.selectTableData(param, example);
	}
	@Override
	public List<BudgetOrganItems> selectListBudgetOrganItemsByBean(BudgetOrganItems bean) 
	{
		BudgetOrganItemsExample example = new BudgetOrganItemsExample();
		return this.selectListData(example);
	}
	
	
}
