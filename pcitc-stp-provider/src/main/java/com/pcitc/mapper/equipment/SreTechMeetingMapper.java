package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreTechMeeting;

public interface SreTechMeetingMapper {
    int deleteByPrimaryKey(String meetingId);

    int insert(SreTechMeeting record);

    int insertSelective(SreTechMeeting record);

    SreTechMeeting selectByPrimaryKey(String meetingId);

    int updateByPrimaryKeySelective(SreTechMeeting record);

    int updateByPrimaryKey(SreTechMeeting record);
    
    
    List<SreTechMeeting> getList(Map  map);
    int getCount(Map map);
}