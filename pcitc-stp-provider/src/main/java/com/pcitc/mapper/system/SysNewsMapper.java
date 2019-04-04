package com.pcitc.mapper.system;

import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.SysNewsExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysNewsMapper {
    long countByExample(SysNewsExample example);

    int deleteByExample(SysNewsExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysNews record);

    int insertSelective(SysNews record);

    List<SysNews> selectByExample(SysNewsExample example);

    SysNews selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysNews record, @Param("example") SysNewsExample example);

    int updateByExample(@Param("record") SysNews record, @Param("example") SysNewsExample example);

    int updateByPrimaryKeySelective(SysNews record);

    int updateByPrimaryKey(SysNews record);

    int updateByPrimaryKeyWithBLOBs(SysNews record);

    List<SysNews> findSysNewsByPage(Map<String, Object> map);

    List<SysNews> findSysNewsList(SysNews record);

}