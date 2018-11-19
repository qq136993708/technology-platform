package com.pcitc.mapper.plan;

import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.plan.PlanBaseDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PlanBaseDetailMapper {
    long countByExample(PlanBaseDetailExample example);

    int deleteByExample(PlanBaseDetailExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(PlanBaseDetail record);

    int insertSelective(PlanBaseDetail record);

    List<PlanBaseDetail> selectByExample(PlanBaseDetailExample example);

    PlanBaseDetail selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") PlanBaseDetail record, @Param("example") PlanBaseDetailExample example);

    int updateByExample(@Param("record") PlanBaseDetail record, @Param("example") PlanBaseDetailExample example);

    int updateByPrimaryKeySelective(PlanBaseDetail record);

    int updateByPrimaryKey(PlanBaseDetail record);

    int updateByPrimaryKeyWithBLOBs(PlanBaseDetail record);

    List<PlanBaseDetail> findPlanBaseDetailByPage(Map<String, Object> map);

    List<PlanBaseDetail> findPlanBaseDetailList(PlanBaseDetail record);

    //add
    void deleteByIds(@Param("ids") List<String> ids);

    void affirmByIds(@Param("ids") List<String> ids);

    List<PlanBaseDetail> queryBotWorkOrderMatterListByPage(PlanBaseDetail vo);

    Long countByBotWorkOrderMatter(PlanBaseDetail vo);

    int submitBotWorkOrderMatter(String dataId);

    public void insertBotWorkOrderMatterBatch(List<PlanBaseDetail> list);

    List<PlanBaseDetail> queryBotWorkOrderMatterList(PlanBaseDetail vo);

    Long countByBotWorkOrderMatterById(PlanBaseDetail vo);

    int deleteByWorkOrderId(String workOrderId);

    void deleteMyByWorkOrderId(String workOrderId);

}