package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetOrganMapper {
    long countByExample(BudgetOrganExample example);

    int deleteByExample(BudgetOrganExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetOrgan record);

    int insertSelective(BudgetOrgan record);

    List<BudgetOrgan> selectByExample(BudgetOrganExample example);

    BudgetOrgan selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetOrgan record, @Param("example") BudgetOrganExample example);

    int updateByExample(@Param("record") BudgetOrgan record, @Param("example") BudgetOrganExample example);

    int updateByPrimaryKeySelective(BudgetOrgan record);

    int updateByPrimaryKey(BudgetOrgan record);
}