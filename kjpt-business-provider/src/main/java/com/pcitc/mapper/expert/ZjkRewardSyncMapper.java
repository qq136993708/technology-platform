package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.expert.ZjkRewardSync;

public interface ZjkRewardSyncMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkRewardSync record);

    int insertSelective(ZjkRewardSync record);

    ZjkRewardSync selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkRewardSync record);

    int updateByPrimaryKey(ZjkRewardSync record);
    
    
    
    List getList(Map map);
    public int deleteAll()throws Exception;
    int getCount(Map map);
    public Integer insertBatch(List<ZjkRewardSync> list);
    
    
}