package com.pcitc.service.out.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutProject;
import com.pcitc.mapper.out.OutProjectMapper;
import com.pcitc.service.out.IOutProjectService;
@Service("outProjectService")
public class OutProjectServiceImpl implements IOutProjectService {
	
	
	
	@Autowired
	private OutProjectMapper outProjectMapper;
	
	
	
	/**
     * 根据ID获取专家奖励信息详情
	*/
	public OutProject selectOutProject(String id) throws Exception
	{
		return outProjectMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改专家奖励信息
	*/
	public Integer updateOutProject(OutProject record)throws Exception
	{
		return outProjectMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除专家奖励信息
	 */
	public int deleteOutProject(String id)throws Exception
	{
		return outProjectMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加专家奖励信息
	 */
	public Integer insertOutProject(OutProject record)throws Exception
	{
		return outProjectMapper.insert(record);
	}
	
	
	/**
	  * 获取专家奖励（分页）
	*/
	public LayuiTableData getOutProjectPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String rewarkLevel=getTableParam(param,"rewarkLevel","");
			String sourceType=getTableParam(param,"sourceType","");
			String delStatus=getTableParam(param,"delStatus","");
			String outSystemId=getTableParam(param,"outSystemId","");
			String expertId=getTableParam(param,"expertId","");
			Map map=new HashMap();
			map.put("rewarkLevel", rewarkLevel);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			
			
			
			List<OutProject> list = outProjectMapper.getList(map);
			PageInfo<OutProject> pageInfo = new PageInfo<OutProject>(list);
			System.out.println(">>>>>>>>>专家奖励查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	
	public List getOutProjectList(Map map)throws Exception
	{
		List<OutProject> list = outProjectMapper.getList(map);
		
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
