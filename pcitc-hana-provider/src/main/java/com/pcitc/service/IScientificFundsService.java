package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.ScientificFunds;

public interface IScientificFundsService {
	
	    //课题直间接费用统计表
	    public List<ScientificFunds> getKtzjjfytjbData(Map map)throws Exception;
	    //人工成本支出统计表
		public List<ScientificFunds> getRgcbzctjbData(Map map )throws Exception;
		public List<ScientificFunds> getRgcbzctjbDataDetail(Map map )throws Exception;
		
		
		
		//原材料支出统计表
		public List<ScientificFunds> getYclzctjbData(Map map )throws Exception;
		//能耗支出统计表
		public LayuiTableData getNhzctjbData(LayuiTableParam param)throws Exception;
		//项目资金流向分析
		public LayuiTableData getXmzjlxfxData(LayuiTableParam param)throws Exception;
				
		
		
		
		

}
