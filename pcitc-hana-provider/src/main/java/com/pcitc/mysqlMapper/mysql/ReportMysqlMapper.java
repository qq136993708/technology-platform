package com.pcitc.mysqlMapper.mysql;

import com.pcitc.base.report.ReportColumn;
import com.pcitc.base.report.ReportColumnExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReportMysqlMapper {

    List getSql(Map<String, Object> map);

    List getReportListStpDb(Map<String, Object> map);

    List selectMysqlModelColumn(Map<String, Object> map);

    List getReportListStpDbAll(Map<String, Object> map);

    String getReportListStpMysqlCount(Map<String, Object> map);
}