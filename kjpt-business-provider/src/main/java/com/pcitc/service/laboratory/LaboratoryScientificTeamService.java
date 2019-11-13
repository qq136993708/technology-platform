package com.pcitc.service.laboratory;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratoryScientificTeam;
import com.pcitc.base.laboratory.LaboratoryScientificTeamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: laboratory_scientific_team - 实验室-科研团队</p>
 *
 * @since 2019-07-01 09:14:00
 */
public interface LaboratoryScientificTeamService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LaboratoryScientificTeam> findLaboratoryScientificTeamList(LaboratoryScientificTeam record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertLaboratoryScientificTeam(LaboratoryScientificTeam record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLaboratoryScientificTeamById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LaboratoryScientificTeam getLaboratoryScientificTeamInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(LaboratoryScientificTeamExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(LaboratoryScientificTeamExample example);

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
    int insert(LaboratoryScientificTeam record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    LaboratoryScientificTeam insertObject(LaboratoryScientificTeam record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(LaboratoryScientificTeam record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<LaboratoryScientificTeam> selectByExample(LaboratoryScientificTeamExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LaboratoryScientificTeam selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LaboratoryScientificTeam record, @Param("example") LaboratoryScientificTeamExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LaboratoryScientificTeam record, @Param("example") LaboratoryScientificTeamExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LaboratoryScientificTeam record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(LaboratoryScientificTeam record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryScientificTeam(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findLaboratoryScientificTeamByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryScientificTeamReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}