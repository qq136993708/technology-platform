package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveSubmit;

import java.util.Map;

/**
 * @author
 */
public interface AchieveRecordService {
    AchieveRecord load(String id);
    void save(AchieveSubmit as);
    Integer delete(String ids);
    PageInfo query(Map param);
}
