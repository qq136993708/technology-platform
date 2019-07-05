package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchaseArrival;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {
	
	void insertPurchaseOrder(SrePurchaseOrder purchaseOrder);

	int deletePurchaseOrder();

	void insertPurchaseArrival(SrePurchaseArrival srePurchaseArrival);

    int deletePurchaseArrival();

    void insertPurchaseArrivalList(List<SrePurchaseArrival> srePurchaseArrivals);

    void insertPurchaseOrderList(List<SrePurchaseOrder> srePurchaseOrderList);
    public LayuiTableData getErpOrderPageByErpNo(LayuiTableParam param)throws Exception;
}
