package com.pcitc.service.doc;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileKind;
import com.pcitc.base.doc.SysFileKindAuth;
import com.pcitc.base.doc.SysFileKindExample;
import com.pcitc.base.system.SysUnit;

/**
 * <p>接口类</p>
 * <p>Table: sys_file_kind - </p>
 *
 * @since 2018-06-19 09:24:12
 */
public interface SysFileKindService {

    List<SysFileKind> findSysFileKindList(SysFileKind record) throws Exception;

    int updateOrInsertSysFileKind(SysFileKind record) throws Exception;

    int deleteSysFileKindById(String id) throws Exception;


    SysFileKind getSysFileKindInfo(String id) throws Exception;


    long countByExample(SysFileKindExample example);

    int deleteByExample(SysFileKindExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFileKind record);

    SysFileKind insertObject(SysFileKind record);

    int insertSelective(SysFileKind record);

    List<SysFileKind> selectByExample(SysFileKindExample example);

    SysFileKind selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFileKind record, @Param("example") SysFileKindExample example);

    int updateByExample(@Param("record") SysFileKind record, @Param("example") SysFileKindExample example);

    int updateByPrimaryKeySelective(SysFileKind record);

    int updateByPrimaryKey(SysFileKind record);

    /**
     * 删除菜单
     *
     * @param sysMenuId
     * @return
     */
    DataOperationStatusEnum deleteSysFileKind(java.io.Serializable sysMenuId);

    /**
     * 分页查询
     * @param param
     * @return
     */
    public LayuiTableData findSysFileKindByPage(LayuiTableParam param);

    int deleteSysFileKindReal(String menuId);

    List<TreeNode> selectObjectByTree();

    /**
     * 查询树
     *
     * @return
     */
    public List<TreeNode> selectTrees(HashMap<String, Object> map);

    public int updateOrInsertSysFile(SysFileKind sysFileKind);
    
    /**
     * 文档分类权限分配查询
     */
    public LayuiTableData getSysFileKindUserListData(LayuiTableParam param);
    
    /**
     * 删除当前页人员所有的已分配数据，插入新保存的用户(若干条)
     */
    public int saveFileKindAuthUser(SysFileKindAuth sysFileKindAuth);
    
    /**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * 已配置功能权限的默认勾选
	 */
	public List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit);
}