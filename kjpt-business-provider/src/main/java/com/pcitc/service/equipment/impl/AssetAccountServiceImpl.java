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
import com.pcitc.base.stp.equipment.SreAssetAccount;
import com.pcitc.base.stp.equipment.SreAssetAccountExample;
import com.pcitc.mapper.equipment.SreAssetAccountMapper;
import com.pcitc.service.equipment.AssetAccountService;
@Service("assetAccountService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AssetAccountServiceImpl implements AssetAccountService {
	private final static Logger logger = LoggerFactory.getLogger(AssetAccountServiceImpl.class); 
	@Autowired
	private SreAssetAccountMapper sreAssetAccountMapper;
	
	
	public SreAssetAccount selectAssetAccount(String id) throws Exception
	{
		return sreAssetAccountMapper.selectByPrimaryKey(id);
	}

	public Integer updateAssetAccount(SreAssetAccount record)throws Exception
	{
		return sreAssetAccountMapper.updateByPrimaryKey(record);
	}

	public int deleteAssetAccount(String id)throws Exception
	{
		return sreAssetAccountMapper.deleteByPrimaryKey(id);
	}
	
	
	public int batchDeleteAssetAccount(List<String> list)throws Exception
	{

		SreAssetAccountExample example = new SreAssetAccountExample();
		example.createCriteria().andAccountIdIn(list);
		return sreAssetAccountMapper.deleteByExample(example);
	}
	
	public List<SreAssetAccount> getAssetAccountListByIds(List<String> list)throws Exception
	{
		SreAssetAccountExample example = new SreAssetAccountExample();
		example.createCriteria().andAccountIdIn(list);
		return sreAssetAccountMapper.selectByExample(example);
	}

	public Integer insertAssetAccount(SreAssetAccount record)throws Exception
	{
		return sreAssetAccountMapper.insert(record);
	}

	public List<SreAssetAccount> getAssetAccountList(SreAssetAccountExample example)throws Exception
	{
		return sreAssetAccountMapper.selectByExample(example);
	}
	
	
	public LayuiTableData getAssetAccountPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String producName=(String)param.getParam().get("producName");
		String equipmentIdsObj=(String)param.getParam().get("equipmentIds");
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"producName="+producName+" equipmentIdsObj"+equipmentIdsObj);
		
		
		SreAssetAccountExample example=new SreAssetAccountExample();
		SreAssetAccountExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if(!producName.equals(""))
		{
			
			criteria.andProducNameLike("%"+producName+"%");
		}
		
		List<SreAssetAccount> list = sreAssetAccountMapper.selectByExample(example);
		PageInfo<SreAssetAccount> pageInfo = new PageInfo<SreAssetAccount>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	
	

}
