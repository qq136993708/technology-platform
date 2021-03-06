package com.pcitc.mapper.out;

import com.pcitc.base.out.OutProject;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface OutProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(OutProject record);

    int insertSelective(OutProject record);

    OutProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OutProject record);

    int updateByPrimaryKey(OutProject record);
    
    
    int insertBatch(List<OutProject> list);
    int deleteAll();
    List getList(Map map);
    
    int getCount(Map map);
}