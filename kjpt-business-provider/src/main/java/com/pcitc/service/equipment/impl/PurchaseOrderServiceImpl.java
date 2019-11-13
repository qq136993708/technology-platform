package com.pcitc.service.equipment.impl;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.stp.equipment.SrePurchaseArrival;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.mapper.equipment.SrePurchaseArrivalMapper;
import com.pcitc.mapper.equipment.SrePurchaseOrderMapper;
import com.pcitc.service.equipment.PurchaseOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("purchaseOrderService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);
    @Autowired
    private SrePurchaseOrderMapper srePurchaseOrderMapper;
	@Autowired
    private SrePurchaseArrivalMapper srePurchaseArrivalMapper;
	

    @Override
    public void insertPurchaseOrder(SrePurchaseOrder purchaseOrder) {
        srePurchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public int deletePurchaseOrder() {
        return srePurchaseOrderMapper.deleteByExample();
    }

    @Override
    public void insertPurchaseArrival(SrePurchaseArrival srePurchaseArrival) {
        srePurchaseArrivalMapper.insert(srePurchaseArrival);
    }

    @Override
    public int deletePurchaseArrival() {
        return srePurchaseArrivalMapper.deletePurchaseArrival();
    }

    @Override
    public void insertPurchaseArrivalList(List<SrePurchaseArrival> srePurchaseArrivals) {
        srePurchaseArrivalMapper.insertPurchaseArrivalList(srePurchaseArrivals);
    }

    @Override
    public void insertPurchaseOrderList(List<SrePurchaseOrder> srePurchaseOrderList) {
        srePurchaseOrderMapper.insertPurchaseOrderList(srePurchaseOrderList);
    }
    
    
    
    
    
    
    
    /**
	 * 根据ERP号获取采购订单的数据
	 */
    public LayuiTableData getErpOrderPageByErpNo(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String g0PROJCODE=(String)param.getParam().get("code");
	  		
	  		
	  		List<SrePurchaseOrder> list = srePurchaseOrderMapper.getErpOrderListByG0PROJCODE(g0PROJCODE);
	  		//Integer totalRecords = erpOrderMapper.getErpOrderCountByG0PROJCODE(map);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(1000);
			
	  	    return data;
    }
    
}
