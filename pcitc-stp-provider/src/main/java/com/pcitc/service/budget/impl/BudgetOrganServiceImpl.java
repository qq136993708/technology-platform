package com.pcitc.service.budget.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;
import com.pcitc.mapper.budget.BudgetOrganMapper;
import com.pcitc.service.budget.BudgetOrganService;
/**
 * 
 * @author uuy
 *
 */
@Service("budgetOrganService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOrganServiceImpl implements BudgetOrganService
{

	@Autowired
	public BudgetOrganMapper mapper;
	
	
	
	
	@Override
	public BudgetOrgan selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LayuiTableData selectTableData(LayuiTableParam param, BudgetOrganExample e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BudgetOrgan> selectListData(BudgetOrganExample e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateBean(BudgetOrgan bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean deleteBean(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean saveBean(BudgetOrgan bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean saveOrUpdBean(String id, BudgetOrgan bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BudgetOrgan selectBudgetOrgan(String dataId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result saveBudgetOrgan(BudgetOrgan bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateBudgetOrgan(BudgetOrgan bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result deleteBudgetOrgan(String dataId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrgan() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
