package com.pcitc.service.expenses;

import java.util.List;

import com.pcitc.base.stp.expenses.ExpensesBills;
import com.pcitc.base.stp.expenses.ExpensesBillsApproves;
import com.pcitc.base.stp.expenses.ExpensesBillsItem;
import com.pcitc.base.stp.expenses.ExpensesBillsPay;


/**
 * 费用报销接口
 * @author zhf
 *
 */
public interface ExpensesService {
	
	/**
	 * @return
	 * 查询最大的更新日期,方便再次更新
	 */
	public String selectMaxUpdate();
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public String insertExpensesBillsBatch(List<ExpensesBills> list);
	
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsItemBatch(List<ExpensesBillsItem> list);
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsApprBatch(List<ExpensesBillsApproves> list);
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsPayBatch(List<ExpensesBillsPay> list);
	
}
