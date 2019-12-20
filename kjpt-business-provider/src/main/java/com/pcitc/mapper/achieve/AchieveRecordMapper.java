package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveRecord;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
public interface AchieveRecordMapper {
    AchieveRecord load(String id);
    Integer add(AchieveRecord ab);
    Integer update(AchieveRecord ab);
    Integer delete(String[] ids);
    List<AchieveRecord> query(Map param);
    List<Map> queryAchieveSubsidiarity(Map param);
}
