package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetExceptionResultEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetReleaseEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.service.budget.BudgetAssetTotalService;
import com.pcitc.service.budget.BudgetB2cSplitService;
import com.pcitc.service.budget.BudgetGroupTotalService;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.budget.BudgetStockTotalService;
import com.pcitc.service.budget.BudgetTechSplitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算表管理",tags= {"预算-预算表管理"})
@RestController
public class BudgetInfoProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetInfoProviderClient.class);

	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Autowired
	private BudgetGroupTotalService budgetGroupTotalService;
	@Autowired
	private BudgetAssetTotalService budgetAssetTotalService;
	@Autowired
	private BudgetStockTotalService budgetStockTotalService;
	@Autowired
	private BudgetB2cSplitService budgetB2cSplitService;
	@Autowired
	private BudgetTechSplitService budgetTechSplitService;
	
	@ApiOperation(value="预算管理-预算列表",notes="按年检索年度预算表信息列表（不分页）。")
	@RequestMapping(value = "/stp-provider/budget/budget-info-list", method = RequestMethod.POST)
	public Object selectBudgetInfoList(@RequestBody BudgetInfo info) 
	{
		//List<BudgetInfo> data = null;
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> datalist = budgetInfoService.selectBudgetInfoList(info.getNd(),info.getBudgetType());
			for(BudgetInfo dt:datalist) {
				Map<String,Object> map = MyBeanUtils.transBean2Map(dt);
				map.put("auditStatusDesc", BudgetAuditStatusEnum.getStatusByCode(dt.getAuditStatus()).getDesc());
				rsdata.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="预算管理-预算列表",notes="按年检索年度预算表信息（带分页）。")
	@RequestMapping(value = "/stp-provider/budget/budget-info-table", method = RequestMethod.POST)
	public Object selectBudgetInfoTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = budgetInfoService.selectBudgetInfoPage(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算管理-创建年度预算",notes="创建年度预算空白预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-create", method = RequestMethod.POST)
	public Object createBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-total...");
		BudgetInfo rsbean = null;
		try
		{
			rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(),info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsbean;
	}
	@ApiOperation(value="预算管理-创建年度预算",notes="创建年度预算空白预算表(根据模板)")
	@RequestMapping(value = "/stp-provider/budget/budget-info-create-bytemplate", method = RequestMethod.POST)
	public Object createBudgetInfoByTemplate(@RequestBody BudgetInfo info) 
	{
		BudgetInfo newInfo = null;
		try
		{
			newInfo = budgetInfoService.createBlankBudgetInfo(info.getNd(),info);
			
			BudgetInfo oldInfo = budgetInfoService.selectBudgetInfo(info.getDataId());
			newInfo.setBudgetMoney(oldInfo.getBudgetMoney());
			newInfo.setNd(info.getNd());
			newInfo.setCreaterId(info.getCreaterId());
			newInfo.setCreaterName(info.getCreaterName());
			budgetInfoService.updateBudgetInfo(newInfo);
			//集团预算总表
			if(BudgetInfoEnum.GROUP_TOTAL.getCode().equals(info.getBudgetType())) {
				budgetGroupTotalService.createBudgetItemByTemplate(info.getDataId(), newInfo);
			}else if(BudgetInfoEnum.ASSETS_TOTAL.getCode().equals(info.getBudgetType())){
				budgetAssetTotalService.createBudgetItemByTemplate(info.getDataId(), newInfo);
			}else if(BudgetInfoEnum.STOCK_TOTAL.getCode().equals(info.getBudgetType())) {
				budgetStockTotalService.createBudgetItemByTemplate(info.getDataId(), newInfo);
			}else if(BudgetInfoEnum.B2C_SPLIT.getCode().equals(info.getBudgetType())) {
				budgetB2cSplitService.createBudgetItemByTemplate(info.getDataId(), newInfo);
			}else if(BudgetInfoEnum.TECH_SPLIT.getCode().equals(info.getBudgetType())) {
				budgetTechSplitService.createBudgetItemByTemplate(info.getDataId(), newInfo);
			}else {
				System.out.println("create by template is null..........");
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newInfo;
	}
	
	@ApiOperation(value="获取年度最终预算",notes="获取年度最终预算表")
	@RequestMapping(value = "/stp-provider/budget/get-final-budget", method = RequestMethod.POST)
	public Object getFinalBudgetInfo(@RequestBody BudgetInfo info) 
	{
		BudgetInfo budget = null;
		try
		{
			budget = budgetInfoService.selectFinalBudget(info.getNd(),info.getBudgetType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return budget;
	}
	
	@ApiOperation(value="预算管理",notes="保存年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-save", method = RequestMethod.POST)
	public Object saveOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("saveorupdate-budget-info...");
		Integer rs = 0;
		try
		{
			rs = budgetInfoService.insertBudgetInfo(info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="预算管理",notes="更新年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-update", method = RequestMethod.POST)
	public Object updOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		Integer rs = 0;
		try
		{
			rs = budgetInfoService.updateBudgetInfo(info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="预算管理",notes="删除年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-del", method = RequestMethod.POST)
	public Object deleteBudgetInfo(@RequestBody BudgetInfo info) 
	{
		Integer rs = 0;
		try
		{
			rs = budgetInfoService.deleteBudgetInfo(info.getDataId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算管理",notes="获得预算详情")
	@RequestMapping(value = "/stp-provider/budget/budget-info-get/{dataId}", method = RequestMethod.POST)
	public Object selectBudgetInfo(@PathVariable("dataId") String dataId) 
	{
		BudgetInfo info = null;
		try
		{
			info = budgetInfoService.selectBudgetInfo(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return info;
	}
	@ApiOperation(value="启动审批",notes="启动审批流程。")
	@RequestMapping(value = "/stp-provider/budget/start-budgetinfo-activity/{budgetId}", method = RequestMethod.POST)
	public Object satrtApplyActivity(@PathVariable("budgetId") String budgetId,@RequestBody WorkflowVo workflowVo) 
	{
		BudgetInfo info;
		Result rs = new Result(true,"操作成功!");
		try {
			info = budgetInfoService.selectBudgetInfo(budgetId);
			//如果审批已发起则不能再次发起(审批中，审批通过，最终版本 这三种状态不可提交，编制中和审批驳回可以继续提交)
			if(BudgetAuditStatusEnum.AUDIT_STATUS_START.getCode().equals(info.getAuditStatus()) 
					|| BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode().equals(info.getAuditStatus())
					|| BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode().equals(info.getAuditStatus())) 
			{
				return new Result(false,"已发起审批不可重复发起！");
			}
			boolean status = budgetInfoService.startWorkFlow(info,workflowVo);
	    	if(status) 
			{
	    		info.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_START.getCode());
	    		budgetInfoService.updateBudgetInfo(info);
			}
	    	Map<String,Object> rsmap = MyBeanUtils.transBean2Map(info);
	    	rsmap.put("auditStatusDesc", BudgetAuditStatusEnum.getStatusByCode(info.getAuditStatus()).getDesc());
	    	rs.setData(rsmap);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"操作失败!");
		}
		return rs;
	}
	
	@ApiOperation(value="公司预算-审批流程回调通知",notes="审批结果回调通知")
	@RequestMapping(value = "/stp-provider/budget/callback-workflow-notice-budgetinfo")
	public Object callBackProjectNoticeWorkflow(@RequestParam(value = "budgetId", required = true) String budgetId,
			@RequestParam(value = "workflow_status", required = true) Integer workflow_status) throws Exception 
	{
		BudgetInfo info = budgetInfoService.selectBudgetInfo(budgetId);
		//如果审批通过
		if(BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode().equals(workflow_status)) {
			//将当年的其他值设置为审批通过
			List<BudgetInfo> infos = budgetInfoService.selectBudgetInfoList(info.getNd(), info.getBudgetType());
			for(BudgetInfo i:infos) {
				//最终版本只有一个，多次审批后以最后一次审批为准
				if(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode().equals(i.getAuditStatus())) {
					i.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode());
					budgetInfoService.updateBudgetInfo(i);
				}
			}
			info.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
			budgetInfoService.updateBudgetInfo(info);
			//输出到最终报表
			budgetInfoService.processDataImport(info);
		}else {
			//更新状态
			info.setAuditStatus(workflow_status);
			budgetInfoService.updateBudgetInfo(info);
		}
		return 1;
	}
	@ApiOperation(value="检查可编辑状态",notes="检查预算项是否可编辑，审批中、审批通过、最终版本都不可编辑!")
	@RequestMapping(value = "/stp-provider/budget/check-budgetinfo-edit/{budgetId}", method = RequestMethod.POST)
	public Object checkBudgetInfoEdit(@PathVariable("budgetId") String budgetId) 
	{
		try 
		{
			BudgetInfo info = budgetInfoService.selectBudgetInfo(budgetId);
			
			if(BudgetAuditStatusEnum.AUDIT_STATUS_START.getCode().equals(info.getAuditStatus())) 
			{
				return BudgetExceptionResultEnum.ERROR_FLOWING.getResult();
			}
			if(BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode().equals(info.getAuditStatus())) 
			{
				return BudgetExceptionResultEnum.ERROR_FLOWEND.getResult();
			}
			if(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode().equals(info.getAuditStatus())) 
			{
				return BudgetExceptionResultEnum.ERROR_FLOWRELASE.getResult();
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new Result(true);
	}
	@ApiOperation(value="预算管理-预算下发列表",notes="按年检索所有最终预算版本")
	@RequestMapping(value = "/stp-provider/budget/budget-release-list", method = RequestMethod.POST)
	public Object selectBudgetReleaseList(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = budgetInfoService.selectReleaseBudgetPage(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算管理-预算列表",notes="按年检索年度预算表信息列表（不分页）。")
	@RequestMapping(value = "/stp-provider/budget/budget-info-release", method = RequestMethod.POST)
	public Object budgetRelease(@RequestBody BudgetInfo info) 
	{
		Result rs = new Result(false,"下发失败!");
		try
		{
			BudgetInfo rsinfo = budgetInfoService.selectBudgetInfo(info.getDataId());
			if(rsinfo != null) 
			{
				rsinfo.setReleaseStatus(BudgetReleaseEnum.STATUS_RELEASE.getCode());
				budgetInfoService.updateBudgetInfo(rsinfo);	
				rs = new Result(true,"下发成功!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
