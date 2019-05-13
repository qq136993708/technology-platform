package com.pcitc.web.equipment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.*;
import com.pcitc.base.workflow.Constants;
import com.pcitc.mapper.equipment.SreEquipmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.equipment.PurchaseService;
import com.pcitc.service.feign.SystemRemoteClient;
import com.pcitc.service.msg.MailSentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "Purchase-API",tags = {"采购相关的接口"})
@RestController
public class PurchaseProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(PurchaseProviderClient.class);
	@Autowired
	private PurchaseService purchaseService;
    @Autowired
    private SreEquipmentMapper sreEquipmentMapper;
	@Autowired
	private MailSentService mailSentService;
	
	@ApiOperation(value = "采购分页", notes = "采购分页")
	@RequestMapping(value = "/sre-provider/purchase/page", method = RequestMethod.POST)
	public LayuiTableData getSrePurchaseList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		logger.info("=== SrePurchase paramsJson============"+paramsJson);
		return purchaseService.getPurchasePage(paramsJson);
	}
	
	@ApiOperation(value = "采购名称,ID", notes = "采购名称,ID")
	@RequestMapping(value = "/sre-provider/getUnitNameList", method = RequestMethod.GET)
	public List<SrePurchase> getPurchaseNameIdList()throws Exception
	{
		return purchaseService.getPurchaseNameIdList();
	}

	@ApiOperation(value = "获取采购申请单信息", notes = "根据ID获取采购申请单信息")
	@RequestMapping(value = "/sre-provider/purchase/get/{id}", method = RequestMethod.GET)
	public SrePurchase selectSrePurchaseById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SrePurchase id "+id+"===========");
		return purchaseService.selectSrePurchaseById(id);
	}
    @ApiOperation(value = "增加采购申请单", notes = "增加采购申请单")
    @RequestMapping(value = "/sre-provider/purchase/add", method = RequestMethod.POST)
    public void insertSrePurchase(@RequestBody SrePurchase srePurchase) throws Exception{
        logger.info("====================add srePurchase....========================");

         purchaseService.insertPurchase(srePurchase);
    }
    @ApiOperation(value = "修改采购申请单", notes = "修改采购申请单")
    @RequestMapping(value = "/sre-provider/purchase/update", method = RequestMethod.POST)
    public Integer updateSrePurchase(@RequestBody SrePurchase srePurchase) throws Exception{
        logger.info("==================update SrePurchase===========================");

        return purchaseService.updateSrePurchase(srePurchase);
    }
    @ApiOperation(value = "删除采购单",notes = "根据ID删除采购单")
	@RequestMapping(value = "/sre-provider/purchase/delete/{id}",method = RequestMethod.GET)
	public int  deletePurchase(@PathVariable("id") String id) throws  Exception{
		logger.info("=============================delete Purchase=================");
		return purchaseService.deletePurchase(id);
	}
    @ApiOperation(value = "获取项目统计", notes = "根据ID获取项目统计")
    @RequestMapping(value = "/sre-provider/purchase/getSreProject/{id}", method = RequestMethod.GET)
    public SreProject selectSreProjectById(@PathVariable(value = "id", required = true) String id) throws Exception {
        logger.info("===============================get SreProject id "+id+"===========");
        return purchaseService.selectProjectBasic(id);
    }
	@ApiOperation(value="采购申请确认流程",notes="采购申请确认流程")
	@RequestMapping(value = "/stp-provider/purchase/start_purchase_activity/{id}", method = RequestMethod.POST)
	public Result start_purchase_activity(@PathVariable("id") String id, @RequestBody Map map)throws Exception
	{
		return purchaseService.dealPurchaseFlow(id,map);
	}

    /**
     * @param id
     * @return
     * @throws Exception
     * 采购管理--审批流程都同意后业务
     */
	@RequestMapping(value = "/sre-provider/purchase/agree_purchase/{id}", method = RequestMethod.POST)
	public Integer purchaseAgreeSrePurchase(@PathVariable(value = "id", required = true) String id)throws Exception {

		SrePurchase srePurchase = purchaseService.selectSrePurchaseById(id);
        String equipmentIds = srePurchase.getEquipmentId();
        String[] arr = equipmentIds.split(",");
        for (int i = 0; i < arr.length; i++) {
            SreEquipment sreEquipment = sreEquipmentMapper.selectByPrimaryKey(arr[i]);
            sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_PASS);
            sreEquipmentMapper.updateByPrimaryKeySelective(sreEquipment);
        }
        srePurchase.setStage(Constant.PURCHASE_CONTRACT_DOCKING);
        srePurchase.setState(Constant.PURCHASE_STATUS_PASS);
		int count=purchaseService.updateSrePurchase(srePurchase);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}

    /**
     * @param id
     * @return
     * @throws Exception
     * 采购管理--驳回后业务
     */
    @RequestMapping(value = "/sre-provider/purchase/reject_purchase/{id}", method = RequestMethod.POST)
    public Integer purchaseRejectSrePurchase(@PathVariable(value = "id", required = true) String id)throws Exception {

        SrePurchase srePurchase = purchaseService.selectSrePurchaseById(id);
        String equipmentIds = srePurchase.getEquipmentId();
        String[] arr = equipmentIds.split(",");
        for (int i = 0; i < arr.length; i++) {
            SreEquipment sreEquipment = sreEquipmentMapper.selectByPrimaryKey(arr[i]);
            sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_DRAFT);
            sreEquipmentMapper.updateByPrimaryKeySelective(sreEquipment);
        }
        srePurchase.setState(Constant.PURCHASE_STATUS_REJECT);
        int count=purchaseService.updateSrePurchase(srePurchase);
        System.out.println("======业务系统处理--驳回 --后业务======="+id);
        return count;
    }
}
