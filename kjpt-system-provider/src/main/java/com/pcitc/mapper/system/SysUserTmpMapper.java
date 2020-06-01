package com.pcitc.mapper.system;
import java.util.List;
import java.util.Map;
import com.pcitc.base.system.SysUserTmp;

public interface SysUserTmpMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUserTmp record);

    int insertSelective(SysUserTmp record);

    SysUserTmp selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUserTmp record);

    int updateByPrimaryKey(SysUserTmp record);
    
    List getList(Map map);
    
    int getCount(Map map);
    
    
}