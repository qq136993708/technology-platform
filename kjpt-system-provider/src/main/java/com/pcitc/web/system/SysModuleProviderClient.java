package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysModule;
import com.pcitc.service.system.SysModuleService;

@Api(value = "SysModule-API",description = "模块管理相关的接口")
@RestController
public class SysModuleProviderClient {

	private final static Logger logger = LoggerFactory.getLogger(SysModuleProviderClient.class);

	@Autowired
	private SysModuleService sysModuleService;

	@ApiOperation(value = "查询模块列表", notes = "传入json格式的模块实体属性")
	@RequestMapping(value = "/sysModule-provider/sysModule_list",method = RequestMethod.POST)
	public String selectSysModuleByPage(@RequestBody SysModule vo) {
		JSONObject tem = null;
		try {
			tem = sysModuleService.selectSysModuleList(vo);
		} catch (Exception e) {
			logger.error("[系统管理-查询模块列表失败：]", e);
			e.printStackTrace();
		}
		return tem.toString();
	}
	
	/**
	 * 新增或修改模块
	 * @param sysModule
	 * @return
	 */
	@ApiOperation(value = "新增或修改模块", notes = "传入json格式的模块实体属性")
	@RequestMapping(value = "/sysModule-provider/saveSysModule", method = RequestMethod.POST)
	public int saveSysModule(@RequestBody SysModule sysModule){
		int result = 500;
		try {
			result = sysModuleService.updateOrInsertSysModule(sysModule);
		} catch (Exception e) {
			logger.error("[模块管理-保存模块失败：]", e);
		}
		return result;
	}
	
	/**
	 * 删除模块
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除模块", notes = "传入模块实体id属性")
	@RequestMapping(value = "/sysModule-provider/deleteSysModule/{id}", method = RequestMethod.POST)
	public int deleteDictionary(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = sysModuleService.deleteSysModule(id);
		} catch (Exception e) {
			logger.error("[模块管理-删除模块失败：]", e);
		}
		return result;
	}
	
	
	/**
	 * 初始化模块详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "初始化模块详情", notes = "传入模块实体id属性")
	@RequestMapping(value = "/sysModule-provider/getSysModule/{id}", method = RequestMethod.POST)
	public SysModule getSysModule(@PathVariable(value = "id", required = true) String id){
		SysModule sysModule = null;
		try {
			sysModule = sysModuleService.getSysModuleById(id);
		} catch (Exception e) {
			logger.error("[模块管理-初始化模块失败：]", e);
		}
		return sysModule;
	}

}
