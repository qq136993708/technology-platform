package com.pcitc.web.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysConfig;
import com.pcitc.base.system.SysModule;
import com.pcitc.base.system.SysRestfulapi;
import com.pcitc.service.system.SysConfigService;

import io.swagger.annotations.ApiOperation;

//@Api(value = "Task-API",description = "任务相关的接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysConfigClient {

	private final static Logger logger = LoggerFactory.getLogger(SysConfigClient.class);
	
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	* @author Nishikino
	* 查询系统配置
	*/
	@ApiOperation(value = "系统配置表查询", notes = "查询的是系统配置表")
	@RequestMapping(value = "/sysconfig-provider/sys_config/list", method = RequestMethod.POST)
	public Object selectConfigByPage(@RequestBody LayuiTableParam param) {
		System.out.println("selectConfigByPage==============查询的是系统配置表");
		Object tem = sysConfigService.selectConfigByPage(param);
		return tem;
	}
	
	/**
	* @author Nishikino
	* 查询系统配置
	*/
	@ApiOperation(value = "初始化模块详情", notes = "新增保存")
	@RequestMapping(value = "/sysconfig-provider/sys_config/add", method = RequestMethod.POST)
	public Object insertSysConfig(@RequestBody SysConfig sysconfig){
		System.out.println("insertSysConfig=================="+sysconfig);
		return sysConfigService.insertSysConfig(sysconfig);
	}
	
	/**
	 * @author Nishikino
	 * 查询id
	 */
	@ApiOperation(value = "初始化模块详情", notes = "根据id查询")
	@RequestMapping(value = "/sysconfig-provider/sys_config/getsysconfig/{configId}", method = RequestMethod.POST)
	public SysConfig getSysConfig(@PathVariable(value = "configId", required = true) String configId) throws Exception{
		return sysConfigService.getSysConfigById(configId);
	}
	
	/**
	 * @author Nishikino
	 * 保存修改
	 */
	@ApiOperation(value = "修改系统配置", notes = "修改保存")
	@RequestMapping(value = "/sysconfig-provider/sys_config/saveSysConfig", method = RequestMethod.POST)
	public Integer updateSysRestfulapi(@RequestBody SysConfig sysconfig){
		System.out.println("updateSysConfig=================="+sysconfig);
		return sysConfigService.updateSysConfig(sysconfig);
	}//
	
	/**
	 * @author Nishikino
	 * 删除配置
	 */
	@ApiOperation(value = "删除配置", notes = "删除配置")
	@RequestMapping(value = "/sysconfig-provider/sys_config/deleteSysConfig", method = RequestMethod.DELETE)
	public Integer deleteSysConfigById(@RequestBody SysConfig sysconfig){
		int rInt = 0;
		sysconfig.setConfigId(sysconfig.getConfigId());
		rInt = rInt + sysConfigService.deleteSysConfig(sysconfig);
		return rInt;
	}
}
