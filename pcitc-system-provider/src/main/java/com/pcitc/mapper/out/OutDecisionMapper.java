package com.pcitc.mapper.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OutDecisionMapper {
    
    /**
     * @param nd
     * @return
     * 经费预算建议--集团公司总部科技经费预算（建议稿）
     */
    public List getGroupCompanyStpMoneyForBudgetProposals(HashMap<String, String> map);
    
	/**
     * @param nd
     * @return
     * 预算分配,经费预算分析,股份公司总部科技经费预算（建议稿）
     */
	public List getStockCompanyMoneyTable(HashMap<String, String> map);
	
	/**
     * 预算分配,经费预算分析,各处、部门科技经费预算总表
     */
	public List getDepartmentBudgetMoneyTable(String nd);
	
	/**
     * 知识产权分析,国际、国内专利数量统计
     */
	public List getPatentCountByCountryType(Map map);
	
	/**
     * 知识产权分析,各类型专利的数量，发明公布，发明授权，实用新型等
     */
	public List getPatentCountByPatentType(Map map);
	
	/**
     * 知识产权分析,各类型专利的数量，8大研究院
     */
	public List getPatentCountByInstitute(Map map);
	
	/**
     * 知识产权分析,专利申报情况明细分析表
     */
	public List selectPatentDetailInfoByCond(Map map);
	
	/**
     * 处部门科技经费预算总表，各处、部门科技经费预算总表
     */
	public List selectJFYSZBForDepartment(Map map);
	
	/**
     * 科技经费预算总表，集团经费预算明细表
     */
	public List selectJFYSForGroup(Map map);
	
	/**
     * 科技经费预算总表，资产经费预算明细表
     */
	public List selectJFYSForAsset(Map map);
	
	/**
     * 科技经费预算总表，直属研究院科技经费预算表
     */
	public List selectJFYSForInstitute(Map map);
	
	/**
     * 科技经费预算总表，股份支付集团、外系统及盈科经费预算表
     */
	public List selectJFYSForOther(Map map);
	
	/**
     * 科技经费预算总表，分子公司科技经费预算表
     */
	public List selectJFYSForCompany(Map map);
	
	/**
     * 科技经费预算总表，分子公司科技经费预算表
     */
	public List selectJFYSForB2c(Map map);
	
	/**
     * 科技经费预算总表，股份公司科技专项经费预算表
     */
	public List selectJFYSForTech(Map map);
	
	/**
     * 知识产权分析，近三年国内外专利的情况
     */
	public List getPatentInfoByHomeAbroad(Map map);
	
	/**
     * 辅助决策中心，知识产权分析,各个研究院知识产权的情况，去年和今年
     */
	public List getPatentYearInfoByInstitute(Map map);
	
	/**
     * 辅助决策中心，成果，最近几年的鉴定结论
     */
	public List getAppraisalInfoByJDJG(Map map);
	
	/**
     * 辅助决策中心，成果，各个研究院成果情况
     */
	public List getAppraisalInfoByInstitute(Map map);
	
	
	
}