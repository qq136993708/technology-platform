package com.pcitc.service.intlproject.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.DataTableParam;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.enums.FlowStatusEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectApply;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyExample;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlantExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.HanyuPinyinHelper;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.mapper.IntlProject.IntlProjectApplyMapper;
import com.pcitc.mapper.IntlProject.IntlProjectApplyPlantMapper;
import com.pcitc.service.feign.WorkflowRemoteClient;
import com.pcitc.service.intlproject.IntlProjectApplyService;

@Service("projectApplyService")
public class IntlProjectApplyServiceImpl implements IntlProjectApplyService {

	@Autowired
	private IntlProjectApplyMapper projectApplyMapper;
	
	@Autowired
	private IntlProjectApplyPlantMapper projectApplyPlantMapper;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	@Override
	public Integer saveProjectApply(IntlProjectApply apply) 
	{
		return projectApplyMapper.insert(apply);
	}

	@Override
	public Integer updProjectApply(IntlProjectApply apply) 
	{
		IntlProjectApply oldApply = projectApplyMapper.selectByPrimaryKey(apply.getApplyId());
		if(oldApply != null)
		{
			MyBeanUtils.copyPropertiesIgnoreNull(apply, oldApply);
		}
		return projectApplyMapper.updateByPrimaryKey(oldApply);
	}

	@Override
	public Integer delProjectApply(String applyId) 
	{
		Integer rs = 0;
		try
		{
			IntlProjectApply apply = projectApplyMapper.selectByPrimaryKey(applyId);
			if(apply != null) {
				apply.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
				rs = projectApplyMapper.updateByPrimaryKey(apply);
			}
		}catch(Exception e){
			return rs;
		}
		return rs;
	}

	@Override
	public Integer delProjectApplyReal(String applyId) 
	{
		Integer rs = 0;
		try
		{
			IntlProjectApply apply = projectApplyMapper.selectByPrimaryKey(applyId);
			if(apply != null) 
			{
				IntlProjectApplyPlantExample example = new IntlProjectApplyPlantExample();
				IntlProjectApplyPlantExample.Criteria relc = example.createCriteria();
				relc.andApplyIdEqualTo(applyId);
				List<IntlProjectApplyPlant> rels = projectApplyPlantMapper.selectByExample(example);
				if(rels != null) {
					for(IntlProjectApplyPlant rel:rels)
					{
						rs += projectApplyPlantMapper.deleteByPrimaryKey(rel.getRelId());
					}
				}
				rs += projectApplyMapper.deleteByPrimaryKey(applyId);
			}
		}catch(Exception e){
			return rs;
		}
		return rs;
	}

	@Override
	public IntlProjectApply findProjectApply(String applyId) 
	{
		return projectApplyMapper.selectByPrimaryKey(applyId);
	}

	@Override
	public Integer startWorkFlowByApply(String applyId) 
	{
		IntlProjectApply apply = projectApplyMapper.selectByPrimaryKey(applyId);
		if(apply != null){
			apply.setFlowStartStatus(FlowStatusEnum.FLOW_START_STATUS_YES.getCode());
			return projectApplyMapper.updateByPrimaryKey(apply);
		}
		return 0;
	}

	@Override
	public PageInfo<IntlProjectApply> findByConn(DataTableParam dataTableParam) 
	{
		
		int pageLength = dataTableParam.getiDisplayLength();
		int startPage = dataTableParam.getiDisplayStart();
		
		IntlProjectApplyExample example = new IntlProjectApplyExample();
		com.pcitc.base.stp.IntlProject.IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		startPage = startPage/pageLength+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(startPage, pageLength);
		// 2、执行查询
		List<IntlProjectApply> list = projectApplyMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectApply> pageInfo = new PageInfo<IntlProjectApply>(list);
		// 4、封装需要返回的分页实体
		/*JSONObject retJson = new JSONObject();
		retJson.put("totalCount", pageInfo.getTotal());
		retJson.put("list", list);
		return retJson;*/
		return pageInfo;
	}

