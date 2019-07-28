package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePlanImplement;

public interface PlanImplementService {

	//获取规划管理信息分页数据
	LayuiTableData getPlanImplementPage(LayuiTableParam param) throws Exception;
	
	//执行新增方法
	Integer setPlanImplement(SrePlanImplement srePlanImplement);
	
	//获取规划发布信息
	SrePlanImplement selectPlanImplement(String id);
	
	//删除规划发布信息
	int deleteSrePlanImplement(String id);
	
	
	
	
	
}
