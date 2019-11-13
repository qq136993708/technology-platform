package com.pcitc.web.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreProjectAssess;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.mapper.equipment.SreProjectAssessMapper;
import com.pcitc.service.equipment.SreProjectTaskAcService;
import com.pcitc.service.equipment.SreScrapApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "ProjectTaskAc-API",tags = {"课题"})
@RestController
public class ProjectTaskAcClient {
	
	private final static Logger logger = LoggerFactory.getLogger(ProjectTaskAcClient.class); 
	@Autowired
    private SreProjectTaskAcService sreProjectTaskAcService; 
	@Autowired
	private SreProjectAssessMapper sreProjectAssessMapper;
	@ApiOperation(value = "课题审核分页", notes = "课题审核分页")
	@RequestMapping(value = "/sre-provider/sreProjectTaskAc/page", method = RequestMethod.POST)
	public LayuiTableData getsreProjectTaskAcList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=sreProjectTaskAcService.getlist(param);
		return rageResult;
	}

	@ApiOperation(value = "课题申请审核", notes = "课题申请审核")
	@RequestMapping(value = "/sre-provider/sreProjectTaskAc/submitaudit", method = RequestMethod.POST)
	public String submitaudit(@RequestBody SreProjectAudit record)throws Exception
	{
		int i=sreProjectTaskAcService.updateAuditById(record);
		if(i>0)
		{
			return "success";
			}
		else {
			return "error";
		}
	}
	@ApiOperation(value = "获取课题申请", notes = "根据ID获取课题申请")
	@RequestMapping(value = "/sre-provider/sreProjectTaskAc/get/{id}", method = RequestMethod.GET)
	public SreProjectAudit selectSrePurchaseById(@PathVariable(value = "id", required = true) String id) throws Exception
	{
		return sreProjectTaskAcService.selectProjectAuditById(id);
	}
	
	@ApiOperation(value = "更改申请", notes = "更改申请")
	@RequestMapping(value = "/sre-provider/sreProjectTaskAc/updateAudit", method = RequestMethod.POST)
	public int updateByPrimaryKey(@RequestBody SreProjectAudit record) throws Exception
	{
		return sreProjectTaskAcService.updateByPrimaryKey(record);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ApiOperation(value = "课题审核分页", notes = "课题审核分页")
	@RequestMapping(value = "/sre-provider/sreProjectAssess/page", method = RequestMethod.POST)
	public LayuiTableData getsreProjectAssessList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=sreProjectTaskAcService.getlistassess(param);
		return rageResult;
	}

	@ApiOperation(value = "课题申请审核", notes = "课题申请审核")
	@RequestMapping(value = "/sre-provider/sreProjectAssess/submitAssess", method = RequestMethod.POST)
	public String submitAssess(@RequestBody SreProjectAssess record)throws Exception
	{
		int i=sreProjectTaskAcService.updateAssessById(record);
		if(i>0)
		{
			return "success";
			}
		else {
			return "error";
		}
	}
	@ApiOperation(value = "获取课题申请", notes = "根据ID获取课题申请")
	@RequestMapping(value = "/sre-provider/sreProjectAssess/get/{id}", method = RequestMethod.GET)
	public SreProjectAssess selectAssessById(@PathVariable(value = "id", required = true) String id) throws Exception
	{
		return sreProjectTaskAcService.selectProjectAssessById(id);
	}
	
	@ApiOperation(value = "更改申请", notes = "更改申请")
	@RequestMapping(value = "/sre-provider/sreProjectAssess/updateAssess", method = RequestMethod.POST)
	public int updateAssessByPrimaryKey(@RequestBody SreProjectAssess record) throws Exception
	{
		return sreProjectTaskAcService.updateAssessByPrimaryKey(record);
	}
	
	@RequestMapping(value = "/sre-provider/sreProjectAssess/Assess", method = RequestMethod.POST)
	public String addAssess(@RequestBody SreProjectAssess sreProjectAssess)throws Exception{
		return sreProjectTaskAcService.addAssess(sreProjectAssess);
	}

	@ApiOperation(value = "根据ID删除",notes = "根据ID删除")
	@RequestMapping(value = "/sre-provider/sreProjectTaskAc/delete/{id}",method = RequestMethod.GET)
	public int  delete(@PathVariable("id") String id) throws Exception{
		logger.info("=============================delete sreProjectTaskAc=================");
		return sreProjectTaskAcService.delete(id);
	}

	@RequestMapping(value = "/sre-provider/sreProjectAssess/delete/{id}", method = RequestMethod.POST)
	public int deleteSreForapplication(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete sreForapplication=================");
		Integer count =  sreProjectTaskAcService.deleteDetail(id);
		return count;
	}
}
