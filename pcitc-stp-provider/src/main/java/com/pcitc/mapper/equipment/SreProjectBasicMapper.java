package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreProjectBasic;
import com.pcitc.base.stp.equipment.SreProjectBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreProjectBasicMapper {
    int countByExample(SreProjectBasicExample example);

    int deleteByExample(SreProjectBasicExample example);

    int deleteByPrimaryKey(String projectId);

    int insert(SreProjectBasic record);

    int insertSelective(SreProjectBasic record);

    List<SreProjectBasic> selectByExample(SreProjectBasicExample example);

    SreProjectBasic selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") SreProjectBasic record, @Param("example") SreProjectBasicExample example);

    int updateByExample(@Param("record") SreProjectBasic record, @Param("example") SreProjectBasicExample example);

    int updateByPrimaryKeySelective(SreProjectBasic record);

    int updateByPrimaryKey(SreProjectBasic record);
}