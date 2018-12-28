package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.expert.ZjkExpertExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkExpertMapper {
    long countByExample(ZjkExpertExample example);

    int deleteByExample(ZjkExpertExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkExpert record);

    int insertSelective(ZjkExpert record);

    List<ZjkExpert> selectByExample(ZjkExpertExample example);

    ZjkExpert selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkExpert record, @Param("example") ZjkExpertExample example);

    int updateByExample(@Param("record") ZjkExpert record, @Param("example") ZjkExpertExample example);

    int updateByPrimaryKeySelective(ZjkExpert record);

    int updateByPrimaryKey(ZjkExpert record);

    int updateByPrimaryKeyWithBLOBs(ZjkExpert record);

    List<ZjkExpert> findZjkExpertByPage(Map<String, Object> map);

    List<ZjkExpert> findZjkExpertList(ZjkExpert record);

    List<Map<String,Object>> listSqlResult(Map<String,Object> map);

}