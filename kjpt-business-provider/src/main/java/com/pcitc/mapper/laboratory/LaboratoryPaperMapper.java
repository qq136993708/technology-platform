package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryPaper;
import com.pcitc.base.laboratory.LaboratoryPaperExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryPaperMapper {
    long countByExample(LaboratoryPaperExample example);

    int deleteByExample(LaboratoryPaperExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryPaper record);

    int insertSelective(LaboratoryPaper record);

    List<LaboratoryPaper> selectByExample(LaboratoryPaperExample example);

    LaboratoryPaper selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryPaper record, @Param("example") LaboratoryPaperExample example);

    int updateByExample(@Param("record") LaboratoryPaper record, @Param("example") LaboratoryPaperExample example);

    int updateByPrimaryKeySelective(LaboratoryPaper record);

    int updateByPrimaryKey(LaboratoryPaper record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryPaper record);

    List<LaboratoryPaper> findLaboratoryPaperByPage(Map<String, Object> map);

    List<LaboratoryPaper> findLaboratoryPaperList(LaboratoryPaper record);

}