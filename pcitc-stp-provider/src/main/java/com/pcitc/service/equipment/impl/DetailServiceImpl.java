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
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.mapper.equipment.SreDetailMapper;
import com.pcitc.service.equipment.DetailService;
@Service("detailService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class DetailServiceImpl implements DetailService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(DetailServiceImpl.class); 
	@Autowired
	private SreDetailMapper detailMapper;
	
	
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
	
	
	public LayuiTableData getDetailPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String equipmentName=getTableParam(param,"equipmentName","");
		String equipmentType=getTableParam(param,"equipmentType","");
		String equipmentId=getTableParam(param,"equipmentId","");
		String equipmentPrice=getTableParam(param,"equipmentPrice","");
		String equipmenNumber=getTableParam(param,"equipmenNumber","");
		String declareUnit=getTableParam(param,"declareUnit","");
		
		String declareDepartment=getTableParam(param,"declareDepartment","");
		String declarePeople=getTableParam(param,"declarePeople","");
		String declareTime=getTableParam(param,"declareTime","");
		String assetNumber=getTableParam(param,"assetNumber","");
		String configure=getTableParam(param,"configure","");
		String measuringUnit=getTableParam(param,"measuringUnit","");
		
		String assetsClassification=getTableParam(param,"assetsClassification","");
		String nationality=getTableParam(param,"nationality","");
		String placeUse=getTableParam(param,"placeUse","");
		String placePeople=getTableParam(param,"placePeople","");
		String receivePeople=getTableParam(param,"receivePeople","");

		
		Map map=new HashMap();
		map.put("equipmentName", equipmentName);
		map.put("equipmentType", equipmentType);
		map.put("equipmentId", equipmentId);
		map.put("equipmentPrice", equipmentPrice);
		map.put("equipmenNumber", equipmenNumber);
		map.put("declareUnit", declareUnit);
		map.put("declareDepartment", declareDepartment);
		map.put("declarePeople", declarePeople);
		map.put("declareTime", declareTime);
		map.put("assetNumber", assetNumber);
		map.put("configure", configure);
		map.put("measuringUnit", measuringUnit);
		map.put("assetsClassification", assetsClassification);
		map.put("nationality", nationality);
		map.put("placeUse", placeUse);
		map.put("placePeople", placePeople);
		map.put("receivePeople", receivePeople);
	

		
		List<SreDetail> list = detailMapper.getList(map);
		PageInfo<SreDetail> pageInfo = new PageInfo<SreDetail>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}


	@Override
	public Integer insertDetail(SreDetail sreDetail) {
		// TODO Auto-generated method stub
		return detailMapper.insert(sreDetail);
	}


	@Override
	public Integer insertForApplication(SreDetail sreDetail) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LayuiTableData getForApplicationView(LayuiTableParam param) {
		
			
			//每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String configure=getTableParam(param,"equipmentIds","");
			
			Map map=new HashMap();
			map.put("configure", configure);
		
			
			List<SreDetail> list = detailMapper.getList(map);
			PageInfo<SreDetail> pageInfo = new PageInfo<SreDetail>(list);
			System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
		}

	
	//删除转资绑定装备
	@Override
	public Integer deleteDetail(String id) {
		
		return detailMapper.deleteByPrimaryKey(id);
	}
	
	
}
