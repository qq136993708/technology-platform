package com.pcitc.mapper.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.system.SysLogExample;

public interface SysLogMapper {
    long countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
    
    int insertBatch(List<SysLog> list);

	int deleteSysLogById(@Param("ids")List<String> ids);
}