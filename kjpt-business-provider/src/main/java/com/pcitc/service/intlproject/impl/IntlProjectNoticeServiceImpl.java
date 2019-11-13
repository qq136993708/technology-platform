package com.pcitc.service.intlproject.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectNotice;
import com.pcitc.base.stp.IntlProject.IntlProjectNoticeExample;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.mapper.IntlProject.IntlProjectNoticeMapper;
import com.pcitc.service.feign.WorkflowRemoteClient;
import com.pcitc.service.intlproject.IntlProjectNoticeService;

@Service("intlProjectNoticeService")
//@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class IntlProjectNoticeServiceImpl implements IntlProjectNoticeService {

	@Autowired
	private IntlProjectNoticeMapper projectNoticeMapper;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	@Override
	public LayuiTableData selectProjectNoticeList(LayuiTableParam param) 
	{
		IntlProjectNoticeExample example = new IntlProjectNoticeExample();
		IntlProjectNoticeExample.Criteria criteria = example.createCriteria();
		
		criteria.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(param.getParam().get("noticeTitle") != null && !StringUtils.isBlank(param.getParam().get("noticeTitle")+""))
		{
			criteria.andNoticeTitleLike("%"+param.getParam().get("noticeTitle")+"%");
		}
		example.setOrderByClause("create_time desc ");
		return this.findByExample(param, example);
	}

	@Override
	public IntlProjectNotice findById(String noticeId) 
	{
		return projectNoticeMapper.selectByPrimaryKey(noticeId);
	}
	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectNoticeExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<IntlProjectNotice> list = projectNoticeMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<IntlProjectNotice> pageInfo= new PageInfo<IntlProjectNotice>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public Integer saveProjectNotice(IntlProjectNotice notice) 
	{
		return projectNoticeMapper.insert(notice);
	}

	@Override
	public Integer updProjectNotice(IntlProjectNotice notice) 
	{
		return projectNoticeMapper.updateByPrimaryKey(notice);
	}

	@Override
	public Integer delProjectNotice(String noticeId) 
	{
		IntlProjectNotice notice = projectNoticeMapper.selectByPrimaryKey(noticeId);
		if(notice != null) 
		{
			return projectNoticeMapper.deleteByPrimaryKey(noticeId);
		}
		return 0;
	}

	@Override
	@Transactional
	//@TxTransaction(isStart=true)
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
	    	flowJson.put("auditDetailsPath", "/intl_project/notice_view?noticeId="+businessId);
	    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-notice?noticeId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_PASS.getCode());
	    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/project/callback-workflow-notice?noticeId="+businessId+"&workflow_status="+WorkFlowStatusEnum.STATUS_RETURN.getCode());

	    	String rs = workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	
	    	if("true".equals(rs)) 
			{
	    		IntlProjectNotice notice = projectNoticeMapper.selectByPrimaryKey(businessId);
	        	notice.setFlowStatus(WorkFlowStatusEnum.STATUS_RUNNING.getCode());
	    		updProjectNotice(notice);
	    		
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
