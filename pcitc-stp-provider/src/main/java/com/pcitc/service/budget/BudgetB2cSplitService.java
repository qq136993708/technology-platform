package com.pcitc.service.budget;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetB2cSplit;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;

/**
 * 事业部预算总表业务
 * @author fb
 *
 */
public interface BudgetB2cSplitService
{
	/**
	 * 查询预算项
	 * @param dataId
	 * @return
	 * @throws Exception
	 */
	public BudgetB2cSplit selectBudgetB2cSplit(String dataId) throws Exception;
	/**
	 * 查询当前预算项的所有子项
	 * @param dataId
	 * @return
	 */
	public List<BudgetB2cSplit> selectChildBudgetB2cSplit(String dataId);
	/**
	 * 查询当前预算项的所有公司子项
	 * @param dataId
	 * @return
	 */
	public List<BudgetB2cSplit> selectBudgetB2cSplitCompanyItem(String dataId);
	/**
	 * 查询当前预算项的所有子项(包含已删除)
	 * @param dataId
	 * @return
	 */
	public List<BudgetB2cSplit> selectChildBudgetB2cSplitAll(String dataId);
	/**
	 * 更新预算项
	 * @param groupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer updateBudgetB2cSplit(BudgetB2cSplit groupTotal)throws Exception;
	/**
	 * 删除预算项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetB2cSplit(String id) throws Exception;
	/**
	 * 检索预算项列表
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<BudgetB2cSplit> selectBudgetB2cSplitListByIds(List<String> list)throws Exception;
	/**
	 * 持久化预算项
	 * @param budgetGroupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer saveOrUpdateBudgetB2cSplit(BudgetB2cSplit budgetGroupTotal)throws Exception;
	/**
	 * 根据预算表查询预算表下所有预算项（一级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetB2cSplit> selectItemsByBudgetId(String budgetId)throws Exception;
	/**
	 * 根据预算表查询预算表下所有预算项（包括一级和二级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetB2cSplit> selectBudgetB2cSplitByInfoId(String budgetId)throws Exception;
	/**
	 * 分页检索预算项（一级）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public LayuiTableData selectBudgetB2cSplitPage(LayuiTableParam param) throws Exception;
	/**
	 * 根据预算ID删除
	 * @param infoId
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetB2cSplitByInfo(String budgetInfoId) throws Exception;
	/**
	 * 
	 * @param item
	 * @return
	 */
	public List<BudgetB2cSplit> selectB2cSplitHistoryItems(BudgetB2cSplit item);
	/**
	 * 检索公司
	 * @return
	 */
	public List<OutUnit> selectB2cCompnays();
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
