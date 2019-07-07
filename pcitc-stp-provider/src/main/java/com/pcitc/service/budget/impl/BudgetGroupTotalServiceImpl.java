package com.pcitc.service.budget.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetGroupTotalExample;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.mapper.budget.BudgetGroupTotalMapper;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.service.budget.BudgetGroupTotalService;
import com.pcitc.service.feign.SystemRemoteClient;
import com.pcitc.service.feign.WorkflowRemoteClient;

@Service("budgetGroupTotalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetGroupTotalServiceImpl implements BudgetGroupTotalService
{

	@Autowired
	private BudgetGroupTotalMapper budgetGroupTotalMapper;
	
	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	@Override
	public BudgetGroupTotal selectBudgetGroupTotal(String dataId) throws Exception
	{
		return budgetGroupTotalMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetGroupTotal(BudgetGroupTotal groupTotal) throws Exception
	{
		
		return budgetGroupTotalMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetGroupTotal(String id) throws Exception
	{
		BudgetGroupTotal group = budgetGroupTotalMapper.selectByPrimaryKey(id);
		if(group != null) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetGroupTotalMapper.updateByPrimaryKey(group);
		}
		return 0;
	}

	@Override
	public List<BudgetGroupTotal> selectBudgetGroupTotalListByIds(List<String> list) throws Exception
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andDataIdIn(list);
		return budgetGroupTotalMapper.selectByExample(example);
	}

	@Override
	public Integer saveOrUpdateBudgetGroupTotal(BudgetGroupTotal budgetGroupTotal) throws Exception
	{
		BudgetGroupTotal old = budgetGroupTotalMapper.selectByPrimaryKey(budgetGroupTotal.getDataId());
		if(old == null) {
			return budgetGroupTotalMapper.insert(budgetGroupTotal);
		}else {
			MyBeanUtils.copyProperties(budgetGroupTotal, old);
			return budgetGroupTotalMapper.updateByPrimaryKey(old);
		}
	}

	@Override
	public List<BudgetGroupTotal> selectItemsByBudgetId(String budgetInfoId)
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		c.andLevelEqualTo(0);//只显示第一级
		example.setOrderByClause("no");
		return budgetGroupTotalMapper.selectByExample(example);
	}

	@Override
	public LayuiTableData selectBudgetGroupTotalPage(LayuiTableParam param) throws Exception
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andLevelEqualTo(0);//只显示第一级
		example.setOrderByClause("no");
		//return this.findByExample(param, example);
		LayuiTableData tabledata = this.findByExample(param, example);
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = tabledata.getData().iterator();iter.hasNext();) 
		{
			Map<String,Object> mp  = MyBeanUtils.transBean2Map(iter.next());
			mp.put("total", new Double(mp.get("zxjf").toString())+new Double(mp.get("xmjf").toString()));
			mp.put("plan_money", 0);
			mp.put("last_year_end", 0);
			ls.add(mp);
		}
		tabledata.setData(ls);
		return tabledata;
	}
	private LayuiTableData findByExample(LayuiTableParam param,BudgetGroupTotalExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetGroupTotal> list = budgetGroupTotalMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetGroupTotal> pageInfo= new PageInfo<BudgetGroupTotal>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int deleteBudgetGroupTotalByInfo(String budgetInfoId) throws Exception
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		List<BudgetGroupTotal> list = budgetGroupTotalMapper.selectByExample(example);
		
		Integer rs = 0;
		for(BudgetGroupTotal group:list) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs += budgetGroupTotalMapper.updateByPrimaryKey(group);
		}
		return rs;
	}

	@Override
	public List<BudgetGroupTotal> selectChildBudgetGroupTotal(String dataId)
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andParentDataIdEqualTo(dataId);
		c.andLevelEqualTo(1);//只显示第二级
		example.setOrderByClause("no");
		return budgetGroupTotalMapper.selectByExample(example);
	}
	@Override
	public List<BudgetGroupTotal> selectChildBudgetGroupTotalAll(String dataId) {
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andParentDataIdEqualTo(dataId);
		c.andLevelEqualTo(1);//只显示第二级
		example.setOrderByClause("no");
		return budgetGroupTotalMapper.selectByExample(example);
	}

	@Override
	public List<BudgetGroupTotal> selectGroupTotalHistoryItems(BudgetGroupTotal item) {
		//检索已通过审核的集团预算
		BudgetInfoExample infoExample = new BudgetInfoExample();
		BudgetInfoExample.Criteria infoc = infoExample.createCriteria();
		infoc.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		infoc.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		infoc.andBudgetTypeEqualTo(BudgetInfoEnum.GROUP_TOTAL.getCode());
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(infoExample);
		Set<String> ids = new HashSet<String>();
		ids.add("xxxx");//避免为空
		for(BudgetInfo info:infos) {
			ids.add(info.getDataId());
		}
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdIn(new ArrayList<String>(ids));
		c.andNdNotEqualTo(item.getNd());
		c.andDisplayNameEqualTo(item.getDisplayName());
		c.andLevelEqualTo(0);//只显示第1级
		example.setOrderByClause("nd desc");
		return budgetGroupTotalMapper.selectByExample(example);
	}

	@Override
	public List<BudgetGroupTotal> selectBudgetGroupTotalByInfoId(String budgetId) throws Exception 
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetId);
		example.setOrderByClause("no");
		return budgetGroupTotalMapper.selectByExample(example);
	}
	@Override
	public List<OutUnit> selectGroupCompnays() {
		return systemRemoteClient.selectProjectUnits("JTZS");
	}
	@Override
	public Map<String, List<OutProjectPlan>> selectComparePlanData(Set<String> codes, String nd) {
		if(codes == null || codes.size() == 0) {
			return new HashMap<String,List<OutProjectPlan>>();
		}
		StringBuffer sb = new StringBuffer();
		for (String code : codes) {
			sb.append(code + ",");
		}

		LayuiTableParam layuiParam = new LayuiTableParam();
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("ysnd", nd);
		p.put("define9", sb.toString().substring(0, sb.length() - 1));
		layuiParam.setLimit(1000);
		layuiParam.setPage(1);
		layuiParam.setParam(p);

		LayuiTableData dt = systemRemoteClient.selectProjectPlanByCond(layuiParam);
		Map<String, List<OutProjectPlan>> rs = new HashMap<String,List<OutProjectPlan>>();
		for (java.util.Iterator<?> iter = dt.getData().iterator(); iter.hasNext();) {
			String planStr = JSON.toJSON(iter.next()).toString();
			OutProjectPlan plan = JSON.toJavaObject(JSON.parseObject(planStr), OutProjectPlan.class);

			if(!rs.containsKey(plan.getDefine9())) {
				rs.put(plan.getDefine9(), new ArrayList<OutProjectPlan>());
			}
			rs.get(plan.getDefine9()).add(plan);
		}
		return rs;
	}

	@Override
	public Map<String, List<OutProjectInfo>> selectCompareProjectInfoData(Set<String> codes, String nd) {
		if(codes == null || codes.size() == 0) {
			return new HashMap<String,List<OutProjectInfo>>();
		}
		StringBuffer sb = new StringBuffer();
		for (String code : codes) {
			sb.append(code + ",");
		}

		LayuiTableParam layuiParam = new LayuiTableParam();
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("ysnd", nd);
		p.put("define9", sb.toString().substring(0, sb.length() - 1));
		layuiParam.setLimit(1000);
		layuiParam.setPage(1);
		layuiParam.setParam(p);

		LayuiTableData dt = systemRemoteClient.selectCommonProjectByCond(layuiParam);
		Map<String, List<OutProjectInfo>> rs = new HashMap<String,List<OutProjectInfo>>();
		for (java.util.Iterator<?> iter = dt.getData().iterator(); iter.hasNext();) {
			String planStr = JSON.toJSON(iter.next()).toString();
			OutProjectInfo plan = JSON.toJavaObject(JSON.parseObject(planStr), OutProjectInfo.class);

			if(!rs.containsKey(plan.getDefine9())) {
				rs.put(plan.getDefine9(), new ArrayList<OutProjectInfo>());
			}
			rs.get(plan.getDefine9()).add(plan);
		}
		return rs;
	}

	@Override
	public Boolean startWorkFlow(BudgetInfo info,WorkflowVo workflowVo) 
	{
		try {
	    	// 调用审批流程，此处调用同时实现事务
	    	JSONObject flowJson = new JSONObject();
	    	// 业务主键id
	    	flowJson.put("businessId", info.getDataId());
	    	flowJson.put("processInstanceName", "集团预算总表审批");
	    	
	    	// 发起者信息
	    	flowJson.put("authenticatedUserId", info.getCreaterId());
	    	flowJson.put("authenticatedUserName", info.getCreaterName());
	
			// 菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
	    	flowJson.put("functionId", workflowVo.getFunctionId());
	    	
	    	// 待办业务详情、最终审批同意、最终审批不同意路径
	    	flowJson.put("auditDetailsPath", "/budget/budget_main_grouptotal?budgetId"+info.getDataId());
	    	flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-grouptotal-notice?budgetId=" + info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
	    	flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/stp-provider/budget/callback-workflow-grouptotal-notice?budgetId=" + info.getDataId()+"&workflow_status="+BudgetAuditStatusEnum.AUDIT_STATUS_REFUSE.getCode());
	    	
	    	// 远程调用
	    	System.out.println("=====远程调用开始");
	    	workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	System.out.println("=====远程调用结束");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean outDataToReport(BudgetInfo info) 
	{
		/*1	2018	1	油田处	25870	8750	8350	0	400	200	17120	15820	0	1300			
		2	2018	2	炼油处	0	0					0						
		3	2018	3	化工处	1190	400			400		790			790			
		4	2018	4	材料处	1440	240	40		200		1200	800		400			
		5	2018	5	装储处	3855	2305	1640		665	100	1550	800		750	1300		
		6	2018	6	综合计划处	3700	400			400	200	3300	500	500	2300			
		7	2018	7	技术监督处	0	0					0						
		8	2018	8	三剂处	150	50	50				100			100			
		9	2018	9	知识产权处	210	110			110		100	100		0			
		10	2018	10	物装部	0	0					0						
		11	2018	11	信息部	0	0					0						
		12	2018	12	工程部	0	0					0						
		13	2018	13	炼油事业部（军工）	0	0					0						
		14	2018	14	炼油事业部（B2、C类）	0	0					0						
		15	2018	15	化工事业部（B2、C类）	0	0					0						
		16	2018	16	专项	0	0					0						
		17	2018	17	机动	935	0					935			935	335		
		18	2018		合计	37350	12255	10080	0	2175	500	25095	18020	500	6575	1635	*/	

		return null;
	}

	@Override
	public Object createBudgetItemByTemplate(String dataId,BudgetInfo newInfo) throws Exception 
	{
		
		List<BudgetGroupTotal> templates = selectBudgetGroupTotalByInfoId(dataId);
		Map<String,String> idRel = new HashMap<String,String>();//新老ID对照
		for(BudgetGroupTotal total:templates) 
		{
			String newId = IdUtil.createIdByTime();
			idRel.put(total.getDataId(), newId);
			
			total.setBudgetInfoId(newInfo.getDataId());
			total.setDataVersion(newInfo.getDataVersion());
			total.setNd(newInfo.getNd());
			total.setDataId(newId);
			total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			saveOrUpdateBudgetGroupTotal(total);
		}
		//处理二级预算单位
		templates = selectBudgetGroupTotalByInfoId(newInfo.getDataId());
		for(BudgetGroupTotal total:templates) 
		{
			if(total.getLevel()>0 && total.getParentDataId() != null) {
				total.setParentDataId(idRel.get(total.getParentDataId()));
				updateBudgetGroupTotal(total);
			}
		}
		return newInfo;
	}

	@Override
	public Map<String, Object> selectFinalGroupTotalBudget(BudgetInfo info)  
	{
		Map<String,Object> rsmap = new HashMap<String,Object>();
		if(info != null) {
			rsmap = MyBeanUtils.transBean2Map(info);
			List<BudgetGroupTotal> totals = selectItemsByBudgetId(info.getDataId());
			Double items_total = 0d;
			for(BudgetGroupTotal total:totals) {
				items_total += total.getTotal()==null?0d:total.getZxjf()+total.getXmjf();
			}
			rsmap.put("items", totals);
			rsmap.put("items_total", items_total);
		}else {
			rsmap.put("items", new ArrayList<BudgetGroupTotal>());
			rsmap.put("items_total", 0);
		}
		return rsmap;
	}
}
