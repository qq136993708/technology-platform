package com.pcitc.service.equipment.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.mapper.equipment.SreProjectAuditMapper;
import com.pcitc.mapper.equipment.SreProjectTaskAcMapper;
import com.pcitc.service.equipment.SreProjectTaskAcService;

@Service("ProjectTaskAcService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ProjectTaskAcServiceImpl implements SreProjectTaskAcService{
	private final static Logger logger = LoggerFactory.getLogger(ProjectTaskAcServiceImpl.class);
	@Autowired
	private SreProjectAuditMapper sreProjectAuditMapper;
	public LayuiTableData getlist(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String projecttask=getTableParam(param,"projecttask","");
		String status=getTableParam(param,"status","");
		Map map=new HashMap();
		map.put("projecttask", projecttask);
		map.put("status",status);
		System.out.println(">>>>>>>>projecttask="+projecttask);
		
		List<SreProjectAudit> list = sreProjectAuditMapper.getlist(map);
		PageInfo<SreProjectAudit> pageInfo = new PageInfo<SreProjectAudit>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
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
	public int updateAuditById(SreProjectAudit record)throws Exception
	{
		
		return sreProjectAuditMapper.updateAuditById(record);
	}
	public SreProjectAudit selectProjectAuditById(String id)throws Exception
	{
		return sreProjectAuditMapper.selectByPrimaryKey(id);
	}
	public int updateByPrimaryKey(SreProjectAudit record)throws Exception
	{
		return sreProjectAuditMapper.updateByPrimaryKey(record);
	}
}
