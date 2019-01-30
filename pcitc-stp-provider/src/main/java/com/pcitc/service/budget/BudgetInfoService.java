package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;

/**
 * 集团预算信息表
 * @author fb
 *
 */
public interface BudgetInfoService
{
	public BudgetInfo selectBudgetInfo(String dataId) throws Exception;

	public Integer updateBudgetInfo(BudgetInfo budgetInfo)throws Exception;

	public int deleteBudgetInfo(String id)throws Exception;
	
	public List<BudgetInfo> selectBudgetInfoListByIds(List<String> list)throws Exception;

	public Integer insertBudgetInfo(BudgetInfo budgetInfo)throws Exception;

	public List<BudgetInfo> selectBudgetInfoList(String nd)throws Exception;
	
	public LayuiTableData selectBudgetInfoPage(LayuiTableParam param) throws Exception;
}
