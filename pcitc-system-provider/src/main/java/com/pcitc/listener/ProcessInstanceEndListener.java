package com.pcitc.listener;

import java.util.Date;
import java.util.UUID;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.history.HistoricVariableInstanceQuery;

import com.pcitc.base.system.SysMessage;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.system.SysMessageService;

public class ProcessInstanceEndListener implements ExecutionListener {

	public void notify(DelegateExecution execution) throws Exception {
		String eventName = execution.getEventName();
		
		System.out.println("process istance end========="+execution.getId());
		System.out.println("process istance end========="+execution.getBusinessKey());
		System.out.println("process istance end========="+execution.getProcessBusinessKey());
		System.out.println("process istance end========="+execution.getCurrentActivityId());
		System.out.println("process istance end========="+execution.getCurrentActivityName());
		System.out.println("process istance end========="+execution.getEngineServices().getHistoryService());
		
		
		// start
		if ("start".equals(eventName)) {
			System.out.println("process istance start=========");
		} else if ("end".equals(eventName)) {
			
			HistoricVariableInstanceQuery hviq = execution.getEngineServices().getHistoryService().createHistoricVariableInstanceQuery().processInstanceId(execution.getProcessInstanceId());
			HistoricVariableInstance detail = hviq.variableName("auditDetailsPath").singleResult();
			HistoricVariableInstance messageUserIds = hviq.variableName("messageUserIds").singleResult();
			HistoricVariableInstance messagePostCodes = hviq.variableName("messagePostCodes").singleResult();
			HistoricVariableInstance messageRoleCodes = hviq.variableName("messageRoleCodes").singleResult();
			HistoricVariableInstance userName = hviq.variableName("authenticatedUserName").singleResult();
			HistoricVariableInstance taskName = hviq.variableName("processInstanceName").singleResult();
			
			// 保存进系统公告数据中（个人类型公告）
			SysMessageService messageService = SpringContextUtil.getApplicationContext().getBean(SysMessageService.class);
			System.out.println("message ========process istance end========="+messageService);
			SysMessage sysMessage = new SysMessage();
			sysMessage.setDataId(UUID.randomUUID().toString().replace("-", ""));
			sysMessage.setMessageType("审批消息");
			sysMessage.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
			sysMessage.setUpdateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
			sysMessage.setIsRead("0");
			sysMessage.setReadTotal(0);
			sysMessage.setSts("1");
			sysMessage.setAuditStatus("1");
			if (messageUserIds != null) {
				String userIds = messageUserIds.getValue() != null ? messageUserIds.getValue().toString() : "";
				sysMessage.setUserId(userIds); //可能有多个
			}
			if (detail != null) {
				sysMessage.setMessageUrl(detail.getValue() != null ? detail.getValue().toString() : "");
			}
			if (taskName != null) {
				sysMessage.setMessageTitle(taskName.getValue() != null ? taskName.getValue().toString() : "");
			}
			if (messagePostCodes != null) {
				sysMessage.setPostCode(messagePostCodes.getValue() != null ? ","+messagePostCodes.getValue().toString()+"," : "");
			}
			if (messageRoleCodes != null) {
				sysMessage.setRoleCode(messageRoleCodes.getValue() != null ? ","+messageRoleCodes.getValue().toString()+"," : "");
			}
			
			messageService.insertSysMessage(sysMessage);
		}
	}

}
