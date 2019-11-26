package com.pcitc.web.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.JwtTokenUtil;

public class TokenInterUtils {
	
	private static final String LOG_ADD_URL = "http://kjpt-zuul/system-proxy/log-provider/add";
	
	public static Map getUrlMap() 
	{
		  Map map  = new HashMap();
		  map.put("/index", "用户登陆");
		  map.put("/role/add-role", "角色增加");
		  map.put("/role/del-role/", "角色删除");
		  map.put("/function/saveFunction", "新增或者修改菜单");
		  map.put("/function/deleteFunction", "删除菜单");
		  map.put("/dictionary/saveDictionary", "增加字典");
		  return map;
	}
	
	
	
	//保存日志
	public static Integer saveSysLog(RestTemplate restTemplate,HttpHeaders httpHeaders,HttpServletRequest request,SysUser userInfo)
		{
			Integer resutl=0;
			String url=request.getRequestURI();
			System.out.println(">>>>>>>>>>>>>>>>>>当前请求"+url);
			Map map=TokenInterUtils.getUrlMap();
			Object urlName=map.get(url);
			if(urlName!=null)
			{
				String optDescribe="";
				//如果当前环境下为空,则从TOKEN中获取
				if(userInfo==null)
				{
					System.out.println("========================当前环境userInfo为空=============================");
					List<String> list = httpHeaders.get("Authorization");
					if (list != null && list.get(0) != null)
					{
						userInfo = JwtTokenUtil.getUserFromTokenByValue(list.get(0).split(" ")[1]);
					}
				}
				if(userInfo!=null)
				{
					
					JSONObject user = JSONObject.parseObject(JSONObject.toJSONString(userInfo));
					System.out.println(">>>>>>>>>>>>>>>>>>>>USER信息"+user.toString());
					String userName=userInfo.getUserDisp();
					String userId=userInfo.getUserName();
					SysLog sysLog = new SysLog();
					sysLog.setId(UUID.randomUUID().toString().replaceAll("-", ""));
					sysLog.setLogIp(EquipmentUtils.getRemoteHost(request));
					sysLog.setLogTime(new Date());
					sysLog.setLogUrl(url);
					if(url.equals("/index"))
					{
						sysLog.setLogType(Constant.LOG_TYPE_LOGIN);//日志类型：1登陆日志，2操作日志，3错误日志
					}else
					{
						sysLog.setLogType(Constant.LOG_TYPE_OPT);
					}
					
					//用户类型：1普通用户，2系统管理员，3安全员，4审计员
					if(userId.equals(Constant.LOG_SYSTEMADMIN))
					{
						sysLog.setUserType("2");
					}else if(userId.equals(Constant.LOG_SECURITYADMIN))
					{
						sysLog.setUserType("3");
					}else if(userId.equals(Constant.LOG_AUDITADMIN))
					{
						sysLog.setUserType("4");
					}else
					{
						sysLog.setUserType("1");
					}
					optDescribe=String.valueOf(urlName);
					sysLog.setUserName(userName); 
					sysLog.setUserId(userId);
					sysLog.setRequestType(request.getMethod());
					sysLog.setUnitId(userInfo.getUnitId());
					sysLog.setUnitName(userInfo.getUnitName());
					sysLog.setOptDescribe(optDescribe);
					JSONObject sysLogstr = JSONObject.parseObject(JSONObject.toJSONString(sysLog));
					System.out.println(">>>>>>>>>>>>>>>>>>>>sysLog信息"+sysLogstr.toString());
					httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
					ResponseEntity<String> responseEntity =restTemplate.exchange(LOG_ADD_URL, HttpMethod.POST, new HttpEntity<SysLog>(sysLog, httpHeaders), String.class);
					int statusCode = responseEntity.getStatusCodeValue();
					if (statusCode == 200) 
					{
						String dataId = responseEntity.getBody();
						resutl=1;
					}
				
				}
			}
			return resutl;
		}
		

}
