package com.pcitc.service.system;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.system.StandardBase;
import com.pcitc.base.system.StandardBaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: standard_base - 标准化</p>
 *
 * @since 2019-05-10 03:07:51
 */
public interface StandardBaseService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<StandardBase> findStandardBaseList(StandardBase record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertStandardBase(StandardBase record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteStandardBaseById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    StandardBase getStandardBaseInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(StandardBaseExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(StandardBaseExample example);

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
    int insert(StandardBase record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    StandardBase insertObject(StandardBase record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(StandardBase record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<StandardBase> selectByExample(StandardBaseExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    StandardBase selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") StandardBase record, @Param("example") StandardBaseExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") StandardBase record, @Param("example") StandardBaseExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StandardBase record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(StandardBase record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteStandardBase(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findStandardBaseByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteStandardBaseReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}