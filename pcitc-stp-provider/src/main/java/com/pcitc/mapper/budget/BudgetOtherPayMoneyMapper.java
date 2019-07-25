package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetOtherPayMoney;
import com.pcitc.base.stp.budget.BudgetOtherPayMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetOtherPayMoneyMapper {
    long countByExample(BudgetOtherPayMoneyExample example);

    int deleteByExample(BudgetOtherPayMoneyExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetOtherPayMoney record);

    int insertSelective(BudgetOtherPayMoney record);

    List<BudgetOtherPayMoney> selectByExampleWithBLOBs(BudgetOtherPayMoneyExample example);

    List<BudgetOtherPayMoney> selectByExample(BudgetOtherPayMoneyExample example);

    BudgetOtherPayMoney selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetOtherPayMoney record, @Param("example") BudgetOtherPayMoneyExample example);

    int updateByExampleWithBLOBs(@Param("record") BudgetOtherPayMoney record, @Param("example") BudgetOtherPayMoneyExample example);

    int updateByExample(@Param("record") BudgetOtherPayMoney record, @Param("example") BudgetOtherPayMoneyExample example);

    int updateByPrimaryKeySelective(BudgetOtherPayMoney record);

    int updateByPrimaryKeyWithBLOBs(BudgetOtherPayMoney record);

    int updateByPrimaryKey(BudgetOtherPayMoney record);
}