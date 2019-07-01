package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratorySoftWork;
import com.pcitc.base.laboratory.LaboratorySoftWorkExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratorySoftWorkMapper {
    long countByExample(LaboratorySoftWorkExample example);

    int deleteByExample(LaboratorySoftWorkExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratorySoftWork record);

    int insertSelective(LaboratorySoftWork record);

    List<LaboratorySoftWork> selectByExample(LaboratorySoftWorkExample example);

    LaboratorySoftWork selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratorySoftWork record, @Param("example") LaboratorySoftWorkExample example);

    int updateByExample(@Param("record") LaboratorySoftWork record, @Param("example") LaboratorySoftWorkExample example);

    int updateByPrimaryKeySelective(LaboratorySoftWork record);

    int updateByPrimaryKey(LaboratorySoftWork record);

    int updateByPrimaryKeyWithBLOBs(LaboratorySoftWork record);

    List<LaboratorySoftWork> findLaboratorySoftWorkByPage(Map<String, Object> map);

    List<LaboratorySoftWork> findLaboratorySoftWorkList(LaboratorySoftWork record);

}