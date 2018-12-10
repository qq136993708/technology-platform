package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkZhuanli;
import com.pcitc.base.expert.ZjkZhuanliExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkZhuanliMapper {
    long countByExample(ZjkZhuanliExample example);

    int deleteByExample(ZjkZhuanliExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkZhuanli record);

    int insertSelective(ZjkZhuanli record);

    List<ZjkZhuanli> selectByExample(ZjkZhuanliExample example);

    ZjkZhuanli selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkZhuanli record, @Param("example") ZjkZhuanliExample example);

    int updateByExample(@Param("record") ZjkZhuanli record, @Param("example") ZjkZhuanliExample example);

    int updateByPrimaryKeySelective(ZjkZhuanli record);

    int updateByPrimaryKey(ZjkZhuanli record);

    int updateByPrimaryKeyWithBLOBs(ZjkZhuanli record);

    List<ZjkZhuanli> findZjkZhuanliByPage(Map<String, Object> map);

    List<ZjkZhuanli> findZjkZhuanliList(ZjkZhuanli record);

}