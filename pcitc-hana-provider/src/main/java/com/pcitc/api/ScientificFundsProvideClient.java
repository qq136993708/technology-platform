package com.pcitc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.ICommonService;
import com.pcitc.service.IScientificFundsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "Decision-API",description = "科技经费相关的接口")
@RestController
@RequestMapping("/hana/scientificFunds") 
public class ScientificFundsProvideClient {
	
	
	@Autowired
	private IScientificFundsService scientificFundsService;
	
	@Autowired
	private ICommonService commonService;
	
	
	@ApiOperation(value = "课题直间接费用统计表", notes = "课题直间接费用统计表")
	@RequestMapping(value = "/ktzjjfytjb", method = RequestMethod.POST)
	public LayuiTableData ktzjjfytjb(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getKtzjjfytjbData(param);
	}
	
	
	
	
	@ApiOperation(value = "人工成本支出统计表", notes = "人工成本支出统计表")
	@RequestMapping(value = "/rgcbzctjb", method = RequestMethod.POST)
	public LayuiTableData rgcbzctjb(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getRgcbzctjbData(param);
	}
	
	
	
	@ApiOperation(value = "原材料支出统计表", notes = "原材料支出统计表")
	@RequestMapping(value = "/yclzctjb", method = RequestMethod.POST)
	public LayuiTableData yclzctjb(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getYclzctjbData(param);
	}
	
	
	@ApiOperation(value = "能耗支出统计表", notes = "能耗支出统计表")
	@RequestMapping(value = "/nhzctjb", method = RequestMethod.POST)
	public LayuiTableData nhzctjb(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getNhzctjbData(param);
	}
	
	
	
	@ApiOperation(value = "项目资金流向分析", notes = "项目资金流向分析")
	@RequestMapping(value = "/xmzjlxfx", method = RequestMethod.POST)
	public LayuiTableData xmzjlxfx(@RequestBody LayuiTableParam param)throws Exception
	{
		return scientificFundsService.getXmzjlxfxData(param);
	}
	
	
}
