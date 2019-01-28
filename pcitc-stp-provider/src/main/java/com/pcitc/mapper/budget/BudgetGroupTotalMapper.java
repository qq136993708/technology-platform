package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetGroupTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetGroupTotalMapper {
    long countByExample(BudgetGroupTotalExample example);

    int deleteByExample(BudgetGroupTotalExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetGroupTotal record);

    int insertSelective(BudgetGroupTotal record);

    List<BudgetGroupTotal> selectByExampleWithBLOBs(BudgetGroupTotalExample example);

    List<BudgetGroupTotal> selectByExample(BudgetGroupTotalExample example);

    BudgetGroupTotal selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetGroupTotal record, @Param("example") BudgetGroupTotalExample example);

    int updateByExampleWithBLOBs(@Param("record") BudgetGroupTotal record, @Param("example") BudgetGroupTotalExample example);

    int updateByExample(@Param("record") BudgetGroupTotal record, @Param("example") BudgetGroupTotalExample example);

    int updateByPrimaryKeySelective(BudgetGroupTotal record);

    int updateByPrimaryKeyWithBLOBs(BudgetGroupTotal record);

    int updateByPrimaryKey(BudgetGroupTotal record);
}