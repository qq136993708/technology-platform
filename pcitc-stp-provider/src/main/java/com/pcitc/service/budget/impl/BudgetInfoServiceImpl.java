package com.pcitc.service.budget.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetOrganEnum;
import com.pcitc.base.common.enums.BudgetOrganNdEnum;
import com.pcitc.base.common.enums.BudgetStockEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.budget.BudgetMoneyDecompose;
import com.pcitc.base.stp.budget.BudgetMoneyDecomposeExample;
import com.pcitc.base.stp.budget.BudgetMoneyTotal;
import com.pcitc.base.stp.budget.BudgetStockTotal;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.mapper.budget.BudgetMoneyDecomposeMapper;
import com.pcitc.service.budget.BudgetAssetSplitService;
import com.pcitc.service.budget.BudgetAssetTotalService;
import com.pcitc.service.budget.BudgetGroupSplitService;
import com.pcitc.service.budget.BudgetGroupTotalService;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.budget.BudgetMoneyTotalService;
import com.pcitc.service.budget.BudgetStockSplitXtwSplitService;
import com.pcitc.service.budget.BudgetStockSplitZgsSplitService;
import com.pcitc.service.budget.BudgetStockSplitZsySplitService;
import com.pcitc.service.budget.BudgetStockTotalService;
import com.pcitc.service.feign.SystemRemoteClient;
import com.pcitc.service.feign.WorkflowRemoteClient;

