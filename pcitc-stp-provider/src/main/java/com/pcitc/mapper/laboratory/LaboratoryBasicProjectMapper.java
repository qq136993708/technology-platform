package com.pcitc.mapper.laboratory;

import com.pcitc.base.laboratory.LaboratoryBasicProject;
import com.pcitc.base.laboratory.LaboratoryBasicProjectExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LaboratoryBasicProjectMapper {
    long countByExample(LaboratoryBasicProjectExample example);

    int deleteByExample(LaboratoryBasicProjectExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(LaboratoryBasicProject record);

    int insertSelective(LaboratoryBasicProject record);

    List<LaboratoryBasicProject> selectByExample(LaboratoryBasicProjectExample example);

    LaboratoryBasicProject selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") LaboratoryBasicProject record, @Param("example") LaboratoryBasicProjectExample example);

    int updateByExample(@Param("record") LaboratoryBasicProject record, @Param("example") LaboratoryBasicProjectExample example);

    int updateByPrimaryKeySelective(LaboratoryBasicProject record);

    int updateByPrimaryKey(LaboratoryBasicProject record);

    int updateByPrimaryKeyWithBLOBs(LaboratoryBasicProject record);

    List<LaboratoryBasicProject> findLaboratoryBasicProjectByPage(Map<String, Object> map);

    List<LaboratoryBasicProject> findLaboratoryBasicProjectList(LaboratoryBasicProject record);

}