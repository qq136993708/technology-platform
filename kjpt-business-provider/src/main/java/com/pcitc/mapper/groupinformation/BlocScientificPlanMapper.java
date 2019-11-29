package com.pcitc.mapper.groupinformation;

import com.pcitc.base.groupinformation.BlocScientificPlan;

import java.util.List;
import java.util.Map;

public interface BlocScientificPlanMapper {

    /**
     * 根据主键获取一个平台的信息
     */
    BlocScientificPlan load(String id);

    /**
     * 保存集团信息的科技规划
     */
    int add(BlocScientificPlan blocScientificPlan);

    /**
     * 查询集团信息的科技规划列表
     */
    List<BlocScientificPlan> query(Map paramMap);


    /**
     * 修改集团信息的科技规划
     */
    int update(BlocScientificPlan blocScientificPlan);

    /**
     * 逻辑删
     */
    int delete(String id);
}
