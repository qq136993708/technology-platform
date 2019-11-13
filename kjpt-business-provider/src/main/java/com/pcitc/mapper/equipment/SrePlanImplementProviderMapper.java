package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SrePlanImplement;

public interface SrePlanImplementProviderMapper {
    int deleteByPrimaryKey(String id);

    int insert(SrePlanImplement record);

    int insertSelective(SrePlanImplement record);

    SrePlanImplement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SrePlanImplement record);

    int updateByPrimaryKey(SrePlanImplement record);

	List<SrePlanImplement> getList(Map map);
	
}