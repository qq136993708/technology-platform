package com.pcitc.mapper.system;

import com.pcitc.base.system.SysQrtzLog;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * SysCronExceptionLogMapper继承基类
 */
@Repository
public interface SysQrtzLogMapper {
	
	
	    int deleteByPrimaryKey(String id);

	    int insert(SysQrtzLog record);

	    int insertSelective(SysQrtzLog record);

	    SysQrtzLog selectByPrimaryKey(String id);

	    int updateByPrimaryKeySelective(SysQrtzLog record);

	    int updateByPrimaryKey(SysQrtzLog record);
	    
	    List<SysQrtzLog> getList(Map  map);
	    int getCount(Map map);
	    
}