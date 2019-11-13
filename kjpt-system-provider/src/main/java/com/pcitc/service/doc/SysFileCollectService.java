package com.pcitc.service.doc;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileCollect;
import com.pcitc.base.doc.SysFileCollectExample;

/**
 * <p>接口类</p>
 * <p>Table: sys_file_collect - 文件收藏</p>
 *
 * @since 2018-06-22 09:00:03
 */
public interface SysFileCollectService {

    List<SysFileCollect> findSysFileCollectList(SysFileCollect record) throws Exception;


    int updateOrInsertSysFileCollect(SysFileCollect record) throws Exception;

    int deleteSysFileCollectById(String id) throws Exception;


    SysFileCollect getSysFileCollectInfo(String id) throws Exception;


    long countByExample(SysFileCollectExample example);

    int deleteByExample(SysFileCollectExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFileCollect record);

    SysFileCollect insertObject(SysFileCollect record);

    int insertSelective(SysFileCollect record);

    List<SysFileCollect> selectByExample(SysFileCollectExample example);

    SysFileCollect selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFileCollect record, @Param("example") SysFileCollectExample example);

    int updateByExample(@Param("record") SysFileCollect record, @Param("example") SysFileCollectExample example);

    int updateByPrimaryKeySelective(SysFileCollect record);

    int updateByPrimaryKey(SysFileCollect record);

    /**
     * 删除菜单
     *
     * @param sysMenuId
     * @return
     */
    DataOperationStatusEnum deleteSysFileCollect(java.io.Serializable sysMenuId);

    /**
     * @param jsonStr 分页组件传过来的参数列表
     * @return
     */
    PageInfo<SysFileCollect> findSysFileCollectByPage(String jsonStr);

    int deleteSysFileCollectReal(String menuId);

    List<TreeNode> selectObjectByTree();

    /**
     * 根据文件ID删除数据
     *
     * @param strFileId
     */
    public void deleteObjByParam(String strFileId);
    
    public int deleteSysFileCollect(HashMap<String, Object> map);
}