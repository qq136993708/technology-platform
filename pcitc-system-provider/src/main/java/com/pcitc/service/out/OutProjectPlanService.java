package com.pcitc.service.out;

import java.util.HashMap;
import java.util.List;

import com.pcitc.base.stp.out.OutProjectPlan;

public interface OutProjectPlanService {

	/**
     * 批量插入项目计划数据
     */
    public void insertOutProjectPlanBatch(List<OutProjectPlan> list);
    
    /**
     * 直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组
     */
	public List getPlanCompleteRateByOldNew(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），总的签订率
     */
	public List getPlanTotalCompleteRate(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），各个院的合同签订率
     */
	public List getPlanCompleteRateByInstitute(HashMap<String, String> map);
	
	
}
