package com.pcitc.service.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.Department;

public interface DepartmentService {
	
	
	
	public  Department selectDepartment(String id) throws Exception;

	public Integer updateDepartment( Department record)throws Exception;

	public int deleteDepartment(String id)throws Exception;

	public Integer insertDepartment( Department record)throws Exception;

	
	
	public List getDepartmentList(Map map)throws Exception;
	
	
	public LayuiTableData getDepartmentPage(LayuiTableParam param)throws Exception;

}
