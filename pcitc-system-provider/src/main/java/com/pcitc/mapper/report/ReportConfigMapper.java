package com.pcitc.mapper.report;

import com.pcitc.base.report.ReportConfig;
import com.pcitc.base.report.ReportConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReportConfigMapper {
    long countByExample(ReportConfigExample example);

    int deleteByExample(ReportConfigExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ReportConfig record);

    int insertSelective(ReportConfig record);

    List<ReportConfig> selectByExample(ReportConfigExample example);

    ReportConfig selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ReportConfig record, @Param("example") ReportConfigExample example);

    int updateByExample(@Param("record") ReportConfig record, @Param("example") ReportConfigExample example);

    int updateByPrimaryKeySelective(ReportConfig record);

    int updateByPrimaryKey(ReportConfig record);

    int updateByPrimaryKeyWithBLOBs(ReportConfig record);

    List<ReportConfig> findReportConfigByPage(Map<String, Object> map);

    List<ReportConfig> findReportConfigList(ReportConfig record);

}