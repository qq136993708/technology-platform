package com.pcitc.mapper.scientificplan;

import com.pcitc.base.scientificplan.SciencePlan;

import java.util.List;
import java.util.Map;

public interface SciencePlanMapper {

    /**
     * 根据主键获取一个平台的信息
     * @param id
     */
    SciencePlan load(String id);

    /**
     * 保存科技规划
     *
     * @param sciencePlan
     * @return
     */
    int add(SciencePlan sciencePlan);

    /**
     * 删除科研规划
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改科技规划
     *
     * @param sciencePlan
     * @return
     */
    int update(SciencePlan sciencePlan);

    /**
     * 查询科技规划列表
     *
     * @param paramMap
     * @return
     */
    List<SciencePlan> query(Map paramMap);

}