@Service("budGetInfoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetInfoServiceImpl implements BudgetInfoService
{

	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	
	@Autowired
	private BudgetMoneyDecomposeMapper budgetMoneyDecomposeMapper;
	
	@Autowired
	private BudgetMoneyTotalService budgetMoneyTotalService;
	
	@Autowired
	private BudgetAssetTotalService budgetAssetTotalService;
	
	@Autowired
	private BudgetGroupTotalService budgetGroupTotalService;
	
	@Autowired
	private BudgetStockTotalService budgetStockTotalService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@Autowired
	private WorkflowRemoteClient workflowRemoteClient;
	
	/*@Autowired
	private BudgetB2cSplitService budgetB2cSplitService;
	
	@Autowired
	private BudgetTechSplitService budgetTechSplitService;
	*/
	
	@Autowired
	private BudgetAssetSplitService budgetAssetSplitService;
	
	@Autowired
	private BudgetGroupSplitService budgetGroupSplitService;
	
	@Autowired
	private BudgetStockSplitXtwSplitService budgetStockSplitXtwSplitService;
	
	@Autowired
	private BudgetStockSplitZgsSplitService budgetStockSplitZgsSplitService;
	
	@Autowired
	private BudgetStockSplitZsySplitService budgetStockSplitZsySplitService;
	
	@Override
	public BudgetInfo selectBudgetInfo(String dataId) throws Exception
	{
		return budgetInfoMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetInfo(BudgetInfo groupTotal) throws Exception
	{
		groupTotal.setUpdateTime(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		return budgetInfoMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetInfo(String id) throws Exception
	{
		BudgetInfo info = budgetInfoMapper.selectByPrimaryKey(id);
		if(info != null) 
		{
			info.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetInfoMapper.updateByPrimaryKey(info);
		}
		return 0;
	}

	@Override
	public List<BudgetInfo> selectBudgetInfoListByIds(List<String> list) throws Exception
	{
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDataIdIn(list);
		return budgetInfoMapper.selectByExample(example);
	}

	@Override
	public Integer insertBudgetInfo(BudgetInfo BudgetInfo) throws Exception
	{
		return budgetInfoMapper.insert(BudgetInfo);
	}

	@Override
	public List<BudgetInfo> selectBudgetInfoList(String nd,Integer budgetType) throws Exception
	{
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andNdEqualTo(nd);
		c.andBudgetTypeEqualTo(budgetType);
		example.setOrderByClause("data_version DESC");
		return budgetInfoMapper.selectByExample(example);
	}

	@Override
	public LayuiTableData selectBudgetInfoPage(LayuiTableParam param) throws Exception
	{
		Integer budgetType = null;
		if(param.getParam().get("nd")==null || (param.getParam().get("budget_type") == null && param.getParam().get("budgetType") == null)) 
		{
			return null;
		}
		if(param.getParam().get("budget_type") != null) {
			budgetType = new Integer(param.getParam().get("budget_type").toString());
		}
		if(param.getParam().get("budgetType") != null) {
			budgetType = new Integer(param.getParam().get("budgetType").toString());
		}
		
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetTypeEqualTo(budgetType);
		c.andNdEqualTo(param.getParam().get("nd").toString());
		example.setOrderByClause("data_version");
		LayuiTableData data = this.findByExample(param, example);
		List<Map<String,Object>> mapdata = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) {
			Map<String,Object> map = MyBeanUtils.transBean2Map(iter.next());
			map.put("status", BudgetAuditStatusEnum.getStatusByCode((Integer)map.get("auditStatus")).getDesc());
			mapdata.add(map);
		}
		data.setData(mapdata);
		return data;
	}
	private LayuiTableData findByExample(LayuiTableParam param,BudgetInfoExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetInfo> list = budgetInfoMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetInfo> pageInfo= new PageInfo<BudgetInfo>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public BudgetInfo createBlankBudgetInfo(String nd,BudgetInfo info)
	{
		BudgetInfo params = (BudgetInfo) MyBeanUtils.createDefaultModel(BudgetInfo.class);
		params.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_NO_START.getCode());
		params.setBudgetType(info.getBudgetType());
		params.setNd(nd);
		params.setBudgetMoney(info.getBudgetMoney()==null?0d:info.getBudgetMoney());
		params.setCreaterId(info.getCreaterId());
		params.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
		params.setCreaterName(info.getCreaterName());
		
		//检索已创建
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andBudgetTypeEqualTo(info.getBudgetType());
		c.andNdEqualTo(nd);
		Integer size = budgetInfoMapper.selectByExample(example).size();
		
		
		params.setDataVersion("vs-"+nd+"-"+info.getBudgetType()+"-"+((1001+size)+"").substring(1));
		budgetInfoMapper.insert(params);
		return params;
	}

	@Override
	public List<BudgetInfo> selectFinalBudgetInfoList(Integer budgetType) throws Exception {
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		c.andBudgetTypeEqualTo(budgetType);
		example.setOrderByClause("nd DESC");
		return budgetInfoMapper.selectByExample(example);
	}

	@Override
	public BudgetInfo selectFinalBudget(String nd, Integer budgetType) {
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		c.andBudgetTypeEqualTo(budgetType);
		c.andNdEqualTo(nd);
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(example);
		if(infos != null && infos.size()>0) {
			return infos.get(0);
		}
		return null;
	}
	@Override
	public Map<String, List<OutProjectPlan>> selectBudgetPlanData(Set<String> codes, String nd) {
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
	public Boolean startWorkFlow(BudgetInfo info, WorkflowVo workflowVo) {

		try {
	    	// 调用审批流程，此处调用同时实现事务
	    	JSONObject flowJson = new JSONObject();
	    	// 业务主键id
	    	flowJson.put("businessId", info.getDataId());
	    	flowJson.put("processInstanceName", workflowVo.getProcessInstanceName());
	    	
	    	// 发起者信息
	    	flowJson.put("authenticatedUserId", info.getCreaterId());
	    	flowJson.put("authenticatedUserName", info.getCreaterName());
	    	// 审批完成通知发起人
	    	flowJson.put("messageUserIds",workflowVo.getAuthenticatedUserId());
			// 菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
	    	flowJson.put("functionId", workflowVo.getFunctionId());
	    	
	    	// 待办业务详情、最终审批同意、最终审批不同意路径
	    	flowJson.put("auditDetailsPath", workflowVo.getAuditDetailsPath());
	    	flowJson.put("auditAgreeMethod", workflowVo.getAuditAgreeMethod());
	    	flowJson.put("auditRejectMethod", workflowVo.getAuditRejectMethod());
	    	
	    	// 远程调用
	    	System.out.println("=====远程调用开始  time:"+System.currentTimeMillis());
	    	String rs = workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
	    	System.out.println("=====远程调用结束 time:"+System.currentTimeMillis()+"  RS:"+rs);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Map<String, Object>> selectGroupFinalSplit(String nd) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			//最终预算
			BudgetInfo fInfo = selectFinalBudget(nd,BudgetInfoEnum.GROUP_SPLIT.getCode());
			
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

	@Override
	public List<Map<String, Object>> selectAssetFinalSplit(String nd) {
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			//最终预算
			BudgetInfo fInfo = selectFinalBudget(nd,BudgetInfoEnum.ASSET_SPLIT.getCode());
			
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

	@Override
	public List<Map<String, Object>> selectStockFinalSplit(String nd) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			BudgetInfo xtwInfo = selectFinalBudget(nd,BudgetInfoEnum.STOCK_XTY_SPLIT.getCode());
			BudgetInfo zgsInfo = selectFinalBudget(nd,BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode());
			BudgetInfo zsyInfo = selectFinalBudget(nd,BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			
			
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
	
	@Override
	public void processDataImport(BudgetInfo info) throws Exception 
	{
		//更新到[资产分解表：out_tem_money_asset]
		if(BudgetInfoEnum.ASSET_SPLIT.getCode().equals(info.getBudgetType()))
		{
			writeToAsset(info);
		}
		else if(BudgetInfoEnum.GROUP_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			writeToGroup(info);
		}
		else if( BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			writeToInstitute(info);
		}
		else if(BudgetInfoEnum.STOCK_XTY_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			writeToOther(info);
		}
		else if(BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			writeToCompany(info);
		}
		else if(BudgetInfoEnum.B2C_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			writeToB2c(info);
		}
		else if(BudgetInfoEnum.TECH_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			writeToTech(info);
		}
		//更新到[分解总表：out_tem_money_decompose]
		if(BudgetInfoEnum.ASSET_SPLIT.getCode().equals(info.getBudgetType())
			|| BudgetInfoEnum.GROUP_SPLIT.getCode().equals(info.getBudgetType())
			|| BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode().equals(info.getBudgetType())
			|| BudgetInfoEnum.STOCK_XTY_SPLIT.getCode().equals(info.getBudgetType())
			|| BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			writeToDecompose(info);
		}
		//更新到汇总表[out_tem_money_total]
		if(BudgetInfoEnum.GROUP_TOTAL.getCode().equals(info.getBudgetType())
			||BudgetInfoEnum.ASSETS_TOTAL.getCode().equals(info.getBudgetType())
			||BudgetInfoEnum.STOCK_TOTAL.getCode().equals(info.getBudgetType())) 
		{
			writeToMoneyTotal(info);
		}
	}
	
	//[集团分解表：out_tem_money_group]
	private void writeToGroup(BudgetInfo info) 
	{
		
	}
	//[资产分解表：out_tem_money_asset]
	private void writeToAsset(BudgetInfo info) 
	{
		
	}
	//[股份分解表：直属院out_tem_money_institute]
	private void writeToInstitute(BudgetInfo info) 
	{
		
	}
	//[股份支付集团、外系统外out_tem_money_other]
	private void writeToOther(BudgetInfo info) 
	{
		
	}
	//[分子公司out_tem_money_company]
	private void writeToCompany(BudgetInfo info) 
	{
		
	}
	//[事业部分解表：out_tem_money_b2c]
	private void writeToB2c(BudgetInfo info) 
	{
		
	}
	//[专项经费分解表：out_tem_money_tech]
	private void writeToTech(BudgetInfo info) 
	{
		
	}
	//[分解总表：out_tem_money_decompose]
	private void writeToDecompose(BudgetInfo info) 
	{
		BudgetMoneyDecomposeExample example = new BudgetMoneyDecomposeExample();
		BudgetMoneyDecomposeExample.Criteria c = example.createCriteria();
		c.andNdEqualTo(info.getNd());
		example.setOrderByClause("xh");
		List<BudgetMoneyDecompose> list = budgetMoneyDecomposeMapper.selectByExample(example);
		//如果没有则创建
		if(list.size() == 0) 
		{
			Long dataCount = budgetMoneyDecomposeMapper.countByExample(new BudgetMoneyDecomposeExample());
			Integer xh = 0;
			List<BudgetOrganEnum> organs = BudgetOrganNdEnum.getByNd(info.getNd()).getOrgans();
			for(BudgetOrganEnum org:organs) {
				dataCount++;
				xh++;
				BudgetMoneyDecompose budget = new BudgetMoneyDecompose();
				budget.setNd(info.getNd());
				budget.setCb(org.getName());
				budget.setBudgetCode(org.getCode());
				budget.setUnitCode(org.getUnitCode());
				budget.setDataId(dataCount.intValue());
				budget.setXh(xh.toString());
				budget.setGfyshjlht("0");
				budget.setGfyshjys("0");
				budget.setGfyshjxq("0");
				
				budget.setJfyszjlht("0");
				budget.setJfyszjxq("0");
				budget.setJfyszjys("0");
				
				budget.setJtyshjlht("0");
				budget.setJtyshjys("0");
				budget.setJtyshxq("0");
				
				budget.setZcyshjlht("0");
				budget.setZcyshjxq("0");
				budget.setZcyshjys("0");
				budgetMoneyDecomposeMapper.insert(budget);
			}
			list = budgetMoneyDecomposeMapper.selectByExample(example);
		}
		
		//table_data.push({"index": i,"no":d.no,"organName":d.organName,"group_total":d.group_total,"group_jz":d.group_jz,"group_xq":d.group_xq,"asset_total":0,"asset_jz":0,"asset_xq":0,"stock_total":0,"stock_jz":0,"stock_xq":0,"total":0,"jz":0,"xq":0});
		if(BudgetInfoEnum.GROUP_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			//集团汇总
			List<Map<String, Object>> groupsplit = selectGroupFinalSplit(info.getNd());
			for(int i =0;i<list.size();i++) {
				BudgetMoneyDecompose budget = list.get(i);
				
				budget.setJtyshjlht(dToI(groupsplit.get(i).get("group_jz")));//老合同
				budget.setJtyshxq(dToI(groupsplit.get(i).get("group_xq")));//新签
				budget.setJtyshjys(dToI(groupsplit.get(i).get("group_total")));
			}
		}else if(BudgetInfoEnum.ASSET_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			//资产汇总
			List<Map<String, Object>> assetsplit = selectAssetFinalSplit(info.getNd());
			for(int i =0;i<list.size();i++) {
				BudgetMoneyDecompose budget = list.get(i);
				budget.setZcyshjlht(dToI(assetsplit.get(i).get("asset_jz")));//老合同
				budget.setZcyshjxq(dToI(assetsplit.get(i).get("asset_xq")));
				budget.setZcyshjys(dToI(assetsplit.get(i).get("asset_total")));
			}
		}else if (BudgetInfoEnum.STOCK_XTY_SPLIT.getCode().equals(info.getBudgetType()) || BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode().equals(info.getBudgetType()) || BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode().equals(info.getBudgetType())) 
		{
			//股份汇总
			List<Map<String, Object>> stocksplit = selectStockFinalSplit(info.getNd());
			for(int i =0;i<list.size();i++) {
				BudgetMoneyDecompose budget = list.get(i);
				budget.setGfyshjlht(dToI(stocksplit.get(i).get("stock_jz")));//老合同
				budget.setGfyshjxq(dToI(stocksplit.get(i).get("stock_xq")));
				budget.setGfyshjys(dToI(stocksplit.get(i).get("stock_total")));
			}
		}
		//计算总数
		for(int i =0;i<list.size();i++) {
			BudgetMoneyDecompose budget = list.get(i);
			
			Integer jz = new Double(budget.getJtyshjlht()).intValue()+new Double(budget.getZcyshjlht()).intValue() + new Double(budget.getGfyshjlht()).intValue();
			Integer xq = new Double(budget.getJtyshxq()).intValue()+new Double(budget.getZcyshjxq()).intValue() + new Double(budget.getGfyshjxq()).intValue();
			Integer ys = new Double(budget.getJtyshjys()).intValue()+new Double(budget.getZcyshjys()).intValue()+ new Double(budget.getGfyshjys()).intValue();
			
			budget.setJfyszjlht(jz.toString());
			budget.setJfyszjxq(xq.toString());
			budget.setJfyszjys(ys.toString());
			
			
			budgetMoneyDecomposeMapper.updateByPrimaryKey(budget);
		}
	}
	private void writeToMoneyTotal(BudgetInfo info) throws Exception 
	{
		//获得最终预算
		BudgetInfo stock = selectFinalBudget(info.getNd(),BudgetInfoEnum.STOCK_TOTAL.getCode());
		BudgetInfo group = selectFinalBudget(info.getNd(),BudgetInfoEnum.GROUP_TOTAL.getCode());
		BudgetInfo asset = selectFinalBudget(info.getNd(),BudgetInfoEnum.ASSETS_TOTAL.getCode());
		//先删除清空
		BudgetMoneyTotal bean = new BudgetMoneyTotal();
		bean.setNd(info.getNd());
		List<BudgetMoneyTotal> totals = budgetMoneyTotalService.selectListBudgetMoneyTotalByBean(bean);
		for(BudgetMoneyTotal t:totals) {
			budgetMoneyTotalService.deleteBudgetMoneyTotalReal(t.getDataId());
		}
		//创建顺序[股份，集团，资产]
		List<BudgetMoneyTotal> saves = new ArrayList<BudgetMoneyTotal>();
		//股份
		BudgetMoneyTotal stockTotal = new BudgetMoneyTotal();
		stockTotal.setDataId(info.getNd()+"_"+(saves.size()+1000));
		stockTotal.setNo(saves.size()+1);
		stockTotal.setNd(info.getNd());
		stockTotal.setUnitName("一、股份公司合计");
		stockTotal.setShowAli("股份公司");
		stockTotal.setZbxMoney("0");//资本性
		stockTotal.setFyxMoney("0");//费用性
		stockTotal.setMoneyLevel("1");
		stockTotal.setTypeName("gfgs");
		stockTotal.setSheetFlag(info.getNd()+"年预算总表");
		stockTotal.setBudgetType(BudgetInfoEnum.STOCK_TOTAL.getCode());
		saves.add(stockTotal);
		if(stock != null) 
		{
			Integer xmjfZbx=0,xmjfFyx=0;
			Map<String,Object> maps = budgetStockTotalService.selectFinalStockTotalBudget(stock);
			JSONArray array = JSON.parseArray(JSON.toJSONString(maps.get("items")));
			for(java.util.Iterator<?> iter = array.iterator();iter.hasNext();) 
			{
				String str = JSON.toJSON(iter.next()).toString();
				BudgetStockTotal b = JSON.toJavaObject(JSON.parseObject(str), BudgetStockTotal.class);
				BudgetMoneyTotal t = new BudgetMoneyTotal();
				t.setDataId(info.getNd()+"_"+(saves.size()+1000));
				//t.setParentDataId(stockTotal.getDataId());
				t.setNo(saves.size()+1);
				t.setBudgetCode(b.getDisplayCode());
				t.setBudgetType(BudgetInfoEnum.STOCK_TOTAL.getCode());
				t.setBudgetInfoId(stock.getDataId());
				t.setNd(b.getNd());
				t.setUnitName(b.getDisplayName());
				t.setShowAli(b.getSimpleName());
				t.setZbxMoney(b.getXmjfZbx().intValue()+"");
				t.setFyxMoney(b.getXmjfFyx().intValue()+"");
				t.setMoneyLevel(new Integer(2+b.getLevel()).toString());
				t.setShowIndex(b.getLevel()==0?b.getNo().toString():"");
				t.setTypeName("gfgs");
				t.setSheetFlag(info.getNd()+"年预算总表");
				t.setUnitCode(BudgetStockEnum.getByCode(b.getDisplayCode())!=null?BudgetStockEnum.getByCode(b.getDisplayCode()).getUnitCode():null);
				if(b.getLevel()==0) {
					xmjfZbx += b.getXmjfZbx().intValue();
					xmjfFyx += b.getXmjfFyx().intValue();
				}
				saves.add(t);
			}
			stockTotal.setBudgetInfoId(stock.getDataId());
			stockTotal.setZbxMoney(xmjfZbx+"");//资本性
			stockTotal.setFyxMoney(xmjfFyx+"");//费用性
		}
		//集团公司
		BudgetMoneyTotal groupTotal = new BudgetMoneyTotal();
		groupTotal.setDataId(info.getNd()+"_"+(saves.size()+1000));
		groupTotal.setNd(info.getNd());
		groupTotal.setUnitName("二、集团公司合计");
		groupTotal.setShowAli("集团公司");
		groupTotal.setZbxMoney("0");//资本性
		groupTotal.setFyxMoney("0");//费用性
		groupTotal.setMoneyLevel("1");
		groupTotal.setTypeName("jtgs");
		groupTotal.setSheetFlag(info.getNd()+"年预算总表");
		groupTotal.setNo(saves.size()+1);
		groupTotal.setBudgetType(BudgetInfoEnum.GROUP_TOTAL.getCode());
		saves.add(groupTotal);
		if(group != null) 
		{
			Map<String,Object> maps = budgetGroupTotalService.selectFinalGroupTotalBudget(group);
			groupTotal.setFyxMoney(new Double(maps.get("items_total").toString()).intValue()+"");
			
			groupTotal.setBudgetInfoId(group.getDataId());
		}
		
		//资产公司
		BudgetMoneyTotal assetTotal = new BudgetMoneyTotal();
		assetTotal.setDataId(info.getNd()+"_"+(saves.size()+1000));
		assetTotal.setNd(info.getNd());
		assetTotal.setUnitName("三、资产公司合计");
		assetTotal.setShowAli("资产公司");
		assetTotal.setZbxMoney("0");//资本性
		assetTotal.setFyxMoney("0");//费用性
		assetTotal.setMoneyLevel("1");
		assetTotal.setTypeName("zcgs");
		assetTotal.setSheetFlag(info.getNd()+"年预算总表");
		assetTotal.setNo(saves.size()+1);
		assetTotal.setBudgetType(BudgetInfoEnum.ASSETS_TOTAL.getCode());
		saves.add(assetTotal);
		if(asset != null) 
		{
			Map<String,Object> maps = budgetAssetTotalService.selectFinalAssetTotalBudget(asset);
			assetTotal.setFyxMoney(new Double(maps.get("items_total").toString()).intValue()+"");
			
			assetTotal.setBudgetInfoId(asset.getDataId());
		}
		//保存
		for(java.util.Iterator<BudgetMoneyTotal> iter= saves.iterator();iter.hasNext();) 
		{
			BudgetMoneyTotal total = iter.next();
			total.setBak1(DateUtils.dateToStr(new Date(), DateUtils.FMT_SS));	
			budgetMoneyTotalService.saveBudgetMoneyTotal(total);
		}
	}
	private String dToI(Object obj) 
	{
		return new Double(obj.toString()).intValue()+"";
	}
	
}
