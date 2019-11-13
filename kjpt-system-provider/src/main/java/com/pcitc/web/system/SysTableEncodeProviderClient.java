package com.pcitc.web.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysTableEncode;
import com.pcitc.service.system.SysTableEncodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "SysTableEncodeProviderClient-API",description = "编码相关的接口")
@RestController
@RequestMapping("/tableEncode-provider")
public class SysTableEncodeProviderClient {
	
	
	@Autowired
	private SysTableEncodeService sysTableEncodeService;
	
	private final static Logger logger = LoggerFactory.getLogger(SysTableEncodeProviderClient.class);
	
	/**
	 * 查看列表
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "查看编码列表分页-key", notes = "传入菜单code、分页信息")
	@RequestMapping(value = "/tableEncode_list",method = RequestMethod.POST)
	public LayuiTableData querySysTableEncodeListByPage(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		try {
			data = sysTableEncodeService.querySysTableEncodeListByPage(param);
		} catch (Exception e) {
			logger.error("[编码管理-查询编码列表失败：]", e);
		}
		return data;
	}
	
	/**
	 * 新增编码
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "新增编码保存", notes = "新增编码线保存")
	@RequestMapping(value = "/saveTableEncode", method = RequestMethod.POST)
	public String saveTableEncode(@RequestBody SysTableEncode sysTableEncode,@RequestHeader HttpHeaders headers){
		int code = 500;
		JSONObject result = new JSONObject();
		try {
			code = sysTableEncodeService.saveTableEncode(sysTableEncode);
		} catch (Exception e) {
			logger.error("[编码管理-保存编码失败：]", e);
		}
		result.put("code", code);
		result.put("msg", "-");
		return result.toString();
	}
	
	/**
	 * 删除编码
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除编码-key", notes = "根据ID删除编码信息")
	@RequestMapping(value = "/deleteTableEncode/{id}", method = RequestMethod.POST)
	public String deleteTableEncode(@PathVariable(value = "id", required = true) String id){
		int code = 500;
		JSONObject result = new JSONObject();
		try {
			code = sysTableEncodeService.deleteTableEncode(id);
		} catch (Exception e) {
			logger.error("[编码管理-删除编码失败：]", e);
		}
		result.put("code", code);
		result.put("msg", "-");
		return result.toString();
	}
	/**
	 * 变更编码状态
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/modifyTableEncode/{id}", method = RequestMethod.POST)
	public String modifyTableEncode(@PathVariable(value = "id", required = true) String id){
		int code = 500;
		JSONObject result = new JSONObject();
		try {
			code = sysTableEncodeService.modifyTableEncode(id);
		} catch (Exception e) {
			logger.error("[编码管理-变更编码失败：]", e);
		}
		result.put("code", code);
		result.put("msg", "-");
		return result.toString();
	}
	
}
