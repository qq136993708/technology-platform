package com.pcitc.service.expert.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkProject;
import com.pcitc.base.expert.ZjkReward;
import com.pcitc.mapper.expert.ZjkAchievementMapper;
import com.pcitc.mapper.expert.ZjkBaseMapper;
import com.pcitc.mapper.expert.ZjkPatentMapper;
import com.pcitc.mapper.expert.ZjkProjectMapper;
import com.pcitc.mapper.expert.ZjkRewardMapper;
import com.pcitc.service.expert.IExpertService;

import io.swagger.annotations.ApiImplicitParam;


@Service
public class ExpertServiceImpl implements IExpertService {
	
	@Autowired
	private ZjkBaseMapper zjkBaseMapper;
	@Autowired
	private ZjkAchievementMapper zjkAchievementMapper;
	@Autowired
	private ZjkPatentMapper zjkPatentMapper;
	@Autowired
	private ZjkProjectMapper zjkProjectMapper;
	@Autowired
	private ZjkRewardMapper zjkRewardMapper;
	
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
		
		
		
		 zjkAchievementMapper.deleteZjkAchievementByExpertId(record.getId());
		 String achievementStr=record.getZjkAchievementJsonList();
		 String patentStr=record.getZjkPatentJsonList();
		 String projectStr=record.getZjkProjectJsonList();
		 String rewardStr=record.getZjkRewardJsonList();
		 //外系统ID#成果名称# 申请单位#申请年度#成果类别$外系统ID#成果名称#申请单位#申请年度#成果类别 
		 if(achievementStr!=null && !achievementStr.equals(""))
		 {
			 String arr[]=achievementStr.split("\\$");
			 if(arr!=null)
			 {
				 for(int i=0;i<arr.length;i++)
				 {
					String linestr= arr[i];
					
					if(linestr!=null)
					 {
						 ZjkAchievement zjkAchievement=new ZjkAchievement();
						 String array[]=linestr.split("#");
						 if(array!=null)
						 {
							 String outSystemId= array[0];
							 String achieveName= array[1];
							 String applyUnit= array[2];
							 String applyYear= array[3];
							 String achieveType= array[4];
							 zjkAchievement.setOutSystemId(outSystemId);
							 zjkAchievement.setApplyYear(applyYear);
							 zjkAchievement.setAchieveName(achieveName);
							 zjkAchievement.setApplyUnit(applyUnit);
							 zjkAchievement.setAchieveType(achieveType);
							 zjkAchievement.setExpertId(record.getId());
							 zjkAchievement.setDelStatus(Constant.DEL_STATUS_NOT);
							 if(!outSystemId.equals(""))
							 {
								 zjkAchievement.setSourceType(Constant.SOURCE_TYPE_OUTER);
							 }else
							 {
								 zjkAchievement.setSourceType(Constant.SOURCE_TYPE_LOCATION);
							 }
							 zjkAchievementMapper.insert(zjkAchievement);
						 }
						 
					 }
				 }
			 }
		 }
		 
