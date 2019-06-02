package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.ScientificInvestment;

public interface ScientificInvestmentMapper {
	
	 ///投资项目完成情况统计表
     public List<ScientificInvestment> getTzxmwcqktjbDataList(Map map);
     public List<ScientificInvestment> getTzxmwcqktjbDetailList(Map map);
     public Integer getTzxmwcqktjbDetailCount(Map map);
	 //投资项目采购进度统计表
	 public List<ScientificInvestment> getTzxmcgjdtjbDataList(Map map);
	 public List<ScientificInvestment> getTzxmcgjdtjbDetailList(Map map);
	 public Integer getTzxmcgjdtjbDetailCount(Map map);
	 
	 
	 
	 
	 //投资项目转出情况表
	 public List<ScientificInvestment> getTzxmzcqkbDataList(Map map);
	 public List<ScientificInvestment> getTzxmzcqkbDetailList(Map map);
	 public Integer getTzxmzcqkbDetailCount(Map map);
	 
	 
		
		
		
}
