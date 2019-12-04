package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;

import java.util.Map;

/**
 * @author
 */
public interface AchieveBaseService {
    AchieveBase load(String id);
    void save(AchieveBase ab);
    void delete(String id);
    PageInfo query(Map param);
}
