package com.pcitc.mapper.expenses;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.expenses.ExpensesBillsPay;
import com.pcitc.base.stp.expenses.ExpensesBillsPayExample;

public interface ExpensesBillsPayMapper {
    long countByExample(ExpensesBillsPayExample example);

    int deleteByExample(ExpensesBillsPayExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(ExpensesBillsPay record);

    int insertSelective(ExpensesBillsPay record);

    List<ExpensesBillsPay> selectByExample(ExpensesBillsPayExample example);

    ExpensesBillsPay selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") ExpensesBillsPay record, @Param("example") ExpensesBillsPayExample example);

    int updateByExample(@Param("record") ExpensesBillsPay record, @Param("example") ExpensesBillsPayExample example);

    int updateByPrimaryKeySelective(ExpensesBillsPay record);

    int updateByPrimaryKey(ExpensesBillsPay record);
    
    /**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsPayBatch(List<ExpensesBillsPay> list);
}