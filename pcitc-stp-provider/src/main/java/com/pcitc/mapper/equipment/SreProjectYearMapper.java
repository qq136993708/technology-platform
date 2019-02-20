package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreProjectYear;
import com.pcitc.base.stp.equipment.SreProjectYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreProjectYearMapper {
    int countByExample(SreProjectYearExample example);

    int deleteByExample(SreProjectYearExample example);

    int deleteByPrimaryKey(String id);

    int insert(SreProjectYear record);

    int insertSelective(SreProjectYear record);

    List<SreProjectYear> selectByExample(SreProjectYearExample example);

    SreProjectYear selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SreProjectYear record, @Param("example") SreProjectYearExample example);

    int updateByExample(@Param("record") SreProjectYear record, @Param("example") SreProjectYearExample example);

    int updateByPrimaryKeySelective(SreProjectYear record);

    int updateByPrimaryKey(SreProjectYear record);
}