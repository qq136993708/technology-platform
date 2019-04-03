package com.pcitc.service.budget;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;

/**
 * 预算明细分解表业务
 * @author fb
 *
 */
public interface BudgetGroupSplitService
{
	/**
	 * 查询预算数据项
	 * @param dataId
	 * @return
	 * @throws Exception
	 */
	public BudgetSplitData selectBudgetSplitData(String dataId) throws Exception;
	/**
	 * 查询当前预算表数据
	 * @param dataId
	 * @return
	 */
	public List<BudgetSplitData> selectChildBudgetSplitData(String budgetInfoId);
	/**
	 * 查询当前预算项的所有子项
	 * @param dataId
	 * @return
	 */
	public List<Map<String,Object>> selectBudgetSplitDataList(String budgetInfoId);
	/**
	 * 查询当前预算所有项目
	 * @param dataId
	 * @return
	 */
	public List<Map<String,Object>> selectBudgetSplitTableTitles(String nd);
	/**
	 * 查询当前预算项的所有子项(包含已删除)
	 * @param dataId
	 * @return
	 */
	public List<BudgetSplitData> selectChildBudgetSplitDataAll(String dataId);
	/**
	 * 更新预算项
	 * @param groupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer updateBudgetSplitData(BudgetSplitData data)throws Exception;
	/**
	 * 删除预算项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetSplitData(String id) throws Exception;
	/**
	 * 检索预算项列表
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<BudgetSplitData> selectBudgetSplitDataListByIds(List<String> list)throws Exception;
	/**
	 * 持久化预算项
	 * @param budgetGroupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer saveOrUpdateBudgetSplitData(BudgetSplitData budgetGroupTotal)throws Exception;
	/**
	 * 根据预算表查询预算表下所有预算项（一级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetSplitData> selectItemsByBudgetId(String budgetId)throws Exception;
	/**
	 * 根据预算表查询预算表下所有预算项（包括一级和二级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetSplitData> selectBudgetSplitDataByInfoId(String budgetId)throws Exception;
	/**
	 * 分页检索预算项（一级）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public LayuiTableData selectBudgetSplitDataPage(LayuiTableParam param) throws Exception;
	/**
	 * 根据预算ID删除
	 * @param infoId
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetSplitDataByInfo(String budgetInfoId) throws Exception;
	/**
	 * 
	 * @param item
	 * @return
	 */
	public List<BudgetSplitData> selectB2cSplitHistoryItems(BudgetSplitData item);
	
	/**
	 * 获取计划参考数据
	 * @param budgetInfoId
	 * @param nd
	 * @return
	 */
	public Map<String,List<OutProjectPlan>> selectComparePlanData(Set<String> codes,String nd);
	/**
	 * 获取项目参考数据（上年完成）
	 * @param budgetInfoId
	 * @param nd
	 * @return
	 */
	public Map<String,List<OutProjectInfo>> selectCompareProjectInfoData(Set<String> codes,String nd);
}
