package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectRemark;
import com.pcitc.base.stp.IntlProject.IntlProjectRemarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectRemarkMapper {
    long countByExample(IntlProjectRemarkExample example);

    int deleteByExample(IntlProjectRemarkExample example);

    int insert(IntlProjectRemark record);

    int insertSelective(IntlProjectRemark record);

    List<IntlProjectRemark> selectByExample(IntlProjectRemarkExample example);

    int updateByExampleSelective(@Param("record") IntlProjectRemark record, @Param("example") IntlProjectRemarkExample example);

    int updateByExample(@Param("record") IntlProjectRemark record, @Param("example") IntlProjectRemarkExample example);
}