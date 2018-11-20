package com.pcitc.service.out.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.mapper.out.OutDecisionMapper;
import com.pcitc.service.out.OutDecisionService;

@Service("outDecisionService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutDecisionServiceImpl implements OutDecisionService {

	@Autowired
	private OutDecisionMapper outDecisionMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutDecisionServiceImpl.class);
	
	/**
     * @param nd
     * @return
     * 经费预算建议--集团公司总部科技经费预算（建议稿）
     */
    public List getGroupCompanyStpMoneyForBudgetProposals(String nd) {
    	return outDecisionMapper.getGroupCompanyStpMoneyForBudgetProposals(nd);
    }
    
    /**
     * @param nd
     * @return
     * 预算分配,经费预算分析,股份公司总部科技经费预算（建议稿）
     */
	public List getStockCompanyMoneyTable(String nd) {
		return outDecisionMapper.getStockCompanyMoneyTable(nd);
	}
	
	
	/**
     * @param nd
     * @return
     * 预算分配,经费预算分析,各处、部门科技经费预算总表
     */
	public List getDepartmentBudgetMoneyTable(String nd) {
		return outDecisionMapper.getDepartmentBudgetMoneyTable(nd);
	}
	
	/**
     * @param nd
     * @return
     * 知识产权分析,国际、国内专利数量统计
     */
	public List getPatentCountByCountryType(Map map) {
		return outDecisionMapper.getPatentCountByCountryType(map);
	}
	
	
	
	
}
