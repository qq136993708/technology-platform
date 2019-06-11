package com.pcitc.service.intlproject.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectAccept;
import com.pcitc.base.stp.IntlProject.IntlProjectAcceptExample;
import com.pcitc.base.stp.IntlProject.IntlProjectContract;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.stp.IntlProject.IntlProjectInfoExample;
import com.pcitc.mapper.IntlProject.IntlProjectAcceptMapper;
import com.pcitc.mapper.IntlProject.IntlProjectInfoMapper;
import com.pcitc.service.intlproject.IntlProjectAcceptService;
import com.pcitc.service.intlproject.IntlProjectContractService;

@Service("intlProjectAcceptService")
public class IntlProjectAcceptServiceImpl implements IntlProjectAcceptService {
	
	@Autowired
	private IntlProjectAcceptMapper intlProjectAcceptMapper;
	
	@Autowired
	private IntlProjectInfoMapper projectInfoMapper;

	//@Autowired
	//private IntlProjectApplyMapper intlProjectApplyMapper;
	
	@Autowired
	IntlProjectContractService intlProjectContractService;
	
	@Override
	public LayuiTableData selectProjectAcceptList(LayuiTableParam param) {
		IntlProjectAcceptExample example = new IntlProjectAcceptExample();
		IntlProjectAcceptExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(new Integer(param.getParam().get("status").toString()));
		if(param.getParam().get("projectName") != null) {
			IntlProjectInfoExample ce = new IntlProjectInfoExample();
			IntlProjectInfoExample.Criteria ac = ce.createCriteria();
			if(param.getParam().get("projectName") != null) {
				ac.andProjectNameLike("%"+param.getParam().get("projectName")+"%");
			}
			List<IntlProjectInfo> apps = projectInfoMapper.selectByExample(ce);
			List<String> applyIds = new ArrayList<String>();
			applyIds.add("xxxx");//避免为空
			for(IntlProjectInfo plt:apps) {
				applyIds.add(plt.getProjectId());
			}
			criteria.andProjectIdIn(applyIds);
		}
		//param.getParam().put("status", AcceptStatusEnum.STATUS_REFUSE.getCode());
		return this.findByExample(param, example);
	}

	@Override
	public LayuiTableData selectProjectWaitingAcceptList(LayuiTableParam param) 
	{
		//检索待验收项目
		IntlProjectInfoExample example = new IntlProjectInfoExample();
		IntlProjectInfoExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(param.getParam().get("projectName") != null) {
			criteria.andProjectNameLike("%"+param.getParam().get("projectName")+"%");
		}
		//只检索已签约项目
		List<IntlProjectContract> contracts = intlProjectContractService.selectAllProjctContract();
		List<String> ids = new ArrayList<String>();
		for(IntlProjectContract c:contracts) {
			ids.add(c.getProjectId());
		}
		criteria.andProjectIdIn(ids);
		
		List<IntlProjectInfo> infos = projectInfoMapper.selectByExample(example);
		Map<String,IntlProjectInfo> maps = new HashMap<String,IntlProjectInfo>();
		for(IntlProjectInfo plt:infos) {
			maps.put(plt.getProjectId(), plt);
		}
		
		//移除已验收过的项目
		IntlProjectAcceptExample aexample = new IntlProjectAcceptExample();
		List<IntlProjectAccept> acceptlist = intlProjectAcceptMapper.selectByExample(aexample);
		for(IntlProjectAccept accept:acceptlist) {
			maps.remove(accept.getProjectId());
		}
		
		IntlProjectInfoExample ce = new IntlProjectInfoExample();
		IntlProjectInfoExample.Criteria projectCriteria = ce.createCriteria();
		if(maps.size()>0) {
			projectCriteria.andProjectIdIn(new ArrayList<String>(maps.keySet()));
		}else {
			LayuiTableData data = new LayuiTableData();
			data.setData(new ArrayList<Object>());
			return data;
		}
		return findProjectByExample(param,ce);
	}
	
	@Override
	public IntlProjectAccept findProjectAccept(String acceptId) {
		return intlProjectAcceptMapper.selectByPrimaryKey(acceptId);
	}

	@Override
	public Integer saveProjectAccept(IntlProjectAccept accept) {
		return intlProjectAcceptMapper.insert(accept);
	}

	@Override
	public Integer updProjectAccept(IntlProjectAccept accept) {
		return intlProjectAcceptMapper.updateByPrimaryKey(accept);
	}

	@Override
	public Integer delProjectAccept(String acceptId) {
		return intlProjectAcceptMapper.deleteByPrimaryKey(acceptId);
	}

	@Override
	public Integer delProjectAcceptReal(String acceptId) {
		return intlProjectAcceptMapper.deleteByPrimaryKey(acceptId);
	}
	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectAcceptExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<IntlProjectAccept> list = intlProjectAcceptMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectAccept> pageInfo= new PageInfo<IntlProjectAccept>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	private LayuiTableData findProjectByExample(LayuiTableParam param,IntlProjectInfoExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<IntlProjectInfo> list = projectInfoMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectInfo> pageInfo= new PageInfo<IntlProjectInfo>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
}
