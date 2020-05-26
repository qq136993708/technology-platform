package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkPatentSync;

public interface ZjkPatentSyncMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkPatentSync record);

    int insertSelective(ZjkPatentSync record);

    ZjkPatentSync selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkPatentSync record);

    int updateByPrimaryKey(ZjkPatentSync record);
    
    List getList(Map map);
    public int deleteAllPatentSync()throws Exception;
    int getCount(Map map);
    public Integer insertBatch(List<ZjkPatentSync> list);
}