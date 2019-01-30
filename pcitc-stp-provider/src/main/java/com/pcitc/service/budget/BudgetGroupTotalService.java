package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetGroupTotalExample;

/**
 * 集团预算总表业务
 * @author fb
 *
 */
public interface BudgetGroupTotalService
{
	public BudgetGroupTotal selectBudgetGroupTotal(String dataId) throws Exception;

	public Integer updateBudgetGroupTotal(BudgetGroupTotal groupTotal)throws Exception;

	public int deleteBudgetGroupTotal(String id)throws Exception;
	
	public List<BudgetGroupTotal> selectBudgetGroupTotalListByIds(List<String> list)throws Exception;

	public Integer saveOrUpdateBudgetGroupTotal(BudgetGroupTotal budgetGroupTotal)throws Exception;

	public List<BudgetGroupTotal> selectBudgetInfoId(String budgetId)throws Exception;
	
	public LayuiTableData selectBudgetGroupTotalPage(LayuiTableParam param) throws Exception;
}
