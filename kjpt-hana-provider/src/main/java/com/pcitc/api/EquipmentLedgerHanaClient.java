package com.pcitc.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.service.IEquipmentLedgerService;
import com.pcitc.service.IPurchaseOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Api(value = "OUT-HANA-API",description = "为了前端和其他系统集成-相关接口")
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentLedgerHanaClient {

	@Autowired
	private IPurchaseOrderService purchaseOrderService;
	@Autowired
	private  IEquipmentLedgerService equipmentLedgerService;

	/**
	 * 获取ERP装备台账数据
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/hana/equipment-ledger/list")
	public JSONArray getEquipmentLedgerList(@RequestBody HashMap<String, String> map) {
		System.out.println("=================getEquipmentLedger");
		List resultList = equipmentLedgerService.getEquipmentLedgerList(map);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(resultList));
		return json;
	}

}
	
	
	
	
	
	
	
	
