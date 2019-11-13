package com.pcitc.mapper.budget;

import com.pcitc.base.stp.budget.BudgetMoneyAsset;
import com.pcitc.base.stp.budget.BudgetMoneyAssetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BudgetMoneyAssetMapper {
    long countByExample(BudgetMoneyAssetExample example);

    int deleteByExample(BudgetMoneyAssetExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(BudgetMoneyAsset record);

    int insertSelective(BudgetMoneyAsset record);

    List<BudgetMoneyAsset> selectByExample(BudgetMoneyAssetExample example);

    BudgetMoneyAsset selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") BudgetMoneyAsset record, @Param("example") BudgetMoneyAssetExample example);

    int updateByExample(@Param("record") BudgetMoneyAsset record, @Param("example") BudgetMoneyAssetExample example);

    int updateByPrimaryKeySelective(BudgetMoneyAsset record);

    int updateByPrimaryKey(BudgetMoneyAsset record);
}