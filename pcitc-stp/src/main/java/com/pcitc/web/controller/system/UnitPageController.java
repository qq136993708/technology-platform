package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/unit")
public class UnitPageController 
{
	@RequestMapping(method = RequestMethod.GET, value = "/unit_tree")
	private String toOrgTreePage(HttpServletRequest request) 
	{
        return "base/unit/unit_tree";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/edit_unit")
	private String toEditUnitPage(HttpServletRequest request) 
	{
		request.setAttribute("unitId", request.getParameter("unitId"));
		request.setAttribute("parentUnitId", request.getParameter("parentUnitId"));
        return "base/unit/edit_unit";
    }
}
