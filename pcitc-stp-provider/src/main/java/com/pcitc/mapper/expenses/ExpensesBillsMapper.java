package com.pcitc.mapper.expenses;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.expenses.ExpensesBills;
import com.pcitc.base.stp.expenses.ExpensesBillsExample;

public interface ExpensesBillsMapper {
    long countByExample(ExpensesBillsExample example);

    int deleteByExample(ExpensesBillsExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(ExpensesBills record);

    int insertSelective(ExpensesBills record);

    List<ExpensesBills> selectByExample(ExpensesBillsExample example);

    ExpensesBills selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") ExpensesBills record, @Param("example") ExpensesBillsExample example);

    int updateByExample(@Param("record") ExpensesBills record, @Param("example") ExpensesBillsExample example);

    int updateByPrimaryKeySelective(ExpensesBills record);

    int updateByPrimaryKey(ExpensesBills record);
    
    /**
	 * @return
	 * 查询最大的更新日期,方便再次更新
	 */
	public String selectMaxUpdate();
	
	/**
	 * 批量保存经费报销单据
	 * @return
	 */
	public void insertExpensesBillsBatch(List<ExpensesBills> list);
}