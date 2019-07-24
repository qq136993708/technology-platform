package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetRealPayMoney;

public interface BudgetRealPayMoneyService
{
	
	public BudgetRealPayMoney selectBudgetRealPayMoney(String dataId);
	
	public Result saveBudgetRealPayMoney(BudgetRealPayMoney bean) throws Exception;

	public Result updateBudgetRealPayMoney(BudgetRealPayMoney bean) throws Exception;
	
	public Result saveOrUpdBudgetRealPayMoney(BudgetRealPayMoney bean) throws Exception;
	
	public Result deleteBudgetRealPayMoney(String dataId) throws Exception;
	
	public Result deleteBudgetRealPayMoneyReal(String dataId) throws Exception;
	
	public List<BudgetRealPayMoney> selectListBudgetRealPayMoney();
	
	public List<BudgetRealPayMoney> selectListBudgetRealPayMoneyByBean(BudgetRealPayMoney bean);
	
	public LayuiTableData selectTableBudgetRealPayMoney(LayuiTableParam param);
}
