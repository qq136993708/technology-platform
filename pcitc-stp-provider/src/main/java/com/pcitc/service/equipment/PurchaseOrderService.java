package com.pcitc.service.equipment;

import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.base.stp.equipment.SrePurchaseOrderExample;

public interface PurchaseOrderService {
	
	void insertPurchaseOrder(SrePurchaseOrder purchaseOrder);

	int deletePurchaseOrder();
}
