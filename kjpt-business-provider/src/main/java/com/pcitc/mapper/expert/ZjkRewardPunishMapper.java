package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.expert.ZjkBookSync;
import com.pcitc.base.expert.ZjkRewardPunish;

public interface ZjkRewardPunishMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkRewardPunish record);

    int insertSelective(ZjkRewardPunish record);

    ZjkRewardPunish selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkRewardPunish record);

    int updateByPrimaryKey(ZjkRewardPunish record);
    

    List getList(Map map);
    public int deleteAll()throws Exception;
    int getCount(Map map);
    public Integer insertBatch(List<ZjkRewardPunish> list);
    
}