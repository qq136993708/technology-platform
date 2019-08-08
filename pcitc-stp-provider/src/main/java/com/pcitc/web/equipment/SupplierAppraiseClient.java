package com.pcitc.web.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.SreSupplierAppraise;
import com.pcitc.service.equipment.SupplierAppraiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "supplierAppraise-API",tags = {"供应商评价"})
@RestController
public class SupplierAppraiseClient
{
	
	private final static Logger logger = LoggerFactory.getLogger(SupplierAppraiseClient.class);
	@Autowired
    private SupplierAppraiseService appraiseService;



    @ApiOperation(value = "获取供应商评价信息", notes = "根据装备台账ID查询")
    @RequestMapping(value = "/sre-provider/supplierAppraise/getByDetailId/{equipmentDetailId}", method = RequestMethod.GET)
    public SreSupplierAppraise selectSreSupplierDetailId(@PathVariable(value = "equipmentDetailId", required = true) String equipmentDetailId) throws Exception {
        logger.info("===============================get SreSupplierAppraise id "+equipmentDetailId+"===========");
        return appraiseService.selectSreSupplierDetailId(equipmentDetailId);
    }
    @ApiOperation(value = "保存供应商评价信息", notes = "保存供应商评价信息")
    @RequestMapping(value = "/sre-provider/supplierAppraise/add", method = RequestMethod.POST)
    public void insertsreSupplierAppraise(@RequestBody SreSupplierAppraise sreSupplierAppraise) throws Exception{
        logger.info("====================add sreSupplierAppraise....========================");

        appraiseService.insertSupplierAppraise(sreSupplierAppraise);
    }
    @ApiOperation(value = "修改供应商评价信息", notes = "修改供应商评价信息")
    @RequestMapping(value = "/sre-provider/supplierAppraise/update", method = RequestMethod.POST)
    public Integer updateSreSupplierAppraise(@RequestBody SreSupplierAppraise sreSupplierAppraise) throws Exception{
        logger.info("==================update SrePurchase===========================");

        return appraiseService.updateSreSupplierAppraise(sreSupplierAppraise);
    }
    @ApiOperation(value = "获取供应商评价信息", notes = "根据供应商ID查询")
    @RequestMapping(value = "/sre-provider/supplierAppraise/get/{id}", method = RequestMethod.GET)
    public SreSupplierAppraise selectSreSupplierById(@PathVariable(value = "id", required = true) String id) throws Exception {
        logger.info("===============================get SreSupplierAppraise id "+id+"===========");
        return appraiseService.selectSreSupplierById(id);
    }
    @ApiOperation(value = "供应商评价分页", notes = "供应商评价分页")
    @RequestMapping(value = "/sre-provider/supplierAppraise/page", method = RequestMethod.POST)
    public LayuiTableData getSreSupplierAppraiseList(@RequestBody LayuiTableParam paramsJson)throws Exception
    {
        logger.info("=== SreSupplierApprais paramsJson============"+paramsJson);
        return appraiseService.getSreSupplierAppraisePage(paramsJson);
    }
}
