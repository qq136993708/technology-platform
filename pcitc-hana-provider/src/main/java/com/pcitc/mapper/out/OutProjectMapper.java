package com.pcitc.mapper.out;

import java.util.HashMap;
import java.util.List;

public interface OutProjectMapper {

	/**
     * 获取国家项目的数据
     */
	public List getCountryProjectList(HashMap<String, String> map);

}