package com.pcitc.service.out;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;

public interface OutCompanyAreaService {

	/**
	 * 分页显示项目
	 * @param param
	 * @return
	 */
	public LayuiTableData getCompanyListPage(LayuiTableParam param);

}
