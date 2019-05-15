package com.pcitc.web.equipment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePlanCompletion;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.service.equipment.InvestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "InvestmentProgress-API",tags = {"投资进度接口"})
@RestController
public class InvestmentProgressProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(InvestmentProgressProviderClient.class); 
	@Autowired
    private InvestService investService; 
	
    private final static String WORKFLOW_DEFINE_ID = "intl_notice:3:1117555";
	
	
	
	@ApiOperation(value = "投资进度分页", notes = "投资进度分页")
	@RequestMapping(value = "/sre-provider/Investmentrogress/page", method = RequestMethod.POST)
	public LayuiTableData getForApplicationList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=investService.getInvestmentrogressPage(param);
		return rageResult;
	}
	/*==================================采购计划进度分页=============================*/
	@ApiOperation(value = "投资进度分页", notes = "投资进度分页")
	@RequestMapping(value = "/sre-provider/Investmentrogress/prppage", method = RequestMethod.POST)
	public LayuiTableData getProcurementProgramList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=investService.getProcurementProgramPage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "管理台账", notes = "管理台账")
	@RequestMapping(value = "/sre-provider/Investmentrogress/management", method = RequestMethod.POST)
	public int getProcurementProgramList()throws Exception
	{
		List<SreProject> ProjectTask = investService.getSelectProject();
		int count = 0;
		for(int i =0;i<ProjectTask.size();i++) {
			count++;
		}
		return count;
	}
	
	/*==================================计划完成管理台账=============================*/
	@ApiOperation(value = "设备全过程统计大表", notes = "设备全过程统计大表")
	@RequestMapping(value = "/sre-provider/mana/page", method = RequestMethod.POST)
	public LayuiTableData getManagementLedgerList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=investService.getManagementLedgerPage(param);
		return rageResult;
	}
}
