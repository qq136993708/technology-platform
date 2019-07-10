package com.pcitc.service.budget.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;
import com.pcitc.service.budget.BudgetOrganService;
/**
 * 
 * @author uuy
 *
 */
@Service("budgetOrganService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOrganServiceImpl  extends BaseServiceImpl<BudgetOrgan,Serializable,BudgetOrganExample>  implements BudgetOrganService
{

	@Override
	public BudgetOrgan selectBudgetOrgan(String dataId) 
	{
		return this.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveBudgetOrgan(BudgetOrgan bean) throws Exception 
	{
		Boolean status = this.saveBean(bean);
		
		return new Result(status);
	}
	@Override
	public Result updateBudgetOrgan(BudgetOrgan budgetOrgan) throws Exception 
	{
		Boolean status =  this.updateBean(budgetOrgan);
		
		return new Result(status);
	}
	@Override
	public Result deleteBudgetOrgan(String id) throws Exception 
	{
		Boolean status =  this.deleteBean(id);
		
		return new Result(status);
	}
	@Override
	public Result saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception 
	{
		Boolean status =  this.saveOrUpdBean(bean.getDataId(),bean);
		
		return new Result(status);
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrgan() 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		return this.selectListData(example);
	}
	@Override
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param) 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		return this.selectTableData(param, example);
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean) 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		return this.selectListData(example);
	}
	
	
}
