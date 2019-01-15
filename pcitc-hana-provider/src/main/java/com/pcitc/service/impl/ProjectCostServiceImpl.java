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
import com.pcitc.mapper.financial.ProjectCostMapper;
import com.pcitc.service.IProjectCostService;
@Service("projectCostService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ProjectCostServiceImpl implements IProjectCostService {
	 private final static Logger logger = LoggerFactory.getLogger(DecisionFinancialServiceImpl.class);
     @Autowired
     private ProjectCostMapper projectCostMapper;
	 public LayuiTableData getKytztjbData(LayuiTableParam param)throws Exception
  	 {
  		//每页显示条数
  		int pageSize = param.getLimit();
  		//从第多少条开始
  		int pageNum = param.getPage();
  		Page p=new Page(pageNum,pageSize);
		int start=(pageNum-1)*p.getPageSize();
  		String g0TXT50=(String)param.getParam().get("g0TXT50");
  		String g0GSJC=(String)param.getParam().get("g0GSJC");
  		String g0ZCMS=(String)param.getParam().get("g0ZCMS");
  		String month=(String)param.getParam().get("month");
  		String companyCode=(String)param.getParam().get("companyCode");
  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
  		Map map=new HashMap();
  		map.put("start", start);
  		map.put("pageSize", pageSize);
  		map.put("month", month);
  		map.put("companyCode", companyCode);
  		map.put("g0TXT50", g0TXT50);
  		map.put("g0ZCMS", g0ZCMS);
  		map.put("g0GSJC", g0GSJC);
  		
  		List<ProjectCost> list = projectCostMapper.getList(map);
  		Integer totalRecords = projectCostMapper.getCount(map);
  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
  		LayuiTableData data = new LayuiTableData();
  		data.setData(list);
  		data.setCount(totalRecords);
  	    return data;
  	}
	 
	 
	 
	 
	 public LayuiTableData getKjjftjbData(LayuiTableParam param)throws Exception
  	 {
  		//每页显示条数
  		int pageSize = param.getLimit();
  		//从第多少条开始
  		int pageNum = param.getPage();
  		Page p=new Page(pageNum,pageSize);
		int start=(pageNum-1)*p.getPageSize();
  		String g0TXT50=(String)param.getParam().get("g0TXT50");
  		String g0GSJC=(String)param.getParam().get("g0GSJC");
  		String g0ZCMS=(String)param.getParam().get("g0ZCMS");
  		String month=(String)param.getParam().get("month");
  		String companyCode=(String)param.getParam().get("companyCode");
  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
  		Map map=new HashMap();
  		map.put("start", start);
  		map.put("pageSize", pageSize);
  		map.put("month", month);
  		map.put("companyCode", companyCode);
  		map.put("g0TXT50", g0TXT50);
  		map.put("g0ZCMS", g0ZCMS);
  		map.put("g0GSJC", g0GSJC);
  		
  		List<ProjectCost> list = projectCostMapper.getList(map);
  		Integer totalRecords = projectCostMapper.getCount(map);
  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
  		LayuiTableData data = new LayuiTableData();
  		data.setData(list);
  		data.setCount(totalRecords);
  	    return data;
  	}
	 
	 
	 public LayuiTableData getHxktqcbtjbData(LayuiTableParam param)throws Exception
  	 {
  		//每页显示条数
  		int pageSize = param.getLimit();
  		//从第多少条开始
  		int pageNum = param.getPage();
  		Page p=new Page(pageNum,pageSize);
		int start=(pageNum-1)*p.getPageSize();
  		String g0TXT50=(String)param.getParam().get("g0TXT50");
  		String g0GSJC=(String)param.getParam().get("g0GSJC");
  		String g0ZCMS=(String)param.getParam().get("g0ZCMS");
  		String month=(String)param.getParam().get("month");
  		String companyCode=(String)param.getParam().get("companyCode");
  		logger.info("===明细查询参数 param: "+JSONObject.toJSONString(param));
  		Map map=new HashMap();
  		map.put("start", start);
  		map.put("pageSize", pageSize);
  		map.put("month", month);
  		map.put("companyCode", companyCode);
  		map.put("g0TXT50", g0TXT50);
  		map.put("g0ZCMS", g0ZCMS);
  		map.put("g0GSJC", g0GSJC);
  		
  		List<ProjectCost> list = projectCostMapper.getList(map);
  		Integer totalRecords = projectCostMapper.getCount(map);
  		System.out.println(">>>>>>>>>查询分页结果"+totalRecords);
  		LayuiTableData data = new LayuiTableData();
  		data.setData(list);
  		data.setCount(totalRecords);
  	    return data;
  	}
}
