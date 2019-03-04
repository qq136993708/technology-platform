package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkTrain;
import com.pcitc.base.expert.ZjkTrainExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkTrainMapper {
    long countByExample(ZjkTrainExample example);

    int deleteByExample(ZjkTrainExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkTrain record);

    int insertSelective(ZjkTrain record);

    List<ZjkTrain> selectByExample(ZjkTrainExample example);

    ZjkTrain selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkTrain record, @Param("example") ZjkTrainExample example);

    int updateByExample(@Param("record") ZjkTrain record, @Param("example") ZjkTrainExample example);

    int updateByPrimaryKeySelective(ZjkTrain record);

    int updateByPrimaryKey(ZjkTrain record);

    int updateByPrimaryKeyWithBLOBs(ZjkTrain record);

    List<ZjkTrain> findZjkTrainByPage(Map<String, Object> map);

    List<ZjkTrain> findZjkTrainList(ZjkTrain record);

}