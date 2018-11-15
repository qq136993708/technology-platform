package com.pcitc.web.controller.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.system.SysFunctionGroup;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("functiongroup")
public class SysFunctionGroupController extends BaseController {

	private static final String POST_GET_FUNCTIONGROUP = "http://pcitc-zuul/system-proxy/functiongroup-provider/functiongroup/functiongroup-list";
	private static final String FUNCTIONGROUP_INFO = "http://pcitc-zuul/system-proxy/functiongroup-provider/functiongroup/functiongroup-info/";
	private static final String FUNCTIONGROUP_FUNCTIONS = "http://pcitc-zuul/system-proxy/functiongroup-provider/functiongroup/functiongroup-functions/";
	private static final String POST_GET_FUNCTIONGROUP_TABLE = "http://pcitc-zuul/system-proxy/functiongroup-provider/functiongroup/functiongroup-table";
	
	
	private static final String FUNCTIONGROUP_ADD_AND_UPD = "http://pcitc-zuul/system-proxy/functiongroup-provider/functiongroup/functiongroup-update";
	private static final String FUNCTIONGROUP_DEL = "http://pcitc-zuul/system-proxy/functiongroup-provider/functiongroup/functiongroup-del/";
	private static final String FUNCTIONGROUP_ROLE_UPD = "http://pcitc-zuul/system-proxy/functiongroup-provider/functiongroup/functiongroup-update-functions";
	
	private String basePath;
	
	@RequestMapping(value = "/functiongroup-manage", method = RequestMethod.GET)
	public Object toFunctionGroupPageList(HttpServletRequest request) throws IOException 
	{
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
        return "base/auth/functiongroup_list";
	}
	@RequestMapping(value = "/functiongroup-edit", method = RequestMethod.GET)
	public Object toFunctionGroupEditPage(HttpServletRequest request) throws IOException 
	{
		basePath = request.getContextPath();
	    request.setAttribute("basePath", basePath);
	    request.setAttribute("functionGroupId", request.getParameter("functionGroupId"));
        return "base/auth/functiongroup_edit";
	}
	@RequestMapping(value = "/functiongroup-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getDataList(HttpServletRequest request) throws IOException 
	{
		HttpEntity<Object> entity = new HttpEntity<Object>(this.httpHeaders);
		ResponseEntity<?> responseEntity = this.restTemplate.exchange(POST_GET_FUNCTIONGROUP, HttpMethod.POST, entity, List.class);
		return JSON.toJSON(responseEntity.getBody()).toString();
	}
	
	@RequestMapping(value = "/functiongroup-table", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(@ModelAttribute("param")LayuiTableParam param) throws IOException {
		
		System.out.print("functionGroupName:"+param.getParam().get("functionGroupName"));
		
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(POST_GET_FUNCTIONGROUP_TABLE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}
	@RequestMapping(value = "/functiongroup-functions", method = RequestMethod.POST)
	@ResponseBody
	public Object getFunctionGroupFunctions(@RequestParam(name="groupId",required=false)String groupId,HttpServletRequest request) throws IOException {

	 ResponseEntity<String> responseEntity = this.restTemplate.exchange(FUNCTIONGROUP_FUNCTIONS+groupId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), String.class);
	 return responseEntity.getBody();
	}

	@RequestMapping(value = "/functiongroup-info", method = RequestMethod.POST)
	@ResponseBody
	public Object getFunctionGroupInfo(@RequestParam(name="groupId",required=false)String groupId,HttpServletRequest request) throws IOException {

	 ResponseEntity<SysFunctionGroup> responseEntity = this.restTemplate.exchange(FUNCTIONGROUP_INFO+groupId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFunctionGroup.class);
	 return responseEntity.getBody();
	}
	
	@RequestMapping(value = "/functiongroup-update", method = RequestMethod.POST)
	@ResponseBody
	public Object saveFunctionGroupInfo(@ModelAttribute("group") SysFunctionGroup group, HttpServletRequest request)
			throws IOException {
		group.setCreatePersonId(sysUserInfo.getUserId());
		group.setCreatePersonName(sysUserInfo.getUserName());
		group.setStatus(DelFlagEnum.STATUS_NORMAL.getCode());
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(FUNCTIONGROUP_ADD_AND_UPD, HttpMethod.POST,
				new HttpEntity<SysFunctionGroup>(group, this.httpHeaders), Integer.class);
		Integer rs = responseEntity.getBody();
		if (rs > 0) {
			return new Result(true, "操作成功！");
		} else {
			return new Result(false, "保存失败请重试！");
		}
	}
	@RequestMapping(value = "/functiongroup-del", method = RequestMethod.POST)
	@ResponseBody
	public Object delFunctionGroupInfo(@RequestParam(name="groupId",required=false)String groupId,HttpServletRequest request) throws IOException {

		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(FUNCTIONGROUP_DEL+groupId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		Integer rs = responseEntity.getBody();
		if (rs > 0) {
			return new Result(true, "操作成功！");
		} else {
			return new Result(false, "保存失败请重试！");
		}
	}
	@RequestMapping(value = "/functiongroup-update-functions", method = RequestMethod.POST)
	@ResponseBody
	public Object updateFunctionGroupFunctions(@ModelAttribute("group") SysFunctionGroup group,HttpServletRequest request) throws IOException {

		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(FUNCTIONGROUP_ROLE_UPD, HttpMethod.POST, new HttpEntity<SysFunctionGroup>(group,this.httpHeaders), Integer.class);
		Integer rs = responseEntity.getBody();
		if (rs > 0) {
			return new Result(true, "操作成功！");
		} else {
			return new Result(false, "保存失败请重试！");
		}
	}
	
	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
}
