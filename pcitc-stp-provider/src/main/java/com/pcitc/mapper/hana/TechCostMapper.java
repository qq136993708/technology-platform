package com.pcitc.mapper.hana;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.report.TechCost;

public interface TechCostMapper {
    int deleteByPrimaryKey(String id);

    int insert(TechCost record);

    int insertSelective(TechCost record);

    TechCost selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TechCost record);

    int updateByPrimaryKey(TechCost record);
    
    List getList(Map map);
    int getCount(Map map);
}