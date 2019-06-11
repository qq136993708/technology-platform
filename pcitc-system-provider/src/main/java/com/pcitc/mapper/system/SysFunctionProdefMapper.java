package com.pcitc.mapper.system;

import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.SysFunctionProdefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFunctionProdefMapper {
    int countByExample(SysFunctionProdefExample example);

    int deleteByExample(SysFunctionProdefExample example);

    int deleteByPrimaryKey(String functionProdefId);

    int insert(SysFunctionProdef record);

    int insertSelective(SysFunctionProdef record);

    List<SysFunctionProdef> selectByExample(SysFunctionProdefExample example);

    SysFunctionProdef selectByPrimaryKey(String functionProdefId);

    int updateByExampleSelective(@Param("record") SysFunctionProdef record, @Param("example") SysFunctionProdefExample example);

    int updateByExample(@Param("record") SysFunctionProdef record, @Param("example") SysFunctionProdefExample example);

    int updateByPrimaryKeySelective(SysFunctionProdef record);

    int updateByPrimaryKey(SysFunctionProdef record);
}