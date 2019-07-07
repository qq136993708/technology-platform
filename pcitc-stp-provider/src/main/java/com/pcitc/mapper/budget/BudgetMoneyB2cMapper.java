package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyB2c;
import com.pcitc.base.stp.budget.BudgetMoneyB2cExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyB2cMapper {
    long countByExample(BudgetMoneyB2cExample example);

    int deleteByExample(BudgetMoneyB2cExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyB2c record);

    int insertSelective(BudgetMoneyB2c record);

    List<BudgetMoneyB2c> selectByExample(BudgetMoneyB2cExample example);

    BudgetMoneyB2c selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyB2c record, @Param("example") BudgetMoneyB2cExample example);

    int updateByExample(@Param("record") BudgetMoneyB2c record, @Param("example") BudgetMoneyB2cExample example);

    int updateByPrimaryKeySelective(BudgetMoneyB2c record);

    int updateByPrimaryKey(BudgetMoneyB2c record);
}