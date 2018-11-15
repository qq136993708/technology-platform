package com.pcitc.mapper.out;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutReward;
import com.pcitc.base.stp.out.OutRewardExample;

public interface OutRewardMapper {
    int countByExample(OutRewardExample example);

    int deleteByExample(OutRewardExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutReward record);

    int insertSelective(OutReward record);

    List<OutReward> selectByExample(OutRewardExample example);

    OutReward selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutReward record, @Param("example") OutRewardExample example);

    int updateByExample(@Param("record") OutReward record, @Param("example") OutRewardExample example);

    int updateByPrimaryKeySelective(OutReward record);

    int updateByPrimaryKey(OutReward record);
    
    public void insertOutRewardBatch(List<OutReward> list);
}