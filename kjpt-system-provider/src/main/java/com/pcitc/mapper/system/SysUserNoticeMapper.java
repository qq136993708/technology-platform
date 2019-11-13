package com.pcitc.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysUserNotice;
import com.pcitc.base.system.SysUserNoticeExample;

public interface SysUserNoticeMapper {
    long countByExample(SysUserNoticeExample example);

    int deleteByExample(SysUserNoticeExample example);

    int insert(SysUserNotice record);

    int insertSelective(SysUserNotice record);

    List<SysUserNotice> selectByExample(SysUserNoticeExample example);

    int updateByExampleSelective(@Param("record") SysUserNotice record, @Param("example") SysUserNoticeExample example);

    int updateByExample(@Param("record") SysUserNotice record, @Param("example") SysUserNoticeExample example);
    
    int insertBatch(List<SysUserNotice> list);
}