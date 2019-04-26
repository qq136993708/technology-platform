package com.pcitc.service.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SrePurchase;


public interface PurchaseService {
	
	public LayuiTableData getPurchasePage(LayuiTableParam paramsJson)throws Exception;

	public List<SrePurchase> getPurchaseNameIdList()throws Exception;


	SrePurchase selectSrePurchaseById(String id)throws Exception;

	void insertPurchase(SrePurchase srePurchase)throws Exception;

	int deletePurchase(String id)throws Exception;

	Integer updateSrePurchase(SrePurchase srePurchase)throws Exception;

    SreProject selectProjectBasic(String id)throws Exception;

	Result dealPurchaseFlow(String id, Map map)throws Exception;
}
