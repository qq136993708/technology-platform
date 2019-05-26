package com.pcitc.web.Intlproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectContract;
import com.pcitc.service.intlproject.IntlProjectContractService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="项目签约接口",tags= {"国际合作-项目签约操作服务接口"})
@RestController
public class IntlProjectContractProviderClient 
{
	@Autowired
	IntlProjectContractService intlProjectContractService;
	
	@ApiOperation(value="分页检索已签约项目",notes="检索签约项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/contract-list", method = RequestMethod.POST)
	public Object selectContractByPage(@RequestBody LayuiTableParam param) 
	{
		return intlProjectContractService.selectProjectContractList(param);
	}
	@ApiOperation(value="分页检索待续约项目",notes="检索已过期待续约项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/contract-end-list", method = RequestMethod.POST)
	public Object selectEndContractByPage(@RequestBody LayuiTableParam param) 
	{
		return intlProjectContractService.selectEndProjectContractList(param);
	}
	
	@ApiOperation(value="添加签约项目",notes="添加签约项目信息。")
	@RequestMapping(value = "/stp-provider/project/add-contract", method = RequestMethod.POST)
	public Integer insertProjectContract(@RequestBody IntlProjectContract contract) 
	{
		
		return intlProjectContractService.addIntlProjectContract(contract);
	}
	@ApiOperation(value="更新签约项目",notes="更新签约项目信息。")
	@RequestMapping(value = "/stp-provider/project/upd-contract", method = RequestMethod.POST)
	public Integer updProjectContract(@RequestBody IntlProjectContract contract) 
	{
	
		return intlProjectContractService.updateIntlProjectContract(contract);
	}
	@ApiOperation(value="删除签约项目",notes="删除签约项目信息（逻辑删除）。")
	@RequestMapping(value = "/stp-provider/project/contract-close/{contractId}", method = RequestMethod.POST)
	public Object delProjectContractClose(@PathVariable("contractId") String contractId) 
	{
		
		return intlProjectContractService.delIntlProjectContract(contractId);
		
	}
	@ApiOperation(value="删除签约项目",notes="删除签约项目信息（物理删除）。")
	@RequestMapping(value = "/stp-provider/project/contract-delete/{contractId}", method = RequestMethod.POST)
	public Object delProjectContractReal(@PathVariable("contractId") String contractId) 
	{
		return intlProjectContractService.delIntlProjectContractReal(contractId);
		
	}
	@ApiOperation(value="检索签约项目",notes="检索签约项目信息（根据项目ID）。")
	@RequestMapping(value = "/stp-provider/project/get-contract/{contractId}", method = RequestMethod.POST)
	public IntlProjectContract findProjectContract(@PathVariable("contractId") String contractId) 
	{
	
		return intlProjectContractService.findById(contractId);
	}
	@ApiOperation(value="获取签约代码",notes="签约项目编号。")
	@RequestMapping(value = "/stp-provider/project/project-contract-code", method = RequestMethod.POST)
	public Object getProjectContractCode(@RequestBody IntlProjectContract contract) 
	{
	
		return intlProjectContractService.createProjectContractCode();
	}
}
