package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.expert.ZjkChoiceExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkChoiceMapper {
    long countByExample(ZjkChoiceExample example);

    int deleteByExample(ZjkChoiceExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkChoice record);

    int insertSelective(ZjkChoice record);

    List<ZjkChoice> selectByExample(ZjkChoiceExample example);

    ZjkChoice selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example);

    int updateByExample(@Param("record") ZjkChoice record, @Param("example") ZjkChoiceExample example);

    int updateByPrimaryKeySelective(ZjkChoice record);

    int updateByPrimaryKey(ZjkChoice record);

    int updateByPrimaryKeyWithBLOBs(ZjkChoice record);

    List<ZjkChoice> findZjkChoiceByPage(Map<String, Object> map);

    List<ZjkChoice> findZjkChoiceList(ZjkChoice record);

}