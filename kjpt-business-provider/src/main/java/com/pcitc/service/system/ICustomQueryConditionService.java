package com.pcitc.service.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.CustomQueryCondition;

public interface ICustomQueryConditionService {


	/**
     * 根据ID获取查询接口信息详情
   */
	public CustomQueryCondition selectCustomQueryCondition(String id) throws Exception;
	
	 /**
	     *修改查询接口信息
	*/
	public Integer updateCustomQueryCondition(CustomQueryCondition record)throws Exception;
	 /**
	     *根据ID删除查询接口信息
	*/
	public int deleteCustomQueryCondition(String id)throws Exception;
	

	 /**
	     * 增加查询接口信息
	 */
	public Integer insertCustomQueryCondition(CustomQueryCondition record)throws Exception;
	
	/**
	     * 获取查询接口（分页）
	*/
	public LayuiTableData getCustomQueryConditionPage(LayuiTableParam param)throws Exception;
	
	public List getCustomQueryConditionList(Map map)throws Exception;
	
	
}
