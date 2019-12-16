package com.pcitc.web.workflow;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.history.HistoricVariableInstanceQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.ParallelMultiInstanceBehavior;
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
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.DelegationState;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.workflow.ActivityVo;
import com.pcitc.base.workflow.Constants;
import com.pcitc.base.workflow.SysDelegate;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.SysTaskDelegate;
import com.pcitc.base.workflow.TaskDoneVo;
import com.pcitc.base.workflow.TaskVo;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.service.system.UserService;
import com.pcitc.service.workflow.TaskInstanceService;
import com.pcitc.service.workflow.WorkflowInstanceService;
<<<<<<< HEAD
import com.pcitc.utils.BpmnModelImageUtil;
import com.pcitc.utils.ImageGenerator;
=======
>>>>>>> branch 'master' of http://10.102.111.111:88/STP-Team/kjpt.git

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
    public RestTemplate restTemplate;

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
		if (map != null && map.get("userId") != null && !map.get("userId").equals("")) {
			userId = map.get("userId").toString();
		} else {
			retJson.put("pendingTaskCount", "0");
		}
		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		long count = query.count();
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
	@RequestMapping(value = "/task-provider/delegates/delete", method = RequestMethod.POST)
	public Integer deleteDelegate(@RequestBody SysDelegate delegate) {
		System.out.println("deleteDelegate============"+delegate);
		String[] delegateIds = delegate.getDelegateId().split(",");
		int rInt = 0;
		HashMap<String, String> hashmap = new HashMap<String, String>();
		
		// 因为不存在太多委托，所以暂时不考虑批量删除的效率
		for (int i = 0; i < delegateIds.length; i++) {
			delegate.setDelegateId(delegateIds[i]);
			hashmap.put("delegateId", delegateIds[i]);
			List<SysDelegate> temList = taskInstanceService.getSysDelegateInfo(hashmap);
			SysDelegate temObj = temList.get(0);
			temObj.setStatus("0");
			System.out.println("deleteDelegate============"+i+"------"+temObj);
			rInt = rInt + taskInstanceService.deleteDelegate(temObj);
			System.out.println("deleteDelegate============"+i+"------"+rInt);
			
			// 删除当前的委托相关待办任务及流程实例（理论上审批不通过后的数据不允许删除，如果物理删除的话，这里就要调用）
			this.deleteProcessInstanceByDataId(delegateIds[i]);
			
			// 当初委托时（之前）的待办任务都分配给被委托人了，现在把这些待办任务重新归到委托人名下
			// 如果在取消委托之前，已经办理的委托任务就不处理了
			// 获取委托时，被委托人接收的所有任务和委托后监听器分配给被委托人的任务。这些任务已经处理的不能回收，其他的取消重新指派给委托人
			List<SysTaskDelegate> list = taskInstanceService.getDelegateHistoryTask(temObj.getDelegateId());
			for (SysTaskDelegate std : list) {
				System.out.println("2deleteDelegate============"+i+"------"+list);
				// 查询taskId是否已经处理
				Task task = taskService.createTaskQuery().taskId(std.getTaskId()).active().singleResult();
				if (task != null) {
					System.out.println("4deleteDelegate============------"+list);
					taskService.deleteCandidateUser(std.getTaskId(), temObj.getAttorneyCode());
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
		Date now1 = new Date();
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

		if (param.getParam().get("functionId") != null && !StrUtil.isBlankOrNull(param.getParam().get("functionId").toString())) {
			// 只查询某个菜单（功能点）的具体待办任务
			HashMap<String, String> hashmap = new HashMap<String, String>();
			hashmap.put("functionId", param.getParam().get("functionId").toString());
			List<SysFunctionProdef> proList = taskInstanceService.getProcessDefineInfo(hashmap);
			if (proList != null && proList.size() > 0) {
				String[] temKeys = proList.get(0).getProdefId().split(":");
				query = query.processDefinitionKey(temKeys[0]);
			}
		}

		if (param.getParam().get("dateFlag") != null && !StrUtil.isBlankOrNull(param.getParam().get("dateFlag").toString())) {

			if (param.getParam().get("dateFlag").toString().equals("3")) {
				query.taskCreatedAfter(DateUtil.dateAdd(new Date(), -3));
				query.taskCreatedBefore(new Date());
			}
			if (param.getParam().get("dateFlag").toString().equals("7")) {
				query.taskCreatedAfter(DateUtil.dateAdd(new Date(), -7));
				query.taskCreatedBefore(new Date());
			}
			if (param.getParam().get("dateFlag").toString().equals("8")) {
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
		Date now3 = new Date();
		for (Task task : taskList) {
			TaskVo vo = new TaskVo();
			BeanUtils.copyProperties(task, vo);
			// 获取流程变量，得到流程的启动人信息
			Map<String, Object> variables = taskService.getVariables(task.getId());

			if (variables != null && variables.get("authenticatedUserName") != null) {
				vo.setStartUserName(variables.get("authenticatedUserName") != null ? String.valueOf(variables.get("authenticatedUserName")) : "");
			}
			if (variables != null && variables.get("authenticatedDate") != null && !variables.get("authenticatedDate").toString().equals("")) {
				// 流程最开始的发起时间
				Date temDate = (Date) variables.get("authenticatedDate");
				vo.setFlowStartTime(temDate);
			}
			if (variables != null && variables.get("processInstanceName") != null) {
				vo.setProcessInstanceName(variables.get("processInstanceName") != null ? String.valueOf(variables.get("processInstanceName")) : "");
			}
			if (variables != null && variables.get("processDefinitionName") != null) {
				vo.setProcessDefinitionName(variables.get("processDefinitionName") != null ? String.valueOf(variables.get("processDefinitionName")) : "");
			}
			
			if (variables != null && variables.get("flowAuditorName") != null) {
				vo.setAuditor(variables.get("flowAuditorName") != null ? String.valueOf(variables.get("flowAuditorName")) : "");
			}

			if (variables != null && variables.get("flowAuditorComments") != null) {
				vo.setAuditRemarks(variables.get("flowAuditorComments") != null ? String.valueOf(variables.get("flowAuditorComments")) : "");
			}
			vo.setCreateTimeStr(DateUtil.dateToStr(vo.getCreateTime(), DateUtil.FMT_SS));
			/*// 处理历史上已经发生过的节点，包括开始节点,按时间倒序
			List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery().processInstanceId(task.getProcessInstanceId()).finished().orderByHistoricTaskInstanceEndTime().desc().list();
			for (HistoricTaskInstance hti : htiList) {

				// 审批意见
				List<Comment> comments = taskService.getTaskComments(hti.getId());
				if (comments != null && comments.size() > 0) {
					for (Comment comment : comments) {
						vo.setAuditRemarks(comment.getFullMessage());
						break;
					}
				}

				// variables 本次任务变量中，上一步任务id（key）记录有审批人姓名
				if (variables != null && variables.get(hti.getId()) != null) {
					System.out.println(task.getId() + "=====2HistoricTaskInstance=====");
					// SysUser temUser =
					// userService.selectUserByUserId(hti.getAssignee());
					vo.setAuditor(String.valueOf(variables.get(hti.getId())));
					break;
				}

			}*/

			voList.add(vo);
		}

		LayuiTableData data = new LayuiTableData();
		data.setData(voList);
		data.setCount((int) count);
		Date now2 = new Date();
		System.out.println("selectPendingList====总用时-------------" + (now2.getTime() - now1.getTime()));
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
			if (param.getParam().get("dateFlag").toString().equals("3")) {
				query.taskCreatedAfter(DateUtil.dateAdd(new Date(), -3));
				query.taskCreatedBefore(new Date());
			}
			if (param.getParam().get("dateFlag").toString().equals("7")) {
				query.taskCreatedAfter(DateUtil.dateAdd(new Date(), -7));
				query.taskCreatedBefore(new Date());
			}
			if (param.getParam().get("dateFlag").toString().equals("8")) {
				query.taskCreatedBefore(DateUtil.dateAdd(new Date(), -7));
			}
		}

		if (param.getParam().get("functionId") != null && !StrUtil.isBlankOrNull(param.getParam().get("functionId").toString())) {
			// 只查询某个菜单（功能点）的具体待办任务
			HashMap<String, String> hashmap = new HashMap<String, String>();
			hashmap.put("functionId", param.getParam().get("functionId").toString());
			List<SysFunctionProdef> proList = taskInstanceService.getProcessDefineInfo(hashmap);
			if (proList != null && proList.size() > 0) {
				String[] temKeys = proList.get(0).getProdefId().split(":");
				query = query.processDefinitionKey(temKeys[0]);
			}
		}

		List<HistoricTaskInstance> taskInstances = query.orderByHistoricTaskInstanceEndTime().desc().listPage(limit * (page - 1), limit);
		long count = query.count();
		List<TaskDoneVo> voList = new ArrayList<TaskDoneVo>();
		for (HistoricTaskInstance taskInstance : taskInstances) {
			
			TaskDoneVo vo = new TaskDoneVo();
			//3.使用流程实例，查询
			ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(taskInstance.getProcessInstanceId()).singleResult();
			
			
			BeanUtils.copyProperties(taskInstance, vo);
			// String str = JSONObject.toJSONString(taskInstance);
			String pdi = taskInstance.getProcessDefinitionId();
			if (pdi != null && pdi.split(":").length > 0) {
				vo.setProcessDefinitionName(pdi.split(":")[0]);
			}

			vo.setStartTime(taskInstance.getCreateTime());
			vo.setEndTime(taskInstance.getEndTime());

			List<Comment> comments = taskService.getTaskComments(taskInstance.getId());
			if (comments != null && comments.size() > 0) {
				for (Comment comment : comments) {
					vo.setAuditRemarks(comment.getFullMessage());
				}
			}
			vo.setEndTimeStr(DateUtil.dateToStr(vo.getEndTime(), DateUtil.FMT_SS));
			
			//4.使用流程实例对象获取BusinessKey
			if(pi!=null)
			{
				String taskName = pi.getName();
				System.out.println("------  taskName:"+taskName);
				vo.setTaskName(taskName);
			}
			
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

		if (param.getParam().get("functionId") != null && !StrUtil.isBlankOrNull(param.getParam().get("functionId").toString())) {
			// 只查询某个菜单（功能点）的具体待办任务
			HashMap<String, String> hashmap = new HashMap<String, String>();
			hashmap.put("functionId", param.getParam().get("functionId").toString());
			List<SysFunctionProdef> proList = taskInstanceService.getProcessDefineInfo(hashmap);
			if (proList != null && proList.size() > 0) {
				String[] temKeys = proList.get(0).getProdefId().split(":");
				query = query.processDefinitionKey(temKeys[0]);
			}
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
			Date temDate = DateUtil.strToDate(param.getParam().get("startTime").toString() + " 00:00:00", DateUtil.FMT_SS);
			System.out.println("1-----" + param.getParam().get("startTime").toString());
			realQuery = realQuery.startedAfter(temDate);

		}
		if (param.getParam().get("endTime") != null && !StrUtil.isBlankOrNull(param.getParam().get("endTime").toString())) {
			System.out.println("2-----" + param.getParam().get("endTime").toString());
			Date temDate = DateUtil.strToDate(param.getParam().get("endTime").toString() + " 23:59:59", DateUtil.FMT_SS);
			realQuery = realQuery.startedBefore(temDate);
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
		Date date1 = new Date();
		// 此任务节点会签标识
		boolean signFlag = false;

		Integer nrOfInstances = 0;
		Integer nrOfCompletedInstances = 0;

		Task task = taskService.createTaskQuery().taskId(workflowVo.getTaskId()).singleResult();
		
		// 下一个环节需要用的变量等属性，此次审批人选项的agree属性等属性
		Map<String, Object> nextVar = workflowVo.getVariables();
		
		String processInstanceId = taskService.createTaskQuery().taskId(workflowVo.getTaskId()).singleResult().getProcessInstanceId();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).orderByProcessInstanceId().active().desc().singleResult();
		// String businessKey = processInstance.getBusinessKey();BusinessKey一般放(业务模块名称_id)
		// 本次任务的可用变量
		Map<String, Object> taskVar = taskService.getVariables(workflowVo.getTaskId());
		
		// 回退时，方便回到当初指定的审批人
		List currAuditUser = (List) taskVar.get("auditor");
		if (currAuditUser != null) {
			if (!currAuditUser.contains(workflowVo.getAuditorId())) {
				// 本次任务审批人如果不包含当前人，可能当前人是被委托人
				currAuditUser.add(workflowVo.getAuditorId());
			}
			nextVar.put(processInstance.getActivityId() + "-auditor", currAuditUser);
		}
		
		System.out.println("=========3回退时=======----------" + processInstance.getActivityId());
		System.out.println("=========3回退时=======----------" + taskVar.get("auditor"));
		for (String key : taskVar.keySet()) {
			if (!key.equals("agree") && !key.equals("comment") && !key.equals("auditor")) {
				nextVar.put(key, taskVar.get(key));
			}
		}

		// 本次任务节点的下一个节点。特殊节点，根据表单内容来觉得下一步的审批人
		Map<String, Object> temMap = new HashMap<String, Object>();
		temMap.put("agree", "1");
		TaskDefinition taskDef = getNextTaskInfo(workflowVo.getTaskId(), temMap);
		if (taskDef != null && taskDef.getKey().startsWith("specialAuditor")) {
			//nextVar.put(processInstance.getActivityId() + "-auditor", nextVar.get("auditor"));
			System.out.println("=========2回退时=======----------" + processInstance.getActivityId());
			System.out.println("=========2回退时=======----------" + nextVar.get("auditor"));
			if (nextVar.get(taskDef.getKey()) != null) {
				String realAuth = nextVar.get(taskDef.getKey()).toString();
				if (!realAuth.startsWith("post") && !realAuth.startsWith("role") && !realAuth.startsWith("unit")) {
					String[] groups = realAuth.split("-");
					nextVar.put("auditor", sysUserMapper.findUserByGroupIdFromACT(Arrays.asList(groups)));
				} else {
					// 此时前台应该已经选择好auditor
				}
			} else {
				// 初始值虽然是specialAuditor开头，启动时没有配置对应变量
				System.out.println("初始值虽然是specialAuditor开头，启动时没有配置对应变量");
			}
		}

		// 审批意见
		taskService.addComment(workflowVo.getTaskId(), task.getProcessInstanceId(), nextVar.get("comment") != null ? nextVar.get("comment").toString() : "");
		// 会签时的处理，会签条件（agreeCount）的处理
		String currentExecutionId = task.getExecutionId();
		if (runtimeService.getVariable(currentExecutionId, "loopCounter") != null) {
			if (nextVar.get("agree") != null && nextVar.get("agree").toString().equals("1")) {
				// 判断会签里面，有几个同意的，同意一次+1
				if (runtimeService.getVariable(currentExecutionId, "agreeCount") != null) {
					Integer agreeCount = (Integer) runtimeService.getVariable(currentExecutionId, "agreeCount");
					runtimeService.setVariable(currentExecutionId, "agreeCount", agreeCount + 1);
					nextVar.put("agreeCount", agreeCount + 1);
				} else {
					runtimeService.setVariable(currentExecutionId, "agreeCount", 1);
					nextVar.put("agreeCount", 1);
				}
			} else {
				// 不处理
				if (runtimeService.getVariable(currentExecutionId, "agreeCount") != null) {
					Integer agreeCount = (Integer) runtimeService.getVariable(currentExecutionId, "agreeCount");
					runtimeService.setVariable(currentExecutionId, "agreeCount", agreeCount);
					nextVar.put("agreeCount", agreeCount);
				} else {
					nextVar.put("agreeCount", 0);
				}
			}

			// 会签标识
			signFlag = true;

			// 判断此时的同意率（同意数/总的审批人数）是否符合，符合的话，complete后，直接返回，否则继续执行
			if (nextVar.get("signAuditRate") != null) {
				Integer signAgreeCount = (Integer) nextVar.get("agreeCount");

				// nrOfCompletedInstances：已经完成实例的数目; nrOfInstances：实例总数
				nrOfInstances = (Integer) runtimeService.getVariable(currentExecutionId, "nrOfInstances");
				nrOfCompletedInstances = (Integer) runtimeService.getVariable(currentExecutionId, "nrOfCompletedInstances");

				Double signAuditRate = Double.valueOf(nextVar.get("signAuditRate").toString());
				if (nrOfInstances == nrOfCompletedInstances + 1) { // 会签人员都审批了(+1,因为马上要complete)
					if (signAgreeCount / nrOfInstances >= signAuditRate) {
						nextVar.put("agree", 1);
					} else {
						nextVar.put("agree", 0);
					}
				}
			}
		} else {
			// 其他非多实例节点，此时需要
			// runtimeService.setVariable(currentExecutionId, "agreeCount", 0);
			nextVar.put("agreeCount", 0);
		}

		// 委托的任务，需要先resolve一下
		if (DelegationState.PENDING == task.getDelegationState()) {
			taskService.resolveTask(workflowVo.getTaskId());
		}

		// 会签时，获取选择审批人给会签需要的assigneeList(下一个环节如果不是会签，assigneeList可能就白赋值了)
		if (nextVar.get("signAuditRate") != null && nextVar.get("auditor") != null) {
			System.out.println("1会签时====" + nextVar.get("auditor"));
			nextVar.put("assigneeList", nextVar.get("auditor"));
		}

		// 本次任务的审批人id
		taskService.setAssignee(workflowVo.getTaskId(), workflowVo.getAuditorId());

		// 插入本次任务的审批人姓名，方便下一步查询上一步执行人姓名。key为本次taskId
		nextVar.put(workflowVo.getTaskId(), workflowVo.getAuditorName());
		nextVar.put("flowAuditorName", workflowVo.getAuditorName());
		// 启动节点，审批意见为空
		nextVar.put("flowAuditorComments", nextVar.get("comment") != null ? nextVar.get("comment").toString() : " ");

		for (String key : nextVar.keySet()) {
			System.out.println(key + "============complete=================" + nextVar.get(key));
		}
		
		// 为回退添加标识位
		nextVar.put("rejectFlag", workflowVo.getTaskId());
		System.out.println("=========2回退时=======----------" + processInstance.getActivityId());
		System.out.println("=========2回退时=======----------" + nextVar.get("auditor"));
		
		// 完成本次任务
		taskService.complete(workflowVo.getTaskId(), nextVar);
		JSONObject retJson = new JSONObject();
		Date date2 = new Date();
		System.out.println("=========任务处理时间=======----------" + (date2.getTime() - date1.getTime()));
		if (!signFlag) {// 不是会签的正常走流程
			if (nextVar.get("agree") != null && nextVar.get("agree").toString().equals("0")) {
				// 把agree属性，在全局变量中删除
				// 审批驳回
				//retJson.put("result", "2");
				//retJson.put("auditRejectMethod", nextVar.get("auditRejectMethod").toString());
				retJson.put("statusCode", handleBusinessInfo(nextVar.get("auditRejectMethod").toString()));
				return retJson;
			} else {
				System.out.println("=========审批同意=======----------");
				ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
				if (pi == null) {
					// 流程结束
					//retJson.put("result", "1");
					//retJson.put("auditAgreeMethod", nextVar.get("auditAgreeMethod").toString());
					retJson.put("statusCode", handleBusinessInfo(nextVar.get("auditAgreeMethod").toString()));
					return retJson;
				}
				retJson.put("statusCode", "0");
				return retJson;
			}
		} else {
			// 会签的
			// 判断此时的同意率（同意数/总的审批人数）是否符合，符合的话，complete后，直接返回，否则继续执行
			if (nextVar.get("signAuditRate") != null) {
				Integer signAgreeCount = (Integer) nextVar.get("agreeCount");

				// nrOfCompletedInstances：已经完成实例的数目; nrOfInstances：实例总数
				System.out.println(signAgreeCount + "-------nrOfInstances-------" + nrOfInstances);

				Double signAuditRate = Double.valueOf(nextVar.get("signAuditRate").toString());
				if (nrOfInstances == nrOfCompletedInstances + 1) { // 会签人员都审批了
					if (signAgreeCount / nrOfInstances >= signAuditRate) {
						ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
						if (pi == null) {
							// 流程结束
							//retJson.put("result", "1");
							//retJson.put("auditAgreeMethod", nextVar.get("auditAgreeMethod").toString());
							System.out.println("=========会签流程结束=======流程结束----------");
							retJson.put("statusCode", handleBusinessInfo(nextVar.get("auditAgreeMethod").toString()));
							return retJson;
						}
						System.out.println("=========会签流程结束=======流程未结束----------");
						retJson.put("statusCode", "0");
						return retJson;
					} else {// 审批不通过 ，直接打回
						// 审批驳回
						System.out.println("=========会签流程结束=======审批驳回----------");
						//retJson.put("result", "2");
						//retJson.put("auditRejectMethod", nextVar.get("auditRejectMethod").toString());
						retJson.put("statusCode", handleBusinessInfo(nextVar.get("auditRejectMethod").toString()));
						return retJson;
					}
				} else { // 会签还没完全走完（之后可以逻辑细分）
					System.out.println("=========会签流程未结束=======----------");
					retJson.put("statusCode", "0");
					return retJson;
				}
			} else {
				// 异常情况，会签必须要signAuditRate属性
				System.out.println("=========1会签异常情况=======----------");
				retJson.put("statusCode", "-1");
				return retJson;
			}
		}

	}

	/**
	 * 生成流程实例的流程图片，并重点高亮当前节点，高亮已经执行的链路
	 * 
	 * @author zhf
	 * @date 2018年4月23日 下午5:42:11
	 */
	@ApiOperation(value = "查詢流程实例的流程图片", notes = "重点高亮当前节点，高亮已经执行的链路")
	@RequestMapping(value = "/task-provider/task/business/audit/image", method = RequestMethod.POST)
	public byte[] getBusinessImageInfo(@RequestBody WorkflowVo workflowVo) {
		try {
			System.out.println("6getBusinessImageInfo==========="+workflowVo.getBusinessId());
			// 获取任务名称（从历史流程实例中获取，因为现有流程实例可能已经结束）
			HistoricProcessInstance instance = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(workflowVo.getBusinessId()).singleResult();
			if (instance == null) {
				return null;
			}
			System.out.println("5getBusinessImageInfo==========="+instance);
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(instance.getId()).singleResult();
			BpmnModel bpmnModel;
			List<String> activeActivityIds = new ArrayList<String>();
			String processDefinitionId;
			// 存在活动节点，流程正在进行中
			System.out.println("4getBusinessImageInfo==========="+processInstance);
			if (processInstance != null) {
				processDefinitionId = processInstance.getProcessDefinitionId();
				// 流程定义-正在活动的节点
				activeActivityIds = runtimeService.getActiveActivityIds(processInstance.getId());
			} else {
				// 流程已经结束
				processDefinitionId = instance.getProcessDefinitionId();
			}
			System.out.println("3getBusinessImageInfo==========="+processDefinitionId);
			bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
			System.out.println("2getBusinessImageInfo==========="+bpmnModel);
			ProcessDiagramGenerator pdg = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();

			// -------------------------------executedActivityIdList已经执行的节点------------------------------------
			List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(instance.getId()).orderByHistoricActivityInstanceStartTime().asc().list();

			// 已执行的节点ID集合
			List<String> executedActivityIdList = new ArrayList<String>();
			for (HistoricActivityInstance activityInstance : historicActivityInstanceList) {
				executedActivityIdList.add(activityInstance.getActivityId());
			}

			ProcessDefinition processDefinition = repositoryService.getProcessDefinition(processDefinitionId);
			//String resourceName = workflowVo.getInstanceId() + "_" + processDefinition.getDiagramResourceName();

			List<String> highLightedFlows = getHighLightedFlows((ProcessDefinitionEntity) processDefinition, historicActivityInstanceList);

			// 生成流图片 所有走过的节点高亮 第三个参数
			// activeActivityIds=当前活动节点点高亮;executedActivityIdList=已经执行过的节点高亮
			// processEngine.getProcessEngineConfiguration().getActivityFontName(),
			// processEngine.getProcessEngineConfiguration().getLabelFontName()
			System.out.println("1getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration());
			System.out.println("2getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getClassLoader());
			System.out.println("3getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getActivityFontName());
			System.out.println("4getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getLabelFontName());
			System.out.println("5getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getAnnotationFontName());
			InputStream inputStream = pdg.generateDiagram(bpmnModel, "PNG", activeActivityIds, highLightedFlows, "SimSun", "SimSun", "SimSun", processEngine.getProcessEngineConfiguration().getClassLoader(), 1.0d);
			/*
			 * resourceName = DateUtil.format(new Date(), "yyyyMMddHHmmss") +
			 * "_" + resourceName; // 生成本地图片 String realPath = uploadPath +
			 * resourceName; realPath = realPath.replaceAll("\\\\", "/"); File
			 * file = new File(realPath); if (file.exists()) { file.delete(); }
			 * FileUtil.copyInputStreamToFile(inputStream, file); String
			 * realName = ("" + File.separator +
			 * resourceName).replaceAll("\\\\", "/"); inputStream.close();
			 */

			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[100]; // buff用于存放循环读取的临时数据
			int rc = 0;
			while ((rc = inputStream.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
			byte[] in_b = swapStream.toByteArray(); // in_b为转换之后的结果
			System.out.println("1getBusinessImageInfo==========="+in_b.length);
			return in_b;
		} catch (Exception e) {
			return null;
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
	public byte[] getTaskProcessInfo(@RequestBody WorkflowVo workflowVo) {
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

			System.out.println("getTaskProcessInfo======"+processDefinitionId);
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
			System.out.println("getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration());
			System.out.println("getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getClassLoader());
			System.out.println("getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getActivityFontName());
			System.out.println("getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getLabelFontName());
			System.out.println("getProcessEngineConfiguration-------------"+processEngine.getProcessEngineConfiguration().getAnnotationFontName());
			InputStream inputStream = pdg.generateDiagram(bpmnModel, "PNG", activeActivityIds, highLightedFlows, "SimSun", "SimSun", "SimSun", processEngine.getProcessEngineConfiguration().getClassLoader(), 1.0d);
			/*
			 * resourceName = DateUtil.format(new Date(), "yyyyMMddHHmmss") +
			 * "_" + resourceName; // 生成本地图片 String realPath = uploadPath +
			 * resourceName; realPath = realPath.replaceAll("\\\\", "/"); File
			 * file = new File(realPath); if (file.exists()) { file.delete(); }
			 * FileUtil.copyInputStreamToFile(inputStream, file); String
			 * realName = ("" + File.separator +
			 * resourceName).replaceAll("\\\\", "/"); inputStream.close();
			 */

			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[100]; // buff用于存放循环读取的临时数据
			int rc = 0;
			while ((rc = inputStream.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
			byte[] in_b = swapStream.toByteArray(); // in_b为转换之后的结果
			return in_b;
		} catch (Exception e) {
			return null;
		}
	}

	
	@ApiOperation(value = "查詢流程实例的流程图片", notes = "重点高亮当前节点，高亮已经执行的链路")
	@RequestMapping(value = "/task-provider/getModelImage/{modelId}", method = RequestMethod.GET)
	public byte[] getBpmnModelImage(@PathVariable("modelId") String modelId ) throws Exception
	{
	    	Model modelData = processEngine.getRepositoryService().getModel(modelId);
	    	//InputStream inputStream =processEngine.getRepositoryService().getModelEditorSource(modelId);
	    	
	    	InputStream inputStream = ImageGenerator.getBpmnModelInputStream2(repositoryService, processEngine, modelData.getId()) ;
	    	ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[100]; // buff用于存放循环读取的临时数据
			int rc = 0;
			while ((rc = inputStream.read(buff, 0, 100)) > 0) 
			{
				swapStream.write(buff, 0, rc);
			}
			byte[] in_b = swapStream.toByteArray(); // in_b为转换之后的结果
			return in_b;
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
		System.out.println("1=========selectAuditFlag=======" + taskDef);
		if (taskDef != null) {
			// 如果taskDef.getKey()中有系统特定的值，让用户先选择这些人员（下一步审批人），否则直接通过角色/部门进行全部默认。
			System.out.println("=========TaskDefinition=======" + taskDef.getKey());

			// 解析key
			if (taskDef.getKey().startsWith("role") || taskDef.getKey().startsWith("unit") || taskDef.getKey().startsWith("post")) {
				retS = taskDef.getKey();
			}

			if (taskDef.getKey().startsWith("specialAuditor")) {
				System.out.println("3=========specialAuditor=======" + taskId);
				// 本次任务的可用变量
				Map<String, Object> taskVar = taskService.getVariables(taskId);
				// 判断当前节点是否是会签节点，并且是否是最后一个审批人。
				// 最后节点的话，如果是选择审批人类型的节点，让此次审批人选择下一步的审批人
				if (taskVar.get(taskDef.getKey()) != null) {
					String auditorType = taskVar.get(taskDef.getKey()).toString();
					if (auditorType.startsWith("unit") && auditorType.startsWith("post") || auditorType.startsWith("role")) {
						retS = auditorType;
					} else {
						// 此时下一个环节是直接指定审批人（通过预设的角色、岗位、单位）
						System.out.println("3=========此时下一个环节是直接指定审批人（通过预设的角色、岗位、单位）=======" + taskId);
					}
				}
			}
		}
		// System.out.println("2=========TaskDefinition======="+retS);
		return retS;
	}

	/**
	 * 判断是否需要选择审批人, 通过流程processDefineId来进行判断（第一次启动流程时的判断）
	 */
	@ApiOperation(value = "判断下一个是否需要选择审批人", notes = "此接口是发起时调用，当前还没有任务。返回的string字符串，role、unit、post分别代表角色、组织机构、岗位")
	@RequestMapping(value = "/task-provider/workflow/start/audit-type", method = RequestMethod.POST)
	public String processAuditFlag(@RequestBody JSONObject json) throws Exception {
		System.out.println("==-=-=-=" + json.toJSONString());
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
		
		outer:
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
							System.out.println("1==========" + first.getConditionExpression());
							System.out.println("2==========" + first.getTargetRef());
							FlowNode auditNode = (FlowNode) process.getFlowElement(first.getTargetRef());
							System.out.println("3==========" + auditNode.getId());
							System.out.println("4==========" + auditNode.getClass().toString());
							if (auditNode instanceof org.activiti.bpmn.model.UserTask) {
								if (auditNode.getId().startsWith("role") || auditNode.getId().startsWith("unit") || auditNode.getId().startsWith("post")) {
									retS = auditNode.getId();
									break outer;
								}
								// 特殊的审批节点
								if (auditNode.getId().startsWith("specialAuditor")) {
									System.out.println("====specialAuditor======" + auditNode.getId());
									// 启动的时候，让启动者选择特殊审批节点的审批人员
									if (json != null && json.get(auditNode.getId()) != null && !json.get(auditNode.getId()).equals("")) {
										// 不用选择自动配置审批人的话，此时json（html）中需要提前设定角色/岗位/单位CODE
										retS = json.get(auditNode.getId()).toString();
										System.out.println("====specialAuditor11======" + json.get(auditNode.getId()).toString());
										break outer;
									}
								}
							} else if (auditNode instanceof org.activiti.bpmn.model.ExclusiveGateway) {
								// 发起人之后的第一个节点，不确定
								List<SequenceFlow> excluList = auditNode.getOutgoingFlows();
								System.out.println("5==========发起人之后的第一个节点，不确定");
								for (SequenceFlow exclu : excluList) {
									System.out.println("5==========" + exclu.getConditionExpression());
									System.out.println("6==========" + exclu.getTargetRef());
									System.out.println("7==========" + json.get("branchFlag"));
									// 遍历json对象
									for (Map.Entry<String, Object> entry : json.entrySet()) {
							            System.out.println(entry.getKey() + ":" + entry.getValue());
							            if (entry.getValue() != null && exclu.getConditionExpression() != null) {
							            	if (isCondition(entry.getKey(), exclu.getConditionExpression().replaceAll(" ", ""), entry.getValue().toString())) {
							            		FlowNode realAuditNode = (FlowNode) process.getFlowElement(exclu.getTargetRef());
							            		if (realAuditNode instanceof org.activiti.bpmn.model.UserTask) {
													if (realAuditNode.getId().startsWith("role") || realAuditNode.getId().startsWith("unit") || realAuditNode.getId().startsWith("post")) {
														retS = realAuditNode.getId();
														break outer;
													}
													// 特殊的审批节点
													if (realAuditNode.getId().startsWith("specialAuditor")) {
														System.out.println("1====specialAuditor======" + realAuditNode.getId());
														System.out.println("2====specialAuditor======" + json.get(realAuditNode.getId()));
														// 启动的时候，让启动者选择特殊审批节点的审批人员
														if (json != null && json.get(realAuditNode.getId()) != null && !json.get(realAuditNode.getId()).equals("")) {
															// 不用选择自动配置审批人的话，此时json（html）中需要提前设定角色/岗位/单位CODE
															retS = json.get(realAuditNode.getId()).toString();
															System.out.println("====specialAuditor11======" + json.get(realAuditNode.getId()).toString());
															break outer;
														}
													}
												}
											}
							            }
							        }
								}
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
		Task currentTask = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processInstanceId = currentTask.getProcessInstanceId();

		// 获取流程发布Id信息
		String definitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();

		processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService).getDeployedProcessDefinition(definitionId);

		/*
		 * ExecutionEntity execution = (ExecutionEntity)
		 * runtimeService.createProcessInstanceQuery
		 * ().processInstanceId(processInstanceId).singleResult(); // 当前流程节点Id信息
		 * String activitiId = execution.getActivityId();
		 */

		ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(currentTask.getExecutionId()).singleResult();
		String activitiId = execution.getActivityId();
		System.out.println("4----------当前任务节点----" + activitiId);
		if (activitiId == null) {
			return null;
		}
		// 获取流程所有节点信息
		List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();
		System.out.println("3----------当前任务节点----" + activitiList);
		// 遍历所有节点信息
		for (ActivityImpl activityImpl : activitiList) {
			id = activityImpl.getId();
			System.out.println("4----------当前任务节点----" + id);
			if (activitiId.equals(id)) {
				// 获取下一个节点信息
				task = nextTaskDefinition(activityImpl, activityImpl.getId(), null, processInstanceId, globalVar);
				System.out.println("5----------下一个节点----" + task);
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
			System.out.println("activityImpl.getActivityBehavior()==================" + activityImpl.getActivityBehavior().getClass());
			System.out.println("activityImpl.getActivityBehavior()==================" + activityImpl.getActivityBehavior().getClass().getName());
			if (activityImpl.getActivityBehavior().getClass().getName().contains("UserTaskActivityBehavior")) {
				TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior()).getTaskDefinition();
				return taskDefinition;
			} else if (activityImpl.getActivityBehavior().getClass().getName().contains("ParallelMultiInstanceBehavior")) {
				ParallelMultiInstanceBehavior paralBehavior = (ParallelMultiInstanceBehavior) activityImpl.getActivityBehavior();
				return ((UserTaskActivityBehavior) paralBehavior.getInnerActivityBehavior()).getTaskDefinition();
			} else {
				// 其他特殊情况，暂时不考虑。目前只包含一般的用户任务和会签（多实例）任务
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
					System.out.println("userTask1---------------" + ac.getProperty("type"));
					// return ((UserTaskActivityBehavior) ((ActivityImpl)
					// ac).getActivityBehavior()).getTaskDefinition();
					if (((ActivityImpl) ac).getActivityBehavior() instanceof UserTaskActivityBehavior) {
						UserTaskActivityBehavior aaBehavior = (UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior();
						return ((UserTaskActivityBehavior) aaBehavior).getTaskDefinition();
					} else if (((ActivityImpl) ac).getActivityBehavior() instanceof ParallelMultiInstanceBehavior) {
						ParallelMultiInstanceBehavior aaBehavior = (ParallelMultiInstanceBehavior) ((ActivityImpl) ac).getActivityBehavior();
						return ((UserTaskActivityBehavior) aaBehavior.getInnerActivityBehavior()).getTaskDefinition();
					}
				} else {
					System.out.println("userTask2---------------" + ac.getProperty("type"));
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
		if (el.indexOf(key) < 0) {
			return false;
		}
		ExpressionFactory factory = new ExpressionFactoryImpl();
		SimpleContext context = new SimpleContext();
		context.setVariable(key, factory.createValueExpression(value, String.class));
		ValueExpression e = factory.createValueExpression(context, el, boolean.class);
		return (Boolean) e.getValue(context);
	}
	
	/**
	 * 通过业务详情查询审批详情
	 * 
	 * @author zhf
	 * @date 2019年4月24日 下午2:14:37
	 */
	@ApiOperation(value = "通过业务详情查询审批详情", notes = "")
	@RequestMapping(value = "/task-provider/task/business/audit/{dataId}", method = RequestMethod.POST)
	public JSONObject businessAuditDetail(@PathVariable("dataId") String dataId, @RequestParam(value = "jsonStr", required = false) String jsonStr) {
		
		// 获取任务名称（从历史流程实例中获取，因为现有流程实例可能已经结束）
		HistoricProcessInstance instance = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(dataId).singleResult();
		if (instance == null) {
			return null;
		}
		// 已执行的流程节点
		List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(instance.getId()).orderByHistoricActivityInstanceStartTime().asc().list();
		
		// 历史流程中用过的变量信息
		HistoricVariableInstanceQuery hviq = historyService.createHistoricVariableInstanceQuery().processInstanceId(instance.getId());
		
		// voList=处理历史上已经发生过的任务节点
		List<ActivityVo> voList = new ArrayList<ActivityVo>();
		// 处理历史上已经发生过的节点，包括开始节点
		for (HistoricActivityInstance historicActivityInstance : historicActivityInstanceList) {
			// 过滤掉非用户任务
			if (!historicActivityInstance.getActivityType().equals("userTask"))
				continue;
			ActivityVo vo = new ActivityVo();
			System.out.println("====" + historicActivityInstance);
			BeanUtils.copyProperties(historicActivityInstance, vo);
			if (historicActivityInstance.getActivityType().equals("userTask") && historicActivityInstance.getTaskId() != null) {
				// 获取审批意见、审批时间
				List<Comment> comments = taskService.getTaskComments(historicActivityInstance.getTaskId());
				if (comments != null && comments.size() > 0) {
					for (Comment comment : comments) {
						vo.setSuggestion(comment.getFullMessage());
						if (comment.getFullMessage() != null)
							break;
					}
				}
				
				
				HistoricVariableInstance hvi = hviq.variableName(historicActivityInstance.getTaskId()).singleResult();
				
				if (hvi == null) {
					// 当前任务，在历史任务中没有此属性
					List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(historicActivityInstance.getTaskId());
					List<String> userList = taskInstanceService.getCandidateUserForTask(identityLinks);
					String userNames = "";
					if (userList != null && userList.size() > 0) {
						SysUserExample example = new SysUserExample();
						example.createCriteria().andUserIdIn(userList);
						List<SysUser> users = userService.selectByExample(example);
						
						for (int i = 0; i < users.size(); i++) {
							if (i == 0) {
								userNames = users.get(i).getUserDisp();
							} else {
								userNames = userNames + "," + users.get(i).getUserDisp();
							}
						}
					} 
					vo.setAssigneeName(userNames);
				} else {
					vo.setAssigneeName(hvi.getValue() == null ? "" : hvi.getValue().toString());
				}
				vo.setTaskName(instance != null ? instance.getName() : "");
			}

			// 节点状态
			if (vo.getEndTime() != null)
				vo.setActivityState("已执行");
			else
				vo.setActivityState("正在执行");

			vo.setApproved("当前已办理任务的是否已办理");
			voList.add(vo);
		}

		JSONObject retJson = new JSONObject();
		// 封装需要返回的分页实体
		retJson.put("totalCount", voList.size());
		retJson.put("list", voList);
		return retJson;
	}
	
	/**
	 * 根据业务id删除对应流程实例
	 * 
	 * @author zhf
	 * @date 2019年9月10日 下午4:40:37
	 */
	@ApiOperation(value = "通过业务id删除对应的流程实例", notes = "")
	@RequestMapping(value = "/task-provider/task/process-instance/delete/{dataId}", method = RequestMethod.POST)
	public JSONObject deleteProcessInstanceByDataId(@PathVariable("dataId") String dataId) {
		
		// 获取任务名称（从历史流程实例中获取，因为现有流程实例可能已经结束）
		HistoricProcessInstance instance = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(dataId).singleResult();
		JSONObject retJson = new JSONObject();
		
		if (instance == null) {
			retJson.put("result", "1");
			return retJson;
		}
		
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(instance.getId()).singleResult();
		
		if (processInstance != null) {
			// 当前流程未结束
			runtimeService.suspendProcessInstanceById(instance.getId());//挂起流程
			runtimeService.deleteProcessInstance(instance.getId(),"业务单据数据物理删除");//删除流程
			//historyService.deleteHistoricProcessInstance(instance.getId());
		}
		
		retJson.put("result", "1");
		return retJson;
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
		// 已执行的流程节点
		List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(instanceId).orderByHistoricActivityInstanceStartTime().asc().list();
		
		// 历史流程中用过的变量信息
		HistoricVariableInstanceQuery hviq = historyService.createHistoricVariableInstanceQuery().processInstanceId(instanceId);
		
		// voList=处理历史上已经发生过的任务节点
		List<ActivityVo> voList = new ArrayList<ActivityVo>();
		// 处理历史上已经发生过的节点，包括开始节点
		for (HistoricActivityInstance historicActivityInstance : historicActivityInstanceList) {
			// 过滤掉非用户任务
			if (!historicActivityInstance.getActivityType().equals("userTask"))
				continue;
			ActivityVo vo = new ActivityVo();
			System.out.println("====" + historicActivityInstance);
			BeanUtils.copyProperties(historicActivityInstance, vo);
			if (historicActivityInstance.getActivityType().equals("userTask") && historicActivityInstance.getTaskId() != null) {
				// 获取审批意见、审批时间
				List<Comment> comments = taskService.getTaskComments(historicActivityInstance.getTaskId());
				if (comments != null && comments.size() > 0) {
					for (Comment comment : comments) {
						vo.setSuggestion(comment.getFullMessage());
						if (comment.getFullMessage() != null)
							break;
					}
				}
				
				
				HistoricVariableInstance hvi = hviq.variableName(historicActivityInstance.getTaskId()).singleResult();
				
				if (hvi == null) {
					// 当前任务，在历史任务中没有此属性。说明此任务是正在执行的任务
					List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(historicActivityInstance.getTaskId());
					List<String> userList = taskInstanceService.getCandidateUserForTask(identityLinks);
					String userNames = "";
					if (userList != null && userList.size() > 0) {
						SysUserExample example = new SysUserExample();
						example.createCriteria().andUserIdIn(userList);
						List<SysUser> users = userService.selectByExample(example);
						
						for (int i = 0; i < users.size(); i++) {
							if (i == 0) {
								userNames = users.get(i).getUserDisp();
							} else {
								userNames = userNames + "," + users.get(i).getUserDisp();
							}
						}
					} 
					vo.setAssigneeName(userNames);
				} else {
					vo.setAssigneeName(hvi.getValue() == null ? "" : hvi.getValue().toString());
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
	
	
	
	@ApiOperation(value = "根据业务Id查某个实例的任务列表", notes = "根据业务Id查某个实例的任务列表，返回总数和list的json对象")
	@RequestMapping(value = "/task-provider/task/getInstanceIdByBussinessId/{bussinessId}", method = RequestMethod.GET)
	public JSONObject getInstanceIdByBussinessId(@PathVariable("bussinessId") String bussinessId) 
	{
		HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()//对应历史的流程实例表
				.processInstanceBusinessKey(bussinessId)//使用BusinessKey字段查询
				.singleResult();
		////流程实例ID
		String instanceId = hpi.getId();
		JSONObject retJson = new JSONObject();
		// 封装需要返回的分页实体
		retJson.put("instanceId", instanceId);
		return retJson;
	}

	

	/**
	 * @author zhf
	 * @date 2018年5月8日 下午7:26:49 新增委托单
	 */
	@ApiOperation(value = "新增委托单", notes = "委托人和被委托人、生效时间范围是必选项，当前的待办任务委托给第一个被委托人")
	@RequestMapping(value = "/task-provider/delegate/add", method = RequestMethod.POST)
	public Integer insertDelegate(@RequestBody SysDelegate delegate) {
		// System.out.println("add-delegate=================="+delegate);

		List<SysDelegate> sdList = taskInstanceService.getSysDelegate(delegate);
		// 判断同一个时间段是否委托多个人
		if (sdList.size() > 0) {
			return -1;
		}
		
		taskInstanceService.insertDelegate(delegate);

		// 把当前委托人的任务都委托给被委托人（如果创建委托需要审批的话，应该是审批通过后，处理这个动作）
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
				List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(taskEntity.getId());
				List<String> userIds = taskInstanceService.getCandidateUserForTask(identityLinks);
				// System.out.println(assignee+"=========1124==========="+userIds.size());
				if (userIds.size() == 1) {
					// String candidateUser = userIds.iterator().next();
					// taskService.claim(task.getId(), candidateUser);
					//不调用delegateTask，delegateTask会把原审批人的待办任务去掉。调用addCandidateUser，本质上只是动态添加一个审批人
					// taskService.delegateTask(task.getId(), attorney);
					taskService.addCandidateUser(task.getId(), attorney);
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
		//pi.getActivityId()
		JSONObject retJson = new JSONObject();
		retJson.put("auditDetailsPath", auditDetailsPath);
		retJson.put("id", businessKey);
		return retJson;
	}

	/**
	 * 任务撤回
	 */
	@ApiOperation(value = "撤回历史任务, 下一步审批人员已经操作的不允许撤回", notes = "撤回任务节点的任务id-taskId")
	@RequestMapping(value = "/task-provider/task/recall/{taskId}", method = RequestMethod.POST)
	public JSONObject taskRecall(@PathVariable("taskId") String taskId) throws Exception {
		JSONObject retJson = new JSONObject();
		boolean startNodeFlag = false;
		
		HistoricTaskInstanceQuery htiq = historyService.createHistoricTaskInstanceQuery();
		// 要撤回的任务id对应的任务实例。撤回的节点如果是发起人节点的话，最终再执行一次审批不通过的方法
		HistoricTaskInstance historicTaskInstance = htiq.taskId(taskId).singleResult();
		
		// 取得流程实例
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(historicTaskInstance.getProcessInstanceId()).singleResult();
		
		if (processInstance == null) {
			// 当前流程已经结束，不允许撤回
			retJson.put("result", false);
			retJson.put("statusCode", 500);
			return retJson;
		}
		// 当前任务的活动节点id
		String activitiId = processInstance.getActivityId();
		if (activitiId.equals(historicTaskInstance.getTaskDefinitionKey())) {
			// 同一个节点，不需要多次退回
			retJson.put("result", false);
			retJson.put("statusCode", 100);
			return retJson;
		}
		
		// 查询历史变量中rejectFlag属性，判断要撤回的任务，下一步任务是否已经执行。已经执行就不能撤回。
		HistoricVariableInstanceQuery hviq = historyService.createHistoricVariableInstanceQuery().processInstanceId(historicTaskInstance.getProcessInstanceId());
		HistoricVariableInstance hvi = hviq.variableName("rejectFlag").singleResult();
		
		String auditor = "";
		if (hvi == null) {
			// 异常
			retJson.put("result", false);
			retJson.put("statusCode", 400);
			return retJson;
		} else {
			// 此历史变量大于任务id，变量值是提前置入的，为了撤回功能新加的变量
			Long lTaskId = Long.parseLong(taskId);
			Long lRejectFlag = Long.parseLong(hvi.getValue().toString());
			if (lRejectFlag > lTaskId) {
				System.out.println(taskId+"---下一步审批已经执行----"+hvi.getValue());
				retJson.put("result", false);
				retJson.put("statusCode", 300);
				return retJson;
			}
			
			HistoricVariableInstance hviAuditor = hviq.variableName("flowAuditorName").singleResult();
			auditor = hviAuditor.getValue().toString();
		}
		
		Map<String, Object> variables = runtimeService.getVariables(historicTaskInstance.getExecutionId());
		for (String key : variables.keySet()) {
			System.out.println(key+"-----variables====" + variables.get(key));
		}
		// 取得流程定义
		ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(historicTaskInstance.getProcessDefinitionId());
		System.out.println("definitionEntity---------"+definitionEntity);
		
		// 通过当前任务活动ID在流程定义中找到对应的活动对象
		ActivityImpl currActivity = definitionEntity.findActivity(activitiId);

		// 取得上一步活动(要撤回审批的这个活动节点)
		ActivityImpl hisActivity = definitionEntity.findActivity(historicTaskInstance.getTaskDefinitionKey());
		System.out.println("撤回审批的这个活动节点---------"+hisActivity);
		
		// 撤回节点的来源如果是开始节点，说明是发起人节点，撤回此节点需要执行审批不同意方法
		List<PvmTransition> hisTransList = hisActivity.getIncomingTransitions();
		for (PvmTransition pvm :hisTransList) {
			PvmActivity sourceLine = pvm.getSource(); // 获取线路的终点节点
			if ("startEvent".equals(sourceLine.getProperty("type"))) {
				startNodeFlag = true;
				break;
			}
		}
		// 要回退到的节点、当前节点是会签节点，不允许回退
		if (currActivity.getActivityBehavior().getClass().getName().contains("MultiInstanceBehavior") || hisActivity.getActivityBehavior().getClass().getName().contains("MultiInstanceBehavior")) {
			retJson.put("result", false);
			return retJson;
		} 
		
		// 当前任务节点的平行任务（一个节点有多个人来审批）
		List<Task> currTasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskDefinitionKey(currActivity.getId()).list();
		System.out.println("平行任务-----------"+currTasks.size());
		
		for (Task currTask : currTasks) {
			ArrayList<PvmTransition> oriPvmTransitionList = new ArrayList<>();
			// 当前历史节点的真实流向，做一个临时处理
			List<PvmTransition> pvmTransitionList = currActivity.getOutgoingTransitions();
			System.out.println("pvmTransitionList"+pvmTransitionList);
			for (PvmTransition pvmTransition : pvmTransitionList) {
				oriPvmTransitionList.add(pvmTransition);
			}
			System.out.println("oriPvmTransitionList"+oriPvmTransitionList);
			pvmTransitionList.clear();
			
			// 建立新方向
			ActivityImpl nextActivityImpl = definitionEntity.findActivity(currActivity.getId());
			TransitionImpl newTransition = nextActivityImpl.createOutgoingTransition();
			newTransition.setDestination(hisActivity);
			
			// 正在待办的任务都处理了，处理前，强行把当前任务的下一个节点设置成要恢复的任务节点
			taskService.claim(currTask.getId(), null);
			variables.put(currTask.getId(), auditor+"审批撤回");
			Object temObj = variables.get(historicTaskInstance.getTaskDefinitionKey() + "-auditor");
			
			if (temObj != null) {
				List temList = (ArrayList)variables.get(historicTaskInstance.getTaskDefinitionKey() + "-auditor");
				variables.put("auditor", temList);
			}
			
			
			taskService.complete(currTask.getId(), variables);
			historyService.deleteHistoricTaskInstance(currTask.getId());
			
			System.out.println("删除的任务节点id---------"+currTask.getId());

			// 恢复方向。把要恢复的任务节点的流入清除掉
			hisActivity.getIncomingTransitions().remove(newTransition);
			
			// 当前任务节点的流出清理掉（临时返回到恢复节点的流向清理掉）
			List<PvmTransition> pvmTList = currActivity.getOutgoingTransitions();
			pvmTList.clear();
			
			// 把当前历史节点的真实的流向再添加进来。配合上面的临时处理
			for (PvmTransition pvmTransition : oriPvmTransitionList) {
				pvmTransitionList.add(pvmTransition);
			}
			System.out.println("pvmTransitionList"+pvmTransitionList);
		}
		
		System.out.println("撤回节点的历史实例不撤回，用于记录节点----------------"+historicTaskInstance.getId());
		//historyService.deleteHistoricTaskInstance(historicTaskInstance.getId());

		if (startNodeFlag) { //要恢复的节点是发起节点
			HistoricVariableInstance arm = hviq.variableName("auditRejectMethod").singleResult();
			if (arm != null) {
				String auditRejectMethod = arm.getValue().toString();
				retJson.put("statusCode", handleBusinessInfo(auditRejectMethod));
			}
		}
		System.out.println("statusCode---------"+retJson.getInteger("statusCode"));
		if (retJson.getInteger("statusCode") == null) {
			retJson.put("statusCode", 200);
		}
		retJson.put("result", true);
		
		return retJson;
	}
	
	/**
	 * 执行审批同意后的业务方法
	 * @param methodName
	 * @return
	 */
	public int handleBusinessInfo(String methodName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTGV2ZWwiOjAsInVuaXROYW1lIjoi5Lit5Zu955-z5rK55YyW5bel6ZuG5ZuiLOWLmOaOouW8gOWPkeeglOeptumZoiIsInVuaXRQYXRoIjoiMTAwMSwxMDAxMDUwMDAwMDIwMDA0IiwidW5pdENvZGUiOiIwMDAwMCwxMDA0MDEwMDEiLCJ1bml0SWQiOiI0NmI3ZTQ1NzU2ZWY0ZGI4OGI2YWNiNzExZjkxNmU0Myw0NWRiMmRkM2UxNDI0OTVjOTFiYzk0ZjIwZWY0OTllOCIsInVzZXJEaXNwIjoi6LaF57qn566h55CG5ZGYIiwicG9zdElkIjoiMTY0MmE3MWYyMmNfN2FmNzMxMGEiLCJ1c2VyTmFtZSI6ImFkbWluIiwicm9sZUxpc3QiOltdLCJleHAiOjc2MTE5Njc0MTYsInVzZXJJZCI6IjEyMyIsImVtYWlsIjoiNjc4MTA1NTk1OUBzaW5hLmNvbSJ9.UnK-xrHlRr1OsHC1HZIMijHEx3WlSqGKdfPu87sJom9vuW0Fe3imYkwxP4EXNYFuE7CXvvqfKLGcaUhUXfBUUw");
		
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		// 传递参数
		//form.add("xxx", "xxx");
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, headers);
		
		ResponseEntity<Object> responseEntity = this.restTemplate.postForEntity(methodName, httpEntity, Object.class);
		HttpStatus statusCode = responseEntity.getStatusCode();
		return statusCode.value();
	}
	
	
}
