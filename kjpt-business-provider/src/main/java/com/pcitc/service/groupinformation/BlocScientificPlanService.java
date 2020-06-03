package com.pcitc.service.groupinformation;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.scientificplan.SciencePlan;

import java.util.List;
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

    /**
     * 查询计算机软件项目
     * @param paramMap
     * @return
     */
    List queryNoPage(Map paramMap);


    public int insertBatch(List<BlocScientificPlan> list)throws Exception;

}
