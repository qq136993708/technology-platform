package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveRecord;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
public interface AchieveRecordMapper {
    AchieveRecord load(String id);
    void add(AchieveRecord ab);
    void update(AchieveRecord ab);
    Integer delete(String id);
    List<AchieveRecord> query(Map param);
}
