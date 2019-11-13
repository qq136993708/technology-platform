package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetTechSplit;
import com.pcitc.base.stp.budget.BudgetTechSplitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetTechSplitMapper {
    long countByExample(BudgetTechSplitExample example);

    int deleteByExample(BudgetTechSplitExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetTechSplit record);

    int insertSelective(BudgetTechSplit record);

    List<BudgetTechSplit> selectByExample(BudgetTechSplitExample example);

    BudgetTechSplit selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetTechSplit record, @Param("example") BudgetTechSplitExample example);

    int updateByExample(@Param("record") BudgetTechSplit record, @Param("example") BudgetTechSplitExample example);

    int updateByPrimaryKeySelective(BudgetTechSplit record);

    int updateByPrimaryKey(BudgetTechSplit record);
}