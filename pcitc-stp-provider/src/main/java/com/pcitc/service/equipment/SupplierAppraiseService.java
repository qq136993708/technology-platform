package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreSupplierAppraise;

public interface SupplierAppraiseService {


	void insertSupplierAppraise(SreSupplierAppraise sreSupplierAppraise)throws Exception;

	Integer updateSreSupplierAppraise(SreSupplierAppraise sreSupplierAppraise)throws Exception;

	//根据装备台账ID查询供应商评价信息
	SreSupplierAppraise selectSreSupplierDetailId(String equipmentDetailId)throws Exception;
	//根据供应商ID查询供应商评价信息
	SreSupplierAppraise selectSreSupplierById(String id)throws Exception;

	LayuiTableData getSreSupplierAppraisePage(LayuiTableParam paramsJson)throws Exception;
}
