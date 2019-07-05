package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;

import java.util.List;

public interface SreEquipmentLedgerMapper {
    int insert(SreEquipmentLedger record);

    int insertSelective(SreEquipmentLedger record);

    void insertEquipmentLedgerList(List<SreEquipmentLedger> sreEquipmentLedgerList);
}