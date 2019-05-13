package com.pcitc.service.expenses;


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
	
}
