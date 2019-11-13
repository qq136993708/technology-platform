package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyGroup;
import com.pcitc.base.stp.budget.BudgetMoneyGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyGroupMapper {
    long countByExample(BudgetMoneyGroupExample example);

    int deleteByExample(BudgetMoneyGroupExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyGroup record);

    int insertSelective(BudgetMoneyGroup record);

    List<BudgetMoneyGroup> selectByExample(BudgetMoneyGroupExample example);

    BudgetMoneyGroup selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyGroup record, @Param("example") BudgetMoneyGroupExample example);

    int updateByExample(@Param("record") BudgetMoneyGroup record, @Param("example") BudgetMoneyGroupExample example);

    int updateByPrimaryKeySelective(BudgetMoneyGroup record);

    int updateByPrimaryKey(BudgetMoneyGroup record);
}