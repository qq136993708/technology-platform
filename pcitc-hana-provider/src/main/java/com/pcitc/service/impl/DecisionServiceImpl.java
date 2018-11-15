package com.pcitc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis01;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis02;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis03;
import com.pcitc.base.hana.report.ScientificCashFlow01;
import com.pcitc.base.hana.report.ScientificCashFlow02;
import com.pcitc.base.hana.report.ScientificCashFlow03;
import com.pcitc.mapper.common.CommonMapper;
import com.pcitc.mapper.other.DecisionMapper;
import com.pcitc.service.IDecisionService;

@Service("decisionService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class DecisionServiceImpl implements IDecisionService {

    @Autowired
    private DecisionMapper decisionMapper;

    @Autowired
    private CommonMapper commonMapper;
    private final static Logger logger = LoggerFactory.getLogger(DecisionFinancialServiceImpl.class);
    

    //报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_01
    public List<ScientificCashFlow01> getScientificCashFlow01Report(Map map)throws Exception
    {
    	List<ScientificCashFlow01> list = decisionMapper.getScientificCashFlow01Report(map);
    	return list;
    }
    //报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_02
    public List<ScientificCashFlow02> getScientificCashFlow02Report(Map map)throws Exception
    {
    	List<ScientificCashFlow02> list = decisionMapper.getScientificCashFlow02Report(map);
    	return list;
    }

    //报表名称: 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_03
    public List<ScientificCashFlow03> getScientificCashFlow03Report(Map map)throws Exception
    {
    	List<ScientificCashFlow03> list = decisionMapper.getScientificCashFlow03Report(map);
    	return list;
    }




    //报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_01
    public List<FundsComprehensiveAnalysis01> getFundsComprehensiveAnalysis01Report(Map map)throws Exception
    {
    	JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
    	logger.info("========= 科研预算经费年度趋势分析: "+jSONObject.toJSONString());
    	return decisionMapper.getFundsComprehensiveAnalysis01Report(map);
    }
    //报表名称:科研经费综合分析,报表编码: H1AM_KY_ZH_1001_02
    //项目类型经费预算投入或预算占比金额+预算经费投入或预算 资金来源占比金额+研究院实际经费投入管理级别占比分析
    public List<FundsComprehensiveAnalysis02> getFundsComprehensiveAnalysis02Report(Map map)throws Exception
    {

    	List<FundsComprehensiveAnalysis02> list=new ArrayList();
    	String type=(String)map.get("type");
    	if(type.equals("project"))
    	{
    		list= decisionMapper.getFundsComprehensiveAnalysis02Report_for_project(map);

    	}
    	if(type.equals("source"))
    	{
    		list=  decisionMapper.getFundsComprehensiveAnalysis02Report_for_source(map);

    	}
    	if(type.equals("manage"))
    	{
    		list=  decisionMapper.getFundsComprehensiveAnalysis02Report_for_manage(map);
    	}
    	return list;
    }
    //报表名称:科研经费综合分析    报表编码: H1AM_KY_ZH_1001_03
    public List<FundsComprehensiveAnalysis03> getFundsComprehensiveAnalysis03Report(Map map)throws Exception
    {
    	return decisionMapper.getFundsComprehensiveAnalysis03Report(map);
    }





}
