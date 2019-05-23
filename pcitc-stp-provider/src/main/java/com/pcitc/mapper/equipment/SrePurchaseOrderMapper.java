package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SrePurchaseOrder;

public interface SrePurchaseOrderMapper {
    int insert(SrePurchaseOrder record);

    int insertSelective(SrePurchaseOrder record);

    int deleteByExample();
}