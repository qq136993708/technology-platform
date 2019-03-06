package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkEvaluate;
import com.pcitc.base.expert.ZjkEvaluateExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkEvaluateMapper {
    long countByExample(ZjkEvaluateExample example);

    int deleteByExample(ZjkEvaluateExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkEvaluate record);

    int insertSelective(ZjkEvaluate record);

    List<ZjkEvaluate> selectByExample(ZjkEvaluateExample example);

    ZjkEvaluate selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkEvaluate record, @Param("example") ZjkEvaluateExample example);

    int updateByExample(@Param("record") ZjkEvaluate record, @Param("example") ZjkEvaluateExample example);

    int updateByPrimaryKeySelective(ZjkEvaluate record);

    int updateByPrimaryKey(ZjkEvaluate record);

    int updateByPrimaryKeyWithBLOBs(ZjkEvaluate record);

    List<ZjkEvaluate> findZjkEvaluateByPage(Map<String, Object> map);

    List<ZjkEvaluate> findZjkEvaluateList(ZjkEvaluate record);

}