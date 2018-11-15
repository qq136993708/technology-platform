package com.pcitc.web.Intlproject;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectPlant;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.common.MailBean;
import com.pcitc.service.intlproject.IntlProjectPlantService;
import com.pcitc.service.msg.MailSentService;
import com.pcitc.web.feign.SystemRemoteClient;

@RestController
public class IntlProjectPlantProviderClient 
{
	private final static Logger logger = LoggerFactory.getLogger(IntlProjectPlantProviderClient.class);

	private final static String WORKFLOW_DEFINE_ID = "project_plant:1:7";
	@Autowired
	private MailSentService mailSentService;
	
	@Autowired
	private IntlProjectPlantService projectPlantService;
	
	@Autowired
	private SystemRemoteClient systemRemoteClient;
	

	
	
	@RequestMapping(value = "/stp-provider/project/plant-list", method = RequestMethod.POST)
	public Object selectPlantByPage(@RequestBody LayuiTableParam param) 
	{
		Object tem = projectPlantService.selectProjectPlantByPage(param);
		logger.info("find notice list rs .... "+tem.toString());
		//test send mail
		return tem;
	}
	@RequestMapping(value = "/stp-provider/project/add-plant", method = RequestMethod.POST)
	public Integer insertPlantInfo(@RequestBody IntlProjectPlant plant) 
	{
		logger.info("save notice....");
		
		return projectPlantService.saveProjectPlant(plant);
	}
	@RequestMapping(value = "/stp-provider/project/upd-plant", method = RequestMethod.POST)
	public Integer updPlantInfo(@RequestBody IntlProjectPlant plant) 
	{
		logger.info("upd notice....");
	
		return projectPlantService.updProjectPlant(plant);
	}
	@RequestMapping(value = "/stp-provider/project/close-plant/{plantId}", method = RequestMethod.POST)
	public Integer delPlantClose(@PathVariable("plantId") String plantId) 
	{
		logger.info("del notice....");
	
		return projectPlantService.delProjectPlant(plantId);
	}
	@RequestMapping(value = "/stp-provider/project/del-plant/{plantId}", method = RequestMethod.POST)
	public Integer delPlantReal(@PathVariable("plantId") String plantId) 
	{
		logger.info("del notice....");
	
		return projectPlantService.delProjectPlantReal(plantId);
	}
	@RequestMapping(value = "/stp-provider/project/get-plant/{plantId}", method = RequestMethod.POST)
	public IntlProjectPlant findPlantInfo(@PathVariable("plantId") String plantId) 
	{
		logger.info("find notice....");
	
		return projectPlantService.findProjectPlant(plantId);
	}
	
	@RequestMapping(value = "/stp-provider/project/start-plant-activity/{plantId}", method = RequestMethod.POST)
	public Integer satrtPlantActivity(@PathVariable("plantId") String plantId) 
	{
		logger.info("startwork  plant....");
		WorkflowVo workflowVo = new WorkflowVo();
		workflowVo.setAuthenticatedUserId("111");
		workflowVo.setProcessDefineId(WORKFLOW_DEFINE_ID); 
		workflowVo.setBusinessId(plantId);
		workflowVo.setProcessInstanceName("业务任务名称（全流程不变）："+WORKFLOW_DEFINE_ID);
		Map<String, Object> variables = new HashMap<String, Object>();  
		//starter为必填项。流程图的第一个节点待办人变量必须为starter
        variables.put("starter", workflowVo.getAuthenticatedUserId());
        
        //必须设置。流程中，需要的第二个节点的指派人；除starter外，所有待办人变量都指定为auditor
        variables.put("auditor", workflowVo.getAuthenticatedUserId());
        
        //必须设置，统一流程待办任务中需要的业务详情
        variables.put("auditDetailsPath", "/pplus/workflow/task-details.html");
        
        workflowVo.setVariables(variables);
		String rs = systemRemoteClient.startWorkflowByProcessDefinitionId(workflowVo);
		if("true".equals(rs)){
			return 1;
		}else{
			return 0;
		}
	}
	//工作流审批通过后回调通知相关人员
	@RequestMapping(value = "/stp-provider/project/plant-mail-notice/{plantId}", method = RequestMethod.POST)
	public Integer sentPlantMail(@PathVariable("plantId") String plantId) 
	{
		logger.info("sent notice....");
		
		IntlProjectPlant plant = projectPlantService.findProjectPlant(plantId);
		
		mailSentService.sentMail(new MailBean("398078361@qq.com","项目审批通过",plant.getPlantContent()));
		
		return 1;
	}
	@RequestMapping(value = "/stp-provider/project/add-toplant", method = RequestMethod.POST)
	public Integer addToPlant(@RequestBody IntlProjectApplyPlant rel) 
	{
		logger.info("add rel....");
	
		return projectPlantService.addApplyPlantRel(rel.getApplyId(), rel.getPlantId());
	}
	@RequestMapping(value = "/stp-provider/project/del-fromplant", method = RequestMethod.POST)
	public Integer delFromPlant(@RequestBody IntlProjectApplyPlant rel) 
	{
		logger.info("del rel....");
	
		return projectPlantService.delApplyPlantRel(rel.getApplyId(), rel.getPlantId());
	}
}
