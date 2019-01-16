package com.pcitc.mapper.expert;

import com.pcitc.base.expert.TfmType;
import com.pcitc.base.expert.TfmTypeExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TfmTypeMapper {
    long countByExample(TfmTypeExample example);

    int deleteByExample(TfmTypeExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(TfmType record);

    int insertSelective(TfmType record);

    List<TfmType> selectByExample(TfmTypeExample example);

    TfmType selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") TfmType record, @Param("example") TfmTypeExample example);

    int updateByExample(@Param("record") TfmType record, @Param("example") TfmTypeExample example);

    int updateByPrimaryKeySelective(TfmType record);

    int updateByPrimaryKey(TfmType record);

    int updateByPrimaryKeyWithBLOBs(TfmType record);

    List<TfmType> findTfmTypeByPage(Map<String, Object> map);

    List<TfmType> findTfmTypeList(TfmType record);

}