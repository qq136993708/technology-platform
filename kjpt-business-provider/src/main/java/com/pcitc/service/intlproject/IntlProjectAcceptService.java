package com.pcitc.service.intlproject;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectAccept;

public interface IntlProjectAcceptService 
{
	/**
	 *  分页查询(新版)
	 * 
	 * @return
	 */
	public LayuiTableData selectProjectAcceptList(LayuiTableParam param);
	/**
	 *  分页查询(新版)
	 * 
	 * @return
	 */
	public LayuiTableData selectProjectWaitingAcceptList(LayuiTableParam param);
	/**
	 * 
	 * @param acceptId
	 * @return
	 */
	public IntlProjectAccept findProjectAccept(String acceptId);
	/**
	 * 
	 * @param acceptId
	 * @return
	 */
	public Integer saveProjectAccept(IntlProjectAccept accept);
	/**
	 * 
	 * @param acceptId
	 * @return
	 */
	public Integer updProjectAccept(IntlProjectAccept accept);
	/**
	 * 
	 * @param acceptId
	 * @return
	 */
	public Integer delProjectAccept(String acceptId);
	/**
	 * 
	 * @param acceptId
	 * @return
	 */
	public Integer delProjectAcceptReal(String acceptId);
}
