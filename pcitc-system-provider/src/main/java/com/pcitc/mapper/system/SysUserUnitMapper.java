package com.pcitc.mapper.system;

import com.pcitc.base.system.SysUserUnit;
import com.pcitc.base.system.SysUserUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserUnitMapper {
    long countByExample(SysUserUnitExample example);

    int deleteByExample(SysUserUnitExample example);

    int deleteByPrimaryKey(String relId);

    int insert(SysUserUnit record);

    int insertSelective(SysUserUnit record);

    List<SysUserUnit> selectByExample(SysUserUnitExample example);

    SysUserUnit selectByPrimaryKey(String relId);

    int updateByExampleSelective(@Param("record") SysUserUnit record, @Param("example") SysUserUnitExample example);

    int updateByExample(@Param("record") SysUserUnit record, @Param("example") SysUserUnitExample example);

    int updateByPrimaryKeySelective(SysUserUnit record);

    int updateByPrimaryKey(SysUserUnit record);
}