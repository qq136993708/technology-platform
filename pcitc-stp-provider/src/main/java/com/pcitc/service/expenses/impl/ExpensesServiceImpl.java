package com.pcitc.service.expenses.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.mapper.expenses.ExpensesBillsMapper;
import com.pcitc.service.expenses.ExpensesService;

@Service("expensesService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ExpensesServiceImpl implements ExpensesService {

	@Autowired
	private ExpensesBillsMapper expensesBillsMapper;
	
	/**
	 * @return
	 * 查询最大的更新日期,方便再次更新
	 */
	public String selectMaxUpdate() {
		return "2017-01-01";
	}

}
