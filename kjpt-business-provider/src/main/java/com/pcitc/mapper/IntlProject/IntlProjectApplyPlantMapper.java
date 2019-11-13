package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyPlantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectApplyPlantMapper {
    long countByExample(IntlProjectApplyPlantExample example);

    int deleteByExample(IntlProjectApplyPlantExample example);

    int deleteByPrimaryKey(String relId);

    int insert(IntlProjectApplyPlant record);

    int insertSelective(IntlProjectApplyPlant record);

    List<IntlProjectApplyPlant> selectByExample(IntlProjectApplyPlantExample example);

    IntlProjectApplyPlant selectByPrimaryKey(String relId);

    int updateByExampleSelective(@Param("record") IntlProjectApplyPlant record, @Param("example") IntlProjectApplyPlantExample example);

    int updateByExample(@Param("record") IntlProjectApplyPlant record, @Param("example") IntlProjectApplyPlantExample example);

    int updateByPrimaryKeySelective(IntlProjectApplyPlant record);

    int updateByPrimaryKey(IntlProjectApplyPlant record);
}