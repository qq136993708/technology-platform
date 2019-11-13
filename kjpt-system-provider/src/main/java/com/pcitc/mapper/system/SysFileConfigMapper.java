package com.pcitc.mapper.system;

import com.pcitc.base.system.SysFileConfig;
import com.pcitc.base.system.SysFileConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFileConfigMapper {
    long countByExample(SysFileConfigExample example);

    int deleteByExample(SysFileConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysFileConfig record);

    int insertSelective(SysFileConfig record);

    List<SysFileConfig> selectByExample(SysFileConfigExample example);

    SysFileConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysFileConfig record, @Param("example") SysFileConfigExample example);

    int updateByExample(@Param("record") SysFileConfig record, @Param("example") SysFileConfigExample example);

    int updateByPrimaryKeySelective(SysFileConfig record);

    int updateByPrimaryKey(SysFileConfig record);
}