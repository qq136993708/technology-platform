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
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.TokenInterUtils;

@Component
public class TokenInterceptor extends BaseController implements HandlerInterceptor {


	@Autowired
	private WebApplicationContext applicationContext;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			String path = request.getRequestURI();
			System.out.println(">>>>>>>path:"+path);
			// 手动设置几个常用页面不能直接访问，在InterceptorConfig文件中也可以批量设置
			if (path != null && (path.indexOf("index.html") > -1 || path.indexOf("login.html") > -1 || path.indexOf("error.html") > -1)) {
				// 统一身份认证时，重定向到/stpHome, 测试环境是/login
				return false;
			}
			response.setHeader("Content-Security-Policy", "frame-ancestors 'self'");
			// 只信任同源的
			response.setHeader("x-frame-options", "SAMEORIGIN");
			// 安全设置：归档文件下载
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			// 默认走这个格式，对于form等格式，自己在处理时特殊处理
			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			String token = null;
			Cookie[] cookies = request.getCookies();
			if(cookies!=null)
			{
				for (Cookie c : cookies) {
					if ("token".equalsIgnoreCase(c.getName()) && !StringUtils.isBlank(c.getValue())) {
						token = c.getValue();
						break;
					}
				}
			}
			
			//System.out.println(">>>>>>>token:"+token);
			if (token != null && !token.equals("null")) {
				httpHeaders.set("Authorization", "Bearer " + token);
				return true;
			} else {
				response.sendRedirect("/login");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


		TokenInterUtils.saveSysLog(restTemplate, httpHeaders, request, getUserProfile());

	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}


}
