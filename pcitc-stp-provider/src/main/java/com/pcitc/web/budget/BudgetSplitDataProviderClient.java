package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.service.budget.BudgetAssetSplitService;
import com.pcitc.service.budget.BudgetGroupSplitService;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.budget.BudgetStockSplitXtwSplitService;
import com.pcitc.service.budget.BudgetStockSplitZgsSplitService;
import com.pcitc.service.budget.BudgetStockSplitZsySplitService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-分解表数据",tags= {"预算-数据分解业务逻辑处理"})
@RestController
public class BudgetSplitDataProviderClient 
{
	@Autowired
	private BudgetStockSplitXtwSplitService budgetStockSplitXtwSplitService;
	
	@Autowired
	private BudgetStockSplitZgsSplitService budgetStockSplitZgsSplitService;
	
	@Autowired
	private BudgetStockSplitZsySplitService budgetStockSplitZsySplitService;
	
	@Autowired
	private BudgetGroupSplitService budgetGroupSplitService;
	
	@Autowired
	private BudgetAssetSplitService budgetAssetSplitService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="预算分解总表-集团预算分解总表",notes="集团预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-groupsplit", method = RequestMethod.POST)
	public Object selectBudgetGroupSplitDataList(@RequestBody BudgetInfo info) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			//最终预算
			BudgetInfo fInfo = budgetInfoService.selectFinalBudget(info.getNd(),BudgetInfoEnum.GROUP_SPLIT.getCode());
			if(fInfo == null) {
				fInfo = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.GROUP_SPLIT.getCode()).get(0);
			}
			List<Map<String,Object>> list = budgetGroupSplitService.selectBudgetSplitDataList(fInfo == null?"xxx":fInfo.getDataId());
			
			for(int i = 0;i<list.size();i++) {
				Map<String,Object> rowmap = new HashMap<String,Object>();
				rowmap.put("no", list.get(i).get("no"));
				rowmap.put("organCode", list.get(i).get("organCode"));
				rowmap.put("organName", list.get(i).get("organName"));
				rowmap.put("group_jz", (Double)list.get(i).get("total_jz"));
				rowmap.put("group_xq", (Double)list.get(i).get("total_xq"));
				rowmap.put("group_total", (Double)list.get(i).get("total"));
			
				rsdata.add(rowmap);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="预算分解总表-资产预算分解总表",notes="资产预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-assetsplit", method = RequestMethod.POST)
	public Object selectBudgetAssetSplitDataList(@RequestBody BudgetInfo info) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			//最终预算
			BudgetInfo fInfo = budgetInfoService.selectFinalBudget(info.getNd(),BudgetInfoEnum.ASSET_SPLIT.getCode());
			if(fInfo == null) {
				fInfo = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.ASSET_SPLIT.getCode()).get(0);
			}
			
			
			List<Map<String,Object>> list = budgetAssetSplitService.selectBudgetSplitDataList(fInfo == null?"xxx":fInfo.getDataId());
			for(int i = 0;i<list.size();i++) {
				Map<String,Object> rowmap = new HashMap<String,Object>();
				rowmap.put("no", list.get(i).get("no"));
				rowmap.put("organCode", list.get(i).get("organCode"));
				rowmap.put("organName", list.get(i).get("organName"));
				rowmap.put("asset_jz", (Double)list.get(i).get("total_jz"));
				rowmap.put("asset_xq", (Double)list.get(i).get("total_xq"));
				rowmap.put("asset_total", (Double)list.get(i).get("total"));
			
				rsdata.add(rowmap);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="预算分解总表-股份预算分解总表",notes="股份预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-stocksplit", method = RequestMethod.POST)
	public Object selectBudgetStockSplitDataList(@RequestBody BudgetInfo info) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			BudgetInfo xtwInfo = budgetInfoService.selectFinalBudget(info.getNd(),BudgetInfoEnum.STOCK_XTY_SPLIT.getCode());
			BudgetInfo zgsInfo = budgetInfoService.selectFinalBudget(info.getNd(),BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode());
			BudgetInfo zsyInfo = budgetInfoService.selectFinalBudget(info.getNd(),BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			if(xtwInfo == null) {
				xtwInfo = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.STOCK_XTY_SPLIT.getCode()).get(0);
			}if(zgsInfo == null) {
				zgsInfo = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode()).get(0);
			}if(zsyInfo == null) {
				zsyInfo = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode()).get(0);
			}
			
			List<Map<String,Object>> xtw = budgetStockSplitXtwSplitService.selectBudgetSplitDataList(xtwInfo==null?"xxx":xtwInfo.getDataId());
			List<Map<String,Object>> zgs = budgetStockSplitZgsSplitService.selectBudgetSplitDataList(zgsInfo == null?"xxx":zgsInfo.getDataId());
			List<Map<String,Object>> zsy = budgetStockSplitZsySplitService.selectBudgetSplitDataList(zsyInfo == null?"xxx":zsyInfo.getDataId());
			for(int i = 0;i<xtw.size();i++) {
				Map<String,Object> rowmap = new HashMap<String,Object>();
				rowmap.put("no", xtw.get(i).get("no"));
				rowmap.put("organCode", xtw.get(i).get("organCode"));
				rowmap.put("organName", xtw.get(i).get("organName"));
				rowmap.put("stock_jz", (Double)xtw.get(i).get("total_jz")+(Double)zgs.get(i).get("total_jz")+(Double)zsy.get(i).get("total_jz"));
				rowmap.put("stock_xq", (Double)xtw.get(i).get("total_xq")+(Double)zgs.get(i).get("total_xq")+(Double)zsy.get(i).get("total_xq"));
				rowmap.put("stock_total", (Double)xtw.get(i).get("total")+(Double)zgs.get(i).get("total")+(Double)zsy.get(i).get("total"));
			
				rsdata.add(rowmap);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	
	
}
