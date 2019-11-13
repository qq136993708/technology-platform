package com.pcitc.mapper.expenses;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.expenses.ExpensesPayHana;
import com.pcitc.base.stp.expenses.ExpensesPayHanaExample;

public interface ExpensesPayHanaMapper {
    long countByExample(ExpensesPayHanaExample example);

    int deleteByExample(ExpensesPayHanaExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(ExpensesPayHana record);

    int insertSelective(ExpensesPayHana record);

    List<ExpensesPayHana> selectByExample(ExpensesPayHanaExample example);

    ExpensesPayHana selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") ExpensesPayHana record, @Param("example") ExpensesPayHanaExample example);

    int updateByExample(@Param("record") ExpensesPayHana record, @Param("example") ExpensesPayHanaExample example);

    int updateByPrimaryKeySelective(ExpensesPayHana record);

    int updateByPrimaryKey(ExpensesPayHana record);
    
    /**
	 * 批量保存报销对于的erp中的付款明显清单
	 * @return
	 */
	public void insertExpensesPayHanaBatch(List<ExpensesPayHana> list);
}