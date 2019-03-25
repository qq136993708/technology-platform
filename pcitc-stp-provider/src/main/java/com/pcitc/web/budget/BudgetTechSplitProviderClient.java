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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetItemTypeEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetTechSplit;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.common.BudgetInfoEnum;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.budget.BudgetTechSplitService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-专项经费",tags= {"预算-专项经费预算表"})
@RestController
public class BudgetTechSplitProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetTechSplitProviderClient.class);
	private final static String WORKFLOW_DEFINE_ID = "xxxx:x:xxxxx";
	
	@Autowired
	private BudgetTechSplitService budgetTechSplitService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="专项预算-预算列表",notes="按年检索年度专项预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-techsplit-info-list", method = RequestMethod.POST)
	public Object selectBudgetTechSplitInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-info-list...");
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			
			List<BudgetInfo> datalist = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.TECH_SPLIT.getCode());
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
	@ApiOperation(value="专项预算-预算列表",notes="按年分页检索年度专项预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-techsplit-info-table", method = RequestMethod.POST)
	public Object selectBudgetTechSplitInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-techsplit-info-list...");
		LayuiTableData data = null;
		try
		{
			param.getParam().put("budget_type", BudgetInfoEnum.TECH_SPLIT.getCode());
			data = budgetInfoService.selectBudgetInfoPage(param);
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="专项预算-预算表信息检索",notes="检索预算表信息")
	@RequestMapping(value = "/stp-provider/budget/budget-techsplit-info", method = RequestMethod.POST)
	public Object selectTechSplitInfo(@RequestBody String budgetInfoId) 
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
	
	@ApiOperation(value="专项预算-预算明细检索",notes="检索专项预算表明细信息（分页列表）。")
	@RequestMapping(value = "/stp-provider/budget/budget-techsplit-items", method = RequestMethod.POST)
	public Object selectTechSplitItemTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("select-budget-techsplit-items...");
		LayuiTableData data = null;
		try
		{
			data = budgetTechSplitService.selectBudgetTechSplitPage(param);

			System.out.println(JSON.toJSONString(data));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@ApiOperation(value="专项预算-持久化预算项",notes="添加或更新专项预算表项目。")
	@RequestMapping(value = "/stp-provider/budget/budget-persistence-techsplit-item", method = RequestMethod.POST)
	public Object addOrUpdateTechSplitItem(@RequestBody BudgetTechSplit budgetTechSplit) 
	{
		logger.info("add-budget-techsplit-item...");
		Integer rs = 0;
		try
		{
			rs = budgetTechSplitService.saveOrUpdateBudgetTechSplit(budgetTechSplit);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="专项预算-创建专项年度预算",notes="创建专项年度预算空白预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-techsplit", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-techsplit...");
		BudgetInfo rsbean = null;
		try
		{
			info.setBudgetType(BudgetInfoEnum.TECH_SPLIT.getCode());
			rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(),info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsbean;
	}
	@ApiOperation(value="专项预算-创建专项年度预算表",notes="根据模板创建专项年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-template-techsplit", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfoByHis(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-template-techsplit...");
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
			List<BudgetTechSplit> templates = budgetTechSplitService.selectBudgetTechSplitByInfoId(info.getDataId());
			Map<String,String> idRel = new HashMap<String,String>();//新老ID对照
			for(BudgetTechSplit total:templates) 
			{
				String newId = IdUtil.createIdByTime();
				idRel.put(total.getDataId(), newId);
				
				total.setBudgetInfoId(newInfo.getDataId());
				total.setDataVersion(newInfo.getDataVersion());
				total.setNd(newInfo.getNd());
				total.setDataId(newId);
				total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetTechSplitService.saveOrUpdateBudgetTechSplit(total);
			}
			//处理二级预算单位
			templates = budgetTechSplitService.selectBudgetTechSplitByInfoId(newInfo.getDataId());
			for(BudgetTechSplit total:templates) 
			{
				if(total.getLevel()>0 && total.getParentDataId() != null) {
					total.setParentDataId(idRel.get(total.getParentDataId()));
					budgetTechSplitService.updateBudgetTechSplit(total);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newInfo;
	}
	@ApiOperation(value="专项预算-删除专项年度预算",notes="删除专项年度预算表（逻辑删除）")
	@RequestMapping(value = "/stp-provider/budget/budget-techsplit-del", method = RequestMethod.POST)
	public Object deleteBudgetTechSplitInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-techsplit-del...");
		Integer rs = 0;
		try
		{
			rs += budgetInfoService.deleteBudgetInfo(info.getDataId());
			rs += budgetTechSplitService.deleteBudgetTechSplitByInfo(info.getDataId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="专项预算-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-techsplit-item/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetTechSplitItem(@PathVariable("itemId") String itemId) 
	{
		logger.info("get-techsplit-item...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			BudgetTechSplit groupTotal = budgetTechSplitService.selectBudgetTechSplit(itemId);
			if(groupTotal != null) {
				List<BudgetTechSplit> childStocks = budgetTechSplitService.selectChildBudgetTechSplit(itemId);
				List<Map<String,Object>> groupMaps = new ArrayList<Map<String,Object>>();
				for(BudgetTechSplit total:childStocks) {
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
	@ApiOperation(value="专项预算-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-techsplit-item-company/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetTechSplitCompanyItem(@PathVariable("itemId") String itemId) 
	{
		logger.info("get-techsplit-item-company...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			BudgetTechSplit groupTotal = budgetTechSplitService.selectBudgetTechSplit(itemId);
			if(groupTotal != null) {
				List<BudgetTechSplit> childStocks = budgetTechSplitService.selectBudgetTechSplitCompanyItem(itemId);
				List<Map<String,Object>> groupMaps = new ArrayList<Map<String,Object>>();
				for(BudgetTechSplit total:childStocks) {
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
	@ApiOperation(value="专项预算-保存年度预算项详情",notes="保存预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/save-techsplit-item", method = RequestMethod.POST)
	public Object saveBudgetTechSplitInfo(@RequestBody BudgetTechSplit item) 
	{
		logger.info("budget-save-techsplit...");
		System.out.println(JSON.toJSONString(item));
		BudgetTechSplit stock = null;
		try
		{
			BudgetInfo info = budgetInfoService.selectBudgetInfo(item.getBudgetInfoId());
			stock = budgetTechSplitService.selectBudgetTechSplit(item.getDataId());
			if(stock != null) {
				MyBeanUtils.copyPropertiesIgnoreNull(item, stock);
				stock.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetTechSplitService.updateBudgetTechSplit(stock);
			}else {
				stock = (BudgetTechSplit)MyBeanUtils.createDefaultModel(BudgetTechSplit.class);
				MyBeanUtils.copyPropertiesIgnoreNull(item, stock);
				stock.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				stock.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
				stock.setNd(info.getNd());
				stock.setLevel("0".equals(stock.getParentDataId())?0:1);//
				stock.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				stock.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				stock.setDataVersion(info.getDataVersion());
				budgetTechSplitService.saveOrUpdateBudgetTechSplit(stock);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return stock;
	}
	@ApiOperation(value="专项预算-保存年度预算项详情",notes="保存预算项不包括子项")
	@RequestMapping(value = "/stp-provider/budget/save-techsplit-items", method = RequestMethod.POST)
	public Object saveBudgetTechSplitItems(@RequestBody List<BudgetTechSplit> items) 
	{
		logger.info("budget-save-techsplit-items...");
		Integer rs = 0;
		try
		{
			Map<String,BudgetTechSplit> map = new HashMap<String,BudgetTechSplit>();
			for(BudgetTechSplit item:items) {
				map.put(item.getDataId(), item);
			}
			List<BudgetTechSplit> totals = budgetTechSplitService.selectBudgetTechSplitListByIds(new ArrayList<String>(map.keySet()));
			for(BudgetTechSplit total:totals) {
				BudgetTechSplit maptotal = map.get(total.getDataId());
				if(!JSON.toJSONString(maptotal).equals(JSON.toJSONString(total))) {
					rs += budgetTechSplitService.updateBudgetTechSplit(maptotal);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="专项预算-保存年度预算项详情",notes="保存预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/save-techsplit-childitems", method = RequestMethod.POST)
	public Object saveBudgetTechSplitChildItems(@RequestBody HashMap<String,Object> map) 
	{
		Integer rs = 0;
		try
		{
			BudgetTechSplit to = JSON.parseObject(map.get("item").toString(), BudgetTechSplit.class);
			//原有全部逻辑删除（包括已删除的）
			List<BudgetTechSplit> childlist = budgetTechSplitService.selectBudgetTechSplitCompanyItem(to.getDataId());
			Map<String,BudgetTechSplit> oldmap = new HashMap<String,BudgetTechSplit>();
			for(BudgetTechSplit t:childlist){
				budgetTechSplitService.deleteBudgetTechSplit(t.getDataId());
				oldmap.put(t.getDisplayName(), t);
			}
			//有则更新，无责保存
			List<BudgetTechSplit> totals = JSON.parseArray(map.get("items").toString(), BudgetTechSplit.class);
			for(BudgetTechSplit t:totals){
				if(oldmap.containsKey(t.getDisplayName())){
				
					BudgetTechSplit old = oldmap.get(t.getDisplayName());
					old.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					old.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				/*	old.setXmjfFyx(t.getXmjfFyx());
					old.setXmjfZbx(t.getXmjfZbx());
					old.setXmjfTotal(t.getXmjfTotal());
					old.setYjwcFyx(t.getYjwcFyx());
					old.setYjwcZbx(t.getYjwcZbx());
					old.setYjwcTotal(t.getYjwcTotal());*/
					old.setDisplayCode(t.getDisplayCode());
					budgetTechSplitService.updateBudgetTechSplit(old);
				}else{
					t.setDataId(IdUtil.createIdByTime());
					t.setDataVersion(to.getDataVersion());
					t.setNd(to.getNd());
					t.setLevel(to.getLevel()+1);
					t.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_COMPANY.getCode());
					t.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					budgetTechSplitService.saveOrUpdateBudgetTechSplit(t);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="专项预算-检索专项公司",notes="检索专项公司列表")
	@RequestMapping(value = "/stp-provider/budget/search-tech-company-items", method = RequestMethod.POST)
	public Object selectBudgetStockCompanyItems() 
	{
		logger.info("search-group-items...");
		List<OutUnit> units = null;
		try
		{
			units = budgetTechSplitService.selectTechCompnays();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return units;
	}
	@ApiOperation(value="专项预算-检索专项公司",notes="检索专项公司树")
	@RequestMapping(value = "/stp-provider/budget/search-tech-company-tree", method = RequestMethod.POST)
	public Object selectBudgetStockCompanyTree() 
	{
		logger.info("search-group-items...");
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		try
		{
			List<OutUnit> units = budgetTechSplitService.selectTechCompnays();
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
	@ApiOperation(value="专项预算-删除预算项详情",notes="删除专项预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/del-techsplit-item/{dataId}", method = RequestMethod.POST)
	public Object deleteBudgetTechSplitInfo(@PathVariable("dataId") String dataId) 
	{
		logger.info("budget-delete-techsplit-item...");
		Integer rs = 0;
		try
		{
			BudgetTechSplit groupTotal = budgetTechSplitService.selectBudgetTechSplit(dataId);
			if(groupTotal != null) {
				List<BudgetTechSplit> childStocks = budgetTechSplitService.selectChildBudgetTechSplit(dataId);
				for(BudgetTechSplit total:childStocks) 
				{
					rs += budgetTechSplitService.deleteBudgetTechSplit(total.getDataId());
				}
				rs += budgetTechSplitService.deleteBudgetTechSplit(dataId);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="专项预算-检索预算项历史数据",notes="检索预算项历史数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-techsplit-history-items", method = RequestMethod.POST)
	public Object selectBudgetTechSplitItemHistory(@RequestBody BudgetTechSplit item) 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetTechSplit> rs = budgetTechSplitService.selectTechSplitHistoryItems(item);
			for(BudgetTechSplit total:rs) {
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
	@ApiOperation(value="专项预算-检索预算项历年数据",notes="检索预算项历年数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-techsplit-final-history-list", method = RequestMethod.POST)
	public Object selectBudgetStockFinalHistoryList() 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> rs = budgetInfoService.selectFinalBudgetInfoList(BudgetInfoEnum.TECH_SPLIT.getCode());
			for(BudgetInfo info:rs) {
				LayuiTableParam param = new LayuiTableParam(1,100);
				param.getParam().put("budget_info_id",info.getDataId());
				LayuiTableData rsdata = budgetTechSplitService.selectBudgetTechSplitPage(param);
				
				//List<BudgetTechSplit> totals = budgetTechSplitService.selectBudgetTechSplitByInfoId(info.getDataId());
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
	@ApiOperation(value="专项预算-获取计划参考数据",notes="检索专项公司年度计划金额")
	@RequestMapping(value = "/stp-provider/budget/select-techsplit-compare-plan", method = RequestMethod.POST)
	public Object selectBudgetStockItemComparePlan(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectPlan> plans = new ArrayList<OutProjectPlan>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectPlan>> planMap = budgetTechSplitService.selectComparePlanData(codes,nd);
			
			List<OutProjectPlan> rs = planMap.get(code);
			if(rs != null && rs.size() >0 ) {
				plans.addAll(rs);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return plans;
	}
	@ApiOperation(value="专项预算-获取计划参考数据",notes="检索专项公司年度计划金额")
	@RequestMapping(value = "/stp-provider/budget/select-techsplit-compare-project", method = RequestMethod.POST)
	public Object selectBudgetStockItemCompareProject(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectInfo> plans = new ArrayList<OutProjectInfo>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectInfo>> planMap = budgetTechSplitService.selectCompareProjectInfoData(codes,nd);
			List<OutProjectInfo> rs = planMap.get(code);
			if(rs != null && rs.size() >0 ) {
				plans.addAll(rs);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return plans;
	}
	@ApiOperation(value="专项预算-专项预算审批",notes="发起专项预算表审批")
	@RequestMapping(value = "/stp-provider/budget/start-budget-techsplit-activity/{budgetInfoId}", method = RequestMethod.POST)
	public Object startBudgetTechSplitActivity(@PathVariable("budgetInfoId") String budgetInfoId,@RequestBody WorkflowVo workflowVo) 
	{
		
		BudgetInfo info = null;
		try {
			info = budgetInfoService.selectBudgetInfo(budgetInfoId);
		
			//如果审批已发起则不能再次发起(只有编制中，获取审批驳回可再发起)
			if(!(BudgetAuditStatusEnum.AUDIT_STATUS_NO_START.getCode().equals(info.getAuditStatus()) || BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode().equals(info.getAuditStatus())))
			{
				return new Result(false,"审批中或者已完成审批不可重复发起！");
			}
			//workflowVo.setAuthenticatedUserId("111");
			workflowVo.setProcessDefineId(WORKFLOW_DEFINE_ID); 
			workflowVo.setBusinessId(info.getDataId());
			workflowVo.setProcessInstanceName("专项预算表审批："+info.getDataVersion());
			Map<String, Object> variables = new HashMap<String, Object>();  
			//starter为必填项。流程图的第一个节点待办人变量必须为starter
	        variables.put("starter", workflowVo.getAuthenticatedUserId());
	        
	        //必须设置。流程中，需要的第二个节点的指派人；除starter外，所有待办人变量都指定为auditor(处长审批)
	        //处长审批 ZSH_JTZSZYC_GJHZC_CZ
	        List<SysUser> users = systemRemoteClient.selectUsersByPostCode("ZSH_JTZSZYC_GJHZC_CZ");
	        System.out.println("start userIds ... "+JSON.toJSONString(users));
	        variables.put("auditor", workflowVo.getAuthenticatedUserId());
	        if(users != null && users.size()>0) {
	        	variables.put("auditor", users.get(0).getUserId());
	        }
	        //必须设置，统一流程待办任务中需要的业务详情
	        variables.put("auditDetailsPath", "/budget/notice_view?noticeId="+info.getDataId());
	        //流程完全审批通过时，调用的方法（通过版本即为当前预算最终版本）
	        variables.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-techsplit-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
	        //流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
	        variables.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-techsplit-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
	        
	        workflowVo.setVariables(variables);
			String rs = systemRemoteClient.startWorkflowByProcessDefinitionId(workflowVo);
			System.out.println("startwork  rs...."+rs);
			if("true".equals(rs)) 
			{
				info.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_START.getCode());
				budgetInfoService.updateBudgetInfo(info);
				return new Result(true,"操作成功!");
			}else {
				return new Result(false,rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(false);
	}
	@ApiOperation(value="专项预算-审批流程回调通知",notes="审批结果回调通知")
	@RequestMapping(value = "/stp-provider/budget/callback-workflow-techsplit-notice")
	public Object callBackProjectNoticeWorkflow(@RequestParam(value = "budgetId", required = true) String budgetId,
			@RequestParam(value = "workflow_status", required = true) Integer workflow_status) throws Exception 
	{
		if(budgetId != null) {
			BudgetInfo info = budgetInfoService.selectBudgetInfo(budgetId);
			if(info != null) {
				//将当年的其他值设置为审批通过
				List<BudgetInfo> infos = budgetInfoService.selectBudgetInfoList(info.getNd(), info.getBudgetType());
				for(BudgetInfo i:infos) {
					//最终版本只有一个，多次审批后以最后一次审批为准
					if(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode().equals(i.getAuditStatus())) {
						i.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_PASS.getCode());
						budgetInfoService.updateBudgetInfo(i);
					}
				}
				info.setAuditStatus(workflow_status);
				budgetInfoService.updateBudgetInfo(info);
			}
		}
		return null;
	}
	@ApiOperation(value="专项预算-检索预算项",notes="检索预算项树形数据")
	@RequestMapping(value = "/stp-provider/budget/search-techitem-tree")
	public Object searchStockitemTree(@RequestBody String budgetId) throws Exception 
	{
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		try
		{
			TreeNode root = new TreeNode();
			root.setId("0");
			root.setLevelCode(-1);
			root.setName("专项公司");
			nodes.add(root);
			List<BudgetTechSplit> totals = budgetTechSplitService.selectItemsByBudgetId(budgetId);
			for(BudgetTechSplit total:totals) {
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
	@ApiOperation(value="专项预算-获取指定年度最终预算表",notes="获取指定年度最终预算表信息及列表")
	@RequestMapping(value = "/stp-provider/budget/get-final-techsplit", method = RequestMethod.POST)
	public Object selectFinalTechSplitInfo(@RequestBody String nd) throws Exception 
	{
		BudgetInfo info = budgetInfoService.selectFinalBudget(nd, BudgetInfoEnum.TECH_SPLIT.getCode());
		Map<String,Object> rsmap = new HashMap<String,Object>();
		if(info != null) {
			rsmap = MyBeanUtils.transBean2Map(info);
			List<BudgetTechSplit> totals = budgetTechSplitService.selectItemsByBudgetId(info.getDataId());
			Double items_total = 0d;
			for(BudgetTechSplit total:totals) {
				items_total += total.getTotal();
			}
			rsmap.put("items", totals);
			rsmap.put("items_total", items_total);
		}else {
			rsmap.put("items", new ArrayList<BudgetTechSplit>());
			rsmap.put("items_total", 0);
		}
		return rsmap;
	}
}
