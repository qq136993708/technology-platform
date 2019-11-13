package com.pcitc.service.outApi;

import com.pcitc.base.stp.out.OutProjectRequire;

/**
 * 项目需求表
 * 对外提供接收项目需求的接口
 * @author zhf
 *
 */
public interface OutProjectRequireService {
	
	/**
	 * 批量插入项目需求表
	 */
	public Integer saveOutProjectRequire(OutProjectRequire outProjectRequire);
}
