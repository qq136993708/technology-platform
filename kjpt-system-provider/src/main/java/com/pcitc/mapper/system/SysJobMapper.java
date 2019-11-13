package com.pcitc.mapper.system;

import com.pcitc.base.system.SysJob;

import java.util.List;
import java.util.Map;

public interface SysJobMapper {
    int deleteByPrimaryKey(String dataId);

    int insert(SysJob record);

    int insertSelective(SysJob record);

    SysJob selectByPrimaryKey(String dataId);

    List<SysJob> selectByCondition(Map<String, Object> map);

    int updateByPrimaryKeySelective(SysJob record);

    int updateByPrimaryKey(SysJob record);
}