package com.pcitc.web.equipment;

import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import com.pcitc.service.equipment.EquipmentLedgerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "PurchaseOrder-API",tags = {"装备台账订单相关的接口"})
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentLedgerClient
{

	private final static Logger logger = LoggerFactory.getLogger(EquipmentLedgerClient.class);
    @Autowired
    private EquipmentLedgerService equipmentLedgerService;

    @ApiOperation(value = "将装备台账数据存到本地", notes = "将装备台账数据存到本地")
    @RequestMapping(value = "/sre-provider/equipmentLedger/insertEquipmentLedger")
    public void insertEquipmentLedger(@RequestBody List<SreEquipmentLedger> sreEquipmentLedgerList) throws Exception{
        logger.info("====================add sreEquipmentLedger....========================");
        /*purchaseOrderService.deletePurchaseOrder();*/

        equipmentLedgerService.insertEquipmentLedger(sreEquipmentLedgerList);
    }
}