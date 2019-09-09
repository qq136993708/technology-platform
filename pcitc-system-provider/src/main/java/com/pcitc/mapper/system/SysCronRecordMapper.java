package com.pcitc.mapper.system;

import com.pcitc.base.system.SysCronRecord;
import com.pcitc.base.system.SysCronRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCronRecordMapper {
    long countByExample(SysCronRecordExample example);

    int deleteByExample(SysCronRecordExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(SysCronRecord record);

    int insertSelective(SysCronRecord record);

    List<SysCronRecord> selectByExample(SysCronRecordExample example);

    SysCronRecord selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") SysCronRecord record, @Param("example") SysCronRecordExample example);

    int updateByExample(@Param("record") SysCronRecord record, @Param("example") SysCronRecordExample example);

    int updateByPrimaryKeySelective(SysCronRecord record);

    int updateByPrimaryKey(SysCronRecord record);
}