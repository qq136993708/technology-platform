package com.pcitc.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.CustomQueryCondition;
import com.pcitc.mapper.system.CustomQueryConditionMapper;
import com.pcitc.service.system.ICustomQueryConditionService;
@Service
public class CustomQueryConditionServiceImpl implements ICustomQueryConditionService {
	
	
	@Autowired
	private CustomQueryConditionMapper customQueryConditionMapper;

	
	
	
	/**
     * 根据ID获取专家奖励信息详情
	*/
	public CustomQueryCondition selectCustomQueryCondition(String id) throws Exception
	{
		return customQueryConditionMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改专家奖励信息
	*/
	public Integer updateCustomQueryCondition(CustomQueryCondition record)throws Exception
	{
		return customQueryConditionMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除专家奖励信息
	 */
	public int deleteCustomQueryCondition(String id)throws Exception
	{
		return customQueryConditionMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加专家奖励信息
	 */
	public Integer insertCustomQueryCondition(CustomQueryCondition record)throws Exception
	{
		return customQueryConditionMapper.insert(record);
	}
	
	
	/**
	  * 获取专家奖励（分页）
	*/
	public LayuiTableData getCustomQueryConditionPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String taleName=getTableParam(param,"taleName","");
			String columnName=getTableParam(param,"columnName","");
			String columnType=getTableParam(param,"columnType","");
			String columnCode=getTableParam(param,"columnCode","");
			String notes=getTableParam(param,"notes","");
			
			Map map=new HashMap();
			map.put("taleName", taleName);
			map.put("columnName", columnName);
			map.put("columnType", columnType);
			map.put("columnCode", columnCode);
			map.put("notes", notes);
			
			List<CustomQueryCondition> list = customQueryConditionMapper.getList(map);
			PageInfo<CustomQueryCondition> pageInfo = new PageInfo<CustomQueryCondition>(list);
			System.out.println(">>>>>>>>>专家奖励查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	public List getCustomQueryConditionList(Map map)throws Exception
	{
		
		List<CustomQueryCondition> list = customQueryConditionMapper.getList(map);
	    return list;
	}
	
	
	
	
	
	private String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
	{
		String resault="";
		Object object=param.getParam().get(paramName);
		if(object!=null)
		{
			resault=(String)object;
		}
		return resault;
	}


}
