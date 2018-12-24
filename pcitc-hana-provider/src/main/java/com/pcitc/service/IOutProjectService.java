package com.pcitc.service;

import java.util.HashMap;
import java.util.List;

public interface IOutProjectService {
	
	/**
	 * 获取国家项目的数据
	 */
	public List getCountryProjectList(HashMap<String, String> map);

}
