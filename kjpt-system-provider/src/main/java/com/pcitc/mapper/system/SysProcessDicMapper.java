package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.system.SysProcessDic;

public interface SysProcessDicMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysProcessDic record);

    int insertSelective(SysProcessDic record);

    SysProcessDic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysProcessDic record);

    int updateByPrimaryKey(SysProcessDic record);
    
    List getList(Map map);
    int getCount(Map map);
    
}