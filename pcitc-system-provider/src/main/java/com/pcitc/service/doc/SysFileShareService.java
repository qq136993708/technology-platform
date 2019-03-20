package com.pcitc.service.doc;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileShare;
import com.pcitc.base.doc.SysFileShareExample;
import com.pcitc.base.system.SysUnit;

/**
 * <p>接口类</p>
 * <p>Table: sys_file_share - 文件分享信息</p>
 *
 * @since 2018-06-19 03:58:11
 */
public interface SysFileShareService {

    List<SysFileShare> findSysFileShareList(SysFileShare record) throws Exception;


    int updateOrInsertSysFileShare(SysFileShare record) throws Exception;

    int deleteSysFileShareById(String id) throws Exception;


    SysFileShare getSysFileShareInfo(String id) throws Exception;


    long countByExample(SysFileShareExample example);

    int deleteByExample(SysFileShareExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFileShare record);

    SysFileShare insertObject(SysFileShare record);

    int insertSelective(SysFileShare record);

    List<SysFileShare> selectByExample(SysFileShareExample example);

    SysFileShare selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFileShare record, @Param("example") SysFileShareExample example);

    int updateByExample(@Param("record") SysFileShare record, @Param("example") SysFileShareExample example);

    int updateByPrimaryKeySelective(SysFileShare record);

    int updateByPrimaryKey(SysFileShare record);

    /**
     * 删除菜单
     *
     * @param sysMenuId
     * @return
     */
    DataOperationStatusEnum deleteSysFileShare(java.io.Serializable sysMenuId);

    /**
     * @param jsonStr 分页组件传过来的参数列表
     * @return
     */
    PageInfo<SysFileShare> findSysFileShareByPage(String jsonStr);

    int deleteSysFileShareReal(String menuId);

    List<TreeNode> selectObjectByTree();

    public  void saveSysFileShare(SysFileShare sysFileShare);

    /**
     * 根据文件ID删除数据
     * @param strFileId
     */
    public void deleteObjByParam(String strFileId);
    
    /**
     * 替换sysFIle，保存进历史版本
     * @param versionUUID
     * @return
     */
    public int replaceSysFile(String versionUUID);
    
    /**
	 * 历史版本文档下载
	 */
	public void downloadFiles(@PathVariable("versionUUID") String versionUUID, HttpServletRequest request, HttpServletResponse response) throws IOException;
	
    /**
	 * 历史版本文档下载
	 */
	public void downloadFile(@PathVariable("versionUUID") String versionUUID, HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * 包含文件已分享信息
	 */
	public List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit);

}