package com.pcitc.web.Intlproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectAccept;
import com.pcitc.common.AcceptStatusEnum;
import com.pcitc.service.intlproject.IntlProjectAcceptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="项目验收接口",tags= {"国际合作-项目验收操作服务接口"})
@RestController
public class IntlProjectAcceptProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(IntlProjectAcceptProviderClient.class);

	
	@Autowired
	private IntlProjectAcceptService projectAcceptService;
	
	
	@ApiOperation(value="分页检索验收项目",notes="检索待验收项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/accept-pass-list", method = RequestMethod.POST)
	public Object selectProjectPassAcceptList(@RequestBody LayuiTableParam param) 
	{
		logger.info("accept-list...");
		param.getParam().put("status", AcceptStatusEnum.STATUS_PASS.getCode());
		return projectAcceptService.selectProjectAcceptList(param);
	}
	@ApiOperation(value="分页检索验收项目",notes="检索待验收项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/accept-process", method = RequestMethod.POST)
	public Object saveProjectProcess(@RequestBody IntlProjectAccept accept) 
	{
		logger.info("accept-list...");
		return projectAcceptService.saveProjectAccept(accept);
	}
	
	@ApiOperation(value="分页检索验收项目",notes="检索待验收项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/accept-refuse-list", method = RequestMethod.POST)
	public Object selectProjectRefuseAcceptList(@RequestBody LayuiTableParam param) 
	{
		param.getParam().put("status", AcceptStatusEnum.STATUS_REFUSE.getCode());
		return projectAcceptService.selectProjectAcceptList(param);
	}
	
	@ApiOperation(value="分页检索验收项目",notes="检索待验收项目列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/accept-list", method = RequestMethod.POST)
	public Object selectProjectAcceptList(@RequestBody LayuiTableParam param) 
	{
		return projectAcceptService.selectProjectWaitingAcceptList(param);
	}
	
	@ApiOperation(value="添加验收项目",notes="添加验收项目信息。")
	@RequestMapping(value = "/stp-provider/project/add-accept", method = RequestMethod.POST)
	public Integer insertProjectAccept(@RequestBody IntlProjectAccept accept) 
	{
		return projectAcceptService.saveProjectAccept(accept);
	}
	@ApiOperation(value="更新项目验收",notes="更新项目验收信息。")
	@RequestMapping(value = "/stp-provider/project/upd-accept", method = RequestMethod.POST)
	public Integer updProjectResult(@RequestBody IntlProjectAccept accept) 
	{
		return projectAcceptService.updProjectAccept(accept);
	}
	@ApiOperation(value="删除项目验收",notes="删除项目验收信息（逻辑删除）。")
	@RequestMapping(value = "/stp-provider/project/close-accept/{acceptId}", method = RequestMethod.POST)
	public Integer delProjectAcceptClose(@PathVariable("acceptId") String acceptId) 
	{
		return projectAcceptService.delProjectAccept(acceptId);
	}
	@ApiOperation(value="删除项目验收",notes="删除项目验收信息（物理删除）。")
	@RequestMapping(value = "/stp-provider/project/del-accept/{acceptId}", method = RequestMethod.POST)
	public Integer delProjectAcceptReal(@PathVariable("acceptId") String acceptId) 
	{
		return projectAcceptService.delProjectAcceptReal(acceptId);
	}
	@ApiOperation(value="获取项目验收信息",notes="获取项目验收信息")
	@RequestMapping(value = "/stp-provider/project/get-accept/{acceptId}", method = RequestMethod.POST)
	public IntlProjectAccept getProjectAccept(@PathVariable("acceptId") String acceptId) 
	{
		return projectAcceptService.findProjectAccept(acceptId);
	}
}
