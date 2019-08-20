package com.pcitc.web.controller.invoices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.web.common.BaseController;

@Controller
public class InvoicesController extends BaseController 
{
	@RequestMapping(method = RequestMethod.GET, value = "/invoices/project_main")
	public Object toBudgetGroupPage(HttpServletRequest request) throws IOException 
	{
		return "stp/invoices/project_main";
	}
	
}
