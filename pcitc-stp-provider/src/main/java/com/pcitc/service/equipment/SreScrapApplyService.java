package com.pcitc.service.equipment;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.base.stp.equipment.SreScrapApply;

public interface SreScrapApplyService {
	
	public LayuiTableData getSreScrapApplyPage(LayuiTableParam param)throws Exception;
	
	public int insert(SreScrapApply record)throws Exception;
	
	public SreScrapApply selectByPrimaryKey(String id)throws Exception;
	
	public int updateByPrimaryKeySelective(SreScrapApply record)throws Exception;
	
	public String addAudit(SreProjectAudit sreProjectAudit)throws Exception;
	
	Result dealInnerPurchaseFlow(String id, Map map)throws Exception;
}
