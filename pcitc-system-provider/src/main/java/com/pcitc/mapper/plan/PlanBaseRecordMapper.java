package com.pcitc.mapper.plan;

import com.pcitc.base.plan.PlanBaseRecord;
import com.pcitc.base.plan.PlanBaseRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PlanBaseRecordMapper {
    long countByExample(PlanBaseRecordExample example);

    int deleteByExample(PlanBaseRecordExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(PlanBaseRecord record);

    int insertSelective(PlanBaseRecord record);

    List<PlanBaseRecord> selectByExample(PlanBaseRecordExample example);

    PlanBaseRecord selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") PlanBaseRecord record, @Param("example") PlanBaseRecordExample example);

    int updateByExample(@Param("record") PlanBaseRecord record, @Param("example") PlanBaseRecordExample example);

    int updateByPrimaryKeySelective(PlanBaseRecord record);

    int updateByPrimaryKey(PlanBaseRecord record);

    int updateByPrimaryKeyWithBLOBs(PlanBaseRecord record);

    List<PlanBaseRecord> findPlanBaseRecordByPage(Map<String, Object> map);

    List<PlanBaseRecord> findPlanBaseRecordList(PlanBaseRecord record);

}