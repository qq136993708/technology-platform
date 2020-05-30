package com.pcitc.service.out.impl;

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
import com.pcitc.base.expert.ZjkBookSync;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.mapper.out.OutPersonMapper;
import com.pcitc.service.out.IOutPersonService;
import com.pcitc.util.BusinessUtil;
@Service("outPersonService")
public class OutPersonServiceImpl implements IOutPersonService {




	@Autowired
	private OutPersonMapper outPersonMapper;
    
    
    
    
    
    
    
	
	/**
              * 根据ID获取外系统人员信息详情
	*/
	public OutPerson selectOutPerson(String id) throws Exception
	{
		return outPersonMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改外系统人员信息
	*/
	public Integer updateOutPerson(OutPerson record)throws Exception
	{
		return outPersonMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除外系统人员信息
	 */
	public int deleteOutPerson(String id)throws Exception
	{
		return outPersonMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加外系统人员信息
	 */
	public Integer insertOutPerson(OutPerson record)throws Exception
	{
		return outPersonMapper.insert(record);
	}
	
	
	/**
	  * 获取外系统人员（分页）
	*/
	public LayuiTableData getOutPersonPage(LayuiTableParam param)throws Exception
	{
		
		
		JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println(">>>>>>>>>getOutPersonPage参数: "+parma.toJSONString());
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String name=getTableParam(param,"name","");
			String belongUnitId=getTableParam(param,"belongUnitId","");
			String education=getTableParam(param,"education","");
			String title=getTableParam(param,"title","");
			String post=getTableParam(param,"post","");
			
			Integer beginAage=CommonUtil.getTableParamInt(param,"beginAage",18);
			Integer endAage=CommonUtil.getTableParamInt(param,"endAage",120);
			String sex=getTableParam(param,"sex","");
			String techType=getTableParam(param,"techType","");
			String isExpert=getTableParam(param,"isExpert",""); 
			String customQueryConditionStr=getTableParam(param,"customQueryConditionStr","");
			
			
			
			Map map=new HashMap();
			map.put("post", post);
			map.put("title", title);
			map.put("education", education);
			map.put("belongUnitId", belongUnitId);
			map.put("name", name);
			map.put("beginAage", beginAage);
			map.put("endAage", endAage);
			map.put("sex", sex);
			map.put("techType", techType);
			map.put("isExpert", isExpert);
			String condition=BusinessUtil.getSqlQueryCondition(customQueryConditionStr);
			map.put("condition", condition);
			
			List<OutPerson> list = outPersonMapper.getList(map);
			PageInfo<OutPerson> pageInfo = new PageInfo<OutPerson>(list);
			System.out.println(">>>>>>>>>外系统人员查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	
	public List getOutPersonList(Map map)throws Exception
	{
		List<OutPerson> list = outPersonMapper.getList(map);
		
		return list;
	}
	
    
    
	public long getOutPersonCount(Map map)throws Exception
	{
		return outPersonMapper.getCount(map);
		
	}
    
    
    
    
    
	public Integer insertBatchOutPerson(List<OutPerson> list)throws Exception
	{
		return outPersonMapper.insertBatch(list);
	}
    
    
    
    
	public int deleteAllOutPerson()throws Exception
	{
		return outPersonMapper.deleteAll();
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
