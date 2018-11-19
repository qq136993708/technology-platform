package com.pcitc.web.Intlproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.service.intlproject.IntlProjectInfoService;
import com.pcitc.web.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="项目立项接口",tags= {"国际合作-项目立项操作服务接口"})
@RestController
public class IntlProjectInfoProviderClient 
{
	@Autowired
	IntlProjectInfoService intlProjectInfoService;
	
	private final static String WORKFLOW_DEFINE_ID = "projectApply:1:150007";
	
	@Autowired
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="分页检索立项项目",notes="检索立项项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/info-list")
	public Object getWorkflowPassApplyProject(@RequestBody LayuiTableParam param) throws Exception 
	{
		return intlProjectInfoService.selectProjectInfoByPage(param);
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
	public Integer startNoticeWorkFlow(@PathVariable("projectId") String projectId,@RequestBody WorkflowVo workflowVo) 
	{
		IntlProjectInfo info = intlProjectInfoService.findById(projectId);
		//workflowVo.setAuthenticatedUserId("111");
		workflowVo.setProcessDefineId(WORKFLOW_DEFINE_ID); 
		workflowVo.setBusinessId(projectId);
		workflowVo.setProcessInstanceName("立项审批："+info.getProjectName());
		Map<String, Object> variables = new HashMap<String, Object>();  
		//starter为必填项。流程图的第一个节点待办人变量必须为starter
        variables.put("starter", workflowVo.getAuthenticatedUserId());
        
        //必须设置。流程中，需要的第二个节点的指派人；除starter外，所有待办人变量都指定为auditor(处长审批)
        //处长审批 ZSH_JTZSZYC_GJHZC_CZ
        List<SysUser> users = systemRemoteClient.selectUsersByPostCode("ZSH_JTZSZYC_GJHZC_CZ");
        System.out.println("start userIds ... "+JSON.toJSONString(users));
        variables.put("auditor", workflowVo.getAuthenticatedUserId());
        if(users != null && users.size()>0) {
        	variables.put("auditor", users.get(0).getUserId());
        }
        
        //必须设置，统一流程待办任务中需要的业务详情
        variables.put("auditDetailsPath", "/intl_project/info_view?projectId="+projectId);
       
        //流程完全审批通过时，调用的方法
        variables.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/intl_project/notice_view?noticeId="+projectId);
        
        //流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
        variables.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/intl_project/notice_view?noticeId="+projectId);
        
        workflowVo.setVariables(variables);
		String rs = systemRemoteClient.startWorkflowByProcessDefinitionId(workflowVo);
		System.out.println("startwork  apply  rs...."+rs);
		if("true".equals(rs)){
			return 1;
		}else{
			return 0;
		}
	}
}
