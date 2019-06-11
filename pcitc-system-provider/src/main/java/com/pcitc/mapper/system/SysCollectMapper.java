package com.pcitc.mapper.system;

import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCollectMapper {
    int countByExample(SysCollectExample example);

    int deleteByExample(SysCollectExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(SysCollect record);

    int insertSelective(SysCollect record);

    List<SysCollect> selectByExample(SysCollectExample example);

    SysCollect selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") SysCollect record, @Param("example") SysCollectExample example);

    int updateByExample(@Param("record") SysCollect record, @Param("example") SysCollectExample example);

    int updateByPrimaryKeySelective(SysCollect record);

    int updateByPrimaryKey(SysCollect record);
}