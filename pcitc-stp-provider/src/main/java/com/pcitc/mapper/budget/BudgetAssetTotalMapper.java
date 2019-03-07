package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetAssetTotal;
import com.pcitc.base.stp.budget.BudgetAssetTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetAssetTotalMapper {
    long countByExample(BudgetAssetTotalExample example);

    int deleteByExample(BudgetAssetTotalExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(BudgetAssetTotal record);

    int insertSelective(BudgetAssetTotal record);

    List<BudgetAssetTotal> selectByExampleWithBLOBs(BudgetAssetTotalExample example);

    List<BudgetAssetTotal> selectByExample(BudgetAssetTotalExample example);

    BudgetAssetTotal selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") BudgetAssetTotal record, @Param("example") BudgetAssetTotalExample example);

    int updateByExampleWithBLOBs(@Param("record") BudgetAssetTotal record, @Param("example") BudgetAssetTotalExample example);

    int updateByExample(@Param("record") BudgetAssetTotal record, @Param("example") BudgetAssetTotalExample example);

    int updateByPrimaryKeySelective(BudgetAssetTotal record);

    int updateByPrimaryKeyWithBLOBs(BudgetAssetTotal record);

    int updateByPrimaryKey(BudgetAssetTotal record);
}