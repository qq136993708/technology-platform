package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/org")
public class OrgPageController 
{
	private String basePath;
	@RequestMapping(method = RequestMethod.GET, value = "/org_tree")
	private String toOrgTreePage(HttpServletRequest request) {
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
        return "base/org/org_tree";
    }
	

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	 
	 
}
