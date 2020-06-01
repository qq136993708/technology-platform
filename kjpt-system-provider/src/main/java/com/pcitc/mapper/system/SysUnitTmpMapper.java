package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.SysUnitTmp;

public interface SysUnitTmpMapper {
    int deleteByPrimaryKey(String unitId);

    int insert(SysUnitTmp record);

    int insertSelective(SysUnitTmp record);

    SysUnitTmp selectByPrimaryKey(String unitId);

    int updateByPrimaryKeySelective(SysUnitTmp record);

    int updateByPrimaryKey(SysUnitTmp record);
    
    List getList(Map map);
    public List<TreeNode> getTreeNodeList(Map map);
    int getCount(Map map);
    
}