package com.pcitc.service.expenses.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.expenses.ExpensesBills;
import com.pcitc.base.stp.expenses.ExpensesBillsApproves;
import com.pcitc.base.stp.expenses.ExpensesBillsItem;
import com.pcitc.base.stp.expenses.ExpensesBillsPay;
import com.pcitc.base.stp.expenses.ExpensesPayHana;
import com.pcitc.base.stp.expenses.ExpensesPayHanaExample;
import com.pcitc.mapper.expenses.ExpensesBillsApprovesMapper;
import com.pcitc.mapper.expenses.ExpensesBillsItemMapper;
import com.pcitc.mapper.expenses.ExpensesBillsMapper;
import com.pcitc.mapper.expenses.ExpensesBillsPayMapper;
import com.pcitc.mapper.expenses.ExpensesPayHanaMapper;
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
	
	@Autowired
	private ExpensesPayHanaMapper expensesPayHanaMapper;
	
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

	/**
	 * 批量保存报销对于的erp中的付款明显清单
	 * @return
	 */
	public void insertExpensesPayHanaBatch(List<ExpensesPayHana> list) {
		expensesPayHanaMapper.insertExpensesPayHanaBatch(list);
	}
	
	/**
	 * 删除部分数据，重新导入
	 * @return
	 */
	public void deleteExpensesPayHana(HashMap<String, String> hashmap) {
		ExpensesPayHanaExample ephe = new ExpensesPayHanaExample();
		String G0GJAHR = hashmap.get("G0GJAHR");
		ephe.createCriteria().andG0gjahrEqualTo(G0GJAHR);
		expensesPayHanaMapper.deleteByExample(ephe);
	}
}
