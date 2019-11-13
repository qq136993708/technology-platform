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
import com.pcitc.base.stp.equipment.SreBusinessTalk;
import com.pcitc.base.stp.equipment.SreBusinessTalkExample;
import com.pcitc.mapper.equipment.SreBusinessTalkMapper;
import com.pcitc.service.equipment.BusinessNegotiationService;
@Service("businessNegotiationService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BusinessNegotiationServiceImpl implements BusinessNegotiationService {
	private final static Logger logger = LoggerFactory.getLogger(BusinessNegotiationServiceImpl.class); 
	@Autowired
	private SreBusinessTalkMapper sreBusinessTalkMapper;
	
	
	public SreBusinessTalk selectBusinessTalk(String id) throws Exception
	{
		return sreBusinessTalkMapper.selectByPrimaryKey(id);
	}

	public Integer updateBusinessTalk(SreBusinessTalk record)throws Exception
	{
		return sreBusinessTalkMapper.updateByPrimaryKey(record);
	}

	public int deleteBusinessTalk(String id)throws Exception
	{
		return sreBusinessTalkMapper.deleteByPrimaryKey(id);
	}
	
	
	public int batchDeleteBusinessTalk(List<String> list)throws Exception
	{

		SreBusinessTalkExample example = new SreBusinessTalkExample();
		example.createCriteria().andTalkIdIn(list) ;
		return sreBusinessTalkMapper.deleteByExample(example);
	}
	
	public List<SreBusinessTalk> getBusinessTalkListByIds(List<String> list)throws Exception
	{
		SreBusinessTalkExample example = new SreBusinessTalkExample();
		example.createCriteria().andTalkIdIn(list);
		return sreBusinessTalkMapper.selectByExample(example);
	}

	public Integer insertBusinessTalk(SreBusinessTalk record)throws Exception
	{
		return sreBusinessTalkMapper.insert(record);
	}

	public List<SreBusinessTalk> getBusinessTalkList(SreBusinessTalkExample example)throws Exception
	{
		return sreBusinessTalkMapper.selectByExample(example);
	}
	
	public LayuiTableData getBusinessTalkPage(LayuiTableParam param)throws Exception
	{
		
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String purchasePlanId=(String)param.getParam().get("purchasePlanId");
		String equipmentIdsObj=(String)param.getParam().get("equipmentIds");
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"purchasePlanId="+purchasePlanId+" equipmentIdsObj"+equipmentIdsObj);
						
		
		SreBusinessTalkExample example=new SreBusinessTalkExample();
		SreBusinessTalkExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if(purchasePlanId!=null && !purchasePlanId.equals(""))
		{
			
			//criteria.andna .andNameLike("%"+name+"%");
		}
		List<SreBusinessTalk> list = sreBusinessTalkMapper.selectByExample(example);
		PageInfo<SreBusinessTalk> pageInfo = new PageInfo<SreBusinessTalk>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	
	

}
