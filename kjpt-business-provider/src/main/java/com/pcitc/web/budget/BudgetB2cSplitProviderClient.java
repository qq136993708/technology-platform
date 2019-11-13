package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetItemTypeEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetB2cSplit;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetB2cSplitService;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-炼油事业部、化工事业部",tags= {"预算-炼油事业部、化工事业部B2、C类科技经费预算表"})
@RestController
public class BudgetB2cSplitProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetB2cSplitProviderClient.class);
	
	
	@Autowired
	private BudgetB2cSplitService budgetB2cSplitService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="事业部预算-预算列表",notes="按年检索年度事业部预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-b2csplit-info-list", method = RequestMethod.POST)
	public Object selectBudgetB2cSplitInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-info-list...");
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			
			List<BudgetInfo> datalist = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.B2C_SPLIT.getCode());
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
	@ApiOperation(value="事业部预算-预算列表",notes="按年分页检索年度事业部预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-b2csplit-info-table", method = RequestMethod.POST)
	public Object selectBudgetB2cSplitInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-b2csplit-info-list...");
		LayuiTableData data = null;
		try
		{
			param.getParam().put("budget_type", BudgetInfoEnum.B2C_SPLIT.getCode());
			data = budgetInfoService.selectBudgetInfoPage(param);
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="事业部预算-预算表信息检索",notes="检索预算表信息")
	@RequestMapping(value = "/stp-provider/budget/budget-b2csplit-info", method = RequestMethod.POST)
	public Object selectB2cSplitInfo(@RequestBody String budgetInfoId) 
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
	
	@ApiOperation(value="事业部预算-预算明细检索",notes="检索事业部预算表明细信息（分页列表）。")
	@RequestMapping(value = "/stp-provider/budget/budget-b2csplit-items", method = RequestMethod.POST)
	public Object selectB2cSplitItemTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("select-budget-b2csplit-items...");
		LayuiTableData data = null;
		try
		{
			data = budgetB2cSplitService.selectBudgetB2cSplitPage(param);

			System.out.println(JSON.toJSONString(data));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@ApiOperation(value="事业部预算-持久化预算项",notes="添加或更新事业部预算表项目。")
	@RequestMapping(value = "/stp-provider/budget/budget-persistence-b2csplit-item", method = RequestMethod.POST)
	public Object addOrUpdateB2cSplitItem(@RequestBody BudgetB2cSplit budgetB2cSplit) 
	{
		logger.info("add-budget-b2csplit-item...");
		Integer rs = 0;
		try
		{
			rs = budgetB2cSplitService.saveOrUpdateBudgetB2cSplit(budgetB2cSplit);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="事业部预算-创建事业部年度预算",notes="创建事业部年度预算空白预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-b2csplit", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-b2csplit...");
		BudgetInfo rsbean = null;
		try
		{
			info.setBudgetType(BudgetInfoEnum.B2C_SPLIT.getCode());
			rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(),info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsbean;
	}
	@ApiOperation(value="事业部预算-创建事业部年度预算表",notes="根据模板创建事业部年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-template-b2csplit", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfoByHis(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-template-b2csplit...");
		BudgetInfo newInfo = null;
		try
		{
			//System.out.println(JSON.toJSONString(info.getNd()));
			BudgetInfo oldInfo = budgetInfoService.selectBudgetInfo(info.getDataId());
			
			
			newInfo = budgetInfoService.createBlankBudgetInfo(info.getNd(),oldInfo);
			
			newInfo.setBudgetMoney(oldInfo.getBudgetMoney());
			newInfo.setNd(info.getNd());
			newInfo.setCreaterId(info.getCreaterId());
			newInfo.setCreaterName(info.getCreaterName());
			
			budgetInfoService.updateBudgetInfo(newInfo);
			//获取模板数据
			List<BudgetB2cSplit> templates = budgetB2cSplitService.selectBudgetB2cSplitByInfoId(info.getDataId());
			Map<String,String> idRel = new HashMap<String,String>();//新老ID对照
			for(BudgetB2cSplit total:templates) 
			{
				String newId = IdUtil.createIdByTime();
				idRel.put(total.getDataId(), newId);
				
				total.setBudgetInfoId(newInfo.getDataId());
				total.setDataVersion(newInfo.getDataVersion());
				total.setNd(newInfo.getNd());
				total.setDataId(newId);
				total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetB2cSplitService.saveOrUpdateBudgetB2cSplit(total);
			}
			//处理二级预算单位
			templates = budgetB2cSplitService.selectBudgetB2cSplitByInfoId(newInfo.getDataId());
			for(BudgetB2cSplit total:templates) 
			{
				if(total.getLevel()>0 && total.getParentDataId() != null) {
					total.setParentDataId(idRel.get(total.getParentDataId()));
					budgetB2cSplitService.updateBudgetB2cSplit(total);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newInfo;
	}
	@ApiOperation(value="事业部预算-删除事业部年度预算",notes="删除事业部年度预算表（逻辑删除）")
	@RequestMapping(value = "/stp-provider/budget/budget-b2csplit-del", method = RequestMethod.POST)
	public Object deleteBudgetB2cSplitInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-b2csplit-del...");
		Integer rs = 0;
		try
		{
			rs += budgetInfoService.deleteBudgetInfo(info.getDataId());
			rs += budgetB2cSplitService.deleteBudgetB2cSplitByInfo(info.getDataId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="事业部预算-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-b2csplit-item/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetB2cSplitItem(@PathVariable("itemId") String itemId) 
	{
		logger.info("get-b2csplit-item...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			BudgetB2cSplit groupTotal = budgetB2cSplitService.selectBudgetB2cSplit(itemId);
			if(groupTotal != null) {
				List<BudgetB2cSplit> childStocks = budgetB2cSplitService.selectChildBudgetB2cSplit(itemId);
				List<Map<String,Object>> groupMaps = new ArrayList<Map<String,Object>>();
				for(BudgetB2cSplit total:childStocks) {
					Map<String,Object> mp = MyBeanUtils.transBean2Map(total);
					map.put("last_year_end", 0);
					map.put("plan_money", 0);
					groupMaps.add(mp);
				}
				
				map  = MyBeanUtils.transBean2Map(groupTotal);
				map.put("groups", groupMaps);
				//map.put("total", new Double(map.get("yjwc").toString())+new Double(map.get("xmjf").toString()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="事业部预算-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-b2csplit-item-company/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetB2cSplitCompanyItem(@PathVariable("itemId") String itemId) 
	{
		logger.info("get-b2csplit-item-company...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			BudgetB2cSplit groupTotal = budgetB2cSplitService.selectBudgetB2cSplit(itemId);
			if(groupTotal != null) {
				List<BudgetB2cSplit> childStocks = budgetB2cSplitService.selectBudgetB2cSplitCompanyItem(itemId);
				List<Map<String,Object>> groupMaps = new ArrayList<Map<String,Object>>();
				for(BudgetB2cSplit total:childStocks) {
					Map<String,Object> mp = MyBeanUtils.transBean2Map(total);
					map.put("last_year_end", "无");
					map.put("plan_money", "无");
					groupMaps.add(mp);
				}
				map  = MyBeanUtils.transBean2Map(groupTotal);
				map.put("groups", groupMaps);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="事业部预算-保存年度预算项详情",notes="保存预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/save-b2csplit-item", method = RequestMethod.POST)
	public Object saveBudgetB2cSplitInfo(@RequestBody BudgetB2cSplit item) 
	{
		logger.info("budget-save-b2csplit...");
		BudgetB2cSplit stock = null;
		try
		{
			BudgetInfo info = budgetInfoService.selectBudgetInfo(item.getBudgetInfoId());
			stock = budgetB2cSplitService.selectBudgetB2cSplit(item.getDataId());
			if(stock != null) {
				MyBeanUtils.copyPropertiesIgnoreNull(item, stock);
				stock.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetB2cSplitService.updateBudgetB2cSplit(stock);
			}else {
				stock = (BudgetB2cSplit)MyBeanUtils.createDefaultModel(BudgetB2cSplit.class);
				MyBeanUtils.copyPropertiesIgnoreNull(item, stock);
				stock.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				stock.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
				stock.setNd(info.getNd());
				stock.setLevel("0".equals(stock.getParentDataId())?0:1);//
				stock.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				stock.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				stock.setDataVersion(info.getDataVersion());
				budgetB2cSplitService.saveOrUpdateBudgetB2cSplit(stock);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return stock;
	}
	@ApiOperation(value="事业部预算-保存年度预算项详情",notes="保存预算项不包括子项")
	@RequestMapping(value = "/stp-provider/budget/save-b2csplit-items", method = RequestMethod.POST)
	public Object saveBudgetB2cSplitItems(@RequestBody List<BudgetB2cSplit> items) 
	{
		logger.info("budget-save-b2csplit-items...");
		Integer rs = 0;
		try
		{
			Map<String,BudgetB2cSplit> map = new HashMap<String,BudgetB2cSplit>();
			for(BudgetB2cSplit item:items) {
				map.put(item.getDataId(), item);
			}
			List<BudgetB2cSplit> totals = budgetB2cSplitService.selectBudgetB2cSplitListByIds(new ArrayList<String>(map.keySet()));
			for(BudgetB2cSplit total:totals) {
				BudgetB2cSplit maptotal = map.get(total.getDataId());
				if(!JSON.toJSONString(maptotal).equals(JSON.toJSONString(total))) {
					rs += budgetB2cSplitService.updateBudgetB2cSplit(maptotal);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="事业部预算-保存年度预算项详情",notes="保存预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/save-b2csplit-childitems", method = RequestMethod.POST)
	public Object saveBudgetB2cSplitChildItems(@RequestBody HashMap<String,Object> map) 
	{
		Integer rs = 0;
		try
		{
			BudgetB2cSplit to = JSON.parseObject(map.get("item").toString(), BudgetB2cSplit.class);
			//原有全部逻辑删除（包括已删除的）
			List<BudgetB2cSplit> childlist = budgetB2cSplitService.selectBudgetB2cSplitCompanyItem(to.getDataId());
			Map<String,BudgetB2cSplit> oldmap = new HashMap<String,BudgetB2cSplit>();
			for(BudgetB2cSplit t:childlist){
				budgetB2cSplitService.deleteBudgetB2cSplit(t.getDataId());
				oldmap.put(t.getDisplayName(), t);
			}
			//有则更新，无责保存
			List<BudgetB2cSplit> totals = JSON.parseArray(map.get("items").toString(), BudgetB2cSplit.class);
			for(BudgetB2cSplit t:totals){
				if(oldmap.containsKey(t.getDisplayName())){
				
					BudgetB2cSplit old = oldmap.get(t.getDisplayName());
					old.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					old.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				/*	old.setXmjfFyx(t.getXmjfFyx());
					old.setXmjfZbx(t.getXmjfZbx());
					old.setXmjfTotal(t.getXmjfTotal());
					old.setYjwcFyx(t.getYjwcFyx());
					old.setYjwcZbx(t.getYjwcZbx());
					old.setYjwcTotal(t.getYjwcTotal());*/
					old.setDisplayCode(t.getDisplayCode());
					budgetB2cSplitService.updateBudgetB2cSplit(old);
				}else{
					t.setDataId(IdUtil.createIdByTime());
					t.setDataVersion(to.getDataVersion());
					t.setNd(to.getNd());
					t.setLevel(to.getLevel()+1);
					t.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_COMPANY.getCode());
					t.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					budgetB2cSplitService.saveOrUpdateBudgetB2cSplit(t);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="事业部预算-检索事业部公司",notes="检索事业部公司列表")
	@RequestMapping(value = "/stp-provider/budget/search-b2c-company-items", method = RequestMethod.POST)
	public Object selectBudgetStockCompanyItems() 
	{
		logger.info("search-group-items...");
		List<OutUnit> units = null;
		try
		{
			units = budgetB2cSplitService.selectB2cCompnays();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return units;
	}
	@ApiOperation(value="事业部预算-检索事业部公司",notes="检索事业部公司树")
	@RequestMapping(value = "/stp-provider/budget/search-b2c-company-tree", method = RequestMethod.POST)
	public Object selectBudgetStockCompanyTree() 
	{
		logger.info("search-group-items...");
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		try
		{
			List<OutUnit> units = budgetB2cSplitService.selectB2cCompnays();
			for(OutUnit unit:units) {
				TreeNode node = new TreeNode();
				node.setId(unit.getUnitCode());
				node.setpId(unit.getParentCode());
				node.setCode(unit.getUnitCode());
				node.setName(unit.getUnitName());
				nodes.add(node);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return nodes;
	}
	@ApiOperation(value="事业部预算-删除预算项详情",notes="删除事业部预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/del-b2csplit-item/{dataId}", method = RequestMethod.POST)
	public Object deleteBudgetB2cSplitInfo(@PathVariable("dataId") String dataId) 
	{
		logger.info("budget-delete-b2csplit-item...");
		Integer rs = 0;
		try
		{
			BudgetB2cSplit groupTotal = budgetB2cSplitService.selectBudgetB2cSplit(dataId);
			if(groupTotal != null) {
				List<BudgetB2cSplit> childStocks = budgetB2cSplitService.selectChildBudgetB2cSplit(dataId);
				for(BudgetB2cSplit total:childStocks) 
				{
					rs += budgetB2cSplitService.deleteBudgetB2cSplit(total.getDataId());
				}
				rs += budgetB2cSplitService.deleteBudgetB2cSplit(dataId);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="事业部预算-检索预算项历史数据",notes="检索预算项历史数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-b2csplit-history-items", method = RequestMethod.POST)
	public Object selectBudgetB2cSplitItemHistory(@RequestBody BudgetB2cSplit item) 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetB2cSplit> rs = budgetB2cSplitService.selectB2cSplitHistoryItems(item);
			for(BudgetB2cSplit total:rs) {
				Map<String,Object> map  = MyBeanUtils.transBean2Map(total);
				//map.put("total", new Double(map.get("yjwc").toString())+new Double(map.get("xmjf").toString()));
				rsmap.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsmap;
	}
	@ApiOperation(value="事业部预算-检索预算项历年数据",notes="检索预算项历年数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-b2csplit-final-history-list", method = RequestMethod.POST)
	public Object selectBudgetStockFinalHistoryList() 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> rs = budgetInfoService.selectFinalBudgetInfoList(BudgetInfoEnum.B2C_SPLIT.getCode());
			for(BudgetInfo info:rs) {
				LayuiTableParam param = new LayuiTableParam(1,100);
				param.getParam().put("budget_info_id",info.getDataId());
				LayuiTableData rsdata = budgetB2cSplitService.selectBudgetB2cSplitPage(param);
				
				//List<BudgetB2cSplit> totals = budgetB2cSplitService.selectBudgetB2cSplitByInfoId(info.getDataId());
				Map<String,Object> map  = MyBeanUtils.transBean2Map(info);
				map.put("items", rsdata.getData());
				rsmap.add(map);
			}
			System.out.println("-----");
			System.out.println(JSON.toJSONString(rsmap));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsmap;
	}
	@ApiOperation(value="事业部预算-获取计划参考数据",notes="检索事业部公司年度计划金额")
	@RequestMapping(value = "/stp-provider/budget/select-b2csplit-compare-plan", method = RequestMethod.POST)
	public Object selectBudgetStockItemComparePlan(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectPlan> plans = new ArrayList<OutProjectPlan>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectPlan>> planMap = budgetB2cSplitService.selectComparePlanData(codes,nd);
			
			List<OutProjectPlan> rs = planMap.get(code);
			if(rs != null && rs.size() >0 ) {
				plans.addAll(rs);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return plans;
	}
	@ApiOperation(value="事业部预算-获取计划参考数据",notes="检索事业部公司年度计划金额")
	@RequestMapping(value = "/stp-provider/budget/select-b2csplit-compare-project", method = RequestMethod.POST)
	public Object selectBudgetStockItemCompareProject(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectInfo> plans = new ArrayList<OutProjectInfo>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectInfo>> planMap = budgetB2cSplitService.selectCompareProjectInfoData(codes,nd);
			List<OutProjectInfo> rs = planMap.get(code);
			if(rs != null && rs.size() >0 ) {
				plans.addAll(rs);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return plans;
	}
	
	
	@ApiOperation(value="事业部预算-检索预算项",notes="检索预算项树形数据")
	@RequestMapping(value = "/stp-provider/budget/search-b2citem-tree")
	public Object searchStockitemTree(@RequestBody String budgetId) throws Exception 
	{
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		try
		{
			TreeNode root = new TreeNode();
			root.setId("0");
			root.setLevelCode(-1);
			root.setName("事业部公司");
			nodes.add(root);
			List<BudgetB2cSplit> totals = budgetB2cSplitService.selectItemsByBudgetId(budgetId);
			for(BudgetB2cSplit total:totals) {
				//只显示一级
				if(total.getLevel()>0) {
					continue;
				}
				TreeNode node = new TreeNode();
				node.setId(total.getDataId());
				node.setpId(root.getId());
				node.setLevelCode(0);
				node.setName(total.getDisplayName());
				nodes.add(node);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return nodes;
	}
	@ApiOperation(value="事业部预算-获取指定年度最终预算表",notes="获取指定年度最终预算表信息及列表")
	@RequestMapping(value = "/stp-provider/budget/get-final-b2csplit", method = RequestMethod.POST)
	public Object selectFinalB2cSplitInfo(@RequestBody String nd) throws Exception 
	{
		BudgetInfo info = budgetInfoService.selectFinalBudget(nd, BudgetInfoEnum.B2C_SPLIT.getCode());
		Map<String,Object> rsmap = new HashMap<String,Object>();
		if(info != null) {
			rsmap = MyBeanUtils.transBean2Map(info);
			List<BudgetB2cSplit> totals = budgetB2cSplitService.selectItemsByBudgetId(info.getDataId());
			Double items_total = 0d;
			for(BudgetB2cSplit total:totals) {
				items_total += total.getHgTotal();
			}
			rsmap.put("items", totals);
			rsmap.put("items_total", items_total);
		}else {
			rsmap.put("items", new ArrayList<BudgetB2cSplit>());
			rsmap.put("items_total", 0);
		}
		return rsmap;
	}
}
