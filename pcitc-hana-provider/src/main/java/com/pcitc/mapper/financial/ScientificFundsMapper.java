package com.pcitc.mapper.financial;
import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.ScientificFunds;

public interface ScientificFundsMapper {
	
	

    //课题直间接费用统计表
    public List<ScientificFunds> getKtzjjfytjbData(Map param)throws Exception;
    //人工成本支出统计表
	public List<ScientificFunds> getRgcbzctjbData(Map param)throws Exception;
	public List<ScientificFunds> getRgcbzctjbDataDetail(Map param)throws Exception;
	
	//原材料支出统计表
	public List<ScientificFunds> getYclzctjbData(Map param)throws Exception;
	//能耗支出统计表
	public List<ScientificFunds> getNhzctjbData(Map param)throws Exception;
	//项目资金流向分析
	public List<ScientificFunds> getXmzjlxfxData(Map param)throws Exception;
			
	
}
