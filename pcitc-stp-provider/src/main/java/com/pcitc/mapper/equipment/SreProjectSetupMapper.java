package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreProjectSetup;

public interface SreProjectSetupMapper {
    int deleteByPrimaryKey(String setupId);

    int insert(SreProjectSetup record);

    int insertSelective(SreProjectSetup record);

    SreProjectSetup selectByPrimaryKey(String setupId);

    int updateByPrimaryKeySelective(SreProjectSetup record);

    int updateByPrimaryKeyWithBLOBs(SreProjectSetup record);

    int updateByPrimaryKey(SreProjectSetup record);
    
    
    
    List getList(Map map);
    int getCount(Map map);
    
}