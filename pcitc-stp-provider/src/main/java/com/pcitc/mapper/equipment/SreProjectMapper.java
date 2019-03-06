package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectExample;

public interface SreProjectMapper {
    int countByExample(SreProjectExample example);

    int deleteByExample(SreProjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(SreProject record);

    int insertSelective(SreProject record);

    List<SreProject> selectByExample(SreProjectExample example);

    SreProject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SreProject record, @Param("example") SreProjectExample example);

    int updateByExample(@Param("record") SreProject record, @Param("example") SreProjectExample example);

    int updateByPrimaryKeySelective(SreProject record);

    int updateByPrimaryKey(SreProject record);
    
    
    List<SreProject> getList(Map  map);
    int getCount(Map map);
    
}