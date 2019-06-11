package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectResult;
import com.pcitc.base.stp.IntlProject.IntlProjectResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectResultMapper {
    long countByExample(IntlProjectResultExample example);

    int deleteByExample(IntlProjectResultExample example);

    int insert(IntlProjectResult record);

    int insertSelective(IntlProjectResult record);

    List<IntlProjectResult> selectByExample(IntlProjectResultExample example);

    int updateByExampleSelective(@Param("record") IntlProjectResult record, @Param("example") IntlProjectResultExample example);

    int updateByExample(@Param("record") IntlProjectResult record, @Param("example") IntlProjectResultExample example);
}