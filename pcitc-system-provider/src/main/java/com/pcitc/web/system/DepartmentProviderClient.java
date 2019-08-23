package com.pcitc.web.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.Department;
import com.pcitc.service.system.DepartmentService;

import io.swagger.annotations.Api;
@Api(value = "Equipment-API",tags = {"研究院维护的接口"})
@RestController
public class DepartmentProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(DepartmentProviderClient.class); 
	@Autowired
    private DepartmentService departmentService; 
	
	
	
	
	@RequestMapping(value = "/department-provider/department/page", method = RequestMethod.POST)
	public LayuiTableData getDepartmentList(@RequestBody LayuiTableParam paramsJson)throws Exception
	{
		
		logger.info("=== Department paramsJson============"+paramsJson);
		return departmentService.getDepartmentPage(paramsJson);
		
	}
	
	
	@RequestMapping(value = "/department-provider/department/add", method = RequestMethod.POST)
	public String insertDepartment(@RequestBody Department department) throws Exception{
		logger.info("====================add Department....========================");
		Integer count= departmentService.insertDepartment(department);
		return department.getId();
	}
	
	
	
	@RequestMapping(value = "/department-provider/department/update", method = RequestMethod.POST)
	public Integer updateDepartment(@RequestBody Department Department) throws Exception{
		logger.info("==================update Department===========================");
		return departmentService.updateDepartment(Department);
	}
	
	
	@RequestMapping(value = "/department-provider/department/delete/{id}", method = RequestMethod.POST)
	public int deleteDepartment(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete Department=================");
		return departmentService.deleteDepartment(id);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/department-provider/department/get/{id}", method = RequestMethod.GET)
	public Department selectDepartmentById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get Department id "+id+"===========");
		return departmentService.selectDepartment(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
