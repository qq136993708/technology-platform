package com.pcitc.service.equipment;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreEquipmentLedger;

import java.util.List;

public interface EquipmentLedgerService {

    void insertEquipmentLedger(List<SreEquipmentLedger> sreEquipmentLedgerList);
    public LayuiTableData getEquipmentLedgerPage(LayuiTableParam param)throws Exception;
}
