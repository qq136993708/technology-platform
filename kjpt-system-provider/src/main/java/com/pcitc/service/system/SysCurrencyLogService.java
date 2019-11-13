package com.pcitc.service.system;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysCurrencyLog;

public interface SysCurrencyLogService
{
	
	public SysCurrencyLog selectSysCurrencyLog(String dataId);
	
	public Result saveSysCurrencyLog(SysCurrencyLog bean) throws Exception;

	public List<SysCurrencyLog> selectListSysCurrencyLog();
	
	public List<SysCurrencyLog> selectListSysCurrencyLogByBean(SysCurrencyLog bean);
	
	public LayuiTableData selectTableSysCurrencyLog(LayuiTableParam param);
}
