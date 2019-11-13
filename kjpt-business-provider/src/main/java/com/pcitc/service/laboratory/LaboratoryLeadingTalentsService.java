package com.pcitc.service.laboratory;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratoryLeadingTalents;
import com.pcitc.base.laboratory.LaboratoryLeadingTalentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: laboratory_leading_talents - 实验室-领军人才</p>
 *
 * @since 2019-07-01 09:12:35
 */
public interface LaboratoryLeadingTalentsService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LaboratoryLeadingTalents> findLaboratoryLeadingTalentsList(LaboratoryLeadingTalents record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertLaboratoryLeadingTalents(LaboratoryLeadingTalents record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLaboratoryLeadingTalentsById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LaboratoryLeadingTalents getLaboratoryLeadingTalentsInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(LaboratoryLeadingTalentsExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(LaboratoryLeadingTalentsExample example);

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
    int insert(LaboratoryLeadingTalents record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    LaboratoryLeadingTalents insertObject(LaboratoryLeadingTalents record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(LaboratoryLeadingTalents record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<LaboratoryLeadingTalents> selectByExample(LaboratoryLeadingTalentsExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LaboratoryLeadingTalents selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LaboratoryLeadingTalents record, @Param("example") LaboratoryLeadingTalentsExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LaboratoryLeadingTalents record, @Param("example") LaboratoryLeadingTalentsExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LaboratoryLeadingTalents record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(LaboratoryLeadingTalents record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryLeadingTalents(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findLaboratoryLeadingTalentsByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryLeadingTalentsReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}