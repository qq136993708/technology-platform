package com.pcitc.web.budget;

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
import com.pcitc.service.budget.BudGetGroupTotalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-年度预算（集团）总表",tags= {"预算-年度集团预算总表"})
@RestController
public class BudgetGroupTotalProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetGroupTotalProviderClient.class);

	
	@Autowired
	private BudGetGroupTotalService budGetGroupTotalService;
	
	
	@ApiOperation(value="预算检索",notes="按年检索年度集团预算总表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-group-total-list", method = RequestMethod.POST)
	public Object selectProjectPassAcceptList(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-group-total-list...");
		try
		{
			LayuiTableData data = budGetGroupTotalService.selectBudgetGroupTotalPage(param);
			System.out.println(JSON.toJSONString(data));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
