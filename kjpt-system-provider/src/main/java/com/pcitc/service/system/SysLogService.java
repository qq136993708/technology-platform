package com.pcitc.service.system;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysLog;


/**
 * @author zhf
 *
 *         日志服务接口
 *
 */
public interface SysLogService {

	/**
	 * @param log
	 * @return 插入日志
	 */
	public Integer insertLog(SysLog log) throws Exception;

	/**
	 * 条件查询系统日志列表
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */

	JSONObject selectSysLogList(SysLog obj) throws Exception;

	/**
	 * 根据id删除系统日志
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteSysLog(String id) throws Exception;
	
	/**
	 * 批量新增日志
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	int insertBatch(List<SysLog> list) throws Exception;
}
