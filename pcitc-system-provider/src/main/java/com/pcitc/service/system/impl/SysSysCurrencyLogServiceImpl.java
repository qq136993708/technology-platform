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
import com.pcitc.base.system.SysCurrencyLog;
import com.pcitc.base.system.SysCurrencyLogExample;
import com.pcitc.mapper.system.SysCurrencyLogMapper;
import com.pcitc.service.system.SysCurrencyLogService;
/**
 * 
 * @author uuy
 *
 */
@Service("sysCurrencyLogService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysSysCurrencyLogServiceImpl implements SysCurrencyLogService
{

	@Autowired
	public SysCurrencyLogMapper mapper;
	

	@Override
	public SysCurrencyLog selectSysCurrencyLog(String dataId) 
	{
		SysCurrencyLogExample example = new SysCurrencyLogExample();
		SysCurrencyLogExample.Criteria c = example.createCriteria();
		c.andDataIdEqualTo(dataId);
		return mapper.selectByExample(example).get(0);
	}
	@Override
	public Result saveSysCurrencyLog(SysCurrencyLog bean) throws Exception 
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
	public List<SysCurrencyLog> selectListSysCurrencyLog() 
	{
		SysCurrencyLogExample example = new SysCurrencyLogExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableSysCurrencyLog(LayuiTableParam param) 
	{
		SysCurrencyLogExample example = new SysCurrencyLogExample();
		return selectTableData(param, example);
	}
	@Override
	public List<SysCurrencyLog> selectListSysCurrencyLogByBean(SysCurrencyLog bean) 
	{
		SysCurrencyLogExample example = new SysCurrencyLogExample();
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,SysCurrencyLogExample example)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<SysCurrencyLog> list = mapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysCurrencyLog> pageInfo= new PageInfo<SysCurrencyLog>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	
}
