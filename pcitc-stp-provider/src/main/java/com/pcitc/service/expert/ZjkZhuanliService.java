package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkZhuanli;
import com.pcitc.base.expert.ZjkZhuanliExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: zjk_zhuanli - 专家-专利信息</p>
 *
 * @since 2018-12-08 04:10:52
 */
public interface ZjkZhuanliService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<ZjkZhuanli> findZjkZhuanliList(ZjkZhuanli record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertZjkZhuanli(ZjkZhuanli record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteZjkZhuanliById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ZjkZhuanli getZjkZhuanliInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(ZjkZhuanliExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(ZjkZhuanliExample example);

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
    int insert(ZjkZhuanli record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    ZjkZhuanli insertObject(ZjkZhuanli record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(ZjkZhuanli record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<ZjkZhuanli> selectByExample(ZjkZhuanliExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ZjkZhuanli selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") ZjkZhuanli record, @Param("example") ZjkZhuanliExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") ZjkZhuanli record, @Param("example") ZjkZhuanliExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ZjkZhuanli record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ZjkZhuanli record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteZjkZhuanli(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findZjkZhuanliByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteZjkZhuanliReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}