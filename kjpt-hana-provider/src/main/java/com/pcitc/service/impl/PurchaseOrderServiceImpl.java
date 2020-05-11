package com.pcitc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.stp.equipment.SrePurchaseArrival;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.mapper.equipment.ErpOrderMapper;
import com.pcitc.mapper.out.PurchaseArrivalMapper;
import com.pcitc.mapper.out.PurchaseOrderMapper;
import com.pcitc.service.IPurchaseOrderService;

@Service("purchaseOrderService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private PurchaseArrivalMapper purchaseArrivalMapper;
    
    @Autowired
    private ErpOrderMapper erpOrderMapper;
    

    @Override
    public List getPurchaseOrderList(HashMap<String, String> map) {
        return purchaseOrderMapper.getPurchaseOrderList(map);
    }

    @Override
    public List<SrePurchaseArrival> getPurchaseArrivalList(HashMap<String, String> map) {
        return purchaseArrivalMapper.getPurchaseArrivalList(map);
    }
    
    
    
    
    /**
	 * 根据ERP号获取采购订单的数据
	 */
    public LayuiTableData getHanaErpOrderPage(LayuiTableParam param)throws Exception
    {
  	        //每页显示条数
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String g0PROJCODE=(String)param.getParam().get("code");
	  		
	  		
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("g0PROJCODE", g0PROJCODE);
	  		
	  		
	  		
	  		List<SrePurchaseOrder> list = erpOrderMapper.getErpOrderListByG0PROJCODE(map);
	  		//Integer totalRecords = erpOrderMapper.getErpOrderCountByG0PROJCODE(map);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(1000);
			
	  	    return data;
    }
    
    
    
    public List<SrePurchaseOrder> getHanaErpOrderList(Map map)throws Exception
    {
	  		List<SrePurchaseOrder> list = erpOrderMapper.getErpOrderListByG0PROJCODE(map);
	  	    return list;
    }
    
    
    
}
