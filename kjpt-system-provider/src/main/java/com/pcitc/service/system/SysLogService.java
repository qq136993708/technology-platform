package com.pcitc.service.system;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysLog;

/**
 * @author zhf
 *
 *         日志服务接口
 *
 */
public interface SysLogService {

	/**
             * 根据ID获取日志信息详情
    */
	public SysLog selectSysLog(String id) throws Exception;
	
	 /**
	     *修改日志信息
	*/
	public Integer updateSysLog(SysLog record)throws Exception;
	 /**
	     *根据ID删除日志信息
	*/
	public int deleteSysLog(String id)throws Exception;
	
	 /**
	     * 增加日志信息
	 */
	public Integer insertSysLog(SysLog record)throws Exception;
	
	/**
	     * 获取日志（分页）
	*/
	public LayuiTableData getSysLogPage(LayuiTableParam param)throws Exception;
	
	
}
