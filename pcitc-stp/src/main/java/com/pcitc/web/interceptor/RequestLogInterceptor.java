package com.pcitc.web.interceptor;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pcitc.base.common.Result;
import com.pcitc.base.constant.SysConstant;
import com.pcitc.base.system.SysReqLogs;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.HostUtil;
import com.pcitc.web.common.BaseController;

@Component
public class RequestLogInterceptor implements HandlerInterceptor 
{
	private static final String LOG_CLIENT = "http://pcitc-zuul/system-proxy/sys-provider/processlogs/process-logs-save";
	
	private static Boolean runInServerHost = false;
	private static String serverHost = HostUtil.getLocalHostIpAddress();
	
	private static Set<String> runHost = HostUtil.getLocalHostAddressSet();
	private static Set<String> serverHostSet = new HashSet<String>(Arrays.asList(SysConstant.STP_SERVER_HOST.split(",")));
	
	static 
	{
		serverHostSet.retainAll(runHost);
    	if(serverHostSet.size() > 0) 
    	{
    		runInServerHost = true;
    	}
	}
	
	@Autowired
    public HttpHeaders httpHeaders;
	  
	@Autowired
	public RestTemplate restTemplate;
	
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
			if(!runInServerHost) 
			{
				return;
			}
			request.setAttribute("afterCompletionStartTime", System.currentTimeMillis());
			//此功能暂时禁用，待未来有需求时放开
			Long preHandleStartTime = (Long)request.getAttribute("preHandleStartTime");
			//Long postHandleStartTime = (Long)request.getAttribute("postHandleStartTime");
			Long afterCompletionStartTime = (Long)request.getAttribute("afterCompletionStartTime");
			HandlerMethod m = (HandlerMethod) handler;
			//m.getMethod().getAnnotations();
			//m.getBean().getClass().getAnnotations();
			SysUser sysUser = null;
			if (m.getBean() instanceof BaseController) {
				BaseController baerInfo = (BaseController) m.getBean();
				sysUser = baerInfo.getUserProfile();
			}
			String uri = request.getRequestURI();
			String reqType = request.getMethod();
			String host = request.getRemoteHost();
			String methodName = m.getMethod().getName();
			String className = m.getBean().getClass().getName();
			String userId = sysUser == null?null:sysUser.getUserId();
			String ctime = DateUtil.format(new Date(), DateUtil.FMT_SSS);
			Long processTime = afterCompletionStartTime-preHandleStartTime;
			
			SysReqLogs bean = new SysReqLogs();
			bean.setClassName(className);
			bean.setHost(host);
			bean.setMethodName(methodName);
			bean.setUri(uri);
			bean.setUserId(userId);
			bean.setLogTime(ctime);
			bean.setProcessTime(processTime.intValue());
			bean.setStartTime(preHandleStartTime.toString());
			bean.setEndTime(afterCompletionStartTime.toString());
			bean.setReqType(reqType);
			bean.setServerHost(serverHost);
			
			HttpEntity<SysReqLogs> entity = new HttpEntity<SysReqLogs>(bean, httpHeaders);
			restTemplate.exchange(LOG_CLIENT, HttpMethod.POST, entity, Result.class).getBody();
			//System.out.println("[http-log-time]:"+ctime+" uri:"+uri+" host:"+host+" methodName:"+methodName+" className:"+className+" userId:"+userId+" processTime:"+(processTime)+JSON.toJSONString(rs));
		}
		catch(Exception e) 
		{
			System.out.println("log error...");
		}
	}
}
