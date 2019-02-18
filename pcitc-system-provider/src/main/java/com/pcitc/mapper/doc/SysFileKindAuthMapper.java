package com.pcitc.mapper.doc;

import com.pcitc.base.doc.SysFileKindAuth;
import com.pcitc.base.doc.SysFileKindAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFileKindAuthMapper {
    int countByExample(SysFileKindAuthExample example);

    int deleteByExample(SysFileKindAuthExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(SysFileKindAuth record);

    int insertSelective(SysFileKindAuth record);

    List<SysFileKindAuth> selectByExample(SysFileKindAuthExample example);

    SysFileKindAuth selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") SysFileKindAuth record, @Param("example") SysFileKindAuthExample example);

    int updateByExample(@Param("record") SysFileKindAuth record, @Param("example") SysFileKindAuthExample example);

    int updateByPrimaryKeySelective(SysFileKindAuth record);

    int updateByPrimaryKey(SysFileKindAuth record);
}