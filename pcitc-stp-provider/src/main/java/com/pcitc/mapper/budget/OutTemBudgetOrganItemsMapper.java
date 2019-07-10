package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.OutTemBudgetOrganItems;
import com.pcitc.base.stp.budget.OutTemBudgetOrganItemsExample;
import org.springframework.stereotype.Repository;

/**
 * OutTemBudgetOrganItemsMapper继承基类
 */
@Repository
public interface OutTemBudgetOrganItemsMapper extends BudgetBaseMapper<OutTemBudgetOrganItems, String, OutTemBudgetOrganItemsExample>
{
	
}