package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveReward;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
public interface AchieveRewardMapper {
    AchieveReward load(String id);
    Integer add(AchieveReward ab);
    Integer update(AchieveReward ab);
    Integer delete(String id);
    List<AchieveReward> query(Map param);
    void updateRewardMoney(String aRecordId);
    void updateCurrentYearMoney(String aRecordId);

    List<AchieveReward> getByRecordId(String aRecordId);
}
