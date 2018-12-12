package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkChengguo;
import com.pcitc.base.expert.ZjkChengguoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkChengguoMapper {
    long countByExample(ZjkChengguoExample example);

    int deleteByExample(ZjkChengguoExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkChengguo record);

    int insertSelective(ZjkChengguo record);

    List<ZjkChengguo> selectByExample(ZjkChengguoExample example);

    ZjkChengguo selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkChengguo record, @Param("example") ZjkChengguoExample example);

    int updateByExample(@Param("record") ZjkChengguo record, @Param("example") ZjkChengguoExample example);

    int updateByPrimaryKeySelective(ZjkChengguo record);

    int updateByPrimaryKey(ZjkChengguo record);

    int updateByPrimaryKeyWithBLOBs(ZjkChengguo record);

    List<ZjkChengguo> findZjkChengguoByPage(Map<String, Object> map);

    List<ZjkChengguo> findZjkChengguoList(ZjkChengguo record);

}