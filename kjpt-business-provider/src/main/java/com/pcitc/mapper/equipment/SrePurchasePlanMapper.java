package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SrePurchasePlan;
import com.pcitc.base.stp.equipment.SrePurchasePlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SrePurchasePlanMapper {
    int countByExample(SrePurchasePlanExample example);

    int deleteByExample(SrePurchasePlanExample example);

    int deleteByPrimaryKey(String purchasePlanId);

    int insert(SrePurchasePlan record);

    int insertSelective(SrePurchasePlan record);

    List<SrePurchasePlan> selectByExample(SrePurchasePlanExample example);

    SrePurchasePlan selectByPrimaryKey(String purchasePlanId);

    int updateByExampleSelective(@Param("record") SrePurchasePlan record, @Param("example") SrePurchasePlanExample example);

    int updateByExample(@Param("record") SrePurchasePlan record, @Param("example") SrePurchasePlanExample example);

    int updateByPrimaryKeySelective(SrePurchasePlan record);

    int updateByPrimaryKey(SrePurchasePlan record);
}