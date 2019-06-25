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
import com.pcitc.base.stp.budget.BudgetStockTotal;
import com.pcitc.base.stp.budget.BudgetStockTotalExample;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.mapper.budget.BudgetStockTotalMapper;
import com.pcitc.service.budget.BudgetStockTotalService;
import com.pcitc.service.feign.SystemRemoteClient;

@Service("budgetStockTotalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetStockTotalServiceImpl implements BudgetStockTotalService
{

	@Autowired
	private BudgetStockTotalMapper budgetStockTotalMapper;
	
	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@Override
	public BudgetStockTotal selectBudgetStockTotal(String dataId) throws Exception
	{
		return budgetStockTotalMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetStockTotal(BudgetStockTotal groupTotal) throws Exception
	{
		
		return budgetStockTotalMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetStockTotal(String id) throws Exception
	{
		BudgetStockTotal group = budgetStockTotalMapper.selectByPrimaryKey(id);
		if(group != null) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetStockTotalMapper.updateByPrimaryKey(group);
		}
		return 0;
	}

	@Override
	public List<BudgetStockTotal> selectBudgetStockTotalListByIds(List<String> list) throws Exception
	{
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andDataIdIn(list);
		return budgetStockTotalMapper.selectByExample(example);
	}

	@Override
	public Integer saveOrUpdateBudgetStockTotal(BudgetStockTotal budgetGroupTotal) throws Exception
	{
		BudgetStockTotal old = budgetStockTotalMapper.selectByPrimaryKey(budgetGroupTotal.getDataId());
		if(old == null) {
			return budgetStockTotalMapper.insert(budgetGroupTotal);
		}else {
			MyBeanUtils.copyProperties(budgetGroupTotal, old);
			return budgetStockTotalMapper.updateByPrimaryKey(old);
		}
	}

	@Override
	public List<BudgetStockTotal> selectItemsByBudgetId(String budgetInfoId) throws Exception
	{
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		example.setOrderByClause("no");
		List<BudgetStockTotal> list =  budgetStockTotalMapper.selectByExample(example);
		Collections.sort(list, new java.util.Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				BudgetStockTotal t1 = (BudgetStockTotal)o1;
				BudgetStockTotal t2 = (BudgetStockTotal)o2;
				return t1.getNo()-t2.getNo();
			}
		});
		//根据父Id排序
		List<BudgetStockTotal> ls = new ArrayList<BudgetStockTotal>();
		for(java.util.Iterator<?> iter = list.iterator();iter.hasNext();) {
			BudgetStockTotal stock = (BudgetStockTotal)iter.next();
			if(stock.getLevel()==0) {
				ls.add(stock);
				//添加子项
				for(java.util.Iterator<?> siter = list.iterator();siter.hasNext();) {
					BudgetStockTotal sstock = (BudgetStockTotal)siter.next();
					if(sstock.getLevel()==1 && stock.getDataId().equals(sstock.getParentDataId())) {
						ls.add(sstock);
					}
				}
			}
		}
		return ls;
	}

	@Override
	public LayuiTableData selectBudgetStockTotalPage(LayuiTableParam param) throws Exception
	{
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_PROJECT.getCode());
		example.setOrderByClause("no");
		LayuiTableData tabledata = this.findByExample(param, example);
		//根据级别排序
		Collections.sort(tabledata.getData(), new java.util.Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				BudgetStockTotal t1 = (BudgetStockTotal)o1;
				BudgetStockTotal t2 = (BudgetStockTotal)o2;
				return t1.getNo()-t2.getNo();
			}
		});
		//根据父Id排序
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = tabledata.getData().iterator();iter.hasNext();) {
			BudgetStockTotal stock = (BudgetStockTotal)iter.next();
			if(stock.getLevel()==0) {
				ls.add(MyBeanUtils.transBean2Map(stock));
				//添加子项
				for(java.util.Iterator<?> siter = tabledata.getData().iterator();siter.hasNext();) {
					BudgetStockTotal sstock = (BudgetStockTotal)siter.next();
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
	private LayuiTableData findByExample(LayuiTableParam param,BudgetStockTotalExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetStockTotal> list = budgetStockTotalMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetStockTotal> pageInfo= new PageInfo<BudgetStockTotal>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int deleteBudgetStockTotalByInfo(String budgetInfoId) throws Exception
	{
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		List<BudgetStockTotal> list = budgetStockTotalMapper.selectByExample(example);
		
		Integer rs = 0;
		for(BudgetStockTotal group:list) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs += budgetStockTotalMapper.updateByPrimaryKey(group);
		}
		return rs;
	}

	@Override
	public List<BudgetStockTotal> selectChildBudgetStockTotal(String dataId)
	{
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andParentDataIdEqualTo(dataId);
		example.setOrderByClause("no");
		return budgetStockTotalMapper.selectByExample(example);
	}
	@Override
	public List<BudgetStockTotal> selectBudgetStockTotalCompanyItem(String dataId)
	{
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andItemTypeEqualTo(BudgetItemTypeEnum.BUDGET_ITEM_COMPANY.getCode());
		c.andParentDataIdEqualTo(dataId);
		return budgetStockTotalMapper.selectByExample(example);
	}
	@Override
	public List<BudgetStockTotal> selectChildBudgetStockTotalAll(String dataId) {
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andParentDataIdEqualTo(dataId);
		example.setOrderByClause("no");
		return budgetStockTotalMapper.selectByExample(example);
	}

	@Override
	public List<BudgetStockTotal> selectStockTotalHistoryItems(BudgetStockTotal item) {
		//检索已通过审核的资产预算
		BudgetInfoExample infoExample = new BudgetInfoExample();
		BudgetInfoExample.Criteria infoc = infoExample.createCriteria();
		infoc.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		infoc.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		infoc.andBudgetTypeEqualTo(BudgetInfoEnum.STOCK_TOTAL.getCode());
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(infoExample);
		Set<String> ids = new HashSet<String>();
		ids.add("xxxx");//避免为空
		for(BudgetInfo info:infos) {
			ids.add(info.getDataId());
		}
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdIn(new ArrayList<String>(ids));
		c.andNdNotEqualTo(item.getNd());
		c.andDisplayNameEqualTo(item.getDisplayName());
		example.setOrderByClause("nd desc");
		return budgetStockTotalMapper.selectByExample(example);
	}

	@Override
	public List<BudgetStockTotal> selectBudgetStockTotalByInfoId(String budgetId) throws Exception 
	{
		BudgetStockTotalExample example = new BudgetStockTotalExample();
		BudgetStockTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetId);
		example.setOrderByClause("no");
		return budgetStockTotalMapper.selectByExample(example);
	}
	@Override
	public List<OutUnit> selectStockCompnays() {
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
		List<BudgetStockTotal> templates = selectBudgetStockTotalByInfoId(dataId);
		Map<String,String> idRel = new HashMap<String,String>();//新老ID对照
		for(BudgetStockTotal total:templates) 
		{
			String newId = IdUtil.createIdByTime();
			idRel.put(total.getDataId(), newId);
			
			total.setBudgetInfoId(newInfo.getDataId());
			total.setDataVersion(newInfo.getDataVersion());
			total.setNd(newInfo.getNd());
			total.setDataId(newId);
			total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			saveOrUpdateBudgetStockTotal(total);
		}
		//处理二级预算单位
		templates = selectBudgetStockTotalByInfoId(newInfo.getDataId());
		for(BudgetStockTotal total:templates) 
		{
			if(total.getLevel()>0 && total.getParentDataId() != null) {
				total.setParentDataId(idRel.get(total.getParentDataId()));
				updateBudgetStockTotal(total);
			}
		}
		return newInfo;
	}
}
