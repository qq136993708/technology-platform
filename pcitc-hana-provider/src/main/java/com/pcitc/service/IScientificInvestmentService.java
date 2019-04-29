package com.pcitc.service;

import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;

public interface IScientificInvestmentService {
		//投资项目完成情况统计表
		public LayuiTableData getTzxmwcqktjbData(LayuiTableParam param)throws Exception;
		
		public JSONArray getTzxmwcqktjbDataList(Map map)throws Exception;
		
		
	    //投资项目采购进度统计表
		public LayuiTableData getTzxmcgjdtjbData(LayuiTableParam param)throws Exception;
		public JSONArray getTzxmcgjdtjbDataList(Map map)throws Exception;
		//投资项目转出情况表
		public LayuiTableData getTzxmzcqkbData(LayuiTableParam param)throws Exception;
		
		public JSONArray getTzxmzcqkbDataList(Map map)throws Exception;
}
