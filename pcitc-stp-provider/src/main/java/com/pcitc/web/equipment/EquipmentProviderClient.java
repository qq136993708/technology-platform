package com.pcitc.web.equipment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SreProjectYear;
import com.pcitc.base.stp.equipment.SreProjectYearExample;
import com.pcitc.base.stp.equipment.SreSupplier;
import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.workflow.Constants;
import com.pcitc.common.MailBean;
import com.pcitc.common.WorkFlowStatusEnum;
import com.pcitc.service.equipment.EquipmentService;
import com.pcitc.service.feign.SystemRemoteClient;
import com.pcitc.service.msg.MailSentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "Equipment-API",tags = {"装备、项目统计相关的接口"})
@RestController
public class EquipmentProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentProviderClient.class); 
	@Autowired
    private EquipmentService equipmentService; 
	
	
	@Autowired
	private MailSentService mailSentService;
	
	@Autowired
	private SystemRemoteClient systemRemoteClient;
	
	
	
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
	/*@ApiOperation(value = "删除装备", notes = "删除装备")
	@RequestMapping(value = "/sre-provider/equipment/batch-delete", method = RequestMethod.POST)
	public int batchDelete(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete SreEquipment=================");
		return equipmentService.batchDeleteEquipment(list);
	}*/
	
	
	
	
	
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
	@ApiOperation(value = "批量获取装备", notes = "根据IDS批量获取装备，返回LIST")
	@RequestMapping(value = "/sre-provider/equipment/list-by-ids", method = RequestMethod.POST)
	public List<SreEquipment> getlistEquipemntids(@RequestBody List<String> list)throws Exception{
		logger.info("=============================list-by-ids Equipemnt =================");
		return equipmentService.getEquipmentListByIds(list);
	}
	
	
	@ApiOperation(value = "批量获取装备", notes = "根据IDS批量获取装备，返回json格式")
	@RequestMapping(value = "/sre-provider/equipment/get_json_by_ids", method = RequestMethod.POST)
	public JSONArray getlistEquipemntidsjSON(@RequestBody List<String> list)throws Exception{
		logger.info("============================get_json_by_ids Equipemnt =================");
		List<SreEquipment> listSreEquipment= equipmentService.getEquipmentListByIds(list);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(listSreEquipment));
		return json;
	}
	
	
	
	
	
	/**===============================================计划上报===================================================*/
	
	
	@ApiOperation(value = "计划上报统计列表", notes = "计划上报统计列表")
	@RequestMapping(value = "/sre-provider/project_basic/page", method = RequestMethod.POST)
	public LayuiTableData getSreProjectBasicList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		logger.info("==================page SreProjectBasic==========================="+paramsJson);
		return equipmentService.getProjectPage(paramsJson);
	}
	
	
	@ApiOperation(value = "增加计划上报", notes = "增加计划上报")
	@RequestMapping(value = "/sre-provider/project_basic/add", method = RequestMethod.POST)
	public String insertSreProjectBasic(@RequestBody SreProject sreProjectBasic) throws Exception{
		logger.info("====================add SreProjectBasic....========================");
		Integer count= equipmentService.insertProjectBasic(sreProjectBasic);
		
		//再添加费用表
		String yearFeeStr=sreProjectBasic.getYearFeeStr() ;
		String array[]=yearFeeStr.split("#");
		if(array!=null && array.length>0)
		{
			for(int i=0;i<array.length;i++)
			{
				String year=array[i];
				String arr[]=year.split(",");
				SreProjectYear sreProjectYear=new SreProjectYear();
				String id = UUID.randomUUID().toString().replaceAll("-", "");
				sreProjectYear.setId(id);
				sreProjectYear.setProjectId(sreProjectBasic.getId());
				sreProjectYear.setYear(arr[0]);
				sreProjectYear.setCostMoney(new BigDecimal(arr[1]));
				sreProjectYear.setCapitalMoney(new BigDecimal(arr[2]));
				sreProjectYear.setSubtotalMoney(new BigDecimal(arr[3]));
				equipmentService.insertSreProjectYear(sreProjectYear);
			}
		}
		
		return sreProjectBasic.getId();
	}
	
	
	@ApiOperation(value = "修改项目统计", notes = "修改项目统计")
	@RequestMapping(value = "/sre-provider/project_basic/update", method = RequestMethod.POST)
	public Integer updateSreProjectBasic(@RequestBody SreProject sreProjectBasic) throws Exception{
		logger.info("==================update SreProjectBasic===========================");
		
		//先删除费用表
		SreProjectYearExample sreProjectYearExample=new SreProjectYearExample();
		SreProjectYearExample.Criteria criteria = sreProjectYearExample.createCriteria();
		criteria.andProjectIdEqualTo(sreProjectBasic.getId());
		equipmentService.deleteSreProjectYearExample(sreProjectYearExample);
		//再添加费用表
		String yearFeeStr=sreProjectBasic.getYearFeeStr() ;
		String array[]=yearFeeStr.split("#");
		if(array!=null && array.length>0)
		{
			for(int i=0;i<array.length;i++)
			{
				String year=array[i];
				String arr[]=year.split(",");
				SreProjectYear sreProjectYear=new SreProjectYear();
				String id = UUID.randomUUID().toString().replaceAll("-", "");
				sreProjectYear.setId(id);
				sreProjectYear.setProjectId(sreProjectBasic.getId());
				sreProjectYear.setYear(arr[0]);
				sreProjectYear.setCostMoney(new BigDecimal(arr[1]));
				sreProjectYear.setCapitalMoney(new BigDecimal(arr[2]));
				sreProjectYear.setSubtotalMoney(new BigDecimal(arr[3]));
				equipmentService.insertSreProjectYear(sreProjectYear);
			}
		}
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
	public SreProject selectSreProjectById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreProject id "+id+"===========");
		return equipmentService.selectProjectBasic(id) ;
	}
	
	
	//工作流审批通过后回调通知相关人员
	@ApiOperation(value="任务书填写邮件通知",notes="任务书填写，下发邮件通知。")
	@RequestMapping(value = "/stp-provider/project_basic/mail", method = RequestMethod.POST)
	public Integer sentSreProjectTaskMail(@RequestBody SreProject sreProject) throws Exception
	{
		logger.info("sent notice....");
		mailSentService.sentMail(new MailBean(sreProject.getEmail(),"科技管理平台-装备管理-任务书填写","您好，课题："+sreProject.getName()+"，需要您填写任务书，请到科技管理平台-装备管理-任务书管理-任务书 菜单中填写"));
		return 1;
	}
	
	/**
	 * @param jsonStr
	 * @return
	 * 业务系统处理驳回后业务
	 */
	@RequestMapping(value = "/sre-provider/project/task/reject/{id}", method = RequestMethod.POST)
	public Integer taskRejectSreProject(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		SreProject sreProject=equipmentService.selectProjectBasic(id);
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE));
		int count=equipmentService.updateProjectBasic(sreProject);
		System.out.println("======业务系统处理--驳回 --后业务======="+id);
		return count;
	}
	
	/**
	 * @param jsonStr
	 * @return
	 * 业务系统处理审批流程都同意后业务
	 */
	@RequestMapping(value = "/sre-provider/project/task/agree/{id}", method = RequestMethod.POST)
	public Integer taskAgreeSreProject(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		SreProject sreProject=equipmentService.selectProjectBasic(id);
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		int count=equipmentService.updateProjectBasic(sreProject);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}
	
	
	
	@ApiOperation(value="计划上报审批流程",notes="计划上报通知内容审批")
	@RequestMapping(value = "/stp-provider/project_basic/start_project_activity/{id}", method = RequestMethod.POST)
	public Result dealProjectWorkFlow(@PathVariable("id") String id,@RequestBody Map map)throws Exception 
	{
		return equipmentService.dealProjectWorkFlow(id,map);
	}
	

	
	/**===============================================任务书===================================================*/
	
	
	/**
	 * 根据topicId-任务书
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量获取供应商", notes = "根据topicId任务书")
	@RequestMapping(value = "/sre-provider/project_task/getSreProjectTaskList/{topicId}", method = RequestMethod.GET)
	public JSONArray getSreProjectTaskList(@PathVariable("topicId") String topicId)throws Exception{
		logger.info("============================SreSreProjectTask =================");
		List<SreProjectTask> list=equipmentService.getSreProjectTaskListBytopicId(topicId);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
		return json;
	}
	
	
	@ApiOperation(value = "任务书统计列表", notes = "任务书统计列表")
	@RequestMapping(value = "/sre-provider/project_task/page", method = RequestMethod.POST)
	public LayuiTableData getSreProjecTaskList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		logger.info("==================page SreSreProjectTask==========================="+paramsJson);
		return equipmentService.getSreProjectTaskPage(paramsJson);
	}
	
	@ApiOperation(value = "增加任务书", notes = "增加任务书")
	@RequestMapping(value = "/sre-provider/project_task/add", method = RequestMethod.POST)
	public String insertSreSreProjectTask(@RequestBody SreProjectTask sreProjectTask) throws Exception{
		logger.info("====================add SreProjectTask....========================");
		Integer count= equipmentService.insertSreProjectTask(sreProjectTask);
		
		return sreProjectTask.getTaskId();
	}
	
	
	@ApiOperation(value = "修改任务书", notes = "修改任务书")
	@RequestMapping(value = "/sre-provider/project_task/update", method = RequestMethod.POST)
	public Integer updateSreSreProjectTask(@RequestBody SreProjectTask sreSreProjectTask) throws Exception{
		logger.info("==================update SreSreProjectTask===========================");
		
		
		return equipmentService.updateSreProjectTask(sreSreProjectTask);
	}
	
	
	@ApiOperation(value = "删除任务书", notes = "删除任务书")
	@RequestMapping(value = "/sre-provider/project_task/delete/{id}", method = RequestMethod.POST)
	public int deleteSreSreProjectTask(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SreSreProjectTask=================");
		return equipmentService.deleteSreProjectTask(id) ;
	}
	
	
	@ApiOperation(value = "获取任务书", notes = "根据ID获取任务书")
	@RequestMapping(value = "/sre-provider/project_task/get/{id}", method = RequestMethod.GET)
	public SreProjectTask selectSreProjectTaskById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreProject id "+id+"===========");
		return equipmentService.selectSreProjectTask(id) ;
	}
	
	
	/**
	 * 任务书--总部审核流程--驳回后业务
	 */
	@RequestMapping(value = "/sre-provider/project_task/task/reject/{id}", method = RequestMethod.POST)
	public Integer taskRejectSreProjectTask(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		SreProjectTask sreProject=equipmentService.selectSreProjectTask(id);
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE));
		int count=equipmentService.updateSreProjectTask(sreProject);
		System.out.println("======业务系统处理--驳回 --后业务======="+id);
		return count;
	}
	
	/**
	 * 任务书--总部审核流程--同意后业务
	 */
	@RequestMapping(value = "/sre-provider/project_task/task/agree/{id}", method = RequestMethod.POST)
	public Integer taskAgreeSreProjectTask(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		SreProjectTask sreProject=equipmentService.selectSreProjectTask(id);
		sreProject.setAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		List<SreProjectTask> list=	equipmentService.getSreProjectTaskListBytopicId(sreProject.getTopicId());
		String contractNum="";
		if(list!=null && list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				SreProjectTask sreProjectTask=list.get(i);
				String str=sreProjectTask.getTaskVersion();
				if(str.equals("1"))
				{
					contractNum=sreProjectTask.getContractNum();
				}
			}
		}
		if(!contractNum.equals(""))
		{
			sreProject.setContractNum(contractNum);
		}
		int count=equipmentService.updateSreProjectTask(sreProject);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}
	
	
	
	/**
	 * 任务书--内部审核流程--驳回后业务
	 */
	@RequestMapping(value = "/sre-provider/project_task/task/reject_inner/{id}", method = RequestMethod.POST)
	public Integer taskRejectSreProjectTaskInner(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		SreProjectTask sreProject=equipmentService.selectSreProjectTask(id);
		sreProject.setInnerAuditStatus(String.valueOf(Constants.FLOW_STATE_SAVE)); 
		int count=equipmentService.updateSreProjectTask(sreProject);
		System.out.println("======业务系统处理--驳回 --后业务======="+id);
		return count;
	}
	
	/**
	 * 任务书--内部审核流程--同意后业务
	 */
	@RequestMapping(value = "/sre-provider/project_task/task/agree_inner/{id}", method = RequestMethod.POST)
	public Integer taskAgreeSreProjectTaskInner(@PathVariable(value = "id", required = true) String id)throws Exception {
		
		SreProjectTask sreProject=equipmentService.selectSreProjectTask(id);
		sreProject.setInnerAuditStatus(String.valueOf(Constants.FLOW_STATE_DONE));
		int count=equipmentService.updateSreProjectTask(sreProject);
		System.out.println("======业务系统处理审批流程都 --同意 --后业务======="+id);
		return count;
	}
	
	
	
	
	
	@ApiOperation(value="计划内部确认流程",notes="计划内部确认流程")
	@RequestMapping(value = "/stp-provider/project_task/start_inner_activity/{taskId}", method = RequestMethod.POST)
	public Result start_inner_activity(@PathVariable("taskId") String taskId,@RequestBody Map map)throws Exception 
	{
		return equipmentService.dealInnerTaskFlow(taskId,map);
	}
	@ApiOperation(value="计划总部上报流程",notes="计划总部上报流程")
	@RequestMapping(value = "/stp-provider/project_task/start_up_activity/{taskId}", method = RequestMethod.POST)
	public Result start_up_activity(@PathVariable("taskId") String taskId,@RequestBody Map map)throws Exception 
	{
		return equipmentService.dealUpTaskFlow(taskId,map);
	}
	

	
	/**===============================================立项报告===================================================*/
	
	@ApiOperation(value = "立项报告统计列表", notes = "立项报告统计列表")
	@RequestMapping(value = "/sre-provider/project_setup/page", method = RequestMethod.POST)
	public LayuiTableData getSreProjectSetupPage(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		logger.info("==================page SreSreProjectSetup==========================="+paramsJson);
		return equipmentService.getSreProjectSetupPage(paramsJson);
	}
	
	@ApiOperation(value = "增加立项报告", notes = "增加立项报告")
	@RequestMapping(value = "/sre-provider/project_setup/add", method = RequestMethod.POST)
	public String insertSreSreProjectSetup(@RequestBody SreProjectSetup sreProjectSetup) throws Exception{
		logger.info("====================add SreProjectSetup....========================");
		Integer count= equipmentService.insertSreProjectSetup(sreProjectSetup);
		
		return sreProjectSetup.getSetupId();
	}
	
	
	@ApiOperation(value = "修改立项报告", notes = "修改立项报告")
	@RequestMapping(value = "/sre-provider/project_setup/update", method = RequestMethod.POST)
	public Integer updateSreSreProjectSetup(@RequestBody SreProjectSetup sreSreProjectSetup) throws Exception{
		logger.info("==================update SreSreProjectSetup===========================");
		
		
		return equipmentService.updateSreProjectSetup(sreSreProjectSetup);
	}
	
	
	@ApiOperation(value = "删除立项报告", notes = "删除立项报告")
	@RequestMapping(value = "/sre-provider/project_setup/delete/{id}", method = RequestMethod.POST)
	public int deleteSreSreProjectSetup(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SreSreProjectSetup=================");
		return equipmentService.deleteSreProjectSetup(id) ;
	}
	
	
	@ApiOperation(value = "获取立项报告", notes = "根据ID获取立项报告")
	@RequestMapping(value = "/sre-provider/project_setup/get/{id}", method = RequestMethod.GET)
	public SreProjectSetup selectSreProjectSetupById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreProject id "+id+"===========");
		return equipmentService.selectSreProjectSetup(id) ;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ApiOperation(value = "供应商分页", notes = "供应商分页")
	@RequestMapping(value = "/sre-provider/supplier/page", method = RequestMethod.POST)
	public LayuiTableData getSreSreSupplierList(@RequestBody LayuiTableParam param)throws Exception
	{
		LayuiTableData rageResult=equipmentService.getSupplierPage(param);
		return rageResult;
	}
	
	@ApiOperation(value = "增加供应商", notes = "增加供应商")
	@RequestMapping(value = "/sre-provider/supplier/add", method = RequestMethod.POST)
	public String insertSreSreSupplier(@RequestBody SreSupplier sreSreSupplier) throws Exception{
		logger.info("====================add sreSreSupplier....========================");
		Integer count= equipmentService.insertSupplier(sreSreSupplier);
		return sreSreSupplier.getId();
	}
	
	
	@ApiOperation(value = "修改供应商", notes = "修改供应商")
	@RequestMapping(value = "/sre-provider/supplier/update", method = RequestMethod.POST)
	public Integer updateSreSreSupplier(@RequestBody SreSupplier sreSreSupplier) throws Exception{
		logger.info("==================update sreSreSupplier===========================");
		return equipmentService.updateSupplier(sreSreSupplier);
	}
	
	
	@RequestMapping(value = "/sre-provider/supplier/delete/{id}", method = RequestMethod.POST)
	public int deleteSreSreSupplier(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete sreSreSupplier=================");
		return equipmentService.deleteSupplier(id);
	}
	
	
	
	
	
	
	@ApiOperation(value = "获取供应商", notes = "根据ID获取供应商")
	@RequestMapping(value = "/sre-provider/supplier/get/{id}", method = RequestMethod.GET)
	public SreSupplier selectSupplier(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get sreSreSupplier id "+id+"===========");
		return equipmentService.selectSupplier(id);
	}
	
	
	
	/**
	 * 批量获取
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量获取供应商", notes = "根据IDS批量获取供应商，返回LIST")
	@RequestMapping(value = "/sre-provider/supplier/list-by-ids", method = RequestMethod.POST)
	public List<SreSupplier> getSreSupplierdids(@RequestBody List<String> list)throws Exception{
		logger.info("=============================list-by-ids Equipemnt =================");
		return equipmentService.getSupplierListByIds(list);
	}
	
	/**
	 * 批量获取
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量获取供应商", notes = "根据IDS批量获取供应商，返回json格式")
	@RequestMapping(value = "/sre-provider/supplier/get_json_by_ids", method = RequestMethod.POST)
	public JSONArray getSreSupplieridsjSON(@RequestBody List<String> list)throws Exception{
		logger.info("============================get_json_by_ids SreSupplier =================");
		List<SreSupplier> listSreEquipment= equipmentService.getSupplierListByIds(list);
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(listSreEquipment));
		return json;
	}
	
	

	
	

}
