package com.pcitc.service;

import java.util.HashMap;
import java.util.List;

public interface IEquipmentLedgerService {
	
	/**
	 * 获取装备台账的数据
	 */

	List getEquipmentLedgerList(HashMap<String, String> map);
}
