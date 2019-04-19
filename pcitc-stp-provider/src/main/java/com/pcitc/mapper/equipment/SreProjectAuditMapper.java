package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreProjectAudit;

public interface SreProjectAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreProjectAudit record);

    int insertSelective(SreProjectAudit record);

    SreProjectAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreProjectAudit record);

    int updateByPrimaryKey(SreProjectAudit record);
}