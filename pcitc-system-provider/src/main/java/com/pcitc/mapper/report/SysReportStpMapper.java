package com.pcitc.mapper.report;

import com.pcitc.base.report.SysReportStp;
import com.pcitc.base.report.SysReportStpExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysReportStpMapper {
    long countByExample(SysReportStpExample example);

    int deleteByExample(SysReportStpExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysReportStp record);

    int insertSelective(SysReportStp record);

    List<SysReportStp> selectByExample(SysReportStpExample example);

    SysReportStp selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysReportStp record, @Param("example") SysReportStpExample example);

    int updateByExample(@Param("record") SysReportStp record, @Param("example") SysReportStpExample example);

    int updateByPrimaryKeySelective(SysReportStp record);

    int updateByPrimaryKey(SysReportStp record);

    int updateByPrimaryKeyWithBLOBs(SysReportStp record);

    List<SysReportStp> findSysReportStpByPage(Map<String, Object> map);

    List<SysReportStp> findSysReportStpList(SysReportStp record);

}