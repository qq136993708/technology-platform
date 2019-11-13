package com.pcitc.service.outApi;

import com.pcitc.base.stp.out.OutProjectFunds;

/**
 * 项目经费表
 * 对外提供接收项目经费的接口
 * @author zhf
 *
 */
public interface OutProjectFundsService {
	
	/**
	 * 批量插入项目经费
	 */
	public Integer saveOutProjectFunds(OutProjectFunds outProjectFunds);
}
