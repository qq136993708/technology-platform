package com.pcitc.service;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;

public interface IProjectCostService {
	
	//科研投资统计表
	public LayuiTableData getKytztjbData(LayuiTableParam param)throws Exception;
	//科技经费统计表
	public LayuiTableData getKjjftjbData(LayuiTableParam param)throws Exception;
	//横向课题全成本统计表
	public LayuiTableData getHxktqcbtjbData(LayuiTableParam param)throws Exception;
	
}
