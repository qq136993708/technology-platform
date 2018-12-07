package com.pcitc.service.out.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.mapper.out.OutProjectPlanMapper;
import com.pcitc.service.out.OutProjectPlanService;

@Service("outProjectPlanService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectPlanServiceImpl implements OutProjectPlanService {

	@Autowired
	private OutProjectPlanMapper outProjectPlanMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutProjectPlanServiceImpl.class);

	/**
     * 批量插入项目计划数据
     */
    public void insertOutProjectPlanBatch(List<OutProjectPlan> list) {
    	outProjectPlanMapper.insertOutProjectPlanBatch(list);
    }
    
    /**
     * 直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组
     */
	public List getPlanCompleteRateByOldNew(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByOldNew(map);
	}
	
	/**
     * 直属研究院二级页面（领导），总的签订率
     */
	public List getPlanTotalCompleteRate(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanTotalCompleteRate(map);
	}
    
	/**
     * 直属研究院二级页面（领导），各个院的合同签订率
     */
	public List getPlanCompleteRateByInstitute(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByInstitute(map);
	}
	
	/**
     * 首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组
     */
	public List getPlanCompleteRateByPlanType(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByPlanType(map);
	}
	
	/**
     * 领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组
     */
	public List getPlanCompleteRateByCompanyType(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByCompanyType(map);
	}
}
