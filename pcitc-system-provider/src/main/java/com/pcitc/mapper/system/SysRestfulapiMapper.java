package com.pcitc.mapper.system;

import com.pcitc.base.system.SysRestfulapi;
import com.pcitc.base.system.SysRestfulapiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRestfulapiMapper {
    long countByExample(SysRestfulapiExample example);

    int deleteByExample(SysRestfulapiExample example);

    int insert(SysRestfulapi record);

    int insertSelective(SysRestfulapi record);

    List<SysRestfulapi> selectByExample(SysRestfulapiExample example);

    int updateByExampleSelective(@Param("record") SysRestfulapi record, @Param("example") SysRestfulapiExample example);

    int updateByExample(@Param("record") SysRestfulapi record, @Param("example") SysRestfulapiExample example);

	Integer updateByPrimaryKey(SysRestfulapi srf);

	SysRestfulapi selectByPrimaryKey(String restfulapiId);

	Integer deleteByPrimaryKey(String restfulapiId);
}