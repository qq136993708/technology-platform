package com.pcitc.mapper.expert;

import com.pcitc.base.expert.TechFamilyType;
import com.pcitc.base.expert.TechFamilyTypeExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TechFamilyTypeMapper {
    long countByExample(TechFamilyTypeExample example);

    int deleteByExample(TechFamilyTypeExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(TechFamilyType record);

    int insertSelective(TechFamilyType record);

    List<TechFamilyType> selectByExample(TechFamilyTypeExample example);

    TechFamilyType selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") TechFamilyType record, @Param("example") TechFamilyTypeExample example);

    int updateByExample(@Param("record") TechFamilyType record, @Param("example") TechFamilyTypeExample example);

    int updateByPrimaryKeySelective(TechFamilyType record);

    int updateByPrimaryKey(TechFamilyType record);

    int updateByPrimaryKeyWithBLOBs(TechFamilyType record);

    List<TechFamilyType> findTechFamilyTypeByPage(Map<String, Object> map);

    List<TechFamilyType> findTechFamilyTypeList(TechFamilyType record);

}