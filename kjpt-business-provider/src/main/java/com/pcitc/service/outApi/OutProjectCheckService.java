package com.pcitc.service.outApi;

import com.pcitc.base.stp.out.OutProjectCheck;

/**
 * 项目验收表
 * 对外提供接收项目验收的接口
 * @author zhf
 *
 */
public interface OutProjectCheckService {
	
	/**
	 * 批量插入项目验收表
	 */
	public Integer saveOutProjectCheck(OutProjectCheck outProjectCheck);
}
