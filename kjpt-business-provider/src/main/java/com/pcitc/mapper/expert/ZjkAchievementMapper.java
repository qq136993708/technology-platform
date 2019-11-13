package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkAchievementExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkAchievementMapper {
    long countByExample(ZjkAchievementExample example);

    int deleteByExample(ZjkAchievementExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkAchievement record);

    int insertSelective(ZjkAchievement record);

    List<ZjkAchievement> selectByExample(ZjkAchievementExample example);

    ZjkAchievement selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkAchievement record, @Param("example") ZjkAchievementExample example);

    int updateByExample(@Param("record") ZjkAchievement record, @Param("example") ZjkAchievementExample example);

    int updateByPrimaryKeySelective(ZjkAchievement record);

    int updateByPrimaryKey(ZjkAchievement record);

    int updateByPrimaryKeyWithBLOBs(ZjkAchievement record);

    List<ZjkAchievement> findZjkAchievementByPage(Map<String, Object> map);

    List<ZjkAchievement> findZjkAchievementList(ZjkAchievement record);

}