package com.pcitc.service.budget.impl;

import java.util.ArrayList;
import java.util.Collections;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetItemTypeEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.budget.BudgetTechSplit;
import com.pcitc.base.stp.budget.BudgetTechSplitExample;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.mapper.budget.BudgetTechSplitMapper;
import com.pcitc.service.budget.BudgetTechSplitService;
import com.pcitc.service.feign.SystemRemoteClient;

@Service("budgetTechSplitService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetTechSplitServiceImpl implements BudgetTechSplitService
{

	@Autowired
	private BudgetTechSplitMapper budgetTechSplitMapper;
	
	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@Override
	public BudgetTechSplit selectBudgetTechSplit(String dataId) throws Exception
	{
		return budgetTechSplitMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetTechSplit(BudgetTechSplit groupTotal) throws Exception
	{
		
		return budgetTechSplitMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetTechSplit(String id) throws Exception
	{
		BudgetTechSplit group = budgetTechSplitMapper.selectByPrimaryKey(id);
		if(group != null) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetTechSplitMapper.updateByPrimaryKey(group);
		}
		return 0;
	}

	@Override
	public List<BudgetTechSplit> selectBudgetTechSplitListByIds(List<String> list) throws Exception
	{
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andDataIdIn(list);
		return budgetTechSplitMapper.selectByExample(example);
	}

	@Override
	public Integer saveOrUpdateBudgetTechSplit(BudgetTechSplit budgetGroupTotal) throws Exception
	{
		BudgetTechSplit old = budgetTechSplitMapper.selectByPrimaryKey(budgetGroupTotal.getDataId());
		if(old == null) {
			return budgetTechSplitMapper.insert(budgetGroupTotal);
		}else {
			MyBeanUtils.copyProperties(budgetGroupTotal, old);
			return budgetTechSplitMapper.updateByPrimaryKey(old);
		}
	}

	@Override
	public List<BudgetTechSplit> selectItemsByBudgetId(String budgetInfoId) throws Exception
	{
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		example.setOrderByClause("no");
		List<BudgetTechSplit> list =  budgetTechSplitMapper.selectByExample(example);
		Collections.sort(list, new java.util.Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				BudgetTechSplit t1 = (BudgetTechSplit)o1;
				BudgetTechSplit t2 = (BudgetTechSplit)o2;
				return t1.getNo()-t2.getNo();
			}
		});
		//根据父Id排序
		List<BudgetTechSplit> ls = new ArrayList<BudgetTechSplit>();
		for(java.util.Iterator<?> iter = list.iterator();iter.hasNext();) {
			BudgetTechSplit stock = (BudgetTechSplit)iter.next();
			if(stock.getLevel()==0) {
				ls.add(stock);
				//添加子项
				for(java.util.Iterator<?> siter = list.iterator();siter.hasNext();) {
					BudgetTechSplit sstock = (BudgetTechSplit)siter.next();
					if(sstock.getLevel()==1 && stock.getDataId().equals(sstock.getParentDataId())) {
						ls.add(sstock);
					}
				}
			}
		}
		return ls;
	}

	@Override
	public LayuiTableData selectBudgetTechSplitPage(LayuiTableParam param) throws Exception
	{
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
		example.setOrderByClause("no");
		LayuiTableData tabledata = this.findByExample(param, example);
		//根据级别排序
		Collections.sort(tabledata.getData(), new java.util.Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				BudgetTechSplit t1 = (BudgetTechSplit)o1;
				BudgetTechSplit t2 = (BudgetTechSplit)o2;
				return t1.getNo()-t2.getNo();
			}
		});
		//根据父Id排序
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = tabledata.getData().iterator();iter.hasNext();) {
			BudgetTechSplit stock = (BudgetTechSplit)iter.next();
			if(stock.getLevel()==0) {
				ls.add(MyBeanUtils.transBean2Map(stock));
				//添加子项
				for(java.util.Iterator<?> siter = tabledata.getData().iterator();siter.hasNext();) {
					BudgetTechSplit sstock = (BudgetTechSplit)siter.next();
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
	private LayuiTableData findByExample(LayuiTableParam param,BudgetTechSplitExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetTechSplit> list = budgetTechSplitMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetTechSplit> pageInfo= new PageInfo<BudgetTechSplit>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int deleteBudgetTechSplitByInfo(String budgetInfoId) throws Exception
	{
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		List<BudgetTechSplit> list = budgetTechSplitMapper.selectByExample(example);
		
		Integer rs = 0;
		for(BudgetTechSplit group:list) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs += budgetTechSplitMapper.updateByPrimaryKey(group);
		}
		return rs;
	}

	@Override
	public List<BudgetTechSplit> selectChildBudgetTechSplit(String dataId)
	{
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andParentDataIdEqualTo(dataId);
		example.setOrderByClause("no");
		return budgetTechSplitMapper.selectByExample(example);
	}
	@Override
	public List<BudgetTechSplit> selectBudgetTechSplitCompanyItem(String dataId)
	{
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_COMPANY.getCode());
		c.andParentDataIdEqualTo(dataId);
		return budgetTechSplitMapper.selectByExample(example);
	}
	@Override
	public List<BudgetTechSplit> selectChildBudgetTechSplitAll(String dataId) {
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andParentDataIdEqualTo(dataId);
		example.setOrderByClause("no");
		return budgetTechSplitMapper.selectByExample(example);
	}

	@Override
	public List<BudgetTechSplit> selectTechSplitHistoryItems(BudgetTechSplit item) {
		//检索已通过审核的资产预算
		BudgetInfoExample infoExample = new BudgetInfoExample();
		BudgetInfoExample.Criteria infoc = infoExample.createCriteria();
		infoc.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		infoc.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		infoc.andBudgetTypeEqualTo(BudgetInfoEnum.TECH_SPLIT.getCode());
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(infoExample);
		Set<String> ids = new HashSet<String>();
		ids.add("xxxx");//避免为空
		for(BudgetInfo info:infos) {
			ids.add(info.getDataId());
		}
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdIn(new ArrayList<String>(ids));
		c.andNdNotEqualTo(item.getNd());
		c.andDisplayNameEqualTo(item.getDisplayName());
		example.setOrderByClause("nd desc");
		return budgetTechSplitMapper.selectByExample(example);
	}

	@Override
	public List<BudgetTechSplit> selectBudgetTechSplitByInfoId(String budgetId) throws Exception 
	{
		BudgetTechSplitExample example = new BudgetTechSplitExample();
		BudgetTechSplitExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetId);
		example.setOrderByClause("no");
		return budgetTechSplitMapper.selectByExample(example);
	}
	@Override
	public List<OutUnit> selectTechCompnays() {
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

	@Override
	public Object createBudgetItemByTemplate(String dataId, BudgetInfo newInfo) throws Exception 
	{
		List<BudgetTechSplit> templates = selectBudgetTechSplitByInfoId(dataId);
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
			saveOrUpdateBudgetTechSplit(total);
		}
		//处理二级预算单位
		templates = selectBudgetTechSplitByInfoId(newInfo.getDataId());
		for(BudgetTechSplit total:templates) 
		{
			if(total.getLevel()>0 && total.getParentDataId() != null) {
				total.setParentDataId(idRel.get(total.getParentDataId()));
				updateBudgetTechSplit(total);
			}
		}
		return newInfo;
	}
}
