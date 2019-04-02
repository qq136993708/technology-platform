package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.BudgetSplitDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetSplitDataMapper {
    long countByExample(BudgetSplitDataExample example);

    int deleteByExample(BudgetSplitDataExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetSplitData record);

    int insertSelective(BudgetSplitData record);

    List<BudgetSplitData> selectByExample(BudgetSplitDataExample example);

    BudgetSplitData selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetSplitData record, @Param("example") BudgetSplitDataExample example);

    int updateByExample(@Param("record") BudgetSplitData record, @Param("example") BudgetSplitDataExample example);

    int updateByPrimaryKeySelective(BudgetSplitData record);

    int updateByPrimaryKey(BudgetSplitData record);
}