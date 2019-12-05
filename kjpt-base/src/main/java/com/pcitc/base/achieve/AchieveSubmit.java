package com.pcitc.base.achieve;

import com.pcitc.base.common.RecordModel;

/**
 *
 * 成果第一次备案时联合激励数据（备案对激励 一对多）
 * @author
 */
public class AchieveSubmit extends RecordModel {
    private AchieveRecord achieveRecord;
    private AchieveReward achieveReward;

    public AchieveRecord getAchieveRecord() {
        return achieveRecord;
    }

    public void setAchieveRecord(AchieveRecord achieveRecord) {
        this.achieveRecord = achieveRecord;
    }

    public AchieveReward getAchieveReward() {
        return achieveReward;
    }

    public void setAchieveReward(AchieveReward achieveReward) {
        this.achieveReward = achieveReward;
    }
}
