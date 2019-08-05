package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreInformationDelivery;
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
	
	//执行修改方法
	Integer setupdataSrePlanImplement(SrePlanImplement srePlanImplement);

	/*-------------------------------信息发布-----------------------*/
	
	//信息发布
	LayuiTableData getInformationDeliveryPage(LayuiTableParam param) throws Exception;
	
	//删除信息发布
	int deleteInformationDelivery(String id);
	
	//获取信息发布数据
	SreInformationDelivery selectInformationDelivery(String id);
	
	//新增信息发布数据
	Integer insertInformationDelivery(SreInformationDelivery sreInformationDelivery);

	//修改信息发布数据
	Integer updataInformationDelivery(SreInformationDelivery sreInformationDelivery);
	
	
	
	
	
}
