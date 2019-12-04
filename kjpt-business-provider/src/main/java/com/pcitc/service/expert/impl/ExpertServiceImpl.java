package com.pcitc.service.expert.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkProject;
import com.pcitc.base.expert.ZjkReward;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.expert.ZjkAchievementMapper;
import com.pcitc.mapper.expert.ZjkBaseMapper;
import com.pcitc.mapper.expert.ZjkPatentMapper;
import com.pcitc.mapper.expert.ZjkProjectMapper;
import com.pcitc.mapper.expert.ZjkRewardMapper;
import com.pcitc.mapper.techFamily.TechFamilyMapper;
import com.pcitc.service.expert.IExpertService;
import com.pcitc.service.feign.WorkflowRemoteClient;


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
	private WorkflowRemoteClient workflowRemoteClient;
	
	
	public Result dealWorkFlow(String id, Map map) throws Exception
	{
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>>课题 上报 dealWorkFlow 参数: "+parmamss.toJSONString());
		
		ZjkBase zjkBase= zjkBaseMapper.selectByPrimaryKey(id);
		String processInstanceName=(String)map.get("processInstanceName");
		String authenticatedUserId=(String)map.get("authenticatedUserId");
		String authenticatedUserName=(String)map.get("authenticatedUserName");
		String functionId=(String)map.get("functionId");
		String auditor=(String)map.get("auditor");
		String specialAuditor0=(String)map.get("specialAuditor0");
		
		
		// 调用审批流程，此处调用同时实现事务
    	JSONObject flowJson = new JSONObject();
    	// 业务主键id
    	flowJson.put("businessId", id);
    	flowJson.put("processInstanceName", processInstanceName);
    	// 发起者信息
    	flowJson.put("authenticatedUserId", authenticatedUserId);
    	flowJson.put("authenticatedUserName", authenticatedUserName);
		// 菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
    	flowJson.put("functionId", functionId);
    	// 待办业务详情、最终审批同意、最终审批不同意路径
    	flowJson.put("auditDetailsPath", "/expert/get/" + id);
    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project/task/agree/" + id);
    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project/task/reject/" + id);

    	// 非必填选项， 菜单功能需要根据不同单位、不同项目选择不同流程图的时候使用。（也可以在单个流程图中，用判断来做）
    	// flowJson.put("flowProjectId", "");
    	// flowJson.put("flowUnitId", "");
    	
    	// 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
    	if (auditor!=null && !auditor.equals("")) 
		{
			String[] userIds_arr = auditor.split(",");
			flowJson.put("auditor", Arrays.asList(userIds_arr));
		}
    	
    	//flowJson.put("auditor", auditor);
    	flowJson.put("specialAuditor0", specialAuditor0); 
		// 非必填选项, 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
		// flowJson.put("money", 50); // 环节1需要用到
		// flowJson.put("departmentCode", "1005"); // 环节2需要用到
		// flowJson.put("companyCode", "2006"); // 环节n需要用到
    	// 非必填选项, 会签时需要的属性，会签里所有的人，同意率（double类型）
    	
    	flowJson.put("signAuditRate", 1d); 
    	
    	// 远程调用
    	System.out.println("=====远程调用开始");
    	String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
    	System.out.println("=====远程调用结束");
		if("true".equals(str)) 
		{
			zjkBase.setAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
			zjkBaseMapper.updateByPrimaryKey(zjkBase);
			return new Result(true,"操作成功!");
		}else 
		{
			return new Result(false,"操作失败!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	

	/**
	     * 根据ID获取专家信息详情
	*/
	public ZjkBase selectZjkBase(String id) throws Exception
	{
		
		List rewardList=zjkRewardMapper.getListByExpertId(id);
		List projectList=zjkProjectMapper.getListByExpertId(id);
		List patentList=zjkPatentMapper.getListByExpertId(id);
		List achievementList=zjkAchievementMapper.getListByExpertId(id);
		
		ZjkBase zjkBase= zjkBaseMapper.selectByPrimaryKey(id);
		
		
		JSONArray j1 = JSONArray.parseArray(JSON.toJSONString(achievementList));
		String zjkAchievementJsonList=j1.toString();
		
		JSONArray j2 = JSONArray.parseArray(JSON.toJSONString(projectList));
		String zjkProjectJsonList=j2.toString();
		
		
		JSONArray j3 = JSONArray.parseArray(JSON.toJSONString(rewardList));
		String zjkRewardJsonList=j3.toString();
		
		
		JSONArray j4 = JSONArray.parseArray(JSON.toJSONString(patentList));
		String zjkPatentJsonList=j4.toString();
		
		
		
		
		zjkBase.setZjkAchievementJsonList(zjkAchievementJsonList);
		zjkBase.setZjkPatentJsonList(zjkPatentJsonList);
		zjkBase.setZjkProjectJsonList(zjkProjectJsonList);
		zjkBase.setZjkRewardJsonList(zjkRewardJsonList);
		
		return zjkBase;
	}

	 /**
	     *修改专家信息
	*/
	public Integer updateZjkBase(ZjkBase record)throws Exception
	{
		 //先根据专家ID删除相关的信息（专利，成果，项目，奖励）
		 zjkAchievementMapper.deleteZjkAchievementByExpertId(record.getId());
		 zjkPatentMapper.deleteZjkPatentByExpertId(record.getId());
		 zjkRewardMapper.deleteZjkRewardByExpertId(record.getId());
		 zjkProjectMapper.deleteZjkProjectByExpertId(record.getId());
		 //再增加相关的信息（专利，成果，项目，奖励）
		 addRealtionInfo(record);
		 
		 
		 
		 
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
		addRealtionInfo(record);
		
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
		List<ZjkBase> list = zjkBaseMapper.getList(map);
		System.out.println(">>>>>>>>>专家查询结果 "+list.size());
	    return list;
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
			Map map=new HashMap();
			map.put("projectName", projectName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			
			
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
			Map map=new HashMap();
			map.put("achieveName", achieveName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
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
			Map map=new HashMap();
			map.put("patentName", patentName);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
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
			String expertId=getTableParam(param,"expertId","");
			Map map=new HashMap();
			map.put("rewarkLevel", rewarkLevel);
			map.put("sourceType", sourceType);
			map.put("delStatus", delStatus);
			map.put("outSystemId", outSystemId);
			map.put("expertId", expertId);
			
			
			
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
