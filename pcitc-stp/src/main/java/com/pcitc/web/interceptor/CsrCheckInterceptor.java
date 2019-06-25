package com.pcitc.web.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CsrCheckInterceptor implements HandlerInterceptor 
{
	static String [] protocols = {"http","https"};
	static String [] hosts = {"stmp.sinopec.com","localhost","127.0.0.1","10.238","10.246.94"};
	static String [] exceptionsURI = {"/index","/login","/stpHome","/instituteIndex"};
	static Set<String> securityReferes = new HashSet<String>();
	static Set<String> exceptionsURL = new HashSet<String>();
	static 
	{
		for(String p:protocols) {
			for(String h:hosts) {
				String r = p+"://"+h;
				securityReferes.add(r);
				for(String uri:exceptionsURI) {
					exceptionsURL.add(r+uri);
					exceptionsURL.add(r+":8080"+uri);
				}
			}
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String referer = request.getHeader("Referer");
		if(referer != null) {
			boolean checkPass = false;
			for(String securityRefere:securityReferes) {
				if(referer.startsWith(securityRefere)) {
					checkPass = true;
					break;
				}
			}
			if(!checkPass) {
				System.out.println("跨站攻击被拦截,攻击来源:"+referer);
				return false;
			}
		}else{
			String url = request.getRequestURL().toString();
			if(!exceptionsURL.contains(url)) {
				System.out.println("跨站攻击被拦截，攻击路径:"+request.getRequestURL());
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
