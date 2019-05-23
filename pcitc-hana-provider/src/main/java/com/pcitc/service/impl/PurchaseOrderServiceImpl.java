package com.pcitc.service.impl;

import com.pcitc.mapper.out.PurchaseArrivalMapper;
import com.pcitc.mapper.out.PurchaseOrderMapper;
import com.pcitc.service.IPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service("purchaseOrderService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private PurchaseArrivalMapper purchaseArrivalMapper;
    

    @Override
    public List getPurchaseOrderList(HashMap<String, String> map) {
        return purchaseOrderMapper.getPurchaseOrderList(map);
    }

    @Override
    public List getPurchaseArrivalList(HashMap<String, String> map) {
        return purchaseArrivalMapper.getPurchaseArrivalList(map);
    }
}
