package com.pcitc.mapper.outApi;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutStandardData;
import com.pcitc.base.stp.out.OutStandardDataExample;


public interface OutStandardDataMapper 
{
    long countByExample(OutStandardDataExample example);

    int deleteByExample(OutStandardDataExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutStandardData record);

    int insertSelective(OutStandardData record);

    List<OutStandardData> selectByExample(OutStandardDataExample example);

    OutStandardData selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutStandardData record, @Param("example") OutStandardDataExample example);

    int updateByExample(@Param("record") OutStandardData record, @Param("example") OutStandardDataExample example);

    int updateByPrimaryKeySelective(OutStandardData record);

    int updateByPrimaryKey(OutStandardData record);
}