package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectContract;
import com.pcitc.base.stp.IntlProject.IntlProjectContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectContractMapper {
    long countByExample(IntlProjectContractExample example);

    int deleteByExample(IntlProjectContractExample example);

    int deleteByPrimaryKey(String contractId);

    int insert(IntlProjectContract record);

    int insertSelective(IntlProjectContract record);

    List<IntlProjectContract> selectByExample(IntlProjectContractExample example);

    IntlProjectContract selectByPrimaryKey(String contractId);

    int updateByExampleSelective(@Param("record") IntlProjectContract record, @Param("example") IntlProjectContractExample example);

    int updateByExample(@Param("record") IntlProjectContract record, @Param("example") IntlProjectContractExample example);

    int updateByPrimaryKeySelective(IntlProjectContract record);

    int updateByPrimaryKey(IntlProjectContract record);
}