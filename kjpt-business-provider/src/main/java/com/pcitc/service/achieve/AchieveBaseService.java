package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.common.Result;

import java.util.Map;

/**
 * @author
 */
public interface AchieveBaseService {
    AchieveBase load(String id);
    Integer save(AchieveBase ab);
    Integer delete(String id);
    PageInfo query(Map param);
    public Result dealWorkFlow(String id, Map map) throws Exception;
}
