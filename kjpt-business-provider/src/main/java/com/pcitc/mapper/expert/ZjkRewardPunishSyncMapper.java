package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.expert.ZjkRewardSync;

public interface ZjkRewardPunishSyncMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkRewardPunishSync record);

    int insertSelective(ZjkRewardPunishSync record);

    ZjkRewardPunishSync selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkRewardPunishSync record);

    int updateByPrimaryKey(ZjkRewardPunishSync record);
    
    List getList(Map map);
    public int deleteAll()throws Exception;
    int getCount(Map map);
    public Integer insertBatch(List<ZjkRewardPunishSync> list);
    
    
}