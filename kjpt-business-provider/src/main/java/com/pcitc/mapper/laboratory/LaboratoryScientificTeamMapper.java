package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryScientificTeam;
import com.pcitc.base.laboratory.LaboratoryScientificTeamExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryScientificTeamMapper {
    long countByExample(LaboratoryScientificTeamExample example);

    int deleteByExample(LaboratoryScientificTeamExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryScientificTeam record);

    int insertSelective(LaboratoryScientificTeam record);

    List<LaboratoryScientificTeam> selectByExample(LaboratoryScientificTeamExample example);

    LaboratoryScientificTeam selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryScientificTeam record, @Param("example") LaboratoryScientificTeamExample example);

    int updateByExample(@Param("record") LaboratoryScientificTeam record, @Param("example") LaboratoryScientificTeamExample example);

    int updateByPrimaryKeySelective(LaboratoryScientificTeam record);

    int updateByPrimaryKey(LaboratoryScientificTeam record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryScientificTeam record);

    List<LaboratoryScientificTeam> findLaboratoryScientificTeamByPage(Map<String, Object> map);

    List<LaboratoryScientificTeam> findLaboratoryScientificTeamList(LaboratoryScientificTeam record);

}