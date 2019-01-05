package com.pcitc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.ICommonService;
import com.pcitc.service.IScientificInvestmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Decision-API",description = "经费决策中心相关的接口")
@RestController
@RequestMapping("/hana/scientificInvestment") 
public class ScientificInvestmentClient {
	@Autowired
	private IScientificInvestmentService decisionFinancialService;
	
	@Autowired
	private ICommonService commonService;
	
	
	@ApiOperation(value = "科研仪器设备支出分析明细表", notes = "科研仪器设备支出分析明细表")
	@RequestMapping(value = "/tzxmwcqktjb_data", method = RequestMethod.POST)
	public LayuiTableData getTzxmwcqktjbData(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getTzxmwcqktjbData(param);
	}
	
	
}
