package com.pcitc.service.intlproject.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectAccept;
import com.pcitc.base.stp.IntlProject.IntlProjectAcceptExample;
import com.pcitc.base.stp.IntlProject.IntlProjectApply;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyExample;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlantExample;
import com.pcitc.mapper.IntlProject.IntlProjectAcceptMapper;
import com.pcitc.mapper.IntlProject.IntlProjectApplyMapper;
import com.pcitc.mapper.IntlProject.IntlProjectApplyPlantMapper;
import com.pcitc.service.intlproject.IntlProjectAcceptService;

@Service("intlProjectAcceptService")
public class IntlProjectAcceptServiceImpl implements IntlProjectAcceptService {
	
	@Autowired
	private IntlProjectAcceptMapper intlProjectAcceptMapper;
	
	@Autowired
	private IntlProjectApplyPlantMapper intlProjectApplyPlantMapper;

	@Autowired
	private IntlProjectApplyMapper intlProjectApplyMapper;
	
	@Override
	public LayuiTableData selectProjectAcceptList(LayuiTableParam param) {
		IntlProjectAcceptExample example = new IntlProjectAcceptExample();
		IntlProjectAcceptExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(new Integer(param.getParam().get("status").toString()));
		if(param.getParam().get("applyName") != null) {
			IntlProjectApplyExample ce = new IntlProjectApplyExample();
			IntlProjectApplyExample.Criteria ac = ce.createCriteria();
			if(param.getParam().get("applyName") != null) {
				ac.andApplyNameLike("%"+param.getParam().get("applyName")+"%");
			}
			List<IntlProjectApply> apps = intlProjectApplyMapper.selectByExample(ce);
			List<String> applyIds = new ArrayList<String>();
			applyIds.add("00010101010");//避免为空
			for(IntlProjectApply plt:apps) {
				applyIds.add(plt.getApplyId());
			}
			criteria.andProjectIdIn(applyIds);
		}
		return this.findByExample(param, example);
	}

	@Override
	public LayuiTableData selectProjectWaitingAcceptList(LayuiTableParam param) 
	{
		//检索待验收项目
		IntlProjectApplyPlantExample example = new IntlProjectApplyPlantExample();
		//IntlProjectApplyPlantExample.Criteria criteria = example.createCriteria();
		List<IntlProjectApplyPlant> rels = intlProjectApplyPlantMapper.selectByExample(example);
		List<String> applyIds = new ArrayList<String>();
		applyIds.add("00010101010");//避免为空
		for(IntlProjectApplyPlant plt:rels) {
			applyIds.add(plt.getApplyId());
		}
		//移除已验收过的项目
		IntlProjectAcceptExample aexample = new IntlProjectAcceptExample();
		List<IntlProjectAccept> acceptlist = intlProjectAcceptMapper.selectByExample(aexample);
		for(IntlProjectAccept accept:acceptlist) {
			applyIds.remove(accept.getProjectId());
		}
		IntlProjectApplyExample ce = new IntlProjectApplyExample();
		IntlProjectApplyExample.Criteria criteria = ce.createCriteria();
		if(param.getParam().get("applyName") != null) {
			criteria.andApplyNameLike("%"+param.getParam().get("applyName")+"%");
		}
		criteria.andApplyIdIn(applyIds);
		return findApplyByExample(param,ce);
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
	private LayuiTableData findApplyByExample(LayuiTableParam param,IntlProjectApplyExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<IntlProjectApply> list = intlProjectApplyMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectApply> pageInfo= new PageInfo<IntlProjectApply>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
}
