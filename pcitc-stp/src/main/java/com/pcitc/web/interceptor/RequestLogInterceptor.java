package com.pcitc.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

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
		try 
		{
			request.setAttribute("afterCompletionStartTime", System.currentTimeMillis());
			//此功能暂时禁用，待未来有需求时放开
			Long preHandleStartTime = (Long)request.getAttribute("preHandleStartTime");
			//Long postHandleStartTime = (Long)request.getAttribute("postHandleStartTime");
			Long afterCompletionStartTime = (Long)request.getAttribute("afterCompletionStartTime");
			HandlerMethod m = (HandlerMethod) handler;
			SysUser sysUser = null;
			if (m.getBean() instanceof BaseController) {
				BaseController baerInfo = (BaseController) m.getBean();
				sysUser = baerInfo.getUserProfile();
			}
			String uri = request.getRequestURI();
			String host = request.getRemoteHost();
			String mname = m.getMethod().getName();
			String classname = m.getBean().getClass().getName();
			String userId = sysUser == null?null:sysUser.getUserId();
			String ctime = DateUtil.format(new Date(), DateUtil.FMT_SS);
			System.out.println("[http-log-time]:"+ctime+" uri:"+uri+" host:"+host+" mname:"+mname+" classname:"+classname+" userId:"+userId+" process_time:"+(afterCompletionStartTime-preHandleStartTime));
		}
		catch(Exception e) 
		{
			System.out.println("log error...");
		}
	}
}
