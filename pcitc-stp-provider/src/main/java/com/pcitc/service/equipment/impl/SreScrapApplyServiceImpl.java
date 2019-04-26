package com.pcitc.service.equipment.impl;

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
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.SreScrapApply;
import com.pcitc.mapper.equipment.SreForApplicationMapper;
import com.pcitc.mapper.equipment.SreProjectAuditMapper;
import com.pcitc.mapper.equipment.SreProjectTaskMapper;
import com.pcitc.mapper.equipment.SreScrapApplyMapper;
import com.pcitc.service.equipment.SreScrapApplyService;
import com.pcitc.service.feign.WorkflowRemoteClient;
@Service("sreScrapApplyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SreScrapApplyServiceImpl implements SreScrapApplyService {
	
	private final static Logger logger = LoggerFactory.getLogger(SreScrapApplyServiceImpl.class); 
	@Autowired
	private SreScrapApplyMapper sreScrapApplyMapper;
	
	@Autowired
	private SreProjectTaskMapper sreProjectTaskMapper;
	@Autowired
	private SreProjectAuditMapper sreProjectAuditMapper;
    @Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	public LayuiTableData getSreScrapApplyPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String ApplyName=getTableParam(param,"name","");
//		String applicationId=getTableParam(param,"applicationId","");
//		String applicationName=getTableParam(param,"applicationName","");
//		String applicationUserName=getTableParam(param,"applicationUserName","");
//		String applicationTime=getTableParam(param,"applicationTime","");
//		String applicationMoney=getTableParam(param,"applicationMoney","");
//		
		Map map=new HashMap();
		map.put("ApplyName", ApplyName);
//		map.put("applicationState", applicationState);
//		map.put("applicationName", applicationName);
//		map.put("applicationUserName", applicationUserName);
//		map.put("applicationTime", applicationTime);
//		map.put("applicationMoney", applicationMoney);
//		
//		System.out.println(">>>>>>>>applicationState="+applicationState);
		
		List<SreScrapApply> list = sreScrapApplyMapper.getlist(map);
		PageInfo<SreScrapApply> pageInfo = new PageInfo<SreScrapApply>(list);
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
	public int insert(SreScrapApply record)throws Exception
	{
		return sreScrapApplyMapper.insert(record);
	}
	public SreScrapApply selectByPrimaryKey(String id)throws Exception
	{
		return sreScrapApplyMapper.selectByPrimaryKey(id);
	}
	public int updateByPrimaryKeySelective(SreScrapApply record)throws Exception
	{
		return sreScrapApplyMapper.updateByPrimaryKeySelective(record);
	}
	
	public String addAudit(SreProjectAudit sreProjectAudit)throws Exception
	{
		try {
			if (sreProjectAudit != null && sreProjectAudit.getProjecttaskid() != null) {
			sreProjectAuditMapper.insert(sreProjectAudit);
			} 
			return "success";
		} catch (Exception e) {
			return "error";
		}
	
	}
	
	 //内部确认流程
    public Result dealInnerPurchaseFlow(String id, Map map) throws Exception
    {


        JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
        System.out.println(">>>>>>>>>>内部确认流程 dealInnerTaskFlow 参数: "+parmamss.toJSONString());


        SreScrapApply sreScrapApply = sreScrapApplyMapper.selectByPrimaryKey(id);

        String processInstanceName=(String)map.get("processInstanceName");
        String authenticatedUserId=(String)map.get("authenticatedUserId");
        String authenticatedUserName=(String)map.get("authenticatedUserName");
        String functionId=(String)map.get("functionId");
        String auditor=(String)map.get("auditor");
        //申请者机构信息
        String applyUnitCode=(String)map.get("applyUnitCode");
        String parentApplyUnitCode=(String)map.get("parentApplyUnitCode");
        String applyUnitName=(String)map.get("applyUnitName");
        /*String applyUserId=(String)map.get("applyUserId");
        String applyUserName=(String)map.get("applyUserName");
        String applyUnitPathCode=(String)map.get("applyUnitPathCode");
        String parentApplyUnitPathCode=(String)map.get("parentApplyUnitPathCode");
        String parentApplyUnitPathName=(String)map.get("parentApplyUnitPathName");*/




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
        flowJson.put("auditDetailsPath", "/sre-sreScrapApply/view/" + id);
        flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/agree_purchase/" + id);
        flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/reject_purchase/" + id);


        // 远程调用
        System.out.println("=====远程调用开始");
        String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
        System.out.println("=====远程调用结束");
        if("true".equals(str))
        {
        	sreScrapApply.setStatus(Constant.SRE_SCARP_APPLY_STATUS);
        	sreScrapApplyMapper.updateByPrimaryKeySelective(sreScrapApply);
            return new Result(true,"操作成功!");
        }else
        {
            return new Result(false,"操作失败!");
        }
    }
}
