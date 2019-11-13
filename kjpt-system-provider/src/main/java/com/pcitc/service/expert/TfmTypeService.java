package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.TfmType;
import com.pcitc.base.expert.TfmTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: tfm_type - </p>
 *
 * @since 2019-01-16 02:47:25
 */
public interface TfmTypeService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<TfmType> findTfmTypeList(TfmType record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertTfmType(TfmType record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteTfmTypeById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    TfmType getTfmTypeInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(TfmTypeExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(TfmTypeExample example);

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
    int insert(TfmType record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    TfmType insertObject(TfmType record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(TfmType record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<TfmType> selectByExample(TfmTypeExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    TfmType selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") TfmType record, @Param("example") TfmTypeExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") TfmType record, @Param("example") TfmTypeExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TfmType record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(TfmType record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteTfmType(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findTfmTypeByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteTfmTypeReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}