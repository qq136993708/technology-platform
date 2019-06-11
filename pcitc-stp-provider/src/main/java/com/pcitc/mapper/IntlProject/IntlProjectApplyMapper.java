package com.pcitc.mapper.IntlProject;

import com.pcitc.base.stp.IntlProject.IntlProjectApply;
import com.pcitc.base.stp.IntlProject.IntlProjectApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntlProjectApplyMapper {
    long countByExample(IntlProjectApplyExample example);

    int deleteByExample(IntlProjectApplyExample example);

    int deleteByPrimaryKey(String applyId);

    int insert(IntlProjectApply record);

    int insertSelective(IntlProjectApply record);

    List<IntlProjectApply> selectByExample(IntlProjectApplyExample example);

    IntlProjectApply selectByPrimaryKey(String applyId);

    int updateByExampleSelective(@Param("record") IntlProjectApply record, @Param("example") IntlProjectApplyExample example);

    int updateByExample(@Param("record") IntlProjectApply record, @Param("example") IntlProjectApplyExample example);

    int updateByPrimaryKeySelective(IntlProjectApply record);

    int updateByPrimaryKey(IntlProjectApply record);
}