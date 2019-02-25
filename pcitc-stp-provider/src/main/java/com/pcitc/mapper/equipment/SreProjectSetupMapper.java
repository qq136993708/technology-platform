package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectSetupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreProjectSetupMapper {
    int countByExample(SreProjectSetupExample example);

    int deleteByExample(SreProjectSetupExample example);

    int deleteByPrimaryKey(String id);

    int insert(SreProjectSetup record);

    int insertSelective(SreProjectSetup record);

    List<SreProjectSetup> selectByExample(SreProjectSetupExample example);

    SreProjectSetup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SreProjectSetup record, @Param("example") SreProjectSetupExample example);

    int updateByExample(@Param("record") SreProjectSetup record, @Param("example") SreProjectSetupExample example);

    int updateByPrimaryKeySelective(SreProjectSetup record);

    int updateByPrimaryKey(SreProjectSetup record);
}