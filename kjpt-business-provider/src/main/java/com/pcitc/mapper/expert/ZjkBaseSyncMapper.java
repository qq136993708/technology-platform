package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.expert.ZjkBaseSync;

public interface ZjkBaseSyncMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkBaseSync record);

    int insertSelective(ZjkBaseSync record);

    ZjkBaseSync selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkBaseSync record);

    int updateByPrimaryKey(ZjkBaseSync record);
    List getList(Map map);
    
    int getCount(Map map);
    
    public Integer insertBatch(List<ZjkBaseSync> list);
    
    public int deleteAllZjkSync()throws Exception;
    
    
    
	
	
	
}