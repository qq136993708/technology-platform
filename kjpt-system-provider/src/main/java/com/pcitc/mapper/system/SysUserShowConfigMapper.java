package com.pcitc.mapper.system;

import com.pcitc.base.system.SysUserShowConfig;
import com.pcitc.base.system.SysUserShowConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserShowConfigMapper {
    int countByExample(SysUserShowConfigExample example);

    int deleteByExample(SysUserShowConfigExample example);

    int insert(SysUserShowConfig record);

    int insertSelective(SysUserShowConfig record);

    List<SysUserShowConfig> selectByExample(SysUserShowConfigExample example);

    int updateByExampleSelective(@Param("record") SysUserShowConfig record, @Param("example") SysUserShowConfigExample example);

    int updateByExample(@Param("record") SysUserShowConfig record, @Param("example") SysUserShowConfigExample example);
}