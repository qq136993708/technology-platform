package com.pcitc.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.ICommonService;
import com.pcitc.service.IScientificInvestmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Decision-API",description = "科研投资相关的接口")
@RestController
@RequestMapping("/hana/scientificInvestment") 
public class ScientificInvestmentClient {
	@Autowired
	private IScientificInvestmentService decisionFinancialService;
	
	@Autowired
	private ICommonService commonService;
	
	
	@ApiOperation(value = "投资项目完成情况统计表", notes = "投资项目完成情况统计表")
	@RequestMapping(value = "/tzxmwcqktjb", method = RequestMethod.POST)
	public LayuiTableData tzxmwcqktjb(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getTzxmwcqktjbData(param);
	}
	
	
	
	
	@ApiOperation(value = "导出-投资项目完成情况统计表", notes = "导出-投资项目完成情况统计表")
	@RequestMapping(value = "/tzxmwcqktjb_out_excel", method = RequestMethod.POST)
	public JSONArray tzxmwcqktjb_out_excel(@RequestBody Map map)throws Exception
	{
		return decisionFinancialService.getTzxmwcqktjbDataList(map);
	}
	
	
	
	
	@ApiOperation(value = "详情-投资项目完成情况统计表", notes = "详情-投资项目完成情况统计表")
	@RequestMapping(value = "/tzxmwcqktjb_detail_data", method = RequestMethod.POST)
	public JSONArray tzxmwcqktjb_detail_data(@RequestBody Map map)throws Exception
	{
		return decisionFinancialService.getTzxmwcqktjbDetailList(map);
	}
	
	
	
	
	
	
	@ApiOperation(value = "投资项目采购进度统计表", notes = "投资项目采购进度统计表")
	@RequestMapping(value = "/tzxmcgjdtjb", method = RequestMethod.POST)
	public LayuiTableData tzxmcgjdtjb(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getTzxmcgjdtjbData(param);
	}
	
	
	@ApiOperation(value = "导出-投资项目采购进度统计表", notes = "导出-投资项目采购进度统计表")
	@RequestMapping(value = "/tzxmcgjdtjb_out_excel", method = RequestMethod.POST)
	public JSONArray tzxmcgjdtjb_out_excel(@RequestBody Map map)throws Exception
	{
		return decisionFinancialService.getTzxmcgjdtjbDataList(map);
	}
	
	
	@ApiOperation(value = "详情-采购进度统计表", notes = "详情-采购进度统计表")
	@RequestMapping(value = "/tzxmcgjdtjb_detail_data", method = RequestMethod.POST)
	public JSONArray tzxmcgjdtjb_detail_data(@RequestBody Map map)throws Exception
	{
		return decisionFinancialService.getTzxmcgjdtjbDetailList(map);
	}
	
	
	
	
	
	
	
	@ApiOperation(value = "投资项目转出情况表", notes = "投资项目转出情况表")
	@RequestMapping(value = "/tzxmzcqkb", method = RequestMethod.POST)
	public LayuiTableData tzxmzcqkb(@RequestBody LayuiTableParam param)throws Exception
	{
		return decisionFinancialService.getTzxmzcqkbData(param);
	}
	
	
	
	
	@ApiOperation(value = "导出-投资项目转出情况表", notes = "导出-投资项目转出情况表")
	@RequestMapping(value = "/tzxmzcqkb_out_excel", method = RequestMethod.POST)
	public JSONArray tzxmzcqkb_out_excel(@RequestBody Map map)throws Exception
	{
		return decisionFinancialService.getTzxmzcqkbDataList(map);
	}
	
	
	@ApiOperation(value = "详情-转出情况表", notes = "详情-转出情况表")
	@RequestMapping(value = "/tzxmzcqkb_detail_data", method = RequestMethod.POST)
	public JSONArray tzxmzcqkb_detail_data(@RequestBody Map map)throws Exception
	{
		return decisionFinancialService.getTzxmzcqkbDetailList(map);
	}
	
	
	
	
}
