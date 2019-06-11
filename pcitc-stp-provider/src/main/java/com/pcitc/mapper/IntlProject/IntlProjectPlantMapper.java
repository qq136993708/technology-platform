package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectPlant;
import com.pcitc.base.stp.IntlProject.IntlProjectPlantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectPlantMapper {
    long countByExample(IntlProjectPlantExample example);

    int deleteByExample(IntlProjectPlantExample example);

    int deleteByPrimaryKey(String plantId);

    int insert(IntlProjectPlant record);

    int insertSelective(IntlProjectPlant record);

    List<IntlProjectPlant> selectByExample(IntlProjectPlantExample example);

    IntlProjectPlant selectByPrimaryKey(String plantId);

    int updateByExampleSelective(@Param("record") IntlProjectPlant record, @Param("example") IntlProjectPlantExample example);

    int updateByExample(@Param("record") IntlProjectPlant record, @Param("example") IntlProjectPlantExample example);

    int updateByPrimaryKeySelective(IntlProjectPlant record);

    int updateByPrimaryKey(IntlProjectPlant record);
}