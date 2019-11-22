package com.pcitc.service.scientificplan;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.scientificplan.SciencePlan;

import java.util.Map;

public interface SciencePlanService {

    /**
     * 根据主键获取一个平台的信息
     */
    SciencePlan load(String id);

    /**
     * 保存科技规划
     * @param sciencePlan
     * @return
     */
    SciencePlan save(SciencePlan sciencePlan);

    /**
     * 删除科技规划
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 查询科技规划
     * @param paramMap
     * @return
     */
    PageInfo query(Map paramMap);


}
