package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreForApplication;

public interface SreForApplicationMapper {
    int deleteByPrimaryKey(String applicationId);

	int insert(SreForApplication record);

	int insertSelective(SreForApplication record);

	SreForApplication selectByPrimaryKey(String applicationId);

	int updateByPrimaryKeySelective(SreForApplication record);

	int updateByPrimaryKey(SreForApplication record);
    
	List getList(Map map);
	
	SreForApplication selectaRchaseidKey(String applicationId);
}