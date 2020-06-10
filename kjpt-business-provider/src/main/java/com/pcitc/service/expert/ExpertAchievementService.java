package com.pcitc.service.expert;

import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkProject;

import java.util.List;
import java.util.Map;

/**
 * 科研平台项目的增删改查
 * @author ty
 */
public interface ExpertAchievementService {


    /**
     * 查询专家信息管理项目列表
     */
    List<ZjkAchievement> queryNoPage(Map paramMap);

    public void insertBatch(List<ZjkAchievement> list)throws Exception;

}
