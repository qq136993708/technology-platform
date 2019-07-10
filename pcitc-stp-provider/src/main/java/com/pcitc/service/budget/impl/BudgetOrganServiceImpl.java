package com.pcitc.service.budget.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
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
	public Boolean saveBudgetOrgan(BudgetOrgan bean) throws Exception 
	{
		return this.saveBean(bean);
	}
	@Override
	public Boolean updateBudgetOrgan(BudgetOrgan budgetOrgan) throws Exception 
	{
		return this.updateBean(budgetOrgan);
	}
	@Override
	public Boolean deleteBudgetOrgan(String id) throws Exception 
	{
		return this.deleteBean(id);
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrgan(BudgetOrganExample example) 
	{
		return this.selectListData(example);
	}
	@Override
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param,BudgetOrganExample example) 
	{
		return this.selectTableData(param, example);
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean) 
	{
		return null;
	}
	@Override
	public Boolean saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception 
	{
		return this.saveOrUpdBean(bean.getDataId(),bean);
	}
	
}
