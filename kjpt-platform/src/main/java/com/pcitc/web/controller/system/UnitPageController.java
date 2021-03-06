package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.util.CommonUtil;

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
	
	@RequestMapping(value = "/chooseUnit", method = RequestMethod.GET)
	public String chooseUnit( HttpServletRequest request, HttpServletResponse response) throws Exception {

		//回调函数名
		String funcName = CommonUtil.getParameter(request, "funcName", "");
		request.setAttribute("funcName", funcName);
		return "base/unit/chooseUnit";
	}
	

	@RequestMapping(value = "/chooseUnitMulti_UserEdit", method = RequestMethod.GET)
	public String chooseUnitMulti_UserEdit( HttpServletRequest request, HttpServletResponse response) throws Exception {

		//回调函数名
		String funcName = CommonUtil.getParameter(request, "funcName", "");
		request.setAttribute("funcName", funcName);
		return "base/unit/chooseUnitMulti_UserEdit";
	}
	
	
	@RequestMapping(value = "/chooseUnitMulti", method = RequestMethod.GET)
	public String chooseUnitMulti( HttpServletRequest request, HttpServletResponse response) throws Exception {

		//回调函数名
		String funcName = CommonUtil.getParameter(request, "funcName", "");
		request.setAttribute("funcName", funcName);
		return "base/unit/chooseUnitMulti";
	}

	@RequestMapping(value = "/chooseUnitMultiExpert", method = RequestMethod.GET)
	public String chooseUnitMultiExpert( HttpServletRequest request, HttpServletResponse response) throws Exception {

        //回调函数名
        String initFuncName = CommonUtil.getParameter(request, "initFuncName", "");
        String callbackFuncName = CommonUtil.getParameter(request, "callbackFuncName", "");
        request.setAttribute("initFuncName", initFuncName);
        request.setAttribute("callbackFuncName", callbackFuncName);
		return "base/unit/chooseUnitMultiExpert";
	}
	@RequestMapping(value = "/chooseUnitMultiV2", method = RequestMethod.GET)
	public String chooseUnitMultiV2( HttpServletRequest request, HttpServletResponse response) throws Exception {

		//回调函数名
		String initFuncName = CommonUtil.getParameter(request, "initFuncName", "");
		String callbackFuncName = CommonUtil.getParameter(request, "callbackFuncName", "");
		request.setAttribute("initFuncName", initFuncName);
		request.setAttribute("callbackFuncName", callbackFuncName);
		return "base/unit/chooseUnitMultiV2";
	}
	
	
	
	@RequestMapping(value = "/choose_unit_users", method = RequestMethod.GET)
	public String choose_unit_users( HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "base/unit/choose_unit_users";
	}
	
}
