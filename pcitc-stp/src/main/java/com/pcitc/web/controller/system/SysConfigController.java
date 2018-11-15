/**
 * 
 * SysConfigController.java
 * Nishikino
 * 2018年8月20日
 * 
 */
package com.pcitc.web.controller.system;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysConfig;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;

/**
 * @description : TODO
 * @author : Nishikino
 * @date : 2018年8月20日 下午3:35:34
 */
@Controller
public class SysConfigController extends BaseController {

	@Autowired
	private HttpHeaders httpHeaders;

	@Autowired
	private RestTemplate restTemplate;

	// 系统配置列表
	private static final String SYS_CONFIG_URL = "http://pcitc-zuul/system-proxy/sysconfig-provider/sys_config/list";

	// 新增配置
	private static final String SYS_CONFIG_ADD_URL = "http://pcitc-zuul/system-proxy/sysconfig-provider/sys_config/add";

	// 根据id获取配置
	private static final String GET_SYS_CONFIG = "http://pcitc-zuul/system-proxy/sysconfig-provider/sys_config/getsysconfig/";

	// 保存修改
	private static final String SAVE_SYS_CONFIG = "http://pcitc-zuul/system-proxy/sysconfig-provider/sys_config/saveSysConfig";

	// 删除数据
	private static final String DELETE_SYS_CONFIG = "http://pcitc-zuul/system-proxy/sysconfig-provider/sys_config/deleteSysConfig";

	/**
	 * @author Nishikino 初始化查询页面
	 */
	@RequestMapping(value = "/sysConfig/page")
	public String sysConfigList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/base/system/sysConfig_list";
	}

	/**
	 * @author Nishikino 查询所有生效配置
	 */
	@RequestMapping(value = "/sys_config/list", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public Object getSysConfigListForTable(@ModelAttribute("param") LayuiTableParam param) {
		System.out.println("====--------/sys_config/list");
		// 获取当前登录人信息
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		param.getParam().put("configCode", userInfo.getUserId());
		param.getParam().put("status", "1");

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SYS_CONFIG_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}

	/**
	 * @author Nishikino 跳转到新增页面
	 */
	@RequestMapping(value = "/sysconfig/add")
	public String sysconfigInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("=====sysConfigAdd");

		SysUser userInfo = JwtTokenUtil.getUserFromToken(httpHeaders);
		System.out.println("=====sysConfigAdd-----" + userInfo.getUserDisp());
		request.setAttribute("userInfo", userInfo);

		return "/base/system/sysConfig_add";
	}

	/**
	 * @author Nishikino 新增配置
	 */
	@RequestMapping(value = "/sysConfig/add", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(modelName = "系统配置", actionName = "新增配置")
	public Result sysConfigInsert(@RequestBody SysConfig sysconfig, HttpServletRequest request) throws Exception {
		SysUser userInfo = JwtTokenUtil.getUserFromToken(httpHeaders);
		sysconfig.setConfigId(UUID.randomUUID().toString().replaceAll("-", ""));
		sysconfig.setStatus("1");
		sysconfig.setCreateUserId(userInfo.getUserId());
		sysconfig.setCreateUser(userInfo.getUserDisp());
		Integer retI = this.restTemplate.exchange(SYS_CONFIG_ADD_URL, HttpMethod.POST, new HttpEntity<SysConfig>(sysconfig, this.httpHeaders), Integer.class).getBody();
		if (retI == 0) {
			return new Result(false, "操作失败!");
		} else {
			return new Result(true, "操作成功!");
		}
	}

	/**
	 * @author Nishikino 跳转到编辑页面
	 */
	@RequestMapping(value = "/sysconfig/edit")
	public String sysConfigEdit(String configId, Model model) throws Exception {
		System.out.println("=====sysConfigEdit");
		if (StringUtils.isEmpty(configId))
			configId = "";
		model.addAttribute("configId", configId);
		SysUser userInfo = JwtTokenUtil.getUserFromToken(httpHeaders);
		System.out.println("=====sysConfigEdit-----" + userInfo.getUserDisp());
		request.setAttribute("userInfo", userInfo);
		ResponseEntity<SysConfig> responseEntity = this.restTemplate.exchange(GET_SYS_CONFIG + configId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysConfig.class);
		SysConfig sysConfig = responseEntity.getBody();
		request.setAttribute("sysConfig", sysConfig);
		return "/base/system/sysConfig_edit";
	}

	/**
	 * @author Nishikino 根据id获取配置數據
	 */
	@RequestMapping(value = "/sysConfig/getSysConfig")
	@ResponseBody
	public Object getSysConfig(HttpServletRequest request) {
		String configId = request.getParameter("configId");
		ResponseEntity<SysConfig> responseEntity = this.restTemplate.exchange(GET_SYS_CONFIG + configId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), SysConfig.class);
		SysConfig sysConfig = responseEntity.getBody();
		return sysConfig;
	}

	/**
	 * @author Nishikino 修改系统配置
	 */
	@RequestMapping(value = "/sysConfig/edit")
	@ResponseBody
	public Result saveSysConfig(@RequestBody SysConfig sysConfig) {
		HttpEntity<SysConfig> entity = new HttpEntity<SysConfig>(sysConfig, this.httpHeaders);
		sysConfig.setStatus("1");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_SYS_CONFIG, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		if (result == 0) {
			return new Result(false, "操作失败!");
		} else {
			return new Result(true, "操作成功!");
		}
	}

	/**
	 * @author Nishikino 删除系统配置
	 */
	@RequestMapping(value = "/sysConfig/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteSysConfig(@RequestBody SysConfig sysConfig) {
		System.out.println("deleteSysRestfulapi=================-----------" + sysConfig.getConfigId());
		HttpEntity<SysConfig> entity = new HttpEntity<SysConfig>(sysConfig, this.httpHeaders);
		Integer retI = this.restTemplate.exchange(DELETE_SYS_CONFIG, HttpMethod.DELETE, entity, Integer.class).getBody();
		System.out.println("=================-----------" + retI);
		if (retI == 0) {
			return new Result(false, "操作失败!");
		} else {
			return new Result(true, "操作成功!");
		}
	}

	/**
	 * @author Nishikino 初始化系统配置历史查询页面
	 */
	@RequestMapping(value = "/sysConfig/history")
	public String iniDelegateHistoryList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/base/system/sysConfig-historylist";
	}

	/**
	 * @author Nishikino 查询所有配置(生效+删除)
	 */
	@RequestMapping(value = "/sysconfig/history/list", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public Object getSysConfigHistoryList(@ModelAttribute("param") LayuiTableParam param) {
		System.out.println("---------------------------/sysconfig/history/list");
		// 获取当前登录人信息
		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		param.getParam().put("configCode", userInfo.getUserId());

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SYS_CONFIG_URL, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData retJson = responseEntity.getBody();

		return JSON.toJSON(retJson).toString();
	}
}