	@Override
	public LayuiTableData findNotJoinPlantApply(LayuiTableParam param) 
	{
		
		String plantId = param.getParam().get("plantId").toString();
		
		IntlProjectApplyPlantExample rel = new IntlProjectApplyPlantExample();
		IntlProjectApplyPlantExample.Criteria relc = rel.createCriteria();
		relc.andPlantIdEqualTo(plantId);
		List<IntlProjectApplyPlant> rs = projectApplyPlantMapper.selectByExample(rel);
		List<String> applyIds = new ArrayList<String>();
		applyIds.add("0");//避免空对象
		for(IntlProjectApplyPlant r:rs){
			applyIds.add(r.getApplyId());
		}
		
		
		IntlProjectApplyExample example = new IntlProjectApplyExample();
		IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		criteria.andFlowEndStatusEqualTo(FlowStatusEnum.FLOW_END_STATUS_YES.getCode());
		criteria.andFlowCurrentStatusEqualTo(FlowStatusEnum.FLOW_CURRENT_STATUS_PASS.getCode());
		if(param.getParam().get("applyTitle") != null) {
			criteria.andApplyTitleLike("%"+param.getParam().get("applyTitle")+"%");
		}
		criteria.andApplyIdNotIn(applyIds);
		
		return findByExample(param, example);
	}

	@Override
	public LayuiTableData findJoinPlantApply(LayuiTableParam param) 
	{
		
		String plantId = param.getParam().get("plantId").toString();
		IntlProjectApplyPlantExample rel = new IntlProjectApplyPlantExample();
		IntlProjectApplyPlantExample.Criteria relc = rel.createCriteria();
		relc.andPlantIdEqualTo(plantId);
		List<IntlProjectApplyPlant> rs = projectApplyPlantMapper.selectByExample(rel);
		List<String> applyIds = new ArrayList<String>();
		applyIds.add("0");//避免空对象
		for(IntlProjectApplyPlant r:rs){
			applyIds.add(r.getApplyId());
		}
		
		
		IntlProjectApplyExample example = new IntlProjectApplyExample();
		IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		criteria.andFlowEndStatusEqualTo(FlowStatusEnum.FLOW_END_STATUS_YES.getCode());
		criteria.andFlowCurrentStatusEqualTo(FlowStatusEnum.FLOW_CURRENT_STATUS_PASS.getCode());
		criteria.andApplyIdIn(applyIds);
		
		return this.findByExample(param, example);
	}

	@Override
	public LayuiTableData selectProjectApplyByPage(LayuiTableParam param) 
	{
		IntlProjectApplyExample example = new IntlProjectApplyExample();
		IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(param.getParam().get("applyName") !=null && !StringUtils.isBlank(param.getParam().get("applyName").toString())) 
		{
			criteria.andApplyNameLike("%"+param.getParam().get("applyName")+"%");
		}
		if(param.getOrderClause() != null) {
			example.setOrderByClause(param.getOrderClause());
		}
		example.setOrderByClause("create_time desc");
		return findByExample(param,example);
	}
	@Override
	public LayuiTableData findJoinPlantAndPassApply(LayuiTableParam param) 
	{
		IntlProjectApplyExample example = new IntlProjectApplyExample();
		IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		return findByExample(param,example);
	}
	
	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectApplyExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<IntlProjectApply> list = projectApplyMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectApply> pageInfo= new PageInfo<IntlProjectApply>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public List<IntlProjectApply> selectProjectApplyList(Map<String, Object> params) 
	{
		IntlProjectApplyExample example = new IntlProjectApplyExample();
		IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		example.setOrderByClause("create_time desc");
		return projectApplyMapper.selectByExample(example);
	}

	@Override
	public String createProjectApplyCode(IntlProjectApply apply) 
	{
		IntlProjectApplyExample example = new IntlProjectApplyExample();
		//IntlProjectApplyExample.Criteria criteria = example.createCriteria();
		//criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		List<IntlProjectApply> applys = projectApplyMapper.selectByExample(example);
		return HanyuPinyinHelper.toPinyin("KJGJHZ_"+DateUtil.format(new Date(), DateUtil.FMT_YYYY)+"_"+(1000+applys.size()));
	}
	@Override
	@Transactional
	public boolean startWorkFlow(String businessId, String functionId, String workflowName,String authenticatedUserId,String authenticatedUserName) {
		
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
	    	flowJson.put("auditDetailsPath", "/intl_project/apply_view?applyId="+businessId);
	    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-apply?applyId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_PASS.getCode());
	    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-apply?applyId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_RETURN.getCode());

	    	String rs = workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	if("true".equals(rs)) 
			{
	    		IntlProjectApply apply = projectApplyMapper.selectByPrimaryKey(businessId);
	    		apply.setFlowStartStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		apply.setFlowCurrentStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		projectApplyMapper.updateByPrimaryKey(apply);
	    		
				return true;
			}
	    	return false;
		}catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	} 
}
