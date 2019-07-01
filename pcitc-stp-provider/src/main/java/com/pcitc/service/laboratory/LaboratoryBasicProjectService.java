package com.pcitc.service.laboratory;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratoryBasicProject;
import com.pcitc.base.laboratory.LaboratoryBasicProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: laboratory_basic_project - 实验室-基础性前瞻性研究项目</p>
 *
 * @since 2019-07-01 09:12:14
 */
public interface LaboratoryBasicProjectService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LaboratoryBasicProject> findLaboratoryBasicProjectList(LaboratoryBasicProject record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertLaboratoryBasicProject(LaboratoryBasicProject record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLaboratoryBasicProjectById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LaboratoryBasicProject getLaboratoryBasicProjectInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(LaboratoryBasicProjectExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(LaboratoryBasicProjectExample example);

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
    int insert(LaboratoryBasicProject record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    LaboratoryBasicProject insertObject(LaboratoryBasicProject record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(LaboratoryBasicProject record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<LaboratoryBasicProject> selectByExample(LaboratoryBasicProjectExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LaboratoryBasicProject selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LaboratoryBasicProject record, @Param("example") LaboratoryBasicProjectExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LaboratoryBasicProject record, @Param("example") LaboratoryBasicProjectExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LaboratoryBasicProject record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(LaboratoryBasicProject record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryBasicProject(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findLaboratoryBasicProjectByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryBasicProjectReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}