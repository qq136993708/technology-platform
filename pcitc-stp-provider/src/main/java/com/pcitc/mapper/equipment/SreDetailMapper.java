package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreDetail;

public interface SreDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreDetail record);

    int insertSelective(SreDetail record);

    SreDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreDetail record);

    int updateByPrimaryKey(SreDetail record);
    
    List<SreDetail> getList(Map map);
    
    int updateByid(String id);

	SreDetail selectaRchaseidKey(String equipmentId);

	SreDetail selectSreDetailId(String id);

	SreDetail detail(String id);
	
	
	
}