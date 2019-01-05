package com.pcitc.service.search;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutProjectPlan;

import java.util.HashMap;
import java.util.List;

public interface FullSearchService {

	/**
	 * 科技查询
	 * @param param
	 * @return
	 */
	public LayuiTableData getTableDataScientific(LayuiTableParam param);
	
	
}
