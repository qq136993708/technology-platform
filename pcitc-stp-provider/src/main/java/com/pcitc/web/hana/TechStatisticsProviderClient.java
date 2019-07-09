package com.pcitc.web.hana;

import java.util.Map;

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
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.report.TechCost;
import com.pcitc.base.stp.report.TechOrgCount;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.hana.ITechStatisticsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "TechCost-API",tags = {"科研投入表、科研机构调查表"})
@RestController
public class TechStatisticsProviderClient {

	private final static Logger logger = LoggerFactory.getLogger(TechStatisticsProviderClient.class); 
	
	@Autowired
	private ITechStatisticsService techStatisticsService;
	
	
	@ApiOperation(value = "科研投入表分页", notes = "科研投入表分页")
	@RequestMapping(value = "/sre-provider/techCost/page", method = RequestMethod.POST)
	public LayuiTableData getTechCostList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=techStatisticsService.getTechCostPage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "增加科研投入表", notes = "增加科研投入表")
	@RequestMapping(value = "/sre-provider/techCost/add", method = RequestMethod.POST)
	public String insertTechCost(@RequestBody TechCost techCost) throws Exception{
		logger.info("====================add TechCost....========================");
		Integer count= techStatisticsService.insertTechCost(techCost);
		return techCost.getId();
	}
	
	
	@ApiOperation(value = "修改科研投入表", notes = "修改科研投入表")
	@RequestMapping(value = "/sre-provider/techCost/update", method = RequestMethod.POST)
	public Integer updateTechCost(@RequestBody TechCost TechCost) throws Exception{
		logger.info("==================update TechCost===========================");
		return techStatisticsService.updateTechCost(TechCost);
	}
	
	
	@RequestMapping(value = "/sre-provider/techCost/delete/{id}", method = RequestMethod.POST)
	public int deleteTechCost(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete TechCost=================");
		return techStatisticsService.deleteTechCost(id);
	}
	
	
	/**
	 * @param jsonStr
	 * @return
	 * 科研投入业务系统处理驳回后业务
	 */
	@RequestMapping(value = "/sre-provider/techCost/task/reject/{id}", method = RequestMethod.POST)
	public Integer taskRejectSreProject(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		TechCost sreProject=techStatisticsService.selectTechCost(id) ;
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE));
		int count=techStatisticsService.updateTechCost(sreProject);
		System.out.println("======科研投入表业务系统处理--驳回 --后业务======="+id);
		return count;
	}
	
	/**
	 * @param jsonStr
	 * @return
	 * 科研投入业务系统处理审批流程都同意后业务
	 */
	@RequestMapping(value = "/sre-provider/techCost/task/agree/{id}", method = RequestMethod.POST)
	public Integer taskAgreeSreProject(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		TechCost sreProject=techStatisticsService.selectTechCost(id);
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		int count=techStatisticsService.updateTechCost(sreProject);
		System.out.println("======科研投入表业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}
	
	//科研投入表审批流程
	@ApiOperation(value="科研投入表审批流程",notes="科研投入表通知内容审批")
	@RequestMapping(value = "/sre-provider/techCost/start_cost_activity/{id}", method = RequestMethod.POST)
	public Result dealProjectWorkFlow(@PathVariable("id") String id,@RequestBody Map map)throws Exception 
	{
		return techStatisticsService.dealTechCostWorkFlow(id, map);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@ApiOperation(value = "科研机构调查表表分页", notes = "科研机构调查表表分页")
	@RequestMapping(value = "/sre-provider/techOrgCount/page", method = RequestMethod.POST)
	public LayuiTableData getTechOrgCountList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=techStatisticsService.getTechOrgCountPage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "增加科研机构调查表表", notes = "增加科研机构调查表表")
	@RequestMapping(value = "/sre-provider/techOrgCount/add", method = RequestMethod.POST)
	public String insertTechOrgCount(@RequestBody TechOrgCount techOrgCount) throws Exception{
		logger.info("====================add techOrgCount....========================");
		Integer count= techStatisticsService.insertTechOrgCount(techOrgCount);
		return techOrgCount.getId();
	}
	
	
	@ApiOperation(value = "修改科研机构调查表表", notes = "修改科研机构调查表表")
	@RequestMapping(value = "/sre-provider/techOrgCount/update", method = RequestMethod.POST)
	public Integer updateTechOrgCount(@RequestBody TechOrgCount techOrgCount) throws Exception{
		logger.info("==================update techOrgCount===========================");
		return techStatisticsService.updateTechOrgCount(techOrgCount);
	}
	
	
	@RequestMapping(value = "/sre-provider/techOrgCount/delete/{id}", method = RequestMethod.POST)
	public int deleteTechOrgCount(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete techOrgCount=================");
		return techStatisticsService.deleteTechOrgCount(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @param jsonStr
	 * @return
	 * 科研机构调查表业务系统处理驳回后业务
	 */
	@RequestMapping(value = "/sre-provider/techOrgCount/task/reject/{id}", method = RequestMethod.POST)
	public Integer taskRejecttechOrgCount(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		TechOrgCount sreProject=techStatisticsService.selectTechOrgCount(id) ;
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE));
		int count=techStatisticsService.updateTechOrgCount(sreProject);
		System.out.println("======科研机构调查表业务系统处理--驳回 --后业务======="+id);
		return count;
	}
	
	/**
	 * @param jsonStr
	 * @return
	 * 科研机构调查表业务系统处理审批流程都同意后业务
	 */
	@RequestMapping(value = "/sre-provider/techOrgCount/task/agree/{id}", method = RequestMethod.POST)
	public Integer taskAgreetechOrgCount(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		TechOrgCount sreProject=techStatisticsService.selectTechOrgCount(id);
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		int count=techStatisticsService.updateTechOrgCount(sreProject);
		System.out.println("======科研机构调查表业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}
	
	//科研机构调查表表审批流程
	@ApiOperation(value="科研机构调查表审批流程",notes="科研机构调查表通知内容审批")
	@RequestMapping(value = "/sre-provider/techOrgCount/start_org_activity/{id}", method = RequestMethod.POST)
	public Result dealTechOrgCountWorkFlow(@PathVariable("id") String id,@RequestBody Map map)throws Exception 
	{
		return techStatisticsService.dealTechCostWorkFlow(id, map);
	}
	

	
	
	
	
	
	
	
	
	
	
}
