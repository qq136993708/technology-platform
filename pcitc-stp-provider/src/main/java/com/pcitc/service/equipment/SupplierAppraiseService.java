package com.pcitc.service.equipment;

import com.pcitc.base.stp.equipment.SreSupplierAppraise;

public interface SupplierAppraiseService {


	void insertSupplierAppraise(SreSupplierAppraise sreSupplierAppraise);

	Integer updateSreSupplierAppraise(SreSupplierAppraise sreSupplierAppraise);

	//根据装备台账ID查询供应商评价信息
	SreSupplierAppraise selectSreSupplierDetailId(String equipmentDetailId);
	//根据供应商ID查询供应商评价信息
	SreSupplierAppraise selectSreSupplierById(String id);
}
