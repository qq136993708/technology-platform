package com.pcitc.web.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个用户只能一处登录
 * 存储全局的SessionId静态变量
 */
public class SessionShare extends BaseController {

	private static Map<String, String> SessionIdSave = new HashMap<String,String>();
	 
	public static Map<String, String> getSessionIdSave() {
		return SessionIdSave;
	}
 
	public static void setSessionIdSave(Map<String, String> sessionIdSave) {
		SessionIdSave = sessionIdSave;
	}

}
