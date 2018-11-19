package com.pcitc.service.plan;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.plan.PlanBaseRecord;
import com.pcitc.base.plan.PlanBaseRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: plan_base_record - </p>
 *
 * @since 2018-11-12 10:15:05
 */
public interface PlanBaseRecordService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<PlanBaseRecord> findPlanBaseRecordList(PlanBaseRecord record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertPlanBaseRecord(PlanBaseRecord record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deletePlanBaseRecordById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    PlanBaseRecord getPlanBaseRecordInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(PlanBaseRecordExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(PlanBaseRecordExample example);

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
    int insert(PlanBaseRecord record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    PlanBaseRecord insertObject(PlanBaseRecord record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(PlanBaseRecord record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<PlanBaseRecord> selectByExample(PlanBaseRecordExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    PlanBaseRecord selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") PlanBaseRecord record, @Param("example") PlanBaseRecordExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") PlanBaseRecord record, @Param("example") PlanBaseRecordExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PlanBaseRecord record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(PlanBaseRecord record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deletePlanBaseRecord(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findPlanBaseRecordByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deletePlanBaseRecordReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}