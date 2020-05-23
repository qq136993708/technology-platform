package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.system.CustomQueryCondition;

public interface CustomQueryConditionMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomQueryCondition record);

    int insertSelective(CustomQueryCondition record);

    CustomQueryCondition selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomQueryCondition record);

    int updateByPrimaryKey(CustomQueryCondition record);
    
    List getList(Map map);
    int getCount(Map map);
}