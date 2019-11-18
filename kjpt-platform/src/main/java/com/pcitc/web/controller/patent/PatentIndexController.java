package com.pcitc.web.controller.patent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PatentIndexController {
	
	
	    // 专利列表
		@RequestMapping(value = "/kjpt/patent/patent_list")
		public String expert_list(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/patent/patent_list";
		}
		
		// 专利增加
		@RequestMapping(value = "/kjpt/patent/patent_add")
		public String expert_add(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/patent/patent_add";
		}
		
		// 专利修改
		@RequestMapping(value = "/kjpt/patent/patent_edit")
		public String expert_edit(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/patent/patent_edit";
		}
		
		// 专利详情
		@RequestMapping(value = "/kjpt/patent/patent_view")
		public String expert_view(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/patent/patent_view";
		}

}
