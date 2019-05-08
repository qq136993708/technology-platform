package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreProjectAssess;
import com.pcitc.base.stp.equipment.SreProjectAudit;

public interface SreProjectAssessMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreProjectAssess record);

    int insertSelective(SreProjectAssess record);

    SreProjectAssess selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreProjectAssess record);

    int updateByPrimaryKey(SreProjectAssess record);
    
    List getlist(Map map);
    
    int updateAuditById(SreProjectAssess record);
}