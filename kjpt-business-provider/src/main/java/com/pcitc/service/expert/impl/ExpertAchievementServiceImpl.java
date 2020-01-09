package com.pcitc.service.expert.impl;

import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkProject;
import com.pcitc.mapper.expert.ZjkAchievementMapper;
import com.pcitc.mapper.expert.ZjkProjectMapper;
import com.pcitc.service.expert.ExpertAchievementService;
import com.pcitc.service.expert.ExpertProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class ExpertAchievementServiceImpl implements ExpertAchievementService {
    @Autowired
    private ZjkAchievementMapper zjkAchievementMapper;

    @Override
    public List<ZjkAchievement> queryNoPage(Map paramMap) {
        return  zjkAchievementMapper.query(paramMap);
    }

}
