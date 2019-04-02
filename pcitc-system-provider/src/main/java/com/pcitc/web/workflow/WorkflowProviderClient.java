package com.pcitc.web.workflow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.ParallelMultiInstanceBehavior;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.javax.el.ExpressionFactory;
import org.activiti.engine.impl.javax.el.ValueExpression;
import org.activiti.engine.impl.juel.ExpressionFactoryImpl;
import org.activiti.engine.impl.juel.SimpleContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.DelegationState;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.explorer.util.XmlUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysFileExample;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.workflow.ProcessDefVo;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.service.system.SysFileService;
import com.pcitc.service.workflow.WorkflowInstanceService;
import com.pcitc.utils.StringUtils;

@Api(value = "Workflow-API", description = "工作流相关的接口")
@RestController
public class WorkflowProviderClient {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private WorkflowInstanceService workflowInstanceService;

	@Autowired
	SysFileService sysFileService;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	/**
	 * @author zhf
	 * @date 2019年3月26日 下午2:08:57
	 */
	@ApiOperation(value = "启动业务审批流程", notes = "公共审批流启动方法")
	@RequestMapping(value = "/workflow-provider/common-workflow/start", method = RequestMethod.POST)
	public String startCommonWorkflow(@RequestBody String jsonStr) throws Exception {
		Date date1 = new Date();
		if (jsonStr == null) {
			return "流程启动异常,参数异常";
		}
		System.out.println("jsonStr---"+jsonStr);
		JSONObject json = JSONObject.parseObject(jsonStr);
		Map<String, Object> variables = new HashMap<String, Object>();
		for (Map.Entry<String, Object> entry : json.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }

		String processDefineId;
		if (StrUtil.isBlankOrNull(json.getString("businessId"))) {
			return "流程启动异常,业务id参数异常";
		}
		
		if (StrUtil.isBlankOrNull(json.getString("authenticatedUserId"))) {
			return "流程启动异常,任务发起人id参数异常";
		}
		
		if (StrUtil.isBlankOrNull(json.getString("functionId"))) {
			return "流程启动异常,功能菜单id参数异常";
		} else {
			WorkflowVo workflowVo = new WorkflowVo();
			workflowVo.setFunctionId(json.getString("functionId"));
			
			if (StrUtil.isBlankOrNull(json.getString("flowProjectId"))) {
				workflowVo.setProjectId(json.getString("flowProjectId"));
			}
			if (StrUtil.isBlankOrNull(json.getString("flowUnitId"))) {
				workflowVo.setUnitId(json.getString("flowUnitId"));
			}
			
			SysFunctionProdef fpd = workflowInstanceService.queryFunctionProdef(workflowVo);
			
			if (fpd == null || fpd.getProdefId() == null) {
				return "流程启动异常,参数异常";
			} else {
				processDefineId = fpd.getProdefId();
			}
		} 
		// 校验流程定义是否存在（.latestVersion()）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefineId).active().singleResult();
		if (processDefinitionEntity == null)
			return "流程启动失败,id为'" + processDefineId + "'的流程定义不存在";
		// 启动流程, 根据key获取最新版本的流程定义
		ProcessInstance processInstance = null;
		try {
			
			ProcessInstance havedPS = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(json.getString("businessId")).singleResult();
			if (havedPS != null) {
				// json.getString("dataId") 如果业务表单修改后，重新发起流程
				processInstance = havedPS;
			} else {
				// 设置流程启动人，第一次发起流程
				identityService.setAuthenticatedUserId(json.getString("authenticatedUserId"));
				processInstance = runtimeService.startProcessInstanceById(processDefineId, json.getString("businessId"), variables);
			}
		} catch (Exception ex) {
			return "流程启动异常,异常原因：" + ex.getMessage();
		}

		// 把第一个节点待办任务办理了，variables中有变量为当前人的starter。（第一个节点在监听器中判断，不允许委托）
		Task task = null;
		
		// 获取申请人的待办任务列表
		List<Task> todoList = taskService.createTaskQuery().processInstanceBusinessKey(json.getString("businessId")).active().list();
		for (Task tmp : todoList) {
			if (tmp.getProcessInstanceId().equals(processInstance.getId())) {
				task = tmp;	// 获取当前流程实例，当前申请人的待办任务
				break;
			}
		}
		// 如果第一步审批（就是发起人后的第一步）是需要选择审批人，而不是通过流程图自动配置的话，需要在发起之前把审批人信息放到variables
		if (DelegationState.PENDING == task.getDelegationState()) {
			taskService.resolveTask(task.getId(), variables);
		}
		
		// 本步的执行人，记录一下，方便之后查询历史任务时，知道具体某个任务的执行人
		taskService.setAssignee(task.getId(), json.getString("authenticatedUserId"));
		
		// 本次任务的可用变量
		Map<String, Object> taskVar = taskService.getVariables(task.getId());
		
		// 本次任务节点的下一个节点。特殊节点，根据表单内容来觉得下一步的审批人
		Map<String, Object> temMap = new HashMap<String, Object>();
		temMap.put("agree", "1");
		TaskDefinition taskDef = this.getNextTaskInfo(processInstance.getId(), temMap);
		// System.out.println("1=========TaskDefinition======="+taskDef);
		if (taskDef != null && taskDef.getKey().startsWith("specialAuditor") && json.getString("auditor") != null) {
			// 特殊节点，自动获取当初传递的审批人员的值。并且不是通过选择来确定审批者的
			Set<String> userIds = new LinkedHashSet<String>();
			System.out.println("1=========TaskDefinition======="+taskDef.getKey());
			System.out.println("1=========TaskDefinition======="+json.getString(taskDef.getKey()));
			if (json.getString(taskDef.getKey()) != null) {
				// 分解group
				String[] groups = json.getString(taskDef.getKey()).toString().split("--")[1].split("-");
				for (int i = 0; i < groups.length; i++) {
					userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(groups[i]));
				}
			}
			taskVar.put("auditor", userIds);
		}
		
