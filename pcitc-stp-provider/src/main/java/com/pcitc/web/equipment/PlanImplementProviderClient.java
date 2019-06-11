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
import com.pcitc.base.common.PageResult;
import com.pcitc.base.stp.equipment.SreAssetAccount;
import com.pcitc.base.stp.equipment.SreBusinessTalk;
import com.pcitc.base.stp.equipment.SrePurchasePlan;
import com.pcitc.service.equipment.AssetAccountService;
import com.pcitc.service.equipment.BusinessNegotiationService;
import com.pcitc.service.equipment.PurchasePlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(value = "PlanImplement-API",description = "装备台账、采购计划、商务谈判 相关的服务接口")
@RestController
public class PlanImplementProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentProviderClient.class); 
	@Autowired
    private AssetAccountService assetAccountService; 
	@Autowired
    private PurchasePlanService purchasePlanService; 
	@Autowired
    private BusinessNegotiationService businessNegotiationService; 
	
	
	
	
	/**装备台账
	 * @param paramsJson
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "装备台账分页", notes = "装备台账分页")
	@RequestMapping(value = "/sre-provider/asset-account/page", method = RequestMethod.POST)
	public LayuiTableData getAssetAccountPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page SreAssetAccount==========================="+param);
		
		return assetAccountService.getAssetAccountPage(param);
	}
	
	@ApiOperation(value = "增加装备台账", notes = "增加装备台账")
	@RequestMapping(value = "/sre-provider/asset-account/add", method = RequestMethod.POST)
	public String insertSreAssetAccount(@RequestBody SreAssetAccount sreAssetAccount) throws Exception{
		logger.info("====================add SreAssetAccount....========================");
		Integer count= assetAccountService.insertAssetAccount(sreAssetAccount) ;
		return sreAssetAccount.getAccountId();
	}
	
	
	@ApiOperation(value = "修改装备台账", notes = "修改装备台账")
	@RequestMapping(value = "/sre-provider/asset-account/update", method = RequestMethod.POST)
	public Integer updateSreAssetAccount(@RequestBody SreAssetAccount record) throws Exception{
		logger.info("==================update SreAssetAccount===========================");
		return assetAccountService.updateAssetAccount(record);
	}
	
	@ApiOperation(value = "删除装备台账", notes = "删除装备台账")
	@RequestMapping(value = "/sre-provider/asset-account/delete/{id}", method = RequestMethod.POST)
	public int deleteSreAssetAccount(@ApiParam(value="主键id",required=true)@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SreAssetAccount=================");
		return assetAccountService.deleteAssetAccount(id);
	}
	
	
	
	@ApiOperation(value = "获取装备台账", notes = "获取装备台账")
	@RequestMapping(value = "/sre-provider/asset-account/get/{id}", method = RequestMethod.GET)
	public SreAssetAccount selectById(@ApiParam(value="主键id",required=true)@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreAssetAccount id "+id+"===========");
		return assetAccountService.selectAssetAccount(id);
	}
	
	
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量删除装备台账", notes = "批量删除装备台账")
	@RequestMapping(value = "/sre-provider/asset-account/batch-delete", method = RequestMethod.POST)
	public int batchDeleteAssetAccount(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete AssetAccount=================");
		return assetAccountService.batchDeleteAssetAccount(list) ;
	}
	
	
	
	/**=================================================采购计划===============================================*/
	
	
	@ApiOperation(value = "采购计划分页", notes = "采购计划分页")
	@RequestMapping(value = "/sre-provider/purchase-plan/page", method = RequestMethod.POST)
	public LayuiTableData getPurchasePlanPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page SrePurchasePlan==========================="+param);
		return purchasePlanService.getPurchasePlanPage(param);
	}
	
	@ApiOperation(value = "增加采购计划", notes = "增加采购计划")
	@RequestMapping(value = "/sre-provider/purchase-plan/add", method = RequestMethod.POST)
	public String insertSrePurchasePlan(@RequestBody SrePurchasePlan record) throws Exception{
		logger.info("====================add SrePurchasePlan....========================");
		Integer count= purchasePlanService.insertPurchasePlan(record) ;
		return record.getPurchasePlanId();
	}
	
	@ApiOperation(value = "修改采购计划", notes = "修改采购计划")
	@RequestMapping(value = "/sre-provider/purchase-plan/update", method = RequestMethod.POST)
	public Integer updateSrePurchasePlan(@RequestBody SrePurchasePlan srePurchasePlan) throws Exception{
		logger.info("==================update SrePurchasePlan===========================");
		return purchasePlanService.updatePurchasePlan(srePurchasePlan);
	}
	
	@ApiOperation(value = "删除采购计划", notes = "删除采购计划")
	@RequestMapping(value = "/sre-provider/purchase-plan/delete/{id}", method = RequestMethod.POST)
	public int deleteSrePurchasePlan(@ApiParam(value="主键id",required=true)@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SrePurchasePlan=================");
		return purchasePlanService.deletePurchasePlan(id);
	}
	
	@ApiOperation(value = "获取采购计划", notes = "获取采购计划")
	@RequestMapping(value = "/sre-provider/purchase-plan/get/{id}", method = RequestMethod.GET)
	public SrePurchasePlan selectSrePurchasePlanById(@ApiParam(value="主键id",required=true)@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SrePurchasePlan id "+id+"===========");
		return purchasePlanService.selectPurchasePlan(id);
	}
	
	
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量删除采购计划", notes = "批量删除采购计划")
	@RequestMapping(value = "/sre-provider/purchase-plan/batch-delete", method = RequestMethod.POST)
	public int batchDeletePurchasePlan(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete PurchasePlan=================");
		return purchasePlanService.batchDeletePurchasePlan(list);
	}
	
	
	
	/**=================================================商务谈判==============================================*/
	
	
	@ApiOperation(value = "商务谈判分页", notes = "商务谈判分页")
	@RequestMapping(value = "/sre-provider/business-talk/page", method = RequestMethod.POST)
	public LayuiTableData getBusinessTalkPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page SreBusinessTalk==========================="+param);
		return businessNegotiationService.getBusinessTalkPage(param);
	}
	
	@ApiOperation(value = "增加商务谈判", notes = "增加商务谈判")
	@RequestMapping(value = "/sre-provider/business-talk/add", method = RequestMethod.POST)
	public String insertSreBusinessTalk(@RequestBody SreBusinessTalk record) throws Exception{
		logger.info("====================add SreBusinessTalk....========================");
		Integer count= businessNegotiationService.insertBusinessTalk(record);
		return record.getTalkId();
	}
	
	@ApiOperation(value = "修改商务谈判", notes = "修改商务谈判")
	@RequestMapping(value = "/sre-provider/business-talk/update", method = RequestMethod.POST)
	public Integer updateSreBusinessTalk(@RequestBody SreBusinessTalk record) throws Exception{
		logger.info("==================update SreBusinessTalk===========================");
		return businessNegotiationService.updateBusinessTalk(record) ;
	}
	
	@ApiOperation(value = "删除商务谈判", notes = "删除商务谈判")
	@RequestMapping(value = "/sre-provider/business-talk/delete/{id}", method = RequestMethod.POST)
	public int deleteSreBusinessTalk(@ApiParam(value="主键id",required=true)@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SreBusinessTalk=================");
		return businessNegotiationService.deleteBusinessTalk(id);
	}
	
	@ApiOperation(value = "获取商务谈判", notes = "根据ID获取商务谈判")
	@RequestMapping(value = "/sre-provider/business-talk/get/{id}", method = RequestMethod.GET)
	public SreBusinessTalk selectSreBusinessTalkById(@ApiParam(value="主键id",required=true)@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreBusinessTalk id "+id+"===========");
		return businessNegotiationService.selectBusinessTalk(id);
	}
	
	
	
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量删除商务谈判", notes = "根据IDS批量删除商务谈判")
	@RequestMapping(value = "/sre-provider/business-talk/batch-delete", method = RequestMethod.POST)
	public int batchDeleteBusinessTalk(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete PurchasePlan=================");
		return businessNegotiationService.batchDeleteBusinessTalk(list);
	}
	
	
	
	

}
