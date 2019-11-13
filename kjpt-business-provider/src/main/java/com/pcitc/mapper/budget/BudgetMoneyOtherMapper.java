package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyOther;
import com.pcitc.base.stp.budget.BudgetMoneyOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyOtherMapper {
    long countByExample(BudgetMoneyOtherExample example);

    int deleteByExample(BudgetMoneyOtherExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyOther record);

    int insertSelective(BudgetMoneyOther record);

    List<BudgetMoneyOther> selectByExample(BudgetMoneyOtherExample example);

    BudgetMoneyOther selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyOther record, @Param("example") BudgetMoneyOtherExample example);

    int updateByExample(@Param("record") BudgetMoneyOther record, @Param("example") BudgetMoneyOtherExample example);

    int updateByPrimaryKeySelective(BudgetMoneyOther record);

    int updateByPrimaryKey(BudgetMoneyOther record);
}