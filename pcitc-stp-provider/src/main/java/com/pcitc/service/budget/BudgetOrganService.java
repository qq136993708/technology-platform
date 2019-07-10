package com.pcitc.service.budget;

import java.io.Serializable;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;

public interface BudgetOrganService extends BaseService<BudgetOrgan,Serializable,BudgetOrganExample>
{
	
	public BudgetOrgan selectBudgetOrgan(String dataId);
	
	public Boolean saveBudgetOrgan(BudgetOrgan bean) throws Exception;

	public Boolean updateBudgetOrgan(BudgetOrgan bean) throws Exception;
	
	public Boolean saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception;
	
	public Boolean deleteBudgetOrgan(String dataId) throws Exception;
	
	public List<BudgetOrgan> selectListBudgetOrgan(BudgetOrganExample example);
	
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean);
	
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param,BudgetOrganExample example);
}
