package com.pcitc.mapper.system;

import com.pcitc.base.system.IndexOutProjectInfo;
import com.pcitc.base.system.IndexOutProjectInfoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IndexOutProjectInfoMapper {
    long countByExample(IndexOutProjectInfoExample example);

    int deleteByExample(IndexOutProjectInfoExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(IndexOutProjectInfo record);

    int insertSelective(IndexOutProjectInfo record);

    List<IndexOutProjectInfo> selectByExample(IndexOutProjectInfoExample example);

    IndexOutProjectInfo selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") IndexOutProjectInfo record, @Param("example") IndexOutProjectInfoExample example);

    int updateByExample(@Param("record") IndexOutProjectInfo record, @Param("example") IndexOutProjectInfoExample example);

    int updateByPrimaryKeySelective(IndexOutProjectInfo record);

    int updateByPrimaryKey(IndexOutProjectInfo record);

    int updateByPrimaryKeyWithBLOBs(IndexOutProjectInfo record);

    List<IndexOutProjectInfo> findIndexOutProjectInfoByPage(Map<String, Object> map);

    List<IndexOutProjectInfo> findIndexOutProjectInfoList(IndexOutProjectInfo record);

}