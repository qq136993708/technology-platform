package com.pcitc.service.expenses.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.expenses.ExpensesBills;
import com.pcitc.base.stp.expenses.ExpensesBillsApproves;
import com.pcitc.base.stp.expenses.ExpensesBillsItem;
import com.pcitc.base.stp.expenses.ExpensesBillsPay;
import com.pcitc.mapper.expenses.ExpensesBillsApprovesMapper;
import com.pcitc.mapper.expenses.ExpensesBillsItemMapper;
import com.pcitc.mapper.expenses.ExpensesBillsMapper;
import com.pcitc.mapper.expenses.ExpensesBillsPayMapper;
import com.pcitc.service.expenses.ExpensesService;

@Service("expensesService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ExpensesServiceImpl implements ExpensesService {

	@Autowired
	private ExpensesBillsMapper expensesBillsMapper;
	
	@Autowired
	private ExpensesBillsPayMapper expensesBillsPayMapper;
	
	@Autowired
	private ExpensesBillsItemMapper expensesBillsItemMapper;
	
	@Autowired
	private ExpensesBillsApprovesMapper expensesBillsApprovesMapper;
	
	/**
	 * @return
	 * 查询最大的更新日期,方便再次更新
	 */
	public String selectMaxUpdate() {
		String updateDate = expensesBillsMapper.selectMaxUpdate();
		return updateDate;
	}
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public String insertExpensesBillsBatch(List<ExpensesBills> list) {
		expensesBillsMapper.insertExpensesBillsBatch(list);
		return "success";
	}
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsItemBatch(List<ExpensesBillsItem> list) {
		expensesBillsItemMapper.insertExpensesBillsItemBatch(list);
	}
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsApprBatch(List<ExpensesBillsApproves> list) {
		expensesBillsApprovesMapper.insertExpensesBillsApprBatch(list);
	}
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsPayBatch(List<ExpensesBillsPay> list) {
		expensesBillsPayMapper.insertExpensesBillsPayBatch(list);
	}

}
