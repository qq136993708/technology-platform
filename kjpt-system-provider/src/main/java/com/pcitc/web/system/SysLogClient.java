package com.pcitc.web.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysLog;
import com.pcitc.service.system.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 * <p>
 * 日志接口，插入日志、查询日志、导出日志
 */
@Api(value = "SysLog-API",description = "日志管理相关的接口")
@RestController
public class SysLogClient {

    private final static Logger logger = LoggerFactory.getLogger(SysLogClient.class);

    @Autowired
    SysLogService sysLogService;
    

	



	@ApiOperation(value = "获取系统日志（分页）", notes = "获取系统日志（分页）")
	@RequestMapping(value = "/log-provider/page", method = RequestMethod.POST)
	public LayuiTableData getSysLogList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("=== SysLog param============"+param);
		return sysLogService.getSysLogPage(param) ;
	}
	
	@ApiOperation(value = "增加系统日志信息", notes = "增加系统日志信息")
	@RequestMapping(value = "/log-provider/add", method = RequestMethod.POST)
	public String insertSysLog(@RequestBody SysLog SysLog) throws Exception{
		logger.info("====================add SysLog....========================");
		Integer count= sysLogService.insertSysLog(SysLog);
		return SysLog.getId();
	}
	
	
	@ApiOperation(value = "修改系统日志信息", notes = "修改系统日志信息")
	@RequestMapping(value = "/log-provider/update", method = RequestMethod.POST)
	public Integer updateSysLog(@RequestBody SysLog SysLog) throws Exception{
		logger.info("==================update SysLog===========================");
		return sysLogService.updateSysLog(SysLog);
	}
	
	@ApiOperation(value = "根据ID物理删除系统日志信息", notes = "根据ID删除系统日志信息")
	@RequestMapping(value = "/log-provider/delete/{id}", method = RequestMethod.POST)
	public int deleteSysLog(@PathVariable("id") String id)throws Exception{
		logger.info("=============================根据ID物理删除系统日志信息 SysLog==="+id+"==============");
		return sysLogService.deleteSysLog(id) ;
	}
	
	
	
	@ApiOperation(value = "根据ID获取系统日志信息详情", notes = "根据ID获取系统日志信息详情")
	@RequestMapping(value = "/log-provider/get/{id}", method = RequestMethod.GET)
	public SysLog selectSysLogId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SysLog id "+id+"===========");
		return sysLogService.selectSysLog(id);
	}
	
	
	
    
    
	@ApiOperation(value = "获取系统日志", notes = "获取系统日志")
	@RequestMapping(value = "/log-provider/list", method = RequestMethod.POST)
	public JSONArray getZjkBase_List(@RequestBody Map param)throws Exception
	{
		logger.info("=== SysLog param============"+param);
		List list=sysLogService.getSysLogList(param);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
    
    
    
    
    
    
    
    
    
}
