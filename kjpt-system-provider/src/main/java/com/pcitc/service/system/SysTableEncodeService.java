package com.pcitc.service.system;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysTableEncode;

public interface SysTableEncodeService {
	/**
	 * 条件查询菜单列表
	 * @param function
	 * @return
	 * @throws Exception
	 */
	int saveTableEncode(SysTableEncode sysTableEncode);

	SysTableEncode findSysTableEncodeById(String id);

	void updateSysTableEncode(SysTableEncode steVO);

	int deleteTableEncode(String id);

	int modifyTableEncode(String id);

	LayuiTableData querySysTableEncodeListByPage(LayuiTableParam param);

	List<SysTableEncode> findTableEncodeList(String str);
	
}
