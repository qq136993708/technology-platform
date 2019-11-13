package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetOrganItems;
import com.pcitc.base.stp.budget.BudgetOrganItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetOrganItemsMapper {
    long countByExample(BudgetOrganItemsExample example);

    int deleteByExample(BudgetOrganItemsExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetOrganItems record);

    int insertSelective(BudgetOrganItems record);

    List<BudgetOrganItems> selectByExample(BudgetOrganItemsExample example);

    BudgetOrganItems selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetOrganItems record, @Param("example") BudgetOrganItemsExample example);

    int updateByExample(@Param("record") BudgetOrganItems record, @Param("example") BudgetOrganItemsExample example);

    int updateByPrimaryKeySelective(BudgetOrganItems record);

    int updateByPrimaryKey(BudgetOrganItems record);
}