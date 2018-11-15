package com.pcitc.web.specialist;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.specialist.SpeBaseinfoMaintain;
import com.pcitc.service.specialist.SpeBaseinfoMaintainService;
@Api(value = "Baseinfo-API", description = "专家库基础信息维护相关的接口api")
@RestController
public class BaseinfoProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(BaseinfoProviderClient.class); 
	@Autowired
    private SpeBaseinfoMaintainService speBaseinfoMaintainService; 
	
	/**
	 * 查询基础信息维护
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "获取全部基础信息维护列表", notes = "列表信息")
	@RequestMapping(value = "/spe-provider/baseinfomaintain/page", method = RequestMethod.POST)
	public String getSpeBaseinfoMaintainList(@RequestBody SpeBaseinfoMaintain searchVO)throws Exception
	{
		JSONObject tem = null;
		try {
			tem = speBaseinfoMaintainService.queryBaseinfoMaintainListByPage(searchVO);
		} catch (Exception e) {
			logger.error("[基础信息维护-查询基础信息维护列表失败：]", e);
		}
		return tem.toString();
	}
	
	/**
	 * 新增或修改基础信息维护
	 * @param SpeBaseinfoMaintain
	 * @return
	 */
	@ApiOperation(value = "添加基础信息维护", notes = "添加基础信息维护")
	@RequestMapping(value = "/spe-provider/baseinfoMaintain/add", method = RequestMethod.POST)
	public SpeBaseinfoMaintain saveQlfcComApply(@RequestBody SpeBaseinfoMaintain obj) {
		try {
			obj = speBaseinfoMaintainService.updateOrInsertBaseinfoMaintain(obj);
		} catch (Exception e) {
			logger.error("[基础信息维护-保存基础信息维护失败：]", e);
		}
		return obj;
	}
	
	/**
	 * 删除基础信息维护
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除基础信息维护", notes = "根据主键ID删除基础信息维护")
	@RequestMapping(value = "/spe-provider/baseinfoMaintain/delete/{id}", method = RequestMethod.POST)
	public int deleteSpeBaseinfoMaintain(@PathVariable(value = "id", required = true) String id) {
		int result = 500;
		try {
			result = speBaseinfoMaintainService.deleteBaseinfoMaintain(id);
		} catch (Exception e) {
			logger.error("[基础信息维护-删除基础信息维护失败：]", e);
		}
		return result;
	}
	
	/**
	 * 查询基础信息维护详情
	 * @param obj
	 * @return
	 */
	@ApiOperation(value = "查询基础信息维护", notes = "根据主键ID查询基础信息维护")
	@RequestMapping(value = "/spe-provider/baseinfoMaintain/getById/{id}", method = RequestMethod.POST)
	public SpeBaseinfoMaintain getBaseinfoMaintain(@PathVariable(value = "id", required = true) String id) {
		SpeBaseinfoMaintain baseinfoMaintain = null;
		try {
			baseinfoMaintain = speBaseinfoMaintainService.getBaseinfoMaintainById(id);
		} catch (Exception e) {
			logger.error("[基础信息维护-初始基础信息维护失败：]", e);
		}
		return baseinfoMaintain;
	}
	
	/**
	 * 审批通过
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "审批通过", notes = "根据主键ID审批基础信息维护，审批通过更改状态")
	@RequestMapping(value = "/spe-provider/baseinfoMaintain/agree/{id}", method = RequestMethod.POST)
	public int agreeBaseinfoMaintain(@PathVariable(value = "id", required = true) String id) {
		SpeBaseinfoMaintain baseinfoMaintain = new SpeBaseinfoMaintain();
		baseinfoMaintain.setBaseId(id);
		baseinfoMaintain.setAuditStatus("1");//审批状态，0未审批、1审批通过、2审批中、3未通过
		try {
			baseinfoMaintain = speBaseinfoMaintainService.updateOrInsertBaseinfoMaintain(baseinfoMaintain);
		} catch (Exception e) {
			logger.error("[基础信息维护-审批基础信息维护通过：]", e);
		}
		return 1;
	}
	
	/**
	 * 审批拒绝
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "审批拒绝", notes = "根据主键ID审批基础信息维护，审批拒绝更改状态")
	@RequestMapping(value = "/spe-provider/baseinfoMaintain/reject/{id}", method = RequestMethod.POST)
	public int rejectBaseinfoMaintain(@PathVariable(value = "id", required = true) String id) {
		SpeBaseinfoMaintain baseinfoMaintain = new SpeBaseinfoMaintain();
		baseinfoMaintain.setBaseId(id);
		baseinfoMaintain.setAuditStatus("3");//审批状态，0未审批、1审批通过、2审批中、3未通过
		try {
			baseinfoMaintain = speBaseinfoMaintainService.updateOrInsertBaseinfoMaintain(baseinfoMaintain);
		} catch (Exception e) {
			logger.error("[基础信息维护-审批基础信息维护拒绝：]", e);
		}
		return 1;
	}
}