		return zjkBaseMapper.updateByPrimaryKey(record);
	}

	
	 /**
                  *根据ID物理删除专家信息
     */
	public int deleteZjkBase(String id)throws Exception
	{
		zjkPatentMapper.deleteZjkPatentByExpertId(id);
		zjkRewardMapper.deleteZjkRewardByExpertId(id);
		zjkProjectMapper.deleteZjkProjectByExpertId(id);
		zjkAchievementMapper.deleteZjkAchievementByExpertId(id);
		return zjkBaseMapper.deleteByPrimaryKey(id);
	}
	
	
	
	 /**
	     *根据ID逻辑删除专家信息
	 */
	public int deleteLogicZjkBase(String id)throws Exception
	{
		ZjkBase sjkBase=zjkBaseMapper.selectByPrimaryKey(id);
		sjkBase.setDelStatus("1");
		
		zjkPatentMapper.deleteLogicZjkPatentByExpertId(id);
		zjkRewardMapper.deleteLogicZjkRewardByExpertId(id);
		zjkProjectMapper.deleteLogicZjkProjectByExpertId(id);
		zjkAchievementMapper.deleteLogicZjkAchievementByExpertId(id);
		
		return zjkBaseMapper.updateByPrimaryKey(sjkBase);
	}
	
	/**
	     * 增加专家信息
	 */
	public Integer insertZjkBase(ZjkBase record)throws Exception
	{
		
		 String achievementStr=record.getZjkAchievementJsonList();
		 String patentStr=record.getZjkPatentJsonList();
		 String projectStr=record.getZjkProjectJsonList();
		 String rewardStr=record.getZjkRewardJsonList();
		 //外系统ID#成果名称# 申请单位#申请年度#成果类别$外系统ID#成果名称#申请单位#申请年度#成果类别 
		 if(achievementStr!=null && !achievementStr.equals(""))
		 {
			 String arr[]=achievementStr.split("\\$");
			 if(arr!=null)
			 {
				 for(int i=0;i<arr.length;i++)
				 {
					String linestr= arr[i];
					
					if(linestr!=null)
					 {
						 ZjkAchievement zjkAchievement=new ZjkAchievement();
						 String array[]=linestr.split("#");
						 if(array!=null)
						 {
							 String outSystemId= array[0];
							 String achieveName= array[1];
							 String applyUnit= array[2];
							 String applyYear= array[3];
							 String achieveType= array[4];
							 zjkAchievement.setOutSystemId(outSystemId);
							 zjkAchievement.setApplyYear(applyYear);
							 zjkAchievement.setAchieveName(achieveName);
							 zjkAchievement.setApplyUnit(applyUnit);
							 zjkAchievement.setAchieveType(achieveType);
							 zjkAchievement.setExpertId(record.getId());
							 zjkAchievement.setDelStatus(Constant.DEL_STATUS_NOT);
							 if(!outSystemId.equals(""))
							 {
								 zjkAchievement.setSourceType(Constant.SOURCE_TYPE_OUTER);
							 }else
							 {
								 zjkAchievement.setSourceType(Constant.SOURCE_TYPE_LOCATION);
							 }
							 zjkAchievementMapper.insert(zjkAchievement);
						 }
						 
					 }
				 }
			 }
		 }
		 
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
			String name=getTableParam(param,"name","");
			String sourceType=getTableParam(param,"sourceType","");
			String delStatus=getTableParam(param,"delStatus","");
			String outSystemId=getTableParam(param,"outSystemId","");
			String belongUnit=getTableParam(param,"belongUnit","");
			String useStatus=getTableParam(param,"useStatus","");
			String post=getTableParam(param,"post","");
			String title=getTableParam(param,"title","");
			String technicalField=getTableParam(param,"technicalField","");
	    	
			Map map=new HashMap();
			map.put("name", name);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("belongUnit", belongUnit);
			map.put("useStatus", useStatus);
			map.put("post", post);
			map.put("title", title);
			map.put("technicalField", technicalField);
			
			List<ZjkBase> list = zjkBaseMapper.getList(map);
			PageInfo<ZjkBase> pageInfo = new PageInfo<ZjkBase>(list);
			System.out.println(">>>>>>>>>专家查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	
	
	
	public List getZjkBaseList(Map map)throws Exception
	{
		/*
		 * String name=getTableParam(param,"name",""); String
		 * sourceType=getTableParam(param,"sourceType",""); String
		 * delStatus=getTableParam(param,"delStatus",""); String
		 * outSystemId=getTableParam(param,"outSystemId",""); String
		 * belongUnit=getTableParam(param,"belongUnit",""); String
		 * useStatus=getTableParam(param,"useStatus",""); String
		 * post=getTableParam(param,"post",""); String
		 * title=getTableParam(param,"title",""); String
		 * technicalField=getTableParam(param,"technicalField","");
		 * 
		 * Map map=new HashMap(); map.put("name", name); map.put("sourceType",
		 * sourceType); map.put("delStatus", delStatus); map.put("outSystemId",
		 * outSystemId); map.put("belongUnit", belongUnit); map.put("useStatus",
		 * useStatus); map.put("post", post); map.put("title", title);
		 * map.put("technicalField", technicalField);
		 */
		
		List<ZjkBase> list = zjkBaseMapper.getList(map);
		System.out.println(">>>>>>>>>专家查询分页结果 "+list.size());
		
	    return list;
	}
	
	
	
	
	/**
	     * 根据ID获取专家项目信息详情
	*/
	public ZjkProject selectZjkProject(String id) throws Exception
	{
		return zjkProjectMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改专家项目信息
	*/
	public Integer updateZjkProject(ZjkProject record)throws Exception
	{
		return zjkProjectMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除专家项目信息
	 */
	public int deleteZjkProject(String id)throws Exception
	{
		return zjkProjectMapper.deleteByPrimaryKey(id);
	}
	
	public int deleteLogicZjkProjectById(String id)throws Exception
	{
		return zjkProjectMapper.deleteLogicZjkProjectById(id);
	}
	
	
	/**
	     * 增加专家项目信息
	 */
	public Integer insertZjkProject(ZjkProject record)throws Exception
	{
		return zjkProjectMapper.insert(record);
	}
	
	
	/**
	  * 获取专家项目（分页）
	*/
	public LayuiTableData getZjkProjectPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String projectName=getTableParam(param,"projectName","");
			String sourceType=getTableParam(param,"sourceType","");
			String delStatus=getTableParam(param,"delStatus","");
			String outSystemId=getTableParam(param,"outSystemId","");
			Map map=new HashMap();
			map.put("projectName", projectName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			
			
			List<ZjkProject> list = zjkProjectMapper.getList(map);
			PageInfo<ZjkProject> pageInfo = new PageInfo<ZjkProject>(list);
			System.out.println(">>>>>>>>>专家项目查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
		
		
		
	
	
	
	
	
	
	
	
	
	

	/**
	     * 根据ID获取专家成果信息详情
	*/
	public ZjkAchievement selectZjkAchievement(String id) throws Exception
	{
		return zjkAchievementMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改专家成果信息
	*/
	public Integer updateZjkAchievement(ZjkAchievement record)throws Exception
	{
		return zjkAchievementMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除专家成果信息
	 */
	public int deleteZjkAchievement(String id)throws Exception
	{
		return zjkAchievementMapper.deleteByPrimaryKey(id);
	}
	public int deleteLogicZjkAchievementById(String id)throws Exception
	{
		return zjkAchievementMapper.deleteLogicZjkAchievementById(id);
	}
	
	
	/**
	     * 增加专家成果信息
	 */
	public Integer insertZjkAchievement(ZjkAchievement record)throws Exception
	{
		return zjkAchievementMapper.insert(record);
	}
	
	
	/**
	  * 获取专家成果（分页）
	*/
	public LayuiTableData getZjkAchievementPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String achieveName=getTableParam(param,"achieveName","");
			String sourceType=getTableParam(param,"sourceType","");
			String delStatus=getTableParam(param,"delStatus","");
			String outSystemId=getTableParam(param,"outSystemId","");
			Map map=new HashMap();
			map.put("achieveName", achieveName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			
			List<ZjkAchievement> list = zjkAchievementMapper.getList(map);
			PageInfo<ZjkAchievement> pageInfo = new PageInfo<ZjkAchievement>(list);
			System.out.println(">>>>>>>>>专家成果查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
		
		
		
	
	
	
	
	
	
	
	
	

	

	/**
	     * 根据ID获取专家专利信息详情
	*/
	public ZjkPatent selectZjkPatent(String id) throws Exception
	{
		return zjkPatentMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改专家专利信息
	*/
	public Integer updateZjkPatent(ZjkPatent record)throws Exception
	{
		return zjkPatentMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除专家专利信息
	 */
	public int deleteZjkPatent(String id)throws Exception
	{
		return zjkPatentMapper.deleteByPrimaryKey(id);
	}
	public int deleteLogicZjkPatentById(String id)throws Exception
	{
		return zjkPatentMapper.deleteLogicZjkPatentById(id);
	}
	/**
	     * 增加专家专利信息
	 */
	public Integer insertZjkPatent(ZjkPatent record)throws Exception
	{
		return zjkPatentMapper.insert(record);
	}
	
	
	/**
	  * 获取专家专利（分页）
	*/
	public LayuiTableData getZjkPatentPage(LayuiTableParam param)throws Exception
	{
		
	        //每页显示条数
			int pageSize = param.getLimit();
			//从第多少条开始
			int pageStart = (param.getPage()-1)*pageSize;
			//当前是第几页
			int pageNum = pageStart/pageSize + 1;
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNum, pageSize);
			String patentName=getTableParam(param,"patentName","");
			String sourceType=getTableParam(param,"sourceType","");
			String delStatus=getTableParam(param,"delStatus","");
			String outSystemId=getTableParam(param,"outSystemId","");
			Map map=new HashMap();
			map.put("patentName", patentName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			
			List<ZjkPatent> list = zjkPatentMapper.getList(map);
			PageInfo<ZjkPatent> pageInfo = new PageInfo<ZjkPatent>(list);
			System.out.println(">>>>>>>>>专家专利查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
		
		
		
	
	
	
	
	
	
	/**
     * 根据ID获取专家奖励信息详情
	*/
	public ZjkReward selectZjkReward(String id) throws Exception
	{
		return zjkRewardMapper.selectByPrimaryKey(id);
	}
	
	 /**
	     *修改专家奖励信息
	*/
	public Integer updateZjkReward(ZjkReward record)throws Exception
	{
		return zjkRewardMapper.updateByPrimaryKey(record);
	}
	
	
	 /**
	     *根据ID删除专家奖励信息
	 */
	public int deleteZjkReward(String id)throws Exception
	{
		return zjkRewardMapper.deleteByPrimaryKey(id);
	}
	
	
	 /**
     *根据ID逻辑删除专家奖励信息
    */
	public int deleteLogicZjkReward(String id)throws Exception
	{
		return zjkRewardMapper.deleteLogicZjkRewardById(id);
	}
	/**
	     * 增加专家奖励信息
	 */
	public Integer insertZjkReward(ZjkReward record)throws Exception
	{
		return zjkRewardMapper.insert(record);
	}
	
	
	/**
	  * 获取专家奖励（分页）
	*/
	public LayuiTableData getZjkRewardPage(LayuiTableParam param)throws Exception
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
			Map map=new HashMap();
			map.put("rewarkLevel", rewarkLevel);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			
			List<ZjkReward> list = zjkRewardMapper.getList(map);
			PageInfo<ZjkReward> pageInfo = new PageInfo<ZjkReward>(list);
			System.out.println(">>>>>>>>>专家奖励查询分页结果 "+pageInfo.getList().size());
			
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
