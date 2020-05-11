package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.ScientificFunds;

public interface IScientificFundsService {
	
	    //课题直间接费用统计表
	    public List<ScientificFunds> getKtzjjfytjbData(Map map)throws Exception;
	    public List<ScientificFunds> getKtzjjfytjbData_detail(Map map)throws Exception;
	    public LayuiTableData getKtzjjfytjbData_detail_page(LayuiTableParam param)throws Exception;
	    
	    //人工成本支出统计表
		public List<ScientificFunds> getRgcbzctjbData(Map map )throws Exception;
		public List<ScientificFunds> getRgcbzctjbDataDetail(Map map )throws Exception;
		public LayuiTableData getRgcbzctjbDataDetail_page(LayuiTableParam param)throws Exception;
		//原材料支出统计表
		public List<ScientificFunds> getYclzctjbData(Map map )throws Exception;
		public List<ScientificFunds> getYclzctjbData_Detail(Map map )throws Exception;
		public LayuiTableData getYclzctjbData_Detail_page(LayuiTableParam param)throws Exception;
		//能耗支出统计表
		public List<ScientificFunds> getNhzctjbData(Map param)throws Exception;
		public List<ScientificFunds> getNhzctjbData_detail(Map param)throws Exception;
		public LayuiTableData getNhzctjbData_detail_page(LayuiTableParam param)throws Exception;
		//项目资金流向分析
		public List<ScientificFunds> getXmzjlxfxData(Map param)throws Exception;
		public List<ScientificFunds> getXmzjlxfxData_detail(Map param)throws Exception;
		public LayuiTableData getXmzjlxfxData_detail_page(LayuiTableParam param)throws Exception;	
		
		
		
		

}
