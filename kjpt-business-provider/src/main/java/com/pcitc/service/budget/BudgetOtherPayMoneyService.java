package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOtherPayMoney;

public interface BudgetOtherPayMoneyService
{
	
	public BudgetOtherPayMoney selectBudgetOtherPayMoney(String dataId);
	
	public Result saveBudgetOtherPayMoney(BudgetOtherPayMoney bean) throws Exception;

	public Result updateBudgetOtherPayMoney(BudgetOtherPayMoney bean) throws Exception;
	
	public Result saveOrUpdBudgetOtherPayMoney(BudgetOtherPayMoney bean) throws Exception;
	
	public Result deleteBudgetOtherPayMoney(String dataId) throws Exception;
	
	public Result deleteBudgetOtherPayMoneyReal(String dataId) throws Exception;
	
	public List<BudgetOtherPayMoney> selectListBudgetOtherPayMoney();
	
	public List<BudgetOtherPayMoney> selectListBudgetOtherPayMoneyByBean(BudgetOtherPayMoney bean);
	
	public LayuiTableData selectTableBudgetOtherPayMoney(LayuiTableParam param);
}
