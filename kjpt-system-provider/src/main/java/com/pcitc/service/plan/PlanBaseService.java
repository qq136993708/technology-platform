package com.pcitc.service.plan;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseExample;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: plan_base - 工程签证申请</p>
 *
 * @since 2018-11-12 10:14:54
 */
public interface PlanBaseService {

    /**
     * 判空-信息
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<PlanBase> findPlanBaseList(PlanBase record) throws Exception;

    /**
     * 删除
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateOrInsertPlanBase(PlanBase record) throws Exception;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deletePlanBaseById(String id) throws Exception;

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    PlanBase getPlanBaseInfo(String id) throws Exception;

    /**
     * 查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(PlanBaseExample example);

    /**
     * 根据example条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(PlanBaseExample example);

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
    int insert(PlanBase record);

    /**
     * 插入信息,返回对象
     *
     * @param record
     * @return
     */
    PlanBase insertObject(PlanBase record);

    /**
     * 判空-插入信息
     *
     * @param record
     * @return
     */
    int insertSelective(PlanBase record);

    /**
     * 根据example条件查询
     *
     * @param example
     * @return
     */
    List<PlanBase> selectByExample(PlanBaseExample example);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    PlanBase selectByPrimaryKey(String id);

    /**
     * 根据example条件-判空更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") PlanBase record, @Param("example") PlanBaseExample example);

    /**
     * 根据example条件,更新所有
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") PlanBase record, @Param("example") PlanBaseExample example);

    /**
     * 根据主键判空-更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PlanBase record);

    /**
     * 根据主键更新所有
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(PlanBase record);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Integer deletePlanBase(java.io.Serializable id);

    /**
     * @param param 分页查询
     * @return
     */
    LayuiTableData findPlanBaseByPage(LayuiTableParam param);

    /**
     * 真删除
     *
     * @param id
     * @return
     */
    Integer deletePlanBaseReal(String id);

    /**
     * 查询树
     *
     * @return
     */
    List<TreeNode> selectObjectByTree();

    /**
     * 首页查询当前登录用户分配给其他人的任务列表
     * @param jsonObject
     * @return
     */
    List<PlanBase> selectSonPlanBasesByCreateUserId(JSONObject jsonObject);

    public void importFileStandard(JSONObject jsonObject);
    public JSONObject importFileTfc(JSONObject jsonObject);
    
    /**
     * 统计首页中上周、本周的工作任务情况 
     */
    public HashMap<String, String> getWorkOrderInfoForStat(HashMap<String, String> map);
}