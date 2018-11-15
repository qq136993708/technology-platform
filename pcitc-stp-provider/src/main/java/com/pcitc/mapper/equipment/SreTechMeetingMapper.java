package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.stp.equipment.SreTechMeetingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreTechMeetingMapper {
    int countByExample(SreTechMeetingExample example);

    int deleteByExample(SreTechMeetingExample example);

    int deleteByPrimaryKey(String meetingId);

    int insert(SreTechMeeting record);

    int insertSelective(SreTechMeeting record);

    List<SreTechMeeting> selectByExample(SreTechMeetingExample example);

    SreTechMeeting selectByPrimaryKey(String meetingId);

    int updateByExampleSelective(@Param("record") SreTechMeeting record, @Param("example") SreTechMeetingExample example);

    int updateByExample(@Param("record") SreTechMeeting record, @Param("example") SreTechMeetingExample example);

    int updateByPrimaryKeySelective(SreTechMeeting record);

    int updateByPrimaryKey(SreTechMeeting record);
}