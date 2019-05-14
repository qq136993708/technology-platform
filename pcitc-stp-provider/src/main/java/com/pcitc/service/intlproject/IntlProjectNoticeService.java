package com.pcitc.service.intlproject;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectNotice;

/**
 * 
 * @author fb
 *
 */
public interface IntlProjectNoticeService 
{

	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	LayuiTableData selectProjectNoticeList(LayuiTableParam param);
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	
	IntlProjectNotice findById(String noticeId);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer saveProjectNotice(IntlProjectNotice notice);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer updProjectNotice(IntlProjectNotice notice);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectNotice(String noticeId);
	/**
	 * 
	 * @param noticeId
	 * @param functionId
	 * @param workflowName
	 * @return
	 */
	public boolean startWorkFlow(String noticeId,String functionId,String workflowName);
}
