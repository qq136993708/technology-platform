package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyDecompose;
import com.pcitc.base.stp.budget.BudgetMoneyDecomposeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyDecomposeMapper {
    long countByExample(BudgetMoneyDecomposeExample example);

    int deleteByExample(BudgetMoneyDecomposeExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyDecompose record);

    int insertSelective(BudgetMoneyDecompose record);

    List<BudgetMoneyDecompose> selectByExample(BudgetMoneyDecomposeExample example);

    BudgetMoneyDecompose selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyDecompose record, @Param("example") BudgetMoneyDecomposeExample example);

    int updateByExample(@Param("record") BudgetMoneyDecompose record, @Param("example") BudgetMoneyDecomposeExample example);

    int updateByPrimaryKeySelective(BudgetMoneyDecompose record);

    int updateByPrimaryKey(BudgetMoneyDecompose record);
}