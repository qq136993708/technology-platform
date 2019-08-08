package com.pcitc.service.intlproject.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.DataTableParam;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.stp.IntlProject.IntlProjectInfoExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.mapper.IntlProject.IntlProjectInfoMapper;
import com.pcitc.service.feign.WorkflowRemoteClient;
import com.pcitc.service.intlproject.IntlProjectApplyService;
import com.pcitc.service.intlproject.IntlProjectInfoService;
@Service("projectInfoService")
public class IntlProjectInfoServiceImpl implements IntlProjectInfoService {

	@Autowired
	private IntlProjectInfoMapper projectInfoMapper;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	@Autowired
	private IntlProjectApplyService intlProjectApplyService;
	
	@Override
	public IntlProjectInfo findById(String projectId) 
	{
		return projectInfoMapper.selectByPrimaryKey(projectId);
	}

	@Override
	public PageInfo<IntlProjectInfo> findByPagin(DataTableParam dataTableParam) {
		int pageLength = dataTableParam.getiDisplayLength();
		int startPage = dataTableParam.getiDisplayStart();
		
		IntlProjectInfoExample example = new IntlProjectInfoExample();
		IntlProjectInfoExample.Criteria criteria = example.createCriteria();
		
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		//criteria.andFlowEndStatusEqualTo(FlowStatusEnum.FLOW_END_STATUS_YES.getCode());
		//criteria.andFlowCurrentStatusEqualTo(FlowStatusEnum.FLOW_CURRENT_STATUS_PASS.getCode());
		
		startPage = startPage/pageLength+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(startPage, pageLength);
		// 2、执行查询
		List<IntlProjectInfo> list = projectInfoMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectInfo> pageInfo = new PageInfo<IntlProjectInfo>(list);
		// 4、封装需要返回的分页实体
		return pageInfo;
	}

