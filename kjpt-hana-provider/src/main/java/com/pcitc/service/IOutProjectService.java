package com.pcitc.service;

import java.util.HashMap;
import java.util.List;

public interface IOutProjectService {
	
	/**
	 * 获取国家项目的数据
	 */
	public List getCountryProjectList(HashMap<String, String> map);
	
	/**
     * 获取hana中报销费用挂账清账信息
     */
	public List getExpensesPayInfo(HashMap<String, String> map);

}
