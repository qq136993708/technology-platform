package com.pcitc.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestLogInterceptor implements HandlerInterceptor 
{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("preHandleStartTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("postHandleStartTime", System.currentTimeMillis());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		request.setAttribute("afterCompletionStartTime", System.currentTimeMillis());
		//此功能暂时禁用，待未来有需求时放开
		/*Long preHandleStartTime = (Long)request.getAttribute("preHandleStartTime");
		Long postHandleStartTime = (Long)request.getAttribute("postHandleStartTime");
		Long afterCompletionStartTime = (Long)request.getAttribute("afterCompletionStartTime");
		SysUser sysUser = null;
		if(request.getAttribute("sysUser") != null) {
			sysUser = (SysUser)request.getAttribute("sysUser");
		}
		HandlerMethod m = (HandlerMethod) handler;
		String uri = request.getRequestURI();
		String host = request.getRemoteHost();
		String cname = m.getClass().getName();
		String userId = sysUser == null?null:sysUser.getUserId();
		System.out.println("process_time:"+(postHandleStartTime-preHandleStartTime));
		System.out.println("process_time:"+(afterCompletionStartTime-preHandleStartTime));*/
	}
}
