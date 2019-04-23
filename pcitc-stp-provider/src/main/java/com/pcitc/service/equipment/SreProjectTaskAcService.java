package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreProjectAudit;

public interface SreProjectTaskAcService {
	public LayuiTableData getlist(LayuiTableParam param)throws Exception;
	public int updateAuditById(SreProjectAudit record)throws Exception;
	public SreProjectAudit selectProjectAuditById(String id)throws Exception;
	public int updateByPrimaryKey(SreProjectAudit record)throws Exception;
}
