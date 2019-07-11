package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetOrganItems;
import com.pcitc.base.stp.budget.BudgetOrganItemsExample;
import org.springframework.stereotype.Repository;

/**
 * BudgetOrganItemsMapper继承基类
 */
@Repository
public interface BudgetOrganItemsMapper extends BudgetBaseMapper<BudgetOrganItems, String, BudgetOrganItemsExample> {
}