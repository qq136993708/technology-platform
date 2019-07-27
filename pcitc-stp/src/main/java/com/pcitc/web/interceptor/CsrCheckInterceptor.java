package com.pcitc.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.web.utils.InputCheckUtil;

//@Component
public class CsrCheckInterceptor implements HandlerInterceptor 
{
	static String [] protocols = {"http","https"};
	static String [] hosts = {"stmp.sinopec.com","localhost","127.0.0.1","10.238.[\\d]{1,3}.[\\d]{1,3}","10.246.[\\d]{1,3}.[\\d]{1,3}"};
	static String [] exceptionsURI = {"/login"};
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
					exceptionsURL.add(r+":8443"+uri);
					exceptionsURL.add(r+":443"+uri);
				}
			}
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String referer = request.getHeader("Referer");
		String url = request.getRequestURL().toString();
		if(referer != null) {
			boolean checkPass = false;
			for(String securityRefere:securityReferes) {
				if(InputCheckUtil.check(securityRefere+".*?",referer)) {
					checkPass = true;
					break;
				}
			}
			if(!checkPass) {
				System.out.println("跨站攻击被拦截,攻击来源:referer:"+referer +" url:"+url);
				outErrorInfo(response);
				return false;
			}
		}else{
			for(String u:exceptionsURL) {
				if(InputCheckUtil.check(u, url)) {
					return true;
				}
			}
			System.out.println("跨站攻击被拦截，攻击路径:"+request.getRequestURL());
			outErrorInfo(response);
			return false;
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
	private void outErrorInfo(HttpServletResponse response) throws IOException 
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");      
	    out.println("<script>");      
	    out.println("window.open ('/error.html','_top')");      
	    out.println("</script>");      
	    out.println("</html>");   
		//out.print("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>非法访问</title></head><body><h1>您的访问涉嫌非法！<h1></body></html>");
		out.close();
	}
}
