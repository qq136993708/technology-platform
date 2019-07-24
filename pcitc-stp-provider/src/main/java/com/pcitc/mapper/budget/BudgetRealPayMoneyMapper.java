package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetRealPayMoney;
import com.pcitc.base.stp.budget.BudgetRealPayMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetRealPayMoneyMapper {
    long countByExample(BudgetRealPayMoneyExample example);

    int deleteByExample(BudgetRealPayMoneyExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetRealPayMoney record);

    int insertSelective(BudgetRealPayMoney record);

    List<BudgetRealPayMoney> selectByExample(BudgetRealPayMoneyExample example);

    BudgetRealPayMoney selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetRealPayMoney record, @Param("example") BudgetRealPayMoneyExample example);

    int updateByExample(@Param("record") BudgetRealPayMoney record, @Param("example") BudgetRealPayMoneyExample example);

    int updateByPrimaryKeySelective(BudgetRealPayMoney record);

    int updateByPrimaryKey(BudgetRealPayMoney record);
}