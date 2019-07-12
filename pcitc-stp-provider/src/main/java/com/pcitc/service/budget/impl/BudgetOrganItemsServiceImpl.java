package com.pcitc.service.budget.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrganItems;
import com.pcitc.base.stp.budget.BudgetOrganItemsExample;
import com.pcitc.service.budget.BudgetOrganItemsService;
/**
 * 
 * @author fb
 *
 */
@Service("budgetOrganItemsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOrganItemsServiceImpl  implements BudgetOrganItemsService
{

	@Override
	public BudgetOrganItems selectByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LayuiTableData selectTableData(LayuiTableParam param, BudgetOrganItemsExample e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BudgetOrganItems> selectListData(BudgetOrganItemsExample e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateBean(BudgetOrganItems bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean deleteBean(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean saveBean(BudgetOrganItems bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean saveOrUpdBean(Serializable id, BudgetOrganItems bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BudgetOrganItems selectBudgetOrganItems(String dataId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result saveBudgetOrganItems(BudgetOrganItems bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateBudgetOrganItems(BudgetOrganItems bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result saveOrUpdBudgetOrganItems(BudgetOrganItems bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result deleteBudgetOrganItems(String dataId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BudgetOrganItems> selectListBudgetOrganItems() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BudgetOrganItems> selectListBudgetOrganItemsByBean(BudgetOrganItems bean) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LayuiTableData selectTableBudgetOrganItems(LayuiTableParam param) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
