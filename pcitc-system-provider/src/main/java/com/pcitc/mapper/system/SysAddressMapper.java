package com.pcitc.mapper.system;

import com.pcitc.base.system.SysAddress;
import com.pcitc.base.system.SysAddressExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysAddressMapper {
    long countByExample(SysAddressExample example);

    int deleteByExample(SysAddressExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysAddress record);

    int insertSelective(SysAddress record);

    List<SysAddress> selectByExample(SysAddressExample example);

    SysAddress selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysAddress record, @Param("example") SysAddressExample example);

    int updateByExample(@Param("record") SysAddress record, @Param("example") SysAddressExample example);

    int updateByPrimaryKeySelective(SysAddress record);

    int updateByPrimaryKey(SysAddress record);

    int updateByPrimaryKeyWithBLOBs(SysAddress record);

    List<SysAddress> findSysAddressByPage(Map<String, Object> map);

    List<SysAddress> findSysAddressList(SysAddress record);

}