package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetB2cSplit;
import com.pcitc.base.stp.budget.BudgetB2cSplitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetB2cSplitMapper {
    long countByExample(BudgetB2cSplitExample example);

    int deleteByExample(BudgetB2cSplitExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetB2cSplit record);

    int insertSelective(BudgetB2cSplit record);

    List<BudgetB2cSplit> selectByExample(BudgetB2cSplitExample example);

    BudgetB2cSplit selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetB2cSplit record, @Param("example") BudgetB2cSplitExample example);

    int updateByExample(@Param("record") BudgetB2cSplit record, @Param("example") BudgetB2cSplitExample example);

    int updateByPrimaryKeySelective(BudgetB2cSplit record);

    int updateByPrimaryKey(BudgetB2cSplit record);
}