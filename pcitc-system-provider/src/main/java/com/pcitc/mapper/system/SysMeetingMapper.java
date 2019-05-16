package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.system.SysMeeting;

public interface SysMeetingMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysMeeting record);

    int insertSelective(SysMeeting record);

    SysMeeting selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMeeting record);

    int updateByPrimaryKey(SysMeeting record);
    

    List getList(Map map);
    int getCount(Map map);
    
}