package com.pcitc.listener;

import java.util.Set;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pcitc.base.util.StrUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.workflow.TaskInstanceService;

@Component("taskAssignedListener")
public class TaskAssignedListener implements ActivitiEventListener {

	@Autowired
	private TaskInstanceService taskInstanceService;

	@Override
	public void onEvent(ActivitiEvent event) {
		ActivitiEntityEventImpl activitiEvent = (ActivitiEntityEventImpl) event;
		
		if (activitiEvent.getEntity().getClass().toString().contains("TaskEntity")) {
			System.out.println("1====TaskAssignedListener========"+activitiEvent.getType());
			System.out.println("2====TaskAssignedListener========"+activitiEvent.getClass());
			System.out.println("3====TaskAssignedListener========"+activitiEvent.getProcessDefinitionId());
			TaskEntity taskEntity = (TaskEntity) activitiEvent.getEntity();

			RepositoryService repositoryService = SpringContextUtil.getApplicationContext().getBean(RepositoryService.class);
			TaskService taskService = SpringContextUtil.getApplicationContext().getBean(TaskService.class);

			if (!StrUtil.isEmpty(taskEntity.getAssignee())) {
				// 指定了受理人后代理
				// String attorney =
				// delegateService.getAttorneyByAssignee(taskEntity.getAssignee(),processDefinition.getCategory());
				String attorney = "";
				if (!StrUtil.isEmpty(attorney)) {
					// System.out.println("------受理人任务委托------任务ID:" + taskEntity.getId() + "委托人:" + taskEntity.getAssignee() + ";" + "被委托人ID:" + attorney);
					// taskEntity.delegate(attorney);
				}
				// taskEntity.setAssignee(attorney);
			} else {
				
			}
		}
		
	}
	
	@Override
	public boolean isFailOnException() {
		return false;
	}
}
