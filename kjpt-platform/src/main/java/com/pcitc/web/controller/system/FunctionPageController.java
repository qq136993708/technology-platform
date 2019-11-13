package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/function")
public class FunctionPageController 
{
	private String basePath;
	@RequestMapping(method = RequestMethod.GET, value = "/function_tree")
	private String toOrgTreePage(HttpServletRequest request) {
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
        return "base/auth/function_tree";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/function_list")
	private String toFunctionListPage(HttpServletRequest request) {
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
        return "pplus/sample/function_list";
    }

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	 
	 
}
