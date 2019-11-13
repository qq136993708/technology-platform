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
import com.pcitc.base.stp.equipment.SreHardwareAccept;
import com.pcitc.base.stp.equipment.SreHardwareAcceptExample;
import com.pcitc.base.stp.equipment.SreSoftwareAccept;
import com.pcitc.base.stp.equipment.SreSoftwareAcceptExample;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.mapper.equipment.SreHardwareAcceptMapper;
import com.pcitc.mapper.equipment.SreSoftwareAcceptMapper;
import com.pcitc.service.equipment.EquipmentAcceptService;
@Service("acceptService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentAcceptServiceImpl implements EquipmentAcceptService {
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentAcceptServiceImpl.class);
	@Autowired
	private SreSoftwareAcceptMapper sreSoftwareAcceptMapper;
	
	@Autowired
	private SreHardwareAcceptMapper sreHardwareAcceptMapper;
	
	
	/**===========================================软件 装备==========================================*/
	

	public SreSoftwareAccept selectSoftwareAccept(String id) throws Exception
	{
		return sreSoftwareAcceptMapper.selectByPrimaryKey(id);
	}

	public Integer updateSoftwareAccept(SreSoftwareAccept record)throws Exception
	{
		return sreSoftwareAcceptMapper.updateByPrimaryKey(record);
	}

	public int deleteSoftwareAccept(String id)throws Exception
	{
		return sreSoftwareAcceptMapper.deleteByPrimaryKey(id);
	}
	
	public Integer insertSoftwareAccept(SreSoftwareAccept record)throws Exception
	{
		return sreSoftwareAcceptMapper.insert(record);
	}

	public List<SreSoftwareAccept> getSoftwareAcceptList(SreSoftwareAcceptExample example)throws Exception
	{
		return sreSoftwareAcceptMapper.selectByExample(example);
	}
	
	public LayuiTableData getSoftwareAcceptPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String equipmentNo=(String)param.getParam().get("equipmentNo");
        String equipmentIdsObj=(String)param.getParam().get("equipmentIds");
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"equipmentNo="+equipmentNo+" equipmentIdsObj"+equipmentIdsObj);
		
		
		SreSoftwareAcceptExample example=new SreSoftwareAcceptExample();
		SreSoftwareAcceptExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if(equipmentNo!=null && !equipmentNo.equals(""))
		{
			
			//criteria.andNameLike("%"+name+"%");
		}
		
		if(equipmentIdsObj!=null && equipmentIdsObj.equals("null"))
		{
			
			if(!equipmentIdsObj.equals(""))
			{
				List list=CommonUtil.strToList(equipmentIdsObj);
				if(list!=null)
				{
					example.createCriteria().andSoftwareIdIn(list);
				}
				
			}
		}
		
		
		List<SreSoftwareAccept> list = sreSoftwareAcceptMapper.selectByExample(example);
		PageInfo<SreSoftwareAccept> pageInfo = new PageInfo<SreSoftwareAccept>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	

	public int batchDeleteSoftwareAccept(List<String> list)throws Exception
	{
		SreSoftwareAcceptExample example = new SreSoftwareAcceptExample();
		example.createCriteria().andSoftwareIdIn(list);
		return sreSoftwareAcceptMapper.deleteByExample(example);
	}
	public int batchDeleteHardwareAccept(List<String> list)throws Exception
	{
		SreHardwareAcceptExample example = new SreHardwareAcceptExample();
		example.createCriteria().andHardwareIdIn(list);
		return sreHardwareAcceptMapper.deleteByExample(example);
	}
	
	
	
	/**===========================================硬件 装备==========================================*/

	public SreHardwareAccept selectHardwareAccept(String id) throws Exception
	{
		return sreHardwareAcceptMapper.selectByPrimaryKey(id);
	}

	public Integer updateHardwareAccept(SreHardwareAccept record)throws Exception
	{
		return sreHardwareAcceptMapper.updateByPrimaryKey(record);
	}

	public int deleteHardwareAccept(String id)throws Exception
	{
		return sreHardwareAcceptMapper.deleteByPrimaryKey(id);
	}
	
	public Integer insertHardwareAccept(SreHardwareAccept record)throws Exception
	{
		return sreHardwareAcceptMapper.insert(record);
	}

	public List<SreHardwareAccept> getHardwareAcceptList(SreHardwareAcceptExample example)throws Exception
	{
		return sreHardwareAcceptMapper.selectByExample(example);
	}
	
	public LayuiTableData getHardwareAcceptPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String equipmentUse=(String)param.getParam().get("equipmentUse");
        String equipmentIdsObj=(String)param.getParam().get("equipmentIds");
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"equipmentUse="+equipmentUse+" equipmentIdsObj"+equipmentIdsObj);
		
		SreHardwareAcceptExample example=new SreHardwareAcceptExample();
		SreHardwareAcceptExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if(equipmentUse!=null && !equipmentUse.equals(""))
		{
			
			//criteria.andNameLike("%"+name+"%");
		}
		
		if(equipmentIdsObj!=null && equipmentIdsObj.equals("null"))
		{
			
			if(!equipmentIdsObj.equals(""))
			{
				List list=CommonUtil.strToList(equipmentIdsObj);
				if(list!=null)
				{
					example.createCriteria().andHardwareIdIn(list);
				}
				
			}
		}
		List<SreHardwareAccept> list = sreHardwareAcceptMapper.selectByExample(example);
		PageInfo<SreHardwareAccept> pageInfo = new PageInfo<SreHardwareAccept>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	
	

	

}
