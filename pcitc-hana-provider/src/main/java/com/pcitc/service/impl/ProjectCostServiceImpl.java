package com.pcitc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.hana.report.ProjectCost;
import com.pcitc.base.hana.report.ScientificFunds;
import com.pcitc.mapper.financial.ProjectCostMapper;
import com.pcitc.service.IProjectCostService;
@Service("projectCostService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ProjectCostServiceImpl implements IProjectCostService {
	
	 private final static Logger logger = LoggerFactory.getLogger(DecisionFinancialServiceImpl.class);
     @Autowired
     private ProjectCostMapper projectCostMapper;
     
     
     
     
     
     
     //科研投资统计表
	  public List<ProjectCost> getKytztjbData(Map  map)throws Exception
 	  {
 		List<ProjectCost> list = projectCostMapper.getKytztjbData(map);
 	    return list;
     }
	  
	  public LayuiTableData getKytztjbData_detail(LayuiTableParam param)throws Exception
	  {
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		
	  		List<ProjectCost> list = projectCostMapper.getKytztjbData_detail(map);
	  		Integer totalRecords = projectCostMapper.getKytztjbData_detail_count(map);
	  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	  	}
	  
	  
	  
	  //科技经费统计表
	  public List<ProjectCost> getKjjftjbData(Map map)throws Exception
	  {
		    List<ProjectCost> list = projectCostMapper.getKjjftjbData(map);
	  	    return list;
	  }
	  
	  public LayuiTableData getKjjftjbData_detail(LayuiTableParam param)throws Exception
	  {
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		
	  		List<ProjectCost> list = projectCostMapper.getKjjftjbData_detail(map);
	  		Integer totalRecords = projectCostMapper.getKjjftjbData_detail_count(map);
	  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	  	}
	  
	  //横向课题全成本统计表
	  public List<ProjectCost> getHxktqcbtjbData(Map map)throws Exception
	  {
		  List<ProjectCost> list = projectCostMapper.getHxktqcbtjbData(map);
	  	    return list;
	  }
	  
	  
	  public LayuiTableData getHxktqcbtjbData_detail(LayuiTableParam param)throws Exception
	  {
	  		int pageSize = param.getLimit();
	  		int pageNum = param.getPage();
	  		Page p=new Page(pageNum,pageSize);
			int start=(pageNum-1)*p.getPageSize();
	  		String month=(String)param.getParam().get("month");
	  		String companyCode=(String)param.getParam().get("companyCode");
	  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
	  		Map map=new HashMap();
	  		map.put("start", start);
	  		map.put("pageSize", pageSize);
	  		map.put("month", month);
	  		map.put("companyCode", companyCode);
	  		
	  		List<ProjectCost> list = projectCostMapper.getHxktqcbtjbData_detail(map);
	  		Integer totalRecords = projectCostMapper.getHxktqcbtjbData_detail_count(map);
	  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(totalRecords);
	  	    return data;
	  	}
	  
	  
	  
	 
	
	 
}
