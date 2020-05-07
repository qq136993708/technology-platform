package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveIdentifyPlan;

import java.util.Map;

/**
 * @author ty
 */
public interface AchieveIdentifyPlanService {

    AchieveIdentifyPlan load(String id);
    Integer save(AchieveIdentifyPlan aip);
    Integer delete(String id);
    PageInfo query(Map param);
}
