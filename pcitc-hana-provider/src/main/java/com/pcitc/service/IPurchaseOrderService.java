package com.pcitc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;

public interface IPurchaseOrderService {
	
	/**
	 * 获取采购订单的数据
	 */

	List getPurchaseOrderList(HashMap<String, String> map);

	List getPurchaseArrivalList(HashMap<String, String> map);
	
	/**
	 * 根据ERP号获取采购订单的数据
	 */
	public LayuiTableData getHanaErpOrderPage(LayuiTableParam param)throws Exception;
	public List<SrePurchaseOrder> getHanaErpOrderList(Map map)throws Exception;
}
