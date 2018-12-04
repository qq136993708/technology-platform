package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.stp.out.OutProjectPlan;

public interface OutProjectPlanService {

	/**
     * 批量插入项目计划数据
     */
    public void insertOutProjectPlanBatch(List<OutProjectPlan> list);
	
	
}
