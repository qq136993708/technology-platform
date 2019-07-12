package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetMoneyTotal;

public interface BudgetMoneyTotalService
{
	
	public BudgetMoneyTotal selectBudgetMoneyTotal(Integer dataId);
	
	public Result saveBudgetMoneyTotal(BudgetMoneyTotal bean) throws Exception;

	public Result updateBudgetMoneyTotal(BudgetMoneyTotal bean) throws Exception;
	
	public Result saveOrUpdBudgetMoneyTotal(BudgetMoneyTotal bean) throws Exception;
	
	public Result deleteBudgetMoneyTotal(Integer dataId) throws Exception;
	
	public List<BudgetMoneyTotal> selectListBudgetMoneyTotal();
	
	public List<BudgetMoneyTotal> selectListBudgetMoneyTotalByBean(BudgetMoneyTotal bean);
	
	public LayuiTableData selectTableBudgetMoneyTotal(LayuiTableParam param);
}
