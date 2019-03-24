package com.pcitc.service.budget.impl;

import java.util.ArrayList;
import java.util.Collections;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetItemTypeEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.budget.BudgetB2cSplit;
import com.pcitc.base.stp.budget.BudgetB2cSplitExample;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.common.BudgetInfoEnum;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.mapper.budget.BudgetB2cSplitMapper;
import com.pcitc.service.budget.BudgetB2cSplitService;
import com.pcitc.service.feign.SystemRemoteClient;

@Service("budgetB2cSplitService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetB2cSplitServiceImpl implements BudgetB2cSplitService
{

	@Autowired
	private BudgetB2cSplitMapper budgetB2cSplitMapper;
	
	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@Override
	public BudgetB2cSplit selectBudgetB2cSplit(String dataId) throws Exception
	{
		return budgetB2cSplitMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetB2cSplit(BudgetB2cSplit groupTotal) throws Exception
	{
		
		return budgetB2cSplitMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetB2cSplit(String id) throws Exception
	{
		BudgetB2cSplit group = budgetB2cSplitMapper.selectByPrimaryKey(id);
		if(group != null) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetB2cSplitMapper.updateByPrimaryKey(group);
		}
		return 0;
	}

	@Override
	public List<BudgetB2cSplit> selectBudgetB2cSplitListByIds(List<String> list) throws Exception
	{
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andDataIdIn(list);
		return budgetB2cSplitMapper.selectByExample(example);
	}

	@Override
	public Integer saveOrUpdateBudgetB2cSplit(BudgetB2cSplit budgetGroupTotal) throws Exception
	{
		BudgetB2cSplit old = budgetB2cSplitMapper.selectByPrimaryKey(budgetGroupTotal.getDataId());
		if(old == null) {
			return budgetB2cSplitMapper.insert(budgetGroupTotal);
		}else {
			MyBeanUtils.copyProperties(budgetGroupTotal, old);
			return budgetB2cSplitMapper.updateByPrimaryKey(old);
		}
	}

	@Override
	public List<BudgetB2cSplit> selectItemsByBudgetId(String budgetInfoId) throws Exception
	{
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		example.setOrderByClause("no");
		List<BudgetB2cSplit> list =  budgetB2cSplitMapper.selectByExample(example);
		Collections.sort(list, new java.util.Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				BudgetB2cSplit t1 = (BudgetB2cSplit)o1;
				BudgetB2cSplit t2 = (BudgetB2cSplit)o2;
				return t1.getNo()-t2.getNo();
			}
		});
		//根据父Id排序
		List<BudgetB2cSplit> ls = new ArrayList<BudgetB2cSplit>();
		for(java.util.Iterator<?> iter = list.iterator();iter.hasNext();) {
			BudgetB2cSplit stock = (BudgetB2cSplit)iter.next();
			if(stock.getLevel()==0) {
				ls.add(stock);
				//添加子项
				for(java.util.Iterator<?> siter = list.iterator();siter.hasNext();) {
					BudgetB2cSplit sstock = (BudgetB2cSplit)siter.next();
					if(sstock.getLevel()==1 && stock.getDataId().equals(sstock.getParentDataId())) {
						ls.add(sstock);
					}
				}
			}
		}
		return ls;
	}

	@Override
	public LayuiTableData selectBudgetB2cSplitPage(LayuiTableParam param) throws Exception
	{
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
		example.setOrderByClause("no");
		LayuiTableData tabledata = this.findByExample(param, example);
		//根据级别排序
		Collections.sort(tabledata.getData(), new java.util.Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				BudgetB2cSplit t1 = (BudgetB2cSplit)o1;
				BudgetB2cSplit t2 = (BudgetB2cSplit)o2;
				return t1.getNo()-t2.getNo();
			}
		});
		//根据父Id排序
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = tabledata.getData().iterator();iter.hasNext();) {
			BudgetB2cSplit stock = (BudgetB2cSplit)iter.next();
			if(stock.getLevel()==0) {
				ls.add(MyBeanUtils.transBean2Map(stock));
				//添加子项
				for(java.util.Iterator<?> siter = tabledata.getData().iterator();siter.hasNext();) {
					BudgetB2cSplit sstock = (BudgetB2cSplit)siter.next();
					if(sstock.getLevel()==1 && stock.getDataId().equals(sstock.getParentDataId())) {
						ls.add(MyBeanUtils.transBean2Map(sstock));
					}
				}
			}
		}
		for(java.util.Iterator<Map<String,Object>> iter = ls.iterator();iter.hasNext();) 
		{
			Map<String,Object> mp = iter.next();
			mp.put("plan_money", "无");
			mp.put("last_year_end", "无");
		}
		tabledata.setData(ls);
		return tabledata;
	}
	private LayuiTableData findByExample(LayuiTableParam param,BudgetB2cSplitExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetB2cSplit> list = budgetB2cSplitMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetB2cSplit> pageInfo= new PageInfo<BudgetB2cSplit>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int deleteBudgetB2cSplitByInfo(String budgetInfoId) throws Exception
	{
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		List<BudgetB2cSplit> list = budgetB2cSplitMapper.selectByExample(example);
		
		Integer rs = 0;
		for(BudgetB2cSplit group:list) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs += budgetB2cSplitMapper.updateByPrimaryKey(group);
		}
		return rs;
	}

	@Override
	public List<BudgetB2cSplit> selectChildBudgetB2cSplit(String dataId)
	{
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andParentDataIdEqualTo(dataId);
		example.setOrderByClause("no");
		return budgetB2cSplitMapper.selectByExample(example);
	}
	@Override
	public List<BudgetB2cSplit> selectBudgetB2cSplitCompanyItem(String dataId)
	{
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_COMPANY.getCode());
		c.andParentDataIdEqualTo(dataId);
		return budgetB2cSplitMapper.selectByExample(example);
	}
	@Override
	public List<BudgetB2cSplit> selectChildBudgetB2cSplitAll(String dataId) {
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andParentDataIdEqualTo(dataId);
		example.setOrderByClause("no");
		return budgetB2cSplitMapper.selectByExample(example);
	}

	@Override
	public List<BudgetB2cSplit> selectB2cSplitHistoryItems(BudgetB2cSplit item) {
		//检索已通过审核的资产预算
		BudgetInfoExample infoExample = new BudgetInfoExample();
		BudgetInfoExample.Criteria infoc = infoExample.createCriteria();
		infoc.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		infoc.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		infoc.andBudgetTypeEqualTo(BudgetInfoEnum.B2C_SPLIT.getCode());
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(infoExample);
		Set<String> ids = new HashSet<String>();
		ids.add("xxxx");//避免为空
		for(BudgetInfo info:infos) {
			ids.add(info.getDataId());
		}
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdIn(new ArrayList<String>(ids));
		c.andNdNotEqualTo(item.getNd());
		c.andDisplayNameEqualTo(item.getDisplayName());
		example.setOrderByClause("nd desc");
		return budgetB2cSplitMapper.selectByExample(example);
	}

	@Override
	public List<BudgetB2cSplit> selectBudgetB2cSplitByInfoId(String budgetId) throws Exception 
	{
		BudgetB2cSplitExample example = new BudgetB2cSplitExample();
		BudgetB2cSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetId);
		example.setOrderByClause("no");
		return budgetB2cSplitMapper.selectByExample(example);
	}
	@Override
	public List<OutUnit> selectB2cCompnays() {
		return systemRemoteClient.selectProjectUnits("ZCGS");
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
}
