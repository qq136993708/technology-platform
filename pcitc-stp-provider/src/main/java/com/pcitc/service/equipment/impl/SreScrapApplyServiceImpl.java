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
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SreScrapApply;
import com.pcitc.mapper.equipment.SreForApplicationMapper;
import com.pcitc.mapper.equipment.SreProjectAuditMapper;
import com.pcitc.mapper.equipment.SreProjectTaskMapper;
import com.pcitc.mapper.equipment.SreScrapApplyMapper;
import com.pcitc.service.equipment.SreScrapApplyService;
@Service("sreScrapApplyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SreScrapApplyServiceImpl implements SreScrapApplyService {
	
	private final static Logger logger = LoggerFactory.getLogger(SreScrapApplyServiceImpl.class); 
	@Autowired
	private SreScrapApplyMapper sreScrapApplyMapper;
	
	@Autowired
	private SreProjectTaskMapper sreProjectTaskMapper;
	@Autowired
	private SreProjectAuditMapper sreProjectAuditMapper;
	
	public LayuiTableData getSreScrapApplyPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String ApplyName=getTableParam(param,"name","");
//		String applicationId=getTableParam(param,"applicationId","");
//		String applicationName=getTableParam(param,"applicationName","");
//		String applicationUserName=getTableParam(param,"applicationUserName","");
//		String applicationTime=getTableParam(param,"applicationTime","");
//		String applicationMoney=getTableParam(param,"applicationMoney","");
//		
		Map map=new HashMap();
		map.put("ApplyName", ApplyName);
//		map.put("applicationState", applicationState);
//		map.put("applicationName", applicationName);
//		map.put("applicationUserName", applicationUserName);
//		map.put("applicationTime", applicationTime);
//		map.put("applicationMoney", applicationMoney);
//		
//		System.out.println(">>>>>>>>applicationState="+applicationState);
		
		List<SreScrapApply> list = sreScrapApplyMapper.getlist(map);
		PageInfo<SreScrapApply> pageInfo = new PageInfo<SreScrapApply>(list);
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
	public int insert(SreScrapApply record)throws Exception
	{
		return sreScrapApplyMapper.insert(record);
	}
	public SreScrapApply selectByPrimaryKey(String id)throws Exception
	{
		return sreScrapApplyMapper.selectByPrimaryKey(id);
	}
	public int updateByPrimaryKeySelective(SreScrapApply record)throws Exception
	{
		return sreScrapApplyMapper.updateByPrimaryKeySelective(record);
	}
	
	public String addAudit(SreProjectAudit sreProjectAudit)throws Exception
	{
		try {
			if (sreProjectAudit != null && sreProjectAudit.getProjecttaskid() != null) {
				SreProjectTask p =sreProjectTaskMapper.selectByPrimaryKey(sreProjectAudit.getProjecttaskid());
				p.setIsCheck("2");
				int i = sreProjectTaskMapper.updateByPrimaryKey(p);
				if (i > 0) {
					sreProjectAuditMapper.insert(sreProjectAudit);
				}
			} 
			return "success";
		} catch (Exception e) {
			return "error";
		}
	
	}
}
