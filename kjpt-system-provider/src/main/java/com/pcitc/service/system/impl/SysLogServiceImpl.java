package com.pcitc.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysLog;
import com.pcitc.mapper.system.SysLogMapper;
import com.pcitc.service.system.SysLogService;


@Service("sysLogService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;
	

	/**
     * 根据ID获取日志信息详情
	*/
	public SysLog selectSysLog(String id) throws Exception
	{
		return sysLogMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改日志信息
	*/
	public Integer updateSysLog(SysLog record)throws Exception
	{
		return sysLogMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除日志信息
	 */
	public int deleteSysLog(String id)throws Exception
	{
		return sysLogMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加日志信息
	 */
	public Integer insertSysLog(SysLog record)throws Exception
	{
		return sysLogMapper.insert(record);
	}
	
	
	/**
	  * 获取日志（分页）
	*/
	public LayuiTableData getSysLogPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String userName=getTableParam(param,"userName","");
			String logType=getTableParam(param,"logType","");
			String userType=getTableParam(param,"userType","");
			String userCompany=getTableParam(param,"userCompany","");
			String userDepartment=getTableParam(param,"userDepartment","");
			Map map=new HashMap();
			map.put("userName", userName);
			map.put("logType", logType);
			map.put("userType", userType);
			map.put("userCompany", userCompany);
			map.put("userDepartment", userDepartment);
			String beginTime=getTableParam(param,"beginTime","");
			String endTime=getTableParam(param,"endTime","");
			
			map.put("endTime", endTime);
			map.put("beginTime", beginTime);
		 
			
			List<SysLog> list = sysLogMapper.getList(map);
			PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(list);
			System.out.println(">>>>>>>>>日志查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
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