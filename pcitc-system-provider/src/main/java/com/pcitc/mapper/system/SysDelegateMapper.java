package com.pcitc.mapper.system;

import com.pcitc.base.workflow.SysDelegate;
import com.pcitc.base.workflow.SysDelegateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDelegateMapper {
    int countByExample(SysDelegateExample example);

    int deleteByExample(SysDelegateExample example);

    int deleteByPrimaryKey(String delegateId);

    int insert(SysDelegate record);

    int insertSelective(SysDelegate record);

    List<SysDelegate> selectByExample(SysDelegateExample example);

    SysDelegate selectByPrimaryKey(String delegateId);

    int updateByExampleSelective(@Param("record") SysDelegate record, @Param("example") SysDelegateExample example);

    int updateByExample(@Param("record") SysDelegate record, @Param("example") SysDelegateExample example);

    int updateByPrimaryKeySelective(SysDelegate record);

    int updateByPrimaryKey(SysDelegate record);
}