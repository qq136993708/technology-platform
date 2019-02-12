package com.pcitc.service.flow;

import com.pcitc.base.stp.flow.FlowProjectInfo;

/**
 * 全流程总表
 * 
 * @author zhf
 *
 */
public interface FlowProjectInfoService {
	
	/**
	 * 批量插入全流程信息
	 * @param flowProjectInfo
	 * @return
	 * @throws Exception
	 */
	public Integer batchInsertFlowProjectInfo(FlowProjectInfo flowProjectInfo) throws Exception;
}
