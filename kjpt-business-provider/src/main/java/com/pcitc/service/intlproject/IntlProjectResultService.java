package com.pcitc.service.intlproject;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectResult;

public interface IntlProjectResultService 
{
	/**
	 * 分页查询(新版)
	 * 
	 * @return
	 */
	public LayuiTableData selectProjectReultByPage(LayuiTableParam param);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public IntlProjectResult findProjectResult(String resultId);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer saveProjectResult(IntlProjectResult result);
	/**
	 * 
	 * @param notice
	 * @return
	 */
	public Integer updProjectResult(IntlProjectResult result);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectResult(String resultId);
	/**
	 * 
	 * @param noticeId
	 * @return
	 */
	public Integer delProjectResultReal(String resultId);
	
	
}
