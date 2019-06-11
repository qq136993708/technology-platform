package com.pcitc.web.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysRole;
import com.pcitc.web.common.BaseController;

@RestController
public class RoleController extends BaseController {

	private static final String ROLE_GET_ROLE = "http://pcitc-zuul/system-proxy/role-provider/role/get-role/";
	private static final String ROLE_LIST_DATA = "http://pcitc-zuul/system-proxy/role-provider/role/role-list";
	private static final String ROLE_LIST_ALL_DATA = "http://pcitc-zuul/system-proxy/role-provider/role/role-list-all";
	private static final String ROLE_ADD_ROLE = "http://pcitc-zuul/system-proxy/role-provider/role/add-role";
	private static final String ROLE_UPDATE_ROLE = "http://pcitc-zuul/system-proxy/role-provider/role/upd-role";
	private static final String ROLE_DEL_ROLE = "http://pcitc-zuul/system-proxy/role-provider/role/del-role/";
	private static final String ROLE_DEL_ROLE_REAL = "http://pcitc-zuul/system-proxy/role-provider/role/del-role-real/";
	private static final String ROLE_USER_REL_ADD = "http://pcitc-zuul/system-proxy/role-provider/role/user-role-add";
	private static final String ROLE_USER_REL_DEL = "http://pcitc-zuul/system-proxy/role-provider/role/user-role-del";
	private static final String ROLE_FUNC_REL_TREE = "http://pcitc-zuul/system-proxy/role-provider/role/role-func-tree/";
	private static final String ROLE_CODE = "http://pcitc-zuul/system-proxy/role-provider/role/role-code";

	@RequestMapping(value = "/role/get-role/{roleId}")
	public Object getRoleInfo(@PathVariable("roleId") String roleId) throws Exception {
		return this.restTemplate.exchange(ROLE_GET_ROLE + roleId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysRole.class).getBody();
	}

	@RequestMapping(value = "/role/role-list")
	public Object getRoleListData(@ModelAttribute("param") LayuiTableParam param) throws Exception {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(ROLE_LIST_DATA, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/role/add-role")
	public Object addRole(@ModelAttribute("role") SysRole role) throws Exception {
		HttpEntity<SysRole> entit = new HttpEntity<SysRole>(role, this.httpHeaders);
		Integer rs = this.restTemplate.exchange(ROLE_ADD_ROLE, HttpMethod.POST, entit, Integer.class).getBody();
		if (rs > 0) {
			return new Result(true);
		} else {
			return new Result(false, "角色名已存在！");
		}
	}

	@RequestMapping(value = "/role/upd-role")
	public Object updateRole(@ModelAttribute("role") SysRole role) throws Exception {
		Integer rs = this.restTemplate.exchange(ROLE_UPDATE_ROLE, HttpMethod.POST, new HttpEntity<SysRole>(role, this.httpHeaders), Integer.class).getBody();
		if (rs > 0) {
			return new Result(true);
		} else {
			return new Result(false, "角色名已存在！");
		}
	}

	@RequestMapping(value = "/role/del-role/{roleId}")
	public Object delRole(@PathVariable("roleId") String roleId) throws Exception {
		ResponseEntity<Integer> rs = this.restTemplate.exchange(ROLE_DEL_ROLE + roleId, HttpMethod.DELETE, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (rs.getBody() > 0) {
			return new Result(true);
		} else {
			return new Result(false, "删除失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/role/del-role-real")
	public Object delRoleReal(String roleId) throws Exception {
		DataOperationStatusEnum rs = this.restTemplate.exchange(ROLE_DEL_ROLE_REAL + roleId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
		return rs;
	}

	@RequestMapping(value = "/role/user-role-add")
	public Object updUserRoleReal(@RequestParam(value = "userIds", required = false) String userIds, @RequestParam(value = "roleId", required = false) String roleId, HttpServletRequest request) throws Exception {
		System.out.println("userIds::ss:::::::::::::" + userIds);
		System.out.println("roleId::::ss::::::::" + roleId);
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<String, Object>();
		requestBody.add("roleId", roleId);
		requestBody.add("userIds", JSONArray.parseArray(userIds).toString());

		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(requestBody, this.httpHeaders);
		Integer rs = this.restTemplate.exchange(ROLE_USER_REL_ADD, HttpMethod.POST, entity, Integer.class).getBody();

		if (rs > 0) {
			return new Result(true);
		} else {
			return new Result(false, "更新失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/role/user-role-del")
	public Object delUserRoleReal(@RequestParam(value = "userIds", required = false) String userIds, @RequestParam(value = "roleId", required = false) String roleId) throws Exception {
		System.out.println("userIds:::::::::::::::" + userIds);
		System.out.println("roleId::::::::::::" + roleId);
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<String, Object>();
		requestBody.add("roleId", roleId);
		requestBody.add("userIds", JSONArray.parseArray(userIds).toString());

		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(requestBody, this.httpHeaders);
		Integer rs = this.restTemplate.exchange(ROLE_USER_REL_DEL, HttpMethod.POST, entity, Integer.class).getBody();

		if (rs > 0) {
			return new Result(true);
		} else {
			return new Result(false, "更新失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/role/role-func-tree")
	public Object getUnitTreeByRole(@RequestParam(value = "roleId", required = false) String roleId) throws Exception {
		HttpEntity<Object> node = this.restTemplate.exchange(ROLE_FUNC_REL_TREE + roleId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return node.getBody();
	}

	@RequestMapping(value = "/role/role-list-all")
	public Object getAllRoles() throws Exception {
		return this.restTemplate.exchange(ROLE_LIST_ALL_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
	}

	@RequestMapping(value = "/role/role-code")
	public Object getRoleCode(@ModelAttribute("role") SysRole role) throws Exception {
		String rs = this.restTemplate.exchange(ROLE_CODE, HttpMethod.POST, new HttpEntity<SysRole>(role, this.httpHeaders), String.class).getBody();
		return new Result(true, rs);
	}
}
