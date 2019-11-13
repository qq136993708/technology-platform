package com.pcitc.service.equipment;

import java.util.List;
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

	public int deleteByApplyId(String id);

	//2019/7/8修改报废添加功能
	public Integer insertSreScrapApply(SreScrapApply srescrapply);
	
	//详情列表
	public LayuiTableData scrApplyByPrimaryKey(LayuiTableParam param);
	//导出数据查询
	public List<SreScrapApply> selectSreScrapApplyy(String id);
	
	
	
}
