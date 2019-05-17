package com.pcitc.service.outApi;

import com.pcitc.base.stp.out.OutProjectReport;

/**
 * 项目报告表
 * 对外提供接收项目报告的接口
 * @author zhf
 *
 */
public interface OutProjectReportService {
	
	/**
	 * 批量插入项目报告
	 */
	public Integer saveOutProjectReport(OutProjectReport outProjectReport);
}
