package com.pcitc.service.intlproject.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlantExample;
import com.pcitc.base.stp.IntlProject.IntlProjectPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectPlantExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.IdUtil;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.mapper.IntlProject.IntlProjectApplyPlantMapper;
import com.pcitc.mapper.IntlProject.IntlProjectPlantMapper;
import com.pcitc.service.feign.WorkflowRemoteClient;
import com.pcitc.service.intlproject.IntlProjectPlantService;

@Service("projectPlantService")
public class IntlProjectPlantServiceImpl implements IntlProjectPlantService {

	@Autowired
	private IntlProjectPlantMapper projectPlantMapper;
	
	@Autowired
	private IntlProjectApplyPlantMapper projectApplyPlantMapper;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	@Override
	public LayuiTableData selectProjectPlantByPage(LayuiTableParam param) 
	{
		IntlProjectPlantExample example = new IntlProjectPlantExample();
		IntlProjectPlantExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(param.getParam().get("plantName")!=null)
		{
			criteria.andPlantNameLike("%"+param.getParam().get("plantName")+"%");
		}
		example.setOrderByClause("create_time desc");
		return findByExample(param,example);
	}
	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectPlantExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<IntlProjectPlant> list = projectPlantMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectPlant> pageInfo= new PageInfo<IntlProjectPlant>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	@Override
	public IntlProjectPlant findProjectPlant(String plantId) 
	{
		IntlProjectPlantExample example = new IntlProjectPlantExample();
		example.createCriteria().andPlantIdEqualTo(plantId);
		
		return projectPlantMapper.selectByPrimaryKey(plantId);
	}

	@Override
	public Integer saveProjectPlant(IntlProjectPlant plant) 
	{
		
		return projectPlantMapper.insert(plant);
	}

	@Override
	public Integer updProjectPlant(IntlProjectPlant plant) {
		return projectPlantMapper.updateByPrimaryKey(plant);
	}

	@Override
	public Integer delProjectPlant(String plantId) 
	{
		Integer rs = 0;
		try
		{
			IntlProjectPlantExample example = new IntlProjectPlantExample();
			example.createCriteria().andPlantIdEqualTo(plantId);
			
			IntlProjectPlant apply = projectPlantMapper.selectByPrimaryKey(plantId);
			apply.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs = projectPlantMapper.updateByPrimaryKey(apply);
		}catch(Exception e){
			return rs;
		}
		return rs;
	}

	@Override
	public Integer delProjectPlantReal(String plantId) {
		Integer rs = 0;
		try
		{
			IntlProjectPlantExample example = new IntlProjectPlantExample();
			example.createCriteria().andPlantIdEqualTo(plantId);
			rs += projectPlantMapper.deleteByExample(example);
		}catch(Exception e){
			return rs;
		}
		return rs;
	}

	@Override
	public Integer startWorkFlowByPlant(String plantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addApplyPlantRel(String applyId, String plantId) 
	{
		IntlProjectApplyPlantExample rel = new IntlProjectApplyPlantExample();
		IntlProjectApplyPlantExample.Criteria relc = rel.createCriteria();
		relc.andPlantIdEqualTo(plantId);
		relc.andApplyIdEqualTo(applyId);
		List<IntlProjectApplyPlant> rs = projectApplyPlantMapper.selectByExample(rel);
		if(rs != null && rs.size() > 0){
			return 0;
		}
		IntlProjectApplyPlant obj = new IntlProjectApplyPlant();
		obj.setApplyId(applyId);
		obj.setPlantId(plantId);
		obj.setRelId(IdUtil.createIdByTime());
		
		return projectApplyPlantMapper.insert(obj);
	}

	@Override
	public Integer delApplyPlantRel(String applyId, String plantId) 
	{
		
		IntlProjectApplyPlantExample rel = new IntlProjectApplyPlantExample();
		IntlProjectApplyPlantExample.Criteria relc = rel.createCriteria();
		relc.andPlantIdEqualTo(plantId);
		relc.andApplyIdEqualTo(applyId);
		List<IntlProjectApplyPlant> rs = projectApplyPlantMapper.selectByExample(rel);
		if(rs != null && rs.size() >0){
			Integer n = 0;
			for(IntlProjectApplyPlant r:rs)
			{
				n += projectApplyPlantMapper.deleteByPrimaryKey(r.getRelId());
			}
			return n;
		}
		return 0;
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
	    	flowJson.put("auditDetailsPath", "/intl_project/plant_view?plantId="+businessId);
	    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-plant?plantId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_PASS.getCode());
	    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-plant?plantId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_RETURN.getCode());

	    	String rs = workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	if("true".equals(rs)) 
			{
	    		IntlProjectPlant plan = projectPlantMapper.selectByPrimaryKey(businessId);
	    		plan.setFlowStartStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		plan.setFlowCurrentStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		projectPlantMapper.updateByPrimaryKey(plan);
	    		
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
	public String createPlantCode() {
		IntlProjectPlantExample example = new IntlProjectPlantExample();
		
		List<IntlProjectPlant> applys = projectPlantMapper.selectByExample(example);
		
		return HanyuPinyinHelper.toPinyin("GJHZ_"+DateUtil.format(new Date(), DateUtil.FMT_YYYY)+"_JH_"+(100+applys.size()));
	}

	
}
