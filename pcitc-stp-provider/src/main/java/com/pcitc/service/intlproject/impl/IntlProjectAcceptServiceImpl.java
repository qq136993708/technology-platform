package com.pcitc.service.intlproject.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
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
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.IntlProject.IntlProjectAcceptMapper;
import com.pcitc.mapper.IntlProject.IntlProjectInfoMapper;
import com.pcitc.service.intlproject.IntlProjectAcceptService;
import com.pcitc.service.intlproject.IntlProjectContractService;
import com.pcitc.service.intlproject.IntlProjectInfoService;

@Service("intlProjectAcceptService")
public class IntlProjectAcceptServiceImpl implements IntlProjectAcceptService {
	
	@Autowired
	private IntlProjectAcceptMapper intlProjectAcceptMapper;
	
	@Autowired
	private IntlProjectInfoMapper projectInfoMapper;

	//@Autowired
	//private IntlProjectApplyService intlProjectApplyService;
	
	@Autowired
	private IntlProjectInfoService intlProjectInfoService;
	
	@Autowired
	IntlProjectContractService intlProjectContractService;
	
	@Override
	public LayuiTableData selectProjectAcceptList(LayuiTableParam param) {

		StringBuffer ordersb = new StringBuffer();
		LayuiTableParam p = new LayuiTableParam();
		p.setLimit(1000);
		if(!StringUtils.isBlank((String)param.getParam().get("reportYear")))
		{
			p.getParam().put("reportYear", param.getParam().get("reportYear"));
		}
		if(!StringUtils.isBlank((String)param.getParam().get("unitId"))) 
		{
			p.getParam().put("unitId", param.getParam().get("unitId"));
		}
		LayuiTableData projects = intlProjectInfoService.selectProjectInfoByPage(p);
		Set<String> pIds = new HashSet<String>();
		pIds.add("xxxx");
		for(int i=projects.getData().size()-1;i>=0;i--) 
		{
			Map<String,Object> map = MyBeanUtils.java2Map(projects.getData().get(i));
			ordersb.append((ordersb.length()>0?",":"")+"'"+map.get("projectId")+"'");
			pIds.add(map.get("projectId").toString());
		}
		
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
		if(!StringUtils.isBlank((String)param.getParam().get("reportYear")) || !StringUtils.isBlank((String)param.getParam().get("unitId")))
		{
			criteria.andProjectIdIn(new ArrayList<String>(pIds));
		}
		example.setOrderByClause("FIELD(project_id,"+ordersb.toString()+") DESC");
		
		return this.findByExample(param, example);
	}

	@Override
	public LayuiTableData selectProjectWaitingAcceptList(LayuiTableParam param) 
	{
		StringBuffer ordersb = new StringBuffer();
		LayuiTableParam p = new LayuiTableParam();
		p.setLimit(1000);
		if(!StringUtils.isBlank((String)param.getParam().get("reportYear")))
		{
			p.getParam().put("reportYear", param.getParam().get("reportYear"));
		}
		if(!StringUtils.isBlank((String)param.getParam().get("unitId"))) 
		{
			p.getParam().put("unitId", param.getParam().get("unitId"));
		}
		LayuiTableData projects = intlProjectInfoService.selectProjectInfoByPage(p);
		Set<String> pIds = new HashSet<String>();
		pIds.add("xxxx");
		for(int i=projects.getData().size()-1;i>=0;i--) 
		{
			Map<String,Object> map = MyBeanUtils.java2Map(projects.getData().get(i));
			ordersb.append((ordersb.length()>0?",":"")+"'"+map.get("projectId")+"'");
			pIds.add(map.get("projectId").toString());
		}
		
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
		//检索已经验收过的项目
		IntlProjectAcceptExample aexample = new IntlProjectAcceptExample();
		List<IntlProjectAccept> acceptlist = intlProjectAcceptMapper.selectByExample(aexample);
		Set<String> assets = new HashSet<String>();
		for(IntlProjectAccept accept:acceptlist) {
			assets.add(accept.getProjectId());
		}
		
		if(assets.size() >0) {
			criteria.andProjectIdNotIn(new ArrayList<String>(assets));
		}
		criteria.andProjectIdIn(ids);
		
		if(!StringUtils.isBlank((String)param.getParam().get("reportYear")) || !StringUtils.isBlank((String)param.getParam().get("unitId")))
		{
			criteria.andProjectIdIn(new ArrayList<String>(pIds));
		}
		example.setOrderByClause("FIELD(project_id,"+ordersb.toString()+") DESC");
		return findProjectByExample(param,example);
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
