package com.pcitc.service.out;

import java.util.HashMap;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutProjectPlan;

public interface OutProjectPlanService {

	/**
     * 获取所有的项目计划数据
     */
    public List getProjectPlanList(HashMap<String, String> map);
    
    /**
     * 批量插入项目计划数据
     */
    public void insertOutProjectPlanBatch(List<OutProjectPlan> list);
    
    /**
     * 批量插入项目计划预算数据
     */
    public void insertOutProjectPlanForYS(List<OutProjectPlan> list);
    
    /**
     * 批量插入国家项目计划数据
     */
    public void insertCountryProjectPlanBatch(List<OutProjectPlan> list, String nd);
    
    
    /**
     * 直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组
     */
	public List getPlanCompleteRateByOldNew(HashMap<String, String> map);
	
	/**
     * 按照专业处分组，来统计各个专业处计划签订合同数量，实际签订合同数量
     */
	public List getPlanCountForZYC(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），总的签订率
     */
	public List getPlanTotalCompleteRate(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），各个院的合同预算情况
     */
	public List getPlanMoneyCompleteRateByInstitute(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），各个院的合同签订率
     */
	public List getPlanCompleteRateByInstitute(HashMap<String, String> map);
	
	/**
     * 首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组
     */
	public List getPlanCompleteRateByPlanType(HashMap<String, String> map);
	
	/**
     * 首页-直属研究院，项目计划完成的比率，+ hana支付的费用，按照资本性费用性来分组
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
     * 领导首页-预算投入 资本性预算分组,资本性不按照专业处权限控制
     */
	public List getOutTemMoneyTotalInfo(HashMap<String, String> map);
	
	/**
     * 领导首页-预算投入 资本性预算分组,资本性不按照专业处权限控制
     */
	public List getOutTemMoneyTotalInfoWithCondition(HashMap<String, String> map);
	
	/**
     * 领导首页-获取专项、机动的预算费用，专项和机动特殊，不按照专业处进行权限控制
     */
	public List getOutTemMoneyDecomposeInfo(HashMap<String, String> map);
	
	/**
     * 领导首页-科研合同，科研合同签订率清单
     */
	public List getPlanCompleteRateDetails(HashMap<String, String> map);
	
	/**
     * 项目计划数据，涉及项目预算、项目计划详情等相关的查询时调用
     */
	public LayuiTableData selectProjectPlanByCond(LayuiTableParam param);
	
	/**
     * 领导首页--科研投入--各个处室的新开结转情况
     */
	public List getPlanMoneyByDepartment(HashMap<String, String> map);
	
	/**
     * 领导首页-科研投入-各个处室的新开结转情况, 专业处没做预算的情况下, 以数据字典中的为准 
     */
	public List getPlanMoneyByDepartmentSpecial(HashMap<String, String> map);
	
	/**
     * 全生命周期查询，计划为起点
     */
	public LayuiTableData selectProjectCycleByCondition(LayuiTableParam param);
	
	/**
     * 项目的详情：合同信息
     */
	public LayuiTableData getScienceProcessDetails(LayuiTableParam param);
	
	/**
     * 合同付款详情
     */
	public LayuiTableData getContractPayDetails(LayuiTableParam param);
	
	/**
     * 合同成果详情
     */
	public LayuiTableData getContractAppraisalDetails(LayuiTableParam param);
	
	/**
     * 项目奖励信息
     */
	public LayuiTableData getProjectRewardDetails(LayuiTableParam param);
	
	/**
     * 直属研究院二级页面（领导），总的科研投入，数据来源于hana
     */
	public List getTotalInvestMoneyWithHana(HashMap<String, String> map);
	
	/**
	 * 修改out_project_info、out_project_plan里面的统计属性
	 */
	public void updateProjectPropertyInfo();
	
	/**
	 * 根据项目ID取项目信息
	 */
	public OutProjectPlan getOutProjectPlanByXmId(String xmid);
	
}
