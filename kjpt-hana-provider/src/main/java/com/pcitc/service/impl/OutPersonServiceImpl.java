package com.pcitc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.out.OutPersonVo;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.mapper.out.OutPersonVoMapper;
import com.pcitc.service.IOutPersonService;
@Service("outPersonService")
public class OutPersonServiceImpl implements IOutPersonService {

    
	@Autowired
	private OutPersonVoMapper outPersonVoMapper;
    
	public List getHanaOutPersonBaseInfoList(Map map)throws Exception
	{
		List<OutPersonVo> list = outPersonVoMapper.getHanaOutPersonVoList(map);
		
		return list;
	}
	
	public List getHanaOutPersonPatentList(Map map)throws Exception
	{
		List<OutPersonVo> list = outPersonVoMapper.getHanaOutPersonPatentList(map);
		
		return list;
	}
	
	public List getHanaOutPersonBookList(Map map)throws Exception
	{
		List<OutPersonVo> list = outPersonVoMapper.getHanaOutPersonBookList(map);
		
		return list;
	}
	
	
	
	
	
	
	
	
	public List getHanaPantentListByNum(String num)throws Exception
	{
		List<OutPersonVo> list = outPersonVoMapper.getHanaPantentListByNum(num);
		return list;
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
