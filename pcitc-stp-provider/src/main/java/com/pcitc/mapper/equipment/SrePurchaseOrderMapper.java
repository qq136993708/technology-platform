package com.pcitc.mapper.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;

import java.util.List;

public interface SrePurchaseOrderMapper {
    int insert(SrePurchaseOrder record);

    int insertSelective(SrePurchaseOrder record);

    int deleteByExample();

    void insertPurchaseOrderList(List<SrePurchaseOrder> srePurchaseOrderList);

	List<SrePurchaseOrder> selectErpnum(String g0projcode);
}