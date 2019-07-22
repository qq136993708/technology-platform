package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrgan;

public interface BudgetOrganService
{
	
	public BudgetOrgan selectBudgetOrgan(String dataId);
	
	public Result saveBudgetOrgan(BudgetOrgan bean) throws Exception;

	public Result updateBudgetOrgan(BudgetOrgan bean) throws Exception;
	
	public Result saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception;
	
	public Result deleteBudgetOrgan(String dataId) throws Exception;
	
	public Result deleteBudgetOrganReal(String id) throws Exception;
	
	public List<BudgetOrgan> selectListBudgetOrgan();
	
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean);
	
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param);
}
