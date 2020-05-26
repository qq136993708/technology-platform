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
import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.mapper.expert.ZjkBaseSyncMapper;
import com.pcitc.mapper.expert.ZjkPatentSyncMapper;
import com.pcitc.service.expert.IExpertSynService;
@Service
public class ExpertSynServiceImpl implements IExpertSynService {
	
	@Autowired
	private ZjkBaseSyncMapper zjkBaseSyncMapper;
	@Autowired
	private ZjkPatentSyncMapper zjkPatentSyncMapper;
	
	
	/**
     * 根据ID获取外系统专家详情
	*/
	public ZjkBaseSync selectZjkBaseSync(String id) throws Exception
	{
		return zjkBaseSyncMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改外系统专家
	*/
	public Integer updateZjkBaseSync(ZjkBaseSync record)throws Exception
	{
		return zjkBaseSyncMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除外系统专家
	 */
	public int deleteZjkBaseSync(String id)throws Exception
	{
		return zjkBaseSyncMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加外系统专家
	 */
	public Integer insertZjkBaseSync(ZjkBaseSync record)throws Exception
	{
		return zjkBaseSyncMapper.insert(record);
	}
	
	
	public Integer insertBatchZjkBaseSync(List<ZjkBaseSync> list)throws Exception
	{
		return zjkBaseSyncMapper.insertBatch(list);
	}
	
	public int deleteAllZjkSync()throws Exception
	{
		return zjkBaseSyncMapper.deleteAllZjkSync();
	}
	
	
	/**
	  * 获取专家奖励（分页）
	*/
	public LayuiTableData getZjkBaseSyncPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String delStatus=getTableParam(param,"delStatus","");
			
			Map map=new HashMap();
			map.put("delStatus", delStatus);
			
			List<ZjkBaseSync> list = zjkBaseSyncMapper.getList(map);
			PageInfo<ZjkBaseSync> pageInfo = new PageInfo<ZjkBaseSync>(list);
			System.out.println(">>>>>>>>>专家奖励查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	public List getZjkBaseSyncList(Map map)throws Exception
	{
		
			List<ZjkBaseSync> list = zjkBaseSyncMapper.getList(map);
		    return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
     * 根据ID获取外系统专家详情
	*/
	public ZjkPatentSync selectZjkPatentSync(String id) throws Exception
	{
		return zjkPatentSyncMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改外系统专家
	*/
	public Integer updateZjkPatentSync(ZjkPatentSync record)throws Exception
	{
		return zjkPatentSyncMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除外系统专家
	 */
	public int deleteZjkPatentSync(String id)throws Exception
	{
		return zjkPatentSyncMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加外系统专家
	 */
	public Integer insertZjkPatentSync(ZjkPatentSync record)throws Exception
	{
		return zjkPatentSyncMapper.insert(record);
	}
	
	public Integer insertBatchPatent(List<ZjkPatentSync> list)throws Exception
	{
		return zjkPatentSyncMapper.insertBatch(list);
	}
	/**
	  * 获取专家奖励（分页）
	*/
	public LayuiTableData getZjkPatentSyncPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String delStatus=getTableParam(param,"delStatus","");
			String expertNum=getTableParam(param,"expertNum","");
			String expertId=getTableParam(param,"expertId","");
			String patentNum=getTableParam(param,"patentNum","");
			
			Map map=new HashMap();
			map.put("expertId", expertId);
			map.put("expertNum", expertNum);
			map.put("patentNum", patentNum);
			map.put("delStatus", delStatus);
			
			
			List<ZjkPatentSync> list = zjkPatentSyncMapper.getList(map);
			PageInfo<ZjkPatentSync> pageInfo = new PageInfo<ZjkPatentSync>(list);
			System.out.println(">>>>>>>>>专家奖励查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	public List getZjkPatentSyncList(Map map)throws Exception
	{
		
			List<ZjkPatentSync> list = zjkPatentSyncMapper.getList(map);
		    return list;
	}
	
	
	public int deleteAllPatentSync()throws Exception
	{
		return zjkPatentSyncMapper.deleteAllPatentSync();
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
