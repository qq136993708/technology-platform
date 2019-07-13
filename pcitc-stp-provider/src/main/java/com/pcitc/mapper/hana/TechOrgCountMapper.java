package com.pcitc.mapper.hana;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.report.TechOrgCount;

public interface TechOrgCountMapper {
    int deleteByPrimaryKey(String id);

    int insert(TechOrgCount record);

    int insertSelective(TechOrgCount record);

    TechOrgCount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TechOrgCount record);

    int updateByPrimaryKey(TechOrgCount record);
    
    List getList(Map map);
    int getCount(Map map);
    
    List getStatisticsList(Map map);
    int  getStatisticsCount(Map map);
    
    
}