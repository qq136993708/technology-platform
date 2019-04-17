package com.pcitc.service.equipment.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SreProjectYear;
import com.pcitc.base.stp.equipment.SreProjectYearExample;
import com.pcitc.base.stp.equipment.SreSupplier;
import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.mapper.equipment.SreEquipmentMapper;
import com.pcitc.mapper.equipment.SreProjectMapper;
import com.pcitc.mapper.equipment.SreProjectSetupMapper;
import com.pcitc.mapper.equipment.SreProjectTaskMapper;
import com.pcitc.mapper.equipment.SreProjectYearMapper;
import com.pcitc.mapper.equipment.SreSupplierMapper;
import com.pcitc.mapper.equipment.SreTechMeetingMapper;
import com.pcitc.service.equipment.EquipmentService;
import com.pcitc.service.feign.WorkflowRemoteClient;


@Service("equipmentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentServiceImpl implements EquipmentService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class); 
	@Autowired
	private SreEquipmentMapper sreEquipmentMapper;
	
	@Autowired
	private SreProjectMapper sreProjectMapper;
	
	@Autowired
	private SreTechMeetingMapper sreTechMeetingMapper;
	
	@Autowired
	private SreProjectYearMapper sreProjectYearMapper;
	
	@Autowired
	private SreProjectTaskMapper sreProjectTaskMapper;
	
	@Autowired
	private SreProjectSetupMapper sreProjectSetupMapper;
	
	@Autowired
	private SreSupplierMapper sreSupplierMapper;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	
	
	public SreEquipment selectEquipment(String id) throws Exception
	{
		return sreEquipmentMapper.selectByPrimaryKey(id);
	}

	public Integer updateEquipment(SreEquipment record)throws Exception
	{
		return sreEquipmentMapper.updateByPrimaryKey(record);
	}

	public int deleteEquipment(String id)throws Exception
	{
		return sreEquipmentMapper.deleteByPrimaryKey(id);
	}
	
	
	
	public List<SreEquipment> getEquipmentListByIds(List<String> list)throws Exception
	{
		return sreEquipmentMapper.getEquipmentListByIds(list);
	}
	
	public List<SreEquipment> getEquipmentListByMap(Map map)throws Exception
	{
		
		Map map_para=new HashMap();
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>> getEquipmentListByMap 参数: "+parmamss.toJSONString());
		String equipmentIds=(String)map.get("equipmentIds");
		String purchaseStatus=(String)map.get("purchaseStatus");
		StringBuffer applyUnitCodeStr=new StringBuffer();
        if (!equipmentIds.equals("")) 
		{
			String chkbox[] = equipmentIds.split(",");
			if (chkbox != null && chkbox.length > 0)
			{
				applyUnitCodeStr.append("  equipment_id IN ( ");
				for(int i=0;i<chkbox.length;i++)
				{
					if(i>0)
					{
						applyUnitCodeStr.append(",'"+chkbox[i]+"'");
					}else
					{
						applyUnitCodeStr.append("'"+chkbox[i]+"'");
					}
				}
				applyUnitCodeStr.append(" ) ");
			}
		}
        map_para.put("purchaseStatus", purchaseStatus);
        map_para.put("sqlStr", applyUnitCodeStr.toString());
    	List<SreEquipment> list = sreEquipmentMapper.getList(map_para);
    	return list;
	}

	public Integer insertEquipment(SreEquipment record)throws Exception
	{
		return sreEquipmentMapper.insert(record);
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
	
	
	public LayuiTableData getEquipmentPage(LayuiTableParam param)throws Exception
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
		String equipmentIds=getTableParam(param,"equipmentIds","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String applyDepartName=getTableParam(param,"applyDepartName","");
		String applyDepartCode=getTableParam(param,"applyDepartCode","");
		String unitPathIds=getTableParam(param,"unitPathIds","");
		String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");
		String isLinkedProject=getTableParam(param,"isLinkedProject","");
		Map map=new HashMap();
		map.put("name", name);
		map.put("equipmentIds", equipmentIds);
		map.put("auditStatus", auditStatus);
		map.put("applyDepartName", applyDepartName);
		map.put("unitPathIds", unitPathIds);
		map.put("parentUnitPathIds", parentUnitPathIds);
		map.put("isLinkedProject", isLinkedProject);
		System.out.println(">>>>>>>>applyDepartCode="+applyDepartCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyDepartCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyDepartCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		
		
		List<SreEquipment> list = sreEquipmentMapper.getList(map);
		PageInfo<SreEquipment> pageInfo = new PageInfo<SreEquipment>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	/**===========================================计划==========================================*/

	public SreProject selectProjectBasic(String id) throws Exception
	{
		return sreProjectMapper.selectByPrimaryKey(id);
	}

	public Integer updateProjectBasic(SreProject record)throws Exception
	{
		return sreProjectMapper.updateByPrimaryKey(record);
	}

	public int deleteProjectBasic(String id)throws Exception
	{
		return sreProjectMapper.deleteByPrimaryKey(id);
	}

	public Integer insertProjectBasic(SreProject record)throws Exception
	{
		return sreProjectMapper.insert(record);
	}

	
	
	
	
	//自定义
	public LayuiTableData getProjectPage(LayuiTableParam param)throws Exception
	{
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
				
		String name=getTableParam(param,"name","");
		String equipmentIds=getTableParam(param,"equipmentIds","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String setupYear=getTableParam(param,"setupYear","");
		String keyWord=getTableParam(param,"keyWord","");
		String leadUnitName=getTableParam(param,"leadUnitName","");
		String leadUnitCode=getTableParam(param,"leadUnitCode","");
		String applyUnitName=getTableParam(param,"applyUnitName","");
		String applyUnitCode=getTableParam(param,"applyUnitCode","");
		String joinUnitName=getTableParam(param,"joinUnitName","");
		String joinUnitCode=getTableParam(param,"joinUnitCode","");
		String taskWriteUsersIds=getTableParam(param,"taskWriteUsersIds","");
		
		
		String createUserId=getTableParam(param,"createUserId","");
		String createUserName=getTableParam(param,"createUserName","");
		String professionalFieldCode=getTableParam(param,"professionalFieldCode","");
		String professionalFieldName=getTableParam(param,"professionalFieldName","");
		String setupId=getTableParam(param,"setupId","");
		String taskId=getTableParam(param,"taskId","");
		
		String belongDepartmentName=getTableParam(param,"belongDepartmentName","");
		String professionalDepartName=getTableParam(param,"professionalDepartName","");
		
		String unitPathIds=getTableParam(param,"unitPathIds","");
		String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");
		
		Map map=new HashMap();
		map.put("belongDepartmentName", belongDepartmentName);
		map.put("professionalDepartName", professionalDepartName);
		map.put("name", name);
		map.put("equipmentIds", equipmentIds);
		map.put("auditStatus", auditStatus);
		map.put("setupYear", setupYear);
		map.put("keyWord", keyWord);
		map.put("leadUnitName", leadUnitName);
		map.put("leadUnitCode", leadUnitCode);
		map.put("applyUnitName", applyUnitName);
		map.put("joinUnitName", joinUnitName);
		map.put("joinUnitCode", joinUnitCode);
		map.put("taskWriteUsersIds", taskWriteUsersIds);
		
		map.put("createUserId", createUserId);
		map.put("createUserName", createUserName);
		map.put("professionalFieldCode", professionalFieldCode);
		map.put("professionalFieldName", professionalFieldName);
		map.put("setupId", setupId);
		map.put("taskId", taskId);
		map.put("unitPathIds", unitPathIds);
		map.put("parentUnitPathIds", parentUnitPathIds);
		System.out.println(">>>>>>>>applyUnitCode="+applyUnitCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyUnitCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyUnitCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		
		System.out.println(">>>>>>>>sqlstr"+applyUnitCodeStr.toString());
		List<SreProject> list = sreProjectMapper.getList(map);
		PageInfo<SreProject> pageInfo = new PageInfo<SreProject>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	public Result dealProjectWorkFlow(String id, Map map) throws Exception
	{
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>>课题 上报 dealProjectWorkFlow 参数: "+parmamss.toJSONString());
		
		SreProject sreProject=sreProjectMapper.selectByPrimaryKey(id);
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
    	flowJson.put("auditDetailsPath", "/sre-project-basic/get/" + id);
    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project/task/agree/" + id);
    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project/task/reject/" + id);

    	// 非必填选项， 菜单功能需要根据不同单位、不同项目选择不同流程图的时候使用。（也可以在单个流程图中，用判断来做）
    	// flowJson.put("flowProjectId", "");
    	// flowJson.put("flowUnitId", "");
    	
    	// 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
    	flowJson.put("auditor", auditor);
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
			sreProjectMapper.updateByPrimaryKey(sreProject);
			return new Result(true,"操作成功!");
		}else 
		{
			return new Result(false,"操作失败!");
		}
	}
	
	

	/**===========================================任务书=========================================*/

	public SreProjectTask selectSreProjectTask(String id) throws Exception
	{
		return sreProjectTaskMapper.selectByPrimaryKey(id);
	}

	public Integer updateSreProjectTask(SreProjectTask record)throws Exception
	{
		return sreProjectTaskMapper.updateByPrimaryKey(record);
	}

	public int deleteSreProjectTask(String id)throws Exception
	{
		return sreProjectTaskMapper.deleteByPrimaryKey(id);
	}

	public Integer insertSreProjectTask(SreProjectTask record)throws Exception
	{
		return sreProjectTaskMapper.insert(record);
	}


	public List<SreProjectTask> getSreProjectTaskListBytopicId(String topicId)throws Exception
	{
		return sreProjectTaskMapper.getSreProjectTaskListBytopicId(topicId);
	}
	
	public LayuiTableData getSreProjectTaskPage(LayuiTableParam param)throws Exception
	{
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
				
		String topicName=getTableParam(param,"topicName","");
		String topicId=getTableParam(param,"topicId","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String contractNum=getTableParam(param,"contractNum","");
		String leadUnitName=getTableParam(param,"leadUnitName","");
		String leadUnitCode=getTableParam(param,"leadUnitCode","");
		String applyUnitName=getTableParam(param,"applyUnitName","");
		String applyUnitCode=getTableParam(param,"applyUnitCode","");
		String joinUnitName=getTableParam(param,"joinUnitName","");
		String joinUnitCode=getTableParam(param,"joinUnitCode","");
		String innerAuditStatus=getTableParam(param,"innerAuditStatus","");
		String setupYear=getTableParam(param,"setupYear","");
		String taskId=getTableParam(param,"taskId","");
		String createUserId=getTableParam(param,"createUserId","");
		String createUserName=getTableParam(param,"createUserName","");
		String professionalFieldCode=getTableParam(param,"professionalFieldCode","");
		String professionalFieldName=getTableParam(param,"professionalFieldName","");
		String setupId=getTableParam(param,"setupId","");
		String belongDepartmentName=getTableParam(param,"belongDepartmentName","");
		String professionalDepartName=getTableParam(param,"professionalDepartName","");
		String unitPathIds=getTableParam(param,"unitPathIds","");
		String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");
		String closeStatus=getTableParam(param,"closeStatus","");
		String isCheck=getTableParam(param,"isCheck","");
		
		Map map=new HashMap();
		map.put("belongDepartmentName", belongDepartmentName);
		map.put("professionalDepartName", professionalDepartName);
		map.put("topicName", topicName);
		map.put("auditStatus", auditStatus);
		map.put("leadUnitName", leadUnitName);
		map.put("leadUnitCode", leadUnitCode);
		map.put("applyUnitName", applyUnitName);
		map.put("joinUnitName", joinUnitName);
		map.put("joinUnitCode", joinUnitCode);
		map.put("taskId", taskId);
		map.put("setupYear", setupYear);
		map.put("topicId", topicId);
		map.put("contractNum", contractNum);
		map.put("innerAuditStatus", innerAuditStatus);
		map.put("createUserId", createUserId);
		map.put("createUserName", createUserName);
		map.put("professionalFieldCode", professionalFieldCode);
		map.put("professionalFieldName", professionalFieldName);
		map.put("setupId", setupId);
		map.put("unitPathIds", unitPathIds);
		map.put("parentUnitPathIds", parentUnitPathIds);
		map.put("closeStatus", closeStatus);
		map.put("isCheck", isCheck);
		System.out.println(">>>>>>>>applyUnitCode="+applyUnitCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyUnitCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyUnitCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		
		
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		System.out.println(">>>>>>>>sqlstr"+applyUnitCodeStr.toString());
		
		
		List<SreProjectTask> list = sreProjectTaskMapper.getList(map);
		PageInfo<SreProjectTask> pageInfo = new PageInfo<SreProjectTask>(list);
		System.out.println(">>>>>>>>>任务书查询分页结果 "+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	//内部确认流程
	public Result dealInnerTaskFlow(String id, Map map) throws Exception
	{
		
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>>内部确认流程 dealInnerTaskFlow 参数: "+parmamss.toJSONString());
		
		
		SreProjectTask sreProject=sreProjectTaskMapper.selectByPrimaryKey(id);
		String processInstanceName=(String)map.get("processInstanceName");
		String authenticatedUserId=(String)map.get("authenticatedUserId");
		String authenticatedUserName=(String)map.get("authenticatedUserName");
		String functionId=(String)map.get("functionId");
		String auditor=(String)map.get("auditor");
		//申请者机构信息
		String applyUnitCode=(String)map.get("applyUnitCode");
		String parentApplyUnitCode=(String)map.get("parentApplyUnitCode");
		String applyUnitName=(String)map.get("applyUnitName");
		String applyUserId=(String)map.get("applyUserId");
		String applyUserName=(String)map.get("applyUserName");
		String applyUnitPathCode=(String)map.get("applyUnitPathCode");
		String parentApplyUnitPathCode=(String)map.get("parentApplyUnitPathCode");
		String parentApplyUnitPathName=(String)map.get("parentApplyUnitPathName");
		//指定岗位
		String specialAuditor1=(String)map.get("specialAuditor1");
		String specialAuditor2=(String)map.get("specialAuditor2");
		String specialAuditor3=(String)map.get("specialAuditor3");
		
		
		String branchFlag=(String)map.get("branchFlag");
		
		
		
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
    	flowJson.put("auditDetailsPath", "/sre_project_task/get/" + id);
    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/agree_inner/" + id);
    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/reject_inner/" + id);

    	// 非必填选项， 菜单功能需要根据不同单位、不同项目选择不同流程图的时候使用。（也可以在单个流程图中，用判断来做）
    	// flowJson.put("flowProjectId", "");
    	// flowJson.put("flowUnitId", "");
    	flowJson.put("branchFlag", branchFlag);
    	// 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
    	flowJson.put("auditor", auditor);
    	
		// 非必填选项, 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
		// flowJson.put("money", 50); // 环节1需要用到
		// flowJson.put("departmentCode", "1005"); // 环节2需要用到
		// flowJson.put("companyCode", "2006"); // 环节n需要用到
    	// 非必填选项, 会签时需要的属性，会签里所有的人，同意率（double类型）
    	// flowJson.put("specialAuditor0", "ZBGL_KTY_CYDW");
    	flowJson.put("specialAuditor1", specialAuditor1);
		flowJson.put("specialAuditor2", specialAuditor2);
    	flowJson.put("specialAuditor3", specialAuditor3);
    	flowJson.put("signAuditRate", 1d); 
    	
    	// 远程调用
    	System.out.println("=====远程调用开始");
    	String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
    	System.out.println("=====远程调用结束");
		if("true".equals(str)) 
		{
			sreProject.setInnerAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
			sreProject.setApplyUnitCode(applyUnitCode);
			sreProject.setApplyUnitName(applyUnitName);
			sreProject.setApplyUnitPathCode(applyUnitPathCode);
			sreProject.setApplyUserId(applyUserId);
			sreProject.setApplyUserName(applyUserName);
			sreProject.setParentApplyUnitCode(parentApplyUnitCode);
			sreProject.setParentApplyUnitPathCode(parentApplyUnitPathCode);
			sreProject.setParentApplyUnitPathName(parentApplyUnitPathName);
			sreProjectTaskMapper.updateByPrimaryKey(sreProject);
			return new Result(true,"操作成功!");
		}else 
		{
			return new Result(false,"操作失败!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	   //总部上报流程
		public Result dealUpTaskFlow(String id, Map map) throws Exception
		{
			
			
			JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
			System.out.println(">>>>>>>>>>总部上报流程 dealUpTaskFlow 参数: "+parmamss.toJSONString());
			
			
			SreProjectTask sreProject=sreProjectTaskMapper.selectByPrimaryKey(id);
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
	    	
	    	flowJson.put("auditDetailsPath", "/sre_project_task/get/" + id);
	    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/agree/" + id);
	    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/reject/" + id);
	    	
	    	

	    	// 非必填选项， 菜单功能需要根据不同单位、不同项目选择不同流程图的时候使用。（也可以在单个流程图中，用判断来做）
	    	// flowJson.put("flowProjectId", "");
	    	// flowJson.put("flowUnitId", "");
	    	
	    	// 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
	    	flowJson.put("auditor", auditor);
	    	
			// 非必填选项, 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
			// flowJson.put("money", 50); // 环节1需要用到
			// flowJson.put("departmentCode", "1005"); // 环节2需要用到
			// flowJson.put("companyCode", "2006"); // 环节n需要用到
	    	// 非必填选项, 会签时需要的属性，会签里所有的人，同意率（double类型）
	    	
	    	

	    	flowJson.put("specialAuditor0", specialAuditor0);
	    	
	    	
	    	//flowJson.put("signAuditRate", 1d); 
	    	
	    	// 远程调用
	    	System.out.println("=====远程调用开始");
	    	String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	System.out.println("=====远程调用结束");
			if("true".equals(str)) 
			{
				sreProject.setAuditStatus(Constant.AUDIT_STATUS_SUBMIT);
				sreProjectTaskMapper.updateByPrimaryKey(sreProject);
				return new Result(true,"操作成功!");
			}else 
			{
				return new Result(false,"操作失败!");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	
	
	


	/**===========================================立项报告=======================================*/

	public SreProjectSetup selectSreProjectSetup(String id) throws Exception
	{
		return sreProjectSetupMapper.selectByPrimaryKey(id);
	}

	public Integer updateSreProjectSetup(SreProjectSetup record)throws Exception
	{
		return sreProjectSetupMapper.updateByPrimaryKey(record);
	}

	public int deleteSreProjectSetup(String id)throws Exception
	{
		return sreProjectSetupMapper.deleteByPrimaryKey(id);
	}

	public Integer insertSreProjectSetup(SreProjectSetup record)throws Exception
	{
		return sreProjectSetupMapper.insert(record);
	}

	
	public LayuiTableData getSreProjectSetupPage(LayuiTableParam param)throws Exception
	{
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
				
		String topicName=getTableParam(param,"topicName","");
		String topicId=getTableParam(param,"topicId","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String contractNum=getTableParam(param,"contractNum","");
		String leadUnitName=getTableParam(param,"leadUnitName","");
		String leadUnitCode=getTableParam(param,"leadUnitCode","");
		String applyUnitName=getTableParam(param,"applyUnitName","");
		String applyUnitCode=getTableParam(param,"applyUnitCode","");
		String joinUnitName=getTableParam(param,"joinUnitName","");
		String joinUnitCode=getTableParam(param,"joinUnitCode","");
		
		
		Map map=new HashMap();
		map.put("topicName", topicName);
		map.put("auditStatus", auditStatus);
		map.put("leadUnitName", leadUnitName);
		map.put("leadUnitCode", leadUnitCode);
		map.put("applyUnitName", applyUnitName);
		map.put("joinUnitName", joinUnitName);
		map.put("joinUnitCode", joinUnitCode);
		map.put("topicId", topicId);
		map.put("contractNum", contractNum);
		System.out.println(">>>>>>>>applyUnitCode="+applyUnitCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyUnitCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyUnitCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		System.out.println(">>>>>>>>sqlstr"+applyUnitCodeStr.toString());
		
		
		List<SreProjectSetup> list = sreProjectSetupMapper.getList(map);
		PageInfo<SreProjectSetup> pageInfo = new PageInfo<SreProjectSetup>(list);
		System.out.println(">>>>>>>>>任务书查询分页结果 "+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	
	
	
	
	
	

	/**===========================================项目费用年==========================================*/

	public SreProjectYear selectSreProjectYear(String id) throws Exception
	{
		return sreProjectYearMapper.selectByPrimaryKey(id);
	}

	public Integer updateSreProjectYear(SreProjectYear record)throws Exception
	{
		return sreProjectYearMapper.updateByPrimaryKey(record);
	}

	public int deleteSreProjectYear(String id)throws Exception
	{
		return sreProjectYearMapper.deleteByPrimaryKey(id);
	}

	public Integer insertSreProjectYear(SreProjectYear record)throws Exception
	{
		return sreProjectYearMapper.insert(record);
	}

	public List<SreProjectYear> getSreProjectYearList(SreProjectYearExample example)throws Exception
	{
		return sreProjectYearMapper.selectByExample(example);
	}
	
	
	public int deleteSreProjectYearExample(SreProjectYearExample example)throws Exception
	{
		return sreProjectYearMapper.deleteByExample(example);
	}
	
	
	/**===========================================技术交流==========================================*/

	
	public SreTechMeeting selectMeeting(String id) throws Exception
	{
		return sreTechMeetingMapper.selectByPrimaryKey(id);
	}

	public Integer updateMeeting(SreTechMeeting record)throws Exception
	{
		return sreTechMeetingMapper.updateByPrimaryKey(record);
	}

	public int deleteMeeting(String id)throws Exception
	{
		return sreTechMeetingMapper.deleteByPrimaryKey(id);
	}
	
	
	

	public Integer insertMeeting(SreTechMeeting record)throws Exception
	{
		return sreTechMeetingMapper.insert(record);
	}

	
	
	public LayuiTableData getMeetingPage(LayuiTableParam param)throws Exception
	{
		
		
		  //每页显示条数
				int pageSize = param.getLimit();
				//从第多少条开始
				int pageStart = (param.getPage()-1)*pageSize;
				//当前是第几页
				int pageNum = pageStart/pageSize + 1;
				// 1、设置分页信息，包括当前页数和每页显示的总计数
				PageHelper.startPage(pageNum, pageSize);
						
				String title=getTableParam(param,"title","");
				
				Map map=new HashMap();
				map.put("title", title);
				
				
				List<SreTechMeeting> list = sreTechMeetingMapper.getList(map);
				PageInfo<SreTechMeeting> pageInfo = new PageInfo<SreTechMeeting>(list);
				System.out.println(">>>>>>>>>任务书查询分页结果 "+pageInfo.getList().size());
				
				LayuiTableData data = new LayuiTableData();
				data.setData(pageInfo.getList());
				Long total = pageInfo.getTotal();
				data.setCount(total.intValue());
				
			    return data;
	}

	
	
	
	
	
	public SreSupplier selectSupplier(String id) throws Exception
	{
		return sreSupplierMapper.selectByPrimaryKey(id);
	}

	public Integer updateSupplier(SreSupplier record)throws Exception
	{
		return sreSupplierMapper.updateByPrimaryKey(record);
	}

	public int deleteSupplier(String id)throws Exception
	{
		return sreSupplierMapper.deleteByPrimaryKey(id);
	}
	
	
	
	public List<SreSupplier> getSupplierListByIds(List<String> list)throws Exception
	{
		return sreSupplierMapper.getListByIds(list);
	}

	public Integer insertSupplier(SreSupplier record)throws Exception
	{
		return sreSupplierMapper.insert(record);
	}

	
	
	
	public LayuiTableData getSupplierPage(LayuiTableParam param)throws Exception
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
		String equipmentIds=getTableParam(param,"equipmentIds","");
		String auditStatus=getTableParam(param,"auditStatus","");
		String applyDepartName=getTableParam(param,"applyDepartName","");
		String applyDepartCode=getTableParam(param,"applyDepartCode","");
		String unitPathIds=getTableParam(param,"unitPathIds","");
		String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");
		
		Map map=new HashMap();
		map.put("name", name);
		map.put("equipmentIds", equipmentIds);
		map.put("auditStatus", auditStatus);
		map.put("applyDepartName", applyDepartName);
		map.put("unitPathIds", unitPathIds);
		map.put("parentUnitPathIds", parentUnitPathIds);
		
		System.out.println(">>>>>>>>applyDepartCode="+applyDepartCode);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		if(!applyDepartCode.equals(""))
		{
			applyUnitCodeStr.append(" (");
			String arr[]=applyDepartCode.split(",");
			for(int i=0;i<arr.length;i++)
			{
				if(i>0)
				{
					applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
				}else
				{
					applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_depart_code`)");
				}
				
			}
			applyUnitCodeStr.append(" )");
		}
		
		map.put("sqlStr", applyUnitCodeStr.toString());
		
		
		List<SreSupplier> list = sreSupplierMapper.getList(map);
		PageInfo<SreSupplier> pageInfo = new PageInfo<SreSupplier>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}


/**===========================================任务书关闭==========================================*/
	
	public LayuiTableData getSreTaskClosurePage(LayuiTableParam param)throws Exception
	{
        //每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String closeStatus = getTableParam(param, "closeStatus","");
		String setupYear = getTableParam(param, "setupYear", "");
		String topicName = getTableParam(param, "topicName", "");
		Map map = new HashMap();
		map.put("closeStatus", closeStatus);
		map.put("topicName", topicName);
		map.put("setupYear", setupYear);
		List<SreProjectTask> list = sreProjectTaskMapper.getTaskClosureList(map);
		PageInfo<SreProjectTask> pageInfo = new PageInfo<SreProjectTask>(list);
		System.out.println(">>>>>>>>>任务书查询分页结果 "+pageInfo.getList().size());
		
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}

	
	
	

}
