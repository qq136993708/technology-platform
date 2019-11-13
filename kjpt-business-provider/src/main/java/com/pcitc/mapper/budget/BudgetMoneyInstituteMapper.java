package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyInstitute;
import com.pcitc.base.stp.budget.BudgetMoneyInstituteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyInstituteMapper {
    long countByExample(BudgetMoneyInstituteExample example);

    int deleteByExample(BudgetMoneyInstituteExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyInstitute record);

    int insertSelective(BudgetMoneyInstitute record);

    List<BudgetMoneyInstitute> selectByExample(BudgetMoneyInstituteExample example);

    BudgetMoneyInstitute selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyInstitute record, @Param("example") BudgetMoneyInstituteExample example);

    int updateByExample(@Param("record") BudgetMoneyInstitute record, @Param("example") BudgetMoneyInstituteExample example);

    int updateByPrimaryKeySelective(BudgetMoneyInstitute record);

    int updateByPrimaryKey(BudgetMoneyInstitute record);
}