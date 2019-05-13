package com.pcitc.mapper.expenses;

import com.pcitc.base.stp.expenses.ExpensesBillsApproves;
import com.pcitc.base.stp.expenses.ExpensesBillsApprovesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpensesBillsApprovesMapper {
    long countByExample(ExpensesBillsApprovesExample example);

    int deleteByExample(ExpensesBillsApprovesExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(ExpensesBillsApproves record);

    int insertSelective(ExpensesBillsApproves record);

    List<ExpensesBillsApproves> selectByExample(ExpensesBillsApprovesExample example);

    ExpensesBillsApproves selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") ExpensesBillsApproves record, @Param("example") ExpensesBillsApprovesExample example);

    int updateByExample(@Param("record") ExpensesBillsApproves record, @Param("example") ExpensesBillsApprovesExample example);

    int updateByPrimaryKeySelective(ExpensesBillsApproves record);

    int updateByPrimaryKey(ExpensesBillsApproves record);
}