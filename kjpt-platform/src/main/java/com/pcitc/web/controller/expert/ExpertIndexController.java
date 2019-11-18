package com.pcitc.web.controller.expert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
public class ExpertIndexController {
	
	
	    // 专家列表
		@RequestMapping(value = "/kjpt/expert/expert_list")
		public String expert_list(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/expert/expert_list";
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
				

}
