package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.budgetGroupTotal;
import com.pcitc.base.stp.budget.budgetGroupTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface budgetGroupTotalMapper {
    long countByExample(budgetGroupTotalExample example);

    int deleteByExample(budgetGroupTotalExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(budgetGroupTotal record);

    int insertSelective(budgetGroupTotal record);

    List<budgetGroupTotal> selectByExampleWithBLOBs(budgetGroupTotalExample example);

    List<budgetGroupTotal> selectByExample(budgetGroupTotalExample example);

    budgetGroupTotal selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") budgetGroupTotal record, @Param("example") budgetGroupTotalExample example);

    int updateByExampleWithBLOBs(@Param("record") budgetGroupTotal record, @Param("example") budgetGroupTotalExample example);

    int updateByExample(@Param("record") budgetGroupTotal record, @Param("example") budgetGroupTotalExample example);

    int updateByPrimaryKeySelective(budgetGroupTotal record);

    int updateByPrimaryKeyWithBLOBs(budgetGroupTotal record);

    int updateByPrimaryKey(budgetGroupTotal record);
}