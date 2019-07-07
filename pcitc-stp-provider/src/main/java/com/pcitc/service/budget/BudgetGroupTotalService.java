package com.pcitc.service.budget;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.workflow.WorkflowVo;

/**
 * 集团预算总表业务
 * @author fb
 *
 */
public interface BudgetGroupTotalService extends BudgetPublicService
{
	/**
	 * 查询预算项
	 * @param dataId
	 * @return
	 * @throws Exception
	 */
	public BudgetGroupTotal selectBudgetGroupTotal(String dataId) throws Exception;
	/**
	 * 查询当前预算项的所有子项
	 * @param dataId
	 * @return
	 */
	public List<BudgetGroupTotal> selectChildBudgetGroupTotal(String dataId);
	/**
	 * 查询当前预算项的所有子项(包含已删除)
	 * @param dataId
	 * @return
	 */
	public List<BudgetGroupTotal> selectChildBudgetGroupTotalAll(String dataId);
	/**
	 * 更新预算项
	 * @param groupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer updateBudgetGroupTotal(BudgetGroupTotal groupTotal)throws Exception;
	/**
	 * 删除预算项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetGroupTotal(String id) throws Exception;
	/**
	 * 检索预算项列表
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<BudgetGroupTotal> selectBudgetGroupTotalListByIds(List<String> list)throws Exception;
	/**
	 * 持久化预算项
	 * @param budgetGroupTotal
	 * @return
	 * @throws Exception
	 */
	public Integer saveOrUpdateBudgetGroupTotal(BudgetGroupTotal budgetGroupTotal)throws Exception;
	/**
	 * 根据预算表查询预算表下所有预算项（一级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetGroupTotal> selectItemsByBudgetId(String budgetId);
	/**
	 * 根据预算表查询预算表下所有预算项（包括一级和二级）
	 * @param budgetId
	 * @return
	 * @throws Exception
	 */
	public List<BudgetGroupTotal> selectBudgetGroupTotalByInfoId(String budgetId)throws Exception;
	/**
	 * 分页检索预算项（一级）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public LayuiTableData selectBudgetGroupTotalPage(LayuiTableParam param) throws Exception;
	/**
	 * 根据预算ID删除
	 * @param infoId
	 * @return
	 * @throws Exception
	 */
	public int deleteBudgetGroupTotalByInfo(String budgetInfoId) throws Exception;
	/**
	 * 
	 * @param item
	 * @return
	 */
	public List<BudgetGroupTotal> selectGroupTotalHistoryItems(BudgetGroupTotal item);
	/**
	 * 检索集团公司
	 * @return
	 */
	public List<OutUnit> selectGroupCompnays();
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
	/**
	 * 发起工作流
	 * @param delegate
	 * @return
	 */
	public Boolean startWorkFlow(BudgetInfo info,WorkflowVo workflowVo);
	/**
	 *  输出最终审批结果到辅助决策中心
	 * @param info
	 * @return
	 */
	public Boolean outDataToReport(BudgetInfo info);
	/**
	 * 获取最终集团预算总表
	 * @param info
	 * @return
	 */
	public Map<String,Object> selectFinalGroupTotalBudget(BudgetInfo info);
}
