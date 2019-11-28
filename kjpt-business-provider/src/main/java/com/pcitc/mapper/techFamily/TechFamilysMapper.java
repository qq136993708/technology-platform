package com.pcitc.mapper.techFamily;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.stp.techFamily.TechFamilys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface TechFamilysMapper {
    int deleteByPrimaryKey(String id);
    int  deleteLogicById(String  id);
    int insert(TechFamilys record);

    int insertSelective(TechFamilys record);

    TechFamilys selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TechFamilys record);

    int updateByPrimaryKey(TechFamilys record);
    
    List getList(Map map);
    int getCount(Map map);
    
    List   getChildListByParentId(String id);
    List<TreeNode>   getNodeList(Map map);
    
}