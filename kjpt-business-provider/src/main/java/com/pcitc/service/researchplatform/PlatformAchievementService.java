package com.pcitc.service.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformAchievementModel;

import java.util.List;
import java.util.Map;

/**
 * 科研平台成果的增删改查
 * @author ty
 */
public interface PlatformAchievementService {

    /**
     * 根据主键获取一个平台成果的信息
     */
    PlatformAchievementModel load(String id);
    /**
     * 保存科研平台成果
     */
    PlatformAchievementModel save(PlatformAchievementModel platformAchievementModel);
    /**
     * 查询科研平台成果列表
     */
    PageInfo query(Map paramMap);

    /**
     * 科研平台项目删除
     */
    Integer delete(String id);

    /**
     * 批量保存平台成果
     */
    Integer batchSave(List<PlatformAchievementModel> dataList);

}
