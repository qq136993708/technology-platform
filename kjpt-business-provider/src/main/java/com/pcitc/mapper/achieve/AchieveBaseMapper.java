package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveBase;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
public interface AchieveBaseMapper {
    AchieveBase load(String id);
    Integer add(AchieveBase ab);
    Integer update(AchieveBase ab);
    Integer delete(String id);
    List<AchieveBase> query(Map param);
    Integer updatePublicStatus(Map param);
}
