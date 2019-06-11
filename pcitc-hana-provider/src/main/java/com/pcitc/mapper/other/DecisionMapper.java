package com.pcitc.mapper.other;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.FundsComprehensiveAnalysis01;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis02;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis03;
import com.pcitc.base.hana.report.ScientificCashFlow01;
import com.pcitc.base.hana.report.ScientificCashFlow02;
import com.pcitc.base.hana.report.ScientificCashFlow03;

public interface DecisionMapper {

    List getList(String no);
    
    
    //报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_01
    public List<ScientificCashFlow01> getScientificCashFlow01Report(Map map);
    
    //报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_01
    public List<ScientificCashFlow02> getScientificCashFlow02Report(Map map);
    
    //报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_01
    public List<ScientificCashFlow03> getScientificCashFlow03Report(Map map);
    
    
    //报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_01
    public List<FundsComprehensiveAnalysis01> getFundsComprehensiveAnalysis01Report(Map map);
    //报表名称:科研经费综合分析 -- 项目类型经费预算投入或预算占比金额  报表编码: H1AM_KY_ZH_1001_02
    public List<FundsComprehensiveAnalysis02> getFundsComprehensiveAnalysis02Report_for_project(Map map);
    //报表名称:科研经费综合分析 -- 预算经费投入或预算 资金来源占比金额  报表编码: H1AM_KY_ZH_1001_02 
    public List<FundsComprehensiveAnalysis02> getFundsComprehensiveAnalysis02Report_for_source(Map map);
    //报表名称:科研经费综合分析 -- 研究院实际经费投入管理级别占比分析 报表编码: H1AM_KY_ZH_1001_02 
    public List<FundsComprehensiveAnalysis02> getFundsComprehensiveAnalysis02Report_for_manage(Map map);
    
    //报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_03
    public List<FundsComprehensiveAnalysis03> getFundsComprehensiveAnalysis03Report(Map map);

}