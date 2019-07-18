package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetMoneyDecompose;

public interface BudgetMoneyDecomposeService 
{
	public BudgetMoneyDecompose selectBudgetMoneyDecompose(Integer dataId);
	
	public Result saveBudgetMoneyDecompose(BudgetMoneyDecompose bean) throws Exception;

	public Result updateBudgetMoneyDecompose(BudgetMoneyDecompose bean) throws Exception;
	
	public Result saveOrUpdBudgetMoneyDecompose(BudgetMoneyDecompose bean) throws Exception;
	
	public Result deleteBudgetMoneyDecompose(Integer dataId) throws Exception;
	
	public Result deleteBudgetMoneyDecomposeReal(Integer dataId) throws Exception;
	
	public List<BudgetMoneyDecompose> selectListBudgetMoneyDecompose();
	
	public List<BudgetMoneyDecompose> selectListBudgetMoneyDecomposeByBean(BudgetMoneyDecompose bean);
	
	public LayuiTableData selectTableBudgetMoneyDecompose(LayuiTableParam param);

}
