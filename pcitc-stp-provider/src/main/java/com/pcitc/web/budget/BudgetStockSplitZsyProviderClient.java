package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

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
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetStockEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.BudgetStockTotal;
import com.pcitc.base.stp.budget.vo.BudgetSplitBaseDataVo;
import com.pcitc.base.stp.budget.vo.SplitItemVo;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.budget.BudgetStockSplitZsySplitService;
import com.pcitc.service.budget.BudgetStockTotalService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-年度预算（股份-直属院）分解表",tags= {"预算分解-年度股股预算分解表"})
@RestController
public class BudgetStockSplitZsyProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetStockSplitZsyProviderClient.class);
	
	@Autowired
	private BudgetStockSplitZsySplitService budgetStockSplitZsySplitService;
	
	@Autowired
	private BudgetStockTotalService budgetStockTotalService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="股份公司直属院预算分解-预算列表",notes="按年检索年度股份预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-stocksplit-zsy-info-list", method = RequestMethod.POST)
	public Object selectBudgetStockSplitInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-info-list...");
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> datalist = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			//获取股份预算总表中可用分配数（审批通过的股份预算,从预算项中获取直属院的预算数）
			BudgetInfo finalBudgetInfo = budgetInfoService.selectFinalBudget(info.getNd(),BudgetInfoEnum.STOCK_TOTAL.getCode());
			for(BudgetInfo dt:datalist) {
				if(finalBudgetInfo !=null) {
					List<BudgetStockTotal> totals = budgetStockTotalService.selectItemsByBudgetId(finalBudgetInfo.getDataId());
					Optional<BudgetStockTotal> rs = totals.stream()
							.filter(a -> BudgetStockEnum.SPLIT_STOCK_YJY.getCode().equals(a.getDisplayCode()))
							.filter(a -> new Integer(0).equals(a.getLevel()))
							.findFirst();
					if(rs != null && rs.isPresent()) {
						//dt.setBudgetMoney(rs.get().getXmjfTotal());
						dt.setBudgetMoney(rs.get().getXmjfFyx());
					}
				}
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
	@ApiOperation(value="股份公司直属院预算分解-预算列表",notes="按年分页检索年度股份预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-stocksplit-zsy-info-table", method = RequestMethod.POST)
	public Object selectBudgetStockSplitInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-grouptotal-info-list...");
		LayuiTableData data = null;
		try
		{
			param.getParam().put("budget_type", BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			data = budgetInfoService.selectBudgetInfoPage(param);
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="股份公司直属院预算分解-预算表信息检索",notes="检索预算表信息")
	@RequestMapping(value = "/stp-provider/budget/budget-stocksplit-zsy-info", method = RequestMethod.POST)
	public Object selectAssetSplitInfo(@RequestBody String budgetInfoId) 
	{
		BudgetInfo info = null;
		try
		{
			info = budgetInfoService.selectBudgetInfo(budgetInfoId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return info;
	}
	@ApiOperation(value="股份公司直属院预算分解-创建股份年度预算",notes="创建股份年度预算空白预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-stocksplit-zsy", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-stocksplit-zsy...");
		BudgetInfo rsbean = null;
		try
		{
			info.setBudgetType(BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(),info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsbean;
	}
	
	@ApiOperation(value="股份公司直属院预算分解-预算明细检索",notes="检索股份预算分解明细列表数据")
	@RequestMapping(value = "/stp-provider/budget/budget-stocksplit-zsy-items", method = RequestMethod.POST)
	public Object selectAssetSplitItemTable(@RequestBody LayuiTableParam param) 
	{
		String dataId = param.getParam().get("budget_info_id").toString();
		logger.info("select-budget-stocksplit-zsy-items..."+dataId);
		LayuiTableData table = new LayuiTableData();
		List<Map<String,Object>> data = null;
		try
		{
			data =  budgetStockSplitZsySplitService.selectBudgetSplitDataList(dataId);
			data = budgetInfoService.filterDataByUnit(data, (String)param.getParam().get("unitCodes"));
			table.setData(data);
			table.setCount(data.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(table));
		return table;
	}
	@ApiOperation(value="股份公司直属院预算分解-预算明细标题",notes="定义股份预算分解表标题。")
	@RequestMapping(value = "/stp-provider/budget/budget-stocksplit-zsy-titles", method = RequestMethod.POST)
	public Object selectAssetSplitTableTitles(@RequestBody String nd) 
	{
		logger.info("select-budget-grouptotal-items..."+nd);
		List<Map<String,Object>> data = null;
		try
		{
			data =  budgetStockSplitZsySplitService.selectBudgetSplitTableTitles(nd);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@ApiOperation(value="股份公司直属院预算分解-预算明细标题",notes="定义股份预算历史数据分解表标题（往年和历年数据标题）。")
	@RequestMapping(value = "/stp-provider/budget/budget-stocksplit-zsy-history-titles", method = RequestMethod.POST)
	public Object selectAssetSplitTableHistoryTitles(@RequestBody String nd) 
	{
		logger.info("budget-stocksplit-zsy-history-titles..."+nd);
		Map<String,List<SplitItemVo>> data = null;
		try
		{
			data =  budgetStockSplitZsySplitService.selectBudgetSplitHistoryTableTitles(nd);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="股份公司直属院预算-保存年度预算项详情",notes="保存预算项不包括子项")
	@RequestMapping(value = "/stp-provider/budget/save-stocksplit-zsy-item", method = RequestMethod.POST)
	public Object saveBudgetStockSplitItem(@RequestBody String item) 
	{
		logger.info("budget-save-stocksplit-zsy-item...");
		Integer rs = 0;
		try
		{
			List<BudgetSplitData> datas = budgetStockSplitZsySplitService.saveBudgetSplitDataItem(item);
			rs = datas.size();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="股份公司直属院预算-保存年度预算项详情",notes="保存预算项不包括子项")
	@RequestMapping(value = "/stp-provider/budget/save-stocksplit-zsy-items", method = RequestMethod.POST)
	public Object saveBudgetStockSplitItems(@RequestBody String items) 
	{
		logger.info("budget-save-stocksplit-zsy-items...");
		Integer rs = 0;
		try
		{
			List<BudgetSplitData> datas = budgetStockSplitZsySplitService.saveBudgetSplitDataItems(items);
			rs = datas.size();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="股份公司直属院预算-删除股份年度预算",notes="删除股份年度预算表（逻辑删除）")
	@RequestMapping(value = "/stp-provider/budget/budget-stocksplit-zsy-del", method = RequestMethod.POST)
	public Object deleteBudgetGroupTotalInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-delete-grouptotal...");
		Integer rs = 0;
		try
		{
			rs += budgetInfoService.deleteBudgetInfo(info.getDataId());
			rs += budgetStockSplitZsySplitService.deleteBudgetSplitDataByInfo(info.getDataId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="股份公司直属院预算分解-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-stocksplit-zsy-item", method = RequestMethod.POST)
	public Object selectBudgetGroupTotalItem(@RequestBody BudgetSplitBaseDataVo vo) 
	{
		logger.info("get-stocksplit-zsy-item...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			map = budgetStockSplitZsySplitService.selectAssetSplitItem(vo.getBudgetInfoId(),vo.getOrganCode());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="股份公司直属院预算分解-检索预算项历史数据",notes="检索预算项历史数据列表")
	@RequestMapping(value = "/stp-provider/budget/get-stocksplit-zsy-history-items", method = RequestMethod.POST)
	public Object selectBudgetStockSplitHistoryItems(@RequestBody BudgetSplitBaseDataVo vo) 
	{
		List<Object> rslist = new ArrayList<Object>();
		try
		{
			List<BudgetInfo> infos = budgetInfoService.selectFinalBudgetInfoList(BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			for(BudgetInfo info:infos) {
				//System.out.println("nd:"+info.getNd()+"  organCode:"+vo.getOrganCode());
				rslist.add(budgetStockSplitZsySplitService.selectAssetSplitFinalItem(info.getNd(),vo.getOrganCode()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rslist;
	}
	@ApiOperation(value="股份公司直属院预算分解-检索预算项历年数据",notes="检索预算项历年数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-stocksplit-zsy-final-history-list", method = RequestMethod.POST)
	public Object selectBudgetStockFinalHistoryList() 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> rs = budgetInfoService.selectFinalBudgetInfoList(BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			for(BudgetInfo info:rs) {
				Map<String,Object> map  = MyBeanUtils.transBean2Map(info);
				List<Map<String,Object>> items =  budgetStockSplitZsySplitService.selectBudgetSplitDataList(info.getDataId());
				map.put("items", items);
				rsmap.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsmap;
	}
}
