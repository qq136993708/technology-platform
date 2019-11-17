package com.pcitc.web.expert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.service.expert.IExpertService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Expert-API",tags = {"专家库相关的接口"})
@RestController
public class ExpertProviderClient {
	
	
	private final static Logger logger = LoggerFactory.getLogger(ExpertProviderClient.class); 
	@Autowired
    private IExpertService expertService; 
	

	
	/**===============================================专家===================================================*/
	
	@ApiOperation(value = "获取专家（分页）", notes = "获取专家（分页）")
	@RequestMapping(value = "/expert/page", method = RequestMethod.POST)
	public LayuiTableData getZjkBaseList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== ZjkBase param============"+param);
		return expertService.getZjkBasePage(param) ;
	}
	
	@ApiOperation(value = "增加专家信息", notes = "增加专家信息")
	@RequestMapping(value = "/expert/add", method = RequestMethod.POST)
	public String insertZjkBase(@RequestBody ZjkBase zjkBase) throws Exception{
		logger.info("====================add ZjkBase....========================");
		Integer count= expertService.insertZjkBase(zjkBase);
		return zjkBase.getId();
	}
	
	
	@ApiOperation(value = "修改专家信息", notes = "修改专家信息")
	@RequestMapping(value = "/expert/update", method = RequestMethod.POST)
	public Integer updateZjkBase(@RequestBody ZjkBase zjkBase) throws Exception{
		logger.info("==================update ZjkBase===========================");
		return expertService.updateZjkBase(zjkBase);
	}
	
	@ApiOperation(value = "根据ID删除专家信息", notes = "根据ID删除专家信息")
	@RequestMapping(value = "/expert/delete/{id}", method = RequestMethod.POST)
	public int deleteZjkBase(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete zjkBase==="+id+"==============");
		return expertService.deleteZjkBase(id) ;
	}
	
	
	@ApiOperation(value = "根据ID获取专家信息详情", notes = "根据ID获取专家信息详情")
	@RequestMapping(value = "/expert/get/{id}", method = RequestMethod.GET)
	public ZjkBase selectMeetingById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get zjkBase id "+id+"===========");
		return expertService.selectZjkBase(id);
	}
	
	
	
	

}
