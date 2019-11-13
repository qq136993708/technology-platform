package com.pcitc.mapper.system;

import com.pcitc.base.system.SysMessage;
import com.pcitc.base.system.SysMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMessageMapper {
    int countByExample(SysMessageExample example);

    int deleteByExample(SysMessageExample example);

    int insert(SysMessage record);

    int insertSelective(SysMessage record);

    List<SysMessage> selectByExample(SysMessageExample example);

    int updateByExampleSelective(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByExample(@Param("record") SysMessage record, @Param("example") SysMessageExample example);
}