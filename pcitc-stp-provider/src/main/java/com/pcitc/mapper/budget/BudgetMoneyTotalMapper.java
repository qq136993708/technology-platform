package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyTotal;
import com.pcitc.base.stp.budget.BudgetMoneyTotalExample;
import org.springframework.stereotype.Repository;

/**
 * BudgetMoneyTotalMapper继承基类
 */
@Repository
public interface BudgetMoneyTotalMapper extends BudgetBaseMapper<BudgetMoneyTotal, Integer, BudgetMoneyTotalExample> 
{
	
}