package com.pcitc.service.budget;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.workflow.WorkflowVo;

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
	/**
	 * 获取计划参考数据
	 * @param budgetInfoId
	 * @param nd
	 * @return
	 */
	public Map<String,List<OutProjectPlan>> selectBudgetPlanData(Set<String> codes,String nd);
	/**
	 * 发起工作流
	 * @param delegate
	 * @return
	 */
	public Boolean startWorkFlow(BudgetInfo info,WorkflowVo workflowVo);
	/**
	 * 集团预算分解汇总
	 * @param nd
	 * @return
	 */
	public List<Map<String,Object>> selectGroupFinalSplit(String nd);
	/**
	 * 资产预算分解汇总
	 * @param nd
	 * @return
	 */
	public List<Map<String,Object>> selectAssetFinalSplit(String nd);
	/**
	 * 股份预算分解汇总
	 * @param nd
	 * @return
	 */
	public List<Map<String,Object>> selectStockFinalSplit(String nd);
	/**
	 * 更新汇总数据
	 * [资产分解表：out_tem_money_asset]
	 * [集团分解表：out_tem_money_group]
	 * [股份分解表：直属院out_tem_money_institute，股份支付集团、外系统外out_tem_money_other，分子公司out_tem_money_company]
	 * [事业部分解表：out_tem_money_b2c]
	 * [专项经费分解表：out_tem_money_tech]
	 * [分解总表：out_tem_money_decompose]
	 * @param info
	 * @return
	 */
	public void processDataImport(BudgetInfo info);
}
