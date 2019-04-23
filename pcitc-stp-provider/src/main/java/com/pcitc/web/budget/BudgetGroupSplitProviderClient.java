package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.vo.BudgetSplitBaseDataVo;
import com.pcitc.base.stp.budget.vo.SplitItemVo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.service.budget.BudgetGroupSplitService;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-年度预算（集团）分解表",tags= {"预算分解-年度集团预分解表"})
@RestController
public class BudgetGroupSplitProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetGroupSplitProviderClient.class);
	private final static String WORKFLOW_DEFINE_ID = "xxxx:x:xxxxx";
	
	@Autowired
	private BudgetGroupSplitService budgetGroupSplitService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="集团公司预算分解-预算列表",notes="按年检索年度集团预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-groupsplit-info-list", method = RequestMethod.POST)
	public Object selectBudgetGroupSplitInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-info-list...");
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> datalist = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.GROUP_SPLIT.getCode());
			//获取集团预算总表中可用分配数（审批通过的集团预算）
			BudgetInfo finalBudgetInfo = budgetInfoService.selectFinalBudget(info.getNd(),BudgetInfoEnum.GROUP_TOTAL.getCode());
			for(BudgetInfo dt:datalist) {
				if(finalBudgetInfo !=null) {
					dt.setBudgetMoney(finalBudgetInfo.getBudgetMoney());
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
	@ApiOperation(value="集团公司预算分解-预算列表",notes="按年分页检索年度集团预算表列表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-groupsplit-info-table", method = RequestMethod.POST)
	public Object selectBudgetGroupSplitInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-grouptotal-info-list...");
		LayuiTableData data = null;
		try
		{
			param.getParam().put("budget_type", BudgetInfoEnum.GROUP_SPLIT.getCode());
			data = budgetInfoService.selectBudgetInfoPage(param);
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="集团公司预算分解-预算表信息检索",notes="检索预算表信息")
	@RequestMapping(value = "/stp-provider/budget/budget-groupsplit-info", method = RequestMethod.POST)
	public Object selectGroupSplitInfo(@RequestBody String budgetInfoId) 
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
	@ApiOperation(value="集团公司预算分解-创建集团年度预算",notes="创建集团年度预算空白预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-groupsplit", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-groupsplit...");
		BudgetInfo rsbean = null;
		try
		{
			info.setBudgetType(BudgetInfoEnum.GROUP_SPLIT.getCode());
			rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(),info);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsbean;
	}
	
	@ApiOperation(value="集团公司预算分解-预算明细检索",notes="检索集团预算分解明细列表数据")
	@RequestMapping(value = "/stp-provider/budget/budget-groupsplit-items", method = RequestMethod.POST)
	public Object selectGroupSplitItemTable(@RequestBody LayuiTableParam param) 
	{
		String dataId = param.getParam().get("budget_info_id").toString();
		logger.info("select-budget-groupsplit-items..."+dataId);
		LayuiTableData table = new LayuiTableData();
		List<Map<String,Object>> data = null;
		try
		{
			data =  budgetGroupSplitService.selectBudgetSplitDataList(dataId);
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
	@ApiOperation(value="集团公司预算分解-预算明细标题",notes="定义集团预算分解表标题。")
	@RequestMapping(value = "/stp-provider/budget/budget-groupsplit-titles", method = RequestMethod.POST)
	public Object selectGroupSplitTableTitles(@RequestBody String nd) 
	{
		logger.info("select-budget-grouptotal-items..."+nd);
		List<Map<String,Object>> data = null;
		try
		{
			data =  budgetGroupSplitService.selectBudgetSplitTableTitles(nd);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@ApiOperation(value="集团公司预算分解-预算明细标题",notes="定义集团预算历史数据分解表标题（往年和历年数据标题）。")
	@RequestMapping(value = "/stp-provider/budget/budget-groupsplit-history-titles", method = RequestMethod.POST)
	public Object selectGroupSplitTableHistoryTitles(@RequestBody String nd) 
	{
		logger.info("budget-groupsplit-history-titles..."+nd);
		Map<String,List<SplitItemVo>> data = null;
		try
		{
			data =  budgetGroupSplitService.selectBudgetSplitHistoryTableTitles(nd);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@ApiOperation(value="集团公司预算-保存年度预算项详情",notes="保存预算项不包括子项")
	@RequestMapping(value = "/stp-provider/budget/save-groupsplit-items", method = RequestMethod.POST)
	public Object saveBudgetGroupSplitItems(@RequestBody String items) 
	{
		logger.info("budget-save-groupsplit-items...");
		Integer rs = 0;
		try
		{
			List<BudgetSplitData> datas = budgetGroupSplitService.saveBudgetSplitData(items);
			rs = datas.size();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="集团公司预算-删除集团年度预算",notes="删除集团年度预算表（逻辑删除）")
	@RequestMapping(value = "/stp-provider/budget/budget-groupsplit-del", method = RequestMethod.POST)
	public Object deleteBudgetGroupTotalInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-delete-grouptotal...");
		Integer rs = 0;
		try
		{
			rs += budgetInfoService.deleteBudgetInfo(info.getDataId());
			rs += budgetGroupSplitService.deleteBudgetSplitDataByInfo(info.getDataId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="集团公司预算分解-检索预算项详情",notes="检索预算项详情包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-groupsplit-item", method = RequestMethod.POST)
	public Object selectBudgetGroupTotalItem(@RequestBody BudgetSplitBaseDataVo vo) 
	{
		logger.info("get-groupsplit-item...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			System.out.println(JSON.toJSONString(vo));
			System.out.println("--------------");
			map = budgetGroupSplitService.selectGroupSplitItem(vo.getBudgetInfoId(),vo.getOrganCode());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="集团公司预算分解-检索预算项历史数据",notes="检索预算项历史数据列表")
	@RequestMapping(value = "/stp-provider/budget/get-groupsplit-history-items", method = RequestMethod.POST)
	public Object selectBudgetGroupSplitHistoryItems(@RequestBody BudgetSplitBaseDataVo vo) 
	{
		Map<String,Object> rsmap = new LinkedHashMap<String,Object>();
		try
		{
			//查询有最终报告的报表
			Map<String,List<SplitItemVo>> map = budgetGroupSplitService.selectBudgetSplitHistoryTableTitles(vo.getNd());
			for(java.util.Iterator<String> iter = map.keySet().iterator();iter.hasNext();){
				String cnd = iter.next();
				rsmap.put(cnd, budgetGroupSplitService.selectGroupSplitFinalItem(cnd,vo.getOrganCode()));
			}
			System.out.println("**********");
			System.out.println(JSON.toJSONString(rsmap));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsmap;
	}
	@ApiOperation(value="集团公司预算分解-检索预算项历年数据",notes="检索预算项历年数据列表不包括子项")
	@RequestMapping(value = "/stp-provider/budget/search-groupsplit-final-history-list", method = RequestMethod.POST)
	public Object selectBudgetGroupFinalHistoryList() 
	{
		List<Map<String,Object>> rsmap = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetInfo> rs = budgetInfoService.selectFinalBudgetInfoList(BudgetInfoEnum.GROUP_SPLIT.getCode());
			for(BudgetInfo info:rs) {
				Map<String,Object> map  = MyBeanUtils.transBean2Map(info);
				List<Map<String,Object>> items =  budgetGroupSplitService.selectBudgetSplitDataList(info.getDataId());
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
	
	@ApiOperation(value="集团公司预算分解-集团预算审批",notes="发起集团预算表审批")
	@RequestMapping(value = "/stp-provider/budget/start-budget-groupsplit-activity/{budgetInfoId}", method = RequestMethod.POST)
	public Object startBudgetGroupTotalActivity(@PathVariable("budgetInfoId") String budgetInfoId,@RequestBody WorkflowVo workflowVo) 
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
			workflowVo.setProcessInstanceName("集团预算表审批："+info.getDataVersion());
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
	        variables.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-grouptotal-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
	        //流程驳回时，调用的方法（可能驳回到第一步，也可能驳回到第1+n步
	        variables.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-grouptotal-notice?budgetId="+info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
	        
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
	@ApiOperation(value="集团公司预算分解-审批流程回调通知",notes="审批结果回调通知")
	@RequestMapping(value = "/stp-provider/budget/callback-workflow-groupsplit-notice")
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
}
