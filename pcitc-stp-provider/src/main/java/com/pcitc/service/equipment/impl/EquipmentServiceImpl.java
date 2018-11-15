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
import com.pcitc.base.common.PageResult;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreEquipmentExample;
import com.pcitc.base.stp.equipment.SreProjectBasic;
import com.pcitc.base.stp.equipment.SreProjectBasicExample;
import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.stp.equipment.SreTechMeetingExample;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.mapper.equipment.SreEquipmentMapper;
import com.pcitc.mapper.equipment.SreProjectBasicMapper;
import com.pcitc.mapper.equipment.SreTechMeetingMapper;
import com.pcitc.service.equipment.EquipmentService;
@Service("equipmentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentServiceImpl implements EquipmentService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class); 
	@Autowired
	private SreEquipmentMapper sreEquipmentMapper;
	
	@Autowired
	private SreProjectBasicMapper sreProjectBasicMapper;
	
	@Autowired
	private SreTechMeetingMapper sreTechMeetingMapper;
	
	
	public SreEquipment selectEquipment(String id) throws Exception
	{
		return sreEquipmentMapper.selectByPrimaryKey(id);
	}

	public Integer updateEquipment(SreEquipment record)throws Exception
	{
		return sreEquipmentMapper.updateByPrimaryKey(record);
	}

	public int deleteEquipment(String id)throws Exception
	{
		return sreEquipmentMapper.deleteByPrimaryKey(id);
	}
	
	
	public int batchDeleteEquipment(List<String> list)throws Exception
	{

		SreEquipmentExample example = new SreEquipmentExample();
		example.createCriteria().andEquipmentIdIn(list);
		return sreEquipmentMapper.deleteByExample(example);
	}
	
	public List<SreEquipment> getEquipmentListByIds(List<String> list)throws Exception
	{
		SreEquipmentExample example = new SreEquipmentExample();
		example.createCriteria().andEquipmentIdIn(list);
		return sreEquipmentMapper.selectByExample(example);
	}

	public Integer insertEquipment(SreEquipment record)throws Exception
	{
		return sreEquipmentMapper.insert(record);
	}

	public List<SreEquipment> getEquipmentList(SreEquipmentExample example)throws Exception
	{
		return sreEquipmentMapper.selectByExample(example);
	}
	
	public LayuiTableData getEquipmentPage(LayuiTableParam param)throws Exception
	{
		
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		String name=(String)param.getParam().get("name");
		String equipmentIds=(String)param.getParam().get("equipmentIds");
		
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"name="+name+" equipmentIds"+equipmentIds);
		SreEquipmentExample example=new SreEquipmentExample();
		SreEquipmentExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if(!name.equals(""))
		{
			
			criteria.andNameLike("%"+name+"%");
		}
		if(equipmentIds!=null && !equipmentIds.equals(""))
		{
			
				List<String> list=CommonUtil.strToList(equipmentIds);
				logger.info("================= equipmentIds list: "+list.size());
				if(list!=null)
				{
					criteria.andEquipmentIdIn(list);
				}
		}
		
		List<SreEquipment> list = sreEquipmentMapper.selectByExample(example);
		PageInfo<SreEquipment> pageInfo = new PageInfo<SreEquipment>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	/**===========================================项目==========================================*/

	public SreProjectBasic selectProjectBasic(String id) throws Exception
	{
		return sreProjectBasicMapper.selectByPrimaryKey(id);
	}

	public Integer updateProjectBasic(SreProjectBasic record)throws Exception
	{
		return sreProjectBasicMapper.updateByPrimaryKey(record);
	}

	public int deleteProjectBasic(String id)throws Exception
	{
		return sreProjectBasicMapper.deleteByPrimaryKey(id);
	}

	public Integer insertProjectBasic(SreProjectBasic record)throws Exception
	{
		return sreProjectBasicMapper.insert(record);
	}

	public List<SreProjectBasic> getProjectBasicList(SreProjectBasicExample example)throws Exception
	{
		return sreProjectBasicMapper.selectByExample(example);
	}
	public int batchDeleteProjectBasic(List<String> list)throws Exception
	{

		SreProjectBasicExample example = new SreProjectBasicExample();
		example.createCriteria().andProjectIdIn(list);
		return sreProjectBasicMapper.deleteByExample(example);
	}
	
	
	public LayuiTableData getProjectBasicPage(LayuiTableParam param)throws Exception
	{
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
				
		
		String name=(String)param.getParam().get("name");
		String equipmentIds=(String)param.getParam().get("equipmentIds");
		
		String status=(String)param.getParam().get("status");
		
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"name="+name+" equipmentIds"+equipmentIds);
		SreProjectBasicExample example=new SreProjectBasicExample();
		SreProjectBasicExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" create_date desc ");
		if(name!=null && !name.equals(""))
		{
			
			criteria.andNameLike("%"+name+"%");
		}
		
		if(status!=null && !status.equals(""))
		{
			
			criteria.andStatusEqualTo(status);
		}
		
		if(equipmentIds!=null && !equipmentIds.equals(""))
		{
			
				List<String> list=CommonUtil.strToList(equipmentIds);
				if(list!=null)
				{
					criteria.andProjectIdIn(list);
				}
		}
		
		List<SreProjectBasic> list = sreProjectBasicMapper.selectByExample(example);
		PageInfo<SreProjectBasic> pageInfo = new PageInfo<SreProjectBasic>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	/**===========================================技术交流==========================================*/

	
	public SreTechMeeting selectMeeting(String id) throws Exception
	{
		return sreTechMeetingMapper.selectByPrimaryKey(id);
	}

	public Integer updateMeeting(SreTechMeeting record)throws Exception
	{
		return sreTechMeetingMapper.updateByPrimaryKey(record);
	}

	public int deleteMeeting(String id)throws Exception
	{
		return sreTechMeetingMapper.deleteByPrimaryKey(id);
	}
	
	
	public int batchDeleteMeeting(List<String> list)throws Exception
	{

		SreTechMeetingExample example = new SreTechMeetingExample();
		example.createCriteria().andProjectIdIn(list);
		return sreTechMeetingMapper.deleteByExample(example);
	}
	
	public List<SreTechMeeting> getMeetingListByIds(List<String> list)throws Exception
	{
		SreTechMeetingExample example = new SreTechMeetingExample();
		example.createCriteria().andMeetingIdIn(list);
		return sreTechMeetingMapper.selectByExample(example);
	}

	public Integer insertMeeting(SreTechMeeting record)throws Exception
	{
		return sreTechMeetingMapper.insert(record);
	}

	public List<SreTechMeeting> getMeetingList(SreTechMeetingExample example)throws Exception
	{
		return sreTechMeetingMapper.selectByExample(example);
	}
	
	
	public LayuiTableData getMeetingPage(LayuiTableParam param)throws Exception
	{
		     //每页显示条数
				int pageSize = param.getLimit();
				//从第多少条开始
				int pageStart = (param.getPage()-1)*pageSize;
				//当前是第几页
				int pageNum = pageStart/pageSize + 1;
				// 1、设置分页信息，包括当前页数和每页显示的总计数
				PageHelper.startPage(pageNum, pageSize);
						
				
				String name=(String)param.getParam().get("name");
				String equipmentIds=(String)param.getParam().get("equipmentIds");
				
				logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize+"name="+name+" equipmentIds"+equipmentIds);
				SreTechMeetingExample example=new SreTechMeetingExample();
				SreTechMeetingExample.Criteria criteria = example.createCriteria();
				example.setOrderByClause(" create_date desc ");
				/*if(!name.equals(""))
				{
					
					criteria.andNameLike("%"+name+"%");
				}
				*/
				
				List<SreTechMeeting> list = sreTechMeetingMapper.selectByExample(example);
				PageInfo<SreTechMeeting> pageInfo = new PageInfo<SreTechMeeting>(list);
				System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
				
				LayuiTableData data = new LayuiTableData();
				data.setData(pageInfo.getList());
				Long total = pageInfo.getTotal();
				data.setCount(total.intValue());
			    return data;
	}

	
	
	
	
	
	
	
	
	

}
