package com.pcitc.mapper.search;

import com.pcitc.base.search.ZjkSearchLog;
import com.pcitc.base.search.ZjkSearchLogExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkSearchLogMapper {
    long countByExample(ZjkSearchLogExample example);

    int deleteByExample(ZjkSearchLogExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkSearchLog record);

    int insertSelective(ZjkSearchLog record);

    List<ZjkSearchLog> selectByExample(ZjkSearchLogExample example);

    List<ZjkSearchLog> getListTopHost();

    ZjkSearchLog selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkSearchLog record, @Param("example") ZjkSearchLogExample example);

    int updateByExample(@Param("record") ZjkSearchLog record, @Param("example") ZjkSearchLogExample example);

    int updateByPrimaryKeySelective(ZjkSearchLog record);

    int updateByPrimaryKey(ZjkSearchLog record);

    int updateByPrimaryKeyWithBLOBs(ZjkSearchLog record);

    List<ZjkSearchLog> findZjkSearchLogByPage(Map<String, Object> map);

    List<ZjkSearchLog> findZjkSearchLogList(ZjkSearchLog record);

}