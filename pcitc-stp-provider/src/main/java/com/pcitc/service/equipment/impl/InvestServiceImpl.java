package com.pcitc.service.equipment.impl;

import java.util.ArrayList;
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
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreInvestmentrogress;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.mapper.equipment.SreEquipmentMapper;
import com.pcitc.mapper.equipment.SreForApplicationMapper;
import com.pcitc.mapper.equipment.SreProjectMapper;
import com.pcitc.mapper.equipment.SreProjectTaskMapper;
import com.pcitc.service.equipment.InvestService;
@Service("investService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public  class InvestServiceImpl implements InvestService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(InvestServiceImpl.class); 
	@Autowired
	private SreForApplicationMapper sreforapplicationMapper;
	@Autowired
	private SreProjectMapper sreProjectMapper;
	@Autowired
	private SreEquipmentMapper sreEquipmentMapper;
	@Autowired
	private SreProjectTaskMapper sreProjectTaskMapper;
	
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
	
	
	public LayuiTableData getInvestmentrogressPage(LayuiTableParam param)throws Exception
	{
		Map map = new HashMap<>();
		List<SreInvestmentrogress> list = new ArrayList<SreInvestmentrogress>();
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String InvestmentrogressId=getTableParam(param,"InvestmentrogressId","");
		SreEquipment quipment = new SreEquipment();
		SreProject sreProject = sreProjectMapper.selectByPrimaryKey(InvestmentrogressId);
		String[] sreEqumimpId =  sreProject.getEquipmentIds().split(",");
		for(int i =0;i<sreEqumimpId.length; i++) {
			SreInvestmentrogress mentrogress = new SreInvestmentrogress();//创建投资进度对象
			quipment = sreEquipmentMapper.selectByPrimaryKey(sreEqumimpId[i]);
			mentrogress.setEquipmentName(quipment.getName());//获取装备名称
			mentrogress.setUnitPrice(quipment.getUnitPrice());//获取装备金额
			SreProjectTask sreProjectTask = sreProjectTaskMapper.selectByTopicKey(String.valueOf(sreProject.getId()));//通过课题ID获取任务数据
			if(sreProjectTask!=null) {
				mentrogress.setContractState(sreProjectTask.getContractNum());//获取合同编号
				mentrogress.setTaskCloseState(sreProjectTask.getCloseStatus());//获取任务关闭状态
				mentrogress.setAcceptanceState(sreProjectTask.getIsCheck());//获取项目验收状态
				SreForApplication sreForApplication = sreforapplicationMapper.selectaRchaseidKey(sreEqumimpId[i]);
				if(sreForApplication!=null) {
					mentrogress.setForapplicationState(sreForApplication.getApplicationState());//获取转资状态
				}
			}
			list.add(mentrogress);
		}
		PageInfo<SreInvestmentrogress> pageInfo = new PageInfo<SreInvestmentrogress>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	

}