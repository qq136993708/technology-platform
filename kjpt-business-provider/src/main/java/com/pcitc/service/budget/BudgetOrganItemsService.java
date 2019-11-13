package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrganItems;

public interface BudgetOrganItemsService
{
	
	public BudgetOrganItems selectBudgetOrganItems(String dataId);
	
	public Result saveBudgetOrganItems(BudgetOrganItems bean) throws Exception;

	public Result updateBudgetOrganItems(BudgetOrganItems bean) throws Exception;
	
	public Result saveOrUpdBudgetOrganItems(BudgetOrganItems bean) throws Exception;
	
	public Result deleteBudgetOrganItems(String dataId) throws Exception;
	
	public Result deleteBudgetOrganItemsReal(String id) throws Exception;
	
	public List<BudgetOrganItems> selectListBudgetOrganItems();
	
	public List<BudgetOrganItems> selectListBudgetOrganItemsByBean(BudgetOrganItems bean);
	
	public LayuiTableData selectTableBudgetOrganItems(LayuiTableParam param);
}
