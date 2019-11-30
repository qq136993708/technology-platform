package com.pcitc.service.groupinformation;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.groupinformation.BlocScientificPlan;

import java.util.Map;

public interface BlocScientificPlanService {

    /**
     * 根据主键获取一个平台项目的信息
     */
    BlocScientificPlan load(String id);

    /**
     * 保存集团信息的科技规划
     */
    BlocScientificPlan save(BlocScientificPlan blocScientificPlan);

    /**
     * 查询集团信息的科技规划列表
     */
    PageInfo query(Map paramMap);

    /**
     * 逻辑删除
     */
    Integer delete(String id);

}
