package com.pcitc.web.Intlproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.IntlProject.IntlProjectRemark;
import com.pcitc.service.intlproject.IntlProjectRemarkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="项目纪要接口",tags= {"国际合作-项目纪要操作服务接口"})
@RestController
public class IntlProjectRemarkProviderClient 
{
	//private final static Logger logger = LoggerFactory.getLogger(IntlProjectRemarkProviderClient.class);

	@Autowired
	private IntlProjectRemarkService projectRemarkService;
	
	
	@ApiOperation(value="分页检索项目纪要",notes="检索项目纪要列表数据，返回数据列表。")
	@RequestMapping(value = "/stp-provider/project/remark-list", method = RequestMethod.POST)
	public Object selectProjectRemarkByPage(@RequestBody LayuiTableParam param) 
	{
		return projectRemarkService.selectProjectRemarkByPage(param);
	}
	
	@ApiOperation(value="添加项目纪要",notes="添加项目纪要相关信息。")
	@RequestMapping(value = "/stp-provider/project/add-remark", method = RequestMethod.POST)
	public Integer insertProjectRemark(@RequestBody IntlProjectRemark remark) 
	{
		
		return projectRemarkService.saveProjectRemark(remark);
	}
	@ApiOperation(value="更新项目纪要",notes="更新项目纪要相关信息。")
	@RequestMapping(value = "/stp-provider/project/upd-remark", method = RequestMethod.POST)
	public Integer updProjectRemark(@RequestBody IntlProjectRemark remark) 
	{
	
		return projectRemarkService.updProjectRemark(remark);
	}
	@ApiOperation(value="删除项目纪要",notes="删除项目纪要相关信息（逻辑删除）。")
	@RequestMapping(value = "/stp-provider/project/close-remark/{remarkId}", method = RequestMethod.POST)
	public Integer delProjectRemarkClose(@PathVariable("remarkId") String remarkId) 
	{
	
		return projectRemarkService.delProjectRemark(remarkId);
	}
	@ApiOperation(value="删除项目纪要",notes="删除项目纪要相关信息（物理删除）。")
	@RequestMapping(value = "/stp-provider/project/del-remark/{remarkId}", method = RequestMethod.POST)
	public Integer delProjectRemarkReal(@PathVariable("remarkId") String remarkId) 
	{
	
		return projectRemarkService.delProjectRemarkReal(remarkId);
	}
	@ApiOperation(value="检索项目纪要",notes="检索项目纪要相关信息（根据纪要ID）。")
	@RequestMapping(value = "/stp-provider/project/get-remark/{remarkId}", method = RequestMethod.POST)
	public IntlProjectRemark findProjectRemark(@PathVariable("remarkId") String remarkId) 
	{
	
		return projectRemarkService.findProjectRemark(remarkId);
	}
}
