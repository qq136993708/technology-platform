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
     * @param nd
     * @return
     * 预算分配,经费预算分析,各处、部门科技经费预算总表
     */
	public List getDepartmentBudgetMoneyTable(String nd);
	
	/**
     * @return
     * 知识产权分析,国际、国内专利数量统计
     */
	public List getPatentCountByCountryType(Map map);
	
	/**
     * @return
     * 知识产权分析,各类型专利的数量，发明公布，发明授权，实用新型等
     */
	public List getPatentCountByPatentType(Map map);
	
	/**
     * @return
     * 知识产权分析,各类型专利的数量，8大研究院
     */
	public List getPatentCountByInstitute(Map map);
	
	/**
     * @return
     * 知识产权分析,专利申报情况明细分析表
     */
	public List selectPatentDetailInfoByCond(Map map);
	
	/**
     * @return
     * 处部门科技经费预算总表，各处、部门科技经费预算总表
     */
	public List selectJFYSZBForDepartment(Map map);
	
	
	
}