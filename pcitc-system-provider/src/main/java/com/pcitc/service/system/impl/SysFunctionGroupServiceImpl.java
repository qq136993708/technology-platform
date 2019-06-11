package com.pcitc.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysFunctionGroup;
import com.pcitc.base.system.SysFunctionGroupExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.system.SysFunctionGroupMapper;
import com.pcitc.service.system.SysFunctionGroupService;
import com.pcitc.utils.StringUtils;

@Service("sysFunctionGroupService")
public class SysFunctionGroupServiceImpl implements SysFunctionGroupService {

	@Autowired
	private SysFunctionGroupMapper sysFunctionGroupMapper;
	
	@Override
	public LayuiTableData selectFunctionGroupByPage(LayuiTableParam param) 
	{
		SysFunctionGroupExample example = new SysFunctionGroupExample();
		SysFunctionGroupExample.Criteria c = example.createCriteria();
		c.andStatusEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(param.getParam().get("functionGroupName") !=null && !StringUtils.isBlank(param.getParam().get("functionGroupName")+""))
		{
			c.andGroupNameLike("%"+param.getParam().get("functionGroupName")+"%");
		}	
		example.setOrderByClause("order_num asc");
		
		return this.findByExample(param, example);
	}

	@Override
	public List<Map<String, Object>> selectSysFunctionGroupFunctions(String groupId) 
	{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		SysFunctionGroup group = sysFunctionGroupMapper.selectByPrimaryKey(groupId);
		JSONArray array = JSON.parseArray(group.getFunctionItems());
		if(array == null || array.size() <=0){
			return list;
		}
		for(java.util.Iterator<Object> iter = array.listIterator();iter.hasNext();)
		{
			String functionId = iter.next().toString();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", functionId);
			list.add(map);
		}
		return list;
	}
	@Override
	public Integer saveSysFunctionGroupInfo(SysFunctionGroup functionGroup) 
	{
		SysFunctionGroup group = sysFunctionGroupMapper.selectByPrimaryKey(functionGroup.getGroupId());
		if(group == null)
		{
			functionGroup.setGroupId(IdUtil.createIdByTime());
			functionGroup.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
			return sysFunctionGroupMapper.insert(functionGroup);
		}else{
			MyBeanUtils.copyPropertiesIgnoreNull(functionGroup, group);
			return sysFunctionGroupMapper.updateByPrimaryKey(group);
		}
	}
	@Override
	public Integer delSysFunctionGroupInfo(String functionGroupId) 
	{
		SysFunctionGroup group = sysFunctionGroupMapper.selectByPrimaryKey(functionGroupId);
		if(group == null)
		{
			return 0;
		}else{
			return sysFunctionGroupMapper.deleteByPrimaryKey(functionGroupId);
		}
	}
	@Override
	public Integer updatSysFunctionGroupRole(SysFunctionGroup functionGroup) 
	{
		SysFunctionGroup group = sysFunctionGroupMapper.selectByPrimaryKey(functionGroup.getGroupId());
		if(group != null)
		{
			group.setFunctionItems(functionGroup.getFunctionItems());
			return sysFunctionGroupMapper.updateByPrimaryKey(group);
		}
		return 0;
	}

	@Override
	public SysFunctionGroup selectSysFunctionGroupById(String groupId) 
	{
		return sysFunctionGroupMapper.selectByPrimaryKey(groupId);
	}
	/**
	 *  根据条件分页搜索
	 * @param param
	 * @param example
	 * @return
	 */
	private LayuiTableData findByExample(LayuiTableParam param,SysFunctionGroupExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<SysFunctionGroup> list = sysFunctionGroupMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysFunctionGroup> pageInfo= new PageInfo<SysFunctionGroup>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public List<SysFunctionGroup> selectFunctionGroupList() 
	{
		SysFunctionGroupExample example = new SysFunctionGroupExample();
		SysFunctionGroupExample.Criteria c = example.createCriteria();
		c.andStatusEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		return sysFunctionGroupMapper.selectByExample(example);
	}
}
