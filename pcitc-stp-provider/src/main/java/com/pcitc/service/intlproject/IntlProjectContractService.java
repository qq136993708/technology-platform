package com.pcitc.service.intlproject;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectContract;

public interface IntlProjectContractService 
{

	/**
	 * 分页查询(签约项目)
	 * 
	 * @return
	 */
	LayuiTableData selectProjectContractList(LayuiTableParam param);
	/**
	 * 分页查询(续约项目)
	 * 
	 * @return
	 */
	LayuiTableData selectEndProjectContractList(LayuiTableParam param);
	
	/**
	 * 
	 * @param projectContrctId
	 * @return
	 */
	IntlProjectContract findById(String projectContrctId);
	
	/**
	 * 
	 * @param contract
	 * @return
	 */
	Integer updateIntlProjectContract(IntlProjectContract contract);
	/**
	 * 
	 * @param contract
	 * @return
	 */
	Integer addIntlProjectContract(IntlProjectContract contract);
	
	/**
	 * 
	 * @param contract
	 * @return
	 */
	Integer delIntlProjectContract(String projectContrctId);
	/**
	 * 
	 * @param contract
	 * @return
	 */
	Integer delIntlProjectContractReal(String projectContrctId);
}
