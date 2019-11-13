package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetInfoMapper {
    long countByExample(BudgetInfoExample example);

    int deleteByExample(BudgetInfoExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetInfo record);

    int insertSelective(BudgetInfo record);

    List<BudgetInfo> selectByExample(BudgetInfoExample example);

    BudgetInfo selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetInfo record, @Param("example") BudgetInfoExample example);

    int updateByExample(@Param("record") BudgetInfo record, @Param("example") BudgetInfoExample example);

    int updateByPrimaryKeySelective(BudgetInfo record);

    int updateByPrimaryKey(BudgetInfo record);
}