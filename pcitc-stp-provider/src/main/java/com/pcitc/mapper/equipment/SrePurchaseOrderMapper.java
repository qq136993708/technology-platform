package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.base.stp.equipment.SrePurchaseOrderExample;

public interface SrePurchaseOrderMapper {
    int insert(SrePurchaseOrder record);

    int insertSelective(SrePurchaseOrder record);

    int deleteByExample();
}