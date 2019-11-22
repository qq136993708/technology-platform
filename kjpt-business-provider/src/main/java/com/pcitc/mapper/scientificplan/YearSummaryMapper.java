package com.pcitc.mapper.scientificplan;

import com.pcitc.base.scientificplan.YearSummary;

import java.util.List;
import java.util.Map;

public interface YearSummaryMapper {


    /**
     * 根据主键获取一个平台的信息
     * @param id
     */
    YearSummary load(String id);

    /**
     * 保存年度总结
     * @param yearSummary
     * @return
     */
    int add(YearSummary yearSummary);

    /**
     * 删除年度总结
     * @param id
     * @return
     */
     int delete(String id );

    /**
     * 修改年度总结
     * @param yearSummary
     * @return
     */
     int update(YearSummary yearSummary);

    /**
     * 查询年度总结列表
     * @param paramMap
     * @return
     */
     List<YearSummary> query(Map paramMap);
}
