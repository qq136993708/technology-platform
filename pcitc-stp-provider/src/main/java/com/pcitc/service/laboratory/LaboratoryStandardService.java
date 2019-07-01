package com.pcitc.service.laboratory;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratoryStandard;
import com.pcitc.base.laboratory.LaboratoryStandardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: laboratory_standard - 实验室-标准情况</p>
 *
 * @since 2019-07-01 09:14:31
 */
public interface LaboratoryStandardService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LaboratoryStandard> findLaboratoryStandardList(LaboratoryStandard record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertLaboratoryStandard(LaboratoryStandard record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLaboratoryStandardById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LaboratoryStandard getLaboratoryStandardInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(LaboratoryStandardExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(LaboratoryStandardExample example);

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
    int insert(LaboratoryStandard record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    LaboratoryStandard insertObject(LaboratoryStandard record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(LaboratoryStandard record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<LaboratoryStandard> selectByExample(LaboratoryStandardExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LaboratoryStandard selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LaboratoryStandard record, @Param("example") LaboratoryStandardExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LaboratoryStandard record, @Param("example") LaboratoryStandardExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LaboratoryStandard record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(LaboratoryStandard record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryStandard(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findLaboratoryStandardByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryStandardReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}