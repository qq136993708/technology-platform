package com.pcitc.service.hana.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.report.TechCost;
import com.pcitc.base.stp.report.TechOrgCount;
import com.pcitc.mapper.hana.TechCostMapper;
import com.pcitc.mapper.hana.TechOrgCountMapper;
import com.pcitc.service.feign.WorkflowRemoteClient;
import com.pcitc.service.hana.ITechStatisticsService;
@Service("techStatisticsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TechStatisticsServiceImpl implements ITechStatisticsService {


    @Autowired
    private TechCostMapper techCostMapper;
    

    @Autowired
    private TechOrgCountMapper techOrgCountMapper;
    
    @Autowired
	private WorkflowRemoteClient workflowRemoteClient;
    
	
	
	/**===========================================科研投入==========================================*/

	
	public TechCost selectTechCost(String id) throws Exception
	{
		return techCostMapper.selectByPrimaryKey(id);
	}

	public Integer updateTechCost(TechCost record)throws Exception
	{
		return techCostMapper.updateByPrimaryKey(record);
	}

	public int deleteTechCost(String id)throws Exception
	{
		return techCostMapper.deleteByPrimaryKey(id);
	}
	

	public Integer insertTechCost(TechCost record)throws Exception
	{
		return techCostMapper.insert(record);
	}
	
	public LayuiTableData getTechCostPage(LayuiTableParam param)throws Exception
	{
		
			int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
			int start=(pageNum-1)*pageSize;
					
			String unitCode=getTableParam(param,"unitCode","");
			String unitName=getTableParam(param,"unitName","");
			String type=getTableParam(param,"type","");
			String auditStatus=getTableParam(param,"auditStatus","");
			String year=getTableParam(param,"year","");
			Map map=new HashMap();
			map.put("type", type);
			map.put("unitName", unitName);
			map.put("unitCode", unitCode);
			map.put("auditStatus", auditStatus);
			map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		
	  		map.put("year", year);
	  		
	  		
	  		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
			System.out.println(">>>>>>>>>> getTechCostPage 参数: "+parmamss.toJSONString());
			
			
			List<TechCost> list = techCostMapper.getList(map);
			Integer count=techCostMapper.getCount(map);
			System.out.println(">>>>>>>>>分页结果 "+count);
			
			LayuiTableData data = new LayuiTableData();
			data.setData(list);
			data.setCount(count);
		    return data;
	}
	
	
	
	
	public JSONArray getTechCostList(Map map)throws Exception
	{
  		List<TechCost> list = techCostMapper.getList(map);
  		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
  		return json;
	}

	
	
	public LayuiTableData getTechCostStatisticsPage(LayuiTableParam param)throws Exception
	{
		
			int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
			int start=(pageNum-1)*pageSize;
		
					
			String unitCode=getTableParam(param,"unitCode","");
			String unitName=getTableParam(param,"unitName","");
			String type=getTableParam(param,"type","");
			String auditStatus=getTableParam(param,"auditStatus","");
			String year=getTableParam(param,"year","");
			Map map=new HashMap();
			map.put("type", type);
			map.put("unitName", unitName);
			map.put("unitCode", unitCode);
			map.put("auditStatus", auditStatus);
			map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("year", year);
	  		
	  		
	  		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
			System.out.println(">>>>>>>>>> getTechCostStatisticsPage 参数: "+parmamss.toJSONString());
			
			
			List<TechCost> list = techCostMapper.getStatisticsList(map);
			Integer count=techCostMapper.getStatisticsCount(map);
			System.out.println(">>>>>>>>>分页结果 "+count);
			
			LayuiTableData data = new LayuiTableData();
			data.setData(list);
			data.setCount(count);
		    return data;
	}
	
	
	
	
	public Result dealTechCostWorkFlow(String id, Map map) throws Exception
	{
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>科研投入表 dealTechCostWorkFlow 参数: "+parmamss.toJSONString());
		
		TechCost sreProject=techCostMapper.selectByPrimaryKey(id);
		String processInstanceName=(String)map.get("processInstanceName");
		String authenticatedUserId=(String)map.get("authenticatedUserId");
		String authenticatedUserName=(String)map.get("authenticatedUserName");
		String functionId=(String)map.get("functionId");
		String auditor=(String)map.get("auditor");
		//String specialAuditor0=(String)map.get("specialAuditor0");
		
		
		
	
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
    	flowJson.put("auditDetailsPath", "/tech_cost/get/" + id);
    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/techCost/task/agree/" + id);
    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/techCost/task/reject/" + id);

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
    	//flowJson.put("specialAuditor0", specialAuditor0); 
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
			sreProject.setAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
			techCostMapper.updateByPrimaryKey(sreProject);
			return new Result(true,"操作成功!");
		}else 
		{
			return new Result(false,"操作失败!");
		}
	}
	
	/**===========================================科研机构调查表==========================================*/

	
	public TechOrgCount selectTechOrgCount(String id) throws Exception
	{
		return techOrgCountMapper.selectByPrimaryKey(id);
	}

	public Integer updateTechOrgCount(TechOrgCount record)throws Exception
	{
		return techOrgCountMapper.updateByPrimaryKey(record);
	}
	public Integer updateTechOrgCountBatch(TechOrgCount record)throws Exception
	{
		return 0;
	}

	public int deleteTechOrgCount(String id)throws Exception
	{
		return techOrgCountMapper.deleteByPrimaryKey(id);
	}
	

	public Integer insertTechOrgCount(TechOrgCount record)throws Exception
	{
		return techOrgCountMapper.insert(record);
	}
	
	
	
	public TechOrgCount getTechOrgCountSum(List<TechOrgCount> list,TechOrgCount totalToc)throws Exception
	{
		Object thesisEiInnerCount=getFieldSumByFieldName(list, "thesisEiInnerCount");
		Object thesisSciInnerCount=getFieldSumByFieldName(list, "thesisSciInnerCount");
		Object achievementsCompanyCount=getFieldSumByFieldName(list, "achievementsCompanyCount");
		Object achievementsCountryCount=getFieldSumByFieldName(list, "achievementsCountryCount");
		Object allPatentCount=getFieldSumByFieldName(list, "allPatentCount");
		Object assetsTotal=getFieldSumByFieldName(list, "assetsTotal");
		Object assistResearcherCount=getFieldSumByFieldName(list, "assistResearcherCount");
		Object countryInvestCost=getFieldSumByFieldName(list, "countryInvestCost");
		Object currentPatentLookCount=getFieldSumByFieldName(list, "currentPatentLookCount");
		Object currentYearPatentCount=getFieldSumByFieldName(list, "currentYearPatentCount");
		Object deviceAssets=getFieldSumByFieldName(list, "deviceAssets");
		Object diplomaDoctorCount=getFieldSumByFieldName(list, "diplomaDoctorCount");
		Object diplomaUndergraduateCount=getFieldSumByFieldName(list, "diplomaUndergraduateCount");
		Object diplomaMasterCount=getFieldSumByFieldName(list, "diplomaMasterCount");
		Object directResearcherCount=getFieldSumByFieldName(list, "directResearcherCount");
		Object fixedAssets=getFieldSumByFieldName(list, "fixedAssets");
		Object groupInvestCost=getFieldSumByFieldName(list, "groupInvestCost");
		Object outInvestCost=getFieldSumByFieldName(list, "outInvestCost");
		Object femaleCount=getFieldSumByFieldName(list, "femaleCount");
		Object researcherCount=getFieldSumByFieldName(list, "researcherCount");
		Object thesisAllCount=getFieldSumByFieldName(list, "thesisAllCount");
		Object thesisEiCount=getFieldSumByFieldName(list, "thesisEiCount");
		Object thesisIsrCount=getFieldSumByFieldName(list, "thesisIsrCount");
		Object thesisSciCount=getFieldSumByFieldName(list, "thesisSciCount");
		Object thesisIstpCount=getFieldSumByFieldName(list, "thesisIstpCount");
		Object titleLowerCount=getFieldSumByFieldName(list, "titleLowerCount");
		Object titleMiddleCount=getFieldSumByFieldName(list, "titleMiddleCount");
		Object titleSeniorCount=getFieldSumByFieldName(list, "titleSeniorCount");
		Object totaIncome=getFieldSumByFieldName(list, "totaIncome");
		Object workerSalary=getFieldSumByFieldName(list, "workerSalary");
		Object workersCount=getFieldSumByFieldName(list, "workersCount");
		Object specialistCountryCount=getFieldSumByFieldName(list, "specialistCountryCount");
		Object specialistProvinceCount=getFieldSumByFieldName(list, "specialistProvinceCount");
		Object subInvestCost=getFieldSumByFieldName(list, "subInvestCost");
		Object allPatentLookCount=getFieldSumByFieldName(list, "allPatentLookCount");
		Object achievementsPrivanceCount=getFieldSumByFieldName(list, "achievementsPrivanceCount");
		Object deviceInnnerAssets=getFieldSumByFieldName(list, "deviceInnnerAssets");
		
		
		totalToc.setThesisEiInnerCount(Integer.parseInt((String)thesisEiInnerCount));
		totalToc.setThesisSciInnerCount(Integer.parseInt((String)thesisSciInnerCount));
		totalToc.setAchievementsCompanyCount(Integer.parseInt((String)achievementsCompanyCount));
		totalToc.setAchievementsCompanyCount(Integer.parseInt((String)achievementsCompanyCount));
		totalToc.setAchievementsCountryCount(Integer.parseInt((String)achievementsCountryCount));
		totalToc.setAllPatentCount(Integer.parseInt((String)allPatentCount));
		totalToc.setAssetsTotal(new BigDecimal((String)assetsTotal));
		totalToc.setAssistResearcherCount(Integer.parseInt((String)assistResearcherCount));
		totalToc.setCountryInvestCost(new BigDecimal((String)countryInvestCost));
		totalToc.setCurrentPatentLookCount(Integer.parseInt((String)currentPatentLookCount));
		totalToc.setCurrentYearPatentCount(Integer.parseInt((String)currentYearPatentCount));
		totalToc.setAchievementsCompanyCount(Integer.parseInt((String)achievementsCompanyCount));
		totalToc.setDeviceAssets(new BigDecimal((String)deviceAssets));
		totalToc.setDiplomaDoctorCount(Integer.parseInt((String)diplomaDoctorCount));
		totalToc.setDiplomaUndergraduateCount(Integer.parseInt((String)diplomaUndergraduateCount));
		totalToc.setDiplomaMasterCount(Integer.parseInt((String)diplomaMasterCount));
		totalToc.setDirectResearcherCount(Integer.parseInt((String)directResearcherCount));
		totalToc.setFemaleCount(Integer.parseInt((String)femaleCount));
		totalToc.setFixedAssets(new BigDecimal((String)fixedAssets));
		totalToc.setGroupInvestCost(new BigDecimal((String)groupInvestCost));
		totalToc.setOutInvestCost(new BigDecimal((String)outInvestCost));
		totalToc.setResearcherCount(Integer.parseInt((String)researcherCount));
		totalToc.setThesisAllCount(Integer.parseInt((String)thesisAllCount));
		totalToc.setThesisEiCount(Integer.parseInt((String)thesisEiCount));
		totalToc.setThesisIsrCount(Integer.parseInt((String)thesisIsrCount));
		totalToc.setThesisIstpCount(Integer.parseInt((String)thesisIstpCount));
		totalToc.setThesisSciCount(Integer.parseInt((String)thesisSciCount));
		totalToc.setTitleLowerCount(Integer.parseInt((String)titleLowerCount));
		totalToc.setTitleMiddleCount(Integer.parseInt((String)titleMiddleCount));
		totalToc.setTitleSeniorCount(Integer.parseInt((String)titleSeniorCount));
		totalToc.setTotaIncome(new BigDecimal((String)totaIncome));
		totalToc.setAssetsTotal(new BigDecimal((String)assetsTotal));
		totalToc.setWorkerSalary(new BigDecimal((String)workerSalary));
		totalToc.setWorkersCount(Integer.parseInt((String)workersCount));
		totalToc.setSpecialistCountryCount(Integer.parseInt((String)specialistCountryCount));
		totalToc.setSpecialistProvinceCount(Integer.parseInt((String)specialistProvinceCount));
		totalToc.setSubInvestCost(new BigDecimal((String)subInvestCost));
		totalToc.setAllPatentLookCount(Integer.parseInt((String)allPatentLookCount));
		totalToc.setAchievementsPrivanceCount(Integer.parseInt((String)achievementsPrivanceCount));
		totalToc.setDeviceInnnerAssets(new BigDecimal((String)deviceInnnerAssets));
		return totalToc;
		
	}
	
	
	
	
	public static <T> Object getFieldSumByFieldName(List<T> list, String fieldName) throws Exception 
	{
		Object object= new Object();
		int countInt=0;
		BigDecimal countBigDecimal=BigDecimal.ZERO;
		//100条
		for (int i = 0; i < list.size(); i++) 
		{
			T entity = list.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) 
			{
				Field field = arr[j];
				//
				Class<?> type = field.getType();
				String str = field.getName();
				if (str.equals(fieldName)) 
				{
					System.out.println(">>>>>>>>>>>>>"+field.getName()+">>>>>>字段类型 "+field.getGenericType().toString());
					// 获取原来的访问控制权限
					boolean accessFlag = field.isAccessible();
					if (!field.isAccessible())
					{
						field.setAccessible(true);	
					}
					if((field.getGenericType().toString()).equals("class java.lang.Integer")) 
					{
						int	reultInt = (int) field.get(entity);
						field.setAccessible(accessFlag);
						System.out.println(">>>>>>>>>>>fieldName="+fieldName+" 值 ："+reultInt);
						countInt=countInt+reultInt;
					}
					if(field.getGenericType().toString().equals("class java.math.BigDecimal")) 
					{
						BigDecimal	reultBigDecimal = (BigDecimal) field.get(entity);
						field.setAccessible(accessFlag);
						System.out.println(">>>>>>>>>>>fieldName="+fieldName+" 值 ："+reultBigDecimal.doubleValue());
						countBigDecimal=countBigDecimal.add(reultBigDecimal);
					}
					
				}
				
			}

		}
		
		if(countInt!=0)
		{
			object=countInt;
		}
		if(countBigDecimal!=BigDecimal.ZERO)
		{
			object=countBigDecimal;
		}
		return object;
	}
	
	
	public Integer insertTechOrgCountBatch(TechOrgCount headTOrg)throws Exception
	{
		
		String subTechOrgStr=headTOrg.getSubTechOrgStr();
		List<TechOrgCount> list =null;
		if(!subTechOrgStr.equals(""))
		{
			JSONArray tableData = JSONArray.parseArray(subTechOrgStr);
			list = JSONObject.parseArray(tableData.toJSONString(), TechOrgCount.class);
			TechOrgCount head=getTechOrgCountSum(list,headTOrg);
			techOrgCountMapper.insert(head);
			//List<TechOrgCount> list = JSONObject.parseArray(subTechOrgStr,TechOrgCount.class);
			for(int i=0;i<list.size();i++)
			{
				TechOrgCount subTechOrg=list.get(i);
				subTechOrg.setWriteType("2");
				subTechOrg.setCreateUserId(headTOrg.getCreateUserId());
				subTechOrg.setCreateUserName(headTOrg.getCreateUserName());
				subTechOrg.setYear(headTOrg.getYear());
				subTechOrg.setAttachmentDoc("");
				subTechOrg.setParentUnitCode(headTOrg.getUnitCode()); 
				subTechOrg.setParentUnitName(headTOrg.getUnitName());
				subTechOrg.setChargeDepartMan(headTOrg.getChargeDepartMan());
				subTechOrg.setCreateUserMobile(headTOrg.getCreateUserMobile());
				subTechOrg.setNotes("");
				subTechOrg.setTechChargeMan(headTOrg.getTechChargeMan());
				subTechOrg.setType(headTOrg.getType());
				subTechOrg.setCreateDate(new Date());
				String idv = UUID.randomUUID().toString().replaceAll("-", "");
				subTechOrg.setId(idv); 
				subTechOrg.setAuditStatus(headTOrg.getAuditStatus());
				subTechOrg.setParentId(headTOrg.getId());
				techOrgCountMapper.insert(subTechOrg);
			}
		}
		return 0;
	}
	
	public LayuiTableData getTechOrgCountPage(LayuiTableParam param)throws Exception
	{
		
		
				int pageSize = param.getLimit();
		  		int pageNum = param.getPage();
				int start=(pageNum-1)*pageSize;
				    
				String unitCode=getTableParam(param,"unitCode","");
				String unitName=getTableParam(param,"unitName","");
				String type=getTableParam(param,"type","");
				String auditStatus=getTableParam(param,"auditStatus","");
				String year=getTableParam(param,"year","");
				
				
				Map map=new HashMap();
				map.put("type", type);
				map.put("unitName", unitName);
				map.put("unitCode", unitCode);
				map.put("auditStatus", auditStatus);
				map.put("start", start);
		  		map.put("pageSize", pageSize);
		  		map.put("year", year);
				List<TechOrgCount> list = techOrgCountMapper.getList(map);
				Integer count=techOrgCountMapper.getCount(map);
				System.out.println(">>>>>>>>>任务书查询分页结果 "+count);
				
				LayuiTableData data = new LayuiTableData();
				data.setData(list);
				data.setCount(count);
				
			    return data;
	}
	public JSONArray getTechOrgCountList(Map map)throws Exception
	{
  		List<TechOrgCount> list = techOrgCountMapper.getList(map);
  		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
  		return json;
	}

	
	
	public LayuiTableData getTechOrgCountStatisticsPage(LayuiTableParam param)throws Exception
	{
		
		
				int pageSize = param.getLimit();
		  		int pageNum = param.getPage();
				int start=(pageNum-1)*pageSize;
				    
				String unitCode=getTableParam(param,"unitCode","");
				String unitName=getTableParam(param,"unitName","");
				String type=getTableParam(param,"type","");
				String auditStatus=getTableParam(param,"auditStatus","");
				String year=getTableParam(param,"year","");
				
				
				Map map=new HashMap();
				map.put("type", type);
				map.put("unitName", unitName);
				map.put("unitCode", unitCode);
				map.put("auditStatus", auditStatus);
				map.put("start", start);
		  		map.put("pageSize", pageSize);
		  		map.put("year", year);
				List<TechOrgCount> list = techOrgCountMapper.getStatisticsList(map);
				Integer count=techOrgCountMapper.getStatisticsCount(map);
				System.out.println(">>>>>>>>>任务书查询分页结果 "+count);
				
				LayuiTableData data = new LayuiTableData();
				data.setData(list);
				data.setCount(count);
				
			    return data;
	}
	
	
	
	

	
	public Result dealTechOrgCountWorkFlow(String id, Map map) throws Exception
	{
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>>科研机构调查表 dealTechOrgCountWorkFlow 参数: "+parmamss.toJSONString());
		
		TechOrgCount sreProject=techOrgCountMapper.selectByPrimaryKey(id);
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
    	flowJson.put("auditDetailsPath", "/tech_org/get/" + id);
    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/task/agree/" + id);
    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/techOrgCount/task/reject/" + id);

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
			sreProject.setAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
			techOrgCountMapper.updateByPrimaryKey(sreProject);
			return new Result(true,"操作成功!");
		}else 
		{
			return new Result(false,"操作失败!");
		}
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
	public TechOrgCount getTechOrgCount(TechOrgCount toc)throws Exception
	{
		
		TechOrgCount techOrgCount=new TechOrgCount();
		Integer achievementsCompanyCount = toc.getAchievementsCompanyCount();
		Integer achievementsCountryCount =  toc.getAchievementsCountryCount();
		Integer allPatentCount = toc.getAllPatentCount();
		BigDecimal assetsTotal = toc.getAssetsTotal();
		Integer assistResearcherCount =toc.getAssistResearcherCount();
		BigDecimal countryInvestCost =toc.getCountryInvestCost();
		BigDecimal outInvestCost = toc.getOutInvestCost();
		Integer femaleCount = toc.getFemaleCount();
		Integer directResearcherCount = toc.getDirectResearcherCount();
		Integer diplomaMasterCount =toc.getDiplomaMasterCount();
		Integer currentYearPatentCount =toc.getCurrentYearPatentCount();
		Integer currentPatentLookCount = toc.getCurrentPatentLookCount();
		Integer diplomaUndergraduateCount =toc.getDiplomaUndergraduateCount();
		Integer diplomaDoctorCount = toc.getDiplomaDoctorCount();
		BigDecimal deviceAssets =toc.getDeviceAssets();
		Integer researcherCount =toc.getResearcherCount();
		Integer thesisAllCount = toc.getThesisAllCount();
		Integer thesisEiCount = toc.getThesisEiCount();
		Integer thesisIsrCount = toc.getThesisIsrCount();
		Integer thesisIstpCount = toc.getThesisIstpCount();
		Integer thesisSciCount = toc.getThesisSciCount();
		Integer titleLowerCount = toc.getTitleLowerCount();
		Integer titleMiddleCount = toc.getTitleMiddleCount();
		Integer titleSeniorCount = toc.getTitleSeniorCount();
		BigDecimal totaIncome = toc.getTotaIncome();
		BigDecimal workerSalary = toc.getWorkerSalary();
		Integer workersCount = toc.getWorkersCount();
		BigDecimal fixedAssets = toc.getFixedAssets();
		BigDecimal groupInvestCost = toc.getGroupInvestCost();
		Integer specialistCountryCount = toc.getSpecialistCountryCount();
		Integer specialistProvinceCount = toc.getSpecialistProvinceCount();
		BigDecimal subInvestCost = toc.getSubInvestCost();
		Integer allPatentLookCount = toc.getAllPatentLookCount();
		Integer achievementsPrivanceCount =toc.getAchievementsPrivanceCount();
		Integer thesisEiInnerCount = toc.getThesisEiInnerCount();
		Integer thesisSciInnerCount = toc.getThesisSciInnerCount();
		BigDecimal deviceInnnerAssets = toc.getDeviceInnnerAssets();
		//
		techOrgCount.setThesisEiInnerCount(Integer.valueOf(thesisEiInnerCount));
		techOrgCount.setThesisSciInnerCount(Integer.valueOf(thesisSciInnerCount));
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setAchievementsCountryCount(Integer.valueOf(achievementsCountryCount));
		techOrgCount.setAllPatentCount(Integer.valueOf(allPatentCount));
		techOrgCount.setAssetsTotal(assetsTotal);
		techOrgCount.setAssistResearcherCount(Integer.valueOf(assistResearcherCount));
		techOrgCount.setCountryInvestCost(countryInvestCost);
		techOrgCount.setCurrentPatentLookCount(Integer.valueOf(currentPatentLookCount));
		techOrgCount.setCurrentYearPatentCount(Integer.valueOf(currentYearPatentCount));
		techOrgCount.setAchievementsCompanyCount(Integer.valueOf(achievementsCompanyCount));
		techOrgCount.setDeviceAssets(deviceAssets);
		techOrgCount.setDiplomaDoctorCount(Integer.valueOf(diplomaDoctorCount));
		techOrgCount.setDiplomaUndergraduateCount(Integer.valueOf(diplomaUndergraduateCount));
		techOrgCount.setDiplomaMasterCount(Integer.valueOf(diplomaMasterCount));
		techOrgCount.setDirectResearcherCount(Integer.valueOf(directResearcherCount));
		techOrgCount.setFemaleCount(Integer.valueOf(femaleCount));
		techOrgCount.setFixedAssets(fixedAssets);
		techOrgCount.setGroupInvestCost(groupInvestCost);
		techOrgCount.setOutInvestCost(outInvestCost);
		techOrgCount.setResearcherCount(Integer.valueOf(researcherCount));
		techOrgCount.setThesisAllCount(Integer.valueOf(thesisAllCount));
		techOrgCount.setThesisEiCount(Integer.valueOf(thesisEiCount));
		techOrgCount.setThesisIsrCount(Integer.valueOf(thesisIsrCount));
		techOrgCount.setThesisIstpCount(Integer.valueOf(thesisIstpCount));
		techOrgCount.setThesisSciCount(Integer.valueOf(thesisSciCount));
		techOrgCount.setTitleLowerCount(Integer.valueOf(titleLowerCount));
		techOrgCount.setTitleMiddleCount(Integer.valueOf(titleMiddleCount));
		techOrgCount.setTitleSeniorCount(Integer.valueOf(titleSeniorCount));
		techOrgCount.setTotaIncome(totaIncome);
		techOrgCount.setAssetsTotal(assetsTotal);
		techOrgCount.setWorkerSalary(workerSalary);
		techOrgCount.setWorkersCount(Integer.valueOf(workersCount));
		techOrgCount.setSpecialistCountryCount(Integer.valueOf(specialistCountryCount));
		techOrgCount.setSpecialistProvinceCount(Integer.valueOf(specialistProvinceCount));
		techOrgCount.setSubInvestCost(subInvestCost);
		techOrgCount.setAllPatentLookCount(Integer.valueOf(allPatentLookCount));
		techOrgCount.setAchievementsPrivanceCount(Integer.valueOf(achievementsPrivanceCount));
		techOrgCount.setDeviceInnnerAssets(deviceInnnerAssets);
		return techOrgCount;
	}
	
}