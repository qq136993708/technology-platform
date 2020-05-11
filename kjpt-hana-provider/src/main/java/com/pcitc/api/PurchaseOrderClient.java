package com.pcitc.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchaseArrival;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.service.IPurchaseOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "OUT-HANA-API",description = "为了前端和其他系统集成-相关接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchaseOrderClient {

	@Autowired
	private IPurchaseOrderService  purchaseOrderService;


	/**
	 * 获取ERP采购订单数据
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/hana/purchase-order/list")
	public JSONArray getPurchaseOrderList(@RequestBody HashMap<String, String> map) {
		System.out.println("=================getPrchaseOrder");
		List resultList = purchaseOrderService.getPurchaseOrderList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(resultList));
		return json;
	}
	/**
	 * 获取ERP采购订单数据
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/hana/purchase-arrival/list")
	public JSONArray getPurchaseArrivalList(@RequestBody HashMap<String, String> map) {
		System.out.println("=================getPrchaseOrder");
		List<SrePurchaseArrival> resultList = purchaseOrderService.getPurchaseArrivalList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(resultList));
		return json;
	}
	
	
	
	
	@ApiOperation(value = "获取ERP采购订单数据", notes = "获取ERP采购订单数据")
	@RequestMapping(value = "/hana/getErpOrderlist_data", method = RequestMethod.POST)
	public LayuiTableData getErpOrderlist_data(@RequestBody LayuiTableParam param)throws Exception
	{
		return purchaseOrderService.getHanaErpOrderPage(param);
	}
	
	@ApiOperation(value = "获取ERP采购订单数据", notes = "获取ERP采购订单数据")
	@RequestMapping(value = "/hana/getErpOrderlist", method = RequestMethod.POST)
	public JSONArray getErpOrderlist(@RequestBody Map map)throws Exception{
		List<SrePurchaseOrder> listSreEquipment= purchaseOrderService.getHanaErpOrderList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(listSreEquipment));
		return json;
	}
	
	
	
}
	
	
	
	
	
	
	
	
