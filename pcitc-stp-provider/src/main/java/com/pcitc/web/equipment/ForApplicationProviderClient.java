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
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreForApplication;
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
	
	
	@ApiOperation(value = "转资详情分页", notes = "转资详情分页")
	@RequestMapping(value = "/sre-provider/forapplication/pageview", method = RequestMethod.POST)
	public LayuiTableData getForApplicationListView(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=detailService.getForApplicationView(param);
		return rageResult;
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
}
