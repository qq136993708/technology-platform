package com.pcitc.service.budget.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetGroupTotalExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetGroupTotalMapper;
import com.pcitc.service.budget.BudgetGroupTotalService;

@Service("budgetGroupTotalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetGroupTotalServiceImpl implements BudgetGroupTotalService
{

	@Autowired
	private BudgetGroupTotalMapper budgetGroupTotalMapper;
	
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
			return budgetGroupTotalMapper.deleteByPrimaryKey(id);
		}
		return 0;
	}

	@Override
	public List<BudgetGroupTotal> selectBudgetGroupTotalListByIds(List<String> list) throws Exception
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
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
	public List<BudgetGroupTotal> selectBudgetInfoId(String budgetInfoId) throws Exception
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		example.setOrderByClause("no");
		return budgetGroupTotalMapper.selectByExample(example);
	}

	@Override
	public LayuiTableData selectBudgetGroupTotalPage(LayuiTableParam param) throws Exception
	{
		BudgetGroupTotalExample example = new BudgetGroupTotalExample();
		BudgetGroupTotalExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		
		example.setOrderByClause("no");
		return this.findByExample(param, example);
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

}
