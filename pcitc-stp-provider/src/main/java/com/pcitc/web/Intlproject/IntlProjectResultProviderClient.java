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
import com.pcitc.base.stp.IntlProject.IntlProjectResult;
import com.pcitc.service.intlproject.IntlProjectResultService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="项目成果接口",tags= {"国际合作-项目成果操作服务接口"})
@RestController
public class IntlProjectResultProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(IntlProjectResultProviderClient.class);

	
	@Autowired
	private IntlProjectResultService projectResultService;
	
	
	@ApiOperation(value="分页检索项目成果",notes="检索项目成果列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/result-list", method = RequestMethod.POST)
	public Object selectProjectResultByPage(@RequestBody LayuiTableParam param) 
	{
		logger.info("remark-list...");
		return projectResultService.selectProjectReultByPage(param);
	}
	
	@ApiOperation(value="添加项目成果",notes="添加项目成果信息。")
	@RequestMapping(value = "/stp-provider/project/add-result", method = RequestMethod.POST)
	public Integer insertProjectResult(@RequestBody IntlProjectResult result) 
	{
		
		return projectResultService.saveProjectResult(result);
	}
	@ApiOperation(value="更新项目成果",notes="更新项目成果信息。")
	@RequestMapping(value = "/stp-provider/project/upd-result", method = RequestMethod.POST)
	public Integer updProjectResult(@RequestBody IntlProjectResult result) 
	{
	
		return projectResultService.updProjectResult(result);
	}
	@ApiOperation(value="删除项目成果",notes="删除项目成果信息（逻辑删除）。")
	@RequestMapping(value = "/stp-provider/project/close-result/{resultId}", method = RequestMethod.POST)
	public Integer delProjectResultClose(@PathVariable("resultId") String resultId) 
	{
	
		return projectResultService.delProjectResult(resultId);
	}
	@ApiOperation(value="删除项目成果",notes="删除项目成果信息（物理删除）。")
	@RequestMapping(value = "/stp-provider/project/del-result/{resultId}", method = RequestMethod.POST)
	public Integer delProjectResultReal(@PathVariable("resultId") String resultId) 
	{
	
		return projectResultService.delProjectResultReal(resultId);
	}
	@ApiOperation(value="检索项目成果",notes="检索项目成果信息（根据成果ID）。")
	@RequestMapping(value = "/stp-provider/project/get-result/{resultId}", method = RequestMethod.POST)
	public IntlProjectResult findProjectResult(@PathVariable("resultId") String resultId) 
	{
	
		return projectResultService.findProjectResult(resultId);
	}
	
}
