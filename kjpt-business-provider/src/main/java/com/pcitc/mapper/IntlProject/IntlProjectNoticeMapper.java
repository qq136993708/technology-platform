package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectNotice;
import com.pcitc.base.stp.IntlProject.IntlProjectNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectNoticeMapper {
    long countByExample(IntlProjectNoticeExample example);

    int deleteByExample(IntlProjectNoticeExample example);

    int deleteByPrimaryKey(String noticeId);

    int insert(IntlProjectNotice record);

    int insertSelective(IntlProjectNotice record);

    List<IntlProjectNotice> selectByExample(IntlProjectNoticeExample example);

    IntlProjectNotice selectByPrimaryKey(String noticeId);

    int updateByExampleSelective(@Param("record") IntlProjectNotice record, @Param("example") IntlProjectNoticeExample example);

    int updateByExample(@Param("record") IntlProjectNotice record, @Param("example") IntlProjectNoticeExample example);

    int updateByPrimaryKeySelective(IntlProjectNotice record);

    int updateByPrimaryKey(IntlProjectNotice record);
}