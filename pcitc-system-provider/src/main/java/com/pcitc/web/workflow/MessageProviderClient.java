package com.pcitc.web.workflow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.system.SysMessageService;

@Api(value = "MESSAGE-API", description = "消息相关的接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class MessageProviderClient {

	@Autowired
	private SysMessageService sysMessageService;

	/**
	 * 查询消息数据
	 * @date 2019年4月16日 下午2:09:43
	 */
	@ApiOperation(value = "获取消息数据", notes = "本人的，以后也可以匹配岗位、角色")
	@RequestMapping(value = "/message-provider/message/list", method = RequestMethod.POST)
	public Object getMessageListData(@RequestBody LayuiTableParam param) {
		Object tem = sysMessageService.getMessageListData(param);
		return tem;
	}
	
	
}
