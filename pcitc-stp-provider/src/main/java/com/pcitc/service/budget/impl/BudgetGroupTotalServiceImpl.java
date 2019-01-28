package com.pcitc.service.budget.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetGroupTotalExample;
import com.pcitc.mapper.budget.BudgetGroupTotalMapper;
import com.pcitc.service.budget.BudGetGroupTotalService;

@Service("budgetGroupTotalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetGroupTotalServiceImpl implements BudGetGroupTotalService
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
		return 0;
	}

	@Override
	public List<BudgetGroupTotal> selectBudgetGroupTotalListByIds(List<String> list) throws Exception
	{
		return null;
	}

	@Override
	public Integer insertBudgetGroupTotal(BudgetGroupTotal budgetGroupTotal) throws Exception
	{
		return null;
	}

	@Override
	public List<BudgetGroupTotal> selectBudgetGroupTotalList(BudgetGroupTotalExample example) throws Exception
	{
		return null;
	}

	@Override
	public LayuiTableData selectBudgetGroupTotalPage(LayuiTableParam param) throws Exception
	{
		return null;
	}

}
