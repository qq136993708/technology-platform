package com.pcitc.service.equipment.impl;

import java.util.Arrays;
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
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.mapper.equipment.SreEquipmentMapper;
import com.pcitc.mapper.equipment.SreForApplicationMapper;
import com.pcitc.service.equipment.ForApplicationService;
import com.pcitc.service.feign.WorkflowRemoteClient;
@Service("forapplicationService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public  class ForApplicationServiceImpl implements ForApplicationService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(ForApplicationServiceImpl.class); 
	@Autowired
	private SreForApplicationMapper sreforapplicationMapper;
	@Autowired
	private SreEquipmentMapper sreEquipmentMapper;
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
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
	
	
	public LayuiTableData getForApplicationPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String applicationState=getTableParam(param,"applicationState","");
		String applicationId=getTableParam(param,"applicationId","");
		String applicationName=getTableParam(param,"applicationName","");
		String applicationUserName=getTableParam(param,"applicationUserName","");
		String applicationTime=getTableParam(param,"applicationTime","");
		String applicationMoney=getTableParam(param,"applicationMoney","");
		String applyDepartCode=getTableParam(param,"applyDepartCode","");
		String unitPathIds=getTableParam(param,"parentUnitPathIds","");
		Map map=new HashMap();
		map.put("applicationId", applicationId);
		map.put("applicationState", applicationState);
		map.put("applicationName", applicationName);
		map.put("applicationUserName", applicationUserName);
		map.put("applicationTime", applicationTime);
		map.put("applicationMoney", applicationMoney);
		map.put("firstApplyUser", unitPathIds);
		
		System.out.println(">>>>>>>>applicationState="+applicationState);
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
		List<SreForApplication> list = sreforapplicationMapper.getList(map);
		PageInfo<SreForApplication> pageInfo = new PageInfo<SreForApplication>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	
	public int deleteForapplication(String id)throws Exception
	{	
		SreForApplication srefor = sreforapplicationMapper.selectByPrimaryKey(id);
		if(srefor!=null) {
			String[] sre = srefor.getApplicationPurchaseid().split(",");
			for(int i = 0 ;i<sre.length;i++) {
				SreEquipment  equipmen = sreEquipmentMapper.selectByPrimaryKey(sre[i]);
				if(equipmen!=null) {
					equipmen.setForStatus(Constant.EQUME_ZERO);
					sreEquipmentMapper.updateByPrimaryKeySelective(equipmen);
				}
			}
		}
		return sreforapplicationMapper.deleteByPrimaryKey(id);
	}


	@Override
	public Integer insertForApplication(SreForApplication record) {
		String[] strp = record.getApplicationPurchaseid().split(",");
		for(int i = 0 ;i<strp.length;i++) {
			SreEquipment  equipmen = sreEquipmentMapper.selectByPrimaryKey(strp[i]);
			if(equipmen!=null) {
				equipmen.setForStatus(Constant.EQUME_ONE);
				sreEquipmentMapper.updateByPrimaryKeySelective(equipmen);
			}
		}
		return sreforapplicationMapper.insert(record);
	}


	@Override
	public SreForApplication selectForApplication(String id) {
		// TODO Auto-generated method stub
		return sreforapplicationMapper.selectByPrimaryKey(id);
	}

	

	public LayuiTableData getEquipmentPage(LayuiTableParam param)throws Exception
	{
		
		///每页显示条数
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
		
		
		List<SreEquipment> list = sreEquipmentMapper.getForApplicationList(map);
		PageInfo<SreEquipment> pageInfo = new PageInfo<SreEquipment>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}


	@Override
	public int upForapplication(String id) {
		SreForApplication record = new SreForApplication();
		record.setApplicationId(id);
		record.setApplicationState(Constant.OK_NEO);
		return sreforapplicationMapper.updateByPrimaryKeySelective(record);
	}

	 //内部确认流程
    public Result dealPurchaseFlow(String id, Map map) throws Exception
    {


        JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
        System.out.println(">>>>>>>>>>内部确认流程 dealInnerTaskFlow 参数: "+parmamss.toJSONString());


        SreForApplication record = sreforapplicationMapper.selectByPrimaryKey(id);
        String equipmentIds = record.getApplicationPurchaseid();
        String processInstanceName=(String)map.get("processInstanceName");
        String authenticatedUserId=(String)map.get("authenticatedUserId");
        String authenticatedUserName=(String)map.get("authenticatedUserName");
        String functionId=(String)map.get("functionId");
        String auditor=(String)map.get("auditor");
        //申请者机构信息
        String applyUnitCode=(String)map.get("applyUnitCode");
        String parentApplyUnitCode=(String)map.get("parentApplyUnitCode");
        String applyUnitName=(String)map.get("applyUnitName");

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

        // 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
        if (auditor != null && !auditor.equals("")) {
            String[] userIdsArr = auditor.split(",");
            flowJson.put("auditor", Arrays.asList(userIdsArr));
        }

        // 待办业务详情、最终审批同意、最终审批不同意路径
        flowJson.put("auditDetailsPath", "/sre-forapplication/get/" + id);
        flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/agree_forapplication/" + id);
        flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/forapplication/reject_forapplication/" + id);

        // 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
        flowJson.put("specialAuditor0", "post--30130054_JHCBSY");
        flowJson.put("specialAuditor1", "role--ZBGL_KJB_ZYCCZ");
        flowJson.put("specialAuditor2", "role--ZBGL_KJB_JHCCZ");
        flowJson.put("specialAuditor3", "role--ZBGL_KJB_ZGZR");
        flowJson.put("specialAuditor4", "role--ZBGL_KJB_ZR");

        // 远程调用
        System.out.println("=====远程调用开始");
        String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
        System.out.println("=====远程调用结束");
        if("true".equals(str))
        {
            	SreForApplication forrecord = sreforapplicationMapper.selectByPrimaryKey(id);
            	forrecord.setApplicationState(Constant.OK_NEO);
            	sreforapplicationMapper.updateByPrimaryKeySelective(forrecord);
            return new Result(true,"操作成功!");
        }else
        {
            return new Result(false,"操作失败!");
        }
    }

}
