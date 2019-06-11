package com.pcitc.web.Intlproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectPlant;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.service.intlproject.IntlProjectPlantService;

@RestController
public class IntlProjectPlantProviderClient 
{
	private final static Logger logger = LoggerFactory.getLogger(IntlProjectPlantProviderClient.class);

	@Autowired
	private IntlProjectPlantService projectPlantService;
	
	
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
	public Object satrtPlantActivity(@PathVariable("plantId") String plantId,@RequestBody WorkflowVo workflowVo) 
	{
		logger.info("startwork  plant....");
		IntlProjectPlant plant = projectPlantService.findProjectPlant(plantId);
		//如果审批已发起则不能再次发起
		if(!WorkFlowStatusEnum.STATUS_WAITING.getCode().equals(plant.getFlowStartStatus())) 
		{
			return new Result(false,"已发起审批不可重复发起！");
		}
		boolean status = projectPlantService.startWorkFlow(workflowVo.getBusinessId(), workflowVo.getFunctionId(), workflowVo.getProcessDefinitionName(), workflowVo.getAuthenticatedUserId(), workflowVo.getAuthenticatedUserName());
		if(status) 
		{
			return new Result(true,"操作成功!");
		}else {
			return new Result(false,"操作失败!");
		}
	}
	//工作流审批通过后回调通知相关人员
	@RequestMapping(value = "/stp-provider/project/callback-workflow-plant", method = RequestMethod.POST)
	public Integer sentPlantMail(@RequestParam(value = "plantId", required = true) String plantId,
			@RequestParam(value = "workflow_status", required = true) Integer workflow_status) 
	{
		logger.info("callback-workflow-plant....");
		IntlProjectPlant plant = projectPlantService.findProjectPlant(plantId);
		if(plant != null) {
			plant.setFlowCurrentStatus(workflow_status);
			projectPlantService.updProjectPlant(plant);
		}
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
	
	@RequestMapping(value = "/stp-provider/project/project-plant-code", method = RequestMethod.POST)
	public Object getPlantCode(@RequestBody IntlProjectPlant plant) 
	{
		return projectPlantService.createPlantCode();
	}
}
