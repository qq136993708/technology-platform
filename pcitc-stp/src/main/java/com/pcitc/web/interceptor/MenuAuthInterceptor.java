package com.pcitc.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.Result;
import com.pcitc.base.util.HostUtil;

/**
 * 菜单的权限控制 拥有某个菜单后，可以拥有其controller下的所有操作。一般一个controller有一个菜单功能
 */
@Component
public class MenuAuthInterceptor implements HandlerInterceptor {
	
	private static Set<String> commonKey = new HashSet();
	
	static {
		commonKey.add("login");
		commonKey.add("stpHome");
		commonKey.add("index");
		commonKey.add("instituteIndex");
		commonKey.add("mainStp");
		
		commonKey.add("getOA");
		commonKey.add("mainLeader");
		commonKey.add("admin");
		
		commonKey.add("message");
		commonKey.add("direct");
		commonKey.add("project");
		
		commonKey.add("sysfile");
		commonKey.add("home_ld");
		
		commonKey.add("indexOutPatent");
		commonKey.add("indexOutProjectInfo");
		commonKey.add("indexOutAppraisal");
		
		commonKey.add("laboratoryBase");
		commonKey.add("expertController");
		
		commonKey.add("out");
		
		commonKey.add("logout");
		commonKey.add("common-login");
		commonKey.add("mobile");
		
		commonKey.add("unit_select_radio");
		commonKey.add("reportStore");
		commonKey.add("sysfileconfig");
		commonKey.add("small_leader");
		commonKey.add("sysNews");
		commonKey.add("dictionary");
		commonKey.add("pageCommon");
		commonKey.add("sysAddress");
		
		commonKey.add("zjkBaseInfo");
		commonKey.add("activiti");
		commonKey.add("emailTemplate");
		commonKey.add("one_level_main");
		commonKey.add("unit");
		commonKey.add("fullSearch");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String path = request.getRequestURI();
		String pathKey = path.split("/")[1];
		if (pathKey != null && !pathKey.equals("")) {
			// 获取session中菜单权限的set值，比较是否有权限
			HashSet authSet = (HashSet)request.getSession().getAttribute("authSet");
			if (authSet != null) {
				commonKey.addAll(authSet);
			}
			System.out.println("1MenuAuthInterceptor=====-"+pathKey);
			System.out.println("2MenuAuthInterceptor=====-"+authSet);
			
			if (path.contains("/mobile/investment_02") || path.contains("/mobile/get_Mobile_Month_Cash_Flow")) {
				// 移动的特殊处理
				String mobileLeader = (String)request.getSession().getAttribute("mobileLeader");
				if (mobileLeader != null && mobileLeader.equals("true")) {
					
				} else {
					System.out.println("3MenuAuthInterceptor=====-"+pathKey);
					resultData(request, response);
					return false;
				}
				
			}
			if (!commonKey.contains(pathKey)) {
				// 没有权限访问才功能
				System.out.println("3MenuAuthInterceptor=====-"+pathKey);
				resultData(request, response);
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
	
	/**
	 * procss not user result
	 * 
	 * @param request
	 * @param response
	 * @param httpHeaders
	 */
	private void resultData(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			//当前主机的网络地址
			Set<String> hostSet = HostUtil.getLocalHostAddressSet();
			// 遍历ip，如果有服务器ip的跳stpHome，否则跳/login
	    	boolean reqFlag = false;
	    	for (String str : hostSet) {  
	    	      if (str.equals("10.246.94.84") || str.equals("10.246.94.76") || str.equals("172.16.100.127") || str.equals("172.16.100.8")) {
	    	    	  reqFlag = true;
	    	      }
	    	}
	    	System.out.println("跳转路径--------------"+request.getRequestURI()+"======="+request.getRemoteAddr());
			response.setHeader("Content-Type", "text/html; charset=utf-8");
			//response.setHeader("X-Content-Type-Options", "nosniff");
			Result rs = new Result(false, reqFlag?"/stpHome":"/login", "权限不足，无法访问!", "404");
			PrintWriter out = response.getWriter();
			out.println(JSON.toJSON(rs));
			out.close();
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

}
