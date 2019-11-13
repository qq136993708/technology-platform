package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryStandard;
import com.pcitc.base.laboratory.LaboratoryStandardExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryStandardMapper {
    long countByExample(LaboratoryStandardExample example);

    int deleteByExample(LaboratoryStandardExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryStandard record);

    int insertSelective(LaboratoryStandard record);

    List<LaboratoryStandard> selectByExample(LaboratoryStandardExample example);

    LaboratoryStandard selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryStandard record, @Param("example") LaboratoryStandardExample example);

    int updateByExample(@Param("record") LaboratoryStandard record, @Param("example") LaboratoryStandardExample example);

    int updateByPrimaryKeySelective(LaboratoryStandard record);

    int updateByPrimaryKey(LaboratoryStandard record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryStandard record);

    List<LaboratoryStandard> findLaboratoryStandardByPage(Map<String, Object> map);

    List<LaboratoryStandard> findLaboratoryStandardList(LaboratoryStandard record);

}