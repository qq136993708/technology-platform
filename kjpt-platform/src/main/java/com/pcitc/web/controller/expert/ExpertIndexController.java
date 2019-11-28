package com.pcitc.web.controller.expert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcitc.base.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
public class ExpertIndexController {
	
	
	
		@RequestMapping(value = "/syslog/to_list")
		public String syslog_list(HttpServletRequest request, HttpServletResponse response) 
		{
			
			String logType=CommonUtil.getParameter(request, "logType", "1");//日志类型：1登陆日志，2操作日志，3错误日志
			String userType=CommonUtil.getParameter(request, "userType", "");//用户类型：1普通用户，2系统管理员，3安全员，4审计员
			request.setAttribute("logType", logType);
			request.setAttribute("userType", userType);
			String resault="/base/sysLog/log_list";
			if(logType.equals("2"))
			{
				resault="/base/sysLog/opt_list";
			}
			if(logType.equals("3"))
			{
				resault="/base/sysLog/error_list";
			}
			return resault;
		}
		
	
	    // 专家管理
		@RequestMapping(value = "/kjpt/expert/expert_list")
		public String expert_list(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/expert/expert_list";
		}
		
		
		// 专家查询
		@RequestMapping(value = "/kjpt/expert/expert_query")
		public String expert_query(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/expert/expert_query";
		}
		
		// 专家增加
		@RequestMapping(value = "/kjpt/expert/expert_add")
		public String expert_add(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/expert/expert_add";
		}
		
		// 专家修改
		@RequestMapping(value = "/kjpt/expert/expert_edit")
		public String expert_edit(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/expert/expert_edit";
		}
		
		// 专家详情
		@RequestMapping(value = "/kjpt/expert/expert_view")
		public String expert_view(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/expert/expert_view";
		}
		
		// 专家风采
		@RequestMapping(value = "/kjpt/expert/expert_graceful")
		public String expert_graceful(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/expert/expert_graceful";
		}
		
		
		
		
		
		
		@RequestMapping(value = "/tech-family/tree_index")
		public String tree_index(HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/kjpt/techFamily/tree_index";
		}
		
		@RequestMapping(value = "/tech-family/add")
		public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/kjpt/techFamily/add";
		}
		
		
		@RequestMapping(value = "/tech-family/update")
		public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/kjpt/techFamily/update";
		}
		
		
				

}
