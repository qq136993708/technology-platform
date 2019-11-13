package com.pcitc.service.laboratory;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratorySoftWork;
import com.pcitc.base.laboratory.LaboratorySoftWorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: laboratory_soft_work - 实验室-知识产权-软著</p>
 *
 * @since 2019-07-01 09:14:14
 */
public interface LaboratorySoftWorkService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LaboratorySoftWork> findLaboratorySoftWorkList(LaboratorySoftWork record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertLaboratorySoftWork(LaboratorySoftWork record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLaboratorySoftWorkById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LaboratorySoftWork getLaboratorySoftWorkInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(LaboratorySoftWorkExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(LaboratorySoftWorkExample example);

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
    int insert(LaboratorySoftWork record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    LaboratorySoftWork insertObject(LaboratorySoftWork record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(LaboratorySoftWork record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<LaboratorySoftWork> selectByExample(LaboratorySoftWorkExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LaboratorySoftWork selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LaboratorySoftWork record, @Param("example") LaboratorySoftWorkExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LaboratorySoftWork record, @Param("example") LaboratorySoftWorkExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LaboratorySoftWork record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(LaboratorySoftWork record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteLaboratorySoftWork(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findLaboratorySoftWorkByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteLaboratorySoftWorkReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}