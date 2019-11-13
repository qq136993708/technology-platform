package com.pcitc.mapper.report;

import com.pcitc.base.common.TreeNode;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.base.report.ReportColumnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReportColumnMapper {
    long countByExample(ReportColumnExample example);

    int deleteByExample(ReportColumnExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ReportColumn record);

    int insertSelective(ReportColumn record);

    List<ReportColumn> selectByExample(ReportColumnExample example);

    ReportColumn selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ReportColumn record, @Param("example") ReportColumnExample example);

    int updateByExample(@Param("record") ReportColumn record, @Param("example") ReportColumnExample example);

    int updateByPrimaryKeySelective(ReportColumn record);

    int updateByPrimaryKey(ReportColumn record);

    int updateByPrimaryKeyWithBLOBs(ReportColumn record);

    List<ReportColumn> findReportColumnByPage(Map<String, Object> map);

    List<ReportColumn> findReportColumnList(ReportColumn record);

    List<TreeNode> selectTrees();

}