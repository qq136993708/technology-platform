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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreInformationDelivery;
import com.pcitc.base.stp.equipment.SrePlanImplement;
import com.pcitc.mapper.equipment.SreInformationDeliveryMapper;
import com.pcitc.mapper.equipment.SrePlanImplementProviderMapper;
import com.pcitc.service.equipment.PlanImplementService;
@Service("planImplementService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PlanningManagementServiceImpl implements PlanImplementService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(PlanningManagementServiceImpl.class); 
	@Autowired
	private SrePlanImplementProviderMapper srePlanningManagementMapper;
	@Autowired
	private SreInformationDeliveryMapper sreInformationDeliveryMapper;
	
	
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
	
	
	@Override
	public LayuiTableData getPlanImplementPage(LayuiTableParam param)throws Exception {
			//每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");//子id
			String parentUnitPathNames=getTableParam(param,"parentUnitPathNames","");//研究院
			String publicationType=getTableParam(param,"publicationType","");//规划类型
			String publicationTitle=getTableParam(param,"publicationTitle","");//规划标题
			String publisher=getTableParam(param,"publisher","");//发布人
			String publicationMonth=getTableParam(param,"publicationMonth","");//发布时间
			String leadUnitCode=getTableParam(param,"leadUnitCode","");//研究院
			Map map=new HashMap();
			if(leadUnitCode.equals("")) {
				map.put("levelId", parentUnitPathIds);
			}else {
				map.put("levelId", leadUnitCode);
			}
			map.put("parentUnitPathNames", parentUnitPathNames);
			map.put("publicationType", publicationType);
			map.put("publicationTitle", publicationTitle);
			map.put("publisher", publisher);
			map.put("publicationMonth", publicationMonth);
			List<SrePlanImplement> srePlanningManagement = srePlanningManagementMapper.getList(map);
			PageInfo<SrePlanImplement> pageInfo = new PageInfo<SrePlanImplement>(srePlanningManagement);
			System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
			return data;
	}


	@Override
	public Integer setPlanImplement(SrePlanImplement srePlanImplement) {
		// TODO Auto-generated method stub
		return srePlanningManagementMapper.insert(srePlanImplement);
	}


	@Override
	public SrePlanImplement selectPlanImplement(String id) {
		// TODO Auto-generated method stub
		return srePlanningManagementMapper.selectByPrimaryKey(id);
	}


	@Override
	public int deleteSrePlanImplement(String id) {
		// TODO Auto-generated method stub
		return srePlanningManagementMapper.deleteByPrimaryKey(id);
	}


	@Override
	public Integer setupdataSrePlanImplement(SrePlanImplement srePlanImplement) {
		// TODO Auto-generated method stub
		return srePlanningManagementMapper.updateByPrimaryKey(srePlanImplement);
	}

	
	/*-----------------------------信息发布---------------------*/
	
	@Override
	public LayuiTableData getInformationDeliveryPage(LayuiTableParam param)throws Exception {
			//每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");//子id
			String parentUnitPathNames=getTableParam(param,"parentUnitPathNames","");//研究院
			String informationType=getTableParam(param,"publicationType","");//规划类型
			String informationTitle=getTableParam(param,"publicationTitle","");//规划标题
			String informationPublisher=getTableParam(param,"publisher","");//发布人
			String informationMonth=getTableParam(param,"publicationMonth","");//发布时间
			String leadUnitCode=getTableParam(param,"leadUnitCode","");//研究院
			Map map=new HashMap();
			if(leadUnitCode.equals("")) {
				map.put("levelId", parentUnitPathIds);
			}else {
				map.put("levelId", leadUnitCode);
			}
			map.put("parentUnitPathNames", parentUnitPathNames);
			map.put("informationType", informationType);
			map.put("informationTitle", informationTitle);
			map.put("informationPublisher", informationPublisher);
			map.put("informationMonth", informationMonth);
			List<SreInformationDelivery> sreInformationDelivery = sreInformationDeliveryMapper.getList(map);
			PageInfo<SreInformationDelivery> pageInfo = new PageInfo<SreInformationDelivery>(sreInformationDelivery);
			System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
			return data;
	}


	@Override
	public int deleteInformationDelivery(String id) {
		// TODO Auto-generated method stub
		return sreInformationDeliveryMapper.deleteByPrimaryKey(id);
	}


	@Override
	public SreInformationDelivery selectInformationDelivery(String id) {
		// TODO Auto-generated method stub
		return sreInformationDeliveryMapper.selectByPrimaryKey(id);
	}


	@Override
	public Integer insertInformationDelivery(SreInformationDelivery sreInformationDelivery) {
		// TODO Auto-generated method stub
		return sreInformationDeliveryMapper.insert(sreInformationDelivery);
	}


	@Override
	public Integer updataInformationDelivery(SreInformationDelivery sreInformationDelivery) {
		// TODO Auto-generated method stub
		return sreInformationDeliveryMapper.updateByPrimaryKey(sreInformationDelivery);
	}
}
