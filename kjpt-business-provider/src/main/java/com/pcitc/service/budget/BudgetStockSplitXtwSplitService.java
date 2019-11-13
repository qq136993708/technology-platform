package com.pcitc.service.budget;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.vo.SplitItemVo;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;

/**
 * 预算明细分解表业务
 * @author fb
 *
 */
public interface BudgetStockSplitXtwSplitService
{
	/**
	 * 查询当前预算表数据
	 * @param dataId
	 * @return
	 */
	public BudgetSplitData selectBudgetSplitItemData(String splitCode,String organCode,String budgetInfoId);
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
	 * 查询历史预算标题（非指定年）
	 * @param dataId
	 * @return
	 */
	public Map<String,List<SplitItemVo>> selectBudgetSplitHistoryTableTitles(String nd);
	/**
	 * 保存预算数据
	 * @param dataId
	 * @return
	 */
	public List<BudgetSplitData> saveBudgetSplitDataItems(String items);
	/**
	 * 保存预算数据
	 * @param dataId
	 * @return
	 */
	public List<BudgetSplitData> saveBudgetSplitDataItem(String item);
	/**
	 * 持久化预算项
	 * @param budgetGroupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer saveOrUpdateBudgetSplitData(BudgetSplitData budgetGroupTotal)throws Exception;
	/**
	 * 根据预算ID删除
	 * @param infoId
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetSplitDataByInfo(String budgetInfoId) throws Exception;
	/**
	 * 获取指定项指定年的审批数据
	 * @param item
	 * @return
	 */
	public Map<String,Object> selectAssetSplitFinalItem(String nd,String organCode);
	/**
	 * 获取指定项指表的审批数据
	 * @param item
	 * @return
	 */
	public Map<String,Object> selectAssetSplitItem(String budgetInfoId,String organCode);
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
