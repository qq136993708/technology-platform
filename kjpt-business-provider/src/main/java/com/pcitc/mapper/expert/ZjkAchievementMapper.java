package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkAchievement;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ZjkAchievementMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(ZjkAchievement record);

    int insertSelective(ZjkAchievement record);

    ZjkAchievement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkAchievement record);

    int updateByPrimaryKey(ZjkAchievement record);
    
    List getList(Map map);
    
    int getCount(Map map);
    
    int deleteLogicZjkAchievementByExpertId(String expertId);
    int deleteLogicZjkAchievementById(String expertId);
    int deleteZjkAchievementByExpertId(String expertId);
    List getListByExpertId(String expertId);
}