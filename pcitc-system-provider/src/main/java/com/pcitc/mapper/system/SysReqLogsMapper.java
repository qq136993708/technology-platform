package com.pcitc.mapper.system;

import com.pcitc.base.system.SysReqLogs;
import com.pcitc.base.system.SysReqLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysReqLogsMapper {
    long countByExample(SysReqLogsExample example);

    int deleteByExample(SysReqLogsExample example);

    int insert(SysReqLogs record);

    int insertSelective(SysReqLogs record);

    List<SysReqLogs> selectByExample(SysReqLogsExample example);

    int updateByExampleSelective(@Param("record") SysReqLogs record, @Param("example") SysReqLogsExample example);

    int updateByExample(@Param("record") SysReqLogs record, @Param("example") SysReqLogsExample example);
}