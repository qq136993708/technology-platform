package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetStockTotal;
import com.pcitc.base.stp.budget.BudgetStockTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetStockTotalMapper {
    long countByExample(BudgetStockTotalExample example);

    int deleteByExample(BudgetStockTotalExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetStockTotal record);

    int insertSelective(BudgetStockTotal record);

    List<BudgetStockTotal> selectByExample(BudgetStockTotalExample example);

    BudgetStockTotal selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetStockTotal record, @Param("example") BudgetStockTotalExample example);

    int updateByExample(@Param("record") BudgetStockTotal record, @Param("example") BudgetStockTotalExample example);

    int updateByPrimaryKeySelective(BudgetStockTotal record);

    int updateByPrimaryKey(BudgetStockTotal record);
}