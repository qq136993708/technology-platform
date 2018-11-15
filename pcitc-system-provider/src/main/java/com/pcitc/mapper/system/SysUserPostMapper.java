package com.pcitc.mapper.system;

import com.pcitc.base.system.SysUserPost;
import com.pcitc.base.system.SysUserPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserPostMapper {
    long countByExample(SysUserPostExample example);

    int deleteByExample(SysUserPostExample example);

    int deleteByPrimaryKey(String relId);

    int insert(SysUserPost record);

    int insertSelective(SysUserPost record);

    List<SysUserPost> selectByExample(SysUserPostExample example);

    SysUserPost selectByPrimaryKey(String relId);

    int updateByExampleSelective(@Param("record") SysUserPost record, @Param("example") SysUserPostExample example);

    int updateByExample(@Param("record") SysUserPost record, @Param("example") SysUserPostExample example);

    int updateByPrimaryKeySelective(SysUserPost record);

    int updateByPrimaryKey(SysUserPost record);
}