package com.pcitc.service.equipment.impl;

import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.base.stp.equipment.SrePurchaseOrderExample;
import com.pcitc.mapper.equipment.SrePurchaseOrderMapper;
import com.pcitc.service.equipment.PurchaseOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("purchaseOrderService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);
    @Autowired
    private SrePurchaseOrderMapper srePurchaseOrderMapper;
	
	

    @Override
    public void insertPurchaseOrder(SrePurchaseOrder purchaseOrder) {
        srePurchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public int deletePurchaseOrder() {
        return srePurchaseOrderMapper.deleteByExample();
    }
}
