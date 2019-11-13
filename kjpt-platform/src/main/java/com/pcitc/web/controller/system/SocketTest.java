package com.pcitc.web.controller.system;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysMessage;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.socket.notice.MessageIndexSocket;

/**
 * socket 连接测试
 * 
 * @author uuy
 *
 */
@Controller
public class SocketTest extends BaseController
{
	
	@Autowired
	private MessageIndexSocket msgSocket;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/test/msg-sent")
	@ResponseBody
	public Object toBudgetGroupAddPage(@RequestBody SysMessage msg,HttpServletRequest request) throws IOException 
	{
		System.out.println("start..................................");
		msgSocket.sendToWeb(msg);
		
		return new Result(true);
	}
	
	

}
