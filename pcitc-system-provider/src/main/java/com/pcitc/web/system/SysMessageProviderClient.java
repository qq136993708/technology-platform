package com.pcitc.web.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.system.SysMessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Message-API",description = "消息相关的接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysMessageProviderClient {

	private final static Logger logger = LoggerFactory.getLogger(SysMessageProviderClient.class);
	
	@Autowired
	private SysMessageService sysMessageService;
	
	/**
	* @author Nishikino
	*  查询系统配置
	*/
	@ApiOperation(value = "获取消息分页列表", notes = "获取消息分页列表")
	@RequestMapping(value = "/sysmessage-provider/message/message-pagin-list", method = RequestMethod.POST)
	public Object selectSysMessageList(@RequestBody LayuiTableParam param) {
		logger.info("loading.....");
		LayuiTableData data = sysMessageService.getMessageListData(param);
		return data;
	}
	
	/**
	* @author Nishikino
	* 查询系统配置
	*/
	@ApiOperation(value = "查询消息详情", notes = "新增保存")
	@RequestMapping(value = "/sysmessage-provider/message/message-info", method = RequestMethod.POST)
	public Object selectSysMessageInfo(@RequestBody String messageId){
		logger.info("selectSysMessageInfo==================");
		return sysMessageService.selectSysMessage(messageId);
	}
	
	/**
	* @author Nishikino
	* 查询系统配置
	*/
	@ApiOperation(value = "查询消息详情", notes = "新增保存")
	@RequestMapping(value = "/sysmessage-provider/message/read-message-info", method = RequestMethod.POST)
	public Object updSysMessageInfo(@RequestBody String messageId){
		logger.info("updSysMessageInfo==================");
		return sysMessageService.readSysMessage(messageId);
	}
}
