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

import org.apache.commons.lang.StringUtils;
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
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetAssetTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.common.BudgetInfoEnum;
import com.pcitc.service.budget.BudgetAssetTotalService;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-年度预算（资产）总表",tags= {"预算-年度资产公司预算总表"})
@RestController
public class BudgetAssetTotalProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetAssetTotalProviderClient.class);
	private final static String WORKFLOW_DEFINE_ID = "xxxx:x:xxxxx";
	
	@Autowired
	private BudgetAssetTotalService budgetAssetTotalService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="资产公司预算-预算列表",notes="按年检索年度资产预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-assettotal-info-list", method = RequestMethod.POST)
	public Object selectBudgetAssetTotalInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-info-list...");
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			
			List<BudgetInfo> datalist = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.ASSETS_TOTAL.getCode());
			System.out.println(JSON.toJSONString(datalist));
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
	@ApiOperation(value="资产公司预算-预算列表",notes="按年分页检索年度资产预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-assettotal-info-table", method = RequestMethod.POST)
	public Object selectBudgetAssetTotalInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-assettotal-info-list...");
		LayuiTableData data = null;
		try
		{
			param.getParam().put("budget_type", BudgetInfoEnum.ASSETS_TOTAL.getCode());
			data = budgetInfoService.selectBudgetInfoPage(param);
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="资产公司预算-预算表信息检索",notes="检索预算表信息")
	@RequestMapping(value = "/stp-provider/budget/budget-assettotal-info", method = RequestMethod.POST)
	public Object selectAssetTotalInfo(@RequestBody String budgetInfoId) 
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
	
	@ApiOperation(value="资产公司预算-预算明细检索",notes="检索资产预算表明细信息（分页列表）。")
	@RequestMapping(value = "/stp-provider/budget/budget-assettotal-items", method = RequestMethod.POST)
	public Object selectAssetTotalItemTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("select-budget-assettotal-items...");
		LayuiTableData data = null;
		try
		{
			data = budgetAssetTotalService.selectBudgetAssetTotalPage(param);
			//获取二级机构的计划数据
			List<BudgetAssetTotal> totals = budgetAssetTotalService.selectBudgetAssetTotalByInfoId(param.getParam().get("budget_info_id").toString());
			//map<dataId,Set<displayCode>>
			Map<String,Set<String>> itemMap = new HashMap<String,Set<String>>();
			Set<String> codes = new HashSet<String>();
			for(BudgetAssetTotal total:totals) {
				if(total.getLevel() > 0) {
					if(StringUtils.isNotBlank(total.getDisplayCode())) {
						codes.add(total.getDisplayCode());
					}
				}else {
					//一级item下包含的二级item列表
					itemMap.put(total.getDataId(), new HashSet<String>());
					for(BudgetAssetTotal t:totals) {
						if(t.getParentDataId() != null && t.getParentDataId().equals(total.getDataId())) {
							if(StringUtils.isNotBlank(t.getDisplayCode())) {
								itemMap.get(total.getDataId()).add(t.getDisplayCode());
							}
						}
					}
				}
			}
			String nd = param.getParam().get("nd").toString();
			//处理计划数据
			Map<String,List<OutProjectPlan>> planMap = budgetAssetTotalService.selectComparePlanData(codes,nd);
			for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) {
				Map<String,Object> map = (Map<String,Object>)iter.next();
				String dataId = map.get("dataId").toString();
				if(itemMap.get(dataId) != null && itemMap.get(dataId).size()>0) {
					Double ysjes = 0d;
					Set<String> codeset = itemMap.get(dataId);
					for(String code:codeset) 
					{
						List<OutProjectPlan> plans = planMap.get(code);
						if(plans != null && plans.size()>0) {
							for(OutProjectPlan plan:plans) {
								ysjes += new Double(plan.getYsje());
							}
						}
					}
					map.put("plan_money", ysjes.intValue());
				}else {
					map.put("plan_money", "无");
				}
			}
			//处理项目完成金额
			Map<String,List<OutProjectInfo>> projectMap = budgetAssetTotalService.selectCompareProjectInfoData(codes,(new Integer(nd)-1)+"");
			for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) {
				Map<String,Object> map = (Map<String,Object>)iter.next();
				String dataId = map.get("dataId").toString();
				if(itemMap.get(dataId) != null && itemMap.get(dataId).size()>0) {
					Double jhjes = 0d;
					Set<String> codeset = itemMap.get(dataId);
					for(String code:codeset) 
					{
						List<OutProjectInfo> plans = projectMap.get(code);
						if(plans != null && plans.size()>0) {
							for(OutProjectInfo plan:plans) {
								jhjes += new Double(plan.getYsje());
							}
						}
					}
					map.put("last_year_end", jhjes.intValue());
				}else {
					map.put("last_year_end", "无");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@ApiOperation(value="资产公司预算-持久化预算项",notes="添加或更新资产预算表项目。")
	@RequestMapping(value = "/stp-provider/budget/budget-persistence-assettotal-item", method = RequestMethod.POST)
	public Object addOrUpdateAssetTotalItem(@RequestBody BudgetAssetTotal budgetAssetTotal) 
	{
		logger.info("add-budget-assettotal-item...");
		Integer rs = 0;
		try
		{
			rs = budgetAssetTotalService.saveOrUpdateBudgetAssetTotal(budgetAssetTotal);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="资产公司预算-创建资产年度预算",notes="创建资产年度预算空白预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-assettotal", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-assettotal...");
		BudgetInfo rsbean = null;
		try
		{
			info.setBudgetType(BudgetInfoEnum.ASSETS_TOTAL.getCode());
			rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(),info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsbean;
	}
	@ApiOperation(value="资产公司预算-创建资产年度预算表",notes="根据模板创建资产年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-template-assettotal", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfoByHis(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-template-assettotal...");
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
			List<BudgetAssetTotal> templates = budgetAssetTotalService.selectBudgetAssetTotalByInfoId(info.getDataId());
			Map<String,String> idRel = new HashMap<String,String>();//新老ID对照
			for(BudgetAssetTotal total:templates) 
			{
				String newId = IdUtil.createIdByTime();
				idRel.put(total.getDataId(), newId);
				
				total.setBudgetInfoId(newInfo.getDataId());
				total.setDataVersion(newInfo.getDataVersion());
				total.setNd(newInfo.getNd());
				total.setDataId(newId);
				total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetAssetTotalService.saveOrUpdateBudgetAssetTotal(total);
			}
			//处理二级预算单位
			templates = budgetAssetTotalService.selectBudgetAssetTotalByInfoId(newInfo.getDataId());
			for(BudgetAssetTotal total:templates) 
			{
				if(total.getLevel()>0 && total.getParentDataId() != null) {
					total.setParentDataId(idRel.get(total.getParentDataId()));
					budgetAssetTotalService.updateBudgetAssetTotal(total);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newInfo;
	}
	@ApiOperation(value="资产公司预算-删除资产年度预算",notes="删除资产年度预算表（逻辑删除）")
	@RequestMapping(value = "/stp-provider/budget/budget-assettotal-del", method = RequestMethod.POST)
	public Object deleteBudgetAssetTotalInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-delete-assettotal...");
		Integer rs = 0;
		try
		{
			rs += budgetInfoService.deleteBudgetInfo(info.getDataId());
			rs += budgetAssetTotalService.deleteBudgetAssetTotalByInfo(info.getDataId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="资产公司预算-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-assettotal-item/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetAssetTotalItem(@PathVariable("itemId") String itemId) 
	{
		logger.info("budget-select-assettotal...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			BudgetAssetTotal groupTotal = budgetAssetTotalService.selectBudgetAssetTotal(itemId);
			if(groupTotal != null) {
				List<BudgetAssetTotal> childAssets = budgetAssetTotalService.selectChildBudgetAssetTotal(itemId);
				List<Map<String,Object>> groupMaps = new ArrayList<Map<String,Object>>();
				for(BudgetAssetTotal total:childAssets) {
					Map<String,Object> mp = MyBeanUtils.transBean2Map(total);
					map.put("last_year_end", 0);
					map.put("plan_money", 0);
					groupMaps.add(mp);
				}
				
				map  = MyBeanUtils.transBean2Map(groupTotal);
				map.put("groups", groupMaps);
				map.put("total", new Double(map.get("yjwc").toString())+new Double(map.get("xmjf").toString()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="资产公司预算-保存年度预算项详情",notes="保存预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/save-assettotal-item", method = RequestMethod.POST)
	public Object saveBudgetAssetTotalInfo(@RequestBody BudgetAssetTotal item) 
	{
		logger.info("budget-save-assettotal...");
		BudgetAssetTotal rs = null;
		try
		{
			BudgetInfo info = budgetInfoService.selectBudgetInfo(item.getBudgetInfoId());
			BudgetAssetTotal groupTotal = budgetAssetTotalService.selectBudgetAssetTotal(item.getDataId());
			if(groupTotal != null) {
				MyBeanUtils.copyPropertiesIgnoreNull(item, groupTotal);
				groupTotal.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetAssetTotalService.updateBudgetAssetTotal(groupTotal);
				rs = groupTotal;
			}else {
				item.setLevel(0);
				item.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				item.setNd(info.getNd());
				item.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				item.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				item.setDataVersion(info.getDataVersion());
				budgetAssetTotalService.saveOrUpdateBudgetAssetTotal(item);
				rs = item;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="资产公司预算-保存年度预算项详情",notes="保存预算项不包括子项")
	@RequestMapping(value = "/stp-provider/budget/save-assettotal-items", method = RequestMethod.POST)
	public Object saveBudgetAssetTotalItems(@RequestBody List<BudgetAssetTotal> items) 
	{
		logger.info("budget-save-assettotal-items...");
		Integer rs = 0;
		try
		{
			Map<String,BudgetAssetTotal> map = new HashMap<String,BudgetAssetTotal>();
			for(BudgetAssetTotal item:items) {
				map.put(item.getDataId(), item);
			}
			List<BudgetAssetTotal> totals = budgetAssetTotalService.selectBudgetAssetTotalListByIds(new ArrayList<String>(map.keySet()));
			for(BudgetAssetTotal total:totals) {
				BudgetAssetTotal maptotal = map.get(total.getDataId());
				if(!JSON.toJSONString(maptotal).equals(JSON.toJSONString(total))) {
					rs += budgetAssetTotalService.updateBudgetAssetTotal(maptotal);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="资产公司预算-保存年度预算项详情",notes="保存预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/save-assettotal-childitems", method = RequestMethod.POST)
	public Object saveBudgetAssetTotalChildItems(@RequestBody HashMap<String,Object> map) 
	{
		Integer rs = 0;
		try
		{
			BudgetAssetTotal to = JSON.parseObject(map.get("item").toString(), BudgetAssetTotal.class);
			//原有全部逻辑删除（包括已删除的）
			List<BudgetAssetTotal> childlist = budgetAssetTotalService.selectChildBudgetAssetTotalAll(to.getDataId());
			Map<String,BudgetAssetTotal> oldmap = new HashMap<String,BudgetAssetTotal>();
			for(BudgetAssetTotal t:childlist){
				budgetAssetTotalService.deleteBudgetAssetTotal(t.getDataId());
				oldmap.put(t.getDisplayName(), t);
			}
			//有则更新，无责保存
			List<BudgetAssetTotal> totals = JSON.parseArray(map.get("items").toString(), BudgetAssetTotal.class);
			for(BudgetAssetTotal t:totals){
				if(oldmap.containsKey(t.getDisplayName())){
				
					BudgetAssetTotal old = oldmap.get(t.getDisplayName());
					old.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					old.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					old.setXmjf(t.getXmjf());
					old.setYjwc(t.getYjwc());
					old.setDisplayCode(t.getDisplayCode());
					budgetAssetTotalService.updateBudgetAssetTotal(old);
				}else{
					t.setDataId(IdUtil.createIdByTime());
					t.setDataVersion(to.getDataVersion());
					t.setNd(to.getNd());
					t.setLevel(1);
					t.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					budgetAssetTotalService.saveOrUpdateBudgetAssetTotal(t);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="资产公司预算-检索资产公司",notes="检索资产公司列表")
	@RequestMapping(value = "/stp-provider/budget/search-asset-company-items", method = RequestMethod.POST)
	public Object selectBudgetAssetCompanyItems() 
	{
		logger.info("search-group-items...");
		List<OutUnit> units = null;
		try
		{
			units = budgetAssetTotalService.selectAssetCompnays();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return units;
	}
	@ApiOperation(value="资产公司预算-检索资产公司",notes="检索资产公司树")
	@RequestMapping(value = "/stp-provider/budget/search-asset-company-tree", method = RequestMethod.POST)
	public Object selectBudgetAssetCompanyTree() 
	{
		logger.info("search-group-items...");
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		try
		{
			List<OutUnit> units = budgetAssetTotalService.selectAssetCompnays();
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
	@ApiOperation(value="资产公司预算-删除预算项详情",notes="删除资产预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/del-assettotal-item/{dataId}", method = RequestMethod.POST)
	public Object deleteBudgetAssetTotalInfo(@PathVariable("dataId") String dataId) 
	{
		logger.info("budget-delete-assettotal-item...");
		Integer rs = 0;
		try
		{
			BudgetAssetTotal groupTotal = budgetAssetTotalService.selectBudgetAssetTotal(dataId);
			if(groupTotal != null) {
				List<BudgetAssetTotal> childAssets = budgetAssetTotalService.selectChildBudgetAssetTotal(dataId);
				for(BudgetAssetTotal total:childAssets) 
				{
					rs += budgetAssetTotalService.deleteBudgetAssetTotal(total.getDataId());
				}
				rs += budgetAssetTotalService.deleteBudgetAssetTotal(dataId);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="资产公司预算-检索预算项历史数据",notes="检索预算项历史数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-assettotal-history-items", method = RequestMethod.POST)
	public Object selectBudgetAssetTotalItemHistory(@RequestBody BudgetAssetTotal item) 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetAssetTotal> rs = budgetAssetTotalService.selectAssetTotalHistoryItems(item);
			for(BudgetAssetTotal total:rs) {
				Map<String,Object> map  = MyBeanUtils.transBean2Map(total);
				map.put("total", new Double(map.get("yjwc").toString())+new Double(map.get("xmjf").toString()));
				rsmap.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsmap;
	}
	@ApiOperation(value="资产公司预算-检索预算项历年数据",notes="检索预算项历年数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-assettotal-final-history-list", method = RequestMethod.POST)
	public Object selectBudgetAssetFinalHistoryList() 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> rs = budgetInfoService.selectFinalBudgetInfoList(BudgetInfoEnum.ASSETS_TOTAL.getCode());
			for(BudgetInfo info:rs) {
				List<BudgetAssetTotal> totals = budgetAssetTotalService.selectItemsByBudgetId(info.getDataId());
				Map<String,Object> map  = MyBeanUtils.transBean2Map(info);
				map.put("items", totals);
				rsmap.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsmap;
	}
	@ApiOperation(value="资产公司预算-获取计划参考数据",notes="检索资产公司年度计划金额")
	@RequestMapping(value = "/stp-provider/budget/select-assettotal-compare-plan", method = RequestMethod.POST)
	public Object selectBudgetAssetItemComparePlan(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectPlan> plans = new ArrayList<OutProjectPlan>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectPlan>> planMap = budgetAssetTotalService.selectComparePlanData(codes,nd);
			
			List<OutProjectPlan> rs = planMap.get(code);
			if(rs != null && rs.size() >0 ) {
				plans.addAll(rs);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return plans;
	}
	@ApiOperation(value="资产公司预算-获取计划参考数据",notes="检索资产公司年度计划金额")
	@RequestMapping(value = "/stp-provider/budget/select-assettotal-compare-project", method = RequestMethod.POST)
	public Object selectBudgetAssetItemCompareProject(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectInfo> plans = new ArrayList<OutProjectInfo>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectInfo>> planMap = budgetAssetTotalService.selectCompareProjectInfoData(codes,nd);
			List<OutProjectInfo> rs = planMap.get(code);
			if(rs != null && rs.size() >0 ) {
				plans.addAll(rs);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return plans;
	}
	@ApiOperation(value="资产公司预算-资产预算审批",notes="发起资产预算表审批")
	@RequestMapping(value = "/stp-provider/budget/start-budget-assettotal-activity/{budgetInfoId}", method = RequestMethod.POST)
	public Object startBudgetAssetTotalActivity(@PathVariable("budgetInfoId") String budgetInfoId,@RequestBody WorkflowVo workflowVo) 
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
			workflowVo.setProcessInstanceName("资产预算表审批："+info.getDataVersion());
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
	        variables.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-assettotal-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
	        //流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
	        variables.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-assettotal-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
	        
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
	@ApiOperation(value="资产公司预算-审批流程回调通知",notes="审批结果回调通知")
	@RequestMapping(value = "/stp-provider/budget/callback-workflow-assettotal-notice")
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
	
	@ApiOperation(value="资产公司预算-获取指定年度最终预算表",notes="获取指定年度最终预算表信息及列表")
	@RequestMapping(value = "/stp-provider/budget/get-final-assettotal", method = RequestMethod.POST)
	public Object selectFinalAssetTotalInfo(@RequestBody String nd) throws Exception 
	{
		BudgetInfo info = budgetInfoService.selectFinalBudget(nd, BudgetInfoEnum.ASSETS_TOTAL.getCode());
		Map<String,Object> rsmap = new HashMap<String,Object>();
		if(info != null) {
			rsmap = MyBeanUtils.transBean2Map(info);
			List<BudgetAssetTotal> totals = budgetAssetTotalService.selectItemsByBudgetId(info.getDataId());
			Double items_total = 0d;
			for(BudgetAssetTotal total:totals) {
				items_total += total.getTotal();
			}
			rsmap.put("items", totals);
			rsmap.put("items_total", items_total);
		}
		return rsmap;
	}
}
