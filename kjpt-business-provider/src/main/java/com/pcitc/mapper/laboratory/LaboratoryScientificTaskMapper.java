package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryScientificTask;
import com.pcitc.base.laboratory.LaboratoryScientificTaskExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryScientificTaskMapper {
    long countByExample(LaboratoryScientificTaskExample example);

    int deleteByExample(LaboratoryScientificTaskExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryScientificTask record);

    int insertSelective(LaboratoryScientificTask record);

    List<LaboratoryScientificTask> selectByExample(LaboratoryScientificTaskExample example);

    LaboratoryScientificTask selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryScientificTask record, @Param("example") LaboratoryScientificTaskExample example);

    int updateByExample(@Param("record") LaboratoryScientificTask record, @Param("example") LaboratoryScientificTaskExample example);

    int updateByPrimaryKeySelective(LaboratoryScientificTask record);

    int updateByPrimaryKey(LaboratoryScientificTask record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryScientificTask record);

    List<LaboratoryScientificTask> findLaboratoryScientificTaskByPage(Map<String, Object> map);

    List<LaboratoryScientificTask> findLaboratoryScientificTaskList(LaboratoryScientificTask record);

}