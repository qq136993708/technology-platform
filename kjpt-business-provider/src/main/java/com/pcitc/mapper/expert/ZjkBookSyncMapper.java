package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.expert.ZjkBookSync;

public interface ZjkBookSyncMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkBookSync record);

    int insertSelective(ZjkBookSync record);

    ZjkBookSync selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkBookSync record);

    int updateByPrimaryKey(ZjkBookSync record);
    
    
    

    List getList(Map map);
    public int deleteAll()throws Exception;
    int getCount(Map map);
    public Integer insertBatch(List<ZjkBookSync> list);
}