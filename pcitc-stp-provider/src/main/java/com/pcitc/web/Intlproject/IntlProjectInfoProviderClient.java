package com.pcitc.web.Intlproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.service.intlproject.IntlProjectInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="项目立项接口",tags= {"国际合作-项目立项操作服务接口"})
@RestController
public class IntlProjectInfoProviderClient 
{
	@Autowired
	IntlProjectInfoService intlProjectInfoService;
	
	@ApiOperation(value="分页检索立项项目",notes="检索立项项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/info-list")
	public Object getWorkflowPassApplyProject(@RequestBody LayuiTableParam param) throws Exception 
	{
		return intlProjectInfoService.selectProjectInfoByPage(param);
	}
	@ApiOperation(value="检索立项项目",notes="检索立项项目数据，返回立项数据详情。")
	@RequestMapping(value = "/stp-provider/project/get-project/{projectId}", method = RequestMethod.POST)
	public IntlProjectInfo findPlantInfo(@PathVariable("projectId") String projectId) 
	{
		return intlProjectInfoService.findById(projectId);
	}
	@ApiOperation(value="添加/更新立项项目",notes="添加/更新立项项目数据。")
	@RequestMapping(value = "/stp-provider/project/addorupd-project", method = RequestMethod.POST)
	public Integer insertProjectInfo(@RequestBody IntlProjectInfo project) 
	{
		return intlProjectInfoService.saveOrUpdate(project);
	}
	@ApiOperation(value="删除立项项目",notes="删除立项项目数据")
	@RequestMapping(value = "/stp-provider/project/del-project/{projectId}", method = RequestMethod.POST)
	public Integer delProjectInfo(@PathVariable("projectId") String projectId) 
	{
		return intlProjectInfoService.delProjectInfoReal(projectId);
	}
	@ApiOperation(value="关闭立项项目",notes="关闭立项项目数据(逻辑删除)")
	@RequestMapping(value = "/stp-provider/project/close-project/{projectId}", method = RequestMethod.POST)
	public Integer closeProjectInfo(@PathVariable("projectId") String projectId) 
	{
		return intlProjectInfoService.delProjectInfo(projectId);
	}
}
