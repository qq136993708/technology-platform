package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreScrapApply;

public interface SreScrapApplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreScrapApply record);

    int insertSelective(SreScrapApply record);

    SreScrapApply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreScrapApply record);

    int updateByPrimaryKey(SreScrapApply record);
    
    List getlist();
}