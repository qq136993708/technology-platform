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
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.mapper.equipment.UnitFieldMapper;
import com.pcitc.service.equipment.UnitFieldService;
@Service("unitFieldService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UnitFieldServiceImpl implements UnitFieldService {
	private final static Logger logger = LoggerFactory.getLogger(UnitFieldServiceImpl.class);
	@Autowired
	private UnitFieldMapper unitFieldMapper;
	
	
	public UnitField selectUnitField(String id) throws Exception
	{
		return unitFieldMapper.selectByPrimaryKey(id);
	}

	public Integer updateUnitField(UnitField record)throws Exception
	{
		return unitFieldMapper.updateByPrimaryKey(record);
	}

	public int deleteUnitField(String id)throws Exception
	{
		return unitFieldMapper.deleteByPrimaryKey(id);
	}
	

	public Integer insertUnitField(UnitField record)throws Exception
	{
		return unitFieldMapper.insert(record);
	}

	
	public LayuiTableData getUnitFieldPage(LayuiTableParam param)throws Exception
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
		logger.info("================= pageNum: "+pageNum+"pageSize="+pageSize);
		Map map=new HashMap();
		map.put("name", name);
		List<UnitField> list = unitFieldMapper.getList(map);
		
		PageInfo<UnitField> pageInfo = new PageInfo<UnitField>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	public List<UnitField> getUnitNameList()throws Exception
	{
		return unitFieldMapper.getUnitNameList();
	}
	public List<UnitField> getDepartmentNameListByUnitName(Map map)throws Exception
	{
		return unitFieldMapper.getDepartmentNameListByUnitName(map);
	}
	public List<UnitField> getProfessionalNameListByUnitNameAndDept(Map map)throws Exception
	{
		return unitFieldMapper.getProfessionalNameListByUnitNameAndDept(map);
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
}