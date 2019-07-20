package com.pcitc.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

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

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.Result;
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
			//System.out.println("TokenInterceptor--------------"+request.getRequestURI()+"======="+request.getRemoteAddr());
			String path = request.getRequestURI();
			/*if(!doLoginInterceptor(path, basePath) ){//是否进行登陆拦截
				return true;
			}*/
			// 手动设置几个常用页面不能直接访问，在InterceptorConfig文件中也可以批量设置
			if (path != null && (path.indexOf("index.html") > -1 || path.indexOf("login.html") > -1 || path.indexOf("error.html") > -1)) {
				// 统一身份认证时，重定向到/stpHome, 测试环境是/login
				resultData(request,response);   
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
			if (cookies == null || cookies.length == 0) {
				// System.out.println("cookies is null ");
				// login和index为了开发需要，避开统一身份认证
				if (!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/mobile/") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome")) {
					// 统一身份认证时，重定向到/stpHome, 测试环境是/login
					resultData(request,response);  
					return false;
				}
				//System.out.println("特殊路径--------------"+request.getRequestURI()+"======="+request.getRemoteAddr());
			} else {
				for (Cookie c : cookies) {
					if ("token".equalsIgnoreCase(c.getName()) && !StringUtils.isBlank(c.getValue())) {
						token = c.getValue();
						// 此cookies重新计时
						c.setMaxAge(1 * 60 * 60);  // 设置有效期为一小时
						c.setPath("/");
						response.addCookie(c);
						break;
					}
				}
			}
			if (token != null) {
				//System.out.println("token is not null:"+token);
				httpHeaders.set("Authorization", "Bearer " + token);
				sysUser = JwtTokenUtil.getUserFromTokenByValue(token);
				// 验证当前url登录人是否有权限查看（url中不会包含ajax请求的）
				HandlerMethod m = (HandlerMethod) handler;
				if (m.getBean() instanceof BaseController) {
					BaseController baerInfo = (BaseController) m.getBean();
					baerInfo.setUserProfile(sysUser);
				}
			} else {
				//System.out.println("token is null ------特殊路径--------------"+request.getRequestURI()+"======="+request.getRemoteAddr());
				// login和index为了开发需要，避开统一身份认证
				if (!request.getRequestURI().contains("/error") && !request.getRequestURI().contains("/mobile/") && !request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/index") && !request.getRequestURI().contains("/stpHome")) {
					// 统一身份认证时，重定向到/stpHome, 测试环境是/login
					resultData(request,response);  
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
	/**
	 *  procss not user result
	 * @param request
	 * @param response
	 * @param httpHeaders
	 */
	private void resultData(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			String accept = request.getHeader("accept");//ajax请求头定义返回类型
			String clientReqType = request.getHeader("client_req_type");//自定义
			if(!StringUtils.isBlank(clientReqType)) 
			{
				Result rs = new Result(false,null,"登录超时!","401");
				PrintWriter out = response.getWriter();
		        out.println(JSON.toJSON(rs));      
				out.close();
			}
			else if(!StringUtils.isBlank(accept) && accept.contains("application/json")) 
			{
				Result rs = new Result(false,null,"登录超时!","401");
				PrintWriter out = response.getWriter();
		        out.println(JSON.toJSON(rs));      
				out.close();
			}
			else 
			{
				PrintWriter out = response.getWriter();
		        out.println("<html>");      
		        out.println("<script>");      
		        out.println("window.open ('"+request.getContextPath()+"/login','_top')");      
		        out.println("</script>");      
		        out.println("</html>");    
				out.close();
			}
		} 
		catch (IOException e) 
		{
			//e.printStackTrace();
		}  
	}
}
