package com.pcitc.mapper.budget;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.budget.BudgetOtherPayMoney;
import com.pcitc.base.stp.budget.BudgetOtherPayMoneyExample;

public interface BudgetOtherPayMoneyMapper {
    long countByExample(BudgetOtherPayMoneyExample example);

    int deleteByExample(BudgetOtherPayMoneyExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetOtherPayMoney record);

    int insertSelective(BudgetOtherPayMoney record);

    List<BudgetOtherPayMoney> selectByExample(BudgetOtherPayMoneyExample example);

    BudgetOtherPayMoney selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetOtherPayMoney record, @Param("example") BudgetOtherPayMoneyExample example);

    int updateByExample(@Param("record") BudgetOtherPayMoney record, @Param("example") BudgetOtherPayMoneyExample example);

    int updateByPrimaryKeySelective(BudgetOtherPayMoney record);

    int updateByPrimaryKey(BudgetOtherPayMoney record);
}