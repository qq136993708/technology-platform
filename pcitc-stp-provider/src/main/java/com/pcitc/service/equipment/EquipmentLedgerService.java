package com.pcitc.service.equipment;


import com.pcitc.base.stp.equipment.SreEquipmentLedger;

import java.util.List;

public interface EquipmentLedgerService {

    void insertEquipmentLedger(List<SreEquipmentLedger> sreEquipmentLedgerList);
}
