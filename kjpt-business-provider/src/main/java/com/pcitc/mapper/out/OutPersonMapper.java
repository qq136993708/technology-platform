package com.pcitc.mapper.out;

import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.out.OutPerson;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface OutPersonMapper {
    int deleteByPrimaryKey(String id);

    int insert(OutPerson record);

    int insertSelective(OutPerson record);

    OutPerson selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OutPerson record);

    int updateByPrimaryKey(OutPerson record);
    
    List getList(Map map);
    
    long getCount(Map map);
    
    
    public int deleteAll()throws Exception;
    public Integer insertBatch(List<OutPerson> list);
    
    
    List getTongjiList();
    
    
}