package com.pcitc.service.equipment.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreEquipmentExample;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectExample;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SreProjectTaskExample;
import com.pcitc.base.stp.equipment.SreProjectYear;
import com.pcitc.base.stp.equipment.SreProjectYearExample;
import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.stp.equipment.SreTechMeetingExample;
import com.pcitc.mapper.equipment.SreEquipmentMapper;
import com.pcitc.mapper.equipment.SreProjectMapper;
import com.pcitc.mapper.equipment.SreProjectTaskMapper;
import com.pcitc.mapper.equipment.SreProjectYearMapper;
import com.pcitc.mapper.equipment.SreTechMeetingMapper;
import com.pcitc.service.equipment.EquipmentService;
@Service("equipmentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentServiceImpl implements EquipmentService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class); 
	@Autowired
	private SreEquipmentMapper sreEquipmentMapper;
	
	@Autowired
	private SreProjectMapper sreProjectMapper;
	
	@Autowired
	private SreTechMeetingMapper sreTechMeetingMapper;
	
	@Autowired
	private SreProjectYearMapper sreProjectYearMapper;
	
	@Autowired
	private SreProjectTaskMapper sreProjectTaskMapper;
	
	
	
	
	
	
	
	
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
	
	private String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
	{
		String resault="";
		Object object=param.getParam().get(paramName);
		if(object!=null)
		{
			resault=(String)object;
		}
		return resault;
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
		String name=getTableParam(param,"name","");
		String equipmentIds=getTableParam(param,"equipmentIds","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String applyDepartName=getTableParam(param,"applyDepartName","");
		String applyDepartCode=getTableParam(param,"applyDepartCode","");
		Map map=new HashMap();
		map.put("name", name);
		map.put("equipmentIds", equipmentIds);
		map.put("auditStatus", auditStatus);
		
		map.put("applyDepartName", applyDepartName);
		
		
		System.out.println(">>>>>>>>applyDepartCode="+applyDepartCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyDepartCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyDepartCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		
		
		List<SreEquipment> list = sreEquipmentMapper.getList(map);
		PageInfo<SreEquipment> pageInfo = new PageInfo<SreEquipment>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	/**===========================================计划==========================================*/

	public SreProject selectProjectBasic(String id) throws Exception
	{
		return sreProjectMapper.selectByPrimaryKey(id);
	}

	public Integer updateProjectBasic(SreProject record)throws Exception
	{
		return sreProjectMapper.updateByPrimaryKey(record);
	}

	public int deleteProjectBasic(String id)throws Exception
	{
		return sreProjectMapper.deleteByPrimaryKey(id);
	}

	public Integer insertProjectBasic(SreProject record)throws Exception
	{
		return sreProjectMapper.insert(record);
	}

	public List<SreProject> getProjectBasicList(SreProjectExample example)throws Exception
	{
		return sreProjectMapper.selectByExample(example);
	}
	public int batchDeleteProjectBasic(List<String> list)throws Exception
	{

		SreProjectExample example = new SreProjectExample();
		example.createCriteria().andIdIn(list);
		return sreProjectMapper.deleteByExample(example);
	}
	
	
	//自定义
	public LayuiTableData getProjectPage(LayuiTableParam param)throws Exception
	{
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
				
		String name=getTableParam(param,"name","");
		String equipmentIds=getTableParam(param,"equipmentIds","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String setupYear=getTableParam(param,"setupYear","");
		String keyWord=getTableParam(param,"keyWord","");
		String leadUnitName=getTableParam(param,"leadUnitName","");
		String leadUnitCode=getTableParam(param,"leadUnitCode","");
		String applyUnitName=getTableParam(param,"applyUnitName","");
		String applyUnitCode=getTableParam(param,"applyUnitCode","");
		String joinUnitName=getTableParam(param,"joinUnitName","");
		String joinUnitCode=getTableParam(param,"joinUnitCode","");
		
		Map map=new HashMap();
		map.put("name", name);
		map.put("equipmentIds", equipmentIds);
		map.put("auditStatus", auditStatus);
		map.put("setupYear", setupYear);
		map.put("keyWord", keyWord);
		map.put("leadUnitName", leadUnitName);
		map.put("leadUnitCode", leadUnitCode);
		
		map.put("applyUnitName", applyUnitName);
		
		map.put("joinUnitName", joinUnitName);
		map.put("joinUnitCode", joinUnitCode);
		
		System.out.println(">>>>>>>>applyUnitCode="+applyUnitCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyUnitCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyUnitCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		System.out.println(">>>>>>>>sqlstr"+applyUnitCodeStr.toString());
		List<SreProject> list = sreProjectMapper.getList(map);
		PageInfo<SreProject> pageInfo = new PageInfo<SreProject>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	
	
	

	/**===========================================任务书=========================================*/

	public SreProjectTask selectSreProjectTask(String id) throws Exception
	{
		return sreProjectTaskMapper.selectByPrimaryKey(id);
	}

	public Integer updateSreProjectTask(SreProjectTask record)throws Exception
	{
		return sreProjectTaskMapper.updateByPrimaryKey(record);
	}

	public int deleteSreProjectTask(String id)throws Exception
	{
		return sreProjectTaskMapper.deleteByPrimaryKey(id);
	}

	public Integer insertSreProjectTask(SreProjectTask record)throws Exception
	{
		return sreProjectTaskMapper.insert(record);
	}

	public List<SreProjectTask> getSreProjectTaskList(SreProjectTaskExample example)throws Exception
	{
		return sreProjectTaskMapper.selectByExample(example);
	}
	public int batchDeleteSreProjectTask(List<String> list)throws Exception
	{

		SreProjectTaskExample example = new SreProjectTaskExample();
		example.createCriteria().andTaskIdIn(list);
		return sreProjectTaskMapper.deleteByExample(example);
	}
	
	
	public LayuiTableData getSreProjectTaskPage(LayuiTableParam param)throws Exception
	{
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
				
		String topicName=getTableParam(param,"topicName","");
		String topicId=getTableParam(param,"topicId","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String contractNum=getTableParam(param,"contractNum","");
		String leadUnitName=getTableParam(param,"leadUnitName","");
		String leadUnitCode=getTableParam(param,"leadUnitCode","");
		String applyUnitName=getTableParam(param,"applyUnitName","");
		String applyUnitCode=getTableParam(param,"applyUnitCode","");
		String joinUnitName=getTableParam(param,"joinUnitName","");
		String joinUnitCode=getTableParam(param,"joinUnitCode","");
		
		
		Map map=new HashMap();
		map.put("topicName", topicName);
		map.put("auditStatus", auditStatus);
		map.put("leadUnitName", leadUnitName);
		map.put("leadUnitCode", leadUnitCode);
		map.put("applyUnitName", applyUnitName);
		map.put("joinUnitName", joinUnitName);
		map.put("joinUnitCode", joinUnitCode);
		map.put("topicId", topicId);
		map.put("contractNum", contractNum);
		System.out.println(">>>>>>>>applyUnitCode="+applyUnitCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyUnitCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyUnitCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		System.out.println(">>>>>>>>sqlstr"+applyUnitCodeStr.toString());
		
		
		List<SreProjectTask> list = sreProjectTaskMapper.getList(map);
		PageInfo<SreProjectTask> pageInfo = new PageInfo<SreProjectTask>(list);
		System.out.println(">>>>>>>>>任务书查询分页结果 "+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	
	
	
	
	

	/**===========================================项目费用年==========================================*/

	public SreProjectYear selectSreProjectYear(String id) throws Exception
	{
		return sreProjectYearMapper.selectByPrimaryKey(id);
	}

	public Integer updateSreProjectYear(SreProjectYear record)throws Exception
	{
		return sreProjectYearMapper.updateByPrimaryKey(record);
	}

	public int deleteSreProjectYear(String id)throws Exception
	{
		return sreProjectYearMapper.deleteByPrimaryKey(id);
	}

	public Integer insertSreProjectYear(SreProjectYear record)throws Exception
	{
		return sreProjectYearMapper.insert(record);
	}

	public List<SreProjectYear> getSreProjectYearList(SreProjectYearExample example)throws Exception
	{
		return sreProjectYearMapper.selectByExample(example);
	}
	
	
	public int deleteSreProjectYearExample(SreProjectYearExample example)throws Exception
	{
		return sreProjectYearMapper.deleteByExample(example);
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
