package com.pcitc.web.equipment;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.mapper.equipment.SreForApplicationMapper;
import com.pcitc.service.equipment.DetailService;
import com.pcitc.service.equipment.ForApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "ForApplication-API",tags = {"转资申请、装备台账相关的接口"})
@RestController
public class ForApplicationProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(ForApplicationProviderClient.class); 
	@Autowired
    private ForApplicationService forapplicationService; 
	
	@Autowired
    private DetailService detailService; 
	
	@Autowired
	private SreForApplicationMapper sreforapplicationMapper;
	
    private final static String WORKFLOW_DEFINE_ID = "intl_notice:3:1117555";
	
	
	
	@ApiOperation(value = "转资申请分页", notes = "转资申请分页")
	@RequestMapping(value = "/sre-provider/forapplication/page", method = RequestMethod.POST)
	public LayuiTableData getForApplicationList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=forapplicationService.getForApplicationPage(param);
		return rageResult;
	}
	
	@RequestMapping(value = "/sre-provider/forapplication/delete/{id}", method = RequestMethod.POST)
	public int deleteSreForapplication(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete sreForapplication=================");
		Integer count =  detailService.deleteDetail(id);
		return forapplicationService.deleteForapplication(id);
	}
	
	@ApiOperation(value = "增加转资申请", notes = "增加转资申请")
	@RequestMapping(value = "/sre-provider/forapplication/add", method = RequestMethod.POST)
	public String insertSreForApplication(@RequestBody SreForApplication sreForApplication) throws Exception{
		logger.info("====================add forapplication....========================");
		Integer count= forapplicationService.insertForApplication(sreForApplication);
		return sreForApplication.getApplicationId();
	}
	
	@ApiOperation(value = "获取转资", notes = "根据ID获取转资")
	@RequestMapping(value = "/sre-provider/forapplication/get/{id}", method = RequestMethod.GET)
	public SreForApplication selectUserByUserId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get sreEquipment id "+id+"===========");
		return forapplicationService.selectForApplication(id);
	}
	
	@ApiOperation(value = "转资申请添加查询装备分页", notes = "转资申请添加查询装备分页")
	@RequestMapping(value = "/sre-provider/forapplicationequipment/page", method = RequestMethod.POST)
	public LayuiTableData getForapplicationequipmentList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=forapplicationService.getEquipmentPage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "转资详情分页", notes = "转资详情分页")
	@RequestMapping(value = "/sre-provider/forapplication/pageview", method = RequestMethod.POST)
	public LayuiTableData getForApplicationListView(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=detailService.getForApplicationView(param);
		return rageResult;
	}
	
	@RequestMapping(value = "/sre-provider/forapplication/upfor/{id}", method = RequestMethod.POST)
	public int upforSreForapplication(@PathVariable("id") String id)throws Exception{
		return forapplicationService.upForapplication(id);
	}
	
	@ApiOperation(value = "修改采购申请单", notes = "修改采购申请单")
    @RequestMapping(value = "/sre-provider/forapplication/update", method = RequestMethod.POST)
    public Integer updateSreForApplication(@RequestBody SreForApplication sreForApplication) throws Exception{
        logger.info("==================update SrePurchase===========================");

        return forapplicationService.updateSreForApplication(sreForApplication);
    }
	
	@ApiOperation(value="转资申请确认流程",notes="转资申请确认流程")
	@RequestMapping(value = "/stp-provider/forapplication/forapplication_activity/{id}", method = RequestMethod.POST)
	public Result start_purchase_activity(@PathVariable("id") String id, @RequestBody Map map)throws Exception
	{
		return forapplicationService.dealPurchaseFlow(id,map);
	}
	/**===============================================装备台账===================================================*/
	
	@ApiOperation(value = "装备台账分页", notes = "装备台账分页")
	@RequestMapping(value = "/sre-provider/detail/page", method = RequestMethod.POST)
	public LayuiTableData getDetailList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=detailService.getDetailPage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "增加转资装备", notes = "增加转资申请")
	@RequestMapping(value = "/sre-provider/Detail/add", method = RequestMethod.POST)
	public String insertSreForApplication(@RequestBody SreDetail sreDetail) throws Exception{
		logger.info("====================add forapplication....========================");
		Integer count= detailService.insertDetail(sreDetail);
		return sreDetail.getEquipmentId();
	}
	
	 /**
     * @param id
     * @return
     * @throws Exception
     * 采购管理--审批流程都同意后业务
     */
	@RequestMapping(value = "/sre-provider/forapplication/agree_forapplication/{id}", method = RequestMethod.POST)
	public Integer agreeSreForapplication(@PathVariable(value = "id", required = true) String id)throws Exception {

		SreForApplication forrecord = sreforapplicationMapper.selectByPrimaryKey(id);
    	forrecord.setApplicationState(Constant.OK_THREE);
    	int count=sreforapplicationMapper.updateByPrimaryKeySelective(forrecord);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}

    /**
     * @param id
     * @return
     * @throws Exception
     * 采购管理--驳回后业务
     */
    @RequestMapping(value = "/sre-provider/forapplication/reject_forapplication/{id}", method = RequestMethod.POST)
    public Integer rejectForapplication(@PathVariable(value = "id", required = true) String id)throws Exception {

    	SreForApplication forrecord = sreforapplicationMapper.selectByPrimaryKey(id);
    	forrecord.setApplicationState(Constant.OK_SREE);
    	int count=sreforapplicationMapper.updateByPrimaryKeySelective(forrecord);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+id);
        return count;
    }
    /**===============================================科技资产查询===================================================*/
    @ApiOperation(value = "科技资产查询", notes = "科技资产查询")
	@RequestMapping(value = "/sre-provider/researchassets/page", method = RequestMethod.POST)
	public LayuiTableData getResearchAssetsList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=forapplicationService.getResearchAssetsList(param);
		return rageResult;
	}
    
    @ApiOperation(value = "获取装备明细", notes = "根据ID获取装备明细")
	@RequestMapping(value = "/sre-provider/sreDetail/get/{id}", method = RequestMethod.GET)
	public SreDetail selectSreDetailId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get sreEquipment id "+id+"===========");
		return detailService.selectSreDetailId(id);
	}
}
