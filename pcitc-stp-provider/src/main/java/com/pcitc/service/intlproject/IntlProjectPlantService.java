package com.pcitc.service.intlproject;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectPlant;

public interface IntlProjectPlantService {

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public LayuiTableData selectProjectPlantByPage(LayuiTableParam param);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public IntlProjectPlant findProjectPlant(String plantId);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer saveProjectPlant(IntlProjectPlant plant);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer updProjectPlant(IntlProjectPlant plant);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectPlant(String plantId);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectPlantReal(String plantId);
	/**
	 * 项目计划工作流启动
	 * @param plantId
	 * @return
	 */
	public Integer startWorkFlowByPlant(String plantId);
	/**
	 * 添加申报与项目关系
	 * @param applyId
	 * @param plantId
	 * @return
	 */
	public Integer addApplyPlantRel(String applyId,String plantId);
	/**
	 * 移除申报与项目关系
	 * @param applyId
	 * @param plantId
	 * @return
	 */
	public Integer delApplyPlantRel(String applyId,String plantId);
}
