package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/role")
public class RolePageController 
{
	private String basePath;
	@RequestMapping(method = RequestMethod.GET, value = "/role_list")
	private String toOrgTreePage(HttpServletRequest request) {
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
        return "base/auth/role_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	private String editRole(HttpServletRequest request) {
		basePath = request.getContextPath();
		if(request.getParameter("roleId") != null){
			request.setAttribute("roleId", request.getParameter("roleId"));
		}
	    request.setAttribute("basePath", basePath);
	    
        return "base/auth/role_edit";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/user_role_rel")
	private String editUserRoleRel(HttpServletRequest request,@RequestParam(name="roleId",required=false)String roleId) {
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
	    request.setAttribute("roleId",roleId);
        return "base/auth/userrole_select";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/role_function")
	private String editRoleFunctionRel(HttpServletRequest request,@RequestParam(name="roleId",required=false)String roleId) {
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
	    request.setAttribute("roleId",roleId);
        return "base/auth/rolefunc_list";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/role_function_rel")
	private String editRoleFunction(HttpServletRequest request,@RequestParam(name="roleId",required=false)String roleId) {
		basePath = request.getContextPath();
		request.setAttribute("roleId", roleId);
	    request.setAttribute("basePath", basePath);
	    System.out.println("-------roleId--------"+roleId);
        return "base/auth/rolefunc_select";
    }
	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	 
	 
}