	@Override
	public Integer saveOrUpdate(IntlProjectInfo info) 
	{
		IntlProjectInfo project = projectInfoMapper.selectByPrimaryKey(info.getProjectId());
		if(info.getAppendFiles() == null) {
			info.setAppendFiles(IdUtil.createFileIdByTime());
		}
		//System.out.println(JSON.toJSONString(info));
		if(project != null)
		{
			MyBeanUtils.copyPropertiesIgnoreNull(info, project);
			project.setUpdateTime(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
			return projectInfoMapper.updateByPrimaryKey(project);
		}
		else 
		{
			info.setStatus(0);
			info.setProjectStep(0);
			info.setCreateTime(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
			return projectInfoMapper.insert(info);
		}
	}

	@Override
	public Integer delProjectInfo(String projectId) 
	{
		IntlProjectInfo project = projectInfoMapper.selectByPrimaryKey(projectId);
		if(project != null) 
		{
			project.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return projectInfoMapper.updateByPrimaryKey(project);
		}
		return 0;
	}

	@Override
	public Integer delProjectInfoReal(String projectId) 
	{
		IntlProjectInfo project = projectInfoMapper.selectByPrimaryKey(projectId);
		if(project != null) 
		{
			return projectInfoMapper.deleteByPrimaryKey(project.getProjectId());
		}
		return 0;
	}

	@Override
	public LayuiTableData selectProjectInfoByPage(LayuiTableParam param) {
		
		
		StringBuffer ordersb = new StringBuffer();
		LayuiTableParam p = new LayuiTableParam();
		p.setLimit(1000);
		if(!StringUtils.isBlank((String)param.getParam().get("reportYear")))
		{
			p.getParam().put("reportYear", param.getParam().get("reportYear"));
		}
		if(!StringUtils.isBlank((String)param.getParam().get("unitId"))) 
		{
			p.getParam().put("unitId", param.getParam().get("unitId"));
		}
		LayuiTableData applys = intlProjectApplyService.selectProjectApplyByPage(p);
		Set<String> applyIds = new HashSet<String>();
		applyIds.add("xxx");
		for(int i=applys.getData().size()-1;i>=0;i--) 
		{
			Map<String,Object> map = MyBeanUtils.java2Map(applys.getData().get(i));
			ordersb.append((ordersb.length()>0?",":"")+"'"+map.get("applyId")+"'");
			applyIds.add(map.get("applyId").toString());
		}
		
		
		
		IntlProjectInfoExample example = new IntlProjectInfoExample();
		IntlProjectInfoExample.Criteria criteria = example.createCriteria();
		if(param.getParam().get("infoName")!=null && !StringUtils.isBlank(param.getParam().get("infoName").toString())) 
		{
			criteria.andProjectNameLike("%"+param.getParam().get("infoName")+"%");
		}
		if(!StringUtils.isBlank((String)param.getParam().get("reportYear")) || !StringUtils.isBlank((String)param.getParam().get("unitId")))
		{
			criteria.andApplyIdIn(new ArrayList<String>(applyIds));
		}
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		if(ordersb.length()>0) {
			example.setOrderByClause("FIELD(apply_id,"+ordersb.toString()+") DESC");
		}
		return findByExample(param,example);
	}
	
	
	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectInfoExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<IntlProjectInfo> list = projectInfoMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectInfo> pageInfo= new PageInfo<IntlProjectInfo>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public boolean startWorkFlow(String businessId, String functionId, String workflowName, String authenticatedUserId,
			String authenticatedUserName) {
		try 
		{
			JSONObject flowJson = new JSONObject();
	    	// 业务主键id
	    	flowJson.put("businessId", businessId);
	    	flowJson.put("processInstanceName", workflowName);
	    	// 发起者信息
	    	flowJson.put("authenticatedUserId", authenticatedUserId);
	    	flowJson.put("authenticatedUserName", authenticatedUserName);
	    	// 审批完成通知发起人
	    	flowJson.put("messageUserIds", authenticatedUserId);

			// 菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
	    	flowJson.put("functionId", functionId);
	    	
	    	// 待办业务详情、最终审批同意、最终审批不同意路径
	    	flowJson.put("auditDetailsPath", "/intl_project/info_view?projectId="+businessId);
	    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-info?projectId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_PASS.getCode());
	    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-info?projectId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_RETURN.getCode());

	    	String rs = workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	if("true".equals(rs)) 
			{
	    		IntlProjectInfo plan = projectInfoMapper.selectByPrimaryKey(businessId);
	    		plan.setFlowStartStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		plan.setFlowCurrentStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		projectInfoMapper.updateByPrimaryKey(plan);
	    		
				return true;
			}
	    	return false;
		}catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean startWorkFlow(WorkflowVo workflowVo) {
		try 
		{
			JSONObject flowJson = JSON.parseObject(JSON.toJSONString(workflowVo));
			// 非必填选项, 会签时需要的属性，会签里所有的人，同意率（double类型）
	    	flowJson.put("signAuditRate", 1d); 
	    	// 待办业务详情、最终审批同意、最终审批不同意路径
			flowJson.put("auditDetailsPath", "/intl_project/info_view?projectId="+workflowVo.getBusinessId());
	    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-info?projectId="+workflowVo.getBusinessId()+"&workflow_status="+WorkFlowStatusEnum.STATUS_PASS.getCode());
	    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-info?projectId="+workflowVo.getBusinessId()+"&workflow_status="+WorkFlowStatusEnum.STATUS_RETURN.getCode());

	    	System.out.println(flowJson.toJSONString());
	    	/*String rs = workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	if("true".equals(rs)) 
			{
	    		IntlProjectInfo plan = projectInfoMapper.selectByPrimaryKey(workflowVo.getBusinessId());
	    		plan.setFlowStartStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		plan.setFlowCurrentStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		projectInfoMapper.updateByPrimaryKey(plan);
	    		
				return true;
			}*/
	    	return false;
		}catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	} 
	
	

	@Override
	public List<IntlProjectInfo> selectAllProjectInfo() 
	{
		IntlProjectInfoExample example = new IntlProjectInfoExample();
		IntlProjectInfoExample.Criteria criteria = example.createCriteria();
		
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		example.setOrderByClause("create_time desc");
		return projectInfoMapper.selectByExample(example);
	}

	@Override
	public String createProjectInfoCode() {
		IntlProjectInfoExample example = new IntlProjectInfoExample();
		List<IntlProjectInfo> applys = projectInfoMapper.selectByExample(example);
		
		return HanyuPinyinHelper.toPinyin("GJHZ_"+DateUtil.format(new Date(), DateUtil.FMT_YYYY)+"_LX_"+(100+applys.size()));
	}

	@Override
	public Integer selectCurrentYearProjectCount(String nd) 
	{
		IntlProjectInfoExample example = new IntlProjectInfoExample();
		IntlProjectInfoExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		Long count = projectInfoMapper.countByExample(example);
		return count.intValue();
	}

	
}
