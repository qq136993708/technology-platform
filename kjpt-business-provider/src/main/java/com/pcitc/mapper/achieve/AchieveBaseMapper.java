package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveBase;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
public interface AchieveBaseMapper {
    AchieveBase load(String id);
    void add(AchieveBase ab);
    void update(AchieveBase ab);
    void delete(String id);
    List<AchieveBase> query(Map param);
}
