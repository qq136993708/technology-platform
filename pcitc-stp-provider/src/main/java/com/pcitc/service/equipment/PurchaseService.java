package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchase;


public interface PurchaseService {
	
	public LayuiTableData getPurchasePage(LayuiTableParam param)throws Exception;

	public List<SrePurchase> getPurchaseNameIdList();


	SrePurchase selectSrePurchaseById(String id);

	void insertPurchase(SrePurchase srePurchase);

	int deletePurchase(String id);
}
