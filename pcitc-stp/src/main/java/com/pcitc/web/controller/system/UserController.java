package com.pcitc.web.controller.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.PageCommon;

@Controller
public class UserController extends BaseController {

	/*
	 * 1、可以直接通过注册的服务名来访问，来实现访问和负载。不过如果用zuul的话， 要用zuul的服务名和实际访问的服务名一起
	 * 2、pplus本身是一个微服务，属于微服务之间的调用，可以直接用名称，不用ip.（注意启动类中的注解）
	 */

	private static final String USER_GET_URL = "http://pcitc-zuul/system-proxy/user-provider/user/get-user/";
	private static final String USER_GET_IN_ROLE_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-in-role";
	private static final String USER_GET_NOT_ROLE_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-not-role";
	private static final String USER_ADD_URL = "http://pcitc-zuul/system-proxy/user-provider/user/add-user";
	private static final String USER_UPDATE_URL = "http://pcitc-zuul/system-proxy/user-provider/user/update-user";
	private static final String USER_PAGE_URL = "http://pcitc-zuul/system-proxy/user-provider/user/users-page";
	private static final String USER_LIST_PAGE_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-list";
	private static final String USER_DEL_URL = "http://pcitc-zuul/system-proxy/user-provider/user/delete-user/";
	private static final String USER_UNIQUE_CHECK_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-validate";
	
	private static final String QUERY_SYS_USER_LIST_BY_PAGE = "http://pcitc-zuul/system-proxy/user-provider/user/querySysUserListByPage/";
	private static final String GET_SYS_USER_LIST_BY_UNIT = "http://pcitc-zuul/system-proxy/user-provider/user/getSysUserListByUserUnitPage/";
	

	// private static final String USER_GET_BY_UNIT =
	// "http://pcitc-zuul/system-proxy/user-provider/user/get-user-by-unit";
	private static final String USER_DELUSERS = "http://pcitc-zuul/system-proxy/user-provider/user/delete-users";
	// 组织机构查询（回写）
	private static final String UNIT_LIST = "http://pcitc-zuul/system-proxy/unit-provider/unit-list";
	// 岗位信息查询（回写）
	private static final String GET_POST_LIST = "http://pcitc-zuul/system-proxy/post-provider/post/list-data";

