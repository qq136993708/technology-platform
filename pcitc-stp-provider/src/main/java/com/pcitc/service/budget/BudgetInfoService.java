package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetInfo;

/**
 * 集团预算信息表
 * @author fb
 *
 */
public interface BudgetInfoService
{
	/**
	 * 
	 * @param dataId
	 * @return
	 * @throws Exception
	 */
	public BudgetInfo selectBudgetInfo(String dataId) throws Exception;
	/**
	 * 
	 * @param budgetInfo
	 * @return
	 * @throws Exception
	 */
	public Integer updateBudgetInfo(BudgetInfo budgetInfo)throws Exception;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetInfo(String id)throws Exception;
	/**
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<BudgetInfo> selectBudgetInfoListByIds(List<String> list)throws Exception;
	/**
	 * 
	 * @param budgetInfo
	 * @return
	 * @throws Exception
	 */
	public Integer insertBudgetInfo(BudgetInfo budgetInfo)throws Exception;
	/**
	 * 
	 * @param nd
	 * @param budgetType
	 * @return
	 * @throws Exception
	 */
	public List<BudgetInfo> selectBudgetInfoList(String nd,Integer budgetType)throws Exception;
	/**
	 * 列表检索
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public LayuiTableData selectBudgetInfoPage(LayuiTableParam param) throws Exception;
	/**
	 * 创建一个空白预算总表
	 * @param nd
	 * @return
	 * @throws Exception
	 */
	public BudgetInfo createBlankBudgetInfo(String nd,BudgetInfo info);
	/**
	 * 
	 * @param budgetType
	 * @return
	 * @throws Exception
	 */
	public List<BudgetInfo> selectFinalBudgetInfoList(Integer budgetType)throws Exception;
	/**
	 * 获取年度最终预算表
	 * @param nd
	 * @param budgetType
	 * @return
	 */
	public BudgetInfo selectFinalBudget(String nd,Integer budgetType);
}
