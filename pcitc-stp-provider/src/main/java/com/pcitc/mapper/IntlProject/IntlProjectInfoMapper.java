package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.stp.IntlProject.IntlProjectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectInfoMapper {
    long countByExample(IntlProjectInfoExample example);

    int deleteByExample(IntlProjectInfoExample example);

    int deleteByPrimaryKey(String projectId);

    int insert(IntlProjectInfo record);

    int insertSelective(IntlProjectInfo record);

    List<IntlProjectInfo> selectByExampleWithBLOBs(IntlProjectInfoExample example);

    List<IntlProjectInfo> selectByExample(IntlProjectInfoExample example);

    IntlProjectInfo selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") IntlProjectInfo record, @Param("example") IntlProjectInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") IntlProjectInfo record, @Param("example") IntlProjectInfoExample example);

    int updateByExample(@Param("record") IntlProjectInfo record, @Param("example") IntlProjectInfoExample example);

    int updateByPrimaryKeySelective(IntlProjectInfo record);

    int updateByPrimaryKeyWithBLOBs(IntlProjectInfo record);

    int updateByPrimaryKey(IntlProjectInfo record);
}