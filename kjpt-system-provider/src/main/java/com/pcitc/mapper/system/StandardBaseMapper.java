package com.pcitc.mapper.system;

import com.pcitc.base.system.StandardBase;
import com.pcitc.base.system.StandardBaseExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StandardBaseMapper {
    long countByExample(StandardBaseExample example);

    int deleteByExample(StandardBaseExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(StandardBase record);

    int insertSelective(StandardBase record);

    List<StandardBase> selectByExample(StandardBaseExample example);

    StandardBase selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") StandardBase record, @Param("example") StandardBaseExample example);

    int updateByExample(@Param("record") StandardBase record, @Param("example") StandardBaseExample example);

    int updateByPrimaryKeySelective(StandardBase record);

    int updateByPrimaryKey(StandardBase record);

    int updateByPrimaryKeyWithBLOBs(StandardBase record);

    List<StandardBase> findStandardBaseByPage(Map<String, Object> map);

    List<StandardBase> findStandardBaseList(StandardBase record);

}