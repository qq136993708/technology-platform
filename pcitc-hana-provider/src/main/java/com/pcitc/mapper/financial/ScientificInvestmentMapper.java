package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.ScientificInvestment;

public interface ScientificInvestmentMapper {
	
	 ///投资项目完成情况统计表
     public List<ScientificInvestment> getTzxmwcqktjbDataList(Map map);
	 public Integer getTzxmwcqktjbDataCount(Map map);
	 
	 //投资项目采购进度统计表
	 public List<ScientificInvestment> getTzxmcgjdtjbDataList(Map map);
	 public Integer getTzxmcgjdtjbDataCount(Map map);
	 //投资项目转出情况表
	 public List<ScientificInvestment> getTzxmzcqkbDataList(Map map);
	 public Integer getTzxmzcqkbDataCount(Map map);
}
