package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyCompany;
import com.pcitc.base.stp.budget.BudgetMoneyCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyCompanyMapper {
    long countByExample(BudgetMoneyCompanyExample example);

    int deleteByExample(BudgetMoneyCompanyExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyCompany record);

    int insertSelective(BudgetMoneyCompany record);

    List<BudgetMoneyCompany> selectByExample(BudgetMoneyCompanyExample example);

    BudgetMoneyCompany selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyCompany record, @Param("example") BudgetMoneyCompanyExample example);

    int updateByExample(@Param("record") BudgetMoneyCompany record, @Param("example") BudgetMoneyCompanyExample example);

    int updateByPrimaryKeySelective(BudgetMoneyCompany record);

    int updateByPrimaryKey(BudgetMoneyCompany record);
}