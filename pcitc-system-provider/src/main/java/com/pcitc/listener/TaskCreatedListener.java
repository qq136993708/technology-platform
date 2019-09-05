package com.pcitc.listener;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.IdentityLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pcitc.base.util.StrUtil;
import com.pcitc.base.workflow.SysDelegate;
import com.pcitc.base.workflow.SysTaskDelegate;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.workflow.TaskInstanceService;

/**
 * @author zhf
 * 流转到下一个任务节点（TaskEntity）时，触发
 */
@Component("taskCreatedListener")
public class TaskCreatedListener implements ActivitiEventListener {

	@Autowired
	private TaskInstanceService taskInstanceService;

	@Override
	public void onEvent(ActivitiEvent event) {
		ActivitiEntityEventImpl activitiEvent = (ActivitiEntityEventImpl) event;
		TaskEntity taskEntity = (TaskEntity) activitiEvent.getEntity();
		// taskEntity.delegate(attorney);
		RepositoryService repositoryService = SpringContextUtil.getApplicationContext().getBean(RepositoryService.class);
		TaskService taskService = SpringContextUtil.getApplicationContext().getBean(TaskService.class);
		ProcessEngine processEngine = SpringContextUtil.getApplicationContext().getBean(ProcessEngine.class);
		
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(taskEntity.getProcessDefinitionId()).singleResult();
		
		if (!StrUtil.isEmpty(taskEntity.getAssignee())) {
			// 目前系统的审批节点不支持直接指定固定审批人，都是通过岗位、角色、机构进行的配置
			// String attorney =
			// delegateService.getAttorneyByAssignee(taskEntity.getAssignee(),processDefinition.getCategory());
			String attorney = "";
			if (!StrUtil.isEmpty(attorney)) {
				// System.out.println("------受理人任务委托------任务ID:" + taskEntity.getId() + "委托人:" + taskEntity.getAssignee() + ";" + "被委托人ID:" + attorney);
				// taskEntity.delegate(attorney);
			}
			// taskEntity.setAssignee(attorney);
		} else {
			/*if (taskEntity.getTaskDefinition().getKey() != null && taskEntity.getTaskDefinition().getKey().equals("start")) {
				// 第一个任务节点（任务发起人自动处理 ）
			} else {
				
			}*/
			System.out.println("------任务委托------任务ID:" + taskEntity.getId());
			// 只有一个候选人的代理，委托生效
			List<IdentityLink> identityLinks = processEngine.getTaskService().getIdentityLinksForTask(taskEntity.getId());
			List<String> userIds = taskInstanceService.getCandidateUserForTask(identityLinks);
			if (userIds.size() == 1) {
				System.out.println("------任务委托------节点只有一个审批人，委托生效---:" + userIds);
				String assignee = userIds.get(0);
				List<SysDelegate> attorneyList = taskInstanceService.getAttorneyByAssignee(assignee, processDefinition.getCategory());
				// 查询这个时间段是否有被委托人，如果没有的话，此任务还是默认到委托人待办列表中
				if (attorneyList != null && attorneyList.size() > 0) {
					
					String attorney = attorneyList.get(0).getAttorneyCode();
					String delegateId = attorneyList.get(0).getDelegateId();
					System.out.println("------任务委托------委托人:" + attorney);
					System.out.println("------任务委托------被委托人:" + assignee);
					if (!StrUtil.isEmpty(attorney)) {
						taskService.addCandidateUser(taskEntity.getId(), attorney);
						//不调用delegateTask，delegateTask会把原审批人的待办任务去掉。调用addCandidateUser，本质上只是动态添加一个审批人
						//taskService.delegateTask(taskEntity.getId(), assignee);
						//taskEntity.delegate(attorney);
						System.out.println("------任务委托------委托记录，方便日志和取消:" + attorney);
						// 把委托后，调用此监听器产生的委托任务都保存起来
						SysTaskDelegate record = new SysTaskDelegate();
						record.setTaskId(taskEntity.getId());
						record.setDelegateId(delegateId);
						record.setCreateDate(new Date());
						record.setStatus("1");
						record.setTaskDelegateId(UUID.randomUUID().toString().replaceAll("-", ""));
						taskInstanceService.insertTaskDelegate(record);
					}
				}
				
			}
		}
	}

	@Override
	public boolean isFailOnException() {
		return false;
	}
	
}
