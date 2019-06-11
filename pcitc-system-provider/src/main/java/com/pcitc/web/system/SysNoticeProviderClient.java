package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysNoticeVo;
import com.pcitc.service.system.SysNoticeService;

@Api(value = "SysNotice-API",description = "通知公告相关的接口")
@RestController
public class SysNoticeProviderClient {

	private final static Logger logger = LoggerFactory.getLogger(SysNoticeProviderClient.class);

	@Autowired
	private SysNoticeService sysNoticeService;

	/**
	 * 查询公告列表
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "查询公告列表", notes = "传入json格式的公告实体属性")
	@RequestMapping(value = "/sysNotice-provider/sysNotice_list",method = RequestMethod.POST)
	public String selectSysNoticeByPage(@RequestBody SysNoticeVo vo) {
		JSONObject tem = null;
		try {
			if(StringUtils.isNotEmpty(vo.getUserId())) {
				tem = sysNoticeService.selectSysNoticeList(vo);
			} else {
				tem = sysNoticeService.selectSysNoticeAll(vo);
			}
		} catch (Exception e) {
			logger.error("[系统管理-查询公告列表失败：]", e);
			e.printStackTrace();
		}
		return (tem == null) ? "" : tem.toString();
	}
	
	/**
	 * 新增或修改公告
	 * @param sysNotice
	 * @return
	 */
	@ApiOperation(value = "新增或修改公告", notes = "传入json格式的公告实体属性")
	@RequestMapping(value = "/sysNotice-provider/saveSysNotice", method = RequestMethod.POST)
	public int saveSysNotice(@RequestBody SysNotice sysNotice){
		int result = 500;
		try {
			result = sysNoticeService.updateOrInsertSysNotice(sysNotice);
		} catch (Exception e) {
			logger.error("[公告管理-保存公告失败：]", e);
		}
		return result;
	}
	
	/**
	 * 删除公告
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除公告", notes = "传入公告实体id属性")
	@RequestMapping(value = "/sysNotice-provider/deleteSysNotice/{id}", method = RequestMethod.POST)
	public int deleteDictionary(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = sysNoticeService.deleteSysNotice(id);
		} catch (Exception e) {
			logger.error("[公告管理-删除公告失败：]", e);
		}
		return result;
	}
	
	/**
	 * 初始化公告详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "初始化公告详情", notes = "传入公告实体id属性")
	@RequestMapping(value = "/sysNotice-provider/getSysNotice/{id}", method = RequestMethod.POST)
	public SysNotice getSysNotice(@PathVariable(value = "id", required = true) String id){
		SysNotice sysNotice = null;
		try {
			sysNotice = sysNoticeService.getSysNoticeById(id);
		} catch (Exception e) {
			logger.error("[公告管理-初始化公告失败：]", e);
		}
		return sysNotice;
	}
	
	/**
	 * 查看公告详情
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "查看公告详情", notes = "传入json格式的公告实体属性")
	@RequestMapping(value = "/sysNotice-provider/getSysNoticeView", method = RequestMethod.POST)
	public SysNotice getSysNoticeView(@RequestBody SysNoticeVo vo){
		SysNotice sysNotice = null;
		try {
			sysNotice = sysNoticeService.getSysNoticeView(vo);
		} catch (Exception e) {
			logger.error("[公告管理-查看公告失败：]", e);
		}
		return sysNotice;
	}
	
	/**
	 * 发布公告
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "发布公告", notes = "传入公告实体id属性")
	@RequestMapping(value = "/sysNotice-provider/publishSysNotice/{id}", method = RequestMethod.POST)
	public SysNotice publishSysNotice(@PathVariable(value = "id", required = true) String id){
		SysNotice sysNotice = null;
		try {
			sysNotice = sysNoticeService.publishSysNotice(id);
		} catch (Exception e) {
			logger.error("[公告管理-发布公告失败：]", e);
		}
		return sysNotice;
	}
	
	/**
	 * 查询已发布的公告信息
	 * @param record
	 * @return
	 */
	@ApiOperation(value = "查询已发布的公告信息", notes = "传入json格式的公告实体属性")
	@RequestMapping(value = "/sysNotice-provider/select_notice_main",method = RequestMethod.POST)
	public List<SysNotice> selectNewsMain(@RequestBody SysNotice record){
		try {
			List<SysNotice> sysNotices =sysNoticeService.selectNoticeMain(record);
			return sysNotices;
		} catch (Exception e) {
			logger.error("[公告管理-首页查询公告管理失败：]", e);
		}
		return null;
	}

	/**
	 * 查询未读公告数量
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "查询未读公告数量", notes = "传入json格式的公告实体属性")
	@RequestMapping(value = "/sysNotice-provider/getSysNoticeCount",method = RequestMethod.POST)
	public Long getSysNoticeCount(@RequestBody SysNoticeVo vo){
		return sysNoticeService.getSysNoticeCount(vo);
	}

}
