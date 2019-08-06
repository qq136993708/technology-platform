package com.pcitc.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysReqLogs;
import com.pcitc.base.system.SysReqLogsExample;
import com.pcitc.mapper.system.SysReqLogsMapper;
import com.pcitc.service.system.SysReqLogsService;
/**
 * 
 * @author uuy
 *
 */
@Service("sysReqLogsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysReqLogsServiceImpl implements SysReqLogsService
{

	@Autowired
	public SysReqLogsMapper mapper;
	

	@Override
	public SysReqLogs selectSysReqLogs(Integer dataId) 
	{
		SysReqLogsExample example = new SysReqLogsExample();
		SysReqLogsExample.Criteria c = example.createCriteria();
		c.andDataIdEqualTo(dataId);
		return mapper.selectByExample(example).get(0);
	}
	@Override
	public Result saveSysReqLogs(SysReqLogs bean) throws Exception 
	{
		Boolean status = false;
		try 
		{
			Integer rs = mapper.insert(bean);
			if(rs > 0) {
				status = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new Result(status);
	}
	
	
	
	@Override
	public List<SysReqLogs> selectListSysReqLogs() 
	{
		SysReqLogsExample example = new SysReqLogsExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableSysReqLogs(LayuiTableParam param) 
	{
		SysReqLogsExample example = new SysReqLogsExample();
		return selectTableData(param, example);
	}
	@Override
	public List<SysReqLogs> selectListSysReqLogsByBean(SysReqLogs bean) 
	{
		SysReqLogsExample example = new SysReqLogsExample();
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,SysReqLogsExample example)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<SysReqLogs> list = mapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysReqLogs> pageInfo= new PageInfo<SysReqLogs>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	
}
