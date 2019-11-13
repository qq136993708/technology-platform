package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreProjectAudit;

public interface SreProjectAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreProjectAudit record);

    int insertSelective(SreProjectAudit record);

    SreProjectAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreProjectAudit record);

    int updateByPrimaryKey(SreProjectAudit record);
    
    List getlist(Map map);
    
    int selectBypid(String projecttaskid);
    
    int updateAuditById(SreProjectAudit record);
}