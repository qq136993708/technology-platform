package com.pcitc.service.intlproject.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectContract;
import com.pcitc.base.stp.IntlProject.IntlProjectContractExample;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.stp.IntlProject.IntlProjectInfoExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.IntlProject.IntlProjectContractMapper;
import com.pcitc.mapper.IntlProject.IntlProjectInfoMapper;
import com.pcitc.service.intlproject.IntlProjectContractService;

@Service("intlProjectContractService")
public class IntlProjectContractServiceImpl implements IntlProjectContractService {

	@Autowired
	private IntlProjectContractMapper intlProjectContracMapper;
	
	@Autowired
	private IntlProjectInfoMapper intlProjectInfoMapper;
	
	
	@Override
	public LayuiTableData selectProjectContractList(LayuiTableParam param) 
	{
		IntlProjectContractExample example = new IntlProjectContractExample();
		IntlProjectContractExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andContractTypeEqualTo(0);//签约项目
		if(param.getParam().get("contractName")!=null && !StringUtils.isBlank(param.getParam().get("contractName").toString())) 
		{
			IntlProjectInfoExample infoExample = new IntlProjectInfoExample();
			IntlProjectInfoExample.Criteria criteria = infoExample.createCriteria();
			criteria.andProjectNameLike("%"+param.getParam().get("contractName")+"%");
			
			List<IntlProjectInfo> infos = intlProjectInfoMapper.selectByExample(infoExample);
			List<String> infoIds = new ArrayList<String>();
			for(IntlProjectInfo apply:infos) {
				infoIds.add(apply.getProjectId());
			}
			infoIds.add("xxxx");
			c.andProjectIdIn(infoIds); 
		}
		//未过期 
		//c.andEndDateGreaterThan(DateUtil.dateToStr(new Date(), DateUtil.FMT_DD));
		return this.findByExample(param, example);
	}
	@Override
	public LayuiTableData selectEndProjectContractList(LayuiTableParam param) {
		IntlProjectContractExample example = new IntlProjectContractExample();
		IntlProjectContractExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andContractTypeEqualTo(1);//续约项目
		if(param.getParam().get("contractName")!=null && !StringUtils.isBlank(param.getParam().get("contractName").toString())) 
		{
			IntlProjectInfoExample infoExample = new IntlProjectInfoExample();
			IntlProjectInfoExample.Criteria criteria = infoExample.createCriteria();
			criteria.andProjectNameLike("%"+param.getParam().get("contractName")+"%");
			
			List<IntlProjectInfo> infos = intlProjectInfoMapper.selectByExample(infoExample);
			List<String> infoIds = new ArrayList<String>();
			for(IntlProjectInfo apply:infos) {
				infoIds.add(apply.getProjectId());
			}
			infoIds.add("xxxx");
			c.andProjectIdIn(infoIds); 
		}
		//已过期
		//c.andEndDateLessThan(DateUtil.dateToStr(new Date(), DateUtil.FMT_DD));
		
		return this.findByExample(param, example);
	}
	
	
	@Override
	public IntlProjectContract findById(String projectContrctId)
	{
		return intlProjectContracMapper.selectByPrimaryKey(projectContrctId);
	}

	@Override
	public Integer updateIntlProjectContract(IntlProjectContract contract) 
	{
		
		IntlProjectContract old = this.intlProjectContracMapper.selectByPrimaryKey(contract.getContractId());
		if(old != null) {
			
			MyBeanUtils.copyPropertiesIgnoreNull(contract, old);
			
			return this.intlProjectContracMapper.updateByPrimaryKey(old);
		}
		return 0;
	}
	@Override
	public Integer addIntlProjectContract(IntlProjectContract contract) 
	{
		if(contract.getContractId() == null) 
		{
			contract.setContractId(IdUtil.createIdByTime());
		}
		try 
		{
			return this.intlProjectContracMapper.insert(contract);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}  
	
	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectContractExample example) 
	{
		int pageSize = param.getLimit();
		int pageStart = (param.getPage()-1)*pageSize;
		int pageNum = pageStart/pageSize + 1;
		PageHelper.startPage(pageNum, pageSize);
		List<IntlProjectContract> list = intlProjectContracMapper.selectByExample(example);
		PageInfo<IntlProjectContract> pageInfo= new PageInfo<IntlProjectContract>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	@Override
	public Integer delIntlProjectContract(String contractId) {
		
		Integer rs = 0;
		IntlProjectContract contact = intlProjectContracMapper.selectByPrimaryKey(contractId);
		if(contact != null) {
			contact.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs = intlProjectContracMapper.updateByPrimaryKey(contact);
		}
		return rs;
	}
	@Override
	public Integer delIntlProjectContractReal(String projectContrctId) {
		Integer rs = 0;
		IntlProjectContract contact = intlProjectContracMapper.selectByPrimaryKey(projectContrctId);
		if(contact != null) {
			rs = intlProjectContracMapper.deleteByPrimaryKey(projectContrctId);
		}
		return rs;
	}
	@Override
	public String createProjectContractCode() {
		IntlProjectContractExample example = new IntlProjectContractExample();
		//IntlProjectContractExample.Criteria c = example.createCriteria();
		//IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		//criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		List<IntlProjectContract> applys = intlProjectContracMapper.selectByExample(example);
		
		return HanyuPinyinHelper.toPinyin("GJHZ_"+DateUtil.format(new Date(), DateUtil.FMT_YYYY)+"_HT_"+(100+applys.size()));
	}
	
}
