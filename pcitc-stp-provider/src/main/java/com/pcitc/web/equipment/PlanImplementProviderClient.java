package com.pcitc.web.equipment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreInformationDelivery;
import com.pcitc.base.stp.equipment.SrePlanImplement;
import com.pcitc.service.equipment.PlanImplementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "PlanImplement-API",tags = {"规划管理 相关的服务接口"})
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PlanImplementProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(PlanImplementProviderClient.class); 
	@Autowired
    private PlanImplementService planImplementService; 
	
	
	/**规划管理
	 * @param paramsJson
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "规划发布分页", notes = "规划发布分页")
	@RequestMapping(value = "/sre-provider/planImplement/page")
	public LayuiTableData getPlanImplementPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page getPlanningManagementPage==========================="+param);
		
		return planImplementService.getPlanImplementPage(param);
	}
	
	
	@ApiOperation(value = "增加规划发布新增", notes = "增加规划发布新增")
	@RequestMapping(value = "/sre-provider/planImplement/add", method = RequestMethod.POST)
	public String insertSrePlanImplement(@RequestBody SrePlanImplement srePlanImplement) throws Exception{
		logger.info("====================add planImplement....========================");
		Integer count= planImplementService.setPlanImplement(srePlanImplement);
		return count.toString();
	}
	
	@ApiOperation(value = "获取规划发布信息", notes = "获取规划发布信息")
	@RequestMapping(value = "/sre-provider/planImplement/get/{id}", method = RequestMethod.GET)
	public SrePlanImplement selectPlanImplement(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get selectPlanImplement id "+id+"===========");
		return planImplementService.selectPlanImplement(id);
	}
	
	@RequestMapping(value = "/sre-provider/planImplement/delete/{id}", method = RequestMethod.POST)
	public int deleteSrePlanImplement(@PathVariable("id") String id)throws Exception{
		logger.info("=============================deleteSrePlanImplement=================");
		return planImplementService.deleteSrePlanImplement(id);
	}
	
	@ApiOperation(value = "增加规划发布修改", notes = "增加规划发布修改")
	@RequestMapping(value = "/sre-provider/planImplement/updata", method = RequestMethod.POST)
	public String updataSrePlanImplement(@RequestBody SrePlanImplement srePlanImplement) throws Exception{
		logger.info("====================add planImplement....========================");
		Integer count= planImplementService.setupdataSrePlanImplement(srePlanImplement);
		return count.toString();
	}
	
	/*------------------------------------------信息发布---------------------------------------------------------*/
	
	/**信息发布
	 * @param paramsJson
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "信息发布分页", notes = "信息发布分页")
	@RequestMapping(value = "/sre-provider/informationDelivery/page")
	public LayuiTableData getInformationDeliveryPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page getInformationDeliveryPage==========================="+param);
		
		return planImplementService.getInformationDeliveryPage(param);
	}
	@ApiOperation(value = "删除信息发布", notes = "删除信息发布")
	@RequestMapping(value = "/sre-provider/informationDelivery/delete/{id}", method = RequestMethod.POST)
	public int deleteInformationDelivery(@PathVariable("id") String id)throws Exception{
		logger.info("=============================deleteInformationDelivery=================");
		return planImplementService.deleteInformationDelivery(id);
	}
	
	@ApiOperation(value = "获取信息发布数据", notes = "获取信息发布数据")
	@RequestMapping(value = "/sre-provider/informationDelivery/get/{id}", method = RequestMethod.GET)
	public SreInformationDelivery selectInformationDelivery(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get selectInformationDelivery id "+id+"===========");
		return planImplementService.selectInformationDelivery(id);
	}
	
	@ApiOperation(value = "信息发布数据修改", notes = "信息发布数据修改")
	@RequestMapping(value = "/sre-provider/informationDelivery/updata", method = RequestMethod.POST)
	public String updataInformationDelivery(@RequestBody SreInformationDelivery sreInformationDelivery) throws Exception{
		logger.info("====================add planImplement....========================");
		Integer count= planImplementService.updataInformationDelivery(sreInformationDelivery);
		return count.toString();
	}
	
	@ApiOperation(value = "增加信息发布数据", notes = "增加信息发布数据")
	@RequestMapping(value = "/sre-provider/informationDelivery/add", method = RequestMethod.POST)
	public String insertInformationDelivery(@RequestBody SreInformationDelivery sreInformationDelivery) throws Exception{
		logger.info("====================add planImplement....========================");
		Integer count= planImplementService.insertInformationDelivery(sreInformationDelivery);
		return count.toString();
	}
}
