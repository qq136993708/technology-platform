package com.pcitc.service.outApi;

import com.pcitc.base.stp.out.OutProjectContract;

/**
 * 项目合同表
 * 对外提供接收项目合同的接口
 * @author zhf
 *
 */
public interface OutProjectContractService {
	
	/**
	 * 批量插入项目合同
	 */
	public Integer saveOutProjectContract(OutProjectContract outProjectContract);
}
