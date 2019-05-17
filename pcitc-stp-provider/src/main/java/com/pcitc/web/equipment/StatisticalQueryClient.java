package com.pcitc.web.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.equipment.PurchaseService;
import com.pcitc.service.equipment.StatisticalQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Purchase-API",tags = {"统计查询相关接口"})
@RestController
public class StatisticalQueryClient {

    private final static Logger logger = LoggerFactory.getLogger(PurchaseProviderClient.class);
    @Autowired
    private StatisticalQueryService statisticalQueryService;

    @ApiOperation(value = "采购分页", notes = "采购分页")
    @RequestMapping(value = "/sre-provider/statisticalQuery/purchaseEquipmentPage", method = RequestMethod.POST)
    public LayuiTableData getPurchaseEquipmenList(@RequestBody LayuiTableParam paramsJson)throws Exception
    {
        logger.info("=== PurchaseEquipmenLis paramsJson============"+paramsJson);
        return statisticalQueryService.getPurchaseEquipmenList(paramsJson);
    }
}
