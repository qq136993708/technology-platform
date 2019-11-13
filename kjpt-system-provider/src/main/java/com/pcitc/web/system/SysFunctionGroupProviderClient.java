package com.pcitc.web.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFunctionGroup;
import com.pcitc.service.system.SysFunctionGroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="权限分组接口",tags= {"权限分组相关操作服务接口"})
@RestController
public class SysFunctionGroupProviderClient 
{

	@Autowired
	private SysFunctionGroupService functionGroupService;
	
	@ApiOperation(value="检索权限分组(不分页)",notes="检索所有的权限分组信息，不带分页。")
	@RequestMapping(value = "/functiongroup-provider/functiongroup/functiongroup-list", method = RequestMethod.POST)
	public Object selectSysFunctionGroupList() 
	{
		return functionGroupService.selectFunctionGroupList();
	}
	@ApiOperation(value="检索权限分组(带分页)",notes="分页检索所有的权限分组信息，带检索条件。")
	@RequestMapping(value = "/functiongroup-provider/functiongroup/functiongroup-table", method = RequestMethod.POST)
	public Object selectSysFunctionGroupTable(@RequestBody LayuiTableParam param) 
	{
		return functionGroupService.selectFunctionGroupByPage(param);
	}
	@ApiOperation(value="检索分组权限",notes="根据分组ID检索分组权限下所有权限ID列表。")
	@RequestMapping(value = "/functiongroup-provider/functiongroup/functiongroup-functions/{groupId}", method = RequestMethod.POST)
	public Object selectFunctionGroupFunction(@PathVariable(value = "groupId", required = true) String groupId) 
	{
		return functionGroupService.selectSysFunctionGroupFunctions(groupId);
	}

	@ApiOperation(value="检索分组详情",notes="根据分组ID检索权限分组信息。")
	@RequestMapping(value = "/functiongroup-provider/functiongroup/functiongroup-info/{groupId}", method = RequestMethod.POST)
	public Object selectFunctionGroupInfo(@PathVariable(value = "groupId", required = true) String groupId) 
	{
		return functionGroupService.selectSysFunctionGroupById(groupId);
	}
	
	@ApiOperation(value="删除分组(物理删除)",notes="根据分组ID删除分组信息，同时解除已保存的分组权限关系。")
	@RequestMapping(value = "/functiongroup-provider/functiongroup/functiongroup-del/{groupId}", method = RequestMethod.POST)
	public Object delFunctionGroupInfo(@PathVariable(value = "groupId", required = true) String groupId) 
	{
		return functionGroupService.delSysFunctionGroupInfo(groupId);
	}
	
	@ApiOperation(value="保存或更新分组",notes="保存或者更新分组信息，不包含权限关系。")
	@RequestMapping(value = "/functiongroup-provider/functiongroup/functiongroup-update", method = RequestMethod.POST)
	public Object updateFunctionGroupInfo(@RequestBody SysFunctionGroup functionGroup) 
	{
		return functionGroupService.saveSysFunctionGroupInfo(functionGroup);
	}
	@ApiOperation(value="更新分组权限",notes="更新分组权限信息，更新分组与权限关系。")
	@RequestMapping(value = "/functiongroup-provider/functiongroup/functiongroup-update-functions", method = RequestMethod.POST)
	public Object updateFunctionGroupRole(@RequestBody SysFunctionGroup functionGroup) 
	{
		return functionGroupService.updatSysFunctionGroupRole(functionGroup);
	}

}
