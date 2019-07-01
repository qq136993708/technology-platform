package com.pcitc.service.laboratory;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratoryBase;
import com.pcitc.base.laboratory.LaboratoryBaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: laboratory_base - 实验室-基本情况</p>
 *
 * @since 2019-07-01 09:11:30
 */
public interface LaboratoryBaseService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LaboratoryBase> findLaboratoryBaseList(LaboratoryBase record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertLaboratoryBase(LaboratoryBase record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLaboratoryBaseById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LaboratoryBase getLaboratoryBaseInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(LaboratoryBaseExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(LaboratoryBaseExample example);

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
    int insert(LaboratoryBase record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    LaboratoryBase insertObject(LaboratoryBase record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(LaboratoryBase record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<LaboratoryBase> selectByExample(LaboratoryBaseExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LaboratoryBase selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LaboratoryBase record, @Param("example") LaboratoryBaseExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LaboratoryBase record, @Param("example") LaboratoryBaseExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LaboratoryBase record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(LaboratoryBase record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryBase(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findLaboratoryBaseByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryBaseReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}