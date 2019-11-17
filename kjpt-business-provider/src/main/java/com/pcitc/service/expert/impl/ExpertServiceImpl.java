package com.pcitc.service.expert.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.mapper.expert.ZjkBaseMapper;
import com.pcitc.service.expert.IExpertService;


@Service
public class ExpertServiceImpl implements IExpertService {
	
	@Autowired
	private ZjkBaseMapper zjkBaseMapper;
	
	/**
	     * 根据ID获取专家信息详情
	*/
	public ZjkBase selectZjkBase(String id) throws Exception
	{
		return zjkBaseMapper.selectByPrimaryKey(id);
	}

	 /**
	     *修改专家信息
	*/
	public Integer updateZjkBase(ZjkBase record)throws Exception
	{
		return zjkBaseMapper.updateByPrimaryKey(record);
	}

	
	 /**
	     *根据ID删除专家信息
	 */
	public int deleteZjkBase(String id)throws Exception
	{
		return zjkBaseMapper.deleteByPrimaryKey(id);
	}
	
	/**
	     * 增加专家信息
	 */
	public Integer insertZjkBase(ZjkBase record)throws Exception
	{
		return zjkBaseMapper.insert(record);
	}
	
	
	/**
	     * 获取专家（分页）
	*/
	public LayuiTableData getZjkBasePage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String title=getTableParam(param,"name","");
			Map map=new HashMap();
			map.put("name", title);
			
			List<ZjkBase> list = zjkBaseMapper.getList(map);
			PageInfo<ZjkBase> pageInfo = new PageInfo<ZjkBase>(list);
			System.out.println(">>>>>>>>>专家查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
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
