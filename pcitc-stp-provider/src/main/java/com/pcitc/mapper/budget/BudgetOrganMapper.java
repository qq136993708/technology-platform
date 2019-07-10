package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;
import org.springframework.stereotype.Repository;

/**
 * BudgetOrganMapper继承基类
 */
@Repository
public interface BudgetOrganMapper extends BudgetBaseMapper<BudgetOrgan, String, BudgetOrganExample> {
}