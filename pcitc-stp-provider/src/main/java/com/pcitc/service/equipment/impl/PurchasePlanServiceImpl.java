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
import com.pcitc.base.stp.equipment.SrePurchasePlan;
import com.pcitc.base.stp.equipment.SrePurchasePlanExample;
import com.pcitc.mapper.equipment.SrePurchasePlanMapper;
import com.pcitc.service.equipment.PurchasePlanService;
@Service("purchasePlanService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchasePlanServiceImpl implements PurchasePlanService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(PurchasePlanServiceImpl.class);
	
	@Autowired
	private SrePurchasePlanMapper srePurchasePlanMapper;
	
	
	public SrePurchasePlan selectPurchasePlan(String id) throws Exception
	{
		return srePurchasePlanMapper.selectByPrimaryKey(id);
	}

	public Integer updatePurchasePlan(SrePurchasePlan record)throws Exception
	{
		return srePurchasePlanMapper.updateByPrimaryKey(record);
	}

	public int deletePurchasePlan(String id)throws Exception
	{
		return srePurchasePlanMapper.deleteByPrimaryKey(id);
	}
	
	
	public int batchDeletePurchasePlan(List<String> list)throws Exception
	{

		SrePurchasePlanExample example = new SrePurchasePlanExample();
		example.createCriteria().andPurchasePlanIdIn(list);
		return srePurchasePlanMapper.deleteByExample(example);
	}
	
	public List<SrePurchasePlan> getPurchasePlanListByIds(List<String> list)throws Exception
	{
		SrePurchasePlanExample example = new SrePurchasePlanExample();
		example.createCriteria().andPurchasePlanIdIn(list);
		return srePurchasePlanMapper.selectByExample(example);
	}

	public Integer insertPurchasePlan(SrePurchasePlan record)throws Exception
	{
		return srePurchasePlanMapper.insert(record);
	}

	public List<SrePurchasePlan> getPurchasePlanList(SrePurchasePlanExample example)throws Exception
	{
		return srePurchasePlanMapper.selectByExample(example);
	}
	
	
	

	public LayuiTableData getPurchasePlanPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String purchaseName=(String)param.getParam().get("purchaseName");
		String equipmentIdsObj=(String)param.getParam().get("equipmentIds");
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"purchaseName="+purchaseName+" equipmentIdsObj"+equipmentIdsObj);
				
		
		SrePurchasePlanExample example=new SrePurchasePlanExample();
		SrePurchasePlanExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if( purchaseName!=null && !purchaseName.equals(""))
		{
			
			//criteria.andNameLike("%"+name+"%");
		}
		List<SrePurchasePlan> list = srePurchasePlanMapper.selectByExample(example);
		PageInfo<SrePurchasePlan> pageInfo = new PageInfo<SrePurchasePlan>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	

}
