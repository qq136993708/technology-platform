package com.pcitc.web.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysModule;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("sysModule")
public class SysModuleController extends BaseController {

	private static final String MODULE_LIST = "http://pcitc-zuul/system-proxy/sysModule-provider/sysModule_list";

	private static final String SAVE_MODULE = "http://pcitc-zuul/system-proxy/sysModule-provider/saveSysModule";

	private static final String DELETE_MODULE = "http://pcitc-zuul/system-proxy/sysModule-provider/deleteSysModule/";

	private static final String GET_MODULE = "http://pcitc-zuul/system-proxy/sysModule-provider/getSysModule/";

	/**
	 * 跳转到模块列表页
	 */
	@RequestMapping(value = "/sysModule_list")
	public String toList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/base/system/sysModule_list";
	}

	/**
	 * 跳转到模块列表页
	 */
	@RequestMapping(value = "/sysModule_list2")
	public String toList2() {
		return "/base/system/sysModule_list2";
	}

	/**
	 * 跳转到模块详情页
	 */
	@RequestMapping(value = "/sysModule_info")
	public String toInfo(String id, Model model) throws Exception {
		if (StringUtils.isEmpty(id))
			id = "";
		model.addAttribute("id", id);
		return "/base/system/sysModule_info";
	}

	/**
	 * 加载模块列表数据
	 */
	@RequestMapping(value = "/getSysModuleList", method = RequestMethod.POST)
	@ResponseBody
	public Object getSysModuleList(HttpServletRequest request) {
		SysModule vo = new SysModule();
		String page = request.getParameter("page"); // 起始索引
		String limit = request.getParameter("limit"); // 每页显示的行数
		String sysModuleName = request.getParameter("sysModuleName");
		String sysModuleCode = request.getParameter("sysModuleCode");
		vo.setPage(page);
		vo.setLimit(limit);
		if (StringUtils.isNotEmpty(sysModuleName)) {
			vo.setModuleName(sysModuleName);
		}
		if (StringUtils.isNotEmpty(sysModuleCode)) {
			vo.setModuleName(sysModuleCode);
		}
		HttpEntity<SysModule> entity = new HttpEntity<SysModule>(vo, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(MODULE_LIST, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject retJson = com.alibaba.fastjson.JSONObject.parseObject(result);
		if (retJson != null) {
			Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
			List<SysModule> resultList = JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysModule.class);
			com.alibaba.fastjson.JSONObject jsonObj = new com.alibaba.fastjson.JSONObject();
			jsonObj.put("code", "0");
			jsonObj.put("msg", "提示");
			jsonObj.put("count", totalCount);
			jsonObj.put("data", resultList);
			return jsonObj.toString();
		}
		return null;
	}

	/**
	 * 新增或修改模块数据
	 */
	@RequestMapping(value = "/saveSysModule")
	@ResponseBody
	public int saveSysModule(@RequestBody SysModule sysModule) {
		HttpEntity<SysModule> entity = new HttpEntity<SysModule>(sysModule, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_MODULE, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 删除模块数据
	 */
	@RequestMapping(value = "/deleteSysModule")
	@ResponseBody
	public int deleteSysModule(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_MODULE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 根据id获取模块数据
	 */
	@RequestMapping(value = "/getSysModule")
	@ResponseBody
	public Object getSysModule(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<SysModule> responseEntity = this.restTemplate.exchange(GET_MODULE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysModule.class);
		SysModule sysModule = responseEntity.getBody();
		return sysModule;
	}

}
