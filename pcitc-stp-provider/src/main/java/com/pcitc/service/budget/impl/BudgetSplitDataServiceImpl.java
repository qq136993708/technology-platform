package com.pcitc.service.budget.impl;

import java.util.ArrayList;
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
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.BudgetSplitDataExample;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.mapper.budget.BudgetSplitDataMapper;
import com.pcitc.service.budget.BudgetSplitDataService;
import com.pcitc.service.feign.SystemRemoteClient;

@Service("budgetSplitDataService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetSplitDataServiceImpl implements BudgetSplitDataService
{

	@Autowired
	private BudgetSplitDataMapper budgetB2cSplitMapper;
	
	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@Override
	public BudgetSplitData selectBudgetSplitData(String dataId) throws Exception
	{
		return budgetB2cSplitMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetSplitData(BudgetSplitData groupTotal) throws Exception
	{
		
		return budgetB2cSplitMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetSplitData(String id) throws Exception
	{
		BudgetSplitData group = budgetB2cSplitMapper.selectByPrimaryKey(id);
		if(group != null) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetB2cSplitMapper.updateByPrimaryKey(group);
		}
		return 0;
	}

	@Override
	public List<BudgetSplitData> selectBudgetSplitDataListByIds(List<String> list) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andDataIdIn(list);
		return budgetB2cSplitMapper.selectByExample(example);
	}

	@Override
	public Integer saveOrUpdateBudgetSplitData(BudgetSplitData budgetGroupTotal) throws Exception
	{
		BudgetSplitData old = budgetB2cSplitMapper.selectByPrimaryKey(budgetGroupTotal.getDataId());
		if(old == null) {
			return budgetB2cSplitMapper.insert(budgetGroupTotal);
		}else {
			MyBeanUtils.copyProperties(budgetGroupTotal, old);
			return budgetB2cSplitMapper.updateByPrimaryKey(old);
		}
	}

	@Override
	public List<BudgetSplitData> selectItemsByBudgetId(String budgetInfoId) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		example.setOrderByClause("no");
		List<BudgetSplitData> list =  budgetB2cSplitMapper.selectByExample(example);
		return list;
	}

	@Override
	public LayuiTableData selectBudgetSplitDataPage(LayuiTableParam param) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		example.setOrderByClause("no");
		LayuiTableData tabledata = this.findByExample(param, example);
		return tabledata;
	}
	private LayuiTableData findByExample(LayuiTableParam param,BudgetSplitDataExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetSplitData> list = budgetB2cSplitMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetSplitData> pageInfo= new PageInfo<BudgetSplitData>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int deleteBudgetSplitDataByInfo(String budgetInfoId) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		List<BudgetSplitData> list = budgetB2cSplitMapper.selectByExample(example);
		
		Integer rs = 0;
		for(BudgetSplitData group:list) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs += budgetB2cSplitMapper.updateByPrimaryKey(group);
		}
		return rs;
	}

	@Override
	public List<BudgetSplitData> selectChildBudgetSplitData(String dataId)
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		example.setOrderByClause("no");
		return budgetB2cSplitMapper.selectByExample(example);
	}
	@Override
	public List<BudgetSplitData> selectBudgetSplitDataCompanyItem(String dataId)
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		return budgetB2cSplitMapper.selectByExample(example);
	}
	@Override
	public List<BudgetSplitData> selectChildBudgetSplitDataAll(String dataId) {
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		example.setOrderByClause("no");
		return budgetB2cSplitMapper.selectByExample(example);
	}

	@Override
	public List<BudgetSplitData> selectB2cSplitHistoryItems(BudgetSplitData item) {
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
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdIn(new ArrayList<String>(ids));
		c.andNdNotEqualTo(item.getNd());
		example.setOrderByClause("nd desc");
		return budgetB2cSplitMapper.selectByExample(example);
	}

	@Override
	public List<BudgetSplitData> selectBudgetSplitDataByInfoId(String budgetId) throws Exception 
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetId);
		example.setOrderByClause("no");
		return budgetB2cSplitMapper.selectByExample(example);
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
