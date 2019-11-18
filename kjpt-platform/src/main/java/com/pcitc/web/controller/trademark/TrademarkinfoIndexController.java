package com.pcitc.web.controller.trademark;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TrademarkinfoIndexController {
	
	
	    // 商标列表
		@RequestMapping(value = "/kjpt/trademarkinfo/trademarkinfo_list")
		public String expert_list(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/trademarkinfo/trademarkinfo_list";
		}
		
		// 商标增加
		@RequestMapping(value = "/kjpt/trademarkinfo/trademarkinfo_add")
		public String expert_add(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/trademarkinfo/trademarkinfo_add";
		}
		
		// 商标修改
		@RequestMapping(value = "/kjpt/trademarkinfo/trademarkinfo_edit")
		public String expert_edit(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/trademarkinfo/trademarkinfo_edit";
		}
		
		// 商标详情
		@RequestMapping(value = "/kjpt/trademarkinfo/trademarkinfo_view")
		public String expert_view(HttpServletRequest request, HttpServletResponse response) 
		{
			return "/kjpt/trademarkinfo/trademarkinfo_view";
		}

}
