package com.pcitc.mapper.patent;

import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.patent.PatentInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PatentInfoMapper {
    long countByExample(PatentInfoExample example);

    int deleteByExample(PatentInfoExample example);

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(PatentInfo record);

    int insertSelective(PatentInfo record);

    List<PatentInfo> selectByExample(PatentInfoExample example);

    PatentInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PatentInfo record, @Param("example") PatentInfoExample example);

    int updateByExample(@Param("record") PatentInfo record, @Param("example") PatentInfoExample example);

    int updateByPrimaryKeySelective(PatentInfo record);

    int updateByPrimaryKey(PatentInfo record);

    List<PatentInfo> queryPatentList(Map param);

    int batchRemove(@Param("ids") String ids);
    int postTreatment(@Param("ids") String ids);

    List<Map> countByLegalStatus(Map param);

    List<Map> countByPatentType(Map param);
}