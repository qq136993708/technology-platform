package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkReward;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ZjkRewardMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkReward record);

    int insertSelective(ZjkReward record);

    ZjkReward selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkReward record);

    int updateByPrimaryKey(ZjkReward record);
    List getList(Map map);
    int getCount(Map map);
    
    //根据专家ID逻辑删除奖励信息
    int  deleteLogicZjkRewardByExpertId(String expertId);
    //根据专家ID删除奖励信息
    int  deleteZjkRewardByExpertId(String expertId);
    
    
    int  deleteLogicZjkRewardById(String expertId);
    
    
    
    List getListByExpertId(String expertId);
    
}