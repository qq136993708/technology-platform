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
import com.pcitc.base.hana.report.ScientificInvestment;
import com.pcitc.mapper.financial.ScientificInvestmentMapper;
import com.pcitc.service.IScientificInvestmentService;
@Service("scientificInvestmentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ScientificInvestmentServiceIml implements IScientificInvestmentService {
	
	 private final static Logger logger = LoggerFactory.getLogger(DecisionFinancialServiceImpl.class);
     
     @Autowired
     private ScientificInvestmentMapper scientificInvestmentMapper;
	
	//投资项目完成情况统计表
	public LayuiTableData getTzxmwcqktjbData(LayuiTableParam param)throws Exception
  	{
  		//每页显示条数
  		int pageSize = param.getLimit();
  		//从第多少条开始
  		//int pageStart = (param.getPage()-1)*pageSize;
  		//当前是第几页
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
  		
  		List<ScientificInvestment> list = scientificInvestmentMapper.getTzxmwcqktjbDataList(map);
  		//Integer totalRecords = scientificInvestmentMapper.getTzxmwcqktjbDataCount(map);
  		System.out.println(">>>>>>投资项目完成情况统计表>>>查询分页结果");
  		LayuiTableData data = new LayuiTableData();
  		data.setData(list);
  		data.setCount(1000);
  	    return data;
  	}
	
	
	
	
	    //投资项目采购进度统计表
		public LayuiTableData getTzxmcgjdtjbData(LayuiTableParam param)throws Exception
	  	{
	  		//每页显示条数
	  		int pageSize = param.getLimit();
	  		//从第多少条开始
	  		//int pageStart = (param.getPage()-1)*pageSize;
	  		//当前是第几页
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
	  		
	  		List<ScientificInvestment> list = scientificInvestmentMapper.getTzxmcgjdtjbDataList(map);
	  		
	  		System.out.println(">>>>>>>投资项目采购进度统计表>>查询分页结果"+list.size());
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(1000);
	  	    return data;
	  	}
		
		
		
		//投资项目转出情况表
		public LayuiTableData getTzxmzcqkbData(LayuiTableParam param)throws Exception
	  	{
	  		//每页显示条数
	  		int pageSize = param.getLimit();
	  		//从第多少条开始
	  		//int pageStart = (param.getPage()-1)*pageSize;
	  		//当前是第几页
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
	  		
	  		List<ScientificInvestment> list = scientificInvestmentMapper.getTzxmzcqkbDataList(map);
	  		System.out.println(">>>>>>>投资项目转出情况表>>查询分页结果");
	  		LayuiTableData data = new LayuiTableData();
	  		data.setData(list);
	  		data.setCount(1000);
	  	    return data;
	  	}


}
