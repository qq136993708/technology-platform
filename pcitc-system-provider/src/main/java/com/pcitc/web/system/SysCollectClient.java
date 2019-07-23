package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;

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

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysFunction;
import com.pcitc.service.system.SysCollectService;
import com.pcitc.service.system.SysFunctionService;

@Api(value = "SYSCOLLECT-API",description = "菜单收藏相关的接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysCollectClient {

	private final static Logger logger = LoggerFactory.getLogger(SysCollectClient.class);
	
	@Autowired
	private SysCollectService sysCollectService;
	
	@Autowired
	private SysFunctionService sysFunctionService;
	
	
	/**
	* @author zhf
	* 收藏菜单保存
	*/
	@ApiOperation(value = "保存菜单收藏", notes = "已经保存的更新最新时间")
	@RequestMapping(value = "/syscollect-provider/sys_collect/add", method = RequestMethod.POST)
	public Object insertSysCollect(@RequestBody SysCollect sysCollect){
		System.out.println("insertSysCollect=================="+sysCollect.getFunctionId());
		System.out.println("insertSysCollect=================="+sysCollect.getUserId());
		
		SysFunction function = sysFunctionService.getFunctionById(sysCollect.getFunctionId());
		if (function == null) {
			return null;
		}
		sysCollect.setCollectUrl(function.getUrl());
		
		List<SysCollect> scList = sysCollectService.getSysCollectByCond(sysCollect.getFunctionId(), sysCollect.getUserId());
		System.out.println("sysCollectService=================="+scList);
		
		if (scList != null && scList.size() > 0) {
			SysCollect temSC = scList.get(0);
			temSC.setUpdateDate(new Date());
			temSC.setStatus("0");
			sysCollectService.updateSysCollect(temSC);
			return temSC;
		} else {
			sysCollect.setStatus("1");
			sysCollectService.insertSysCollect(sysCollect);
			return sysCollect;
		}
	}
	
	@ApiOperation(value="获取用户的收藏菜单",notes="只能查询一个人userId")
	@RequestMapping(value = "/syscollect-provider/list/{userId}", method = RequestMethod.GET)
	public JSONObject selectUserByUserName(@PathVariable(value = "userId", required = true) String userId) {
		
		List<SysCollect> scList = sysCollectService.getSysCollectByUser(userId);
		
		JSONObject tem = new JSONObject();
		tem.put("list", scList);
		return tem;
	}
	
}
