package com.pcitc.service.equipment;


import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreEquipmentLedger;

import java.util.List;
import java.util.Map;

public interface EquipmentLedgerService {

    void insertEquipmentLedger(List<SreEquipmentLedger> sreEquipmentLedgerList);
    public LayuiTableData getEquipmentLedgerPage(LayuiTableParam param)throws Exception;

    void deleteByMonth(Map map);
}
