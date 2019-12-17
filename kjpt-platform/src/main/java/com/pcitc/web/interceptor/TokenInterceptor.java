package com.pcitc.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.TokenInterUtils;

@Component
public class TokenInterceptor extends BaseController implements HandlerInterceptor {

	
	
	
	
	@Autowired
	private WebApplicationContext applicationContext;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			String path = request.getRequestURI();
			System.out.println(">>>>>>>>>>>>>>>>>>当前请求"+path);
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
				if (
						!request.getRequestURI().contains("/sso") 
						&&!request.getRequestURI().contains("/error") 
						&& !request.getRequestURI().contains("/get_image") 
						&& !request.getRequestURI().contains("/login") 
						&& !request.getRequestURI().contains("/index")  
						&& !request.getRequestURI().equals("/")) 
				{
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
				if (!request.getRequestURI().contains("/sso")&&!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/kjptmobile/login") && !request.getRequestURI().contains("/kjptmobile/temIndex") && !request.getRequestURI().contains("/kjptmobile/index") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome") && !request.getRequestURI().equals("/")) {
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
	
		
		   TokenInterUtils.saveSysLog(restTemplate, httpHeaders, request, sysUserInfo);
	    
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
