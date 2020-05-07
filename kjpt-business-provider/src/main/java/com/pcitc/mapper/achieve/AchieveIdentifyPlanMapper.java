package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveIdentifyPlan;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface AchieveIdentifyPlanMapper {

    AchieveIdentifyPlan load(String id);
    Integer add(AchieveIdentifyPlan aip);
    Integer update(AchieveIdentifyPlan aip);
    Integer delete(String id);
    List query(Map param);
}
