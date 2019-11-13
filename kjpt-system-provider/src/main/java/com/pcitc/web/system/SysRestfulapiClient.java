package com.pcitc.web.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysRestfulapi;
import com.pcitc.service.system.SysRestfulapiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "SysRestfulapiClient-API",description = "接口可视化接口")
@RestController
public class SysRestfulapiClient {
	private final static Logger logger = LoggerFactory.getLogger(SysRestfulapiClient.class);

	@Autowired
	SysRestfulapiService sysRestfulapiService;

	@ApiOperation(value = "查看列表分页-key", notes = "分页信息")
	@RequestMapping(value = "/sys_restfulapi/show-list")
	public JSONObject selectSysRestfulapiPage(@RequestParam(value="jsonStr", required=false) String jsonStr) 
	{
		JSONObject retJson = sysRestfulapiService.findWarehousing(jsonStr);
		return retJson;
	}
	
	@ApiOperation(value = "新增保存", notes = "新增保存")
	@RequestMapping(value = "/sys_restfulapi/insert-data", method = RequestMethod.POST)
	public Integer insertSysRestfulapi(@RequestBody SysRestfulapi srf){
		System.out.println("insertFunctionProcessDefine=================="+srf);
		return sysRestfulapiService.insertSysRestfulapi(srf);
	}
	
	@ApiOperation(value = "修改保存", notes = "修改保存")
	@RequestMapping(value = "/sys_restfulapi/update-data", method = RequestMethod.POST)
	public Integer updateSysRestfulapi(@RequestBody SysRestfulapi srf){
		System.out.println("insertFunctionProcessDefine=================="+srf);
		return sysRestfulapiService.updateSysRestfulapi(srf);
	}
	
	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据ID查询", notes = "根据ID查询")
	@RequestMapping(value = "/sys_restfulapi/showById-data/{restfulapiId}", method = RequestMethod.GET)
	public SysRestfulapi getSysRestfulapiById(@PathVariable(value = "restfulapiId", required = true) String restfulapiId) throws Exception{
		return sysRestfulapiService.getSysRestfulapiById(restfulapiId);
	}
	
	/**
	 *删除
	 */
	@ApiOperation(value = "删除", notes = "删除")
	@RequestMapping(value = "/sys_restfulapi/delete-data", method = RequestMethod.DELETE)
	public Integer deleteRestfulapiById(@RequestBody SysRestfulapi srf){
		return sysRestfulapiService.deleteRestfulapiById(srf.getRestfulapiId());
	}
}
