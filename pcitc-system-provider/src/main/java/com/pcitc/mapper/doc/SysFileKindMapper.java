package com.pcitc.mapper.doc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.doc.SysFileKind;
import com.pcitc.base.doc.SysFileKindExample;
import com.pcitc.base.system.SysUser;

public interface SysFileKindMapper {
    long countByExample(SysFileKindExample example);

    int deleteByExample(SysFileKindExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFileKind record);

    int insertSelective(SysFileKind record);

    List<SysFileKind> selectByExample(SysFileKindExample example);

    SysFileKind selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFileKind record, @Param("example") SysFileKindExample example);

    int updateByExample(@Param("record") SysFileKind record, @Param("example") SysFileKindExample example);

    int updateByPrimaryKeySelective(SysFileKind record);

    int updateByPrimaryKey(SysFileKind record);

    int updateByPrimaryKeyWithBLOBs(SysFileKind record);

    List<SysFileKind> findSysFileKindByPage(Map<String, Object> map);

    List<SysFileKind> findSysFileKindList(SysFileKind record);

    List<TreeNode> selectTrees(HashMap<String, Object> map);
    
    List<SysUser> getSysFileKindUserListData(HashMap<String, Object> map);
}