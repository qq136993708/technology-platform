package com.pcitc.service.out.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.mapper.out.OutProjectErpMapper;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.service.out.OutDecisionService;

@Service("outDecisionService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutDecisionServiceImpl implements OutDecisionService {

	@Autowired
	private OutProjectInfoMapper outProjectInfoMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutDecisionServiceImpl.class);
    
    /**
     * @param nd
     * @return
     * 预算分配,经费预算分析,股份公司总部科技经费预算（建议稿）
     */
	public List getStockCompanyMoneyTable(String nd) {
		return outProjectInfoMapper.getStockCompanyMoneyTable(nd);
	}
}