		// 插入本次任务的审批人姓名，方便下一步任务查询上一步执行人姓名
		taskVar.put(task.getId(), json.getString("authenticatedUserName"));
		// 流程的启动人姓名和流程发起时间
		taskVar.put("authenticatedUserName", json.getString("authenticatedUserName"));
		taskVar.put("authenticatedDate", new Date());
		taskVar.put("flowAuditorName", json.getString("authenticatedUserName"));

		String processInstanceName = "";
		if (!StrUtil.isBlankOrNull(json.getString("processInstanceName"))) {
			processInstanceName = json.getString("processInstanceName");
		}
		// 设置此流程实例的名称（待办任务名称）
		runtimeService.setProcessInstanceName(processInstance.getId(), processInstanceName);
		// 方便查询也把名称放到变量中
		taskVar.put("processInstanceName", processInstanceName);
		taskVar.put("processDefinitionName", processInstance.getProcessDefinitionKey());
		
		// 会签时，获取选择审批人给会签需要的assigneeList(下一个环节如果不是会签，assigneeList就白赋值了)
		
		System.out.println("1开始执行任务----------------"+json.getString("signAuditRate"));
		System.out.println("1开始执行任务----------------"+taskVar.get("auditor"));
		if (json.getString("signAuditRate") != null && json.getString("auditor") != null) {
			System.out.println("1会签时1====" + json.getString("auditor"));
			taskVar.put("assigneeList", Arrays.asList(json.getString("auditor").split(",")));
			System.out.println("2会签时2====" + json.getString("auditor"));
		}
		System.out.println("开始执行任务----------------"+task.getId());
		taskService.complete(task.getId(), taskVar);
		Date date2 = new Date();
		System.out.println("=========任务处理时间=======----------"+(date2.getTime()-date1.getTime()));
		return "true";
	}

	/**
	 * A+B两种情况 A: 通过流程定义id启动流程，包括启动+第一步执行（一般第一步都是启动人/申请人）
	 * 申请人启动流程后，流程就会到达“提交任务”，而
	 * “提交任务”的办理人还是该申请人，这个时候就需要通过代码跳过（自动处理）该任务节点，让流程流转到下一任务节点
	 * variables里要有starter这个变量，并且要value要设置为启动人本人。 对应的，在画图的时候，第一个任务节点的candidate
	 * users要添加一个starter变量
	 * 
	 * B: 通过菜单id来查询此菜单配置的工作流定义id，其中需要判断起对应的工程、部门等信息
	 * 
	 * @author zhf
	 * @date 2018年5月3日 下午2:08:57
	 */
	@ApiOperation(value = "启动流程", notes = "传入菜单id等业务属性来启动")
	@RequestMapping(value = "/workflow-provider/workflow/start", method = RequestMethod.POST)
	public String startWorkflow(@RequestBody WorkflowVo workflowVo) throws Exception {
		String processDefineId = workflowVo.getProcessDefineId();
		if (workflowVo == null || (workflowVo.getFunctionId() == null && workflowVo.getProcessDefineId() == null)) {
			return "流程启动异常,参数异常";
		} else if (workflowVo.getFunctionId() != null) {
			//
			SysFunctionProdef fpd = workflowInstanceService.queryFunctionProdef(workflowVo);
			if (fpd != null && fpd.getProdefId() != null) {
				processDefineId = fpd.getProdefId();
			} else {
				return "流程启动异常,参数异常";
			}
		} else {
			return "流程启动异常,参数异常";
		}
		// 校验流程定义是否存在（.latestVersion()）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefineId).active().singleResult();
		if (processDefinitionEntity == null)
			return "流程启动失败id为'" + processDefineId + "'的流程定义不存在";
		// 启动流程, 根据key获取最新版本的流程定义
		ProcessInstance processInstance = null;
		try {
			
			ProcessInstance havedPS = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(workflowVo.getBusinessId()).singleResult();
			if (havedPS != null) {
				// workflowVo.getBusinessId() 如果业务表单修改后，重新发起流程
				processInstance = havedPS;
			} else {
				// 设置流程启动人，第一次发起流程
				identityService.setAuthenticatedUserId(workflowVo.getAuthenticatedUserId());
				processInstance = runtimeService.startProcessInstanceById(processDefineId, workflowVo.getBusinessId(), workflowVo.getVariables());
			}
		} catch (Exception ex) {
			return "流程启动异常,异常原因：" + ex.getMessage();
		}

		// 把第一个节点待办任务办理了，variables中有变量为当前人的starter。（第一个节点在监听器中判断，不允许委托）
		Task task = null;
		
		// 获取申请人的待办任务列表
		List<Task> todoList = taskService.createTaskQuery().processInstanceBusinessKey(workflowVo.getBusinessId()).active().list();
		for (Task tmp : todoList) {
			if (tmp.getProcessInstanceId().equals(processInstance.getId())) {
				task = tmp;// 获取当前流程实例，当前申请人的待办任务
				break;
			}
		}
		
		// 如果第一步审批（就是发起人后的第一步）是需要选择审批人，而不是通过流程图自动配置的话，需要在发起之前把审批人信息放到workflowVo.getVariables()
		if (DelegationState.PENDING == task.getDelegationState()) {
			System.out.println("---开始启动流程，并同时处22222理发起人的第一个任务---");
			taskService.resolveTask(task.getId(), workflowVo.getVariables());
		}
		// 本步的执行人，记录一下，方便之后查询历史任务时，知道具体某个任务的执行人
		taskService.setAssignee(task.getId(), workflowVo.getAuthenticatedUserId());
		
		// 启动流程时的初始化变量
		Map<String, Object> iniVar = workflowVo.getVariables();
		
		// 本次任务的可用变量
		Map<String, Object> taskVar = taskService.getVariables(task.getId());
		// 把启动时的变量也都给下一步
		for (String key : iniVar.keySet()) {
			// 几个常用key，不自动处理
			if (!key.equals("agree") && !key.equals("comment") && !key.equals("auditor")) {
				taskVar.put(key, iniVar.get(key));
			}
		}
		
		// 本次任务节点的下一个节点。特殊节点，根据表单内容来觉得下一步的审批人
		Map<String, Object> temMap = new HashMap<String, Object>();
		temMap.put("agree", "1");
		TaskDefinition taskDef = this.getNextTaskInfo(processInstance.getId(), temMap);
		// System.out.println("1=========TaskDefinition======="+taskDef);
		if (taskDef != null && taskDef.getKey().startsWith("specialAuditor")) {
			// 特殊节点，获取当初传递的值
			Set<String> userIds = new LinkedHashSet<String>();
			System.out.println("1=========TaskDefinition======="+taskDef.getKey());
			System.out.println("1=========TaskDefinition======="+taskVar.get(taskDef.getKey()));
			if (taskVar.get(taskDef.getKey()) != null) {
				// 分解group
				String[] groups = taskVar.get(taskDef.getKey()).toString().split("-");
				for (int i = 0; i < groups.length; i++) {
					userIds.addAll(sysUserMapper.findUserByGroupIdFromACT(groups[i]));
				}
			}
			taskVar.put("auditor", userIds);
		}
		
		// 插入本次任务的审批人姓名，方便下一步任务查询上一步执行人姓名
		taskVar.put(task.getId(), workflowVo.getAuthenticatedUserName());
		
		// 流程的启动人姓名和流程发起时间
		taskVar.put("authenticatedUserName", workflowVo.getAuthenticatedUserName());
		taskVar.put("authenticatedDate", new Date());
		taskVar.put("flowAuditorName", workflowVo.getAuthenticatedUserName());
		
		// 设置此流程实例的名称（待办任务名称）
		runtimeService.setProcessInstanceName(processInstance.getId(), workflowVo.getProcessInstanceName());
		// 方便查询也把名称放到变量中
		taskVar.put("processInstanceName", workflowVo.getProcessInstanceName());
		taskVar.put("processDefinitionName", processInstance.getProcessDefinitionKey());
		
		// 会签时，获取选择审批人给会签需要的assigneeList(下一个环节如果不是会签，assigneeList就白赋值了)
		if (taskVar.get("signAuditRate") != null && taskVar.get("auditor") != null) {
			System.out.println("1会签时====" + taskVar.get("auditor"));
			taskVar.put("assigneeList", taskVar.get("auditor"));
		}
		
		// 处理本次任务，同时指定下一次任务可用的变量(taskVar)
		taskService.complete(task.getId(), taskVar);
		return "true";
	}

	/**
	 * 通过流程定义id启动流程，包括启动+第一步执行（一般第一步都是启动人/申请人）
	 * 申请人启动流程后，流程就会到达“提交任务”，而“提交任务”的办理人还是该申请人
	 * ，这个时候就需要通过代码跳过（自动处理）该任务节点，让流程流转到下一任务节点
	 * variables里要有starter这个变量，并且要value要设置为启动人本人。 对应的，在画图的时候，第一个任务节点的candidate
	 * users要添加一个starter变量
	 * 
	 * @author zhf
	 * @date 2018年5月3日 下午2:08:57
	 */
	@ApiOperation(value = "启动流程-id（测试）", notes = "传入新的部署流程id值来启动（测试）")
	@RequestMapping(value = "/workflow-provider/workflow/start/id", method = RequestMethod.POST)
	public String startWorkflowByProcessDefinitionId(@RequestBody WorkflowVo workflowVo) {
		System.out.println("---startWorkflowByProcessDefinitionId开始启动流程，并同时处理发起人的第一个任务---");

		// 校验流程定义是否存在（.latestVersion()）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.createProcessDefinitionQuery().processDefinitionId(workflowVo.getProcessDefineId()).active().singleResult();
		if (processDefinitionEntity == null)
			return "流程启动失败id为'" + workflowVo.getProcessDefineId() + "'的流程定义不存在";
		// 启动流程, 根据key获取最新版本的流程定义
		ProcessInstance processInstance = null;
		try {
			// 设置流程启动人
			identityService.setAuthenticatedUserId(workflowVo.getAuthenticatedUserId());
			processInstance = runtimeService.startProcessInstanceById(workflowVo.getProcessDefineId(), workflowVo.getBusinessId(), workflowVo.getVariables());
		} catch (Exception ex) {
			return "流程启动异常,异常原因：" + ex.getMessage();
		}

		// 把第一个节点任务同时办理了，variables中有变量为当前人的starter。（第一个节点在监听器中判断，不允许委托）
		Task task = null;
		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(workflowVo.getAuthenticatedUserId());
		List<Task> todoList = query.list();// 获取申请人的待办任务列表
		for (Task tmp : todoList) {
			if (tmp.getProcessInstanceId().equals(processInstance.getId())) {
				task = tmp;// 获取当前流程实例，当前申请人的待办任务
				break;
			}
		}

		// 如果第一步审批（就是发起人后的第一步）是需要选择审批人，而不是通过流程图自动配置的话，需要在发起之前把审批人信息放到workflowVo.getVariables()
		if (DelegationState.PENDING == task.getDelegationState()) {
			taskService.resolveTask(task.getId(), workflowVo.getVariables());
		}

		taskService.complete(task.getId(), workflowVo.getVariables());

		runtimeService.setProcessInstanceName(processInstance.getId(), workflowVo.getProcessInstanceName());
		System.out.println("---startWorkflowByProcessDefinitionId流程启动结束---");
		return "true";
	}

	/**
	 * 通过流程定义key启动流程，包括启动+第一步执行（一般第一步都是启动人/申请人）,key取最新的版本
	 * 申请人启动流程后，流程就会到达“提交任务”，而
	 * “提交任务”的办理人还是该申请人，这个时候就需要通过代码跳过（自动处理）该任务节点，让流程流转到下一任务节点
	 * variables里要有starter这个变量，并且要value要设置为启动人本人。 对应的，在画图的时候，第一个任务节点的candidate
	 * users要添加一个starter变量
	 * 
	 * @author zhf
	 * @date 2018年5月3日 下午2:08:57
	 */
	@ApiOperation(value = "启动流程-key（测试）", notes = "传入新的部署流程key值来启动（测试）")
	@RequestMapping(value = "/workflow-provider/workflow/start/key", method = RequestMethod.POST)
	public String startWorkflowByProcessDefinitionKey(@RequestBody WorkflowVo workflowVo) {

		// 校验流程定义是否存在（.latestVersion()）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.createProcessDefinitionQuery().processDefinitionKey(workflowVo.getProcessDefineKey()).active().singleResult();
		if (processDefinitionEntity == null)
			return "流程启动失败key为'" + workflowVo.getProcessDefineKey() + "'的流程定义不存在";

		// 启动流程, 根据key获取最新版本的流程定义
		ProcessInstance processInstance = null;
		try {
			// 设置流程启动人
			identityService.setAuthenticatedUserId(workflowVo.getAuthenticatedUserId());
			processInstance = runtimeService.startProcessInstanceByKey(workflowVo.getProcessDefineKey(), workflowVo.getBusinessId(), workflowVo.getVariables());
		} catch (Exception ex) {
			return "流程启动异常,异常原因：" + ex.getMessage();
		}

		// 把第一个节点任务同时办理了，variables中有变量为当前人的starter
		Task task = null;
		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(workflowVo.getAuthenticatedUserId());
		List<Task> todoList = query.list();// 获取申请人的待办任务列表
		for (Task tmp : todoList) {
			if (tmp.getProcessInstanceId().equals(processInstance.getId())) {
				task = tmp;// 获取当前流程实例，当前申请人的待办任务
				break;
			}
		}
		taskService.complete(task.getId(), workflowVo.getVariables());

		runtimeService.setProcessInstanceName(processInstance.getId(), workflowVo.getProcessInstanceName());

		return "true";
	}

	/**
	 * @param jsonStr
	 * @return 获取菜单已经配置的工作流程定义、工程、部门等信息
	 */
	@ApiOperation(value = "某个菜单已配置的流程list", notes = "获取菜单已经配置的工作流程定义、工程、部门等信息")
	@RequestMapping(value = "/workflow-provider/function/process-list", method = RequestMethod.POST)
	public JSONObject selectFunctionProcessDefineList(@RequestParam(value = "jsonStr", required = false) String jsonStr) {

		JSONObject retJson = workflowInstanceService.selectFunctionProcessDefineList(jsonStr);

		return retJson;
	}

	@ApiOperation(value = "保存菜单的流程配置", notes = "配置菜单流程，不同项目、不同部门可能有不同的流程")
	@RequestMapping(value = "/workflow-provider/function/add-config", method = RequestMethod.POST)
	public Integer insertFunctionProcessDefine(@RequestBody SysFunctionProdef prodef) {
		System.out.println("insertFunctionProcessDefine==================" + prodef);
		// 判断是否已经存在此配置，如果已经存在，不允许保存
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setFunctionId(prodef.getFunctionId());
		workflowVo.setUnitId(prodef.getUnitValue());
		workflowVo.setProjectId(prodef.getProjectId());
		System.out.println("1insertFunctionProcessDefine==================" + prodef.getFunctionId());
		System.out.println("2insertFunctionProcessDefine==================" + prodef.getUnitId());
		System.out.println("3insertFunctionProcessDefine==================" + prodef.getUnitShow());
		SysFunctionProdef fpd = workflowInstanceService.queryFunctionProdef(workflowVo);
		System.out.println("insertFunctionProcessDefine==================" + fpd);
		if (fpd != null) {
			System.out.println("1insertFunctionProcessDefine==================" + fpd);
			return -1;
		} else {
			System.out.println("2insertFunctionProcessDefine==================" + fpd);
			prodef.setUnitId(prodef.getUnitValue());
			prodef.setUnitName(prodef.getUnitShow());
			int retI = workflowInstanceService.insertFunctionProdef(prodef);
			return retI;
		}

	}

	/**
	 * @param jsonStr
	 * @return 业务系统处理驳回后业务
	 */
	@ApiOperation(value = "流程审批结束后的驳回操作", notes = "根据业务id和启动项目时的驳回路径调用此方法，处理业务逻辑")
	@RequestMapping(value = "/workflow-provider/task/reject/{businessId}", method = RequestMethod.POST)
	public Integer taskReject(@PathVariable(value = "businessId", required = true) String businessId) {

		System.out.println("======业务系统处理驳回后业务=======" + businessId);

		return 1;
	}

	/**
	 * @param jsonStr
	 * @return 业务系统处理审批流程都同意后业务
	 */
	@ApiOperation(value = "流程审批结束后的同意操作", notes = "根据业务id和启动项目时的同意路径调用此方法，处理业务逻辑")
	@RequestMapping(value = "/workflow-provider/task/agree/{businessId}", method = RequestMethod.POST)
	public Integer taskAgree(@PathVariable(value = "businessId", required = true) String businessId) {

		System.out.println("======业务系统处理审批流程都同意后业务=======" + businessId);

		return 1;
	}

	/**
	 * @param jsonStr
	 * @return 删除对功能菜单配置的某个工作流
	 */
	@ApiOperation(value = "删除对菜单配置的某个工作流", notes = "支持批量删除，通过FunctionProdefId，多个id用‘,’隔开")
	@RequestMapping(value = "/workflow-provider/function/configures", method = RequestMethod.DELETE)
	public Integer deleteFunctionPordef(@RequestBody SysFunctionProdef sysFunctionProdef) {

		System.out.println("======删除对功能菜单配置的某个工作流=======" + sysFunctionProdef);
		System.out.println("======删除对功能菜单配置的某个工作流=======" + sysFunctionProdef.getFunctionProdefId());

		return workflowInstanceService.deleteFunctionProdef(sysFunctionProdef.getFunctionProdefId());
	}

	/**
	 * @param fileIds
	 * @return 导入工作流文件
	 */
	@ApiOperation(value = "导入工作流模型", notes = "导入文件类型为bpmn，支持多文件导入")
	@RequestMapping(value = "/workflow-provider/model/import/{fileIds}", method = RequestMethod.POST)
	public Integer importWorkflowFiles(@PathVariable(value = "fileIds", required = true) String fileIds) {

		System.out.println("======导入工作流文件=======" + fileIds);

		List<SysFile> fileList = new ArrayList<>();
		if (!StrUtil.isEmpty(fileIds)) {
			String[] fileIdArr = fileIds.split(",");
			SysFileExample sysFileExample = new SysFileExample();
			sysFileExample.getOredCriteria().add(sysFileExample.createCriteria().andIdIn(Arrays.asList(fileIdArr)));
			fileList = sysFileService.selectByExample(sysFileExample);
		}

		for (SysFile file : fileList) {
			try {
				String fileName = file.getFileName();
				if (fileName.endsWith(".bpmn20.xml") || fileName.endsWith(".bpmn")) {
					File temFile = new File(fileName);
					XMLInputFactory xif = XmlUtil.createSafeXmlInputFactory();
					FileInputStream ins = new FileInputStream(temFile);
					InputStreamReader in = new InputStreamReader(ins, "UTF-8");
					// InputStreamReader in = new InputStreamReader(new
					// ByteArrayInputStream(temFile.le ), "UTF-8");
					XMLStreamReader xtr = xif.createXMLStreamReader(in);
					BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);

					if (bpmnModel.getMainProcess() != null && bpmnModel.getMainProcess().getId() != null) {

						if (!bpmnModel.getLocationMap().isEmpty()) {

							String processName = bpmnModel.getMainProcess().getName();
							if (StringUtils.isEmpty(processName)) {
								processName = bpmnModel.getMainProcess().getId();
							}

							Model model = repositoryService.newModel();
							ObjectNode metaInfo = new ObjectMapper().createObjectNode();
							metaInfo.put("name", processName);
							metaInfo.put("revision", 1);

							model.setMetaInfo(metaInfo.toString());
							model.setName(processName);
							model.setTenantId("pcitc");
							// 固化
							model.setKey(fileName);

							repositoryService.saveModel(model);

							ObjectNode editorNode = new BpmnJsonConverter().convertToJson(bpmnModel);
							repositoryService.addModelEditorSource(model.getId(), editorNode.toString().getBytes("UTF-8"));
						}
					}
				}
			} catch (Exception e) {
				throw new ActivitiException("Error Import Model", e);
			}
		}
		return 1;
	}

	@RequestMapping(value = "/workflow-provider/process/defines/list", method = RequestMethod.POST)
	public Object selectProcessDefList(@RequestBody LayuiTableParam param) {
		System.out.println("1---------------------selectProcessDefList");
		
		int limit = 15;
		int page = 1;
		// 只查询已经激活的工作流定义
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery().active();
		if (param.getLimit() != null && !StrUtil.isBlankOrNull(param.getLimit().toString())) {
			limit = Integer.parseInt(param.getLimit().toString());
		}
		if (param.getPage() != null && !StrUtil.isBlankOrNull(param.getPage().toString())) {
			page = Integer.parseInt(param.getPage().toString());
		}
		if (param.getParam().get("processDefineName") != null && !StrUtil.isBlankOrNull(param.getParam().get("processDefineName").toString())) {
			query = query.processDefinitionNameLike("%" + param.getParam().get("processDefineName").toString() + "%");
		}
		List<ProcessDefinition> processDefList = query.orderByProcessDefinitionId().desc().listPage(limit * (page - 1), limit);
		
		List<ProcessDefVo> retList = new ArrayList<ProcessDefVo>();
		for (ProcessDefinition processDefinition : processDefList) {
			ProcessDefinitionEntity entity = (ProcessDefinitionEntity) processDefinition;
			ProcessDefVo vo = new ProcessDefVo();
			BeanUtils.copyProperties(entity, vo);
			retList.add(vo);
		}
		long count = query.count();
		LayuiTableData data = new LayuiTableData();
		data.setData(retList);
		data.setCount((int) count);
		System.out.println("2---------------------selectProcessDefList");
		return data;
	}
	
	
	/**
	 * 获取下一个用户任务信息
	 * 
	 * @param String
	 *            taskId 任务Id信息
	 * @return 下一个用户任务用户组信息
	 * @throws Exception
	 */
	public TaskDefinition getNextTaskInfo(String processInstanceId, Map<String, Object> globalVar) throws Exception {

		ProcessDefinitionEntity processDefinitionEntity = null;
		String id = null;
		TaskDefinition task = null;

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
			System.out.println("activityImpl.getActivityBehavior()=================="+activityImpl.getActivityBehavior().getClass());
			System.out.println("activityImpl.getActivityBehavior()=================="+activityImpl.getActivityBehavior().getClass().getName());
			if (activityImpl.getActivityBehavior().getClass().getName().contains("UserTaskActivityBehavior")) {
				TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior()).getTaskDefinition();
				return taskDefinition;
			} else if (activityImpl.getActivityBehavior().getClass().getName().contains("ParallelMultiInstanceBehavior")) {
				ParallelMultiInstanceBehavior paralBehavior =  (ParallelMultiInstanceBehavior)activityImpl.getActivityBehavior();
				return ((UserTaskActivityBehavior)paralBehavior.getInnerActivityBehavior()).getTaskDefinition();
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
					System.out.println("userTask1---------------"+ac.getProperty("type"));
					//return ((UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).getTaskDefinition();
					if(((ActivityImpl) ac).getActivityBehavior() instanceof UserTaskActivityBehavior){
						UserTaskActivityBehavior aaBehavior = (UserTaskActivityBehavior)((ActivityImpl) ac).getActivityBehavior();
						return ((UserTaskActivityBehavior)aaBehavior).getTaskDefinition();
					} else if(((ActivityImpl) ac).getActivityBehavior() instanceof ParallelMultiInstanceBehavior){
						ParallelMultiInstanceBehavior aaBehavior = (ParallelMultiInstanceBehavior)((ActivityImpl) ac).getActivityBehavior();
						return ((UserTaskActivityBehavior)aaBehavior.getInnerActivityBehavior()).getTaskDefinition();
					}
				} else {
					System.out.println("userTask2---------------"+ac.getProperty("type"));
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
}
