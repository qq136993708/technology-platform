package com.pcitc.mapper.other;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    /**
     * 报表查询
     *
     * @param map
     * @return
     */
    List getReportList(Map<String, Object> map);

    List getReportListNew(Map<String, Object> map);

    List selectHanaModelColumn(Map<String, Object> map);

    List selectCatalog(Map<String, Object> map);

    Long selectCatalogCount(Map<String, Object> map);

    List selectCubeName(Map<String, Object> map);

    Long selectCubeNameCount(Map<String, Object> map);

    List getReportListStp(Map<String, Object> map);

    List getReportListStpCount(Map<String, Object> map);

    List getReportListStpSum(Map<String, Object> map);

    List getReportListStpDb(Map<String, Object> map);
    List<Map<String, Object>> getSql(Map<String, Object> map);
}