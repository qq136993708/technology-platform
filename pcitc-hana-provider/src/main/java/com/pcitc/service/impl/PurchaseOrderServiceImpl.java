package com.pcitc.service.impl;

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
    

    @Override
    public List getPurchaseOrderList(HashMap<String, String> map) {
        return purchaseOrderMapper.getPurchaseOrderList(map);
    }
}
