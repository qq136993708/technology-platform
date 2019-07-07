package com.pcitc.mapper.out;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutProjectPlanExample;

public interface OutProjectPlanMapper {
    int countByExample(OutProjectPlanExample example);

    int deleteByExample(OutProjectPlanExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectPlan record);

    int insertSelective(OutProjectPlan record);

    List<OutProjectPlan> selectByExample(OutProjectPlanExample example);

    OutProjectPlan selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectPlan record, @Param("example") OutProjectPlanExample example);

    int updateByExample(@Param("record") OutProjectPlan record, @Param("example") OutProjectPlanExample example);

    int updateByPrimaryKeySelective(OutProjectPlan record);

    int updateByPrimaryKey(OutProjectPlan record);
    
    /**
     * 批量插入项目计划数据
     */
    public void insertOutProjectPlanBatch(List<OutProjectPlan> list);
    
    /**
     * 直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组
     */
	public List getPlanCompleteRateByOldNew(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），总的签订率
     */
	public List getPlanTotalCompleteRate(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），各个院的合同签订率
     */
	public List getPlanCompleteRateByInstitute(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），各个院的合同预算情况
     */
	public List getPlanMoneyCompleteRateByInstitute(HashMap<String, String> map);
	
	/**
     * 首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组
     */
	public List getPlanCompleteRateByPlanType(HashMap<String, String> map);
	
	/**
     * 首页-直属研究院，项目计划完成的比率，+ hana支付的费用，按照研究院来分组
     */
	public List getPlanCompleteRateByPlanTypeForHana(HashMap<String, String> map);
	
	/**
     * 首页-直属研究院，项目计划完成的比率，+ hana支付的费用，按照月份分组
     */
	public List getPlanCompleteRateByPlanTypeForHanaMonth(HashMap<String, String> map);
	
	
	/**
     * 领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组
     */
	public List getPlanCompleteRateByCompanyType(HashMap<String, String> map);
	
	/**
     * 领导首页-科研投入，按照直属研究所、分子公司等9个来分组
     */
	public List getPlanMoneyCompleteRateByCompanyType(HashMap<String, String> map);
	
	/**
     * 领导首页-科研合同，科研合同签订率清单
     */
	public List getPlanCompleteRateDetails(HashMap<String, String> map);
	
	/**
     * 项目计划数据，涉及项目预算、项目计划详情等相关的查询时调用
     */
	public List<OutProjectPlan> selectProjectPlanByCond(HashMap<String, Object> map);
	
	/**
     * 领导首页--科研投入--各个处室的新开结转情况
     */
	public List getPlanMoneyByDepartment(HashMap<String, String> map);
	
	/**
     * 全生命周期查询，计划为起点
     */
	public List selectProjectCycleByCondition(HashMap<String, Object> map);
	
	/**
     * 项目的详情：合同信息
     */
	public List getScienceProcessDetails(HashMap<String, Object> map);
	
	/**
     * 合同付款详情
     */
	public List getContractPayDetails(HashMap<String, Object> map);
	
	/**
     * 合同成果详情
     */
	public List getContractAppraisalDetails(HashMap<String, Object> map);
	
	/**
     * 项目成果详情
     */
	public List getProjectRewardDetails(HashMap<String, Object> map);
	
}