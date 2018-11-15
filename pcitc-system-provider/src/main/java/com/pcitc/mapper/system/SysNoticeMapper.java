package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysNoticeExample;

public interface SysNoticeMapper {
    long countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    int deleteByPrimaryKey(String noticeId);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    List<SysNotice> selectByExample(SysNoticeExample example);

    SysNotice selectByPrimaryKey(String noticeId);

    int updateByExampleSelective(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByExample(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);

    /**
     * 首页:查询新闻信息
     * @param record
     * @return
     */
    List<SysNotice> selectNoticeMain(SysNotice record);
    
    /**
     * 查询已发布的公告
     * @param mapParams
     * @return
     */
    List<SysNotice> selectPubNoticeList(Map<String, Object> mapParams);
}