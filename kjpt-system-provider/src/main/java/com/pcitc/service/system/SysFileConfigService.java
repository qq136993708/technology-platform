package com.pcitc.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysFileConfig;
import com.pcitc.base.system.SysFileConfigExample;

/**
 * <p>接口类</p>
 * <p>Table: sys_file_config - InnoDB free: 5120 kB</p>
 *
 * @since 2018-05-12 09:49:59
 */
public interface SysFileConfigService {
        long countByExample(SysFileConfigExample example);

        int deleteByExample(SysFileConfigExample example);

        int deleteByPrimaryKey(String menuId);

        int insert(SysFileConfig record);

        SysFileConfig insertObject(SysFileConfig record);

        int insertSelective(SysFileConfig record);

        List<SysFileConfig> selectByExample(SysFileConfigExample example);

        SysFileConfig selectByPrimaryKey(String menuId);

        int updateByExampleSelective(@Param("record") SysFileConfig record, @Param("example") SysFileConfigExample example);

        int updateByExample(@Param("record") SysFileConfig record, @Param("example") SysFileConfigExample example);

        int updateByPrimaryKeySelective(SysFileConfig record);

        int updateByPrimaryKey(SysFileConfig record);

        /**
        * 删除菜单
        * @param sysMenuId
        * @return
        */
        DataOperationStatusEnum deleteSysFileConfig(java.io.Serializable sysMenuId);
        /**
        *
        * @param jsonStr 分页组件传过来的参数列表
        * @return
        */
        PageInfo<SysFileConfig> findSysFileConfigByPage(String jsonStr);
        int deleteSysFileConfigReal(String menuId);

        List<TreeNode> selectObjectByTree();
}