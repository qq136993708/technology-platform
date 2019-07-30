package com.pcitc.service.outApi;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutStandardData;

public interface OutStandardDataService
{
	
	public OutStandardData selectOutStandardData(String dataId);
	
	public Result saveOutStandardData(OutStandardData bean) throws Exception;

	public Result updateOutStandardData(OutStandardData bean) throws Exception;
	
	public Result saveOrUpdOutStandardData(OutStandardData bean) throws Exception;
	
	public Result deleteOutStandardData(String dataId) throws Exception;
	
	public Result deleteOutStandardDataReal(String id) throws Exception;
	
	public List<OutStandardData> selectListOutStandardData();
	
	public List<OutStandardData> selectListOutStandardDataByBean(OutStandardData bean);
	
	public LayuiTableData selectTableOutStandardData(LayuiTableParam param);
	
	public Integer selectOutStandardDataCount();
}
