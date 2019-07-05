package com.pcitc.service.equipment.impl;

import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.mapper.equipment.SreEquipmentLedgerMapper;
import com.pcitc.mapper.equipment.SrePurchaseArrivalMapper;
import com.pcitc.mapper.equipment.SrePurchaseOrderMapper;
import com.pcitc.service.equipment.EquipmentLedgerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("equipmentLedgerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentLedgerServiceImpl implements EquipmentLedgerService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentLedgerServiceImpl.class);
	@Autowired
    private SreEquipmentLedgerMapper sreEquipmentLedgerMapper;

    @Override
    public void insertEquipmentLedger(List<SreEquipmentLedger> sreEquipmentLedgerList) {
        sreEquipmentLedgerMapper.insertEquipmentLedgerList(sreEquipmentLedgerList);
    }
}
