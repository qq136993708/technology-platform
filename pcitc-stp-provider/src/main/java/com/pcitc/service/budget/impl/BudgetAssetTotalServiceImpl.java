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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetAssetTotal;
import com.pcitc.base.stp.budget.BudgetAssetTotalExample;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetAssetTotalMapper;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.service.budget.BudgetAssetTotalService;
import com.pcitc.service.feign.SystemRemoteClient;

@Service("budgetAssetTotalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetAssetTotalServiceImpl implements BudgetAssetTotalService
{

	@Autowired
	private BudgetAssetTotalMapper budgetAssetTotalMapper;
	
	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@Override
	public BudgetAssetTotal selectBudgetAssetTotal(String dataId) throws Exception
	{
		return budgetAssetTotalMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetAssetTotal(BudgetAssetTotal groupTotal) throws Exception
	{
		
		return budgetAssetTotalMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetAssetTotal(String id) throws Exception
	{
		BudgetAssetTotal group = budgetAssetTotalMapper.selectByPrimaryKey(id);
		if(group != null) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetAssetTotalMapper.updateByPrimaryKey(group);
		}
		return 0;
	}

	@Override
	public List<BudgetAssetTotal> selectBudgetAssetTotalListByIds(List<String> list) throws Exception
	{
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andDataIdIn(list);
		return budgetAssetTotalMapper.selectByExample(example);
	}

	@Override
	public Integer saveOrUpdateBudgetAssetTotal(BudgetAssetTotal budgetGroupTotal) throws Exception
	{
		BudgetAssetTotal old = budgetAssetTotalMapper.selectByPrimaryKey(budgetGroupTotal.getDataId());
		if(old == null) {
			return budgetAssetTotalMapper.insert(budgetGroupTotal);
		}else {
			MyBeanUtils.copyProperties(budgetGroupTotal, old);
			return budgetAssetTotalMapper.updateByPrimaryKey(old);
		}
	}

	@Override
	public List<BudgetAssetTotal> selectItemsByBudgetId(String budgetInfoId) throws Exception
	{
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		c.andLevelEqualTo(0);//只显示第一级
		example.setOrderByClause("no");
		return budgetAssetTotalMapper.selectByExample(example);
	}

	@Override
	public LayuiTableData selectBudgetAssetTotalPage(LayuiTableParam param) throws Exception
	{
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andLevelEqualTo(0);//只显示第一级
		example.setOrderByClause("no");
		LayuiTableData tabledata = this.findByExample(param, example);
		
		List<Map<String,Object>> ls = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = tabledata.getData().iterator();iter.hasNext();) 
		{
			Map<String,Object> mp  = MyBeanUtils.transBean2Map(iter.next());
			//mp.put("total", new Double(mp.get("yjwc").toString()) + new Double(mp.get("xmjf").toString()));
			mp.put("plan_money", 0);
			mp.put("last_year_end", 0);
			ls.add(mp);
		}
		tabledata.setData(ls);
		return tabledata;
	}
	private LayuiTableData findByExample(LayuiTableParam param,BudgetAssetTotalExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetAssetTotal> list = budgetAssetTotalMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetAssetTotal> pageInfo= new PageInfo<BudgetAssetTotal>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int deleteBudgetAssetTotalByInfo(String budgetInfoId) throws Exception
	{
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		List<BudgetAssetTotal> list = budgetAssetTotalMapper.selectByExample(example);
		
		Integer rs = 0;
		for(BudgetAssetTotal group:list) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs += budgetAssetTotalMapper.updateByPrimaryKey(group);
		}
		return rs;
	}

	@Override
	public List<BudgetAssetTotal> selectChildBudgetAssetTotal(String dataId)
	{
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andParentDataIdEqualTo(dataId);
		c.andLevelEqualTo(1);//只显示第二级
		example.setOrderByClause("no");
		return budgetAssetTotalMapper.selectByExample(example);
	}
	@Override
	public List<BudgetAssetTotal> selectChildBudgetAssetTotalAll(String dataId) {
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andParentDataIdEqualTo(dataId);
		c.andLevelEqualTo(1);//只显示第二级
		example.setOrderByClause("no");
		return budgetAssetTotalMapper.selectByExample(example);
	}

	@Override
	public List<BudgetAssetTotal> selectAssetTotalHistoryItems(BudgetAssetTotal item) {
		//检索已通过审核的资产预算
		BudgetInfoExample infoExample = new BudgetInfoExample();
		BudgetInfoExample.Criteria infoc = infoExample.createCriteria();
		infoc.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		infoc.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		infoc.andBudgetTypeEqualTo(BudgetInfoEnum.ASSETS_TOTAL.getCode());
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(infoExample);
		Set<String> ids = new HashSet<String>();
		ids.add("xxxx");//避免为空
		for(BudgetInfo info:infos) {
			ids.add(info.getDataId());
		}
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdIn(new ArrayList<String>(ids));
		c.andNdNotEqualTo(item.getNd());
		c.andDisplayNameEqualTo(item.getDisplayName());
		c.andLevelEqualTo(0);//只显示第1级
		example.setOrderByClause("nd desc");
		return budgetAssetTotalMapper.selectByExample(example);
	}

	@Override
	public List<BudgetAssetTotal> selectBudgetAssetTotalByInfoId(String budgetId) throws Exception 
	{
		BudgetAssetTotalExample example = new BudgetAssetTotalExample();
		BudgetAssetTotalExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetId);
		example.setOrderByClause("no");
		return budgetAssetTotalMapper.selectByExample(example);
	}
	@Override
	public List<OutUnit> selectAssetCompnays() {
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
	public Object createBudgetItemByTemplate(String dataId, BudgetInfo newInfo) throws Exception {
		List<BudgetAssetTotal> templates = selectBudgetAssetTotalByInfoId(dataId);
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
			saveOrUpdateBudgetAssetTotal(total);
		}
		//处理二级预算单位
		templates = selectBudgetAssetTotalByInfoId(newInfo.getDataId());
		for(BudgetAssetTotal total:templates) 
		{
			if(total.getLevel()>0 && total.getParentDataId() != null) {
				total.setParentDataId(idRel.get(total.getParentDataId()));
				updateBudgetAssetTotal(total);
			}
		}
		return newInfo;
	}
}
