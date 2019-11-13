package com.pcitc.service.outApi;

import com.pcitc.base.stp.out.OutProjectResult;

/**
 * 项目检查结果表
 * 对外提供接收项目检查结果的接口
 * @author zhf
 *
 */
public interface OutProjectResultService {
	
	/**
	 * 批量插入项目检查结果
	 */
	public Integer saveOutProjectResult(OutProjectResult outProjectResult);
}
