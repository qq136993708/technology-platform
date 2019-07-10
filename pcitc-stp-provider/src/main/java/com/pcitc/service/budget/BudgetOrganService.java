package com.pcitc.service.budget;

import java.io.Serializable;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;

public interface BudgetOrganService extends BaseService<BudgetOrgan,Serializable,BudgetOrganExample>
{
	
	public BudgetOrgan selectBudgetOrgan(String dataId);
	
	public Result saveBudgetOrgan(BudgetOrgan bean) throws Exception;

	public Result updateBudgetOrgan(BudgetOrgan bean) throws Exception;
	
	public Result saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception;
	
	public Result deleteBudgetOrgan(String dataId) throws Exception;
	
	public List<BudgetOrgan> selectListBudgetOrgan();
	
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean);
	
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param);
}
