package com.pcitc.service.specialist;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.specialist.SpeBaseinfoMaintain;

public interface SpeBaseinfoMaintainService {

	/**
	 * 查询基础信息维护列表
	 * @param tableInfo
	 * @return
	 */
	JSONObject queryBaseinfoMaintainListByPage(SpeBaseinfoMaintain tableInfo);
	
	/**
	 * 新增或修改基础信息维护
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	SpeBaseinfoMaintain updateOrInsertBaseinfoMaintain(SpeBaseinfoMaintain obj) throws Exception;
	
	/**
	 * 删除基础信息维护
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteBaseinfoMaintain(String id) throws Exception;
	
	/**
	 * 查询基础信息维护详情
	 * @param obj
	 * @return
	 */
	SpeBaseinfoMaintain getBaseinfoMaintainById(String id) throws Exception;
}
