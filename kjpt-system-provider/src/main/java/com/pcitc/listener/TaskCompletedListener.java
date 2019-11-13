package com.pcitc.listener;

import java.util.List;
import java.util.Set;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.workflow.TaskInstanceService;

@Component("taskCompletedListener")
public class TaskCompletedListener implements ActivitiEventListener  {

	@Autowired
	private TaskInstanceService taskInstanceService;

	@Override
	public void onEvent(ActivitiEvent event) {
		ActivitiEntityEventImpl activitiEvent = (ActivitiEntityEventImpl) event;
		TaskEntity taskEntity = (TaskEntity) activitiEvent.getEntity();
		System.out.println("1====TaskCompletedListener========"+taskEntity.getId());
		System.out.println("2====TaskCompletedListener========"+activitiEvent.getProcessInstanceId());
		System.out.println("3====TaskCompletedListener========"+activitiEvent.getProcessDefinitionId());
		// 任务完成的时候，直接就指定了下一个待办任务的处理人。不用获取下一个任务节点。
		RepositoryService repositoryService = SpringContextUtil.getApplicationContext().getBean(RepositoryService.class);
		TaskService taskService = SpringContextUtil.getApplicationContext().getBean(TaskService.class);
		RuntimeService runtimeService = SpringContextUtil.getApplicationContext().getBean(RuntimeService.class);
		
		// 当前任务节点
		PvmActivity curActivity = null;
		List<String> activeIds = runtimeService.getActiveActivityIds(taskEntity.getProcessInstanceId());
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(taskEntity.getProcessInstanceId());
        for (String activeId : activeIds) {
            ActivityImpl activityImpl = processDefinition.findActivity(activeId);
            if (activityImpl != null) {
            	curActivity = activityImpl;
            }
        }
		
		
		
		// 任务完成的时候，下一个任务节点和角色关联。先获取下一个任务节点，获取任务节点的待办人（3中形式）
	}
	
	
	/**
	 * 从当前节点出发，迭代查询
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:21:51
	 */
	public PvmActivity findNextActivity(PvmActivity curActivity, String agree) {
		List<PvmTransition> nextTrans = curActivity.getOutgoingTransitions();
		List<PvmTransition> outpvmTransitions = null;
		for (PvmTransition nextTran : nextTrans) {
			PvmActivity activity = nextTran.getDestination();

			if ("userTask".equals(activity.getProperty("type").toString())) {
				
				return activity;
			} else if ("exclusiveGateway".equals(activity.getProperty("type").toString())) {
				outpvmTransitions = activity.getOutgoingTransitions();
				if (outpvmTransitions.size() == 1) {
					return outpvmTransitions.get(0).getDestination();
				} else if (outpvmTransitions.size() > 1) {
					for (PvmTransition outPvmTransition : outpvmTransitions) {
						Object object = outPvmTransition.getProperty("conditionText");
						System.out.println("======"+object.toString());
						return outPvmTransition.getDestination();
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean isFailOnException() {
		return false;
	}
}
