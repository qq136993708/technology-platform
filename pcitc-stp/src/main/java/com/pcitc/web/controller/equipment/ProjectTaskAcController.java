package com.pcitc.web.controller.equipment;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.FindView;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
@Controller
@RequestMapping(value = "/sre_project_taskac")
public class ProjectTaskAcController extends BaseController{
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/page";
	private static final String AUDIT_URL="http://pcitc-zuul/stp-proxy/sre-provider/project_task/audit";
	@RequestMapping(value = "/to_list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		return "/stp/equipment/taskac/project_taskac_list";
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		//
		String applyDepartCode=sysUserInfo.getUnitCode();

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}
	
	@RequestMapping(value = "/to_prlist")
	public String prlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SysDictionary>  dicList= CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
		request.setAttribute("dicList", dicList);
		return "/stp/equipment/taskac/project_taskpr_list";
	}
	@RequestMapping(value = "/project_audit")
	public String audit(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String id= CommonUtil.getParameter(request, "id", "");
	    request.setAttribute("id", id);
		return "/stp/equipment/taskac/project_taskac_audit";
	}
	
	@RequestMapping(value = "/addAudit")
	@ResponseBody
	public String addAudit(HttpServletRequest request) throws Exception {
		ResponseEntity<String> responseEntity = null;
		String id = CommonUtil.getParameter(request, "id", "");
		String content = CommonUtil.getParameter(request, "content", "");
		SreProjectAudit s=new SreProjectAudit();
		s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		s.setProjecttaskid(id);
		s.setContent(content);
		s.setCreateUser(sysUserInfo.getUserId());
		s.setCreateDate(new Date());
		responseEntity = restTemplate.exchange(AUDIT_URL, HttpMethod.POST,new HttpEntity<SreProjectAudit>(s, this.httpHeaders),String.class);
		String success= "{}";
		String getbody=responseEntity.getBody();
	if(getbody.equals("success"))
	{
		 success ="{\"success\":\"success\"}";
	}
	else
	{
		success ="{\"success\":\"error\"}";
	}
		return success;
	}
}
