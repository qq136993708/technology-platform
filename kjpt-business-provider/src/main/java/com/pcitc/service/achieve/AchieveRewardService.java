package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.common.Result;

import java.util.Map;

/**
 * @author
 */
public interface AchieveRewardService {
    AchieveReward load(String id);
    void save(AchieveReward ab);
    
    Integer update(AchieveReward ab);
    
    Integer delete(String id);
    PageInfo query(Map param);
    public Result dealWorkFlow(String id, Map map) throws Exception;
}
