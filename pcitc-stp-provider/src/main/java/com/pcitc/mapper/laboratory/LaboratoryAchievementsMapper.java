package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryAchievements;
import com.pcitc.base.laboratory.LaboratoryAchievementsExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryAchievementsMapper {
    long countByExample(LaboratoryAchievementsExample example);

    int deleteByExample(LaboratoryAchievementsExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryAchievements record);

    int insertSelective(LaboratoryAchievements record);

    List<LaboratoryAchievements> selectByExample(LaboratoryAchievementsExample example);

    LaboratoryAchievements selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryAchievements record, @Param("example") LaboratoryAchievementsExample example);

    int updateByExample(@Param("record") LaboratoryAchievements record, @Param("example") LaboratoryAchievementsExample example);

    int updateByPrimaryKeySelective(LaboratoryAchievements record);

    int updateByPrimaryKey(LaboratoryAchievements record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryAchievements record);

    List<LaboratoryAchievements> findLaboratoryAchievementsByPage(Map<String, Object> map);

    List<LaboratoryAchievements> findLaboratoryAchievementsList(LaboratoryAchievements record);

}