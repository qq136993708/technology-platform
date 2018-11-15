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
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProjectBasic;
import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.workflow.Constants;
import com.pcitc.service.equipment.EquipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "Equipment-API",tags = {"装备、项目统计相关的接口"})
@RestController
public class EquipmentProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentProviderClient.class); 
	@Autowired
    private EquipmentService equipmentService; 
	
	
	
	@ApiOperation(value = "装备分页", notes = "装备分页")
	@RequestMapping(value = "/sre-provider/equipment/page", method = RequestMethod.POST)
	public LayuiTableData getSreEquipmentList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=equipmentService.getEquipmentPage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "增加装备", notes = "增加装备")
	@RequestMapping(value = "/sre-provider/equipment/add", method = RequestMethod.POST)
	public String insertSreEquipment(@RequestBody SreEquipment sreEquipment) throws Exception{
		logger.info("====================add sreEquipment....========================");
		Integer count= equipmentService.insertEquipment(sreEquipment);
		return sreEquipment.getEquipmentId();
	}
	
	
	@ApiOperation(value = "修改装备", notes = "修改装备")
	@RequestMapping(value = "/sre-provider/equipment/update", method = RequestMethod.POST)
	public Integer updateSreEquipment(@RequestBody SreEquipment sreEquipment) throws Exception{
		logger.info("==================update sreEquipment===========================");
		return equipmentService.updateEquipment(sreEquipment);
	}
	
	
	@RequestMapping(value = "/sre-provider/equipment/delete/{id}", method = RequestMethod.POST)
	public int deleteSreEquipment(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete sreEquipment=================");
		return equipmentService.deleteEquipment(id);
	}
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "删除装备", notes = "删除装备")
	@RequestMapping(value = "/sre-provider/equipment/batch-delete", method = RequestMethod.POST)
	public int batchDelete(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete SreEquipment=================");
		return equipmentService.batchDeleteEquipment(list);
	}
	
	
	
	
	
	@ApiOperation(value = "获取装备", notes = "根据ID获取装备")
	@RequestMapping(value = "/sre-provider/equipment/get/{id}", method = RequestMethod.GET)
	public SreEquipment selectUserByUserId(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get sreEquipment id "+id+"===========");
		return equipmentService.selectEquipment(id);
	}
	
	
	/**
	 * @param jsonStr
	 * @return
	 * 业务系统处理驳回后业务
	 */
	@RequestMapping(value = "/sre-provider/equipment/task/reject/{businessId}", method = RequestMethod.POST)
	public Integer taskReject(@PathVariable(value = "businessId", required = true) String businessId)throws Exception {
		
		SreEquipment sreEquipment=equipmentService.selectEquipment(businessId);
		sreEquipment.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE));
		int count=equipmentService.updateEquipment(sreEquipment);
		System.out.println("======业务系统处理--驳回 --后业务======="+businessId);
		return count;
	}
	
	
	/**
	 * @param jsonStr
	 * @return
	 * 业务系统处理审批流程都同意后业务
	 */
	@RequestMapping(value = "/sre-provider/equipment/task/agree/{businessId}", method = RequestMethod.POST)
	public Integer taskAgree(@PathVariable(value = "businessId", required = true) String businessId)throws Exception {
		
		SreEquipment sreEquipment=equipmentService.selectEquipment(businessId);
		sreEquipment.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		int count=equipmentService.updateEquipment(sreEquipment);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+businessId);
		return count;
	}
	
	/**
	 * 批量获取
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量获取装备", notes = "根据IDS批量获取装备")
	@RequestMapping(value = "/sre-provider/equipment/list-by-ids", method = RequestMethod.POST)
	public List getlistEquipemntids(@RequestBody List<String> list)throws Exception{
		logger.info("=============================list-by-ids Equipemnt =================");
		return equipmentService.getEquipmentListByIds(list);
	}
	
	
	
	
	
	
	
	
	
	
	/**===============================================项目===================================================*/
	@ApiOperation(value = "项目统计列表", notes = "项目统计列表")
	@RequestMapping(value = "/sre-provider/project_basic/page", method = RequestMethod.POST)
	public LayuiTableData getSreProjectBasicList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		logger.info("==================page SreProjectBasic==========================="+paramsJson);
		return equipmentService.getProjectBasicPage(paramsJson);
	}
	
	@ApiOperation(value = "增加项目统计", notes = "增加项目统计")
	@RequestMapping(value = "/sre-provider/project_basic/add", method = RequestMethod.POST)
	public String insertSreProjectBasic(@RequestBody SreProjectBasic sreProjectBasic) throws Exception{
		logger.info("====================add SreProjectBasic....========================");
		Integer count= equipmentService.insertProjectBasic(sreProjectBasic);
		return sreProjectBasic.getProjectId();
	}
	
	
	@ApiOperation(value = "修改项目统计", notes = "修改项目统计")
	@RequestMapping(value = "/sre-provider/project_basic/update", method = RequestMethod.POST)
	public Integer updateSreProjectBasic(@RequestBody SreProjectBasic sreProjectBasic) throws Exception{
		logger.info("==================update SreProjectBasic===========================");
		return equipmentService.updateProjectBasic(sreProjectBasic);
	}
	
	
	@ApiOperation(value = "删除项目统计", notes = "删除项目统计")
	@RequestMapping(value = "/sre-provider/project_basic/delete/{id}", method = RequestMethod.POST)
	public int deleteSreProjectBasic(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SreProjectBasic=================");
		return equipmentService.deleteProjectBasic(id) ;
	}
	
	
	@ApiOperation(value = "获取项目统计", notes = "根据ID获取项目统计")
	@RequestMapping(value = "/sre-provider/project_basic/get/{id}", method = RequestMethod.GET)
	public SreProjectBasic selectSreProjectBasicById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreProjectBasic id "+id+"===========");
		return equipmentService.selectProjectBasic(id) ;
	}
	
	
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "删除项目统计", notes = "根据ID删除项目统计")
	@RequestMapping(value = "/sre-provider/project_basic/batch-delete", method = RequestMethod.POST)
	public int batchDeleteSreProjectBasic(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete ProjectBasic =================");
		return equipmentService.batchDeleteProjectBasic(list);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**===============================================交流===================================================*/
	
	
	
	@RequestMapping(value = "/sre-provider/meeting/page", method = RequestMethod.POST)
	public LayuiTableData getSreTechMeetingList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		
		logger.info("=== SreTechMeeting paramsJson============"+paramsJson);
		return equipmentService.getMeetingPage(paramsJson);
		
	}
	
	
	@RequestMapping(value = "/sre-provider/meeting/add", method = RequestMethod.POST)
	public String insertSreTechMeeting(@RequestBody SreTechMeeting sreTechMeeting) throws Exception{
		logger.info("====================add SreTechMeeting....========================");
		Integer count= equipmentService.insertMeeting(sreTechMeeting);
		logger.info("====================add SreTechMeeting id="+sreTechMeeting.getMeetingId()+"======");
		return sreTechMeeting.getMeetingId();
	}
	
	
	
	@RequestMapping(value = "/sre-provider/meeting/update", method = RequestMethod.POST)
	public Integer updateSreTechMeeting(@RequestBody SreTechMeeting sreTechMeeting) throws Exception{
		logger.info("==================update SreTechMeeting===========================");
		return equipmentService.updateMeeting(sreTechMeeting);
	}
	
	
	@RequestMapping(value = "/sre-provider/meeting/delete/{id}", method = RequestMethod.POST)
	public int deleteSreTechMeeting(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SreTechMeeting=================");
		return equipmentService.deleteMeeting(id);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/sre-provider/meeting/get/{id}", method = RequestMethod.GET)
	public SreTechMeeting selectMeetingById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreTechMeeting id "+id+"===========");
		return equipmentService.selectMeeting(id);
	}
	
	
	
	
	
	
	
	

}
