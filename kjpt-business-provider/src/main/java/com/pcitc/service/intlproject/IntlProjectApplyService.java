package com.pcitc.service.intlproject;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectApply;

public interface IntlProjectApplyService 
{
	/**
	 * 查询所有申报的项目(根据参数查询，不分页)
	 * 
	 * @return
	 */
	public List<IntlProjectApply> selectProjectApplyList(Map<String,Object> params);
	/**
	 * 分页查询(新版)
	 * 
	 * @return
	 */
	public LayuiTableData selectProjectApplyByPage(LayuiTableParam param);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public IntlProjectApply findProjectApply(String applyId);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer saveProjectApply(IntlProjectApply apply);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer updProjectApply(IntlProjectApply apply);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectApply(String applyId);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectApplyReal(String applyId);
	/**
	 * 项目计划工作流启动
	 * @param plantId
	 * @return
	 */
	public Integer startWorkFlowByApply(String applyId);
	/**
	 * 
	 * @return
	 */
	public List<IntlProjectApply> findAllFinalApplys();
	/**
	 * 获取没有加入计划的apply
	 * @param plantId
	 * @return
	 */
	public LayuiTableData findNotJoinPlantApply(LayuiTableParam param);
	/**
	 * 获取加入计划的apply
	 * @param plantId
	 * @return
	 */
	public LayuiTableData findJoinPlantApply(LayuiTableParam param);
	/**
	 * 获取已加入计划并审批通过的applyList
	 * @param plantId
	 * @return
	 */
	public LayuiTableData findJoinPlantAndPassApply(LayuiTableParam param);
	/**
	 * 申报项目编码
	 * @param apply
	 * @return
	 */
	public String createProjectApplyCode(IntlProjectApply apply);
	/**
	 * 
	 * @param noticeId
	 * @param functionId
	 * @param workflowName
	 * @return
	 */
	public boolean startWorkFlow(String businessId,String functionId,String workflowName,String authenticatedUserId,String authenticatedUserName);
}
