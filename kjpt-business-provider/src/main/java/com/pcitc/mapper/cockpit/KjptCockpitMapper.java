package com.pcitc.mapper.cockpit;

import java.util.List;
import java.util.Map;

public interface KjptCockpitMapper {

    /**
     * 知识产权-专利数量按专利类型占比分析
     */
    List<Map> knowledgeNumOrType(Map<String, Object> param);


    /**
     * 知识产权-专利数量年度趋势分析
     */
    List<Map> knowledgeNumYearTrend(Map<String, Object> param);


    /**
     * 知识产权-专利数量按单位同比分析
     */
    List<Map> knowledgeNumOrUnit(Map<String, Object> param);

    /**
     * 科研平台-4大类别
     */
    List<Map> numScientificType(Map<String, Object> param);

    /**
     * 科研平台-科研平台数量按技术领域
     */
    List<Map> numScientificTechnology(Map<String, Object> param);
}
