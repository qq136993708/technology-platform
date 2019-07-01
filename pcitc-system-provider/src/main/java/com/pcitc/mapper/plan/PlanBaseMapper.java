package com.pcitc.mapper.plan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseExample;

public interface PlanBaseMapper {
    long countByExample(PlanBaseExample example);

    int deleteByExample(PlanBaseExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(PlanBase record);

    int insertSelective(PlanBase record);

    List<PlanBase> selectByExample(PlanBaseExample example);

    PlanBase selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") PlanBase record, @Param("example") PlanBaseExample example);

    int updateByExample(@Param("record") PlanBase record, @Param("example") PlanBaseExample example);

    int updateByPrimaryKeySelective(PlanBase record);

    int updateByPrimaryKey(PlanBase record);

    int updateByPrimaryKeyWithBLOBs(PlanBase record);

    List<PlanBase> findPlanBaseByPage(Map<String, Object> map);

    List<PlanBase> findPlanBaseList(PlanBase record);

    //add
    void deleteByIds(@Param("ids") List<String> ids);

    void affirmByIds(@Param("ids") List<String> ids);

    List<PlanBase> queryBotWorkOrderListByPage(PlanBase vo);

    List<PlanBase> selectSonPlanBasesByCreateUserId(Map<String, Object> map);

    Long countByBotWorkOrder(PlanBase vo);

    int submitBotWorkOrder(String dataId);

    int updatePlanSonWorkOrderStatus(String dataId);

    List<PlanBase> queryMyBotWorkOrderListByPage(PlanBase vo);

    Long countByMyBotWorkOrder(PlanBase vo);

    void submitMyBotWorkOrder(String id);
    
    /**
     * 统计首页中上周、本周的工作任务情况 
     */
    HashMap<String, String> getWorkOrderInfoForStat(HashMap<String, String> map);
}