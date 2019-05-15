package com.pcitc.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;

@Component
public class TokenInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpHeaders httpHeaders;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			System.out.println("TokenInterceptor--------------"+request.getRequestURI());
			String path = request.getRequestURI();
			/*if(!doLoginInterceptor(path, basePath) ){//是否进行登陆拦截
				return true;
			}*/
			// 手动设置几个常用页面不能直接访问，在InterceptorConfig文件中也可以批量设置
			if (path != null && (path.indexOf("index.html") > -1 || path.indexOf("login.html") > -1 || path.indexOf("error.html") > -1)) {
				return false;
			}
			
			// 只信任同源的
			response.setHeader("x-frame-options", "SAMEORIGIN");
			
			// 默认走这个格式，对于form等格式，自己在处理时特殊处理
			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			String token = null;
			SysUser sysUser = null;
			Cookie[] cookies = request.getCookies();
			if (cookies == null || cookies.length == 0) {
				// System.out.println("cookies is null ");
				// login和index为了开发需要，避开统一身份认证
				if (!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/mobile/") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome")) {
					return false;
				}    
				
			} else {
				//System.out.println("cookies is not null ");
				for (Cookie c : cookies) {
					if ("token".equalsIgnoreCase(c.getName()) && !StringUtils.isBlank(c.getValue())) {
						token = c.getValue();
						break;
					}
				}
			}
			if (token != null) {
				//System.out.println("token is not null ");
				httpHeaders.set("Authorization", "Bearer " + token);
				sysUser = JwtTokenUtil.getUserFromTokenByValue(token);
				
				// 验证当前url登录人是否有权限查看（url中不会包含ajax请求的）
				
				HandlerMethod m = (HandlerMethod) handler;
				
				if (m.getBean() instanceof BaseController) {
					BaseController baerInfo = (BaseController) m.getBean();
					baerInfo.setUserProfile(sysUser);
				}
			} else {
				// System.out.println("token is null ");
				// login和index为了开发需要，避开统一身份认证
				if (!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/mobile/") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome")) {
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
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

}
