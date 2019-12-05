package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveReward;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
public interface AchieveRewardMapper {
    AchieveReward load(String id);
    void add(AchieveReward ab);
    void update(AchieveReward ab);
    void delete(String id);
    List<AchieveReward> query(Map param);
    void updateRewardMoney(String aRecordId);
    void updateCurrentYearMoney(String aRecordId);
}
