package com.pcitc.service.expenses;

import java.util.HashMap;
import java.util.List;

import com.pcitc.base.stp.expenses.ExpensesBills;
import com.pcitc.base.stp.expenses.ExpensesBillsApproves;
import com.pcitc.base.stp.expenses.ExpensesBillsItem;
import com.pcitc.base.stp.expenses.ExpensesBillsPay;
import com.pcitc.base.stp.expenses.ExpensesPayHana;


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
	
	/**
	 * 批量保存报销对于的erp中的付款明显清单
	 * @return
	 */
	public void insertExpensesPayHanaBatch(List<ExpensesPayHana> list);
	
	/**
	 * 删除部分数据，重新导入
	 * @return
	 */
	public void deleteExpensesPayHana(HashMap<String, String> hashmap);
	
}
