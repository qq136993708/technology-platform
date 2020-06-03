package com.pcitc.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.TokenInterUtils;

@Component
public class TokenInterceptor extends BaseController implements HandlerInterceptor {


	@Value("${proxy.url}")
	String proxyUrl;
	
	@Value("${server.ip}")
	String serverIp;
	

	@Autowired
	private WebApplicationContext applicationContext;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try
		{
			String path = request.getRequestURI();
			String serverName = request.getServerName();

			//System.out.println("====================protocol=" + request.getProtocol());
			//System.out.println("====================server name=" + request.getServerName());
			//System.out.println("====================port=" + request.getServerPort());
		   // System.out.println("====================url=" + request.getRequestURI());
			//System.out.println("====================getIpAddress=" + getIpAddress(request));
			System.out.println(">>>>>>>path:"+path+" serverName:"+serverName);

			
			response.setHeader("Content-Security-Policy", "frame-ancestors 'self'");
			// 只信任同源的
			response.setHeader("x-frame-options", "SAMEORIGIN");
			// 安全设置：归档文件下载
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			// 默认走这个格式，对于form等格式，自己在处理时特殊处理
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			
			SysUser u=(SysUser)request.getSession().getAttribute("sysUser");
			if(u==null)
			{
				System.out.println(">>>>>>>session  is  null  空   =============");
				String unifyIdentityId=EquipmentUtils.getSwSSOToken(request, response);
				System.out.println(">>>>>>>TokenInterceptor  KOAL_CERT_CN:"+unifyIdentityId);
				if(unifyIdentityId==null || unifyIdentityId.equals(""))
				{
					//response.sendRedirect(proxyUrl + "sso_error_sw");
					
					if(serverName.equals(serverIp))
					{
						System.out.println(">>>>a>>>serverName ============="+serverName);
						//response.sendRedirect("/login");
						response.getWriter().write("<script> parent.document.location= '/login"+"' </script>");
						
					}else
					{
						System.out.println(">>>>>>b>serverName ============="+serverName);
						//response.sendRedirect(proxyUrl + "sso_error_sw");
						//response.sendRedirect("/login");
						response.getWriter().write("<script> parent.document.location= '/login"+"' </script>");
						
					}
					return false;
				}
				
				//JWT
				//String token=EquipmentUtils.buildToken_ByIdentityId(unifyIdentityId, restTemplate, httpHeaders, response);
				SysUser sysUser=   EquipmentUtils.getUserByUnifyIdentityId(unifyIdentityId, restTemplate, httpHeaders);
				if(sysUser!=null)
				{
					System.out.println(">>>>>>>sysUser  is  exist =============");
					request.getSession().setAttribute("sysUser", sysUser);
					return true;
				}else
				{
					
					if(serverName.equals(serverIp))
					{
						System.out.println(">>>>c>>>serverName ============="+serverName);
						//response.sendRedirect("/login");
						response.getWriter().write("<script> parent.document.location= '/login"+"' </script>");
						
					}else
					{
						System.out.println(">>>>>>d>serverName ============="+serverName);
						//response.sendRedirect("/login");
						response.getWriter().write("<script> parent.document.location= '/login"+"' </script>");
						//response.sendRedirect(proxyUrl + "sso_error_sw");
						
					}
					
					return false;
				}
				
			}else
			{
				//System.out.println(">>>b>>>>session is  "+request.getSession().getId());
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			//response.sendRedirect(proxyUrl + "sso_error_sw");
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



	public  String getIpAddress(HttpServletRequest request) {
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
		return ip;
	}


}
