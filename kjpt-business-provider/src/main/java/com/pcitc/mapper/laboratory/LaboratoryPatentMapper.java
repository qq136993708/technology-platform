package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryPatent;
import com.pcitc.base.laboratory.LaboratoryPatentExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryPatentMapper {
    long countByExample(LaboratoryPatentExample example);

    int deleteByExample(LaboratoryPatentExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryPatent record);

    int insertSelective(LaboratoryPatent record);

    List<LaboratoryPatent> selectByExample(LaboratoryPatentExample example);

    LaboratoryPatent selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryPatent record, @Param("example") LaboratoryPatentExample example);

    int updateByExample(@Param("record") LaboratoryPatent record, @Param("example") LaboratoryPatentExample example);

    int updateByPrimaryKeySelective(LaboratoryPatent record);

    int updateByPrimaryKey(LaboratoryPatent record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryPatent record);

    List<LaboratoryPatent> findLaboratoryPatentByPage(Map<String, Object> map);

    List<LaboratoryPatent> findLaboratoryPatentList(LaboratoryPatent record);

}