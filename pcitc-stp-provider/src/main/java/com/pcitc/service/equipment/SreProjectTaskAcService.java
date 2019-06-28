package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreProjectAssess;
import com.pcitc.base.stp.equipment.SreProjectAudit;

public interface SreProjectTaskAcService {
	public LayuiTableData getlist(LayuiTableParam param)throws Exception;
	public int updateAuditById(SreProjectAudit record)throws Exception;
	public SreProjectAudit selectProjectAuditById(String id)throws Exception;
	public int updateByPrimaryKey(SreProjectAudit record)throws Exception;
	
	public LayuiTableData getlistassess(LayuiTableParam param)throws Exception;
	public int updateAssessById(SreProjectAssess record)throws Exception;
	public SreProjectAssess selectProjectAssessById(String id)throws Exception;
	public int updateAssessByPrimaryKey(SreProjectAssess record)throws Exception;
	public String addAssess(SreProjectAssess sreProjectAssess)throws Exception;

    int delete(String id)throws Exception;

	Integer deleteDetail(String id)throws Exception;
}
