package com.pcitc.web.equipment;

import java.util.List;

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
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SrePurchase;
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
	public LayuiTableData getSrePurchaseList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=purchaseService.getPurchasePage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "采购名称,ID", notes = "采购名称,ID")
	@RequestMapping(value = "/sre-provider/getUnitNameList", method = RequestMethod.GET)
	public List<SrePurchase> getPurchaseNameIdList()throws Exception
	{
		return purchaseService.getPurchaseNameIdList();
	}
	
}
