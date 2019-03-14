package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreProjectTask;

public interface SreProjectTaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(SreProjectTask record);

    int insertSelective(SreProjectTask record);

    SreProjectTask selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(SreProjectTask record);

    int updateByPrimaryKeyWithBLOBs(SreProjectTask record);

    int updateByPrimaryKey(SreProjectTask record);
    
    List getList(Map map);
    int getCount(Map map);
}