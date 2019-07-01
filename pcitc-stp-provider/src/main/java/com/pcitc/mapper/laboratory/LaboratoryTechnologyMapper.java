package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryTechnology;
import com.pcitc.base.laboratory.LaboratoryTechnologyExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryTechnologyMapper {
    long countByExample(LaboratoryTechnologyExample example);

    int deleteByExample(LaboratoryTechnologyExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryTechnology record);

    int insertSelective(LaboratoryTechnology record);

    List<LaboratoryTechnology> selectByExample(LaboratoryTechnologyExample example);

    LaboratoryTechnology selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryTechnology record, @Param("example") LaboratoryTechnologyExample example);

    int updateByExample(@Param("record") LaboratoryTechnology record, @Param("example") LaboratoryTechnologyExample example);

    int updateByPrimaryKeySelective(LaboratoryTechnology record);

    int updateByPrimaryKey(LaboratoryTechnology record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryTechnology record);

    List<LaboratoryTechnology> findLaboratoryTechnologyByPage(Map<String, Object> map);

    List<LaboratoryTechnology> findLaboratoryTechnologyList(LaboratoryTechnology record);

}