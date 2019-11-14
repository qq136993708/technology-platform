package com.pcitc.mapper.doc;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.doc.SysFileShare;
import com.pcitc.base.doc.SysFileShareExample;
import com.pcitc.base.system.SysUnit;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysFileShareMapper {
    long countByExample(SysFileShareExample example);

    int deleteByExample(SysFileShareExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysFileShare record);

    int insertSelective(SysFileShare record);

    List<SysFileShare> selectByExample(SysFileShareExample example);

    SysFileShare selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFileShare record, @Param("example") SysFileShareExample example);

    int updateByExample(@Param("record") SysFileShare record, @Param("example") SysFileShareExample example);

    int updateByPrimaryKeySelective(SysFileShare record);

    int updateByPrimaryKey(SysFileShare record);

    int updateByPrimaryKeyWithBLOBs(SysFileShare record);

    List<SysFileShare> findSysFileShareByPage(Map<String, Object> map);

    List<SysFileShare> findSysFileShareList(SysFileShare record);

    void deleteObj(SysFileShare record);

    void deleteObjByParam(String fileId);
    
    
    /**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * 包含文件已分享信息
	 */
	List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit);

}