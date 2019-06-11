package com.pcitc.web.controller.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysTableEncode;
import com.pcitc.base.util.CodeUtil;
import com.pcitc.web.common.BaseController;

@Controller
@RequestMapping("/tableEncode")
public class SysTableEncodeController extends BaseController {

	private String basePath;
	// 字典
	private static final String DICTIONARY_LIST = "http://pcitc-zuul/system-proxy/dictionary-provider/dictionary/";
	// 列表查询
	private static final String TABLE_ENCODE_LIST = "http://pcitc-zuul/system-proxy/tableEncode-provider/tableEncode_list";
	// 保存新增
	private static final String SAVE_TABLE_ENCODE = "http://pcitc-zuul/system-proxy/tableEncode-provider/saveTableEncode";
	// 删除编码
	private static final String DELETE_TABLE_ENCODE = "http://pcitc-zuul/system-proxy/tableEncode-provider/deleteTableEncode/";
	// 删除编码
	private static final String MODIFY_TABLE_ENCODE = "http://pcitc-zuul/system-proxy/tableEncode-provider/modifyTableEncode/";

	@RequestMapping(method = RequestMethod.GET, value = "/table_tree")
	private String toOrgTreePage(HttpServletRequest request) {
		basePath = request.getContextPath();
		request.setAttribute("basePath", basePath);
		return "base/system/sysTableEncode_list";
	}

	@RequestMapping(value = "/getTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws IOException {
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(TABLE_ENCODE_LIST, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}

	/**
	 * 新建编码
	 */
	@RequestMapping(value = "/addTableEncode")
	public String addTableEncode(HttpServletRequest request) {
		String functionId = request.getParameter("functionId");
		request.setAttribute("functionId", functionId);
		return "base/system/addTableEncode";
	}

	/**
	 * 保存编码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveTableEncode")
	@ResponseBody
	public int saveTableEncode(HttpServletRequest request) {
		String code = CodeUtil.getCode("XTBM_0001", restTemplate, httpHeaders);
		String param = request.getParameter("param");
		JSONObject jsStr = (JSONObject) JSON.parseObject(param);
		SysTableEncode sysTableEncode = (SysTableEncode) JSONObject.toJavaObject(jsStr, SysTableEncode.class);
		sysTableEncode.setTableEncodeAnnotation(code);
		sysTableEncode.setTableEncodeLevel("0");
		sysTableEncode.setTableEncodeValueType("String");
		sysTableEncode.setTableEncodeProjectName("项目名称");
		sysTableEncode.setTableEncodeShow("0");
		sysTableEncode.setTableEncodeRule("0");
		sysTableEncode.setTableEncodeValid("0");
		sysTableEncode.setTableEncodeRemark("编码描述");
		HttpEntity<SysTableEncode> entity = new HttpEntity<SysTableEncode>(sysTableEncode, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(SAVE_TABLE_ENCODE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		return result.getCode();
	}

	/***
	 * 
	 * 字典获取
	 * 
	 * ***/
	@RequestMapping(value = "/dic/{parentCode}", method = RequestMethod.POST)
	@ResponseBody
	public List<SysDictionary> getByCode(@PathVariable("parentCode") String parentCode, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<SysDictionary> dictionarys = this.restTemplate.exchange(DICTIONARY_LIST + parentCode, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
		return dictionarys;
	}

	/**
	 * 删除编码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteTableEncode")
	@ResponseBody
	public int deleteTableEncode(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(DELETE_TABLE_ENCODE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		return result.getCode();
	}

	/**
	 * 变更状态
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifyTableEncode")
	@ResponseBody
	public int modifyTableEncode(HttpServletRequest request) {
		String id = request.getParameter("id");
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(MODIFY_TABLE_ENCODE + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		return result.getCode();
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

}
