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
import com.pcitc.base.expert.ZjkBookSync;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.expert.ZjkRewardSync;
import com.pcitc.mapper.expert.ZjkBaseSyncMapper;
import com.pcitc.mapper.expert.ZjkBookSyncMapper;
import com.pcitc.mapper.expert.ZjkPatentSyncMapper;
import com.pcitc.mapper.expert.ZjkRewardPunishSyncMapper;
import com.pcitc.mapper.expert.ZjkRewardSyncMapper;
import com.pcitc.service.expert.IExpertSynService;
@Service
public class ExpertSynServiceImpl implements IExpertSynService {
	
	@Autowired
	private ZjkBaseSyncMapper zjkBaseSyncMapper;
	@Autowired
	private ZjkPatentSyncMapper zjkPatentSyncMapper;
	
	@Autowired
	private ZjkRewardSyncMapper zjkRewardSyncMapper;
	@Autowired
	private ZjkBookSyncMapper zjkBookSyncMapper;
	
	@Autowired
	private ZjkRewardPunishSyncMapper zjkRewardPunishSyncMapper;
	
	
	
	
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
     * 根据ID获取外系统专利详情
	*/
	public ZjkPatentSync selectZjkPatentSync(String id) throws Exception
	{
		return zjkPatentSyncMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改外系统专利
	*/
	public Integer updateZjkPatentSync(ZjkPatentSync record)throws Exception
	{
		return zjkPatentSyncMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除外系统专利
	 */
	public int deleteZjkPatentSync(String id)throws Exception
	{
		return zjkPatentSyncMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加外系统专利
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
	  * 获取专利奖励（分页）
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
			System.out.println(">>>>>>>>>专利奖励查询分页结果 "+pageInfo.getList().size());
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
     * 根据ID获取外系统奖励
	*/
	public ZjkRewardSync selectZjkRewardSync(String id) throws Exception
	{
		return zjkRewardSyncMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改外系统奖励
	*/
	public Integer updateZjkRewardSync(ZjkRewardSync record)throws Exception
	{
		return zjkRewardSyncMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除外系统奖励
	 */
	public int deleteZjkRewardSync(String id)throws Exception
	{
		return zjkRewardSyncMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加外系统奖励
	 */
	public Integer insertZjkRewardSync(ZjkRewardSync record)throws Exception
	{
		return zjkRewardSyncMapper.insert(record);
	}
	
	public Integer insertBatchRewardSync(List<ZjkRewardSync> list)throws Exception
	{
		return zjkRewardSyncMapper.insertBatch(list);
	}
	/**
	  * 获取奖励奖励（分页）
	*/
	public LayuiTableData getZjkRewardSyncPage(LayuiTableParam param)throws Exception
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
			
			Map map=new HashMap();
			map.put("expertId", expertId);
			map.put("expertNum", expertNum);
			map.put("delStatus", delStatus);
			
			
			List<ZjkRewardSync> list = zjkRewardSyncMapper.getList(map);
			PageInfo<ZjkRewardSync> pageInfo = new PageInfo<ZjkRewardSync>(list);
			System.out.println(">>>>>>>>>奖励奖励查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	public List getZjkRewardSyncList(Map map)throws Exception
	{
		
			List<ZjkRewardSync> list = zjkRewardSyncMapper.getList(map);
		    return list;
	}
	
	
	public int deleteAllReward()throws Exception
	{
		return zjkRewardSyncMapper.deleteAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
     * 根据ID获取外论著
	*/
	public ZjkBookSync selectZjkBookSync(String id) throws Exception
	{
		return zjkBookSyncMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改外论著
	*/
	public Integer updateZjkBookSync(ZjkBookSync record)throws Exception
	{
		return zjkBookSyncMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除外论著
	 */
	public int deleteZjkBookSync(String id)throws Exception
	{
		return zjkBookSyncMapper.deleteByPrimaryKey(id);
	}
	
	
	/**
	     * 增加外论著
	 */
	public Integer insertZjkBookSync(ZjkBookSync record)throws Exception
	{
		return zjkBookSyncMapper.insert(record);
	}
	
	public Integer insertBatchBookSync(List<ZjkBookSync> list)throws Exception
	{
		return zjkBookSyncMapper.insertBatch(list);
	}
	/**
	  * 获取论著（分页）
	*/
	public LayuiTableData getZjkBookSyncPage(LayuiTableParam param)throws Exception
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
			
			Map map=new HashMap();
			map.put("expertId", expertId);
			map.put("expertNum", expertNum);
			map.put("delStatus", delStatus);
			
			
			List<ZjkBookSync> list = zjkBookSyncMapper.getList(map);
			PageInfo<ZjkBookSync> pageInfo = new PageInfo<ZjkBookSync>(list);
			System.out.println(">>>>>>>>>论著查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	public List getZjkBookSyncList(Map map)throws Exception
	{
		
			List<ZjkBookSync> list = zjkBookSyncMapper.getList(map);
		    return list;
	}
	
	
	public int deleteAllBookSync()throws Exception
	{
		return zjkBookSyncMapper.deleteAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ZjkRewardPunishSync selectZjkRewardPunishSync(String id) throws Exception
	{
		return zjkRewardPunishSyncMapper.selectByPrimaryKey(id);
	}
	
	public Integer updateZjkRewardPunishSync(ZjkRewardPunishSync record)throws Exception
	{
		return zjkRewardPunishSyncMapper.updateByPrimaryKey(record);
	}
	
	
	public int deleteZjkRewardPunishSync(String id)throws Exception
	{
		return zjkRewardPunishSyncMapper.deleteByPrimaryKey(id);
	}
	
	
	public Integer insertZjkRewardPunishSync(ZjkRewardPunishSync record)throws Exception
	{
		return zjkRewardPunishSyncMapper.insert(record);
	}
	
	public Integer insertBatchPunishSync(List<ZjkRewardPunishSync> list)throws Exception
	{
		return zjkRewardPunishSyncMapper.insertBatch(list);
	}
	public LayuiTableData getZjkRewardPunishSyncPage(LayuiTableParam param)throws Exception
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
			
			Map map=new HashMap();
			map.put("expertId", expertId);
			map.put("expertNum", expertNum);
			map.put("delStatus", delStatus);
			
			
			List<ZjkRewardPunishSync> list = zjkRewardPunishSyncMapper.getList(map);
			PageInfo<ZjkRewardPunishSync> pageInfo = new PageInfo<ZjkRewardPunishSync>(list);
			System.out.println(">>>>>>>>>论著查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	public List getZjkRewardPunishSyncList(Map map)throws Exception
	{
		
			List<ZjkRewardPunishSync> list = zjkRewardPunishSyncMapper.getList(map);
		    return list;
	}
	
	
	public int deleteAllPunishSync()throws Exception
	{
		return zjkRewardPunishSyncMapper.deleteAll();
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
