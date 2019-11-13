package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryBase;
import com.pcitc.base.laboratory.LaboratoryBaseExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryBaseMapper {
    long countByExample(LaboratoryBaseExample example);

    int deleteByExample(LaboratoryBaseExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryBase record);

    int insertSelective(LaboratoryBase record);

    List<LaboratoryBase> selectByExample(LaboratoryBaseExample example);

    LaboratoryBase selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryBase record, @Param("example") LaboratoryBaseExample example);

    int updateByExample(@Param("record") LaboratoryBase record, @Param("example") LaboratoryBaseExample example);

    int updateByPrimaryKeySelective(LaboratoryBase record);

    int updateByPrimaryKey(LaboratoryBase record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryBase record);

    List<LaboratoryBase> findLaboratoryBaseByPage(Map<String, Object> map);

    List<LaboratoryBase> findLaboratoryBaseList(LaboratoryBase record);

}