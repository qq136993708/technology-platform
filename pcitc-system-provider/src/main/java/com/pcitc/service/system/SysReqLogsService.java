package com.pcitc.service.system;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysReqLogs;

public interface SysReqLogsService
{
	
	public SysReqLogs selectSysReqLogs(Integer dataId);
	
	public Result saveSysReqLogs(SysReqLogs bean) throws Exception;

	public List<SysReqLogs> selectListSysReqLogs();
	
	public List<SysReqLogs> selectListSysReqLogsByBean(SysReqLogs bean);
	
	public LayuiTableData selectTableSysReqLogs(LayuiTableParam param);
}
