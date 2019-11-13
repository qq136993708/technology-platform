package com.pcitc.service.system;


import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUnitMapping;

/**
 * 单位映射关系
 *
 */
public interface SysUnitMappingService 
{

	/**
	 * 查询单位映射关系列表
	 * @param LayuiTableParam
	 * @return
	 */
	LayuiTableData querySysUnitMappingListByPage(LayuiTableParam param);
	
	/**
	 * 新增单位映射关系
	 * @param sysUnitMappings
	 * @return
	 * @throws Exception
	 */
	int saveSysUnitMapping(List<SysUnitMapping> sysUnitMappings);

	/**
	 * 删除单位映射关系
	 * @param id
	 * @return
	 */
	int deleteSysUnitMapping(String id);

}
