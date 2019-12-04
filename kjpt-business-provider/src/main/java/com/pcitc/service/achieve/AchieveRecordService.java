package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveRecord;

import java.util.Map;

/**
 * @author
 */
public interface AchieveRecordService {
    AchieveRecord load(String id);
    void save(AchieveRecord ab);
    Integer delete(String id);
    PageInfo query(Map param);
}
