package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyTech;
import com.pcitc.base.stp.budget.BudgetMoneyTechExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyTechMapper {
    long countByExample(BudgetMoneyTechExample example);

    int deleteByExample(BudgetMoneyTechExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyTech record);

    int insertSelective(BudgetMoneyTech record);

    List<BudgetMoneyTech> selectByExample(BudgetMoneyTechExample example);

    BudgetMoneyTech selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyTech record, @Param("example") BudgetMoneyTechExample example);

    int updateByExample(@Param("record") BudgetMoneyTech record, @Param("example") BudgetMoneyTechExample example);

    int updateByPrimaryKeySelective(BudgetMoneyTech record);

    int updateByPrimaryKey(BudgetMoneyTech record);
}