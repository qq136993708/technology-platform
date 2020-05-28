package com.pcitc.web.common;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class MappingContrller extends BaseController{


	private static final String TECH_TYPE_STR = "http://kjpt-zuul/stp-proxy/tech_family_provider/getMaxCodeByParentId";
	@RequestMapping(value = "/syslog/to_list")
	public String syslog_list(HttpServletRequest request, HttpServletResponse response)
	{

		String logType=CommonUtil.getParameter(request, "logType", "1");//日志类型：1登陆日志，2操作日志，3错误日志
		String userType=CommonUtil.getParameter(request, "userTypes", "");//用户类型：1普通用户，2系统管理员，3安全员，4审计员
		String userType2=CommonUtil.getParameter(request, "userType2", "");
		request.setAttribute("logType", logType);
		request.setAttribute("userType", userType);
		request.setAttribute("userType2", userType2);
		String resault="/base/sysLog/log_list";
		if(logType.equals("2"))
		{
			resault="/base/sysLog/opt_list";
		}
		if(logType.equals("3"))
		{
			resault="/base/sysLog/error_list";
		}
		return resault;
	}

	@RequestMapping(value = "/syslog/to_auditadmin_list")
	public String to_auditadmin_list(HttpServletRequest request, HttpServletResponse response)
	{
		return null;
	}


	// 专家管理
	@RequestMapping(value = "/kjpt/expert/expert_list")
	public String expert_list(HttpServletRequest request, HttpServletResponse response)
	{
		return "/kjpt/expert/expert_list";
	}


	// 专家查询
	@RequestMapping(value = "/kjpt/expert/expert_query")
	public String expert_query(HttpServletRequest request, HttpServletResponse response)
	{
		return "/kjpt/expert/expert_query";
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






	@RequestMapping(value = "/tech-family/tree_index")
	public String tree_index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjpt/techFamily/tree_index";
	}

	@RequestMapping(value = "/tech-family/add")
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjpt/techFamily/add";
	}


	@RequestMapping(value = "/tech-family/update")
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjpt/techFamily/update";
	}


	@RequestMapping(value = "/out/getOutProjectList")
	public String out_projectList(HttpServletRequest request) throws Exception {
		request.setAttribute("projectName", request.getParameter("projectName"));
		request.setAttribute("setupYear", request.getParameter("setupYear"));
		return "/kjpt/out/out_projectList";
	}










	@RequestMapping(value = "/achieve/achieve_list")
	public String achieve(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjpt/achieve/achieve_list";
	}

	@RequestMapping(value = "/achieve/achieve_query")
	public String achieve_query(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjpt/achieve/achieve_query";
	}




	@RequestMapping(value = "/achieve/record_list")
	public String record_list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/kjpt/achieve/record_list";
	}





	@RequestMapping(value = "/user_secret_list")
	public String user_secret_list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/base/user/user_secret_list";
	}


	@RequestMapping(value = "/user_post_list")
	public String user_post_list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/base/user/user_post_list";
	}



	@RequestMapping(value = "/jsc_web")
	public String jsc_web(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return "/jsc_web/index";
	}


//		@RequestMapping(value = "/error")
//		public String error(HttpServletRequest request, HttpServletResponse response) throws Exception
//		{
//			return "redirect:/index";
//			//return "/error_404";
//		}



	@RequestMapping(value = "/tech_family/to_add_family")
	public String iniAddTechFamilyType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysUser sysUserInfo = this.getUserProfile();
		request.setAttribute("userInfo", sysUserInfo);
		// 获取当前节点孩子的最大编码，新节点编码在原有基础上加1
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("parentId", request.getParameter("tfmTypeId"));
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(TECH_TYPE_STR, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		request.setAttribute("typeCode", retJson.get("maxTypeCode"));
		request.setAttribute("parentId", request.getParameter("tfmTypeId"));
		return "/stp/techFamily/techType_add";
	}




	@RequestMapping(value = "/tech_family/ini_chart")
	public String iniTechFamily_Tree(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysUser sysUserInfo = getUserProfile();
		request.setAttribute("userInfo", sysUserInfo);
		return "/stp/techFamily/iniTechTypeTree";
	}



}
