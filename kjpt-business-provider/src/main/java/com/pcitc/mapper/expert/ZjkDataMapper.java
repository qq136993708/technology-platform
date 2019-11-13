package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkData;
import com.pcitc.base.expert.ZjkDataExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkDataMapper {
    long countByExample(ZjkDataExample example);

    int deleteByExample(ZjkDataExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkData record);

    int insertSelective(ZjkData record);

    List<ZjkData> selectByExample(ZjkDataExample example);

    ZjkData selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkData record, @Param("example") ZjkDataExample example);

    int updateByExample(@Param("record") ZjkData record, @Param("example") ZjkDataExample example);

    int updateByPrimaryKeySelective(ZjkData record);

    int updateByPrimaryKey(ZjkData record);

    int updateByPrimaryKeyWithBLOBs(ZjkData record);

    List<ZjkData> findZjkDataByPage(Map<String, Object> map);

    List<ZjkData> findZjkDataList(ZjkData record);

}