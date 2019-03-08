package com.pcitc.web.workflow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.util.StrUtil;
import com.pcitc.service.system.UserService;
import com.pcitc.service.workflow.TaskInstanceService;
import com.pcitc.service.workflow.WorkflowInstanceService;

@Api(value = "Activity-API", description = "流程相关的接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ActivityProviderClient {

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

	@ApiOperation(value = "查询所有流程模型", notes = "查询条件：模型名称；分页查询")
	@RequestMapping(value = "/activity-provider/model/list", method = RequestMethod.POST)
	public Object selectPendingList(@RequestBody LayuiTableParam param) {
		int limit = 15;
		int page = 1;
		String modelName = null;

		ModelQuery mq = repositoryService.createModelQuery();
		if (param.getLimit() != null && !StrUtil.isBlankOrNull(param.getLimit().toString())) {
			limit = Integer.parseInt(param.getLimit().toString());
		}
		if (param.getPage() != null && !StrUtil.isBlankOrNull(param.getPage().toString())) {
			page = Integer.parseInt(param.getPage().toString());
		}
		if (param.getParam().get("modelName") != null && !StrUtil.isBlankOrNull(param.getParam().get("modelName").toString())) {
			modelName = "%" + param.getParam().get("modelName").toString() + "%";
			mq = mq.modelNameLike(modelName);
		}

		List<Model> resultList = mq.orderByLastUpdateTime().desc().listPage(limit * (page - 1), limit);
		LayuiTableData data = new LayuiTableData();
		data.setData(resultList);
		data.setCount((int) mq.count());
		return data;
	}

}
