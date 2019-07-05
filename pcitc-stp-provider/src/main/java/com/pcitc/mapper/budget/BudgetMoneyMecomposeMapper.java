package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyMecompose;
import com.pcitc.base.stp.budget.BudgetMoneyMecomposeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyMecomposeMapper {
    long countByExample(BudgetMoneyMecomposeExample example);

    int deleteByExample(BudgetMoneyMecomposeExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyMecompose record);

    int insertSelective(BudgetMoneyMecompose record);

    List<BudgetMoneyMecompose> selectByExample(BudgetMoneyMecomposeExample example);

    BudgetMoneyMecompose selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyMecompose record, @Param("example") BudgetMoneyMecomposeExample example);

    int updateByExample(@Param("record") BudgetMoneyMecompose record, @Param("example") BudgetMoneyMecomposeExample example);

    int updateByPrimaryKeySelective(BudgetMoneyMecompose record);

    int updateByPrimaryKey(BudgetMoneyMecompose record);
}