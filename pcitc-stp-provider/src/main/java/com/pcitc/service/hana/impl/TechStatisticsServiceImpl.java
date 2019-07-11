package com.pcitc.service.hana.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	  		//Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*pageSize;
		
			/* int start=(pageNo-1)*p.getPageSize();
			 record.setStart(start);
			 record.setPageSize(p.getPageSize());*/
					
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

	public int deleteTechOrgCount(String id)throws Exception
	{
		return techOrgCountMapper.deleteByPrimaryKey(id);
	}
	

	public Integer insertTechOrgCount(TechOrgCount record)throws Exception
	{
		return techOrgCountMapper.insert(record);
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
    
}
