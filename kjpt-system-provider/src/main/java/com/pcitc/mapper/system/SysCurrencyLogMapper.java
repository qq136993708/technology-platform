package com.pcitc.mapper.system;

import com.pcitc.base.system.SysCurrencyLog;
import com.pcitc.base.system.SysCurrencyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCurrencyLogMapper {
    long countByExample(SysCurrencyLogExample example);

    int deleteByExample(SysCurrencyLogExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(SysCurrencyLog record);

    int insertSelective(SysCurrencyLog record);

    List<SysCurrencyLog> selectByExample(SysCurrencyLogExample example);

    SysCurrencyLog selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") SysCurrencyLog record, @Param("example") SysCurrencyLogExample example);

    int updateByExample(@Param("record") SysCurrencyLog record, @Param("example") SysCurrencyLogExample example);

    int updateByPrimaryKeySelective(SysCurrencyLog record);

    int updateByPrimaryKey(SysCurrencyLog record);
}