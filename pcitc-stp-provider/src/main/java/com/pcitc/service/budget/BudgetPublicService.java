package com.pcitc.service.budget;

import com.pcitc.base.stp.budget.BudgetInfo;

/**
 * public process
 * @author uuy
 *
 */
public interface BudgetPublicService 
{
	/**
	 * 根据模板创建预算项目
	 * @return
	 */
	public Object createBudgetItemByTemplate(String dataId,BudgetInfo newInfo) throws Exception ;
}
