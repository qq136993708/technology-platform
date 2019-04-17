package com.pcitc.web.equipment;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.pcitc.base.common.Constant;
import com.pcitc.base.stp.equipment.*;
import com.pcitc.base.workflow.Constants;
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
	
   private final static String WORKFLOW_DEFINE_ID = "intl_notice:3:1117555";
	
	@Autowired
	private MailSentService mailSentService;
	
	@Autowired
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value = "采购分页", notes = "采购分页")
	@RequestMapping(value = "/sre-provider/purchase/page", method = RequestMethod.POST)
	public LayuiTableData getSrePurchaseList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		logger.info("=== SreTechMeeting paramsJson============"+paramsJson);
		return purchaseService.getPurchasePage(paramsJson);
	}
	
	@ApiOperation(value = "采购名称,ID", notes = "采购名称,ID")
	@RequestMapping(value = "/sre-provider/getUnitNameList", method = RequestMethod.GET)
	public List<SrePurchase> getPurchaseNameIdList()throws Exception
	{
		return purchaseService.getPurchaseNameIdList();
	}

	@ApiOperation(value = "获取项目统计", notes = "根据ID获取项目统计")
	@RequestMapping(value = "/sre-provider/purchase/get/{id}", method = RequestMethod.GET)
	public SrePurchase selectSrePurchaseById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SrePurchase id "+id+"===========");
		return purchaseService.selectSrePurchaseById(id);
	}
    @ApiOperation(value = "增加采购申请单", notes = "增加采购申请单")
    @RequestMapping(value = "/sre-provider/purchase/add", method = RequestMethod.POST)
    public void insertSrePurchase(@RequestBody SrePurchase srePurchase) throws Exception{
        logger.info("====================add srePurchase....========================");
        /*Integer count= purchaseService.insertPurchase(srePurchase);
        return srePurchase.getEquipmentId();*/
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
	/**
	 * @param id
	 * @return
	 * 业务系统处理审批流程都同意后业务
	 */
	/*@RequestMapping(value = "/sre-provider/purchase/success/{id}", method = RequestMethod.POST)
	public Integer taskAgreeSreProject(@PathVariable(value = "id", required = true) String id)throws Exception {

		SrePurchase srePurchase = purchaseService.selectSrePurchaseById(id);
		srePurchase.setState(Constant.PURCHASE_STATUS_SUBMIT);
		int count=purchaseService.updateSrePurchase(srePurchase);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}*/
}
