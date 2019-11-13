package com.pcitc.mapper.expenses;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.expenses.ExpensesBillsItem;
import com.pcitc.base.stp.expenses.ExpensesBillsItemExample;

public interface ExpensesBillsItemMapper {
    long countByExample(ExpensesBillsItemExample example);

    int deleteByExample(ExpensesBillsItemExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(ExpensesBillsItem record);

    int insertSelective(ExpensesBillsItem record);

    List<ExpensesBillsItem> selectByExample(ExpensesBillsItemExample example);

    ExpensesBillsItem selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") ExpensesBillsItem record, @Param("example") ExpensesBillsItemExample example);

    int updateByExample(@Param("record") ExpensesBillsItem record, @Param("example") ExpensesBillsItemExample example);

    int updateByPrimaryKeySelective(ExpensesBillsItem record);

    int updateByPrimaryKey(ExpensesBillsItem record);
    
    /**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsItemBatch(List<ExpensesBillsItem> list);
}