package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.ProjectMoney;

public interface ProjectMoneyMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectMoney record);

    int insertSelective(ProjectMoney record);

    ProjectMoney selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectMoney record);

    int updateByPrimaryKey(ProjectMoney record);
    public int deleteProjectMoneyByProjectId(String projectId);
    List getList(Map map);
    int getCount(Map map);
    
}