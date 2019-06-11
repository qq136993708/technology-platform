package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectAccept;
import com.pcitc.base.stp.IntlProject.IntlProjectAcceptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectAcceptMapper {
    long countByExample(IntlProjectAcceptExample example);

    int deleteByExample(IntlProjectAcceptExample example);

    int deleteByPrimaryKey(String acceptId);

    int insert(IntlProjectAccept record);

    int insertSelective(IntlProjectAccept record);

    List<IntlProjectAccept> selectByExample(IntlProjectAcceptExample example);

    IntlProjectAccept selectByPrimaryKey(String acceptId);

    int updateByExampleSelective(@Param("record") IntlProjectAccept record, @Param("example") IntlProjectAcceptExample example);

    int updateByExample(@Param("record") IntlProjectAccept record, @Param("example") IntlProjectAcceptExample example);

    int updateByPrimaryKeySelective(IntlProjectAccept record);

    int updateByPrimaryKey(IntlProjectAccept record);
}