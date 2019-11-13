package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryLeadingTalents;
import com.pcitc.base.laboratory.LaboratoryLeadingTalentsExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryLeadingTalentsMapper {
    long countByExample(LaboratoryLeadingTalentsExample example);

    int deleteByExample(LaboratoryLeadingTalentsExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryLeadingTalents record);

    int insertSelective(LaboratoryLeadingTalents record);

    List<LaboratoryLeadingTalents> selectByExample(LaboratoryLeadingTalentsExample example);

    LaboratoryLeadingTalents selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryLeadingTalents record, @Param("example") LaboratoryLeadingTalentsExample example);

    int updateByExample(@Param("record") LaboratoryLeadingTalents record, @Param("example") LaboratoryLeadingTalentsExample example);

    int updateByPrimaryKeySelective(LaboratoryLeadingTalents record);

    int updateByPrimaryKey(LaboratoryLeadingTalents record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryLeadingTalents record);

    List<LaboratoryLeadingTalents> findLaboratoryLeadingTalentsByPage(Map<String, Object> map);

    List<LaboratoryLeadingTalents> findLaboratoryLeadingTalentsList(LaboratoryLeadingTalents record);

}