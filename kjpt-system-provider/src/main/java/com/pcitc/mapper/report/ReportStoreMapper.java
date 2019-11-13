package com.pcitc.mapper.report;

import com.pcitc.base.system.ReportStore;
import com.pcitc.base.system.ReportStoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReportStoreMapper {
    long countByExample(ReportStoreExample example);

    int deleteByExample(ReportStoreExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ReportStore record);

    int insertSelective(ReportStore record);

    List<ReportStore> selectByExample(ReportStoreExample example);

    ReportStore selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ReportStore record, @Param("example") ReportStoreExample example);

    int updateByExample(@Param("record") ReportStore record, @Param("example") ReportStoreExample example);

    int updateByPrimaryKeySelective(ReportStore record);

    int updateByPrimaryKey(ReportStore record);

    int updateByPrimaryKeyWithBLOBs(ReportStore record);

    List<ReportStore> findReportStoreByPage(Map<String, Object> map);

    List<ReportStore> findReportStoreList(ReportStore record);

}