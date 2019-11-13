package com.pcitc.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.Department;
import com.pcitc.mapper.system.DepartmentMapper;
import com.pcitc.service.system.DepartmentService;


@Service("departmentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired
	private DepartmentMapper departmentMapper;
	


	
	public Department selectDepartment(String id) throws Exception
	{
		return departmentMapper.selectByPrimaryKey(id);
	}

	public Integer updateDepartment(Department record)throws Exception
	{
		return departmentMapper.updateByPrimaryKey(record);
	}

	public int deleteDepartment(String id)throws Exception
	{
		return departmentMapper.deleteByPrimaryKey(id);
	}
	

	public Integer insertDepartment(Department record)throws Exception
	{
		return departmentMapper.insert(record);
	}
	
	public LayuiTableData getDepartmentPage(LayuiTableParam param)throws Exception
	{
		
		        //每页显示条数
				int pageSize = param.getLimit();
				//从第多少条开始
				int pageStart = (param.getPage()-1)*pageSize;
				//当前是第几页
				int pageNum = pageStart/pageSize + 1;
				// 1、设置分页信息，包括当前页数和每页显示的总计数
				PageHelper.startPage(pageNum, pageSize);
						
				String title=getTableParam(param,"title","");
				
				Map map=new HashMap();
				map.put("title", title);
				
				
				List<Department> list = departmentMapper.getList(map);
				PageInfo<Department> pageInfo = new PageInfo<Department>(list);
				System.out.println(">>>>>>>>>任务书查询分页结果 "+pageInfo.getList().size());
				
				LayuiTableData data = new LayuiTableData();
				data.setData(pageInfo.getList());
				Long total = pageInfo.getTotal();
				data.setCount(total.intValue());
				
			    return data;
	}

	
	
	public List getDepartmentList(Map map)throws Exception
	{
		List<Department> list = departmentMapper.getList(map);
		return list;
	}
	

	private String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
	{
		String resault="";
		Object object=param.getParam().get(paramName);
		if(object!=null)
		{
			resault=(String)object;
		}
		return resault;
	}
	

}
