package com.pcitc.service.system;

import java.util.Date;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.IndexOutProjectInfo;
import com.pcitc.base.system.IndexOutProjectInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: index_out_project_info - 首页-科研项目</p>
 *
 * @since 2019-05-22 03:38:18
 */
public interface IndexOutProjectInfoService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<IndexOutProjectInfo> findIndexOutProjectInfoList(IndexOutProjectInfo record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertIndexOutProjectInfo(IndexOutProjectInfo record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteIndexOutProjectInfoById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    IndexOutProjectInfo getIndexOutProjectInfoInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(IndexOutProjectInfoExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(IndexOutProjectInfoExample example);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入信息
     *
     * @param record
     * @return
     */
    int insert(IndexOutProjectInfo record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    IndexOutProjectInfo insertObject(IndexOutProjectInfo record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(IndexOutProjectInfo record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<IndexOutProjectInfo> selectByExample(IndexOutProjectInfoExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    IndexOutProjectInfo selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") IndexOutProjectInfo record, @Param("example") IndexOutProjectInfoExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") IndexOutProjectInfo record, @Param("example") IndexOutProjectInfoExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(IndexOutProjectInfo record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(IndexOutProjectInfo record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteIndexOutProjectInfo(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findIndexOutProjectInfoByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteIndexOutProjectInfoReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    void selectTfcToIndexProjectInfo();

}