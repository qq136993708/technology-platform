package com.pcitc.mapper.system;

import com.pcitc.base.system.IndexOutAppraisal;
import com.pcitc.base.system.IndexOutAppraisalExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IndexOutAppraisalMapper {
    long countByExample(IndexOutAppraisalExample example);

    int deleteByExample(IndexOutAppraisalExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(IndexOutAppraisal record);

    int insertSelective(IndexOutAppraisal record);

    List<IndexOutAppraisal> selectByExample(IndexOutAppraisalExample example);

    IndexOutAppraisal selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") IndexOutAppraisal record, @Param("example") IndexOutAppraisalExample example);

    int updateByExample(@Param("record") IndexOutAppraisal record, @Param("example") IndexOutAppraisalExample example);

    int updateByPrimaryKeySelective(IndexOutAppraisal record);

    int updateByPrimaryKey(IndexOutAppraisal record);

    int updateByPrimaryKeyWithBLOBs(IndexOutAppraisal record);

    List<IndexOutAppraisal> findIndexOutAppraisalByPage(Map<String, Object> map);

    List<IndexOutAppraisal> findIndexOutAppraisalList(IndexOutAppraisal record);

}