package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.FundsComprehensiveAnalysis01;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis02;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis03;
import com.pcitc.base.hana.report.ScientificCashFlow02;
import com.pcitc.base.hana.report.ScientificCashFlow03;

public interface IDecisionService
{
	
	
	
	
	 //报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_01
	public<ScientificCashFlow01> List getScientificCashFlow01Report(Map map)throws Exception;
	
	//报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_02
    public List<ScientificCashFlow02> getScientificCashFlow02Report(Map map)throws Exception;
    
	//报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_02
    public List<ScientificCashFlow03> getScientificCashFlow03Report(Map map)throws Exception;
    
    
    
    
    
    
    //报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_01
    public List<FundsComprehensiveAnalysis01> getFundsComprehensiveAnalysis01Report(Map map)throws Exception;
    //报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_02
    public List<FundsComprehensiveAnalysis02> getFundsComprehensiveAnalysis02Report(Map map)throws Exception;
    //报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_03
    public List<FundsComprehensiveAnalysis03> getFundsComprehensiveAnalysis03Report(Map map)throws Exception;
    
    
	
	
}
