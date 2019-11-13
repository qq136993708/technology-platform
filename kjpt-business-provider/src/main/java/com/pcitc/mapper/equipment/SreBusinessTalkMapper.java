package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreBusinessTalk;
import com.pcitc.base.stp.equipment.SreBusinessTalkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreBusinessTalkMapper {
    int countByExample(SreBusinessTalkExample example);

    int deleteByExample(SreBusinessTalkExample example);

    int deleteByPrimaryKey(String talkId);

    int insert(SreBusinessTalk record);

    int insertSelective(SreBusinessTalk record);

    List<SreBusinessTalk> selectByExample(SreBusinessTalkExample example);

    SreBusinessTalk selectByPrimaryKey(String talkId);

    int updateByExampleSelective(@Param("record") SreBusinessTalk record, @Param("example") SreBusinessTalkExample example);

    int updateByExample(@Param("record") SreBusinessTalk record, @Param("example") SreBusinessTalkExample example);

    int updateByPrimaryKeySelective(SreBusinessTalk record);

    int updateByPrimaryKey(SreBusinessTalk record);
}