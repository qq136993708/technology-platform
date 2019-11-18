package com.pcitc.mapper.patent;

import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.patent.PatentInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PatentInfoMapper {
    long countByExample(PatentInfoExample example);

    int deleteByExample(PatentInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(PatentInfo record);

    PatentInfo insertSelective(PatentInfo record);

    List<PatentInfo> selectByExample(PatentInfoExample example);

    PatentInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PatentInfo record, @Param("example") PatentInfoExample example);

    int updateByExample(@Param("record") PatentInfo record, @Param("example") PatentInfoExample example);

    int updateByPrimaryKeySelective(PatentInfo record);

    PatentInfo updateByPrimaryKey(PatentInfo record);

    List<PatentInfo> queryPatentList(Map param);
}