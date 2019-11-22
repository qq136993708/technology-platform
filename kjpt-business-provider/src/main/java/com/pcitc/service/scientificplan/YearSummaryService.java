package com.pcitc.service.scientificplan;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.scientificplan.YearSummary;

import java.util.Map;

public interface YearSummaryService {


    /**
     * 根据主键获取一个平台的信息
     */
    YearSummary load(String id);

    /**
     * 保存年度计划
     *
     * @param yearSummary
     * @return
     */
    YearSummary save(YearSummary yearSummary);

    /**
     * 删除年度计划
     *
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 查询年度计划
     *
     * @param paramMap
     * @return
     */
    PageInfo query(Map paramMap);

}
