package com.pcitc.web.budget;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.service.budget.BudgetInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算表管理",tags= {"预算-预算表管理"})
@RestController
public class BudgetInfoProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetInfoProviderClient.class);

	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@ApiOperation(value="预算管理-预算列表",notes="按年检索年度预算表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-info-list", method = RequestMethod.POST)
	public Object selectBudgetInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-info-list...");
		List<BudgetInfo> data = null;
		try
		{
			System.out.println(JSON.toJSONString(info.getNd()));
			data = budgetInfoService.selectBudgetInfoList(info.getNd(),info.getBudgetType());
			System.out.println(JSON.toJSONString(data));
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算管理-预算列表",notes="按年检索年度预算表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-info-table", method = RequestMethod.POST)
	public Object selectBudgetInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-grouptotal-info-list...");
		LayuiTableData data = null;
		try
		{
			System.out.println(JSON.toJSONString(param));
			data = budgetInfoService.selectBudgetInfoPage(param);
			System.out.println(JSON.toJSONString(data));
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	
	@ApiOperation(value="预算管理",notes="保存年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-save", method = RequestMethod.POST)
	public Object saveOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("saveorupdate-budget-info...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(info));
			rs = budgetInfoService.insertBudgetInfo(info);
			System.out.println(JSON.toJSONString(rs));
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
		logger.info("saveorupdate-budget-info...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(info));
			rs = budgetInfoService.updateBudgetInfo(info);
			System.out.println(JSON.toJSONString(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="预算管理",notes="删除年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-info-delete/{dataId}", method = RequestMethod.POST)
	public Object deleteBudgetInfo(@PathVariable("dataId") String dataId) 
	{
		logger.info("delete-budget-info...");
		Integer rs = 0;
		try
		{
			rs = budgetInfoService.deleteBudgetInfo(dataId);
			System.out.println(JSON.toJSONString(rs));
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
		logger.info("get-budget-info...");
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
	
	@ApiOperation(value="集团公司预算-审批流程回调通知",notes="审批结果回调通知")
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
		}
		//更新状态
		info.setAuditStatus(workflow_status);
		return budgetInfoService.updateBudgetInfo(info);
	}
}
