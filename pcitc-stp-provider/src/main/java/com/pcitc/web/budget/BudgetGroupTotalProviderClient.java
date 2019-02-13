package com.pcitc.web.budget;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.service.budget.BudgetGroupTotalService;
import com.pcitc.service.budget.BudgetInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-年度预算（集团）总表",tags= {"预算-年度集团预算总表"})
@RestController
public class BudgetGroupTotalProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetGroupTotalProviderClient.class);

	
	@Autowired
	private BudgetGroupTotalService budgetGroupTotalService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	
	@ApiOperation(value="预算明细列表检索",notes="按年检索年度集团预算总表明细。")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-items", method = RequestMethod.POST)
	public Object selectGroupTotalItemList(@RequestBody LayuiTableParam param) 
	{
		logger.info("select-budget-grouptotal-items...");
		LayuiTableData data = null;
		try
		{
			System.out.println(JSON.toJSONString(param));
			data = budgetGroupTotalService.selectBudgetGroupTotalPage(param);
			System.out.println(JSON.toJSONString(data));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="添加预算项",notes="添加集团预算总表项目明细。")
	@RequestMapping(value = "/stp-provider/budget/budget-persistence-grouptotal-item", method = RequestMethod.POST)
	public Object addOrUpdateGroupTotalItem(@RequestBody BudgetGroupTotal budgetGroupTotal) 
	{
		logger.info("add-budget-grouptotal-item...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(budgetGroupTotal));
			rs = budgetGroupTotalService.saveOrUpdateBudgetGroupTotal(budgetGroupTotal);
			System.out.println(JSON.toJSONString(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算管理-创建集团年度预算表",notes="创建集团年度预算空白表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-grouptotal", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-grouptotal...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(info.getNd()));
			BudgetInfo rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(), info.getBudgetType());
			System.out.println(JSON.toJSONString(rsbean));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算管理-创建集团年度预算表",notes="根据模板创建集团年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-template-grouptotal", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfoByHis(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-grouptotal...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(info.getNd()));
			BudgetInfo newInfo = budgetInfoService.createBlankBudgetInfo(info.getNd(), info.getBudgetType());
			//获取模板数据
			List<BudgetGroupTotal> templates = budgetGroupTotalService.selectBudgetInfoId(info.getDataId());
			for(BudgetGroupTotal total:templates) 
			{
				total.setBudgetInfoId(info.getDataId());
				total.setDataVersion(info.getDataVersion());
				total.setDataId(IdUtil.createIdByTime());
				total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				total.setRemark(info.getRemark());
				budgetGroupTotalService.saveOrUpdateBudgetGroupTotal(total);
			}
			
			System.out.println(JSON.toJSONString(newInfo));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
