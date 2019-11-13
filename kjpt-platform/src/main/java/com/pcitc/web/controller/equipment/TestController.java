package com.pcitc.web.controller.equipment;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController {
	
	@RequestMapping(value = "/charts_table")
	public String charts_table(HttpServletRequest request,HttpServletResponse response) 
	{
		return "/layui/charts_table";
	}
	
	
	
	@RequestMapping(value = "/form")
	public String list(HttpServletRequest request,HttpServletResponse response) 
	{
		return "/layui/form";
	}
	
	@RequestMapping(value = "/formUpload")
	public String list2(HttpServletRequest request,HttpServletResponse response) 
	{
		
		return "/layui/formUpload";
	}
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,HttpServletResponse response) 
	{
		
		return "/layui/index";
	}
	@RequestMapping(value = "/report_load")
	public String report_load(HttpServletRequest request,HttpServletResponse response) 
	{
		
		return "/layui/report_load";
	}
	@RequestMapping(value = "/tableDemo")
	public String tableDemo(HttpServletRequest request,HttpServletResponse response) 
	{
		
		return "/layui/tableDemo";
	}
	@RequestMapping(value = "/tree_tableDemo_layui")
	public String list61(HttpServletRequest request,HttpServletResponse response) 
	{
		return "/layui/tree_tableDemo_layui";
	}
	@RequestMapping(value = "/upload")
	public String list23(HttpServletRequest request,HttpServletResponse response) 
	{
		
		return "/layui/upload";
	}
	
	@RequestMapping(value = "/tree_tableDemo")
	public String dictionary(HttpServletRequest request,HttpServletResponse response) 
	{
		
		return "/layui/tree_tableDemo";
	}
	
	
	

}
