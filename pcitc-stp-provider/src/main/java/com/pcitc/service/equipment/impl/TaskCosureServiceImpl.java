package com.pcitc.service.equipment.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.mapper.equipment.SreForApplicationMapper;
import com.pcitc.mapper.equipment.SreProjectTaskMapper;
import com.pcitc.service.equipment.ForApplicationService;
import com.pcitc.service.equipment.TaskCosureService;
@Service("taskCosureService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public  class TaskCosureServiceImpl implements TaskCosureService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(TaskCosureServiceImpl.class); 
	@Autowired
	private SreProjectTaskMapper sreProjectTaskMapper;
	
	
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
	
	
/**===========================================任务书已关闭==========================================*/
	
	public LayuiTableData getSreTaskClosurePage(LayuiTableParam param)throws Exception
	{
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String closeStatus = getTableParam(param, "closeStatus","");
		String setupYear = getTableParam(param, "setupYear", "");
		String topicName = getTableParam(param, "topicName", "");
		String applyDepartCode=getTableParam(param,"applyDepartCode","");
		String unitPathIds=getTableParam(param,"parentUnitPathIds","");
		//String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");
		String topicConten = getTableParam(param, "topicConten", "");
		String kjb = getTableParam(param,"str","");
		String leadUnitCode = getTableParam(param, "leadUnitCode", "");
		String unitCodes = getTableParam(param, "unitCodes", "");
		List<String>  unitCodesList=new ArrayList<String> ();
		Map map = new HashMap();
		map.put("closeStatus", closeStatus);
		map.put("topicName", topicName);
		map.put("setupYear", setupYear);
		map.put("firstApplyUser", unitPathIds);
		//map.put("parentUnitPathIds", parentUnitPathIds);
		map.put("contractNum", topicConten);
		//map.put("leadUnitCode", leadUnitCode);
		
		map.put("unitPathNames", leadUnitCode);
	    map.put("parentUnitPathNames", leadUnitCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(kjb.equals("0")) {
			map.put("unitCodes", "");
		    map.put("unitCodesList", "");
		}else {
	        if(!unitCodes.equals(""))
	        {
	        	String []arr=unitCodes.split(",");
	        	unitCodesList = java.util.Arrays.asList(arr);
	        }
	        map.put("unitCodes", unitCodes);
		    map.put("unitCodesList", unitCodesList);
		}
//		if(!applyDepartCode.equals(""))
//		{
//			applyUnitCodeStr.append(" (");
//			String arr[]=applyDepartCode.split(",");
//			for(int i=0;i<arr.length;i++)
//			{
//				if(i>0)
//				{
//					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
//				}else
//				{
//					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
//				}
//				
//			}
//			applyUnitCodeStr.append(" )");
//		}
//		
//		map.put("sqlStr", applyUnitCodeStr.toString());
		List<SreProjectTask> list = sreProjectTaskMapper.getClosedList(map);
		PageInfo<SreProjectTask> pageInfo = new PageInfo<SreProjectTask>(list);
		System.out.println(">>>>>>>>>任务书查询分页结果 "+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}

	

	

}
