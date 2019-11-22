package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchplatform.PlatformAchievementModel;
import com.pcitc.base.researchplatform.PlatformProjectModel;

import java.util.List;
import java.util.Map;

public interface PlatformAchievementMapper {

    /**
     * 根据主键获取一个平台成果的信息
     */
    PlatformAchievementModel load(String id);
    /**
     * 保存平台成果
     */
    int add(PlatformAchievementModel platformAchievementModel);
    /**
     * 查询科研平台成果列表
     */
    List<PlatformAchievementModel> query(Map paramMap);


    /**
     * 修改科研平台成果
     */
    int update(PlatformAchievementModel platformAchievementModel);

    /**
     * 逻辑删
     */
    int delete(String id);

    /**
     * 批量添加
     */
    int batchSave(List<PlatformAchievementModel> list);


}
