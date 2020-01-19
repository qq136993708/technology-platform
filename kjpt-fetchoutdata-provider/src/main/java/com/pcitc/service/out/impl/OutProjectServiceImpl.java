package com.pcitc.service.out.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutProject;
import com.pcitc.mapper.out.OutProjectMapper;
import com.pcitc.service.out.IOutProjectService;
@Service("outProjectService")
public class OutProjectServiceImpl implements IOutProjectService {
	
	
	
	@Autowired
	private OutProjectMapper outProjectMapper;
	
	
	public List fetch(Map map)throws Exception
	{
		List<OutProject> list = outProjectMapper.fetch(map);
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
