package com.pcitc.mapper.doc;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.doc.SysFileKindAuth;
import com.pcitc.base.doc.SysFileKindAuthExample;
import com.pcitc.base.system.SysUnit;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFileKindAuthMapper {
    int countByExample(SysFileKindAuthExample example);

    int deleteByExample(SysFileKindAuthExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(SysFileKindAuth record);

    int insertSelective(SysFileKindAuth record);

    List<SysFileKindAuth> selectByExample(SysFileKindAuthExample example);

    SysFileKindAuth selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") SysFileKindAuth record, @Param("example") SysFileKindAuthExample example);

    int updateByExample(@Param("record") SysFileKindAuth record, @Param("example") SysFileKindAuthExample example);

    int updateByPrimaryKeySelective(SysFileKindAuth record);

    int updateByPrimaryKey(SysFileKindAuth record);
    
    /**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * 已配置功能权限的默认勾选
	 */
	List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit);
}