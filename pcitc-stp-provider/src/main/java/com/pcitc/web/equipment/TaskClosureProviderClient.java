package com.pcitc.web.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.equipment.DetailService;
import com.pcitc.service.equipment.EquipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "TaskClosure-API",tags = {"验收管理相关的接口"})
@RestController
public class TaskClosureProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(TaskClosureProviderClient.class); 
	@Autowired
    private EquipmentService equipmentService; 
	
	@Autowired
    private DetailService detailService; 
	
    private final static String WORKFLOW_DEFINE_ID = "intl_notice:3:1117555";
	
	
	
    @ApiOperation(value = "任务关闭列表", notes = "任务关闭列表")
	@RequestMapping(value = "/sre-provider/task_closure/page", method = RequestMethod.POST)
	public LayuiTableData getTaskClosureList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		logger.info("==================page SreSreProjectTask==========================="+paramsJson);
		return equipmentService.getSreTaskClosurePage(paramsJson);
	}
}
