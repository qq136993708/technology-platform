package com.pcitc.web.Intlproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.service.intlproject.IntlProjectInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="项目立项接口",tags= {"国际合作-项目立项操作服务接口"})
@RestController
public class IntlProjectInfoProviderClient 
{
	@Autowired
	IntlProjectInfoService intlProjectInfoService;
	
	
	
	@ApiOperation(value="分页检索立项项目",notes="检索立项项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/info-list")
	public Object getWorkflowPassApplyProject(@RequestBody LayuiTableParam param) throws Exception 
	{
		return intlProjectInfoService.selectProjectInfoByPage(param);
	}
	
	@ApiOperation(value="检索立项项目列表",notes="检索全部立项项目数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/info-list-all")
	public Object getAllProject() throws Exception 
	{
		return intlProjectInfoService.selectAllProjectInfo();
	}
	
	@ApiOperation(value="检索立项项目",notes="检索立项项目数据，返回立项数据详情。")
	@RequestMapping(value = "/stp-provider/project/get-project/{projectId}", method = RequestMethod.POST)
	public IntlProjectInfo findPlantInfo(@PathVariable("projectId") String projectId) 
	{
		return intlProjectInfoService.findById(projectId);
	}
	@ApiOperation(value="添加/更新立项项目",notes="添加/更新立项项目数据。")
	@RequestMapping(value = "/stp-provider/project/addorupd-project", method = RequestMethod.POST)
	public Integer insertProjectInfo(@RequestBody IntlProjectInfo project) 
	{
		return intlProjectInfoService.saveOrUpdate(project);
	}
	@ApiOperation(value="删除立项项目",notes="删除立项项目数据")
	@RequestMapping(value = "/stp-provider/project/del-project/{projectId}", method = RequestMethod.POST)
	public Integer delProjectInfo(@PathVariable("projectId") String projectId) 
	{
		return intlProjectInfoService.delProjectInfoReal(projectId);
	}
	@ApiOperation(value="关闭立项项目",notes="关闭立项项目数据(逻辑删除)")
	@RequestMapping(value = "/stp-provider/project/close-project/{projectId}", method = RequestMethod.POST)
	public Integer closeProjectInfo(@PathVariable("projectId") String projectId) 
	{
		return intlProjectInfoService.delProjectInfo(projectId);
	}
	@ApiOperation(value="立项审批流程",notes="发起立项内容审批")
	@RequestMapping(value = "/stp-provider/project/start-info-activity/{projectId}", method = RequestMethod.POST)
	public Object startNoticeWorkFlow(@PathVariable("projectId") String projectId,@RequestBody WorkflowVo workflowVo) 
	{
		IntlProjectInfo info = intlProjectInfoService.findById(projectId);
		if(WorkFlowStatusEnum.STATUS_RUNNING.getCode().equals(info.getFlowStartStatus()) || WorkFlowStatusEnum.STATUS_PASS.getCode().equals(info.getFlowStartStatus())) 
		{
			return new Result(false,"已发起审批不可重复发起！");
		}
		boolean status = intlProjectInfoService.startWorkFlow(workflowVo.getBusinessId(), workflowVo.getFunctionId(), workflowVo.getProcessDefinitionName(), workflowVo.getAuthenticatedUserId(), workflowVo.getAuthenticatedUserName());
		if(status) 
		{
			return new Result(true,"操作成功!");
		}else {
			return new Result(false,"操作失败!");
		}
	}
	@ApiOperation(value="审批流程回调通知",notes="审批结果回调通知")
	@RequestMapping(value = "/stp-provider/project/callback-workflow-info")
	public Object callBackProjectApplyWorkflow(@RequestParam(value = "projectId", required = true) String projectId,
			@RequestParam(value = "workflow_status", required = true) Integer workflow_status) throws Exception 
	{
		if(projectId != null) {
			IntlProjectInfo info = intlProjectInfoService.findById(projectId);
			if(info != null) {
				info.setFlowCurrentStatus(workflow_status);
				intlProjectInfoService.saveOrUpdate(info);
			}
		}
		return null;
	}
	@ApiOperation(value="获取签约代码",notes="签约项目编号。")
	@RequestMapping(value = "/stp-provider/project/project-info-code", method = RequestMethod.POST)
	public Object getProjectContractCode(@RequestBody IntlProjectInfo project) 
	{
		System.out.println("project-info-codeproject-info-codeproject-info-code");
		return intlProjectInfoService.createProjectInfoCode();
	}
}
