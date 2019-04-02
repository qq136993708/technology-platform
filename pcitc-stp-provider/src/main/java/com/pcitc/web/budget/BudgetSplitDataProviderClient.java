package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-分解表数据",tags= {"预算-数据分解业务逻辑处理"})
@RestController
public class BudgetSplitDataProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetSplitDataProviderClient.class);
	private final static String WORKFLOW_DEFINE_ID = "xxxx:x:xxxxx";
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="事业部预算-预算列表",notes="按年检索年度事业部预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-splitdata-info-list", method = RequestMethod.POST)
	public Object selectBudgetSplitDataInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-splitdata-info-list...");
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
	@RequestMapping(value = "/stp-provider/budget/budget-splitdata-info-table", method = RequestMethod.POST)
	public Object selectBudgetSplitDataInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-splitdata-info-table...");
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
	@RequestMapping(value = "/stp-provider/budget/budget-splitdata-info", method = RequestMethod.POST)
	public Object selectSplitDataInfo(@RequestBody String budgetInfoId) 
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

	@ApiOperation(value="事业部预算-创建事业部年度预算",notes="创建事业部年度预算空白预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-splitdata", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-splitdata...");
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
	@RequestMapping(value = "/stp-provider/budget/budget-create-template-splitdata", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfoByHis(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-template-splitdata...");
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
			List<BudgetSplitData> templates = null;//budgetSplitDataService.selectBudgetSplitDataByInfoId(info.getDataId());
			Map<String,String> idRel = new HashMap<String,String>();//新老ID对照
			for(BudgetSplitData total:templates) 
			{
				String newId = IdUtil.createIdByTime();
				idRel.put(total.getDataId(), newId);
				
				total.setBudgetInfoId(newInfo.getDataId());
				total.setDataVersion(newInfo.getDataVersion());
				total.setNd(newInfo.getNd());
				total.setDataId(newId);
				total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				//budgetSplitDataService.saveOrUpdateBudgetSplitData(total);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newInfo;
	}
	@ApiOperation(value="事业部预算-删除事业部年度预算",notes="删除事业部年度预算表（逻辑删除）")
	@RequestMapping(value = "/stp-provider/budget/budget-splitdata-del", method = RequestMethod.POST)
	public Object deleteBudgetSplitDataInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-splitdata-del...");
		Integer rs = 0;
		try
		{
			rs += budgetInfoService.deleteBudgetInfo(info.getDataId());
			//rs += budgetSplitDataService.deleteBudgetSplitDataByInfo(info.getDataId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	/*@ApiOperation(value="事业部预算-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-splitdata-item/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetSplitDataItem(@PathVariable("itemId") String itemId) 
	{
		logger.info("get-splitdata-item...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			BudgetSplitData groupTotal = budgetSplitDataService.selectBudgetSplitData(itemId);
			if(groupTotal != null) {
				List<BudgetSplitData> childStocks = budgetSplitDataService.selectChildBudgetSplitData(itemId);
				List<Map<String,Object>> groupMaps = new ArrayList<Map<String,Object>>();
				for(BudgetSplitData total:childStocks) {
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
	@RequestMapping(value = "/stp-provider/budget/get-splitdata-item-company/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetSplitDataCompanyItem(@PathVariable("itemId") String itemId) 
	{
		logger.info("get-splitdata-item-company...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			BudgetSplitData groupTotal = budgetSplitDataService.selectBudgetSplitData(itemId);
			if(groupTotal != null) {
				List<BudgetSplitData> childStocks = budgetSplitDataService.selectBudgetSplitDataCompanyItem(itemId);
				List<Map<String,Object>> groupMaps = new ArrayList<Map<String,Object>>();
				for(BudgetSplitData total:childStocks) {
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
	@RequestMapping(value = "/stp-provider/budget/save-splitdata-item", method = RequestMethod.POST)
	public Object saveBudgetSplitDataInfo(@RequestBody BudgetSplitData item) 
	{
		logger.info("budget-save-splitdata...");
		BudgetSplitData stock = null;
		try
		{
			BudgetInfo info = budgetInfoService.selectBudgetInfo(item.getBudgetInfoId());
			stock = budgetSplitDataService.selectBudgetSplitData(item.getDataId());
			if(stock != null) {
				MyBeanUtils.copyPropertiesIgnoreNull(item, stock);
				stock.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetSplitDataService.updateBudgetSplitData(stock);
			}else {
				stock = (BudgetSplitData)MyBeanUtils.createDefaultModel(BudgetSplitData.class);
				MyBeanUtils.copyPropertiesIgnoreNull(item, stock);
				stock.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				stock.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
				stock.setNd(info.getNd());
				stock.setLevel("0".equals(stock.getParentDataId())?0:1);//
				stock.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				stock.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				stock.setDataVersion(info.getDataVersion());
				budgetSplitDataService.saveOrUpdateBudgetSplitData(stock);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return stock;
	}
	@ApiOperation(value="事业部预算-保存年度预算项详情",notes="保存预算项不包括子项")
	@RequestMapping(value = "/stp-provider/budget/save-splitdata-items", method = RequestMethod.POST)
	public Object saveBudgetSplitDataItems(@RequestBody List<BudgetSplitData> items) 
	{
		logger.info("budget-save-splitdata-items...");
		Integer rs = 0;
		try
		{
			Map<String,BudgetSplitData> map = new HashMap<String,BudgetSplitData>();
			for(BudgetSplitData item:items) {
				map.put(item.getDataId(), item);
			}
			List<BudgetSplitData> totals = budgetSplitDataService.selectBudgetSplitDataListByIds(new ArrayList<String>(map.keySet()));
			for(BudgetSplitData total:totals) {
				BudgetSplitData maptotal = map.get(total.getDataId());
				if(!JSON.toJSONString(maptotal).equals(JSON.toJSONString(total))) {
					rs += budgetSplitDataService.updateBudgetSplitData(maptotal);
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
	@RequestMapping(value = "/stp-provider/budget/save-splitdata-childitems", method = RequestMethod.POST)
	public Object saveBudgetSplitDataChildItems(@RequestBody HashMap<String,Object> map) 
	{
		Integer rs = 0;
		try
		{
			BudgetSplitData to = JSON.parseObject(map.get("item").toString(), BudgetSplitData.class);
			//原有全部逻辑删除（包括已删除的）
			List<BudgetSplitData> childlist = budgetSplitDataService.selectBudgetSplitDataCompanyItem(to.getDataId());
			Map<String,BudgetSplitData> oldmap = new HashMap<String,BudgetSplitData>();
			for(BudgetSplitData t:childlist){
				budgetSplitDataService.deleteBudgetSplitData(t.getDataId());
				oldmap.put(t.getDisplayName(), t);
			}
			//有则更新，无责保存
			List<BudgetSplitData> totals = JSON.parseArray(map.get("items").toString(), BudgetSplitData.class);
			for(BudgetSplitData t:totals){
				if(oldmap.containsKey(t.getDisplayName())){
				
					BudgetSplitData old = oldmap.get(t.getDisplayName());
					old.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					old.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					old.setXmjfFyx(t.getXmjfFyx());
					old.setXmjfZbx(t.getXmjfZbx());
					old.setXmjfTotal(t.getXmjfTotal());
					old.setYjwcFyx(t.getYjwcFyx());
					old.setYjwcZbx(t.getYjwcZbx());
					old.setYjwcTotal(t.getYjwcTotal());
					old.setDisplayCode(t.getDisplayCode());
					budgetSplitDataService.updateBudgetSplitData(old);
				}else{
					t.setDataId(IdUtil.createIdByTime());
					t.setDataVersion(to.getDataVersion());
					t.setNd(to.getNd());
					t.setLevel(to.getLevel()+1);
					t.setItemType(BudgetItemTypeEnum.BUDGET_ITEM_COMPANY.getCode());
					t.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
					t.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
					budgetSplitDataService.saveOrUpdateBudgetSplitData(t);
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
			units = budgetSplitDataService.selectB2cCompnays();
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
			List<OutUnit> units = budgetSplitDataService.selectB2cCompnays();
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
	@RequestMapping(value = "/stp-provider/budget/del-splitdata-item/{dataId}", method = RequestMethod.POST)
	public Object deleteBudgetSplitDataInfo(@PathVariable("dataId") String dataId) 
	{
		logger.info("budget-delete-splitdata-item...");
		Integer rs = 0;
		try
		{
			BudgetSplitData groupTotal = budgetSplitDataService.selectBudgetSplitData(dataId);
			if(groupTotal != null) {
				List<BudgetSplitData> childStocks = budgetSplitDataService.selectChildBudgetSplitData(dataId);
				for(BudgetSplitData total:childStocks) 
				{
					rs += budgetSplitDataService.deleteBudgetSplitData(total.getDataId());
				}
				rs += budgetSplitDataService.deleteBudgetSplitData(dataId);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="事业部预算-检索预算项历史数据",notes="检索预算项历史数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-splitdata-history-items", method = RequestMethod.POST)
	public Object selectBudgetSplitDataItemHistory(@RequestBody BudgetSplitData item) 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetSplitData> rs = budgetSplitDataService.selectSplitDataHistoryItems(item);
			for(BudgetSplitData total:rs) {
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
	@RequestMapping(value = "/stp-provider/budget/search-splitdata-final-history-list", method = RequestMethod.POST)
	public Object selectBudgetStockFinalHistoryList() 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> rs = budgetInfoService.selectFinalBudgetInfoList(BudgetInfoEnum.B2C_SPLIT.getCode());
			for(BudgetInfo info:rs) {
				LayuiTableParam param = new LayuiTableParam(1,100);
				param.getParam().put("budget_info_id",info.getDataId());
				LayuiTableData rsdata = budgetSplitDataService.selectBudgetSplitDataPage(param);
				
				//List<BudgetSplitData> totals = budgetSplitDataService.selectBudgetSplitDataByInfoId(info.getDataId());
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
	@RequestMapping(value = "/stp-provider/budget/select-splitdata-compare-plan", method = RequestMethod.POST)
	public Object selectBudgetStockItemComparePlan(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectPlan> plans = new ArrayList<OutProjectPlan>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectPlan>> planMap = budgetSplitDataService.selectComparePlanData(codes,nd);
			
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
	@RequestMapping(value = "/stp-provider/budget/select-splitdata-compare-project", method = RequestMethod.POST)
	public Object selectBudgetStockItemCompareProject(@RequestBody Map<String,Object> params) 
	{
		String nd = params.get("nd").toString();
		String code = params.get("code").toString();
		List<OutProjectInfo> plans = new ArrayList<OutProjectInfo>();
		try 
		{
			Set<String> codes = new HashSet<String>(Arrays.asList(new String [] {code}));
			Map<String,List<OutProjectInfo>> planMap = budgetSplitDataService.selectCompareProjectInfoData(codes,nd);
			List<OutProjectInfo> rs = planMap.get(code);
			if(rs != null && rs.size() >0 ) {
				plans.addAll(rs);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return plans;
	}
	@ApiOperation(value="事业部预算-事业部预算审批",notes="发起事业部预算表审批")
	@RequestMapping(value = "/stp-provider/budget/start-budget-splitdata-activity/{budgetInfoId}", method = RequestMethod.POST)
	public Object startBudgetSplitDataActivity(@PathVariable("budgetInfoId") String budgetInfoId,@RequestBody WorkflowVo workflowVo) 
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
			workflowVo.setProcessInstanceName("事业部预算表审批："+info.getDataVersion());
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
	        variables.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-splitdata-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
	        //流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
	        variables.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-splitdata-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
	        
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
	@ApiOperation(value="事业部预算-审批流程回调通知",notes="审批结果回调通知")
	@RequestMapping(value = "/stp-provider/budget/callback-workflow-splitdata-notice")
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
			List<BudgetSplitData> totals = budgetSplitDataService.selectItemsByBudgetId(budgetId);
			for(BudgetSplitData total:totals) {
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
	@RequestMapping(value = "/stp-provider/budget/get-final-splitdata", method = RequestMethod.POST)
	public Object selectFinalSplitDataInfo(@RequestBody String nd) throws Exception 
	{
		BudgetInfo info = budgetInfoService.selectFinalBudget(nd, BudgetInfoEnum.B2C_SPLIT.getCode());
		Map<String,Object> rsmap = new HashMap<String,Object>();
		if(info != null) {
			rsmap = MyBeanUtils.transBean2Map(info);
			List<BudgetSplitData> totals = budgetSplitDataService.selectItemsByBudgetId(info.getDataId());
			Double items_total = 0d;
			for(BudgetSplitData total:totals) {
				items_total += total.getHgTotal();
			}
			rsmap.put("items", totals);
			rsmap.put("items_total", items_total);
		}else {
			rsmap.put("items", new ArrayList<BudgetSplitData>());
			rsmap.put("items_total", 0);
		}
		return rsmap;
	}*/
}
