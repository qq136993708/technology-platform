package com.pcitc.service.budget;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetAssetTotal;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;

/**
 * 集团预算总表业务
 * @author fb
 *
 */
public interface BudgetAssetTotalService
{
	/**
	 * 查询预算项
	 * @param dataId
	 * @return
	 * @throws Exception
	 */
	public BudgetAssetTotal selectBudgetAssetTotal(String dataId) throws Exception;
	/**
	 * 查询当前预算项的所有子项
	 * @param dataId
	 * @return
	 */
	public List<BudgetAssetTotal> selectChildBudgetAssetTotal(String dataId);
	/**
	 * 查询当前预算项的所有子项(包含已删除)
	 * @param dataId
	 * @return
	 */
	public List<BudgetAssetTotal> selectChildBudgetAssetTotalAll(String dataId);
	/**
	 * 更新预算项
	 * @param groupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer updateBudgetAssetTotal(BudgetAssetTotal groupTotal)throws Exception;
	/**
	 * 删除预算项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetAssetTotal(String id) throws Exception;
	/**
	 * 检索预算项列表
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<BudgetAssetTotal> selectBudgetAssetTotalListByIds(List<String> list)throws Exception;
	/**
	 * 持久化预算项
	 * @param budgetGroupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer saveOrUpdateBudgetAssetTotal(BudgetAssetTotal budgetGroupTotal)throws Exception;
	/**
	 * 根据预算表查询预算表下所有预算项（一级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetAssetTotal> selectItemsByBudgetId(String budgetId)throws Exception;
	/**
	 * 根据预算表查询预算表下所有预算项（包括一级和二级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetAssetTotal> selectBudgetAssetTotalByInfoId(String budgetId)throws Exception;
	/**
	 * 分页检索预算项（一级）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public LayuiTableData selectBudgetAssetTotalPage(LayuiTableParam param) throws Exception;
	/**
	 * 根据预算ID删除
	 * @param infoId
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetAssetTotalByInfo(String budgetInfoId) throws Exception;
	/**
	 * 
	 * @param item
	 * @return
	 */
	public List<BudgetAssetTotal> selectAssetTotalHistoryItems(BudgetAssetTotal item);
	/**
	 * 检索集团公司
	 * @return
	 */
	public List<OutUnit> selectAssetCompnays();
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
