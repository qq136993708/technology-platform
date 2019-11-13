package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchasePlan;
import com.pcitc.base.stp.equipment.SrePurchasePlanExample;

public interface PurchasePlanService {
	

	public SrePurchasePlan selectPurchasePlan(String id) throws Exception;

	public Integer updatePurchasePlan(SrePurchasePlan record)throws Exception;

	public int deletePurchasePlan(String id)throws Exception;
	
	public int batchDeletePurchasePlan(List<String> list)throws Exception;
	
	public List<SrePurchasePlan> getPurchasePlanListByIds(List<String> list)throws Exception;

	public Integer insertPurchasePlan(SrePurchasePlan record)throws Exception;
	public List<SrePurchasePlan> getPurchasePlanList(SrePurchasePlanExample example)throws Exception;
	
	public LayuiTableData getPurchasePlanPage(LayuiTableParam param)throws Exception;

}
