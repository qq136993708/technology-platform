package com.pcitc.service.laboratory;

import com.pcitc.base.common.LayuiTableData;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.laboratory.LaboratoryAchievements;
import com.pcitc.base.laboratory.LaboratoryAchievementsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: laboratory_achievements - 实验室-研究成果</p>
 *
 * @since 2019-07-01 09:11:59
 */
public interface LaboratoryAchievementsService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<LaboratoryAchievements> findLaboratoryAchievementsList(LaboratoryAchievements record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertLaboratoryAchievements(LaboratoryAchievements record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteLaboratoryAchievementsById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LaboratoryAchievements getLaboratoryAchievementsInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(LaboratoryAchievementsExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(LaboratoryAchievementsExample example);

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
    int insert(LaboratoryAchievements record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    LaboratoryAchievements insertObject(LaboratoryAchievements record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(LaboratoryAchievements record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<LaboratoryAchievements> selectByExample(LaboratoryAchievementsExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LaboratoryAchievements selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LaboratoryAchievements record, @Param("example") LaboratoryAchievementsExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LaboratoryAchievements record, @Param("example") LaboratoryAchievementsExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LaboratoryAchievements record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(LaboratoryAchievements record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryAchievements(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findLaboratoryAchievementsByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deleteLaboratoryAchievementsReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}