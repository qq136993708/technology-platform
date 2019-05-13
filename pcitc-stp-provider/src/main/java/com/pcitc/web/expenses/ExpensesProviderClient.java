package com.pcitc.web.expenses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.expenses.ExpensesBills;
import com.pcitc.base.stp.expenses.ExpensesBillsApproves;
import com.pcitc.base.stp.expenses.ExpensesBillsItem;
import com.pcitc.base.stp.expenses.ExpensesBillsPay;
import com.pcitc.service.expenses.ExpensesService;

@Api(value = "经费报销相关接口", tags = { "经费报销相关接口" })
@RestController
public class ExpensesProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(ExpensesProviderClient.class);

	@Autowired
	private ExpensesService expensesService;

	@ApiOperation(value = "查询最大的更新时间", notes = "update_date字段")
	@RequestMapping(value = "/expenses/max-date/update", method = RequestMethod.POST)
	public String selectMaxUpdate() throws Exception {
		System.out.println("selectMaxUpdate==================");
		
		String updateDate = expensesService.selectMaxUpdate();
		return updateDate;
	}
	
	@ApiOperation(value = "批量保存费用报销数据", notes = "审批信息、费用信息等")
	@RequestMapping(value = "/expenses/add", method = RequestMethod.POST)
	public JSONObject saveExpenses(@RequestBody String jsonStr) throws Exception {
		System.out.println("saveExpenses==================" + jsonStr);
		JSONObject json = JSONObject.parseObject(jsonStr);
		JSONArray apprArray = json.getJSONArray("apprList");
		List<ExpensesBillsApproves> apprList = new ArrayList<ExpensesBillsApproves>();
		for (int i = 0; i < apprArray.size(); i++) {
			JSONObject temJson = apprArray.getJSONObject(i);
			ExpensesBillsApproves opri = JSON.toJavaObject(temJson,ExpensesBillsApproves.class);
			apprList.add(opri);
		}
		// 转换出点bug，先删除再添加
		json.remove("apprList");
		
		JSONArray payArray = json.getJSONArray("payList");
		List<ExpensesBillsPay> payList = new ArrayList<ExpensesBillsPay>();
		for (int i = 0; i < payArray.size(); i++) {
			JSONObject temJson = payArray.getJSONObject(i);
			ExpensesBillsPay opri = JSON.toJavaObject(temJson,ExpensesBillsPay.class);
			payList.add(opri);
		}
		// 转换出点bug，先删除再添加
		json.remove("payList");
		
		JSONArray itemArray = json.getJSONArray("itemList");
		List<ExpensesBillsItem> itemList = new ArrayList<ExpensesBillsItem>();
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject temJson = itemArray.getJSONObject(i);
			ExpensesBillsItem opri = JSON.toJavaObject(temJson,ExpensesBillsItem.class);
			itemList.add(opri);
		}
		// 转换出点bug，先删除再添加
		json.remove("itemList");
		
		ExpensesBills expensesBills = JSON.toJavaObject(json,ExpensesBills.class);
		expensesBills.setItemList(itemList);
		expensesBills.setApprList(apprList);
		expensesBills.setPayList(payList);
		
		JSONObject result = new JSONObject();
		result.put("resCode", "0");
		result.put("resMsg", "success");
		result.put("total", "1");
		result.put("result", "");
		return result;

	}

}
