package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.ProjectCost;

public interface IProjectCostService {
	  //科研投资统计表
	  public List<ProjectCost> getKytztjbData(Map map)throws Exception;
	  public LayuiTableData    getKytztjbData_detail(LayuiTableParam param)throws Exception;
	  
	  public List<ProjectCost>    getKytztjbData_detail_excel(Map map)throws Exception;
	  
	  //科技经费统计表
	  public List<ProjectCost> getKjjftjbData(Map map)throws Exception;
	  public LayuiTableData    getKjjftjbData_detail(LayuiTableParam param)throws Exception;
	  
	  public List<ProjectCost>    getKjjftjbData_detail_excel(Map map)throws Exception;
	  
	  
	  
	  //横向课题全成本统计表
	  public List<ProjectCost> getHxktqcbtjbData(Map map)throws Exception;
	  public LayuiTableData getHxktqcbtjbData_detail(LayuiTableParam param)throws Exception;
	  
	  
	  public List<ProjectCost>    getHxktqcbtjbData_detail_excel(Map map)throws Exception;
			
			
			
}
