package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreProject;

public interface SreProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreProject record);

    int insertSelective(SreProject record);

    SreProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreProject record);

    int updateByPrimaryKey(SreProject record);
    
    List getList(Map map);
    int getCount(Map map);

	List<SreProject> getSelectDate(Map map);
}