package com.pcitc.service.equipment.impl;

import java.util.List;

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
import com.pcitc.base.stp.equipment.SreContract;
import com.pcitc.base.stp.equipment.SreContractExample;
import com.pcitc.mapper.equipment.SreContractMapper;
import com.pcitc.service.equipment.ContractService;
@Service("contractService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ContractServiceImpl implements ContractService {
	private final static Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
	@Autowired
	private SreContractMapper sreContractMapper;
	
	
	public SreContract selectContract(String id) throws Exception
	{
		return sreContractMapper.selectByPrimaryKey(id);
	}

	public Integer updateContract(SreContract record)throws Exception
	{
		return sreContractMapper.updateByPrimaryKey(record);
	}

	public int deleteContract(String id)throws Exception
	{
		return sreContractMapper.deleteByPrimaryKey(id);
	}
	
	
	public int batchDeleteContract(List<String> list)throws Exception
	{

		SreContractExample example = new SreContractExample();
		example.createCriteria().andContractIdIn(list);
		return sreContractMapper.deleteByExample(example);
	}
	
	public List<SreContract> getContractListByIds(List<String> list)throws Exception
	{
		SreContractExample example = new SreContractExample();
		example.createCriteria().andContractIdIn(list);
		return sreContractMapper.selectByExample(example);
	}

	public Integer insertContract(SreContract record)throws Exception
	{
		return sreContractMapper.insert(record);
	}

	public List<SreContract> getContractList(SreContractExample example)throws Exception
	{
		return sreContractMapper.selectByExample(example);
	}
	
	public LayuiTableData getContractPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String contractCode=(String)param.getParam().get("contractCode");
		String equipmentIdsObj=(String)param.getParam().get("equipmentIds");
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"contractCode="+contractCode+" equipmentIdsObj"+equipmentIdsObj);
		
		SreContractExample example=new SreContractExample();
		SreContractExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if(!contractCode.equals(""))
		{
			
			//criteria.andNameLike("%"+name+"%");
		}
		
		List<SreContract> list = sreContractMapper.selectByExample(example);
		PageInfo<SreContract> pageInfo = new PageInfo<SreContract>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	

}
