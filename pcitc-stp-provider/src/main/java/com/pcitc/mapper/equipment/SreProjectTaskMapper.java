package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SreProjectTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreProjectTaskMapper {
    int countByExample(SreProjectTaskExample example);

    int deleteByExample(SreProjectTaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(SreProjectTask record);

    int insertSelective(SreProjectTask record);

    List<SreProjectTask> selectByExample(SreProjectTaskExample example);

    SreProjectTask selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") SreProjectTask record, @Param("example") SreProjectTaskExample example);

    int updateByExample(@Param("record") SreProjectTask record, @Param("example") SreProjectTaskExample example);

    int updateByPrimaryKeySelective(SreProjectTask record);

    int updateByPrimaryKey(SreProjectTask record);
}