package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectReport;
import com.pcitc.base.stp.out.OutProjectReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectReportMapper {
    long countByExample(OutProjectReportExample example);

    int deleteByExample(OutProjectReportExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectReport record);

    int insertSelective(OutProjectReport record);

    List<OutProjectReport> selectByExample(OutProjectReportExample example);

    OutProjectReport selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectReport record, @Param("example") OutProjectReportExample example);

    int updateByExample(@Param("record") OutProjectReport record, @Param("example") OutProjectReportExample example);

    int updateByPrimaryKeySelective(OutProjectReport record);

    int updateByPrimaryKey(OutProjectReport record);
}