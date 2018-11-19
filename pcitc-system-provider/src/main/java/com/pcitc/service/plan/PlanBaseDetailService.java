package com.pcitc.service.plan;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.plan.PlanBaseDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口类</p>
 * <p>Table: plan_base_detail - 工程签证申请</p>
 *
 * @since 2018-11-12 10:15:00
 */
public interface PlanBaseDetailService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<PlanBaseDetail> findPlanBaseDetailList(PlanBaseDetail record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertPlanBaseDetail(PlanBaseDetail record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deletePlanBaseDetailById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    PlanBaseDetail getPlanBaseDetailInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(PlanBaseDetailExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(PlanBaseDetailExample example);

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
    int insert(PlanBaseDetail record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    PlanBaseDetail insertObject(PlanBaseDetail record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(PlanBaseDetail record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<PlanBaseDetail> selectByExample(PlanBaseDetailExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    PlanBaseDetail selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") PlanBaseDetail record, @Param("example") PlanBaseDetailExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") PlanBaseDetail record, @Param("example") PlanBaseDetailExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PlanBaseDetail record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(PlanBaseDetail record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deletePlanBaseDetail(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findPlanBaseDetailByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deletePlanBaseDetailReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();
}