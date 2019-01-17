package com.pcitc.service;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;

public interface IScientificFundsService {
	
	    //课题直间接费用统计表
	    public LayuiTableData getKtzjjfytjbData(LayuiTableParam param)throws Exception;
	    //人工成本支出统计表
		public LayuiTableData getRgcbzctjbData(LayuiTableParam param)throws Exception;
		//原材料支出统计表
		public LayuiTableData getYclzctjbData(LayuiTableParam param)throws Exception;
		//能耗支出统计表
		public LayuiTableData getNhzctjbData(LayuiTableParam param)throws Exception;
		//项目资金流向分析
		public LayuiTableData getXmzjlxfxData(LayuiTableParam param)throws Exception;
				
		
		
		
		

}
