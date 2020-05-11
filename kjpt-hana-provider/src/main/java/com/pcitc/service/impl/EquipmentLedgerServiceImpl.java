package com.pcitc.service.impl;

import com.pcitc.mapper.out.EquipmentLedgerMapper;
import com.pcitc.service.IEquipmentLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service("equipmentLedgerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentLedgerServiceImpl implements IEquipmentLedgerService {
	

    @Autowired
    private EquipmentLedgerMapper equipmentLedgerMapper;

    @Override
    public List getEquipmentLedgerList(HashMap<String, String> map) {
        return equipmentLedgerMapper.getEquipmentLedgerList(map);
    }
}
