package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyTotal;
import com.pcitc.base.stp.budget.BudgetMoneyTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyTotalMapper {
    long countByExample(BudgetMoneyTotalExample example);

    int deleteByExample(BudgetMoneyTotalExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetMoneyTotal record);

    int insertSelective(BudgetMoneyTotal record);

    List<BudgetMoneyTotal> selectByExample(BudgetMoneyTotalExample example);

    BudgetMoneyTotal selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyTotal record, @Param("example") BudgetMoneyTotalExample example);

    int updateByExample(@Param("record") BudgetMoneyTotal record, @Param("example") BudgetMoneyTotalExample example);

    int updateByPrimaryKeySelective(BudgetMoneyTotal record);

    int updateByPrimaryKey(BudgetMoneyTotal record);
}