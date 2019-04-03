package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SrePurchase;


public interface PurchaseService {
	
	public LayuiTableData getPurchasePage(LayuiTableParam param)throws Exception;

	public List<SrePurchase> getPurchaseNameIdList();

	
	
	

}
