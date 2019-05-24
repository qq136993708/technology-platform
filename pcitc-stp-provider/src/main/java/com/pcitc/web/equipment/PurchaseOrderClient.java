package com.pcitc.web.equipment;

import com.pcitc.base.stp.equipment.SrePurchaseArrival;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.service.equipment.PurchaseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "PurchaseOrder-API",tags = {"采购订单相关的接口"})
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchaseOrderClient
{

	private final static Logger logger = LoggerFactory.getLogger(PurchaseOrderClient.class);
	@Autowired
	private PurchaseOrderService purchaseOrderService;


    @ApiOperation(value = "将采购订单数据存到本地", notes = "将采购订单数据存到本地")
    @RequestMapping(value = "/sre-provider/purchase/insertPurchaseOrder")
    public void insertPurchaseOrder(@RequestBody List<SrePurchaseOrder> srePurchaseOrderList) throws Exception{
        logger.info("====================add srePurchaseOrder....========================");
        purchaseOrderService.deletePurchaseOrder();

        purchaseOrderService.insertPurchaseOrderList(srePurchaseOrderList);
    }

    @ApiOperation(value = "将采购入库数据存到本地", notes = "将采购入库数据存到本地")
    @RequestMapping(value = "/sre-provider/purchase/insertPurchaseArrival")
    public void insertPurchaseArrival(@RequestBody List<SrePurchaseArrival > srePurchaseArrivals ) throws Exception{
        logger.info("====================add SrePurchaseArrival....========================");
        purchaseOrderService.deletePurchaseArrival();

        purchaseOrderService.insertPurchaseArrivalList(srePurchaseArrivals);
    }
}