package com.pcitc.mapper.system;

import com.pcitc.base.system.SysUnitMapping;
import com.pcitc.base.system.SysUnitMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUnitMappingMapper {
    int countByExample(SysUnitMappingExample example);

    int deleteByExample(SysUnitMappingExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(SysUnitMapping record);

    int insertSelective(SysUnitMapping record);

    List<SysUnitMapping> selectByExample(SysUnitMappingExample example);

    SysUnitMapping selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") SysUnitMapping record, @Param("example") SysUnitMappingExample example);

    int updateByExample(@Param("record") SysUnitMapping record, @Param("example") SysUnitMappingExample example);

    int updateByPrimaryKeySelective(SysUnitMapping record);

    int updateByPrimaryKey(SysUnitMapping record);
}