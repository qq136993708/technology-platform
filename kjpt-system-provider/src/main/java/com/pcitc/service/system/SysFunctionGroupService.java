package com.pcitc.service.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFunctionGroup;

public interface SysFunctionGroupService 
{
	/**
	 * 查询列表
	 * 
	 * @return
	 */
	List<SysFunctionGroup> selectFunctionGroupList();
	/**
	 * 分页查询功能分组
	 * 
	 * @return
	 */
	LayuiTableData selectFunctionGroupByPage(LayuiTableParam param);
	/**
	 * 获取分组对应的功能列表
	 * @param groupId
	 * @return
	 */
	SysFunctionGroup selectSysFunctionGroupById(String groupId);
	/**
	 * 
	 * @param groupId
	 * @return
	 */
	List<Map<String,Object>> selectSysFunctionGroupFunctions(String groupId);
	/**
	 * 保存分组信息
	 * @param functionGroup
	 * @return
	 */
	Integer saveSysFunctionGroupInfo(SysFunctionGroup functionGroup);
	/**
	 * 删除分组
	 * @param functionGroupId
	 * @return
	 */
	Integer delSysFunctionGroupInfo(String functionGroupId);
	/**
	 * 更新权限信息
	 * @param functionGroup
	 * @return
	 */
	Integer updatSysFunctionGroupRole(SysFunctionGroup functionGroup);
}
