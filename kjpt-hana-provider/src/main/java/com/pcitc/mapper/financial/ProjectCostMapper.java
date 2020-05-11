package com.pcitc.mapper.financial;
import java.util.List;
import java.util.Map;
import com.pcitc.base.hana.report.ProjectCost;



public interface ProjectCostMapper
{
	  //科研投资统计表
	  public List<ProjectCost> getKytztjbData(Map map)throws Exception;
	  public List<ProjectCost> getKytztjbData_detail(Map map)throws Exception;
	  public Integer getKytztjbData_detail_count(Map map)throws Exception;
	  //科技经费统计表
	  public List<ProjectCost> getKjjftjbData(Map map)throws Exception;
	  public List<ProjectCost> getKjjftjbData_detail(Map map)throws Exception;
	  public Integer getKjjftjbData_detail_count(Map map)throws Exception;
	  //横向课题全成本统计表
	  public List<ProjectCost> getHxktqcbtjbData(Map map)throws Exception;
	  public List<ProjectCost> getHxktqcbtjbData_detail(Map map)throws Exception;
	  public Integer getHxktqcbtjbData_detail_count(Map map)throws Exception;
	  
}
