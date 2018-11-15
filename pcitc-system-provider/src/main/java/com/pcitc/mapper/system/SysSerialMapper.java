package com.pcitc.mapper.system;

import com.pcitc.base.system.SysSerial;
import com.pcitc.base.system.SysSerialExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysSerialMapper {
    long countByExample(SysSerialExample example);

    int deleteByExample(SysSerialExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysSerial record);

    int insertSelective(SysSerial record);

    List<SysSerial> selectByExample(SysSerialExample example);

    SysSerial selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysSerial record, @Param("example") SysSerialExample example);

    int updateByExample(@Param("record") SysSerial record, @Param("example") SysSerialExample example);

    int updateByPrimaryKeySelective(SysSerial record);

    int updateByPrimaryKey(SysSerial record);

    int updateByPrimaryKeyWithBLOBs(SysSerial record);

    List<SysSerial> findSysSerialByPage(Map<String, Object> map);

    List<SysSerial> findSysSerialList(SysSerial record);

}