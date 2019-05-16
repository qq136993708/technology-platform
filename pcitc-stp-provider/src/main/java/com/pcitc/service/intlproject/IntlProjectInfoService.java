package com.pcitc.service.intlproject;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.DataTableParam;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;

/**
 * 
 * @author fb
 *
 */
public interface IntlProjectInfoService 
{
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	IntlProjectInfo findById(String projectId);
	/**
	 * 分页查询
	 * @param dataTableParam
	 * @return
	 */
	PageInfo<IntlProjectInfo> findByPagin(DataTableParam dataTableParam);
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	LayuiTableData selectProjectInfoByPage(LayuiTableParam param);
	/**
	 * 
	 * @param info
	 * @return
	 */
	Integer saveOrUpdate(IntlProjectInfo info);
	/**
	 * 删除项目信息 (逻辑删除)
	 * @param projectId
	 * @return
	 */
	Integer delProjectInfo(String projectId);
	/**
	 * 删除项目信息（物理删除）
	 * @param projectId
	 * @return
	 */
	Integer delProjectInfoReal(String projectId);
	/**
	 * 
	 * @param businessId
	 * @param functionId
	 * @param workflowName
	 * @return
	 */
	public boolean startWorkFlow(String businessId,String functionId,String workflowName,String authenticatedUserId,String authenticatedUserName);

}
