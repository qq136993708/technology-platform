package com.pcitc.web.controller.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysRestfulapi;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("restfulapi")
public class SysRestfulapiController extends BaseController {

	private static final String RESTFULAPI_LIST_DATA = "http://pcitc-zuul/system-proxy/sys_restfulapi/show-list";
	private static final String RESTFULAPI_INSERT_DATA = "http://pcitc-zuul/system-proxy/sys_restfulapi/insert-data";
	private static final String RESTFULAPI_UPDATE_DATA = "http://pcitc-zuul/system-proxy/sys_restfulapi/update-data";
	private static final String RESTFULAPI_SHOWBYID_DATA = "http://pcitc-zuul/system-proxy/sys_restfulapi/showById-data/";
	private static final String RESTFULAPI_DELETEE_DATA = "http://pcitc-zuul/system-proxy/sys_restfulapi/delete-data";

	/**
	 * 跳转页面
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/toNewsList" }, method = RequestMethod.GET)
	public String toUserPorperty() {
		return "base/system/sysRestfulapi_list";
	}

	@ResponseBody
	@RequestMapping(value = "/sys_restfulapi/show-list")
	public Object getWarehousingData(HttpServletRequest request) {
		System.out.println("====/sys_restfulapi/show-list");
		String iDisplayStart = request.getParameter("page"); // 起始索引
		String iDisplayLength = request.getParameter("limit"); // 每页显示的行数
		String modelName = request.getParameter("modelName"); // 每页显示的行数
		System.out.println(iDisplayLength + "========" + iDisplayStart);
		JSONObject param1 = new JSONObject();
		JSONObject param2 = new JSONObject();
		JSONObject param3 = new JSONObject();
		param1.put("name", "iDisplayStart");
		param1.put("value", iDisplayStart);
		param2.put("name", "iDisplayLength");
		param2.put("value", iDisplayLength);
		param3.put("name", "modelName");
		param3.put("value", modelName);

		JSONArray param = new JSONArray();
		param.add(param1);
		param.add(param2);
		param.add(param3);

		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("jsonStr", param.toJSONString());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(RESTFULAPI_LIST_DATA, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
		List<SysRestfulapi> pendingList = JSONArray.parseArray(retJson.getJSONArray("list").toString(), SysRestfulapi.class);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("code", "0");
		jsonObj.put("msg", "提示");
		jsonObj.put("count", totalCount);
		jsonObj.put("data", pendingList);
		return jsonObj.toString();
	}

	/**
	 * 新增/修改
	 * 
	 * @param param
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys_restfulapi/save", method = RequestMethod.POST)
	@ResponseBody
	public Result wareHousingInsert(@RequestBody SysRestfulapi srf, HttpServletRequest request) throws Exception {
		System.out.println("========/workflow/sys_restfulapi/save=========" + srf.getRestfulapiId());
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (srf.getRestfulapiId() == null || "".equals(srf.getRestfulapiId())) {
			srf.setRestfulapiId(UUID.randomUUID().toString().replaceAll("-", ""));
			this.restTemplate.exchange(RESTFULAPI_INSERT_DATA, HttpMethod.POST, new HttpEntity<SysRestfulapi>(srf, this.httpHeaders), Integer.class);
		} else {
			srf.setUpdateUser(sysUserInfo.getUserDisp());
			srf.setUpdateDate(sdf.format(d));
			this.restTemplate.exchange(RESTFULAPI_UPDATE_DATA, HttpMethod.POST, new HttpEntity<SysRestfulapi>(srf, this.httpHeaders), Integer.class);
		}
		return new Result(true, "操作成功!");
	}

	/**
	 * 修改页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys_restfulapi/showById")
	public String updateSysRestfulapiPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String restfulapiId = CommonUtil.getParameter(request, "restfulapiId", "");
		request.setAttribute("restfulapiId", restfulapiId);
		ResponseEntity<SysRestfulapi> responseEntity = this.restTemplate.exchange(RESTFULAPI_SHOWBYID_DATA + restfulapiId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysRestfulapi.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SysRestfulapi sysRestfulapi = responseEntity.getBody();
		request.setAttribute("sysRestfulapi", sysRestfulapi);
		String iframeId = CommonUtil.getParameter(request, "iframeId", "");
		request.setAttribute("iframeId", iframeId);
		String backurl = CommonUtil.getParameter(request, "backurl", "");
		request.setAttribute("backurl", backurl);
		sysUserInfo.setUserName(sysRestfulapi.getCreateUser());
		request.setAttribute("userInfo", sysUserInfo);
		System.out.println(">>>>>>>>>>>>>>>>>>>id  " + restfulapiId);
		return "/base/system/sysRestfulapi-add";
	}

	@RequestMapping(value = "/sys_restfulapi/savepage")
	public String iniRestfulapiDefine(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("userInfo", sysUserInfo);
		return "/base/system/sysRestfulapi-add";
	}

	/**
	 * 批量删除 如果通过某一个值进行删除可以用：@PathVariable
	 * 
	 * @param functionProdefId
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value = "/sys_restfulapi/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteSysRestfulapi(@RequestBody SysRestfulapi srf) {
		System.out.println("deleteSysRestfulapi=================-----------" + srf.getRestfulapiId());
		HttpEntity<SysRestfulapi> entity = new HttpEntity<SysRestfulapi>(srf, this.httpHeaders);
		Integer retI = this.restTemplate.exchange(RESTFULAPI_DELETEE_DATA, HttpMethod.DELETE, entity, Integer.class).getBody();
		System.out.println("=================-----------" + retI);
		if (retI != null && retI >= 1) {
			System.out.println("=================操作成功");
			return new Result(true, "操作成功");
		} else {
			System.out.println("=================操作失败");
			return new Result(false, "操作失败");
		}
	}
}
