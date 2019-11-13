package com.pcitc.mapper.system;

import com.pcitc.base.system.SysCronExceptionLog;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * SysCronExceptionLogMapper继承基类
 */
@Repository
public interface SysCronExceptionLogMapper {
	
	
	    int deleteByPrimaryKey(String id);

	    int insert(SysCronExceptionLog record);

	    int insertSelective(SysCronExceptionLog record);

	    SysCronExceptionLog selectByPrimaryKey(String id);

	    int updateByPrimaryKeySelective(SysCronExceptionLog record);

	    int updateByPrimaryKey(SysCronExceptionLog record);
	    
	    List<SysCronExceptionLog> getList(Map  map);
	    int getCount(Map map);
	    
}