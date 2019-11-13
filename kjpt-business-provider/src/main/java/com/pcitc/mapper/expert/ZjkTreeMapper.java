package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkTree;
import com.pcitc.base.expert.ZjkTreeExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import javax.swing.tree.TreeNode;

public interface ZjkTreeMapper {
    long countByExample(ZjkTreeExample example);

    int deleteByExample(ZjkTreeExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkTree record);

    int insertSelective(ZjkTree record);

    List<ZjkTree> selectByExample(ZjkTreeExample example);

    ZjkTree selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkTree record, @Param("example") ZjkTreeExample example);

    int updateByExample(@Param("record") ZjkTree record, @Param("example") ZjkTreeExample example);

    int updateByPrimaryKeySelective(ZjkTree record);

    int updateByPrimaryKey(ZjkTree record);

    int updateByPrimaryKeyWithBLOBs(ZjkTree record);

    List<ZjkTree> findZjkTreeByPage(Map<String, Object> map);

    List<ZjkTree> findZjkTreeList(ZjkTree record);

    List<com.pcitc.base.common.TreeNode> selectTree(Map map);

}