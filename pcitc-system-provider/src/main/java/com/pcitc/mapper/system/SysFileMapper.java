package com.pcitc.mapper.system;

import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysFileExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysFileMapper {
    long countByExample(SysFileExample example);

    int deleteByExample(SysFileExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFile record);

    int insertSelective(SysFile record);

    List<SysFile> selectByExample(SysFileExample example);

    SysFile selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByPrimaryKeySelective(SysFile record);

    int updateByPrimaryKey(SysFile record);

    String selectMaxEsId();

    void updateSysFileFlag(Map<String,String> map);

    void deleteSysFileByDataId(Map<String,String> map);
}