	@RequestMapping(value = "/user/delete/{userId}")
	@ResponseBody
	public Object delUser(@PathVariable("userId") String userId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<Integer> presult = this.restTemplate.exchange(USER_DEL_URL + userId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		if (presult.getBody() > 0) {
			return new Result(true);
		} else {
			return new Result(false, "删除失败，请联系系统管理员！");
		}
	}

	@RequestMapping(value = "/user/get-user")
	@ResponseBody
	public Object getUser(@RequestParam(value = "userId", required = true) String userId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.restTemplate.exchange(USER_GET_URL + userId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/user/user-saveorupdate", method = RequestMethod.POST)
	@ResponseBody
	public Object userInsert(@ModelAttribute("user") SysUser user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 检查用户名是否可用
		ResponseEntity<List> checkStatus = this.restTemplate.exchange(USER_UNIQUE_CHECK_URL, HttpMethod.POST, new HttpEntity<SysUser>(user, this.httpHeaders), List.class);
		List<Boolean> unique = checkStatus.getBody();
		if (!unique.get(0)) {
			return new Result(false, "登录名不能重复！");
		}
		if (!unique.get(1)) {
			return new Result(false, "邮箱不能重复！");
		}
		// 如果更改密码
		if (!StringUtils.isBlank(user.getUserPassword())) {
			user.setUserPassword(MD5Util.MD5Encode(user.getUserPassword()));
		}
		//System.out.println(JSON.toJSONString(user));
		ResponseEntity<Integer> status = null;
		if (StringUtils.isBlank(user.getUserId())) {
			user.setUserId(IdUtil.createIdByTime());
			user.setUserDelflag(DelFlagEnum.STATUS_NORMAL.getCode());
			status = this.restTemplate.exchange(USER_ADD_URL, HttpMethod.POST, new HttpEntity<SysUser>(user, this.httpHeaders), Integer.class);
		} else {
			status = this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(user, this.httpHeaders), Integer.class);
		}
		if (status.getBody() == 0) {
			return new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		} else {
			return new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		}
	}

	@RequestMapping(value = "/user/resetPassword-users", method = RequestMethod.POST)
	@ResponseBody
	public Object userResetPassword(@RequestParam(value = "userId", required = false) String userId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 如果更改密码
		SysUser sysUser = new SysUser();
		sysUser.setUserPassword(MD5Util.MD5Encode("000000"));// 默认密码6个0
		ResponseEntity<Integer> status = null;
		sysUser.setUserId(userId);
		// sysUser.setUserDelflag(DelFlagEnum.STATUS_NORMAL.getCode());
		status = this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(sysUser, this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
		} else {
			return new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
		}
	}

	@RequestMapping(value = "/user/user-list")
	@ResponseBody
	public Object getUserList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		// System.out.print("userId:"+this.sysUser.getUserId());
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(USER_LIST_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		// 用户类型回写
		String parentCode = "ROOT_XTGL_YHLX"; // 字典编码
		String writebackField = "userKind"; // 回写字段
		JSONObject dataObject = (JSONObject) JSON.toJSON(data);
		PageCommon pageCommon = new PageCommon();
		pageCommon.getDictionaryWriteback(this.restTemplate, this.httpHeaders, dataObject, parentCode, writebackField);

		// 域用户回写
		parentCode = "ROOT_XTGL_YYH"; // 字典编码
		writebackField = "isDomain"; // 回写字段
		pageCommon.getDictionaryWriteback(this.restTemplate, this.httpHeaders, dataObject, parentCode, writebackField);

		// 机构
		writebackField = "userUnit"; // 回写字段
		DataTableInfoVo tableInfo = new DataTableInfoVo();
		tableInfo.setiDisplayLength(1000);
		String resultUnit = this.restTemplate.exchange(UNIT_LIST, HttpMethod.POST, new HttpEntity<DataTableInfoVo>(tableInfo, this.httpHeaders), String.class).getBody();
		JSONObject retUnitJson = (JSONObject) JSON.parse(resultUnit);
		com.alibaba.fastjson.JSONArray retUnitArray = retUnitJson.getJSONArray("list");
		com.alibaba.fastjson.JSONArray dataArray = dataObject.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject jsonObject = dataArray.getJSONObject(i);
			String wirtebackId = jsonObject.getString(writebackField);
			String[] wirtebackIds = wirtebackId.split(",");
			String wirtebackValue = "";
			for (int j = 0; j < wirtebackIds.length; j++) {
				String id = wirtebackIds[j];
				for (int k = 0; k < retUnitArray.size(); k++) {
					JSONObject unitObject = retUnitArray.getJSONObject(k);
					String unitId = unitObject.getString("unitId"); // 单位ID
					if (id.equals(unitId)) {
						String unitName = unitObject.getString("unitName"); // 单位名称
						wirtebackValue += unitName + ",";
						break;
					}
				}
			}
			if (wirtebackValue.length() > 0) {
				wirtebackValue = wirtebackValue.substring(0, wirtebackValue.length() - 1);
			}
			jsonObject.put(writebackField + "Disp", wirtebackValue);
		}
		// 岗位
		List<?> rs = this.restTemplate.exchange(GET_POST_LIST, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), List.class).getBody();
		com.alibaba.fastjson.JSONArray retPostArray = (com.alibaba.fastjson.JSONArray) JSON.parse(JSONObject.toJSON(rs).toString());
		writebackField = "userPost"; // 回写字段
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject jsonObject = dataArray.getJSONObject(i);
			String wirtebackId = jsonObject.getString(writebackField);
			String[] wirtebackIds = wirtebackId.split(",");
			String wirtebackValue = "";
			for (int j = 0; j < wirtebackIds.length; j++) {
				String id = wirtebackIds[j];
				for (int k = 0; k < retPostArray.size(); k++) {
					JSONObject postObject = retPostArray.getJSONObject(k);
					String postId = postObject.getString("postId"); // 岗位ID
					if (id.equals(postId)) {
						String postName = postObject.getString("postName"); // 岗位名称
						wirtebackValue += postName + ",";
						break;
					}
				}
			}
			if (wirtebackValue.length() > 0) {
				wirtebackValue = wirtebackValue.substring(0, wirtebackValue.length() - 1);
			}
			jsonObject.put(writebackField + "Disp", wirtebackValue);
		}
		return dataObject.toString();
	}

	/**
	 * 人员选择
	 * 
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param) throws IOException {

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(USER_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		return JSON.toJSON(data).toString();
	}

	@RequestMapping(value = "/user/user-in-role", method = RequestMethod.POST)
	@ResponseBody
	public Object getUserDataByRole(@ModelAttribute("param") LayuiTableParam param) throws IOException {
		//System.out.print("roleId:" + param.getParam().get("roleId"));
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(USER_GET_IN_ROLE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();

		String parentCode = "ROOT_XTGL_YHLX"; // 字典编码
		String writebackField = "userKind"; // 回写字段
		JSONObject dataObject = (JSONObject) JSON.toJSON(data);
		PageCommon pageCommon = new PageCommon();
		pageCommon.getDictionaryWriteback(this.restTemplate, this.httpHeaders, dataObject, parentCode, writebackField);
		// 机构
		writebackField = "userUnit"; // 回写字段
		DataTableInfoVo tableInfo = new DataTableInfoVo();
		tableInfo.setiDisplayLength(1000);
		String resultUnit = this.restTemplate.exchange(UNIT_LIST, HttpMethod.POST, new HttpEntity<DataTableInfoVo>(tableInfo, this.httpHeaders), String.class).getBody();
		JSONObject retUnitJson = (JSONObject) JSON.parse(resultUnit);
		com.alibaba.fastjson.JSONArray retUnitArray = retUnitJson.getJSONArray("list");
		com.alibaba.fastjson.JSONArray dataArray = dataObject.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject jsonObject = dataArray.getJSONObject(i);
			String wirtebackId = jsonObject.getString(writebackField);
			String[] wirtebackIds = wirtebackId.split(",");
			String wirtebackValue = "";
			for (int j = 0; j < wirtebackIds.length; j++) {
				String id = wirtebackIds[j];
				for (int k = 0; k < retUnitArray.size(); k++) {
					JSONObject unitObject = retUnitArray.getJSONObject(k);
					String unitId = unitObject.getString("unitId"); // 单位ID
					if (id.equals(unitId)) {
						String unitName = unitObject.getString("unitName"); // 单位名称
						wirtebackValue += unitName + ",";
						break;
					}
				}
			}
			if (wirtebackValue.length() > 0) {
				wirtebackValue = wirtebackValue.substring(0, wirtebackValue.length() - 1);
			}
			jsonObject.put(writebackField + "Disp", wirtebackValue);
		}
		return dataObject.toString();
	}

	@RequestMapping(value = "/user/user-not-role", method = RequestMethod.POST)
	@ResponseBody
	public Object getUserDataNotInRole(@ModelAttribute("param") LayuiTableParam param) throws IOException {
		//System.out.print("roleId:" + param.getParam().get("roleId"));
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(USER_GET_NOT_ROLE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();

		String parentCode = "ROOT_XTGL_YHLX"; // 字典编码
		String writebackField = "userKind"; // 回写字段
		JSONObject dataObject = (JSONObject) JSON.toJSON(data);
		PageCommon pageCommon = new PageCommon();
		pageCommon.getDictionaryWriteback(this.restTemplate, this.httpHeaders, dataObject, parentCode, writebackField);
		// 机构
		writebackField = "userUnit"; // 回写字段
		DataTableInfoVo tableInfo = new DataTableInfoVo();
		tableInfo.setiDisplayLength(1000);
		String resultUnit = this.restTemplate.exchange(UNIT_LIST, HttpMethod.POST, new HttpEntity<DataTableInfoVo>(tableInfo, this.httpHeaders), String.class).getBody();
		JSONObject retUnitJson = (JSONObject) JSON.parse(resultUnit);
		com.alibaba.fastjson.JSONArray retUnitArray = retUnitJson.getJSONArray("list");
		com.alibaba.fastjson.JSONArray dataArray = dataObject.getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject jsonObject = dataArray.getJSONObject(i);
			String wirtebackId = jsonObject.getString(writebackField);
			String[] wirtebackIds = wirtebackId.split(",");
			String wirtebackValue = "";
			for (int j = 0; j < wirtebackIds.length; j++) {
				String id = wirtebackIds[j];
				for (int k = 0; k < retUnitArray.size(); k++) {
					JSONObject unitObject = retUnitArray.getJSONObject(k);
					String unitId = unitObject.getString("unitId"); // 单位ID
					if (id.equals(unitId)) {
						String unitName = unitObject.getString("unitName"); // 单位名称
						wirtebackValue += unitName + ",";
						break;
					}
				}
			}
			if (wirtebackValue.length() > 0) {
				wirtebackValue = wirtebackValue.substring(0, wirtebackValue.length() - 1);
			}
			jsonObject.put(writebackField + "Disp", wirtebackValue);
		}
		return dataObject.toString();
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @RequestMapping(value = "/user/get-user-by-unit", method =
	 * RequestMethod.POST) public Object getUserByUnit(DataTableInfo
	 * tableInfo,HttpServletRequest request) throws IOException { //传递参数
	 * httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	 * ResponseEntity<JSONObject> responseEntity =
	 * this.restTemplate.exchange(USER_GET_BY_UNIT, HttpMethod.POST, new
	 * HttpEntity<DataTableInfo>(tableInfo, this.httpHeaders),
	 * JSONObject.class); JSONObject retJson = responseEntity.getBody(); Long
	 * totalCount = retJson.get("totalCount") != null?
	 * Long.parseLong(retJson.get("totalCount").toString()):0l;
	 * 
	 * List<SysUser> userList = JSONArray.toList(retJson.getJSONArray("list"),
	 * new SysUser(), new JsonConfig()); DataTableParameter data = new
	 * DataTableParameter(); data.setAaData(userList); //要显示的总条数
	 * data.setiTotalDisplayRecords(totalCount); //真实的总条数
	 * data.setiTotalRecords(totalCount);
	 * 
	 * return data; }
	 */
	@RequestMapping(value = "/user/delete-users", method = RequestMethod.POST)
	public Object delUsers(@RequestParam(value = "userIds", required = false) String userIds) throws IOException {
		JSONArray array = JSONArray.parseArray(userIds);
		List<?> ids = JSONObject.parseArray(array.toJSONString());
		ResponseEntity<Integer> status = this.restTemplate.exchange(USER_DELUSERS, HttpMethod.POST, new HttpEntity<List<?>>(ids, this.httpHeaders), Integer.class);
		if (status.getBody() > 0) {
			return new Result(true);
		} else {
			return new Result(false);
		}
	}

	@RequestMapping(value = "/user/user-display", method = RequestMethod.POST)
	@ResponseBody
	public Object userInfoDisplay() throws IOException {
		// 获取当前用户信息
		return sysUserInfo;
	}

	// 更新当前用户密码
	@RequestMapping(value = "/user/upd-pass", method = RequestMethod.POST)
	@ResponseBody
	public Object updateCurrentUserPassword(@RequestParam(value = "oldPass", required = false) String oldPass, @RequestParam(value = "newPass", required = false) String newPass) throws IOException {
		SysUser user = this.restTemplate.exchange(USER_GET_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
		if (user == null) {
			return new Result(false, "用户不存在！");
		}
		if (!user.getUserPassword().equals(MD5Util.MD5Encode(oldPass))) {
			return new Result(false, "原始密码错误！");
		}
		user.setUserPassword(MD5Util.MD5Encode(newPass));
		ResponseEntity<Integer> status = this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(user, this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false, "密码更改失败，请联系管理员！");
		} else {
			return new Result(true, "密码修改成功！");
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/ini-self-config")
	private String toUpdatePassPage(HttpServletRequest request) {
		SysUser user = this.restTemplate.exchange(USER_GET_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
		request.setAttribute("userInfo", user);
		return "base/user/user_config";
	}

	// 修改个人设置信息
	@RequestMapping(value = "/user/self-config", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSelfConfig(@RequestBody String params) throws IOException {
		// 获取个人原有信息
		SysUser user = this.restTemplate.exchange(USER_GET_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();

		if (user == null) {
			return new Result(false, "用户不存在！");
		}
		JSONObject reJson = JSONObject.parseObject(params);
		//System.out.println("===updateSelfConfig---"+reJson.getString("userConfig1"));
		user.setUserConfig1(reJson.getString("userConfig1"));
		ResponseEntity<Integer> status = this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(user, this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false, "个人设置失败！");
		} else {
			return new Result(true, "个人设置成功！");
		}
	}

	// 更新头像
	@RequestMapping(value = "/user/upd-headimg", method = RequestMethod.POST)
	@ResponseBody
	public Object updateCurrentUserHeadImg(@RequestParam(value = "userExtend", required = false) String userExtend) throws IOException {
		SysUser user = this.restTemplate.exchange(USER_GET_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
		if (user == null) {
			return new Result(false, "用户不存在！");
		}
		user.setUserExtend(userExtend);// 只更新头像
		//System.out.println("userExtenduserExtenduserExtenduserExtend" + userExtend);
		ResponseEntity<Integer> status = this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(user, this.httpHeaders), Integer.class);
		if (status.getBody() == 0) {
			return new Result(false, "密码更改失败，请联系管理员！");
		} else {
			return new Result(true, "密码修改成功！");
		}
	}
	
	
	
	@RequestMapping(value = "/user/querySysUserListByPage", method = RequestMethod.POST)
	@ResponseBody
	public Object querySysUserListByPage(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
	    ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(QUERY_SYS_USER_LIST_BY_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
	    LayuiTableData result = responseEntity.getBody();
	    JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}
	
	
	
	@RequestMapping(value = "/user/getSysUserListByUserUnitPage", method = RequestMethod.POST)
	@ResponseBody
	public Object getSysUserListByUserUnitPage(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
	    ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(GET_SYS_USER_LIST_BY_UNIT, HttpMethod.POST, entity, LayuiTableData.class);
	    LayuiTableData result = responseEntity.getBody();
	    JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}

	
	
	
	
	

	
	
}