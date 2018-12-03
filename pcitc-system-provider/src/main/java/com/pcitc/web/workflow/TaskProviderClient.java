package com.pcitc.web.workflow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.javax.el.ExpressionFactory;
import org.activiti.engine.impl.javax.el.ValueExpression;
import org.activiti.engine.impl.juel.ExpressionFactoryImpl;
import org.activiti.engine.impl.juel.SimpleContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.DelegationState;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.FileUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.workflow.ActivityVo;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.SysDelegate;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.SysTaskDelegate;
import com.pcitc.base.workflow.TaskDoneVo;
import com.pcitc.base.workflow.TaskVo;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.service.system.UserService;
import com.pcitc.service.workflow.TaskInstanceService;
import com.pcitc.service.workflow.WorkflowInstanceService;

@Api(value = "Task-API", description = "任务相关的接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TaskProviderClient {

	// 文件上传路径
	@Value("${spring.http.multipart.location}")
	private String uploadPath;

	@Autowired
	private TaskInstanceService taskInstanceService;

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private WorkflowInstanceService workflowInstanceService;

	/**
	 * 查询任务委托单信息
	 * 
	 * @author zhf
	 * @date 2018年5月3日 下午2:09:43
	 */
	@ApiOperation(value = "委托单list查询", notes = "查询的是某个人的委托单，不是所有人的委托单")
	@RequestMapping(value = "/task-provider/assignees/delegates", method = RequestMethod.POST)
	public Object selectDelegateByPage(@RequestBody LayuiTableParam param) {
		// System.out.println("1selectDelegateByPage==============查询的是某个人的委托单，不是所有人的委托单");
		Object tem = taskInstanceService.selectDelegateByPage(param);
		return tem;
	}

	/**
	 * 获取当前人最近一周已办事项
	 * 
	 * @author zhf
	 * @date 2018年5月3日 下午2:09:43
	 */
	@ApiOperation(value = "已办事项总数查询", notes = "默认查询最近一周时间的已办事项")
	@RequestMapping(value = "/task-provider/done-task-count", method = RequestMethod.POST)
	public JSONObject getDoneTaskCount(@RequestBody HashMap<String, String> map) {
		String userId = null;
		JSONObject retJson = new JSONObject();
		System.out.println("jsonStr======" + map);
		if (map != null && map.get("userId") != null && !map.get("userId").equals("")) {
			userId = map.get("userId").toString();
		} else {
			retJson.put("doneTaskCount", "0");
		}

		HistoricTaskInstanceQuery query = historyService.createHistoricTaskInstanceQuery().taskInvolvedUser(userId).finished();
		long count = query.taskCreatedAfter(DateUtil.dateAdd(new Date(), -Integer.parseInt("7"))).count();
		System.out.println("11=========" + count + "---------------" + userId);
		retJson.put("doneTaskCount", count);
		return retJson;
	}

	@ApiOperation(value = "待办事项总数查询", notes = "首页查询使用")
	@RequestMapping(value = "/task-provider/pending-task-count", method = RequestMethod.POST)
	public JSONObject getPendingTaskCount(@RequestBody HashMap<String, String> map) {
		String userId = null;
		JSONObject retJson = new JSONObject();
		System.out.println("1jsonStr======" + map);
		if (map != null && map.get("userId") != null && !map.get("userId").equals("")) {
			userId = map.get("userId").toString();
		} else {
			retJson.put("pendingTaskCount", "0");
		}
		System.out.println("2jsonStr======" + userId);
		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		long count = query.count();
		System.out.println("3jsonStr======" + count);
		retJson.put("pendingTaskCount", count);
		return retJson;
	}

	/**
	 * 批量删除委托单,id中有多个，修改状态位来删除，不是物理删除
	 * 
	 * @author zhf
	 * @date 2018年5月3日 下午2:08:57
	 */
	@ApiOperation(value = "删除委托单", notes = "支持删除多个委托单，delegateId通过‘,’隔开")
	@RequestMapping(value = "/task-provider/delegates", method = RequestMethod.DELETE)
	public Integer deleteDelegate(@RequestBody SysDelegate delegate) {

		String[] delegateIds = delegate.getDelegateId().split(",");
		int rInt = 0;
		// 因为不存在太多委托，所以暂时不考虑批量删除的效率
		for (int i = 0; i < delegateIds.length; i++) {
			delegate.setDelegateId(delegateIds[i]);
			delegate.setStatus("0");

			rInt = rInt + taskInstanceService.deleteDelegate(delegate);

			// 当初委托时（之前）的待办任务都分配给被委托人了，现在把这些待办任务重新归到委托人名下
			// 如果在取消委托之前，已经办理的委托任务就不处理了
			// 获取委托时，被委托人接收的所有任务和委托后监听器分配给被委托人的任务。这些任务已经处理的不能回收，其他的取消重新指派给委托人
			List<SysTaskDelegate> list = taskInstanceService.getDelegateHistoryTask(delegate.getDelegateId());
			for (SysTaskDelegate std : list) {
				// 查询taskId是否已经处理
				List<Task> taskList = taskService.createTaskQuery().taskId(std.getTaskId()).active().list();
				if (taskList == null || taskList.size() == 0) {
				} else {
					// 把任务还原成原委托人
					taskService.setAssignee(taskList.get(0).getId(), delegate.getAssigneeCode());
					std.setStatus("0");
					taskInstanceService.deleteTaskDelegate(std);
				}
			}

		}

		return rInt;
	}

	/**
	 * 待办任务查询
	 * 
	 * @author zhf
	 * @throws Exception
	 * @date 2018年5月4日 下午3:53:05
	 */
	@ApiOperation(value = "查询待办任务", notes = "根据用户userId来获取待办任务，返回包含总数和list<TaskVo>的json对象")
	@RequestMapping(value = "/task-provider/pending-page", method = RequestMethod.POST)
	public Object selectPendingList(@RequestBody LayuiTableParam param) {

		int limit = 15;
		int page = 1;
		String taskName = null;

		String userId = param.getParam().get("userId").toString();
		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		if (param.getLimit() != null && !StrUtil.isBlankOrNull(param.getLimit().toString())) {
			limit = Integer.parseInt(param.getLimit().toString());
		}
		if (param.getPage() != null && !StrUtil.isBlankOrNull(param.getPage().toString())) {
			page = Integer.parseInt(param.getPage().toString());
		}
		if (param.getParam().get("taskName") != null && !StrUtil.isBlankOrNull(param.getParam().get("taskName").toString())) {
			taskName = "%" + param.getParam().get("taskName").toString() + "%";
			query = query.taskNameLike(taskName);
		}
		if (param.getParam().get("dateFlag") != null && !StrUtil.isBlankOrNull(param.getParam().get("dateFlag").toString())) {
			query.taskCreatedAfter(DateUtil.dateAdd(new Date(), -Integer.parseInt(param.getParam().get("dateFlag").toString())));
			if (param.getParam().get("dateFlag").toString().equals("7")) {
				query.taskCreatedBefore(DateUtil.dateAdd(new Date(), -3));
			}
			if (param.getParam().get("dateFlag").toString().equals("30")) {
				query.taskCreatedBefore(DateUtil.dateAdd(new Date(), -7));
			}
			
		}
		
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			if (param.getOrderKey().toString().equals("name")) {
				query = query.orderByTaskName();
				if (param.getOrderType().toString().equals("asc")) {
					query = query.asc();
				} else if (param.getOrderType().toString().equals("desc")) {
					query = query.desc();
				} else {
					query = query.desc();
				}
			} else if (param.getOrderKey().toString().equals("createTime")) {
				query = query.orderByTaskCreateTime();
				if (param.getOrderType().toString().equals("asc")) {
					query = query.asc();
				} else if (param.getOrderType().toString().equals("desc")) {
					query = query.desc();
				} else {
					query = query.desc();
				}
			} else {
				query = query.orderByTaskCreateTime().desc();
			}
		} else {
			query = query.orderByTaskCreateTime().desc();
		}

		List<Task> taskList;
		long count;

		// 根据userId查询，谁曾经委托过他。把委托人的待办任务也都查询出来
		count = query.count();
		taskList = query.listPage(limit * (page - 1), limit);

		List<TaskVo> voList = new ArrayList<TaskVo>();
		for (Task task : taskList) {
			TaskVo vo = new TaskVo();
			BeanUtils.copyProperties(task, vo);
			// ProcessInstance processInstance =
			// runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
			// vo.setProcessInstanceName(processInstance.getName());

			HistoricProcessInstance historicProcessInstance = (HistoricProcessInstance) historyService.createHistoricProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
			if (!StrUtil.isBlankOrNull(historicProcessInstance.getStartUserId())) {
				SysUser temUser = userService.selectUserByUserId(historicProcessInstance.getStartUserId());
				vo.setStartUserName(temUser != null ? temUser.getUserDisp() : "");
			}
			vo.setProcessInstanceName(historicProcessInstance.getName());
			vo.setProcessDefinitionName(historicProcessInstance.getProcessDefinitionName());
			vo.setProcessDefinitionKey(historicProcessInstance.getProcessDefinitionKey());

			/*
			 * HistoricTaskInstance historicTaskInstance =
			 * (HistoricTaskInstance)
			 * historyService.createHistoricTaskInstanceQuery
			 * ().taskId(task.getId()).singleResult(); if (historicTaskInstance
			 * != null) { vo.setAssigneeName(historicTaskInstance.getAssignee()
			 * != null ? historicTaskInstance.getAssignee() : ""); }
			 */

			// 处理历史上已经发生过的节点，包括开始节点,按时间倒序
			List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(task.getProcessInstanceId()).orderByHistoricActivityInstanceEndTime().desc().list();
			for (HistoricActivityInstance historicActivityInstance : historicActivityInstanceList) {
				// 过滤掉非用户任务
				if (!historicActivityInstance.getActivityType().equals("userTask"))
					continue;
				System.out.println("1historicActivityInstance=================" + historicActivityInstance);
				System.out.println("2historicActivityInstance=================" + historicActivityInstance.getTaskId());
				if (historicActivityInstance.getTaskId() != null) {
					// 获取审批意见、审批时间
					List<Comment> comments = taskService.getTaskComments(historicActivityInstance.getTaskId());
					if (comments != null && comments.size() > 0) {
						for (Comment comment : comments) {
							vo.setAuditRemarks(comment.getFullMessage());
						}
					}
					List<HistoricIdentityLink> temList = historyService.getHistoricIdentityLinksForTask(historicActivityInstance.getTaskId());
					if (temList != null && temList.size() > 0) {
						for (int i = 0; i < temList.size(); i++) {
							HistoricIdentityLink identityLink = temList.get(i);

							if (!StrUtil.isBlankOrNull(identityLink.getUserId())) {
								SysUser temUser = userService.selectUserByUserId(identityLink.getUserId());
								vo.setAuditor(temUser != null ? temUser.getUserDisp() : "");
							}

						}
					}

					vo.setAuditDate(DateUtil.format(historicActivityInstance.getEndTime(), DateUtil.FMT_SS));
				}

				break;
			}

			voList.add(vo);
		}

		LayuiTableData data = new LayuiTableData();
		data.setData(voList);
		data.setCount((int) count);

		return data;
	}

	/**
	 * 获取一个任务的详情
	 * 
	 * @param task
	 * @return
	 */
	private TaskVo setTaskVo(HistoricTaskInstance task) {
		TaskVo taskVo = new TaskVo();
		taskVo.setId(task.getId());
		taskVo.setName(task.getName());
		// getUserName(task.getAssignee())
		taskVo.setAssigneeName(task.getAssignee() != null ? task.getAssignee() : "");
		// taskBo.setStartTime(task.getStartTime() != null ?
		// DateTimeUtil.getFormatDate(task.getStartTime(),
		// WorkflowConstants.DATEFORMATSTRING) : "");

		ProcessDefinition processDefinition = (ProcessDefinition) repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
		// taskBo.setBusinessName(processDefinition.getName());
		// taskBo.setWorkflowName(processDefinition.getKey());
		// 流程状态
		HistoricProcessInstance historicProcessInstance = (HistoricProcessInstance) historyService.createHistoricProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
		// 得到业务id==historicProcessInstance.getBusinessKey()
		// 发起人姓名
		if (historicProcessInstance.getStartUserId() != null)
			taskVo.setStartUserName(historicProcessInstance.getStartUserId());
		return taskVo;
	}

	/**
	 * 已办任务查询（每行代表一个任务）
	 * 
	 * @author zhf
	 * @date 2018年5月4日 下午3:53:05
	 */
	@ApiOperation(value = "查询已办任务", notes = "根据用户userId来获取已办任务，返回包含总数和list<TaskDoneVo>的json对象")
	@RequestMapping(value = "/task-provider/done-task-page", method = RequestMethod.POST)
	public Object selectDoneTaskList(@RequestBody LayuiTableParam param) {
		int limit = 15;
		int page = 1;
		String processName = null;
		String userId = param.getParam().get("userId").toString();

		HistoricTaskInstanceQuery query = historyService.createHistoricTaskInstanceQuery().taskInvolvedUser(userId).finished();
		if (param.getLimit() != null && !StrUtil.isBlankOrNull(param.getLimit().toString())) {
			limit = Integer.parseInt(param.getLimit().toString());
		}
		if (param.getPage() != null && !StrUtil.isBlankOrNull(param.getPage().toString())) {
			page = Integer.parseInt(param.getPage().toString());
		}
		if (param.getParam().get("processName") != null && !StrUtil.isBlankOrNull(param.getParam().get("processName").toString())) {
			processName = "%" + param.getParam().get("processName").toString() + "%";
			query = query.taskNameLike(processName);
		}
		if (param.getParam().get("dateFlag") != null && !StrUtil.isBlankOrNull(param.getParam().get("dateFlag").toString())) {
			query.taskCreatedAfter(DateUtil.dateAdd(new Date(), -Integer.parseInt(param.getParam().get("dateFlag").toString())));
			if (param.getParam().get("dateFlag").toString().equals("7")) {
				query.taskCreatedBefore(DateUtil.dateAdd(new Date(), -3));
			}
			if (param.getParam().get("dateFlag").toString().equals("30")) {
				query.taskCreatedBefore(DateUtil.dateAdd(new Date(), -7));
			}
		}

		List<HistoricTaskInstance> taskInstances = query.orderByTaskCreateTime().desc().listPage(limit * (page - 1), limit);
		long count = query.count();
		System.out.println("=====" + param.getParam().get("dateFlag").toString() + "====" + count);
		List<TaskDoneVo> voList = new ArrayList<TaskDoneVo>();
		for (HistoricTaskInstance taskInstance : taskInstances) {
			TaskDoneVo vo = new TaskDoneVo();
			BeanUtils.copyProperties(taskInstance, vo);

			HistoricProcessInstance historicProcessInstance = (HistoricProcessInstance) historyService.createHistoricProcessInstanceQuery().processInstanceId(taskInstance.getProcessInstanceId()).singleResult();
			if (historicProcessInstance.getStartUserId() != null) {
				SysUser temUser = userService.selectUserByUserId(historicProcessInstance.getStartUserId());
				vo.setStartUserName(temUser != null ? temUser.getUserDisp() : "");
				vo.setStartTime(historicProcessInstance.getStartTime());
			}

			// 处理历史上已经发生过的节点，包括开始节点,按时间倒序
			List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(taskInstance.getProcessInstanceId()).orderByHistoricActivityInstanceEndTime().desc().list();
			for (HistoricActivityInstance historicActivityInstance : historicActivityInstanceList) {
				// 过滤掉非用户任务
				if (!historicActivityInstance.getActivityType().equals("userTask"))
					continue;
				// 获取审批意见
				if (historicActivityInstance.getTaskId() != null) {
					List<Comment> comments = taskService.getTaskComments(historicActivityInstance.getTaskId());
					if (comments != null && comments.size() > 0) {
						for (Comment comment : comments) {
							vo.setAuditRemarks(comment.getFullMessage());
						}
					}
					break;
				}
			}

			vo.setProcessDefinitionName(historicProcessInstance.getName());
			voList.add(vo);
		}

		LayuiTableData data = new LayuiTableData();
		data.setData(voList);
		data.setCount((int) count);

		return data;
	}

	/**
	 * 已办任务查询（每行代表一个流程实例）
	 * 
	 * @author zhf
	 * @date 2018年5月4日 下午3:53:05
	 */
	@ApiOperation(value = "查询已办流程实例", notes = "根据用户userId来获取已办流程实例，返回包含总数和list<TaskDoneVo>的json对象")
	@RequestMapping(value = "/task-provider/done-instance-page", method = RequestMethod.POST)
	public Object selectDoneInstanceList(@RequestBody LayuiTableParam param) {
		int limit = 15;
		int page = 1;
		String processName = null;
		String userId = param.getParam().get("userId").toString();

		HistoricTaskInstanceQuery query = historyService.createHistoricTaskInstanceQuery().taskInvolvedUser(userId).finished();
		if (param.getLimit() != null && !StrUtil.isBlankOrNull(param.getLimit().toString())) {
			limit = Integer.parseInt(param.getLimit().toString());
		}
		if (param.getPage() != null && !StrUtil.isBlankOrNull(param.getPage().toString())) {
			page = Integer.parseInt(param.getPage().toString());
		}
		if (param.getParam().get("processName") != null && !StrUtil.isBlankOrNull(param.getParam().get("processName").toString())) {
			processName = "%" + param.getParam().get("processName").toString() + "%";
			query = query.processDefinitionNameLike(processName);
		}
		
		// List<HistoricTaskInstance> taskInstances =
		// query.orderByTaskCreateTime().desc().listPage(limit*(page-1)+1,
		// limit);
		LayuiTableData retData = new LayuiTableData();
		List<TaskDoneVo> voList = new ArrayList<TaskDoneVo>();

		Set<String> processInstanceIdSet = new HashSet<String>();
		List<HistoricTaskInstance> taskInstances = query.orderByTaskCreateTime().desc().list();
		for (HistoricTaskInstance taskInstance : taskInstances) {
			processInstanceIdSet.add(taskInstance.getProcessInstanceId());
		}

		if (processInstanceIdSet.isEmpty()) {
			retData.setData(voList);
			retData.setCount(0);
			return retData;
		}

		HistoricProcessInstanceQuery realQuery = historyService.createHistoricProcessInstanceQuery().processInstanceIds(processInstanceIdSet);
		if (!StrUtil.isEmpty(userId))
			realQuery.involvedUser(userId);
		
		if (param.getParam().get("status") != null && !StrUtil.isBlankOrNull(param.getParam().get("status").toString())) {
			if (param.getParam().get("status").toString().equals("finished")) {
				realQuery = realQuery.finished();
			}
			if (param.getParam().get("status").toString().equals("executing")) {
				realQuery = realQuery.unfinished();
			}
		}
		
		if (param.getParam().get("startTime") != null && !StrUtil.isBlankOrNull(param.getParam().get("startTime").toString())) {
			realQuery = realQuery.startedAfter(DateUtil.strToDate(param.getParam().get("startTime").toString(), DateUtil.FMT_SS));
		}
		if (param.getParam().get("endTime") != null && !StrUtil.isBlankOrNull(param.getParam().get("endTime").toString())) {
			realQuery = realQuery.startedBefore(DateUtil.strToDate(param.getParam().get("endTime").toString(), DateUtil.FMT_SS));
		}
		
		long count = realQuery.count();
		
		/*
		 * for (HistoricTaskInstance taskInstance : taskInstances) { TaskDoneVo
		 * vo = new TaskDoneVo(); BeanUtils.copyProperties(taskInstance, vo);
		 * 
		 * HistoricProcessInstance historicProcessInstance =
		 * (HistoricProcessInstance)
		 * historyService.createHistoricProcessInstanceQuery
		 * ().processInstanceId(
		 * taskInstance.getProcessInstanceId()).singleResult(); if
		 * (historicProcessInstance.getStartUserId() != null)
		 * vo.setStartUserName(historicProcessInstance.getStartUserId());
		 * vo.setProcessDefinitionName(historicProcessInstance.getName());
		 * voList.add(vo); }
		 */

		List<HistoricProcessInstance> processInstanceList = realQuery.orderByProcessInstanceStartTime().desc().listPage(limit * (page - 1), limit);
		for (HistoricProcessInstance processInstance : processInstanceList) {
			TaskDoneVo vo = new TaskDoneVo();
			BeanUtils.copyProperties(processInstance, vo);

			// 是否办结
			if (processInstance.getEndTime() != null) {
				vo.setFlowState(Constants.STATE_INSTANCE_DONE);
			} else {
				vo.setFlowState(Constants.STATE_INSTANCE_DOING);
			}
			
			if (processInstance.getStartUserId() != null) {
				SysUser temUser = userService.selectUserByUserId(processInstance.getStartUserId());
				vo.setStartUserName(temUser != null ? temUser.getUserDisp() : "");
			}
			voList.add(vo);
		}

		retData.setData(voList);
		retData.setCount((int) count);
		return retData;
	}

	/**
	 * 任务处理，主要是任务处理时间、处理意见、是否同意
	 * 
	 * @author zhf
	 * @throws Exception
	 * @date 2018年5月4日 下午3:53:05
	 */
	@ApiOperation(value = "任务处理", notes = "任务处理时间、处理意见、是否同意，考虑委托等情况")
	@RequestMapping(value = "/task-provider/task/complete", method = RequestMethod.POST)
	public JSONObject completeTask(@RequestBody WorkflowVo workflowVo) throws Exception {

		Task task = taskService.createTaskQuery().taskId(workflowVo.getTaskId()).singleResult();

		// 下一个环节需要用的变量等属性，根据variables中的agree属性来决定流程走向
		Map<String, Object> globalVar = workflowVo.getVariables();

		// 把历史变量赋值进去
		Map<String, Object> oldVar = taskService.getVariables(workflowVo.getTaskId());
		for (String key : oldVar.keySet()) {
			if (!key.equals("agree") && !key.equals("comment") && !key.equals("auditor")) {
				globalVar.put(key, oldVar.get(key));
			}
		}

		// 审批意见
		taskService.addComment(workflowVo.getTaskId(), task.getProcessInstanceId(), globalVar.get("comment") != null ? globalVar.get("comment").toString() : "");
		// 会签时的处理，会签条件（agreeCount）的处理
		String currentExecutionId = task.getExecutionId();
		if (runtimeService.getVariable(currentExecutionId, "loopCounter") != null) {
			if (globalVar.get("agree") != null && globalVar.get("agree").toString().equals("1")) {
				// 判断会签里面，有几个同意的，同意一次+1
				if (runtimeService.getVariable(currentExecutionId, "agreeCount") != null) {
					Integer agreeCount = (Integer) runtimeService.getVariable(currentExecutionId, "agreeCount");
					runtimeService.setVariable(currentExecutionId, "agreeCount", agreeCount + 1);
					globalVar.put("agreeCount", agreeCount + 1);
					// System.out.println(currentExecutionId+"----------1当前任务："+runtimeService.getVariable(currentExecutionId,
					// "agreeCount"));
				} else {
					runtimeService.setVariable(currentExecutionId, "agreeCount", 1);
					globalVar.put("agreeCount", 1);
					// System.out.println(currentExecutionId+"----------2当前任务："+runtimeService.getVariable(currentExecutionId,
					// "agreeCount"));
				}

			} else {
				// 不处理
			}
		} else {
			// 其他非多实例节点，此时需要
			runtimeService.setVariable(currentExecutionId, "agreeCount", 0);
			globalVar.put("agreeCount", 0);
			// System.out.println(currentExecutionId+"----------3当前任务："+runtimeService.getVariable(currentExecutionId,
			// "agreeCount"));
		}

		// 委托的任务，需要先resolve一下
		if (DelegationState.PENDING == task.getDelegationState()) {
			taskService.resolveTask(workflowVo.getTaskId());
		}

		// 完成本次任务
		taskService.complete(workflowVo.getTaskId(), globalVar);
		JSONObject retJson = new JSONObject();

		if (globalVar.get("agree") != null && globalVar.get("agree").toString().equals("0")) {
			// System.out.println("=========审批不同意======="+globalVar.get("agree").toString());
			// 把agree属性，在全局变量中删除
			// 审批驳回
			retJson.put("result", "2");
			retJson.put("auditRejectMethod", globalVar.get("auditRejectMethod").toString());
			return retJson;
		} else {
			// System.out.println("=========审批同意=======----------");
			ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
			if (pi == null) {
				// 流程结束
				retJson.put("result", "1");
				retJson.put("auditAgreeMethod", globalVar.get("auditAgreeMethod").toString());
			}
			retJson.put("result", "0");
			return retJson;
		}
	}

	/**
	 * 生成流程实例的流程图片，并重点高亮当前节点，高亮已经执行的链路
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:42:11
	 */
	@ApiOperation(value = "查詢流程实例的流程图片", notes = "重点高亮当前节点，高亮已经执行的链路")
	@RequestMapping(value = "/task-provider/task/process/info", method = RequestMethod.POST)
	public Result getTaskProcessInfo(@RequestBody WorkflowVo workflowVo) {
		try {
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(workflowVo.getInstanceId()).singleResult();
			BpmnModel bpmnModel;
			List<String> activeActivityIds = new ArrayList<String>();
			String processDefinitionId;
			// 存在活动节点，流程正在进行中
			if (processInstance != null) {
				processDefinitionId = processInstance.getProcessDefinitionId();
				// 流程定义-正在活动的节点
				activeActivityIds = runtimeService.getActiveActivityIds(workflowVo.getInstanceId());
			} else {
				// 流程已经结束
				HistoricProcessInstance instance = historyService.createHistoricProcessInstanceQuery().processInstanceId(workflowVo.getInstanceId()).singleResult();
				processDefinitionId = instance.getProcessDefinitionId();
			}

			bpmnModel = repositoryService.getBpmnModel(processDefinitionId);

			ProcessDiagramGenerator pdg = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();

			// -------------------------------executedActivityIdList已经执行的节点------------------------------------
			List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(workflowVo.getInstanceId()).orderByHistoricActivityInstanceStartTime().asc().list();

			// 已执行的节点ID集合
			List<String> executedActivityIdList = new ArrayList<String>();
			for (HistoricActivityInstance activityInstance : historicActivityInstanceList) {
				executedActivityIdList.add(activityInstance.getActivityId());
			}

			ProcessDefinition processDefinition = repositoryService.getProcessDefinition(processDefinitionId);
			String resourceName = workflowVo.getInstanceId() + "_" + processDefinition.getDiagramResourceName();

			List<String> highLightedFlows = getHighLightedFlows((ProcessDefinitionEntity) processDefinition, historicActivityInstanceList);

			// 生成流图片 所有走过的节点高亮 第三个参数
			// activeActivityIds=当前活动节点点高亮;executedActivityIdList=已经执行过的节点高亮
			// processEngine.getProcessEngineConfiguration().getActivityFontName(),
			// processEngine.getProcessEngineConfiguration().getLabelFontName()
			InputStream inputStream = pdg.generateDiagram(bpmnModel, "PNG", activeActivityIds, highLightedFlows, "宋体", "宋体", "宋体", processEngine.getProcessEngineConfiguration().getProcessEngineConfiguration().getClassLoader(), 1);
			resourceName = DateUtil.format(new Date(), "yyyyMMddHHmmss") + "_" + resourceName;
			// 生成本地图片
			String realPath = uploadPath + resourceName;
			realPath = realPath.replaceAll("\\\\", "/");
			File file = new File(realPath);
			if (file.exists()) {
				file.delete();
			}
			FileUtil.copyInputStreamToFile(inputStream, file);
			String realName = ("" + File.separator + resourceName).replaceAll("\\\\", "/");
			inputStream.close();
			return new Result(true, realName, "成功生成png");
		} catch (Exception e) {
			return new Result(false);
		}
	}

	/**
	 * 获取需要高亮的线
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:22:21
	 */
	private List<String> getHighLightedFlows(ProcessDefinitionEntity processDefinitionEntity, List<HistoricActivityInstance> historicActivityInstances) {
		List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
		for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
			ActivityImpl activityImpl = processDefinitionEntity.findActivity(historicActivityInstances.get(i).getActivityId());// 得到节点定义的详细信息
			List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
			ActivityImpl sameActivityImpl1 = processDefinitionEntity.findActivity(historicActivityInstances.get(i + 1).getActivityId());
			// 将后面第一个节点放在时间相同节点的集合里
			sameStartTimeNodes.add(sameActivityImpl1);
			for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
				HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
				HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点
				ActivityImpl sameActivityImpl2 = processDefinitionEntity.findActivity(activityImpl2.getActivityId());
				sameStartTimeNodes.add(sameActivityImpl2);
			}
			List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();// 取出节点的所有出去的线
			for (PvmTransition pvmTransition : pvmTransitions) {
				// 对所有的线进行遍历
				ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition.getDestination();
				// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
				if (sameStartTimeNodes.contains(pvmActivityImpl)) {
					highFlows.add(pvmTransition.getId());
				}
			}
		}
		return highFlows;
	}

	/**
	 * 判断是否需要选择审批人
	 */
	@ApiOperation(value = "判断下一个是否需要选择审批人", notes = "根据返回的string字符串的前缀来判断，role、unit、post分别代表角色、组织机构、岗位")
	@RequestMapping(value = "/task-provider/task/audit/flag/{taskId}", method = RequestMethod.POST)
	public String selectAuditFlag(@PathVariable("taskId") String taskId) throws Exception {

		String retS = "common"; // 默认不需要提前选择审批人
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("agree", "1");
		TaskDefinition taskDef = getNextTaskInfo(taskId, variables);
		// System.out.println("1=========TaskDefinition======="+taskDef);
		if (taskDef != null) {
			// 如果taskDef.getKey()中有系统特定的值，让用户先选择这些人员（下一步审批人），否则直接通过角色/部门进行全部默认。
			System.out.println("=========TaskDefinition=======" + taskDef.getKey());

			// 解析key
			if (taskDef.getKey().startsWith("role") || taskDef.getKey().startsWith("unit") || taskDef.getKey().startsWith("post")) {
				retS = taskDef.getKey();
			}
		}
		// System.out.println("2=========TaskDefinition======="+retS);
		return retS;
	}

	/**
	 * 判断是否需要选择审批人, 通过流程processDefineId来进行判断
	 */
	@ApiOperation(value = "判断下一个是否需要选择审批人", notes = "此接口是发起时调用，当前还没有任务。返回的string字符串，role、unit、post分别代表角色、组织机构、岗位")
	@RequestMapping(value = "/task-provider/workflow/start/audit-type", method = RequestMethod.POST)
	public String processAuditFlag(@RequestBody JSONObject json) throws Exception {
		// System.out.println("==-=-=-="+jsonStr);
		String retS = "0";

		String functionId = "";
		String projectId = "";
		String unitId = "";

		// 根据输入参数获取流程定义id
		WorkflowVo workflowVo = new WorkflowVo();
		if (json != null && json.get("functionId") != null && !json.get("functionId").equals("")) {
			functionId = json.get("functionId").toString();
			workflowVo.setFunctionId(functionId);
		}
		if (json != null && json.get("projectId") != null && !json.get("projectId").equals("")) {
			projectId = json.get("projectId").toString();
			workflowVo.setProjectId(projectId);
		}
		if (json != null && json.get("unitId") != null && !json.get("unitId").equals("")) {
			unitId = json.get("unitId").toString();
			workflowVo.setUnitId(unitId);
		}
		// 参数输入错误，必须要明确是哪个菜单
		if (functionId == "") {
			return "error-int";
		}

		String processDefineId = "";

		SysFunctionProdef fpd = workflowInstanceService.queryFunctionProdef(workflowVo);
		if (fpd != null && fpd.getProdefId() != null) {
			processDefineId = fpd.getProdefId();
		} else {
			// 未配置工作流，以后可以有一个公共的工作流，目前是按照菜单进行的配置
			return "error-con";
		}
		// System.out.println("1==-=-=-="+processDefineId);
		// 校验流程定义是否存在（latestVersion().）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefineId).active().singleResult();
		if (processDefinitionEntity == null)
			return "error-exist-" + processDefineId;

		// 获取BpmnModel对象
		BpmnModel bpmnModel = processEngine.getRepositoryService().getBpmnModel(processDefineId);

		// Process对象封装了全部的节点、连线、以及关口等信息
		org.activiti.bpmn.model.Process process = bpmnModel.getProcesses().get(0);

		// 获取全部的FlowElement信息
		Collection<FlowElement> flowElements = process.getFlowElements();

		for (FlowElement flowElement : flowElements) {
			if (flowElement.getClass().getName().contains("StartEvent")) {
				FlowNode fn = (FlowNode) flowElement;
				List<SequenceFlow> startNodeOutList = fn.getOutgoingFlows();
				// System.out.println("21------------------------============="+fn.getId()+"============"+fn.getName());
				for (SequenceFlow start : startNodeOutList) {
					// 开始时间后的第一个节点，发起人节点
					FlowNode firstNode = (FlowNode) process.getFlowElement(start.getTargetRef());
					// System.out.println("22------------------------============="+firstNode.getId()+"============"+firstNode.getName());
					if (firstNode instanceof org.activiti.bpmn.model.UserTask) {

						// 第一个节点的下一个节点就是第一个审批节点
						List<SequenceFlow> firstNodeOutList = firstNode.getOutgoingFlows();
						for (SequenceFlow first : firstNodeOutList) {
							FlowNode auditNode = (FlowNode) process.getFlowElement(first.getTargetRef());

							if (auditNode.getId().startsWith("role") || auditNode.getId().startsWith("unit") || auditNode.getId().startsWith("post")) {
								retS = auditNode.getId();
							}
						}
					}
				}
			}
		}

		// System.out.println("============="+retS);
		return retS;
	}

	/**
	 * 选择的审批人列表
	 */
	@ApiOperation(value = "待选择的审批人列表", notes = "下一步是按照角色进行选择人，罗列这些角色的合集。rolesCodes必须要有值，用-隔开")
	@RequestMapping(value = "/task-provider/task/deal/user", method = RequestMethod.POST)
	public Object getDealUser(@RequestBody LayuiTableParam param) throws Exception {
		int limit = 15;
		int page = 1;
		String roleCodes = null;
		String userDisp = null;
		// System.out.println("1后台getDealUser==========="+jsonStr);

		if (param.getLimit() != null && !StrUtil.isBlankOrNull(param.getLimit().toString())) {
			limit = Integer.parseInt(param.getLimit().toString());
		}
		if (param.getPage() != null && !StrUtil.isBlankOrNull(param.getPage().toString())) {
			page = Integer.parseInt(param.getPage().toString());
		}
		if (param.getParam().get("roleCodes") != null && !StrUtil.isBlankOrNull(param.getParam().get("roleCodes").toString())) {
			roleCodes = param.getParam().get("roleCodes").toString();
		}
		if (param.getParam().get("userDisp") != null && !StrUtil.isBlankOrNull(param.getParam().get("userDisp").toString())) {
			userDisp = param.getParam().get("userDisp").toString();
		}

		String[] roles = roleCodes.split("-");
		// 查询这些角色中的人员信息
		List<String> userCodeList = new ArrayList<String>();
		for (int i = 0; i < roles.length; i++) {
			userCodeList.add(roles[i]);
		}

		// System.out.println("2后台==========="+roleCodes);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleCodes", userCodeList);
		paramMap.put("userDisp", userDisp);
		paramMap.put("page", page);
		paramMap.put("limit", limit);

		return userService.findUserByRoleCodes(paramMap);
	}

	/**
	 * 获取下一个用户任务信息
	 * 
	 * @param String
	 *            taskId 任务Id信息
	 * @return 下一个用户任务用户组信息
	 * @throws Exception
	 */
	public TaskDefinition getNextTaskInfo(String taskId, Map<String, Object> globalVar) throws Exception {

		ProcessDefinitionEntity processDefinitionEntity = null;
		String id = null;
		TaskDefinition task = null;

		// 获取流程实例Id信息
		String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();

		// 获取流程发布Id信息
		String definitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();

		processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService).getDeployedProcessDefinition(definitionId);

		ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

		// 当前流程节点Id信息
		String activitiId = execution.getActivityId();
		if (activitiId == null) {
			return null;
		}
		// System.out.println("activitiId========"+activitiId);
		// 获取流程所有节点信息
		List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();

		// 遍历所有节点信息
		for (ActivityImpl activityImpl : activitiList) {
			id = activityImpl.getId();
			if (activitiId.equals(id)) {
				// 获取下一个节点信息
				task = nextTaskDefinition(activityImpl, activityImpl.getId(), null, processInstanceId, globalVar);
				break;
			}
		}
		return task;
	}

	/**
	 * 下一个任务节点信息,
	 * 
	 * 如果下一个节点为用户任务则直接返回,
	 * 
	 * 如果下一个节点为排他网关, 获取排他网关Id信息, 根据排他网关Id信息和execution获取流程实例排他网关Id为key的变量值,
	 * 根据变量值分别执行排他网关后线路中的el表达式, 并找到el表达式通过的线路后的用户任务
	 * 
	 * @param ActivityImpl
	 *            activityImpl 流程节点信息
	 * @param String
	 *            activityId 当前流程节点Id信息
	 * @param String
	 *            elString 排他网关顺序流线段判断条件
	 * @param String
	 *            processInstanceId 流程实例Id信息
	 * @return
	 */
	private TaskDefinition nextTaskDefinition(ActivityImpl activityImpl, String activityId, String elString, String processInstanceId, Map<String, Object> globalVar) {

		PvmActivity ac = null;

		Object s = null;

		// 如果遍历节点为用户任务并且节点不是当前节点信息
		if ("userTask".equals(activityImpl.getProperty("type")) && !activityId.equals(activityImpl.getId())) {
			// 获取该节点下一个节点信息(下一个实例可能是多实例节点)
			// System.out.println("activityImpl.getActivityBehavior()=================="+activityImpl.getActivityBehavior().getClass());
			// System.out.println("activityImpl.getActivityBehavior()=================="+activityImpl.getActivityBehavior().getClass().getName());
			if (activityImpl.getActivityBehavior().getClass().getName().contains("UserTaskActivityBehavior")) {
				TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior()).getTaskDefinition();
				return taskDefinition;
			} else {
				// 多实例任务等情况
				return null;
			}

		} else {
			// 获取节点所有流向线路信息
			List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();
			List<PvmTransition> outTransitionsTemp = null;
			for (PvmTransition tr : outTransitions) {
				ac = tr.getDestination(); // 获取线路的终点节点
				// 如果流向线路为排他网关
				if ("exclusiveGateway".equals(ac.getProperty("type"))) {
					outTransitionsTemp = ac.getOutgoingTransitions();

					// 如果排他网关只有一条线路信息
					if (outTransitionsTemp.size() == 1) {
						return nextTaskDefinition((ActivityImpl) outTransitionsTemp.get(0).getDestination(), activityId, elString, processInstanceId, globalVar);
					} else if (outTransitionsTemp.size() > 1) { // 如果排他网关有多条线路信息
						boolean cond = true;
						for (PvmTransition tr1 : outTransitionsTemp) {
							s = tr1.getProperty("conditionText"); // 获取排他网关线路判断条件信息
							// System.out.println("1============================="+s+"------------------------------"+elString);
							// 计算出现的变量的相应的表达式是否成立，el中可能有多个变量，在全局变量中分别取这些值
							// 判断el表达式是否成立
							// 可能存在除agree（同意不同意）之外的其他条件判断（一个节点只能有一个节点判断），所以直接遍历当前的网关条件
							for (Map.Entry<String, Object> entry : globalVar.entrySet()) {
								System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
								if (entry.getValue() != null && s != null && isCondition(entry.getKey(), s.toString().replaceAll(" ", ""), entry.getValue().toString())) {
									cond = false;
									// System.out.println("============================success-------------------"+elString);
									return nextTaskDefinition((ActivityImpl) tr1.getDestination(), activityId, elString, processInstanceId, globalVar);
								}
							}

						}
						// 各个分支都不符合条件
						if (cond)
							return null;
					}
				} else if ("userTask".equals(ac.getProperty("type"))) {
					return ((UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).getTaskDefinition();
				} else {
				}
			}
			return null;
		}
	}

	/**
	 * 根据key和value判断el表达式是否通过信息 el暂时不支持多条件的juel判断，所以画图的时候，多条件的用多个网关来区分
	 * 
	 * @param String
	 *            key el表达式key信息
	 * @param String
	 *            el el表达式信息
	 * @param String
	 *            value el表达式传入值信息
	 * @return
	 */
	public boolean isCondition(String key, String el, String value) {
		// System.out.println(key+"===="+el+"========"+value);
		ExpressionFactory factory = new ExpressionFactoryImpl();
		SimpleContext context = new SimpleContext();
		context.setVariable(key, factory.createValueExpression(value, String.class));
		ValueExpression e = factory.createValueExpression(context, el, boolean.class);
		return (Boolean) e.getValue(context);
	}

	/**
	 * usertask任务列表
	 * 
	 * @author zhf
	 * @date 2018年5月5日 下午2:14:37
	 */
	@ApiOperation(value = "某个实例的任务列表", notes = "instanceId涉及到的任务列表，返回总数和list的json对象")
	@RequestMapping(value = "/task-provider/task/process/list/{instanceId}", method = RequestMethod.POST)
	public JSONObject selectTaskProcessList(@PathVariable("instanceId") String instanceId, @RequestParam(value = "jsonStr", required = false) String jsonStr) {
		// HistoricActivityInstanceQuery query =
		// historyService.createHistoricActivityInstanceQuery().processInstanceId(instanceId);
		// 已执行的流程节点
		List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(instanceId).orderByHistoricActivityInstanceStartTime().asc().list();
		// voList=处理历史上已经发生过的任务节点
		List<ActivityVo> voList = new ArrayList<ActivityVo>();
		// 处理历史上已经发生过的节点，包括开始节点
		for (HistoricActivityInstance historicActivityInstance : historicActivityInstanceList) {
			// 过滤掉非用户任务
			if (!historicActivityInstance.getActivityType().equals("userTask"))
				continue;
			ActivityVo vo = new ActivityVo();
			BeanUtils.copyProperties(historicActivityInstance, vo);
			if (historicActivityInstance.getActivityType().equals("userTask") && historicActivityInstance.getTaskId() != null) {
				// 获取审批意见、审批时间
				List<Comment> comments = taskService.getTaskComments(historicActivityInstance.getTaskId());
				if (comments != null && comments.size() > 0) {
					for (Comment comment : comments) {
						vo.setSuggestion(comment.getFullMessage());
					}
				}
				List<HistoricIdentityLink> temList = historyService.getHistoricIdentityLinksForTask(historicActivityInstance.getTaskId());
				if (temList != null && temList.size() > 0) {
					for (int i = 0; i < temList.size(); i++) {
						HistoricIdentityLink identityLink = temList.get(i);
						if (!StrUtil.isBlankOrNull(identityLink.getUserId())) {
							SysUser temUser = userService.selectUserByUserId(identityLink.getUserId());
							vo.setAssigneeName(temUser != null ? temUser.getUserDisp() : "");
						}
					}
				}
			}

			// 节点状态
			if (vo.getEndTime() != null)
				vo.setActivityState("已执行");
			else
				vo.setActivityState("正在执行");

			vo.setApproved("当前已办理任务的是否已办理");

			voList.add(vo);
		}

		// 获取任务名称（从历史流程实例中获取，因为现有流程实例可能已经结束）
		HistoricProcessInstance instance = historyService.createHistoricProcessInstanceQuery().processInstanceId(instanceId).singleResult();

		for (ActivityVo vo : voList) {
			vo.setTaskName(instance != null ? instance.getName() : "");
		}
		JSONObject retJson = new JSONObject();
		// 封装需要返回的分页实体
		retJson.put("totalCount", voList.size());
		retJson.put("list", voList);
		return retJson;
	}

	/**
	 * @author zhf
	 * @date 2018年5月8日 下午7:26:49 新增委托单
	 */
	@ApiOperation(value = "新增委托单", notes = "委托人和被委托人、生效时间范围是必选项，当前的待办任务委托给第一个被委托人")
	@RequestMapping(value = "/task-provider/delegate", method = RequestMethod.POST)
	public Integer insertDelegate(@RequestBody SysDelegate delegate) {
		// System.out.println("add-delegate=================="+delegate);

		List<SysDelegate> sdList = taskInstanceService.getSysDelegate(delegate);

		if (sdList.size() > 0) {
			return -1;
		}
		// 判断同一个时间段是否委托多个人
		taskInstanceService.insertDelegate(delegate);

		// 把当前委托人的任务都委托给被委托人
		// System.out.println(delegate.getAttorneyCode()+"add-delegate=================="+delegate.getAssigneeCode());
		this.delegateTasks(delegate.getAssigneeCode(), delegate.getAttorneyCode(), delegate.getModuleCode(), delegate.getDelegateId());
		return 1;
	}

	/**
	 * 批量委托任务，单个候选人，或者指定了受理人
	 *
	 * @param assignee
	 *            委托人
	 * @param attorney
	 *            被委托人
	 * @param moduleCodes
	 *            业务ids，暂时固化，需要判断这个业务是否已经不允许代理
	 * @return
	 */
	public void delegateTasks(String assignee, String attorney, String moduleCodes, String delegateId) {
		List<Task> tasks = taskService.createTaskQuery().taskCandidateOrAssigned(assignee).list();
		// System.out.println(assignee+"===================="+attorney);
		// 判断是单个候选人还是设置了受理人
		for (Task task : tasks) {
			TaskEntity taskEntity = (TaskEntity) task;
			if (!StrUtil.isEmpty(task.getAssignee())) {
				// System.out.println(assignee+"=========111==========="+taskEntity);
				taskService.delegateTask(task.getId(), attorney);
			} else {

				// 单个候选人的情况下，代理任务，防止无法审批的情况下任务无人处理；多个候选人的情况下不代理（让其他人处理）
				// System.out.println(assignee+"=========112==========="+taskEntity);
				List<IdentityLink> identityLinks = processEngine.getTaskService().getIdentityLinksForTask(taskEntity.getId());
				Set<String> userIds = taskInstanceService.getCandidateUserForTask(identityLinks);
				// System.out.println(assignee+"=========1124==========="+userIds.size());
				if (userIds.size() == 1) {
					String candidateUser = userIds.iterator().next();
					taskService.claim(task.getId(), candidateUser);
					taskService.delegateTask(task.getId(), attorney);
					// System.out.println(attorney+"=========1125==========="+userIds.size());
					// 把委托的任务记录下来，取消委托的时候用
					SysTaskDelegate record = new SysTaskDelegate();
					record.setTaskId(task.getId());
					record.setDelegateId(delegateId);
					record.setCreateDate(new Date());
					record.setStatus("1");
					record.setTaskDelegateId(UUID.randomUUID().toString().replaceAll("-", ""));
					taskInstanceService.insertTaskDelegate(record);
				}
			}
		}
	}

	@ApiOperation(value = "初始化具体某条待办任务信息", notes = "返回具体任务的详情url和业务id")
	@RequestMapping(value = "/task-provider/deal/task/info", method = RequestMethod.POST)
	public JSONObject iniDealTask(@RequestBody WorkflowVo workflowVo) throws Exception {
		// 动态获取审批业务详情的页面(提交待办任务时，要指定)
		Object temPath = taskService.getVariable(workflowVo.getTaskId(), "auditDetailsPath");
		// 遍历任务组指定的自定义属性，在审批页面中显示供审批者修改。
		Map<String, Object> definesMap = taskService.getVariables(workflowVo.getTaskId());
		for (String key : definesMap.keySet()) {
		}
		String auditDetailsPath = temPath != null ? temPath.toString() : "";

		System.out.println("2=====iniDealTask====" + auditDetailsPath);

		// 获取任务所属业务的businessId
		Task task = taskService.createTaskQuery().taskId(workflowVo.getTaskId()).singleResult();
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
		String businessKey = pi.getBusinessKey();
		JSONObject retJson = new JSONObject();
		retJson.put("auditDetailsPath", auditDetailsPath);
		retJson.put("id", businessKey);
		return retJson;
	}

}
