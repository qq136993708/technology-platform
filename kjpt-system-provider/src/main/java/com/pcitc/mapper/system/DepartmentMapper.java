package com.pcitc.mapper.system;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pcitc.base.system.Department;

/**
 * DepartmentMapper继承基类
 */
@Repository
public interface DepartmentMapper {
	
	int deleteByPrimaryKey(String id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKeyWithBLOBs(Department record);

    int updateByPrimaryKey(Department record);
    
    List getList(Map map);
    int getCount(Map map);
    
    
}