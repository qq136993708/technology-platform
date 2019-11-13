package com.pcitc.service.intlproject;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectRemark;

public interface IntlProjectRemarkService 
{
	/**
	 * 分页查询(新版)
	 * 
	 * @return
	 */
	public LayuiTableData selectProjectRemarkByPage(LayuiTableParam param);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public IntlProjectRemark findProjectRemark(String remarkId);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer saveProjectRemark(IntlProjectRemark remark);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer updProjectRemark(IntlProjectRemark remark);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectRemark(String remarkId);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectRemarkReal(String remarkId);
	
	
}
