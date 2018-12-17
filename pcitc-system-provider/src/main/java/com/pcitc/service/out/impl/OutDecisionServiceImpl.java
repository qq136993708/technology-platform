package com.pcitc.service.out.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
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
	public List getGroupCompanyStpMoneyForBudgetProposals(HashMap<String, String> map) {
    	return outDecisionMapper.getGroupCompanyStpMoneyForBudgetProposals(map);
    }
    
    /**
     * @param nd
     * @return
     * 预算分配,经费预算分析,股份公司总部科技经费预算（建议稿）
     */
	public List getStockCompanyMoneyTable(HashMap<String, String> map) {
		return outDecisionMapper.getStockCompanyMoneyTable(map);
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
	
	/**
     * @return
     * 知识产权分析,各类型专利的数量，发明公布，发明授权，实用新型等
     */
	public List getPatentCountByPatentType(Map map) {
		return outDecisionMapper.getPatentCountByPatentType(map);
	}
	
	/**
     * @return
     * 知识产权分析,各类型专利的数量，8大研究院
     */
	public List getPatentCountByInstitute(Map map) {
		return outDecisionMapper.getPatentCountByInstitute(map);
	}
	
	/**
     * @return
     * 知识产权分析,专利申报情况明细分析表
     */
	public LayuiTableData selectPatentDetailInfoByCond(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		List list = outDecisionMapper.selectPatentDetailInfoByCond(null);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<Map> pageInfo = new PageInfo<Map>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	/**
     * @return
     * 处部门科技经费预算总表，各处、部门科技经费预算总表
     */
	public List selectJFYSZBForDepartment(Map map) {
		return outDecisionMapper.selectJFYSZBForDepartment(map);
	}
	
	/**
     * 科技经费预算总表，集团经费预算明细表
     */
	public List selectJFYSForGroup(Map map) {
		return outDecisionMapper.selectJFYSForGroup(map);
	}
	
	/**
     * 科技经费预算总表，资产经费预算明细表
     */
	public List selectJFYSForAsset(Map map) {
		return outDecisionMapper.selectJFYSForAsset(map);
	}
	
	/**
     * 科技经费预算总表，直属研究院科技经费预算表
     */
	public List selectJFYSForInstitute(Map map) {
		return outDecisionMapper.selectJFYSForInstitute(map);
	}
	
	/**
     * 股份支付集团、外系统及盈科经费预算表
     */
	public List selectJFYSForOther(Map map) {
		return outDecisionMapper.selectJFYSForOther(map);
	}
	
	/**
     * 科技经费预算总表，分子公司科技经费预算表
     */
	public List selectJFYSForCompany(Map map) {
		return outDecisionMapper.selectJFYSForCompany(map);
	}
	
	/**
     * 科技经费预算总表，分子公司科技经费预算表
     */
	public List selectJFYSForB2c(Map map) {
		return outDecisionMapper.selectJFYSForB2c(map);
	}
	
	/**
     * 科技经费预算总表，股份公司科技专项经费预算表
     */
	public List selectJFYSForTech(Map map) {
		return outDecisionMapper.selectJFYSForTech(map);
	}
	
	/**
     * 知识产权分析，近三年国内外专利的情况
     */
	public List getPatentInfoByHomeAbroad(Map map) {
		return outDecisionMapper.getPatentInfoByHomeAbroad(map);
	}
	
	/**
     * 辅助决策中心，知识产权分析,各个研究院知识产权的情况，去年和今年
     */
	public List getPatentYearInfoByInstitute(Map map) {
		return outDecisionMapper.getPatentYearInfoByInstitute(map);
	}
	
	/**
     * 辅助决策中心，成果，最近几年的鉴定结论
     */
	public List getAppraisalInfoByJDJG(Map map) {
		return outDecisionMapper.getAppraisalInfoByJDJG(map);
	}
	
	/**
     * 辅助决策中心，成果，各个研究院成果情况
     */
	public List getAppraisalInfoByInstitute(Map map) {
		return outDecisionMapper.getAppraisalInfoByInstitute(map);
	}
	
}
