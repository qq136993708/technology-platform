package com.pcitc.service;

import java.util.HashMap;
import java.util.List;

public interface IPurchaseOrderService {
	
	/**
	 * 获取采购订单的数据
	 */

	List getPurchaseOrderList(HashMap<String, String> map);
}
