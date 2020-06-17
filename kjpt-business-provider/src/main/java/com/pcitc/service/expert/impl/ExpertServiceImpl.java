package com.pcitc.service.expert.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.expert.ZjkProject;
import com.pcitc.base.expert.ZjkReward;
import com.pcitc.base.expert.ZjkRewardPunish;
import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.expert.ZjkAchievementMapper;
import com.pcitc.mapper.expert.ZjkBaseMapper;
import com.pcitc.mapper.expert.ZjkPatentMapper;
import com.pcitc.mapper.expert.ZjkPatentSyncMapper;
import com.pcitc.mapper.expert.ZjkProjectMapper;
import com.pcitc.mapper.expert.ZjkRewardMapper;
import com.pcitc.mapper.expert.ZjkRewardPunishMapper;
import com.pcitc.mapper.expert.ZjkRewardPunishSyncMapper;
import com.pcitc.mapper.out.OutPersonMapper;
import com.pcitc.mapper.techFamily.TechFamilyMapper;
import com.pcitc.service.expert.IExpertService;
import com.pcitc.util.BusinessUtil;


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
	@Autowired
    private TechFamilyMapper techFamilyMapper;
	@Autowired
    private OutPersonMapper outPersonMapper;
	@Autowired
    private ZjkRewardPunishMapper zjkRewardPunishMapper;
	
	@Autowired
    private ZjkPatentSyncMapper zjkPatentSyncMapper;
	@Autowired
    private ZjkRewardPunishSyncMapper zjkRewardPunishSyncMapper;
	
	
	
	
	

	/**
	     * 根据ID获取专家信息详情
	*/
	public ZjkBase selectZjkBase(String id) throws Exception
	{
		
		ZjkBase zjkBase= zjkBaseMapper.selectByPrimaryKey(id);
		return zjkBase;
	}
	
	
	public ZjkBase getZjkBaseByNum(String num) throws Exception
	{
		
		ZjkBase zjkBase= zjkBaseMapper.getZjkBaseByNum(num);
		return zjkBase;
	}
	
	
	  

	 /**
	     *修改专家信息
	*/
	public Integer updateZjkBase(ZjkBase record)throws Exception
	{
		 
		 
		 
		   String technicalFieldName="";
			String codes=record.getTechnicalField();
			if (!codes.equals("")) 
			{
				String chkbox[] = codes.split(",");
				if (chkbox != null && chkbox.length > 0) 
				{
					List<String> list = Arrays.asList(chkbox);
					List<TechFamily> tempList= techFamilyMapper.getTechFamilyListByCodes(list);
					if (tempList!=null && tempList.size()>0) 
					{
						StringBuffer sb=new StringBuffer();
						for(int i=0;i<tempList.size();i++)
						{
							TechFamily techFamily=tempList.get(i);
							String str=techFamily.getTypeName();
							if(i>0)
							{
								sb.append(",");
							}
							sb.append(str);
						}
						technicalFieldName=sb.toString();
					}
					
				}
			}
			record.setTechnicalFieldName(technicalFieldName);
			
			
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
		
		
		String technicalFieldName="";
		String codes=record.getTechnicalField();
		if (!codes.equals("")) 
		{
			String chkbox[] = codes.split(",");
			if (chkbox != null && chkbox.length > 0) 
			{
				List<String> list = Arrays.asList(chkbox);
				List<TechFamily> tempList= techFamilyMapper.getTechFamilyListByCodes(list);
				if (tempList!=null && tempList.size()>0) 
				{
					StringBuffer sb=new StringBuffer();
					for(int i=0;i<tempList.size();i++)
					{
						TechFamily techFamily=tempList.get(i);
						String str=techFamily.getTypeName();
						if(i>0)
						{
							sb.append(",");
						}
						sb.append(str);
					}
					technicalFieldName=sb.toString();
				}
				
			}
		}
		record.setTechnicalFieldName(technicalFieldName);
		return zjkBaseMapper.insert(record);
	}
	
	
	
	//增加专家相关的信息
	public void addRealtionInfo(ZjkBase record)throws Exception
	{
		 String achievementStr=record.getZjkAchievementJsonList();
		 String patentStr=record.getZjkPatentJsonList();
		 String projectStr=record.getZjkProjectJsonList();
		 String rewardStr=record.getZjkRewardJsonList();
		 System.out.println(">>>>>>>>>>成果信息"+achievementStr);
		 System.out.println(">>>>>>>>>>专利信息"+patentStr);
		 System.out.println(">>>>>>>>>>项目信息"+projectStr);
		 System.out.println(">>>>>>>>>>奖励信息"+rewardStr);
		 
		 //成果
		 List<ZjkAchievement> achievementList = JSONObject.parseArray(achievementStr, ZjkAchievement.class);
		 if(achievementList!=null)
		 {
			 for(int i=0;i<achievementList.size();i++)
			 {
				 ZjkAchievement zjkAchievement= achievementList.get(i);
				 zjkAchievement.setDelStatus(Constant.DEL_STATUS_NOT);
				 zjkAchievement.setExpertId(record.getId());
				 String outSystemId=zjkAchievement.getOutSystemId();
				 zjkAchievement.setCreateTime(new Date());
				 String dateid = UUID.randomUUID().toString().replaceAll("-", "");
				 zjkAchievement.setId(dateid);
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
		 
		 //奖励
		 List<ZjkReward> rewardList = JSONObject.parseArray(rewardStr, ZjkReward.class);
		 if(rewardList!=null)
		 {
			 for(int i=0;i<rewardList.size();i++)
			 {
				 ZjkReward zjkReward= rewardList.get(i);
				 zjkReward.setDelStatus(Constant.DEL_STATUS_NOT);
				 zjkReward.setExpertId(record.getId());
				 String outSystemId=zjkReward.getOutSystemId();
				 if(!outSystemId.equals(""))
				 {
					 zjkReward.setSourceType(Constant.SOURCE_TYPE_OUTER);
				 }else
				 {
					 zjkReward.setSourceType(Constant.SOURCE_TYPE_LOCATION);
				 }
				 zjkReward.setCreateTime(new Date());
				 
				 String dateid = UUID.randomUUID().toString().replaceAll("-", "");
				 zjkReward.setId(dateid);
				 String datestr= zjkReward.getAwardingTimeStr();
				 Date awardingTime=DateUtil.strToDate(datestr, DateUtil.FMT_DD);
				 zjkReward.setAwardingTime(awardingTime);
				 
				 
				 zjkRewardMapper.insert(zjkReward);
				 
			 }
		 }
		 
		 //项目
		 List<ZjkProject> projectList = JSONObject.parseArray(projectStr, ZjkProject.class);
		 if(projectList!=null)
		 {
			 for(int i=0;i<projectList.size();i++)
			 {
				 ZjkProject zjkProject= projectList.get(i);
				 zjkProject.setDelStatus(Constant.DEL_STATUS_NOT);
				 zjkProject.setExpertId(record.getId());
				 String outSystemId=zjkProject.getOutSystemId();
				 if(!outSystemId.equals(""))
				 {
					 zjkProject.setSourceType(Constant.SOURCE_TYPE_OUTER);
				 }else
				 {
					 zjkProject.setSourceType(Constant.SOURCE_TYPE_LOCATION);
				 }
				 zjkProject.setCreateTime(new Date());
				 String dateid = UUID.randomUUID().toString().replaceAll("-", "");
				 zjkProject.setId(dateid);
				 
				 zjkProjectMapper.insert(zjkProject);
				 
			 }
		 }
		 
		 //专利
		 List<ZjkPatent> patentList = JSONObject.parseArray(patentStr, ZjkPatent.class);
		 if(patentList!=null)
		 {
			 for(int i=0;i<patentList.size();i++)
			 {
				 ZjkPatent patent= patentList.get(i);
				 patent.setDelStatus(Constant.DEL_STATUS_NOT);
				 patent.setExpertId(record.getId());
				 String outSystemId=patent.getOutSystemId();
				 if(!outSystemId.equals(""))
				 {
					 patent.setSourceType(Constant.SOURCE_TYPE_OUTER);
				 }else
				 {
					 patent.setSourceType(Constant.SOURCE_TYPE_LOCATION);
				 }
				 patent.setCreateTime(new Date());
				 
				 String datestr= patent.getGetPatentTimeStr();
				 Date getPatentTime=DateUtil.strToDate(datestr, DateUtil.FMT_DD);
				 patent.setGetPatentTime(getPatentTime);
				 
				 String dateid = UUID.randomUUID().toString().replaceAll("-", "");
				 patent.setId(dateid);
				 zjkPatentMapper.insert(patent);
				 
			 }
		 }
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
			String sex=getTableParam(param,"sex","");
			String education=getTableParam(param,"education","");
			String technicalFieldIndex=getTableParam(param,"technicalFieldIndex","");
			String technicalFieldName=getTableParam(param,"technicalFieldName","");
			String groupType=getTableParam(param,"groupType","");
			String childUnitIds=getTableParam(param,"childUnitIds","");
			String secretLevel=getTableParam(param,"secretLevel","");
			String userSecretLevel=getTableParam(param,"userSecretLevel","");
			String createUnitId=getTableParam(param,"createUnitId","");
			String createUnitName=getTableParam(param,"createUnitName","");
			String expertType=getTableParam(param,"expertType","");
			String expertTypes=getTableParam(param,"expertTypes","");
			String knowledgeScope=getTableParam(param,"knowledgeScope","");
			String customQueryConditionStr=getTableParam(param,"customQueryConditionStr","");
			String orderBySql=getTableParam(param,"orderBySql","");
			
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
			map.put("sex", sex);
			map.put("groupType", groupType);
			map.put("education", education);
			map.put("technicalFieldIndex", technicalFieldIndex);
			map.put("technicalFieldName", technicalFieldName);
			map.put("childUnitIds", childUnitIds);
			map.put("secretLevel", secretLevel);
			map.put("userSecretLevel", userSecretLevel);
			map.put("createUnitId", createUnitId);
			map.put("createUnitName", createUnitName);
			map.put("expertType", expertType);
			map.put("expertTypes", expertTypes);
			map.put("knowledgeScope", knowledgeScope);
			map.put("orderBySql", orderBySql);

			String condition=BusinessUtil.getSqlQueryCondition(customQueryConditionStr);
			map.put("condition", condition);
			
			JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(map));
			System.out.println(">>>>>>>>>专家查询参数:  "+obj.toString());
			
			List<ZjkBase> list = zjkBaseMapper.getList(map);
			PageInfo<ZjkBase> pageInfo = new PageInfo<ZjkBase>(list);
			System.out.println(">>>>>>>>>专家查询分页结果:  "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	
	
	
	public List getZjkBaseList(Map map)throws Exception
	{
		String customQueryConditionStr=(String)map.get("customQueryConditionStr");
		if(customQueryConditionStr!=null)
		{
			String condition=BusinessUtil.getSqlQueryCondition(customQueryConditionStr);
			map.put("condition", condition);
		}
		
		List<ZjkBase> list = zjkBaseMapper.getList(map);
		System.out.println(">>>>>>>>>专家查询结果 "+list.size());
	    return list;
	}
	
	
	
	
	public Integer outPersonToZjkBase(Map map)throws Exception
	{
		String groups=(String)map.get("groups");
		String ids=(String)map.get("ids");
		String userId=(String)map.get("userId");
		String arr[]=ids.split(",");
		int count=0;
		if(arr!=null)
		{
			for(int i=0;i<arr.length;i++)
			{
				String id=arr[i];
				OutPerson outPerson=outPersonMapper.selectByPrimaryKey(id);
				ZjkBase zjkBase = new ZjkBase();
				zjkBase.setOutSystemId(outPerson.getUserNo());
				zjkBase.setName(outPerson.getName());
				zjkBase.setEmail(outPerson.getEmail());
				zjkBase.setTitle(outPerson.getTitle());
				zjkBase.setHeadPic(outPerson.getHeadPic());
				zjkBase.setPost(outPerson.getPost());
				zjkBase.setCreateTime(new Date());
				zjkBase.setSex(outPerson.getSex());
				zjkBase.setBrief(outPerson.getBirthYear());
				zjkBase.setEducation(outPerson.getEducation());
				zjkBase.setBelongUnit(outPerson.getBelongUnitId());
				zjkBase.setBelongUnitName(outPerson.getBelongUnitName());
				zjkBase.setTechnicalField(outPerson.getTechType());
				zjkBase.setTechnicalFieldName(outPerson.getTechTypeName());
				zjkBase.setDelStatus(Constant.DEL_STATUS_NOT);
				zjkBase.setSourceType(Constant.SOURCE_TYPE_OUTER);//数据来源（1本系统，2外系统）
				zjkBase.setSecretLevel(Constant.INFO_SECRET_LEVEL_PUBLIC);
				String dateid = UUID.randomUUID().toString().replaceAll("-", "");
				zjkBase.setId(dateid);
				zjkBase.setGroupType(groups);
				zjkBase.setCreateUser(userId);
				zjkBase.setNum(outPerson.getUserNo());//人才编号-通过身份证从人事库取,如果没有，生成8位随机数
				zjkBaseMapper.insert(zjkBase);
				outPerson.setIsExpert("1");
				outPersonMapper.updateByPrimaryKey(outPerson);
				
				//同步相关专利
				Map mapv=new HashMap();
				mapv.put("expertNum", outPerson.getUserNo());
				List<ZjkPatentSync> list=zjkPatentSyncMapper.getList(mapv);
				if(list!=null)
				{
					for(int j=0;j<list.size();j++)
					{
						ZjkPatentSync sync=list.get(j);
						ZjkPatent zjkPatent=new ZjkPatent();
						zjkPatent.setExpertId(dateid);
						zjkPatent.setExpertNum(outPerson.getUserNo());
						zjkPatent.setCreateTime(new Date());
						zjkPatent.setDescribe(sync.getNotes());
						zjkPatent.setGetPatentTime(sync.getPatentTime());
						String dateidv = UUID.randomUUID().toString().replaceAll("-", "");
						zjkPatent.setId(dateidv);
						zjkPatent.setPatentName(sync.getPatentName());
						zjkPatent.setPatentNo(sync.getPatentNum());
						zjkPatent.setPatentType(sync.getPatentType());
						zjkPatentMapper.insert(zjkPatent);
					}
				}
				
				
				
				//同步相关奖惩
				Map mapt=new HashMap();
				mapt.put("expertNum", outPerson.getUserNo());
				List<ZjkRewardPunishSync> list2=zjkRewardPunishSyncMapper.getList(mapt);
				if(list2!=null)
				{
					for(int j=0;j<list2.size();j++)
					{
						ZjkRewardPunishSync sync=list2.get(j);
						ZjkRewardPunish punish=new ZjkRewardPunish();
						punish.setExpertId(dateid);
						punish.setExpertNum(outPerson.getUserNo());
						punish.setCreateTime(new Date());
						String dateidv = UUID.randomUUID().toString().replaceAll("-", "");
						punish.setId(dateidv);
						punish.setNotes(sync.getNotes());
						punish.setApproveDate(sync.getApproveDate());
						punish.setTitle(sync.getTitle());
						punish.setRewardType(sync.getRewardType());
						punish.setRewardPunishType(sync.getRewardPunishType());
						punish.setRewardPunishLevel(sync.getRewardPunishLevel());
						punish.setApproveUnit(sync.getApproveUnit());
						punish.setRewardPunishLevelCode(sync.getRewardPunishLevelCode());
						punish.setRewardPunishTypeCode(sync.getRewardPunishTypeCode());
						punish.setRewardTypeCode(sync.getRewardTypeCode());
						zjkRewardPunishMapper.insert(punish);
					}
				}
				
				
				
				
				//同步相关奖惩
				Map maptt=new HashMap();
				maptt.put("expertNum", outPerson.getUserNo());
				List<ZjkRewardPunishSync> list3=zjkRewardPunishSyncMapper.getList(maptt);
				if(list3!=null)
				{
					for(int j=0;j<list3.size();j++)
					{
						ZjkRewardPunishSync sync=list3.get(j);
						ZjkReward reward=new ZjkReward();
						reward.setExpertId(dateid);
						reward.setCreateTime(new Date());
						String dateidv = UUID.randomUUID().toString().replaceAll("-", "");
						reward.setId(dateidv);
						String notes=sync.getTitle()+" ,"+sync.getRewardType()+","+sync.getRewardPunishLevel()+" "+sync.getNotes();
						reward.setNotes(notes);
						reward.setAwardingTime(sync.getApproveDate());
						reward.setAwardingUnit(sync.getApproveUnit());
						String rewarkLevelName=sync.getRewardPunishLevel();
						reward.setRewarkLevel(getRewarkLevelByName(rewarkLevelName));
						reward.setRewarkLevelStr(rewarkLevelName);
						zjkRewardMapper.insert(reward);
					}
				}
				
				count=1;
			}
		}
	    return count;
	}
	
	public static String getRewarkLevelByName(String name)throws Exception
	{
		String resault="";
		if(name!=null)
		{
			if(name.contains("集团级"))
			{
				resault="01";
			}
			if(name.contains("板块级"))
			{
				resault="02";
			}
			if(name.contains("区县级"))
			{
				resault="03";
			}
			if(name.contains("国际级"))
			{
				resault="04";
			}
			if(name.contains("其他"))
			{
				resault="05";
			}
			if(name.contains("省部级"))
			{
				resault="06";
			}
			
			
		}
		return resault;
	}
	
	
	/**
	     * 获取专家个数
	*/
	public Integer getZjkBaseCount()throws Exception
	{
		Map map=new HashMap(); 
		map.put("delStatus", "0");
		//map.put("useStatus", "0");
		List<ZjkBase> list = zjkBaseMapper.getList(map);
		int count=0;
		if(list!=null && list.size()>0)
		{
			count=list.size();
		}
		return count;
	}
	
	public int insertBatch(List<ZjkBase> list)throws Exception
	{
		int count=0;
		if(list!=null && list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				ZjkBase zjkBase=list.get(i);
				count=zjkBaseMapper.insert(zjkBase);
			}
		}
		return count;
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
			String expertId=getTableParam(param,"expertId","");
			String knowledgeScope=getTableParam(param,"knowledgeScope","");
			String userSecretLevel=getTableParam(param,"userSecretLevel","");
			Map map=new HashMap();
			map.put("projectName", projectName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			map.put("userSecretLevel",userSecretLevel);
			map.put("knowledgeScope",knowledgeScope);
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
			String expertId=getTableParam(param,"expertId","");
			String knowledgeScope=getTableParam(param,"knowledgeScope","");
			String userSecretLevel=getTableParam(param,"userSecretLevel","");
			
			
			Map map=new HashMap();
			map.put("achieveName", achieveName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			map.put("knowledgeScope", knowledgeScope);
			map.put("userSecretLevel", userSecretLevel);
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
			String expertId=getTableParam(param,"expertId","");
			String knowledgeScope=getTableParam(param,"knowledgeScope","");
			String userSecretLevel=getTableParam(param,"userSecretLevel","");
			
			Map map=new HashMap();
			map.put("patentName", patentName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			map.put("knowledgeScope", knowledgeScope);
			map.put("userSecretLevel", userSecretLevel);
			
			List<ZjkPatent> list = zjkPatentMapper.getList(map);
			PageInfo<ZjkPatent> pageInfo = new PageInfo<ZjkPatent>(list);
			System.out.println(">>>>>>>>>专家专利查询分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
		
		
	public Integer insertBatchZjkPatent(List<ZjkPatent> list)throws Exception
	{
		return zjkPatentMapper.insertBatch(list);
	}
    
    
    
    
	public int deleteAllZjkPatent()throws Exception
	{
		return zjkPatentMapper.deleteAll();
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
			String expertId=getTableParam(param,"expertId","");
			String knowledgeScope=getTableParam(param,"knowledgeScope","");
			String userSecretLevel=getTableParam(param,"userSecretLevel","");
			
			Map map=new HashMap();
			map.put("rewarkLevel", rewarkLevel);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			map.put("knowledgeScope", knowledgeScope);
			map.put("userSecretLevel", userSecretLevel);
			
			List<ZjkReward> list = zjkRewardMapper.getList(map);
			PageInfo<ZjkReward> pageInfo = new PageInfo<ZjkReward>(list);
			System.out.println(">>>>>>>>>getZjkRewardPage分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ZjkRewardPunish selectZjkRewardPunish(String id) throws Exception
	{
		return zjkRewardPunishMapper.selectByPrimaryKey(id);
	}
	
	public Integer updateZjkRewardPunish(ZjkRewardPunish record)throws Exception
	{
		return zjkRewardPunishMapper.updateByPrimaryKey(record);
	}
	
	
	public int deleteZjkRewardPunish(String id)throws Exception
	{
		return zjkRewardPunishMapper.deleteByPrimaryKey(id);
	}
	
	
	public Integer insertZjkRewardPunish(ZjkRewardPunish record)throws Exception
	{
		return zjkRewardPunishMapper.insert(record);
	}
	
	public Integer insertBatchZjkRewardPunish(List<ZjkRewardPunish> list)throws Exception
	{
		return zjkRewardPunishMapper.insertBatch(list);
	}
	
	public LayuiTableData getZjkRewardPunishPage(LayuiTableParam param)throws Exception
	{
		
			int pageSize = param.getLimit();
			int pageStart = (param.getPage()-1)*pageSize;
			int pageNum = pageStart/pageSize + 1;
			PageHelper.startPage(pageNum, pageSize);
			String delStatus=getTableParam(param,"delStatus","");
			String expertNum=getTableParam(param,"expertNum","");
			String expertId=getTableParam(param,"expertId","");
			
			Map map=new HashMap();
			map.put("expertId", expertId);
			map.put("expertNum", expertNum);
			map.put("delStatus", delStatus);
			
			
			List<ZjkRewardPunish> list = zjkRewardPunishMapper.getList(map);
			PageInfo<ZjkRewardPunish> pageInfo = new PageInfo<ZjkRewardPunish>(list);
			System.out.println(">>>>>>>>getZjkRewardPunishPage分页结果 "+pageInfo.getList().size());
			
			LayuiTableData data = new LayuiTableData();
			data.setData(pageInfo.getList());
			Long total = pageInfo.getTotal();
			data.setCount(total.intValue());
		    return data;
	}
	
	public List getZjkRewardPunishList(Map map)throws Exception
	{
			List<ZjkRewardPunish> list = zjkRewardPunishMapper.getList(map);
		    return list;
	}
	
	public int deleteAllZjkRewardPunish()throws Exception
	{
		return zjkRewardPunishMapper.deleteAll();
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
