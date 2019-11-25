package com.pcitc.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.HostUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
public class TokenInterceptor extends BaseController implements HandlerInterceptor {

	
	private static final String LOG_ADD_URL = "http://kjpt-zuul/system-proxy/log-provider/add";
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private WebApplicationContext applicationContext;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			
			    System.out.println(">>>>>>>>用户请求的URL："+request.getRequestURI());
			    System.out.println(">>>>>>>>用户请求的IP："+request.getRemoteAddr());
			    
				
				
			    if(handler instanceof HandlerMethod)
			    {
			        HandlerMethod method = (HandlerMethod)handler;
			        ApiOperation  apiOperation =method.getMethodAnnotation(ApiOperation.class);
			        if(apiOperation!=null)
			        {
			        	  System.out.println("用户想执行的操作是--------------"+apiOperation.value());
			        }
			        System.out.println(">>>>>>>>用户请求的类："+method.getMethod().getDeclaringClass().getName());
			        System.out.println(">>>>>>>用户请求的方法："+method.getMethod().getName());
			    }
			   
			
			String path = request.getRequestURI();
			// 手动设置几个常用页面不能直接访问，在InterceptorConfig文件中也可以批量设置
			if (path != null && (path.indexOf("index.html") > -1 || path.indexOf("login.html") > -1 || path.indexOf("error.html") > -1)) {
				System.out.println("手动设置几个常用页面不能直接访问");
				// 统一身份认证时，重定向到/stpHome, 测试环境是/login
				return false;
			}

			// 缺少“Content-Security-Policy”头 , 此设置其资源只能自己访问
			response.setHeader("Content-Security-Policy", "frame-ancestors 'self'");
			// 只信任同源的
			response.setHeader("x-frame-options", "SAMEORIGIN");
			// 安全设置：归档文件下载
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			// 默认走这个格式，对于form等格式，自己在处理时特殊处理
			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			String token = null;
			SysUser sysUser = null;
			Cookie[] cookies = request.getCookies();
			if (cookies == null || cookies.length == 0) 
			{
				System.out.println("cookies is null ");
				// login和index为了开发需要，避开统一身份认证
				if (!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/kjptmobile/login") && !request.getRequestURI().contains("/kjptmobile/temIndex") && !request.getRequestURI().contains("/kjptmobile/index") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome") && !request.getRequestURI().equals("/")) {
					// 统一身份认证时，重定向到/stpHome, 测试环境是/login
					return false;
				}
				System.out.println("特殊路径--------------"+request.getRequestURI()+"======="+request.getRemoteAddr());
			} else {
				System.out.println("cookies is not null ");
				// 会话cookie中缺少HttpOnly属性
				for (Cookie c : cookies) {
					c.setHttpOnly(true);

					if ("token".equalsIgnoreCase(c.getName()) && !StringUtils.isBlank(c.getValue())) {
						token = c.getValue();
						// 此cookies重新计时
						c.setMaxAge(1 * 60 * 60); // 设置有效期为一小时
						c.setPath("/");
						response.addCookie(c);
						break;
					}
				}
			}
			if (token != null) {
				System.out.println("token is not null:");
				httpHeaders.set("Authorization", "Bearer " + token);
				sysUser = JwtTokenUtil.getUserFromTokenByValue(token);
				// 验证当前url登录人是否有权限查看（url中不会包含ajax请求的）
				HandlerMethod m = (HandlerMethod) handler;
				if (m.getBean() instanceof BaseController) {
					BaseController baerInfo = (BaseController) m.getBean();
					baerInfo.setUserProfile(sysUser);
				}
				
				// 一个用户只能一处登录
				/*if (!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/kjptmobile/login") && !request.getRequestURI().contains("/kjptmobile/temIndex") && !request.getRequestURI().contains("/kjptmobile/index") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome") && !request.getRequestURI().equals("/")) {
					//HttpSession session = request.getSession();
					//String sessionId = SessionShare.getSessionIdSave().get(sysUser.getUserName());//获取全局类SessionSave保存账户的静态sessionId
					//System.out.println("原有session--------------:"+sessionId);
					//String currentSessionId = session.getId();//获取当前的sessionId
					//System.out.println("当前session--------------:"+currentSessionId);
					
					//System.out.println("判断--------------:"+currentSessionId.equals(sessionId));
					//if (sessionId != null && !currentSessionId.equals(sessionId)) {//如果两个sessionId不等，则当前账户强制下线，需要重新登录
						//resultData(request, response);
						//return false;
					//} 
				}*/
				
			} else {
				System.out.println("token is null ------特殊路径--------------"+request.getRequestURI()+"======="+request.getRemoteAddr());
				// login和index为了开发需要，避开统一身份认证
				if (!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/kjptmobile/login") && !request.getRequestURI().contains("/kjptmobile/temIndex") && !request.getRequestURI().contains("/kjptmobile/index") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome") && !request.getRequestURI().equals("/")) {
					// 统一身份认证时，重定向到/stpHome, 测试环境是/login
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	
		System.out.println(">>>>>>dd>>用户请求的URL："+request.getRequestURI());
	    System.out.println(">>>>>>dd>>用户请求的IP："+request.getRemoteAddr());
	    
	    String url=request.getRequestURI();
		//Authorization头
		List<String> list = httpHeaders.get("Authorization");
		if(list!=null)
		{
			JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
			System.out.println(">>>>>>>>>>>Authorization:"+json.toString());
			
		    SysLog sysLog = new SysLog();
			sysLog.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			sysLog.setLogIp(getRemoteHost(request));
			sysLog.setLogTime(new Date());
			sysLog.setLogUrl(url);
			if(url.equals("/index"))
			{
				sysLog.setLogType(Constant.LOG_TYPE_LOGIN);//日志类型：1登陆日志，2操作日志，3错误日志
			}else
			{
				sysLog.setLogType(Constant.LOG_TYPE_OPT);
			}
			SysUser userInfo = JwtTokenUtil.getUserFromTokenByValue(list.get(0).split(" ")[1]);
			String userName=userInfo.getUserDisp();
			//用户类型：1普通用户，2系统管理员，3安全员，4审计员
			if(userName.equals(Constant.LOG_SYSTEMADMIN))
			{
				sysLog.setUserType("2");
			}else if(userName.equals(Constant.LOG_SECURITYADMIN))
			{
				sysLog.setUserType("3");
			}else if(userName.equals(Constant.LOG_AUDITADMIN))
			{
				sysLog.setUserType("4");
			}else
			{
				sysLog.setUserType("1");
			}
			sysLog.setUserName(userName); 
			sysLog.setUserId(userInfo.getUserId());
			sysLog.setRequestType(request.getMethod());
			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			//this.restTemplate.exchange(LOG_ADD_URL, HttpMethod.POST, new HttpEntity<SysLog>(sysLog, this.httpHeaders), Integer.class);
	
		}
		
	    if(handler instanceof HandlerMethod)
	    {
	        HandlerMethod method = (HandlerMethod)handler;
	        ApiOperation  apiOperation =method.getMethodAnnotation(ApiOperation.class);
	        if(apiOperation!=null)
	        {
	        	  System.out.println("用户想执行的操作是--------------"+apiOperation.value());
	        }
	        System.out.println(">>>>>>>>用户请求的类："+method.getMethod().getDeclaringClass().getName());
	        System.out.println(">>>>>>>用户请求的方法："+method.getMethod().getName());
	        //sysLog.setRemarks("用户请求的类："+method.getMethod().getDeclaringClass().getName()+"-用户请求的方法："+method.getMethod().getName());
	     }
	    
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
}
